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

public object HangulJamoExtendedB: UtfBlock {
    override val name: String = "Hangul Jamo Extended-B"
    override val meta: String = "0xd7b0..0xd7ff (72/8)"
    override val range: IntRange = 0xd7b0..0xd7fb
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0xd7c7, 0xd7c8, 0xd7c9, 0xd7ca) }
}
