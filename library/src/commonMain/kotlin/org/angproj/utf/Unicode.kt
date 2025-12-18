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


public object Unicode: UnicodeAware {

    public fun decode(data: String): ByteArray = decode(data, Policy.passthrough)

    public fun decode(data: String, policy: Policy): ByteArray {
        var byteSize = 0
        when(policy.filter) {
            Filter.PASSTHROUGH -> loopUtf16(data) { cp -> byteSize += glyphSizeWithPassThrough(cp) }
            Filter.ESCAPE -> loopUtf16(data) { cp -> byteSize += glyphSizeWithEscape(cp, policy.validator) }
            Filter.SECURITY -> loopUtf16(data) { cp -> byteSize += glyphSizeWithSecurity(cp, policy.validator) }
        }

        val utfString = ByteArray(byteSize)
        var byteIdx = 0
        when(policy.filter) {
            Filter.PASSTHROUGH -> loopUtf16(data) { cp ->
                writeGlyphWithPassThroughBlk(cp, byteSize - byteIdx) { utfString[byteIdx++] = it } }
            Filter.ESCAPE -> loopUtf16(data) { cp ->
                writeGlyphWithEscapeBlk(cp, byteSize - byteIdx, policy.validator) { utfString[byteIdx++] = it } }
            Filter.SECURITY -> loopUtf16(data) { cp ->
                writeGlyphWithSecurityBlk(cp, byteSize - byteIdx, policy.validator) { utfString[byteIdx++] = it } }
        }
        return utfString
    }

    public fun debugString(debug: String) {
        debug.forEachIndexed { index, ch ->
            debugCharacter(ch, index)
        }
    }
}
