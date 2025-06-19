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

public object Sunuwar: UtfBlock {
    override val name: String = "Sunuwar"
    override val meta: String = "0x11bc0..0x11bff (44/20)"
    override val range: IntRange = 0x11bc0..0x11bf9
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x11be2, 0x11be3, 0x11be4, 0x11be5, 0x11be6, 0x11be7, 0x11be8, 0x11be9, 0x11bea, 0x11beb, 0x11bec, 0x11bed, 0x11bee, 0x11bef) }
}
