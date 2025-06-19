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

public object EthiopicExtendedB: UtfBlock {
    override val name: String = "Ethiopic Extended-B"
    override val meta: String = "0x1e7e0..0x1e7ff (28/4)"
    override val range: IntRange = 0x1e7e0..0x1e7fe
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x1e7e7, 0x1e7ec, 0x1e7ef) }
}
