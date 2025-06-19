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

public object Kawi: UtfBlock {
    override val name: String = "Kawi"
    override val meta: String = "0x11f00..0x11f5f (87/9)"
    override val range: IntRange = 0x11f00..0x11f5a
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x11f11, 0x11f3b, 0x11f3c, 0x11f3d) }
}
