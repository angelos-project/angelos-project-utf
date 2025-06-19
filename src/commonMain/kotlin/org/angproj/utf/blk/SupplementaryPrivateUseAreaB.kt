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

public object SupplementaryPrivateUseAreaB: UtfBlock {
    override val name: String = "Supplementary Private Use Area-B"
    override val meta: String = "0x100000..0x10ffff (0/65536)"
    override val range: IntRange = 0x100000..0x10ffff
    override val noCtrl: Boolean = true
    override val noUse: Set<Int> by lazy { hashSetOf() }
}
