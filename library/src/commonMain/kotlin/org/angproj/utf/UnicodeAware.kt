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
 * https://www.ietf.org/rfc/rfc2279.txt
 * https://www.ietf.org/rfc/rfc3629.txt
 * https://en.wikipedia.org/wiki/UTF-8
 * */
public interface UnicodeAware {

    public fun readGlyphStrm(readOctet: () -> Byte): CodePoint {
        val value = octetReadStrm<Unit>(readOctet)
        return CodePoint(value)
    }

    public fun readGlyphBlk(remaining: Int, readOctet: () -> Byte): CodePoint {
        val value = req(remaining, 1) { octetReadBlk<Unit>(remaining, readOctet) }
        return CodePoint(value)
    }

    public fun writeGlyphStrm(
        codePoint: CodePoint, writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteStrm<Unit>(codePoint.value, writeOctet)


    public fun writeGlyphBlk(
        codePoint: CodePoint, remaining: Int, writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteBlk<Unit>(codePoint.value, remaining, writeOctet)

    public fun isGlyphStart(octet: Byte): Boolean {
        val value = octet.toInt()
        return when {
            isSingleOctet<Unit>(value) ||
            isFirstOctetOfTwo<Unit>(value) ||
            isFirstOctetOfThree<Unit>(value) ||
            isFirstOctetOfFour<Unit>(value) ||
            isFirstOctetOfFive<Unit>(value) ||
            isFirstOctetOfSix<Unit>(value) -> true
            else -> false
        }
    }

    public fun hasGlyphSize(octet: Byte): Int {
        val value = octet.toInt()
        return when {
            isSingleOctet<Unit>(value) -> 1
            isFirstOctetOfTwo<Unit>(value) -> 2
            isFirstOctetOfThree<Unit>(value) -> 3
            isFirstOctetOfFour<Unit>(value) -> 4
            isFirstOctetOfFive<Unit>(value) -> 5
            isFirstOctetOfSix<Unit>(value) -> 6
            else -> 0
        }
    }

    public fun isValid(value: Int): Boolean = isUtf8<Unit>(value)

    public fun octetSize(value: Int): Int = when (value) {
        in AbstractUnicodeAware.SURROGATE_RANGE -> -1
        in AbstractUnicodeAware.RANGE_SIZE_1 -> 1
        in AbstractUnicodeAware.RANGE_SIZE_2 -> 2
        in AbstractUnicodeAware.RANGE_SIZE_3 -> 3
        in AbstractUnicodeAware.RANGE_SIZE_4 -> 4
        else -> -1
    }

    public fun loopUtf16(
        str: String,
        action: (it: CodePoint) -> Unit
    ) {
        str.forEachIndexed { index, c ->
            when {
                !isSurrogate<Unit>(c) -> action(c.toCodePoint())
                hasSurrogatePairAt<Unit>(str, index) -> action(
                    surrogatesToCodePoint<Unit>(c, str[index + 1]).toCodePoint())
                else -> throw UnicodeError("Illegal codepoint ${c.code}")
            }
        }
    }

    public fun glyphSizeWithPassThrough(cp: CodePoint): Int = innerGlyphSizeWithPassThrough<Unit>(cp)

    public fun glyphSizeWithEscape(cp: CodePoint, filter: LangFilter): Int = innerGlyphSizeWithEscape<Unit>(cp, filter)

    public fun glyphSizeWithSecurity(cp: CodePoint, filter: LangFilter): Int = innerGlyphSizeWithSecurity<Unit>(cp, filter)

    public fun writeGlyphWithPassThroughBlk(
        cp: CodePoint,
        remaining: Int,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteBlk<Unit>(glyphWithPassThrough<Unit>(cp), remaining, writeOctet)

    public fun writeGlyphWithEscapeBlk(
        cp: CodePoint,
        remaining: Int,
        filter: LangFilter,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteBlk<Unit>(glyphWithEscape<Unit>(cp, filter), remaining, writeOctet)

    public fun writeGlyphWithSecurityBlk(
        cp: CodePoint,
        remaining: Int,
        filter: LangFilter,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteBlk<Unit>(glyphWithSecurity<Unit>(cp, filter), remaining, writeOctet)

    public fun writeGlyphWithPassThroughStrm(
        cp: CodePoint,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteStrm<Unit>(glyphWithPassThrough<Unit>(cp), writeOctet)

    public fun writeGlyphWithEscapeStrm(
        cp: CodePoint,
        filter: LangFilter,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteStrm<Unit>(glyphWithEscape<Unit>(cp, filter), writeOctet)

    public fun writeGlyphWithSecurityStrm(
        cp: CodePoint,
        filter: LangFilter,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteStrm<Unit>(glyphWithSecurity<Unit>(cp, filter), writeOctet)

    public companion object: AbstractUnicodeAware()
}


public object UnicodeAwareContext : UnicodeAware

public inline fun <reified T> withUnicode(block: UnicodeAwareContext.() -> T): T = UnicodeAwareContext.block()

public inline fun <reified T> withUnicode(
    array: ByteArray, block: UnicodeAwareContext.(array: ByteArray) -> T
): T = UnicodeAwareContext.block(array)

