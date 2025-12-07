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
package org.angproj.utf.pla

public fun GeneralCategory.isOther(): Boolean =
    when (this) {
        GeneralCategory.OTHER,
        GeneralCategory.CONTROL,
        GeneralCategory.FORMAT,
        GeneralCategory.UNASSIGNED,
        GeneralCategory.PRIVATE_USE,
        GeneralCategory.SURROGATE -> true
        else -> false
    }

public fun GeneralCategory.isNumber(): Boolean =
    when (this) {
        GeneralCategory.NUMBER,
        GeneralCategory.DECIMAL_NUMBER,
        GeneralCategory.LETTER_NUMBER,
        GeneralCategory.OTHER_NUMBER -> true
        else -> false
    }

public fun GeneralCategory.isPunctuation(): Boolean =
    when (this) {
        GeneralCategory.PUNCTUATION,
        GeneralCategory.CONNECTOR_PUNCTUATION,
        GeneralCategory.DASH_PUNCTUATION,
        GeneralCategory.CLOSE_PUNCTUATION,
        GeneralCategory.FINAL_PUNCTUATION,
        GeneralCategory.INITIAL_PUNCTUATION,
        GeneralCategory.OTHER_PUNCTUATION,
        GeneralCategory.OPEN_PUNCTUATION -> true
        else -> false
    }

public fun GeneralCategory.isSymbol(): Boolean =
    when (this) {
        GeneralCategory.SYMBOL,
        GeneralCategory.CURRENCY_SYMBOL,
        GeneralCategory.MODIFIER_SYMBOL,
        GeneralCategory.MATH_SYMBOL,
        GeneralCategory.OTHER_SYMBOL -> true
        else -> false
    }

public fun GeneralCategory.isSeparator(): Boolean =
    when (this) {
        GeneralCategory.SEPARATOR,
        GeneralCategory.LINE_SEPARATOR,
        GeneralCategory.PARAGRAPH_SEPARATOR,
        GeneralCategory.SPACE_SEPARATOR -> true
        else -> false
    }

public fun GeneralCategory.isMark(): Boolean =
    when (this) {
        GeneralCategory.MARK,
        GeneralCategory.ENCLOSING_MARK,
        GeneralCategory.NONSPACING_MARK,
        GeneralCategory.SPACING_MARK -> true
        else -> false
    }

public fun GeneralCategory.isLetter(): Boolean =
    when (this) {
        GeneralCategory.LETTER,
        GeneralCategory.CASED_LETTER,
        GeneralCategory.LOWERCASE_LETTER,
        GeneralCategory.MODIFIER_LETTER,
        GeneralCategory.OTHER_LETTER,
        GeneralCategory.TITLECASE_LETTER,
        GeneralCategory.UPPERCASE_LETTER -> true
        else -> false
    }
