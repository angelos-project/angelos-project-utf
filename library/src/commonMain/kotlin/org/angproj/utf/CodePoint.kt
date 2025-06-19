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


/**
 * A code point is a number that maps to a character in the Unicode standard.
 * It is an integer value that represents a specific character in the Unicode character set.
 * Code points are used to represent characters in various encoding schemes, such as UTF-8 and UTF-16.
 *
 * @param value The integer value representing the code point.
 */
@JvmInline
public value class CodePoint(public val value: Int): UnicodeAware {}

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