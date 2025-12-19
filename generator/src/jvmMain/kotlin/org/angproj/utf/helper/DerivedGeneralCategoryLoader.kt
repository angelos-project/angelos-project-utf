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
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths


object DerivedGeneralCategoryLoader : DataLoader2<Triple<String, String, String>>() {

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
            if (it.second != "Cn") return@forEach
            val rangeBounds = it.first.split("..")
            val start = rangeBounds[0].toInt(16)
            val end = if (rangeBounds.size == 2) rangeBounds[1].toInt(16) else -1

            if (end - start >= 128 && end != -1) {
                unassigned.ranges += (start..end)
            } else if (end == -1) {
                unassigned.values += start
            } else {
                for (value in start..end) {
                    unassigned.values += value
                }
            }
        }

        val klazzFile = "library/src/commonMain/kotlin/org/angproj/utf/util/ExactValidator.kt"
        println(Files.createDirectories(Paths.get(klazzFile)))

        // Create or overwrite the ExactValidator.kt file
        //Files.createFile(Path(klazzFile)).toFile().printWriter().use { out ->
        PrintWriter(System.out).use { out ->
            fileHeader(out, "util")
            startValidator(out)
            unassigned.values.sorted().forEachIndexed { index, i ->
                out.print("0x${i.toString(16).uppercase().padStart(4, '0')}, ")
                if ((index + 1) % 8 == 0) out.println()
            }
            middleValidator(out)
            unassigned.ranges.sortedBy { it.first }.forEach {
                out.println(
                    "add(0x${
                        it.first.toString(16).uppercase().padStart(4, '0')
                    }..0x${it.last.toString(16).uppercase().padStart(4, '0')})"
                )
            }
            endValidator(out)
        }
    }
}

fun startValidator(out: java.io.PrintWriter) {
    out.println(
        """
 public class GlobalValidator : Validator() {

    private val values: Set<Int> = buildValuesSet()
    private val ranges: Set<IntRange> = buildRangesSet()

    override fun isValid(cp: Int): Boolean = isUtf8<Unit>(cp) && !isUnassigned<Unit>(cp)

    private inline fun <reified R: Any> isUnassigned(cp: Int): Boolean {
        for (range in ranges) {
            if (cp in range) return true
        }
        return values.contains(cp)
    }

    private companion object : AbstractUnicodeAware() {
        private fun buildValuesSet(): Set<Int> {
            return buildSet {
    """.trimIndent()
    )
}

fun middleValidator(out: java.io.PrintWriter) {
    out.println(
        """
                    }
        }

        private fun buildRangesSet(): Set<IntRange> {
            return buildSet {
    """.trimIndent()
    )
}

fun endValidator(out: java.io.PrintWriter) {
    out.println(
        """
            }
        }
    }
}
    """.trimIndent()
    )
}