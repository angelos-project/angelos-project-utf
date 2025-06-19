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
import org.angproj.utf.blk.Cuneiform
import org.angproj.utf.blk.CuneiformNumbersAndPunctuation
import org.angproj.utf.blk.EarlyDynasticCuneiform

public object Cuneiform : Script {
    override val name: String = "Cuneiform, Sumero-Akkadian"
    override val code: String = "Xsux"
    override val no: Int = 20

    override val blocks: Set<UtfBlock> = setOf(Cuneiform, CuneiformNumbersAndPunctuation, EarlyDynasticCuneiform)
}
