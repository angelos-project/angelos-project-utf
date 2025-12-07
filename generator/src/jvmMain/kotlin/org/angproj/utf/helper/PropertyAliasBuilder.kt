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

class PropertyAliasBuilder(val pva: PropertyValueAlias) : DataLoader<Pair<SearchName, String>>() {
    private fun resourceStream(resourcePath: String): InputStream = ScriptLoader::class.java.getResourceAsStream(resourcePath)
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
            val pva = SearchName(parts[2].trim())
            val abbr = parts[1].trim()
            Pair(pva, abbr)
        }
    }

    override val allData: List<Pair<SearchName, String>> by lazy {
        loadData("/PropertyValueAliases.txt")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            generateScriptEnumFile()
        }

        fun generateBlockEnumFile() {
            File("library/src/commonMain/kotlin/org/angproj/utf/pla/Block.kt").printWriter().use { out ->
                val pva = PropertyAliasBuilder(PropertyValueAlias.BLOCK)
                fileHeader(out, "pla")
                out.println("public enum class " + SearchName(PropertyValueAlias.BLOCK.canonical).klazz + "(public val canonical: String, public val abbr: String) {")
                pva.allData.forEachIndexed { idx, data ->
                    if (idx != pva.allData.lastIndex) {
                        out.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\"),")
                    } else {
                        out.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\");")
                    }
                }
                out.println("}")
            }
        }

        fun generateScriptEnumFile() {
            File("library/src/commonMain/kotlin/org/angproj/utf/pla/Script.kt").printWriter().use { out ->
                val pva = PropertyAliasBuilder(PropertyValueAlias.SCRIPT)
                fileHeader(out, "pla")
                out.println("public enum class " + SearchName(PropertyValueAlias.SCRIPT.canonical).klazz + "(public val canonical: String, public val abbr: String) {")
                pva.allData.forEachIndexed { idx, data ->
                    if (idx != pva.allData.lastIndex) {
                        out.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\"),")
                    } else {
                        out.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\");")
                    }
                }
                out.println("}")
            }
        }
    }
}