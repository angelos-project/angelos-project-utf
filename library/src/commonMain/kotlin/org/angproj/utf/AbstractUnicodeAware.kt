/**
 * Copyright (c) 2024-2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
 *
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 *
 *      https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *      Kristoffer Paulsson - initial implementation
 */
package org.angproj.utf

/**
 *
 * */
public abstract class AbstractUnicodeAware {

    protected inline fun <reified R: Any> unicodePrint(cp: Int): String = "0x${cp.toString(16).uppercase()} ($cp)"

    protected inline fun <reified R : Any> isUnicode(cp: Int): Boolean = cp in UTF8_RANGE
    protected inline fun <reified R : Any> isSurrogate(cp: Int): Boolean = cp in SURROGATE_RANGE
    protected inline fun <reified R : Any> isUtf8(cp: Int): Boolean = isUnicode<Unit>(cp) && !isSurrogate<Unit>(cp)
    protected inline fun <reified R : Any> escapeNonUtf8(cp: Int): Int = when (isUtf8<Unit>(cp)) {
        true -> cp
        else -> Unicode.UTF_REPLACEMENT.toInt()
    }

    protected inline fun <reified R : Any> unicodeOctetSize(value: Int): Int = when (value) {
        in RANGE_SIZE_1 -> 1
        in RANGE_SIZE_2 -> 2
        in RANGE_SIZE_3 -> 3
        in RANGE_SIZE_4 -> 4
        else -> throw UnicodeError("Codepoint ${unicodePrint<Unit>(value)}, out of range")
    }

    protected inline fun <reified R : Any> isSurrogate(char: Char): Boolean = isSurrogate<Unit>(char.code)
    protected inline fun <reified R : Any> isHighSurrogate(char: Char): Boolean = char.code in SURROGATE_HIGH_RANGE
    protected inline fun <reified R : Any> isLowSurrogate(char: Char): Boolean = char.code in SURROGATE_LOW_RANGE
    protected inline fun <reified R : Any> isSurrogatePair(
        high: Char, low: Char
    ): Boolean = isHighSurrogate<Int>(high) && isLowSurrogate<Int>(low)

    protected inline fun <reified R : Any> surrogatesToCodePoint(
        high: Char, low: Char
    ): Int = (((high.code - Unicode.SURROGATE_MIN_HIGH.toInt()) shl 10) or (low.code - Unicode.SURROGATE_MIN_LOW.toInt())) + 0x10000

    protected inline fun <reified R : Any> hasSurrogatePairAt(
        seq: CharSequence, index: Int
    ): Boolean = index in 0..seq.length - 2 && isSurrogatePair<Int>(seq[index], seq[index + 1])

    protected inline fun <reified R : Any> req(remaining: Int, count: Int, block: () -> R): R {
        check(remaining >= count) { "Buffer overflow, limit reached." } // Should be check (IllegalStateException)
        return block()
    }

    protected inline fun <reified R : Any> followDataLoop(loops: Int, cp: Int, readOctet: () -> Byte): Int {
        var value = cp
        var loop = loops
        val replacement = Unicode.UTF_REPLACEMENT.toInt()
        while (loop-- > 0 && value != replacement) value = followDataRead<Unit>(value, readOctet)
        return value
    }

    protected inline fun <reified R : Any> followDataRead(cp: Int, readOctet: () -> Byte): Int {
        val octet = readOctet().toInt()
        return when {
            isFollowingOctet<Unit>(octet) -> (cp shl 6) or (octet and 0B0011_1111)
            else -> Unicode.UTF_REPLACEMENT.toInt()
        }
    }

    protected inline fun <reified R : Any> isSingleOctet(octet: Int): Boolean = octet and 0B1000_0000 == 0B0000_0000
    protected inline fun <reified R : Any> isFirstOctetOfTwo(octet: Int): Boolean = octet and 0B1110_0000 == 0B1100_0000
    protected inline fun <reified R : Any> isFirstOctetOfThree(octet: Int): Boolean = octet and 0B1111_0000 == 0B1110_0000
    protected inline fun <reified R : Any> isFirstOctetOfFour(octet: Int): Boolean = octet and 0B1111_1000 == 0B1111_0000
    protected inline fun <reified R : Any> isFirstOctetOfFive(octet: Int): Boolean = octet and 0B1111_1100 == 0B1111_1000
    protected inline fun <reified R : Any> isFirstOctetOfSix(octet: Int): Boolean = octet and 0B1111_1110 == 0B1111_1100
    protected inline fun <reified R : Any> isFollowingOctet(octet: Int): Boolean = octet and 0B1100_0000 == 0B1000_0000

    protected inline fun <reified R : Any> valueOfSingle(octet: Int): Int = octet and 0B0111_1111
    protected inline fun <reified R : Any> valueOfFirstOfTwo(octet: Int): Int = octet and 0B0001_1111
    protected inline fun <reified R : Any> valueOfFirstOfThree(octet: Int): Int = octet and 0B0000_1111
    protected inline fun <reified R : Any> valueOfFirstOfFour(octet: Int): Int = octet and 0B0000_0111
    protected inline fun <reified R : Any> valueOfFirstOfFive(octet: Int): Int = octet and 0B0000_0011
    protected inline fun <reified R : Any> valueOfFirstOfSix(octet: Int): Int = octet and 0B0000_0001
    protected inline fun <reified R : Any> valueOfFollowingOctet(octet: Int): Boolean = octet and 0B1100_0000 == 0B1000_0000

    protected inline fun <reified R : Any> octetReadStrm(readOctet: () -> Byte): Int {
        val octet = readOctet().toInt()
        return when {
            isSingleOctet<Unit>(octet) -> valueOfSingle<Unit>(octet)
            isFirstOctetOfTwo<Unit>(octet) -> followDataRead<Unit>(valueOfFirstOfTwo<Unit>(octet), readOctet)
            isFirstOctetOfThree<Unit>(octet) -> followDataLoop<Unit>(2, valueOfFirstOfThree<Unit>(octet), readOctet)
            isFirstOctetOfFour<Unit>(octet) -> followDataLoop<Unit>(3, valueOfFirstOfFour<Unit>(octet), readOctet)
            isFirstOctetOfFive<Unit>(octet) -> followDataLoop<Unit>(4, valueOfFirstOfFive<Unit>(octet), readOctet)
            isFirstOctetOfSix<Unit>(octet) -> followDataLoop<Unit>(5, valueOfFirstOfSix<Unit>(octet), readOctet)
            else -> Unicode.UTF_REPLACEMENT.toInt()
        }
    }

    protected inline fun <reified R : Any> octetReadBlk(remaining: Int, readOctet: () -> Byte): Int {
        val octet = readOctet().toInt()
        return when {
            isSingleOctet<Unit>(octet) -> valueOfSingle<Unit>(octet)
            isFirstOctetOfTwo<Unit>(octet) -> req(remaining, 2) {
                followDataRead<Unit>(valueOfFirstOfTwo<Unit>(octet), readOctet) }
            isFirstOctetOfThree<Unit>(octet) -> req(remaining, 3) {
                followDataLoop<Unit>(2, valueOfFirstOfThree<Unit>(octet), readOctet) }
            isFirstOctetOfFour<Unit>(octet)-> req(remaining, 4) {
                followDataLoop<Unit>(3, valueOfFirstOfFour<Unit>(octet), readOctet) }
            isFirstOctetOfFive<Unit>(octet) -> req(remaining, 5) {
                followDataLoop<Unit>(4, valueOfFirstOfFive<Unit>(octet), readOctet) }
            isFirstOctetOfSix<Unit>(octet) -> req(remaining, 6) {
                followDataLoop<Unit>(5, valueOfFirstOfSix<Unit>(octet), readOctet) }
            else -> Unicode.UTF_REPLACEMENT.toInt()
        }
    }

    protected inline fun <reified R : Any> extractOctet0(cp: Int): Byte = (
            (0B0000000_00000000_00000000_00111111 and cp) or -0B10000000).toByte()
    protected inline fun <reified R : Any> extractOctet1(cp: Int): Byte = (
            (0B0000000_00000000_00001111_11000000 and cp shr 6) or -0B10000000).toByte()
    protected inline fun <reified R : Any> extractOctet2(cp: Int): Byte = (
            (0B0000000_00000011_11110000_00000000 and cp shr 12) or -0B10000000).toByte()

    protected inline fun <reified R : Any> octetWrite1(cp: Int, writeOctet: (octet: Byte) -> Unit): Int {
        writeOctet((0B0000000_00000000_00000000_01111111 and cp).toByte())
        return 1
    }

    protected inline fun <reified R : Any> octetWrite2(cp: Int, writeOctet: (octet: Byte) -> Unit): Int {
        writeOctet(((0B0000000_00000000_00000111_11000000 and cp shr 6) or -0B01000000).toByte())
        writeOctet(extractOctet0<Unit>(cp))
        return 2
    }

    protected inline fun <reified R : Any> octetWrite3(cp: Int, writeOctet: (octet: Byte) -> Unit): Int {
        writeOctet(((0B0000000_00000000_11110000_00000000 and cp shr 12) or -0B00100000).toByte())
        writeOctet(extractOctet1<Unit>(cp))
        writeOctet(extractOctet0<Unit>(cp))
        return 3
    }

    protected inline fun <reified R : Any> octetWrite4(cp: Int, writeOctet: (octet: Byte) -> Unit): Int {
        writeOctet(((0B0000000_00011100_00000000_00000000 and cp shr 18) or -0B00010000).toByte())
        writeOctet(extractOctet2<Unit>(cp))
        writeOctet(extractOctet1<Unit>(cp))
        writeOctet(extractOctet0<Unit>(cp))
        return 4
    }

    protected inline fun <reified R : Any> octetWriteStrm(cp: Int, writeOctet: (octet: Byte) -> Unit): Int {
        return when (val value = escapeNonUtf8<Unit>(cp)) {
            in RANGE_SIZE_1 -> octetWrite1<Unit>(value, writeOctet)
            in RANGE_SIZE_2 -> octetWrite2<Unit>(value, writeOctet)
            in RANGE_SIZE_3 -> octetWrite3<Unit>(value, writeOctet)
            in RANGE_SIZE_4 -> octetWrite4<Unit>(value, writeOctet)
            else -> 0
        }
    }

    protected inline fun <reified R : Any> octetWriteBlk(
        cp: Int,
        remaining: Int,
        writeOctet: (octet: Byte) -> Unit
    ): Int {
        return when (val value = escapeNonUtf8<Int>(cp)) {
            in RANGE_SIZE_1 -> req(remaining, 1) { octetWrite1<Unit>(value, writeOctet) }
            in RANGE_SIZE_2 -> req(remaining, 2) { octetWrite2<Unit>(value, writeOctet) }
            in RANGE_SIZE_3 -> req(remaining, 3) { octetWrite3<Unit>(value, writeOctet) }
            in RANGE_SIZE_4 -> req(remaining, 4) { octetWrite4<Unit>(value, writeOctet) }
            else -> 0
        }
    }

    protected inline fun <reified R : Any> innerGlyphSizeWithPassThrough(
        cp: Int
    ): Int = unicodeOctetSize<Unit>(glyphWithPassThrough<Unit>(cp))

    protected inline fun <reified R : Any> innerGlyphSizeWithEscape(
        cp: Int, validator: Validator
    ): Int = unicodeOctetSize<Unit>(glyphWithEscape<Unit>(cp, validator))

    protected inline fun <reified R : Any> innerGlyphSizeWithSecurity(
        cp: Int, validator: Validator
    ): Int = unicodeOctetSize<Unit>(glyphWithSecurity<Unit>(cp, validator))

    protected inline fun <reified R : Any> glyphWithPassThrough(
        cp: Int,
    ): Int = escapeNonUtf8<Unit>(cp)

    protected inline fun <reified R : Any> glyphWithEscape(
        cp: Int, validator: Validator,
    ): Int = when(!isSurrogate<Unit>(cp) && validator.isValid(cp)) {
        true -> cp
        else -> Unicode.UTF_REPLACEMENT.toInt()
    }

    protected inline fun <reified R : Any> glyphWithSecurity(
        cp: Int, validator: Validator,
    ): Int = when(validator.isValid(cp)) {
        true -> cp
        else -> throw UnicodeError("Illegal codepoint ${unicodePrint<Unit>(cp)}")
    }

    protected inline fun <reified R: Any> filterGlyphByPolicy(
        cp: Int,
        policy: Policy
    ): Int = when(policy.filter) {
        Filter.PASSTHROUGH -> glyphWithPassThrough<R>(cp)
        Filter.ESCAPE -> glyphWithEscape<R>(cp, policy.validator)
        Filter.SECURITY -> glyphWithSecurity<R>(cp, policy.validator)
    }

    protected inline fun <reified R : Any> isGlyphAsciiCtrl(cp: Int): Boolean = cp in 0x00..0x1F || cp == 0x7F
    protected inline fun <reified R : Any> isGlyphAsciiPrintable(cp: Int): Boolean = cp in 0x20..0x7e

    /**
     * 0..15 -> [0-9a-f]
     * Radix agnostic
     * */
    protected inline fun <reified R : Any> numberToDigit(number: Int): Int = when(number) {
        in 0..<10 -> 0x30 + number
        in 10..<16 -> 0x61 - 10 + number
        else -> throw UnicodeError("Illegal numerical value ${number}")
    }

    /**
     * [0-9A-Fa-f] -> 0..15
     * Radix agnostic
     * */
    protected inline fun <reified R : Any> digitToNumber(cp: Int): Int = when(cp) {
        in 0x30..0x39 -> cp - 0x30          // [0-9]
        in 0x41..0x46 -> cp - 0x41 + 10     // [A-F]
        in 0x61..0x66 -> cp - 0x61 + 10     // [a-f]
        else -> throw UnicodeError("Illegal glyph digit ${unicodePrint<Unit>(cp)}")
    }

    public companion object {
        public const val REPLACEMENT_CHARACTER_SIZE: Int = 3

        public val UTF8_RANGE: IntRange = Unicode.UTF_FIRST.toInt()..Unicode.UTF_LAST.toInt()

        public val RANGE_SIZE_1: IntRange = Unicode.RANGE_START.toInt()..Unicode.RANGE_STOP.toInt()
        public val RANGE_SIZE_2: IntRange = Unicode.RANGE_START_2.toInt()..Unicode.RANGE_STOP_2.toInt()
        public val RANGE_SIZE_3: IntRange = Unicode.RANGE_START_3.toInt()..Unicode.RANGE_STOP_3.toInt()
        public val RANGE_SIZE_4: IntRange = Unicode.RANGE_START_4.toInt()..Unicode.RANGE_STOP_4.toInt()

        public val SURROGATE_RANGE: IntRange = Unicode.SURROGATE_START.toInt()..Unicode.SURROGATE_STOP.toInt()
        public val SURROGATE_LOW_RANGE: IntRange = Unicode.SURROGATE_MIN_LOW.toInt()..Unicode.SURROGATE_MAX_LOW.toInt()
        public val SURROGATE_HIGH_RANGE: IntRange= Unicode.SURROGATE_MIN_HIGH.toInt()..Unicode.SURROGATE_MAX_HIGH.toInt()
    }
}