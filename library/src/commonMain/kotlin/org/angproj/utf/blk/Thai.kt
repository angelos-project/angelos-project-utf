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

public object Thai: UtfBlock {
    override val name: String = "Thai"
    override val meta: String = "0xe00..0xe7f (87/41)"
    override val range: IntRange = 0xe01..0xe5b
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0xe3b, 0xe3c, 0xe3d, 0xe3e) }
}
