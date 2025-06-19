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

public object LinearBSyllabary: UtfBlock {
    override val name: String = "Linear B Syllabary"
    override val meta: String = "0x10000..0x1007f (88/40)"
    override val range: IntRange = 0x10000..0x1005d
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x1000c, 0x10027, 0x1003b, 0x1003e, 0x1004e, 0x1004f) }
}
