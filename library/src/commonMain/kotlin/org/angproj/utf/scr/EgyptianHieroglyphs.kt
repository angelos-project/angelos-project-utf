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
import org.angproj.utf.blk.EgyptianHieroglyphFormatControls
import org.angproj.utf.blk.EgyptianHieroglyphs
import org.angproj.utf.blk.EgyptianHieroglyphsExtendedA

public object EgyptianHieroglyphs : Script {
    override val name: String = "Egyptian hieroglyphs"
    override val code: String = "Egyp"
    override val no: Int = 50

    override val blocks: Set<UtfBlock> =
        setOf(EgyptianHieroglyphFormatControls, EgyptianHieroglyphs, EgyptianHieroglyphsExtendedA)
}
