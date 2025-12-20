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

import java.io.File
import java.io.InputStream
import java.io.PrintWriter

private object PLAParser : DataLoader<Pair<SearchName, String>>() {
    private fun resourceStream(resourcePath: String): InputStream = PLAParser::class.java.getResourceAsStream(resourcePath)
        ?: throw IllegalArgumentException("Resource not found: $resourcePath")

    private fun <E>lineIterator(stream: InputStream, action: (String) -> E): List<E> {
        val results = mutableListOf<E>()
        stream.bufferedReader().lineSequence().forEach { line ->
            val trimmed = line.trim()
            if (!(trimmed.startsWith("#") && trimmed.endsWith(")"))) return@forEach
            results.add(action(trimmed))
        }
        return results
    }

    override fun loadData(resourcePath: String): List<Pair<SearchName, String>> {
        val stream = resourceStream(resourcePath)
        return lineIterator(stream) { line ->
            val parts = line.split(" ")
            val pva = SearchName(parts[1].trim())
            val abbr = parts[2].replace("(", "").replace(")", "").trim()
            Pair(pva, abbr)
        }
    }

    override val allData: List<Pair<SearchName, String>> by lazy {
        loadData("/PropertyValueAliases.txt")
    }

    fun printPropertyValueAliasEnum(pw: PrintWriter) {
        pw.println("enum class PropertyValueAlias(val canonical: String, val alias: String) {")
        allData.forEachIndexed { idx, data ->
            if(idx != allData.lastIndex) {
                pw.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\"),")
            } else {
                pw.println("    ${data.first.constant}(\"${data.first.canonical}\", \"${data.second}\");")
            }
        }
        pw.println("}")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        File("generator/src/jvmMain/kotlin/org/angproj/utf/helper/PropertyValueAlias.kt").printWriter().use { out ->
            fileHeader(out, "helper")
            printPropertyValueAliasEnum(out)
        }
    }
}