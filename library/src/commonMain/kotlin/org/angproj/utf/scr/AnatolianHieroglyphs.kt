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
package org.angproj.utf.scr

import org.angproj.utf.Script
import org.angproj.utf.UtfBlock
import org.angproj.utf.blk.AnatolianHieroglyphs

public object AnatolianHieroglyphs : Script {
    override val name: String = "Anatolian Hieroglyphs (Luwian Hieroglyphs, Hittite Hieroglyphs)"
    override val code: String = "Hluw"
    override val no: Int = 80

    override val blocks: Set<UtfBlock> = setOf(AnatolianHieroglyphs)
}
