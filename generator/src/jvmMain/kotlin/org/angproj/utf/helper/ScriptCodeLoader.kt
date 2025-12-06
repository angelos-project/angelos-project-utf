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

import org.angproj.utf.model.ScriptCode

object ScriptCodeLoader : DataLoader<ScriptCode>() {

    private val parser = object : UnicodeDataParser {
        fun parseLine(line: String): ScriptCode {
            val parts = line.split(';')
            return ScriptCode(
                code = parts[0],
                number = parts[1].toInt(),
                name = parts[2], // Skip french name parts[3]
                pva = parts[4],
                version = parts[5],
                date = parts[6]
            )
        }
    }

    override fun loadData(resourcePath: String): List<ScriptCode> {
        with(parser) {
            return lineIterator(resourceStream(resourcePath)) { line ->
                parseLine(line)
            }
        }
    }

    override val allData : List<ScriptCode> by lazy {
        loadData("/iso15924.txt")
    }

    val byCode: Map<String, ScriptCode> by lazy {
        allData.associateBy { it.code }
    }

    val byPva: Map<String, ScriptCode> by lazy {
        allData.associateBy { it.pva }
    }

    val byVersion: Map<String, List<ScriptCode>> by lazy {
        allData.groupBy { it.version }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        allData.forEach { println(it) }
    }
}