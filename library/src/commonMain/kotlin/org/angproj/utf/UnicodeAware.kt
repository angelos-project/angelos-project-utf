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

    public fun debugCharacter(debug: Char, index: Int): Unit = when {
        isHighSurrogate<Unit>(debug) -> println("Index: $index, Char: '$debug', ${unicodePrint<Unit>(debug.code)} (High Surrogate)")
        isLowSurrogate<Unit>(debug) -> println("Index: $index, Char: '$debug', ${unicodePrint<Unit>(debug.code)} (Low Surrogate)")
        else -> println("Index: $index, Char: '$debug', ${unicodePrint<Unit>(debug.code)}")
    }

    public fun loopUtf16(
        str: String,
        action: (it: CodePoint) -> Unit
    ) {
        val strIter = str.iterator()
        while (strIter.hasNext()) {
            val current = strIter.nextChar()
            when {
                !isSurrogate<Unit>(current) -> action(current.toCodePoint())
                isHighSurrogate<Unit>(current) -> {
                    if (!strIter.hasNext()) throw UnicodeError("Illegal high surrogate at end of string ${unicodePrint<Unit>(current.code)}")
                    val next = strIter.nextChar()
                    if(!isLowSurrogate<Unit>(next)) throw UnicodeError("Illegal low surrogate ${unicodePrint<Unit>(next.code)}")
                    action(surrogatesToCodePoint<Unit>(current, next).toCodePoint())
                }
                else -> throw UnicodeError("Unintended parsing error at: ${unicodePrint<Unit>(current.code)}")
            }
        }
    }

    public fun sizeGlyphByPolicy(
        cp: CodePoint,
        policy: Policy
    ): Int = sizeGlyphByPolicy<Unit>(cp.value, policy)

    public fun filterGlyphByPolicy(
        cp: CodePoint,
        policy: Policy
    ): Int = filterGlyphByPolicy<Unit>(cp.value, policy)

    public fun readGlyphByPolicyStrm(
        policy: Policy,
        readOctet: () -> Byte
    ): CodePoint {
        val value = filterGlyphByPolicy<Unit>(octetReadStrm<Unit>(readOctet), policy)
        return CodePoint(value)
    }

    public fun readGlyphByPolicyBlk(
        remaining: Int,
        policy: Policy,
        readOctet: () -> Byte
    ): CodePoint {
        val value = req(remaining, 1) { filterGlyphByPolicy<Unit>(octetReadBlk<Unit>(remaining, readOctet), policy) }
        return CodePoint(value)
    }

    public fun writeGlyphByPolicyBlk(
        cp: CodePoint,
        remaining: Int,
        policy: Policy,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteBlk<Unit>(filterGlyphByPolicy<Unit>(cp.value, policy), remaining, writeOctet)

    public fun writeGlyphByPolicyStrm(
        cp: CodePoint,
        policy: Policy,
        writeOctet: (octet: Byte) -> Unit
    ): Int = octetWriteStrm<Unit>(filterGlyphByPolicy<Unit>(cp.value, policy), writeOctet)

    public companion object: AbstractUnicodeAware()
}


public object UnicodeAwareContext : UnicodeAware

public inline fun <reified T> withUnicode(block: UnicodeAwareContext.() -> T): T = UnicodeAwareContext.block()

public inline fun <reified T> withUnicode(
    array: ByteArray, block: UnicodeAwareContext.(array: ByteArray) -> T
): T = UnicodeAwareContext.block(array)

