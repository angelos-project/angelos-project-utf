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
package org.angproj.utf.model

data class SearchName(
    val canonical: String
) {
    val slug: String = slugify(canonical)
    val klazz: String = klazzify(canonical)
    val constant: String = constantify(canonical)

    companion object {
        fun slugify(name: String): String {
            return name.lowercase().replace(" ", "_").replace("-", "_")
        }

        fun klazzify(name: String): String {
            return name.replace(" ", "_").replace("-", "_")
        }

        fun constantify(name: String): String {
            return name.uppercase().replace(" ", "_").replace("-", "_")
        }

        fun camelCaseSplitAndUnderscore(name: String): String {
            return name.replace(Regex("([a-z])([A-Z])"), "$1_$2").replace(Regex("([A-Z])([A-Z])"), "$1_$2").uppercase()
        }
    }
}