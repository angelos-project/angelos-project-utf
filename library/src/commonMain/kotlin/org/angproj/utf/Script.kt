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
package org.angproj.utf

/**
 * Represents a writing system script, which is a collection of valid UTF-8 blocks.
 *
 * A script defines a set of Unicode blocks that are considered valid for that script,
 * along with metadata such as its name, code, and numeric identifier.
 */
public interface Script {
    /**
     * The human-readable name of the script (e.g., "Latin", "Cyrillic").
     */
    public val name: String

    /**
     * The short code or identifier for the script (e.g., "Latn", "Cyrl").
     */
    public val code: String

    /**
     * The numeric identifier for the script, typically matching the Unicode Script property value.
     */
    public val no: Int

    /**
     * The set of [UtfBlock]s that are valid within this script.
     *
     * Each block represents a contiguous range of Unicode code points used by the script.
     */
    public val blocks: Set<UtfBlock>

    /**
     * Builds a filter set of code points that are valid for the given [script].
     *
     * The filter includes all code points from the script's blocks, excluding those
     * explicitly marked as not in use (`noUse`) within each block.
     *
     * @param script The [Script] for which to build the filter.
     * @return A [HashSet] of valid code points for the script.
     */
    public fun buildFilter(script: Script): HashSet<Int> {
        val filter = mutableSetOf<Int>()
        script.blocks.forEach {
            filter.addAll(it.range.toSet() - it.noUse.toSet())
        }
        return filter.toHashSet()
    }
}