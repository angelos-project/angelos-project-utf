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
package org.angproj.utf.lng

import org.angproj.utf.Script
import org.angproj.utf.UtfLanguage
import org.angproj.utf.scr.Devanagari
import org.angproj.utf.scr.Grantha
import org.angproj.utf.scr.Sharada
import org.angproj.utf.scr.Siddham
import org.angproj.utf.scr.Sinhala

public object Sanskrit : UtfLanguage {
    override val name: String = "Sanskrit"
    override val short: String = "sa"
    override val long: String = "san"

    override val scripts: Set<Script> = setOf(Devanagari, Grantha, Sharada, Siddham, Sinhala)
}
