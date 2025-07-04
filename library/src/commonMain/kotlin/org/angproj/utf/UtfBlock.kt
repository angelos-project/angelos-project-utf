/**
 * Copyright (c) 2024 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
 * Represents a block of Unicode characters.
 * */
public interface UtfBlock {

    /**
     * The name of the block.
     */
    public val name: String

    /**
     * A meta description of the block.
     */
    public val meta: String

    /**
     * The range of code points that are valid within this block.
     */
    public val range: IntRange

    public val noCtrl: Boolean

    /**
     * The set of code points that are not allowed in this block.
     */
    public val noUse: Set<Int>

    /**
     * Checks if the given code point is valid within this block.
     *
     * @param codePoint The code point to check.
     * @return `true` if the code point is valid, `false` otherwise.
     */
    public fun isValid(codePoint: CodePoint): Boolean = isValid<Unit>(codePoint.value, this)

    public companion object {
        internal inline fun <reified R: Any>isValid(cp: Int, block: UtfBlock): Boolean = cp in block.range && cp !in block.noUse
    }
}