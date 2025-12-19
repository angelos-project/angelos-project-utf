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

import org.angproj.utf.FileDownloader
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists

object ScriptCodeLoader {

    fun resourceFolder(file: String = ""): Path = Paths.get("src/jvmMain/resources/", file).toAbsolutePath()

    fun generateScriptEnum(): String {
        if(!resourceFolder("iso15924.txt").exists()) {
            FileDownloader.downloadUnicodeBlocksFile(resourceFolder())
        }

        val allData = ScriptCodeParser().allData
        val sortedData = allData.sortedBy { it.script }
        val sb = StringBuilder()
        sb.appendLine("package org.angproj.utf.pla")
        sb.appendLine()
        sb.appendLine("public enum class Script(public val title: String, public val canonical: String, public val abbr: String) {")
        sortedData.forEachIndexed { idx, data ->
            val lineEnding = if (idx != allData.lastIndex) "," else ";"
            sb.appendLine("    ${data.pva.uppercase()}(\"${data.name.canonical}\", \"${data.pva}\", \"${data.script}\")$lineEnding")
        }
        sb.appendLine("    public companion object")
        sb.appendLine("}")
        return sb.toString()
    }

    /*private val parser = object : UnicodeDataParser {
        fun parseLine(line: String): ScriptCode {
            val parts = line.split(';')
            val script = Script.byAbbr(parts[0])
            //if(script.canonical != parts[4]) { println("Unknown script code: ${parts} - ${script}") }
            return ScriptCode(
                script = script,
                number = parts[1].toInt(),
                name = parts[2], // Skip french name parts[3]
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
        allData.associateBy { it.script.abbr }
    }

    val byPva: Map<String, ScriptCode> by lazy {
        allData.associateBy { it.script.canonical }
    }

    val byVersion: Map<String, List<ScriptCode>> by lazy {
        allData.groupBy { it.version }
    }*/
}