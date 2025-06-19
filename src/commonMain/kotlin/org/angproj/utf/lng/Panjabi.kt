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
import org.angproj.utf.scr.Arabic
import org.angproj.utf.scr.Gurmukhi

public object Panjabi : UtfLanguage {
    override val name: String = "Panjabi"
    override val short: String = "pa"
    override val long: String = "pan"

    override val scripts: Set<Script> = setOf(Arabic, Gurmukhi)
}
