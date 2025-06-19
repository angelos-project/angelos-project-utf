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

public object Garay: UtfBlock {
    override val name: String = "Garay"
    override val meta: String = "0x10d40..0x10d8f (69/11)"
    override val range: IntRange = 0x10d40..0x10d8f
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x10d66, 0x10d67, 0x10d68, 0x10d86, 0x10d87, 0x10d88, 0x10d89, 0x10d8a, 0x10d8b, 0x10d8c, 0x10d8d) }
}
