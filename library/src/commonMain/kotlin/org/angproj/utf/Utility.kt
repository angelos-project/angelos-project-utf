/**
 * Copyright (c) 2024 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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

import org.angproj.utf.blk.BasicLatin

public class LangFilter internal constructor(private val languages: List<UtfLanguage>) {

    private val blocks: HashSet<UtfBlock>

    init {
        val blks = mutableSetOf<UtfBlock>()
        languages.forEach { lng -> lng.scripts.forEach { scr -> scr.blocks.forEach { blk -> blks.add(blk) } } }
        this.blocks = blks.toHashSet()
    }

    /**
     * BasicLatin is needed for several type of normal invisible signs such as whitespace.
     * */
    public fun withBasicLatin() { blocks.add(BasicLatin) }

    public fun isLanguageLoaded(lang: Language): Boolean = languages.contains(lang.lang)
    public fun isLanguageLoaded(lang: UtfLanguage): Boolean = languages.contains(lang)

    public fun isValid(codePoint: CodePoint): Boolean = isValid(codePoint.value)

    public fun isValid(cp: Int): Boolean = blocks.any { UtfBlock.isValid<Unit>(cp, it) }


    public companion object : LanguageMap() {
        public val basic: LangFilter by lazy { LangFilter(listOf()).apply { withBasicLatin() } }
        public val wide: LangFilter by lazy { LangFilter(listOf(Language.UNKNOWN.lang)).apply { withBasicLatin() } }

        public fun buildFilter(vararg isoCode: String): LangFilter {
            val languages = mutableListOf<UtfLanguage>()

            isoCode.forEach {
                val code = if (it.length == 2) {
                    if (!short2Long.containsKey(it)) error("Unknown short language code: $it")
                    short2Long[it]
                } else {
                    if (!long2Lang.containsKey(it)) error("Unknown long language code: $it")
                    else it
                }
                languages.add(long2Lang[code]!!.lang)
            }
            return LangFilter(languages.toList())
        }
    }
}
