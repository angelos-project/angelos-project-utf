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

public enum class GeneralCategory(public val canonical: String, public val abbr: String) {
    OTHER("Other", "C"),
    CONTROL("Control", "Cc"),
    FORMAT("Format", "Cf"),
    UNASSIGNED("Unassigned", "Cn"),
    PRIVATE_USE("Private_Use", "Co"),
    SURROGATE("Surrogate", "Cs"),
    LETTER("Letter", "L"),
    CASED_LETTER("Cased_Letter", "LC"),
    LOWERCASE_LETTER("Lowercase_Letter", "Ll"),
    MODIFIER_LETTER("Modifier_Letter", "Lm"),
    OTHER_LETTER("Other_Letter", "Lo"),
    TITLECASE_LETTER("Titlecase_Letter", "Lt"),
    UPPERCASE_LETTER("Uppercase_Letter", "Lu"),
    MARK("Mark", "M"),
    SPACING_MARK("Spacing_Mark", "Mc"),
    ENCLOSING_MARK("Enclosing_Mark", "Me"),
    NONSPACING_MARK("Nonspacing_Mark", "Mn"),
    NUMBER("Number", "N"),
    DECIMAL_NUMBER("Decimal_Number", "Nd"),
    LETTER_NUMBER("Letter_Number", "Nl"),
    OTHER_NUMBER("Other_Number", "No"),
    PUNCTUATION("Punctuation", "P"),
    CONNECTOR_PUNCTUATION("Connector_Punctuation", "Pc"),
    DASH_PUNCTUATION("Dash_Punctuation", "Pd"),
    CLOSE_PUNCTUATION("Close_Punctuation", "Pe"),
    FINAL_PUNCTUATION("Final_Punctuation", "Pf"),
    INITIAL_PUNCTUATION("Initial_Punctuation", "Pi"),
    OTHER_PUNCTUATION("Other_Punctuation", "Po"),
    OPEN_PUNCTUATION("Open_Punctuation", "Ps"),
    SYMBOL("Symbol", "S"),
    CURRENCY_SYMBOL("Currency_Symbol", "Sc"),
    MODIFIER_SYMBOL("Modifier_Symbol", "Sk"),
    MATH_SYMBOL("Math_Symbol", "Sm"),
    OTHER_SYMBOL("Other_Symbol", "So"),
    SEPARATOR("Separator", "Z"),
    LINE_SEPARATOR("Line_Separator", "Zl"),
    PARAGRAPH_SEPARATOR("Paragraph_Separator", "Zp"),
    SPACE_SEPARATOR("Space_Separator", "Zs");
}
