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

        val allData = Iso639Parser().allData
        val sortedData = allData.sortedBy { it.refName.constant }
        val sb = StringBuilder()
        sb.appendLine("package org.angproj.utf.pla")
        sb.appendLine()
        sb.appendLine("public enum class FullIso639(public val lang: String, public val code: String) {")
        sortedData.forEachIndexed { idx, data ->
            val lineEnding = if (idx != allData.lastIndex) "," else ";"
            sb.appendLine("    ${data.refName.constant}(\"${data.refName.canonical}\", \"${data.id}\")$lineEnding")
        }
        sb.appendLine("    public companion object")
        sb.appendLine("}")
        return sb.toString()
    }
}