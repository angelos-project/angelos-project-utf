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

public object GeorgianSupplement: UtfBlock {
    override val name: String = "Georgian Supplement"
    override val meta: String = "0x2d00..0x2d2f (40/8)"
    override val range: IntRange = 0x2d00..0x2d2d
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x2d26, 0x2d28, 0x2d29, 0x2d2a, 0x2d2b, 0x2d2c) }
}
