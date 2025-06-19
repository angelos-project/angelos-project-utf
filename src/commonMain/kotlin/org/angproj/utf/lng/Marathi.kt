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
import org.angproj.utf.scr.Modi

public object Marathi : UtfLanguage {
    override val name: String = "Marathi"
    override val short: String = "mr"
    override val long: String = "mar"

    override val scripts: Set<Script> = setOf(Devanagari, Modi)
}
