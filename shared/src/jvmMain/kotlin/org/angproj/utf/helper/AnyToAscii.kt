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

import com.ibm.icu.text.Transliterator;

public object AnyToAscii {
    private val transliterator = Transliterator.getInstance("Any-Latin; NFD; [:Nonspacing Mark:] Remove; NFC;")

    public fun toAscii(input: String): String = transliterator.transliterate(input)
}