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
 * Abstract validator class for code points.
 */
public abstract class Validator {

    /**
     * Check if the given code point is valid.
     *
     * @param codePoint The code point to check.
     * @return True if valid, false otherwise.
     */
    public fun isValid(codePoint: CodePoint): Boolean = isValid(codePoint.value)

    /**
     * Check if the given integer code point is valid.
     *
     * @param cp The integer code point to check.
     * @return True if valid, false otherwise.
     */
    public abstract fun isValid(cp: Int): Boolean
}