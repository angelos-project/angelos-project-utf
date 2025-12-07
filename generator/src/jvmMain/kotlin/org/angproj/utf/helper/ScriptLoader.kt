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

import org.angproj.utf.model.Scripts
import org.angproj.utf.model.SearchName
import org.angproj.utf.pla.GeneralCategory
import org.angproj.utf.pla.byAbbr

object ScriptLoader {
    fun loadScript(name: String): List<Scripts> {
        val scripts = mutableListOf<Scripts>()
        val resourcePath = name
        val stream = ScriptLoader::class.java.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource not found: $resourcePath")
        stream.bufferedReader().useLines { lines ->
            lines.forEach { line ->
                // Skip comments and empty lines
                val trimmed = line.trim()
                if (trimmed.isEmpty() || trimmed.startsWith("#")) return@forEach
                // parse entries like:
                // START..END    ; NAME # TYPE  COMMENTS
                // 0025..0027    ; Common # Po   [3] PERCENT SIGN..APOSTROPHE
                // 0028          ; Common # Ps       LEFT PARENTHESIS
                val parts = trimmed.split(";")
                if (parts.size >= 2) {
                    val rangePart = parts[0].trim()
                    val namePart = parts[1].trim().split("#")[0].trim()
                    val typePart = GeneralCategory.byAbbr(
                        parts[1].trim().split("#").getOrNull(1)?.trim()?.split(" ")?.getOrNull(0)?.replace("&", "") ?: error("Invalid type part")
                    )
                    val rangeBounds = rangePart.split("..")
                    val start = rangeBounds[0].toInt(16)
                    val end = if (rangeBounds.size == 2) rangeBounds[1].toInt(16) else -1
                    scripts.add(Scripts(start, end, namePart, SearchName(namePart), typePart))
                }
            }
        }
        return scripts
    }

    val allScripts: List<Scripts> by lazy {
        loadScript("/Scripts.txt")
    }
}