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

/**
 * Provides a filter for validating Unicode code points against a set of languages and their scripts.
 *
 * The `LangFilter` class aggregates all Unicode blocks used by the provided [UtfLanguage]s and
 * allows checking if a code point is valid for any of those languages. It also supports adding
 * the [BasicLatin] block, which is commonly required for whitespace and control characters.
 *
 * @property languages The list of [UtfLanguage]s included in this filter.
 * @constructor Internal. Use [buildFilter] to create an instance.
 */
/*public class LangFilter internal constructor(
    private val languages: List<UtfLanguage>
) {

    /**
     * The set of all [UtfBlock]s used by the included languages' scripts.
     */
    private val blocks: HashSet<UtfBlock>

    init {
        val blks = mutableSetOf<UtfBlock>()
        languages.forEach { lng ->
            lng.scripts.forEach { scr ->
                scr.blocks.forEach { blk ->
                    blks.add(blk)
                }
            }
        }
        this.blocks = blks.toHashSet()
    }

    public fun addLanguage(language: UtfLanguage) {
        language.scripts.forEach { addScript(it) }
    }

    public fun addScript(script: Script) {
        script.blocks.forEach { addBlock(it) }
    }

    public fun addBlock(block: UtfBlock) {
        blocks.add(block)
    }

    /**
     * Adds the [BasicLatin] block to the filter.
     *
     * This is necessary for supporting common invisible signs such as whitespace.
     */
    public fun withBasicLatin() { blocks.add(BasicLatin) }

    /**
     * Checks if the specified [Language] is included in this filter.
     *
     * @param lang The [Language] to check.
     * @return `true` if the language is loaded, `false` otherwise.
     */
    public fun isLanguageLoaded(lang: Language): Boolean = languages.contains(lang.lang)

    /**
     * Checks if the specified [UtfLanguage] is included in this filter.
     *
     * @param lang The [UtfLanguage] to check.
     * @return `true` if the language is loaded, `false` otherwise.
     */
    public fun isLanguageLoaded(lang: UtfLanguage): Boolean = languages.contains(lang)

    /**
     * Checks if the given [CodePoint] is valid for any of the filter's blocks.
     *
     * @param codePoint The [CodePoint] to validate.
     * @return `true` if the code point is valid, `false` otherwise.
     */
    public fun isValid(codePoint: CodePoint): Boolean = isValid(codePoint.value)

    /**
     * Checks if the given code point integer is valid for any of the filter's blocks.
     *
     * @param cp The code point as an [Int].
     * @return `true` if the code point is valid, `false` otherwise.
     */
    public fun isValid(cp: Int): Boolean = blocks.any { UtfBlock.isValid<Unit>(cp, it) }

    /**
     * Companion object providing factory methods and default filters.
     */
    public companion object : LanguageMap() {

        /**
         * Builds a [LangFilter] for the specified ISO language codes.
         *
         * @param isoCode One or more ISO 639-1 (2-letter) or ISO 639-3 (3-letter) language codes.
         * @return A [LangFilter] for the specified languages.
         * @throws IllegalArgumentException if an unknown code is provided.
         */
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
}*/
