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
import org.angproj.utf.model.BlockRange
import org.angproj.utf.model.SearchName
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists

object BlockRangeLoader /*: DataLoader<BlockRange>()*/ {

    /*private val parser = object : UnicodeDataParser {
        fun parseLine(line: String): BlockRange {
            // 0000..007F; Basic Latin
            val parts = line.split(';')
            return BlockRange(rangeBounds(parts.get(0)), SearchName(parts.get(1).trim()))
        }
    }

    override fun loadData(resourcePath: String): List<BlockRange> {
        with(parser) {
            return lineIterator(resourceStream(resourcePath)) { line ->
                parseLine(line)
            }
        }
    }

    override val allData: List<BlockRange> by lazy {
        loadData("/Blocks.txt")
    }*/

    fun resourceFolder(file: String = ""): Path = Paths.get("src/jvmMain/resources/", file).toAbsolutePath()

    fun generateBlockRangeEnum(): String {
        if(!resourceFolder("Blocks.txt").exists()) {
            FileDownloader.downloadUnicodeBlocksFile(resourceFolder())
        }

        val allData = BlockRangeParser().allData
        val sortedData = allData.sortedBy { it.searchName.canonical }
        val sb = StringBuilder()
        sb.appendLine("package org.angproj.utf.model")
        sb.appendLine()
        sb.appendLine("enum class BlockRange(val unicodeBounds: Pair<Int, Int>) {")
        sortedData.forEachIndexed { idx, data ->
            val lineEnding = if (idx != allData.lastIndex) "," else ";"
            sb.appendLine("    ${data.searchName.constant}(\"${data.searchName.canonical}\", \"${data.searchName.klazz}\", \"${data.searchName.klazz}\", 0x${data.unicodeBounds.first.toString(16).uppercase()}..0x${data.unicodeBounds.second.toString(16).uppercase()})$lineEnding")
        }
        sb.appendLine("}")
        return sb.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        //allData.forEach { println(it) }
    }
}
