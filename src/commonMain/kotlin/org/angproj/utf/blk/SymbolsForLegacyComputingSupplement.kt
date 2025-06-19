/**
 * Copyright (c) 2024-2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
package org.angproj.utf.blk

import org.angproj.utf.UtfBlock

public object SymbolsForLegacyComputingSupplement: UtfBlock {
    override val name: String = "Symbols for Legacy Computing Supplement"
    override val meta: String = "0x1cc00..0x1cebf (686/18)"
    override val range: IntRange = 0x1cc00..0x1ceb3
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x1ccfa, 0x1ccfb, 0x1ccfc, 0x1ccfd, 0x1ccfe, 0x1ccff) }
}
