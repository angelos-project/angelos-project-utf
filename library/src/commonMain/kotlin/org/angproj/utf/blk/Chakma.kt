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

public object Chakma: UtfBlock {
    override val name: String = "Chakma"
    override val meta: String = "0x11100..0x1114f (71/9)"
    override val range: IntRange = 0x11100..0x11147
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x11135) }
}
