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

import java.io.InputStream

interface UnicodeDataParser {
    fun resourceStream(resourcePath: String): InputStream = ScriptLoader::class.java.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource not found: $resourcePath")

    fun <E>lineIterator(stream: InputStream, action: (String) -> E): List<E> {
        val results = mutableListOf<E>()
        stream.bufferedReader().lineSequence().forEach { line ->
            val trimmed = line.trim()
            if (trimmed.isEmpty() || trimmed.startsWith("#")) return@forEach
            results.add(action(trimmed))
        }
        return results
    }

    fun <E>splitByThree(line: String, action: (Triple<String, String, String>) -> E): E {
        val parts =  line.split(";")
        val otherParts = parts.get(1).split("#")
        val triple = Triple(
            parts.get(0).trim(),
            otherParts.get(0).trim(),
            otherParts.get(1).trim()
        )
        return action(triple)
    }
}