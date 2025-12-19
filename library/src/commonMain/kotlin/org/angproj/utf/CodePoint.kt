/**
 * Copyright (c) 2024-2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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

import kotlin.jvm.JvmInline


public typealias CodePointPredicate = (CodePoint) -> Boolean

/**
 * A code point is a number that maps to a character in the Unicode standard.
 * It is an integer value that represents a specific character in the Unicode character set.
 * Code points are used to represent characters in various encoding schemes, such as UTF-8 and UTF-16.
 *
 * @param value The integer value representing the code point.
 */
@JvmInline
public value class CodePoint(public val value: Int) {

    /**
     * Byte size of octet sequence. Will incorrectly report the size for surrogates.
     * */
    public fun octetSize(): Int = withUnicode { octetSize(value) }

    /**
     * Validity of code point. Will incorrectly validate unassigned values.
     * Code point U+FFFD REPLACEMENT CHARACTER always validates false.
     * */
    public fun isValid(): Boolean = withUnicode { isValid(value) }

    /**
     * Null code point or not.
     * */
    public fun isNull(): Boolean = this == nullCodePoint

    public companion object {

        /**
         * Placeholder for a null code point object.
         * */
        public val nullCodePoint: CodePoint = CodePoint(Int.MIN_VALUE)
    }
}

/**
 * Converts an integer to a code point.
 *
 * @return The code point corresponding to the given integer value.
 */
public fun Int.toCodePoint(): CodePoint = CodePoint(this)

/**
 * Converts a character to a code point.
 *
 * @return The code point corresponding to the given character.
 */
public fun Char.toCodePoint(): CodePoint = CodePoint(this.code)