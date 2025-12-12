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

public abstract class Validator {

    /**
     * Checks if the given [CodePoint] is valid for any of the filter's blocks.
     *
     * @param codePoint The [CodePoint] to validate.
     * @return `true` if the code point is valid, `false` otherwise.
     */
    public fun isValid(codePoint: CodePoint): Boolean = isValid(codePoint.value)

    /**
     * Checks if the given code point integer is valid for any of the filter's blocks.
     *
     * @param cp The code point as an [Int].
     * @return `true` if the code point is valid, `false` otherwise.
     */
    public abstract fun isValid(cp: Int): Boolean
}