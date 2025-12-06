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

import org.angproj.utf.model.Block
import org.angproj.utf.model.SearchName
import java.io.File

object BlockLoader {
    fun loadBlocks(resourcePath: String): List<Block> {
        val blocks = mutableListOf<Block>()
        val stream = BlockLoader::class.java.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource not found: $resourcePath")
        stream.bufferedReader().useLines { lines ->
            lines.forEach { line ->
                val trimmed = line.trim()
                if (trimmed.isEmpty() || trimmed.startsWith("#")) return@forEach
                val parts = trimmed.split(";")
                if (parts.size == 2) {
                    val range = parts[0].trim().split("..")
                    val name = parts[1].trim()
                    if (range.size == 2) {
                        val start = range[0].toInt(16)
                        val end = range[1].toInt(16)
                        blocks.add(Block(start, end, name, SearchName(name), meta = "", range = start..end, noCtrl = false, noUse = emptySet()))
                    }
                }
            }
        }
        return blocks
    }

    val allBlocks: List<Block> by lazy {
        loadBlocks("/Blocks.txt")
    }
}
