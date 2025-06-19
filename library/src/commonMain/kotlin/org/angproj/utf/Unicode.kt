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

    public fun createFilter(vararg languages: Language): LangFilter = mutableListOf<UtfLanguage>().apply {
        languages.forEach { this.add(it.lang) }
    }.let { LangFilter(it) }

    public fun createFilter(vararg isoCodes: String): LangFilter = LangFilter.buildFilter(isoCode = isoCodes)

    public fun decode(
        data: String,
        filter: LangFilter = LangFilter.basic,
        policy: FilterPolicy = FilterPolicy.PASSTHROUGH
    ): ByteArray {
        var byteSize: Int = 0
        when(policy) {
            FilterPolicy.PASSTHROUGH -> loopUtf16(data) { cp -> byteSize += glyphSizeWithPassThrough(cp) }
            FilterPolicy.ESCAPE -> loopUtf16(data) { cp -> byteSize += glyphSizeWithEscape(cp, filter) }
            FilterPolicy.SECURITY -> loopUtf16(data) { cp -> byteSize += glyphSizeWithSecurity(cp, filter) }
        }

        val utfString = ByteArray(byteSize)
        var byteIdx = 0
        when(policy) {
            FilterPolicy.PASSTHROUGH -> loopUtf16(data) { cp ->
                writeGlyphWithPassThroughBlk(cp, byteSize - byteIdx) { utfString[byteIdx++] = it } }
            FilterPolicy.ESCAPE -> loopUtf16(data) { cp ->
                writeGlyphWithEscapeBlk(cp, byteSize - byteIdx, filter) { utfString[byteIdx++] = it } }
            FilterPolicy.SECURITY -> loopUtf16(data) { cp ->
                writeGlyphWithSecurityBlk(cp, byteSize - byteIdx, filter) { utfString[byteIdx++] = it } }
        }
        return utfString
    }
}
