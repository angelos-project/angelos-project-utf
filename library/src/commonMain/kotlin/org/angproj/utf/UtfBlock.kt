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
 * Represents a contiguous block of Unicode code points, typically corresponding to a named Unicode block.
 *
 * A `UtfBlock` defines a range of code points, a human-readable name, a meta description, and
 * optionally a set of code points that are not in use or not allowed within the block. It also
 * provides a flag indicating whether the block contains control characters.
 *
 * Implementations of this interface are used to group and validate code points according to
 * Unicode block definitions, which are useful for language, script, and text processing.
 */
public interface UtfBlock {

    /**
     * The human-readable name of the Unicode block (e.g., "Basic Latin", "Cyrillic").
     */
    public val name: String

    /**
     * A meta description of the block, providing additional context or information.
     */
    public val meta: String

    /**
     * The inclusive range of Unicode code points that belong to this block.
     *
     * This range defines the valid code points for the block, subject to exclusions in [noUse].
     */
    public val range: IntRange

    /**
     * Indicates whether this block contains no control characters.
     *
     * If `true`, the block is free of control characters; if `false`, control characters may be present.
     */
    public val noCtrl: Boolean

    /**
     * The set of code points within [range] that are not allowed or not in use in this block.
     *
     * These code points are excluded from the set of valid code points for the block.
     */
    public val noUse: Set<Int>

    /**
     * Checks if the given [codePoint] is valid within this block.
     *
     * A code point is considered valid if it is within [range] and not present in [noUse].
     *
     * @param codePoint The [CodePoint] to check.
     * @return `true` if the code point is valid for this block, `false` otherwise.
     */
    public fun isValid(codePoint: CodePoint): Boolean = isValid<Unit>(codePoint.value, this)

    /**
     * Companion object providing utility methods for block validation.
     */
    public companion object {
        /**
         * Checks if the given code point integer [cp] is valid for the specified [block].
         *
         * A code point is valid if it is within the block's [range] and not in [noUse].
         *
         * @param cp The code point as an [Int].
         * @param block The [UtfBlock] to validate against.
         * @return `true` if the code point is valid, `false` otherwise.
         */
        internal inline fun <reified R: Any>isValid(cp: Int, block: UtfBlock): Boolean = cp in block.range && cp !in block.noUse
    }
}