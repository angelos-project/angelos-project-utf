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

object LanguageLoader {

    fun resourceFolder(file: String = ""): Path = Paths.get("src/jvmMain/resources/", file).toAbsolutePath()

    fun generateFullIso639Enum(): String {
        if(!resourceFolder("is-639-3.tab").exists()) {
            FileDownloader.downloadUnicodeIso6393File(resourceFolder())
        }

        val duplicates = mutableMapOf<String, Int>()
        val allData = Iso639Parser().allData
        val sortedData = allData.sortedBy { it.id }
        val sb = StringBuilder()
        sb.appendLine("package org.angproj.utf.pla")
        sb.appendLine()
        sb.appendLine("public enum class FullIso639(public val lang: String, public val code: String) {")
        sortedData.forEachIndexed { idx, data ->
            duplicates[data.refName.constant] = (duplicates[data.refName.constant] ?: 0) + 1

            val constant = if(duplicates[data.refName.constant]!! > 1) {
                "${data.refName.constant}_${duplicates[data.refName.constant]}"
            } else {
                data.refName.constant
            }

            val lineEnding = if (idx != allData.lastIndex) "," else ";"
            sb.appendLine("    ${constant}(\"${data.refName.canonical}\", \"${data.id}\")$lineEnding")
        }
        sb.appendLine("    public companion object")
        sb.appendLine("}")
        return sb.toString()
    }
}