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
 * A script is a set of UTf-8 blocks that are valid within the script.
 * */
public interface Script {
    /**
     * The name of the script.
     * */
    public val name: String
    public val code: String
    public val no: Int

    /**
     * The set of blocks that are valid within this script.
     * */
    public val blocks: Set<UtfBlock>

    public fun buildFilter(script: Script): HashSet<Int> {
        val filter = mutableSetOf<Int>()
        script.blocks.forEach {
            filter.addAll(it.range.toSet() - it.noUse.toSet())
        }
        return filter.toHashSet()
    }
}