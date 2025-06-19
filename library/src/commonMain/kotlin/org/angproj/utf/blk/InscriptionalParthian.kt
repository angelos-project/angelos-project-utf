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

public object InscriptionalParthian: UtfBlock {
    override val name: String = "Inscriptional Parthian"
    override val meta: String = "0x10b40..0x10b5f (30/2)"
    override val range: IntRange = 0x10b40..0x10b5f
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x10b56, 0x10b57) }
}
