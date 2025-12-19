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


public class BlockRangeParser : DataLoader<BlockRange>() {

    private val parser = object : UnicodeDataParser {
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
    }
}
