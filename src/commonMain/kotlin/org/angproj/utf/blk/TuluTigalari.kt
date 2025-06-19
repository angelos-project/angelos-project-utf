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

public object TuluTigalari: UtfBlock {
    override val name: String = "Tulu-Tigalari"
    override val meta: String = "0x11380..0x113ff (80/48)"
    override val range: IntRange = 0x11380..0x113e2
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x1138a, 0x1138c, 0x1138d, 0x1138f, 0x113b6, 0x113c1, 0x113c3, 0x113c4, 0x113c6, 0x113cb, 0x113d6, 0x113d9, 0x113da, 0x113db, 0x113dc, 0x113dd, 0x113de, 0x113df, 0x113e0) }
}
