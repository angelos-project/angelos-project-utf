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
import org.angproj.utf.scr.Latin
import org.angproj.utf.scr.Yi

public object SichuanYi : UtfLanguage {
    override val name: String = "Sichuan Yi"
    override val short: String = "ii"
    override val long: String = "iii"

    override val scripts: Set<Script> = setOf(Latin, Yi)
}
