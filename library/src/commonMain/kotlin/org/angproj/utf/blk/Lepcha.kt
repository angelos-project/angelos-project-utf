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

public object Lepcha: UtfBlock {
    override val name: String = "Lepcha"
    override val meta: String = "0x1c00..0x1c4f (74/6)"
    override val range: IntRange = 0x1c00..0x1c4f
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x1c38, 0x1c39, 0x1c3a, 0x1c4a, 0x1c4b, 0x1c4c) }
}
