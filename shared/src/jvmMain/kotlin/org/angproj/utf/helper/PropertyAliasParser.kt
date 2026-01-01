/**
 * Copyright (c) 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
package org.angproj.utf.helper

import java.io.InputStream

public class PropertyAliasParser(public val pva: PropertyValueAlias) : DataLoader<Pair<SearchName, String>>() {
    private fun resourceStream(resourcePath: String): InputStream = PropertyAliasParser::class.java.getResourceAsStream(resourcePath)
        ?: throw IllegalArgumentException("Resource not found: $resourcePath")

    private fun <E>lineIterator(stream: InputStream, action: (String) -> E): List<E> {
        val results = mutableListOf<E>()
        stream.bufferedReader().lineSequence().forEach { line ->
            val trimmed = line.trim()
            if (!trimmed.startsWith(pva.alias)) return@forEach
            results.add(action(trimmed))
        }
        return results
    }

    override fun loadData(resourcePath: String): List<Pair<SearchName, String>> {
        val stream = resourceStream(resourcePath)
        return lineIterator(stream) { line ->
            val parts = line.split(";")
            val pva = SearchName(parts[2].split("#")[0].trim())
            val abbr = parts[1].trim()
            Pair(pva, abbr)
        }
    }

    override val allData: List<Pair<SearchName, String>> by lazy {
        loadData("/PropertyValueAliases.txt")
    }

    public companion object {

        public fun parseBlock(): PropertyAliasParser {
            return PropertyAliasParser(PropertyValueAlias.BLOCK)
        }

        public fun parseScript(): PropertyAliasParser {
            return PropertyAliasParser(PropertyValueAlias.SCRIPT)
        }

        public fun parseGeneralCategory(): PropertyAliasParser {
            return PropertyAliasParser(PropertyValueAlias.GENERAL_CATEGORY)
        }
    }
}