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
package org.angproj.utf.helper

//import com.ibm.icu.text.Transliterator;
import java.text.Normalizer;
import java.util.regex.Pattern;

public object AnyToAscii {
    //private val transliterator = Transliterator.getInstance("Any-Latin; NFD; [:Nonspacing Mark:] Remove; NFC;")

    //public fun toAscii(input: String): String = transliterator.transliterate(input)
    private val DIACRITICS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    /**
     * Converts accented characters to their ASCII equivalents.
     * Works for Latin-based scripts (French, German, Spanish, etc.).
     */
    public fun toAscii(input: String): String {

        // Step 1: Decompose accented chars (NFD form)
        val normalized = Normalizer.normalize(input, Normalizer.Form.NFD);

        // Step 2: Remove combining diacritical marks
        val withoutDiacritics = DIACRITICS_PATTERN.matcher(normalized)
            .replaceAll("");

        // Optional: Replace some common non-ASCII chars that survive
        return withoutDiacritics
            .replace(".", "")
            .replace("'", "")
            .replace("!", "")
            .replace("(", "")
            .replace(")", "")
            .replace("’", "")
            .replace("ǂ", "")
            .replace("ǁ", "")
            .replace("æ", "ae")
            .replace("œ", "oe")
            .replace("ß", "ss")
            .replace("ð", "d")
            .replace("þ", "th")
            .replace("Đ", "D")
            .replace("đ", "d")
            .replace("ł", "l")
            .replace("Ł", "L");
    }
}