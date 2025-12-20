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

import org.angproj.utf.fileHeader
import org.angproj.utf.model.SearchName
import java.io.File
import java.io.InputStream

class PropertyValueAliasLoader(val pva: PropertyValueAlias) : DataLoader<Pair<SearchName, String>>() {

    private val parser = object : UnicodeDataParser {
        override fun <E>lineIterator(stream: InputStream, action: (String) -> E): List<E> {
            val results = mutableListOf<E>()
            stream.bufferedReader().lineSequence().forEach { line ->
                val trimmed = line.trim()
                if (!trimmed.startsWith(pva.alias)) return@forEach
                results.add(action(trimmed))
            }
            return results
        }

        fun parseLine(line: String): Pair<SearchName, String> {
            val parts = line.split(";")
            val pva = SearchName(parts[2].split("#")[0].trim())
            val abbr = parts[1].trim()
            return Pair(pva, abbr)
        }
    }

    override fun loadData(resourcePath: String): List<Pair<SearchName, String>> {
        with(parser) {
            return lineIterator(resourceStream(resourcePath)) { line ->
                val parts = parseLine(line)
                return@lineIterator parts
            }
        }
    }

    fun generateEnumFile() {
        val klazzName = SearchName(pva.canonical).klazz
        File("library/src/commonMain/kotlin/org/angproj/utf/pla/$klazzName.kt").printWriter().use { out ->
            fileHeader(out, "pla")
            out.println("public enum class $klazzName(public val canonical: String, public val abbr: String) {")
            allData.forEachIndexed { idx, data ->
                if (idx != allData.lastIndex) {
                    out.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\"),")
                } else {
                    out.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\");")
                }
            }
            out.println("\n    public companion object")
            out.println("}")
        }
    }


    override val allData: List<Pair<SearchName, String>> by lazy {
        loadData("/PropertyValueAliases.txt")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            generateGeneralCategoryEnumFile()
        }

        fun generateBlockEnumFile() {
            PropertyValueAliasLoader(PropertyValueAlias.BLOCK).generateEnumFile()
        }

        fun generateScriptEnumFile() {
            PropertyValueAliasLoader(PropertyValueAlias.SCRIPT).generateEnumFile()
        }

        fun generateGeneralCategoryEnumFile() {
            PropertyValueAliasLoader(PropertyValueAlias.GENERAL_CATEGORY).generateEnumFile()
        }
    }
}