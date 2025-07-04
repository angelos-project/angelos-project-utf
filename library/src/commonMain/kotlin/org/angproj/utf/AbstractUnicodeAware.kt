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

    protected inline fun <reified R : Any> isUnicode(cp: Int): Boolean = cp in UTF8_RANGE
    protected inline fun <reified R : Any> isSurrogate(cp: Int): Boolean = cp in SURROGATE_RANGE
    protected inline fun <reified R : Any> isUtf8(cp: Int): Boolean = isUnicode<Unit>(cp) && !isSurrogate<Unit>(cp)
    protected inline fun <reified R : Any> escapeNonUtf8(cp: Int): Int = when (isUtf8<Unit>(cp)) {
        true -> cp
        else -> REPLACEMENT_CHARACTER
    }

    protected inline fun <reified R : Any> unicodeOctetSize(value: Int): Int = when (value) {
        in RANGE_SIZE_1 -> 1
        in RANGE_SIZE_2 -> 2
        in RANGE_SIZE_3 -> 3
        in RANGE_SIZE_4 -> 4
        else -> throw UnicodeError("Codepoint ${value}, out of range")
    }

    protected inline fun <reified R : Any> isSurrogate(char: Char): Boolean = isSurrogate<Unit>(char.code)
    protected inline fun <reified R : Any> isHighSurrogate(char: Char): Boolean = char.code in SURROGATE_HIGH_RANGE
    protected inline fun <reified R : Any> isLowSurrogate(char: Char): Boolean = char.code in SURROGATE_LOW_RANGE
    protected inline fun <reified R : Any> isSurrogatePair(
        high: Char, low: Char
    ): Boolean = isHighSurrogate<Int>(high) && isLowSurrogate<Int>(low)

    protected inline fun <reified R : Any> surrogatesToCodePoint(
        high: Char, low: Char
    ): Int = (((high.code - MIN_HIGH_SURROGATE) shl 10) or (low.code - MIN_LOW_SURROGATE)) + 0x10000

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
        while (loop-- > 0 && value != REPLACEMENT_CHARACTER) value = followDataRead<Unit>(value, readOctet)
        return value
    }

    protected inline fun <reified R : Any> followDataRead(cp: Int, readOctet: () -> Byte): Int {
        val octet = readOctet().toInt()
        return when {
            isFollowingOctet<Unit>(octet) -> (cp shl 6) or (octet and 0B0011_1111)
            else -> return REPLACEMENT_CHARACTER
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
            else -> REPLACEMENT_CHARACTER
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
            else -> REPLACEMENT_CHARACTER
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
        cp: Int, filter: LangFilter
    ): Int = unicodeOctetSize<Unit>(glyphWithEscape<Unit>(cp, filter))

    protected inline fun <reified R : Any> innerGlyphSizeWithSecurity(
        cp: Int, filter: LangFilter
    ): Int = unicodeOctetSize<Unit>(glyphWithSecurity<Unit>(cp, filter))

    protected inline fun <reified R : Any> glyphWithPassThrough(
        cp: Int,
    ): Int = escapeNonUtf8<Unit>(cp)

    protected inline fun <reified R : Any> glyphWithEscape(
        cp: Int, filter: LangFilter,
    ): Int = when(!isSurrogate<Unit>(cp) && filter.isValid(cp)) {
        true -> cp
        else -> REPLACEMENT_CHARACTER
    }

    protected inline fun <reified R : Any> glyphWithSecurity(
        cp: Int, filter: LangFilter,
    ): Int = when(filter.isValid(cp)) {
        true -> cp
        else -> throw UnicodeError("Illegal codepoint ${cp}")
    }

    protected inline fun <reified R: Any> filterGlyphByPolicy(
        cp: Int,
        policy: Policy
    ): Int = when(policy.level) {
        FilterPolicy.PASSTHROUGH -> glyphWithPassThrough<R>(cp)
        FilterPolicy.ESCAPE -> glyphWithEscape<R>(cp, policy.filter)
        FilterPolicy.SECURITY -> glyphWithSecurity<R>(cp, policy.filter)
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
        else -> throw UnicodeError("Illegal numerical value $number")
    }

    /**
     * [0-9A-Fa-f] -> 0..15
     * Radix agnostic
     * */
    protected inline fun <reified R : Any> digitToNumber(cp: Int): Int = when(cp) {
        in 0x30..0x39 -> cp - 0x30          // [0-9]
        in 0x41..0x46 -> cp - 0x41 + 10     // [A-F]
        in 0x61..0x66 -> cp - 0x61 + 10     // [a-f]
        else -> throw UnicodeError("Illegal glyph digit $cp")
    }

    public companion object {
        public const val UTF8_START: Int = 0x0
        public const val UTF8_STOP: Int = 0x10_FFFF

        public const val RANGE_1_START: Int = UTF8_START
        public const val RANGE_2_START: Int = 0x80
        public const val RANGE_3_START: Int = 0x800
        public const val RANGE_4_START: Int = 0x1_0000

        public const val RANGE_1_STOP: Int = 0x7F
        public const val RANGE_2_STOP: Int = 0x7FF
        public const val RANGE_3_STOP: Int = 0xFFFF
        public const val RANGE_4_STOP: Int = UTF8_STOP

        public const val SURROGATE_START: Int = 0xD800
        public const val SURROGATE_STOP: Int = 0xDFFF

        public const val MIN_HIGH_SURROGATE: Int = SURROGATE_START
        public const val MAX_HIGH_SURROGATE: Int = 0xDBFF
        public const val MIN_LOW_SURROGATE: Int = 0xDC00
        public const val MAX_LOW_SURROGATE: Int = SURROGATE_STOP

        public const val REPLACEMENT_CHARACTER: Int = 0xFFFD
        public const val REPLACEMENT_CHARACTER_SIZE: Int = 3

        public val UTF8_RANGE: IntRange = UTF8_START..UTF8_STOP

        public val RANGE_SIZE_1: IntRange = RANGE_1_START..RANGE_1_STOP
        public val RANGE_SIZE_2: IntRange = RANGE_2_START..RANGE_2_STOP
        public val RANGE_SIZE_3: IntRange = RANGE_3_START..RANGE_3_STOP
        public val RANGE_SIZE_4: IntRange = RANGE_4_START..RANGE_4_STOP

        public val SURROGATE_RANGE: IntRange= SURROGATE_START..SURROGATE_STOP
        public val SURROGATE_LOW_RANGE: IntRange = MIN_LOW_SURROGATE..MAX_LOW_SURROGATE
        public val SURROGATE_HIGH_RANGE: IntRange= SURROGATE_START..SURROGATE_STOP
    }
}