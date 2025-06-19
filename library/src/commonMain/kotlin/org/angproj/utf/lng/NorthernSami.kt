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
import org.angproj.utf.scr.Cyrillic
import org.angproj.utf.scr.Latin

public object NorthernSami : UtfLanguage {
    override val name: String = "Northern Sami"
    override val short: String = "se"
    override val long: String = "sme"

    override val scripts: Set<Script> = setOf(Cyrillic, Latin)
}
