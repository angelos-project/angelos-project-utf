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

public object Tirhuta: UtfBlock {
    override val name: String = "Tirhuta"
    override val meta: String = "0x11480..0x114df (82/14)"
    override val range: IntRange = 0x11480..0x114d9
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x114c8, 0x114c9, 0x114ca, 0x114cb, 0x114cc, 0x114cd, 0x114ce, 0x114cf) }
}
