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


object DerivedGeneralCategoryLoader : DataLoader<Triple<String, String, String>>() {

    private val parser = object : UnicodeDataParser {
        fun parseLine(line: String): Triple<String, String, String> {
            return splitByThree(line) { parts ->
                return@splitByThree parts
            }
        }
    }

    override fun loadData(resourcePath: String): List<Triple<String, String, String>> {
        with(parser) {
            return lineIterator(resourceStream(resourcePath)) { line ->
                val parts = parseLine(line)
                return@lineIterator parts
            }
        }
    }

    override val allData: List<Triple<String, String, String>> by lazy {
        loadData("/DerivedGeneralCategory.txt")
    }

    data class UnassignedCategory(
        val values: MutableSet<Int> = mutableSetOf(),
        val ranges: MutableSet<IntRange> = mutableSetOf()
    )

    fun generateUnassignedCategories() {
        val unassigned = UnassignedCategory()
        allData.forEach {
            if(it.second != "Cn") return@forEach
            val rangeBounds = it.first.split("..")
            val start = rangeBounds[0].toInt(16)
            val end = if (rangeBounds.size == 2) rangeBounds[1].toInt(16) else -1

            if (end - start >= 128 && end != -1) {
                unassigned.ranges += (start..end)
            } else if ( end == -1) {
                unassigned.values += start
            } else {
                for (value in start..end) {
                    unassigned.values += value
                }
            }
        }

        println("Unassigned values:")
        unassigned.values.sorted().forEach { println("0x${it.toString(16).uppercase().padStart(4, '0')}") }
        println("Unassigned ranges:")
        unassigned.ranges.sortedBy { it.first }.forEach { println("0x${it.first.toString(16).uppercase().padStart(4, '0')}..0x${it.last.toString(16).uppercase().padStart(4, '0')}") }

        println(unassigned.values.size)
        println(unassigned.ranges.size)
    }
}