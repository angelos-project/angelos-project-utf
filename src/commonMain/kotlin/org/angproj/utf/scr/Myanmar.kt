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
import org.angproj.utf.blk.Myanmar
import org.angproj.utf.blk.MyanmarExtendedA
import org.angproj.utf.blk.MyanmarExtendedB
import org.angproj.utf.blk.MyanmarExtendedC

public object Myanmar : Script {
    override val name: String = "Myanmar (Burmese)"
    override val code: String = "Mymr"
    override val no: Int = 350

    override val blocks: Set<UtfBlock> = setOf(Myanmar, MyanmarExtendedA, MyanmarExtendedB, MyanmarExtendedC)
}
