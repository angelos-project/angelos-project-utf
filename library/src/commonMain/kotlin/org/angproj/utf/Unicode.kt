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


public enum class Unicode(internal val cp: Int): Alphabet<Unicode> {
    UTF_FIRST(0x0),
    UTF_LAST(0x10_FFFF),
    UTF_REPLACEMENT(0xFFFD),

    RANGE_START(UTF_FIRST.cp),
    RANGE_START_2(0x80),
    RANGE_START_3(0x800),
    RANGE_START_4(0x1_0000),

    RANGE_STOP(0x7F),
    RANGE_STOP_2(0x7FF),
    RANGE_STOP_3(0xFFFF),
    RANGE_STOP_4(UTF_LAST.cp),

    SURROGATE_START(0xD800),
    SURROGATE_STOP(0xDFFF),

    SURROGATE_MIN_HIGH(SURROGATE_START.cp),
    SURROGATE_MAX_HIGH(0xDBFF),
    SURROGATE_MIN_LOW(0xDC00),
    SURROGATE_MAX_LOW(SURROGATE_STOP.cp);

    override fun toInt(): Int = cp

    override fun toCodePoint(): CodePoint = cp.toCodePoint()

    public companion object : UnicodeAware {
        public fun decode(data: String): ByteArray = decode(data, Policy.passthrough)

        public fun decode(data: String, policy: Policy): ByteArray {
            var byteSize = 0
            loopUtf16(data) { cp -> byteSize += sizeGlyphByPolicy(cp, policy) }
            val utfString = ByteArray(byteSize)
            var byteIdx = 0
            loopUtf16(data) { cp ->
                writeGlyphByPolicyBlk(cp, byteSize - byteIdx, policy) { utfString[byteIdx++] = it } }
            return utfString
        }

        public fun debugString(debug: String) {
            debug.forEachIndexed { index, ch ->
                debugCharacter(ch, index)
            }
        }
    }
}
