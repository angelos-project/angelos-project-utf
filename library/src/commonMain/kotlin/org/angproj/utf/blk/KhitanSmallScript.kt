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

public object KhitanSmallScript: UtfBlock {
    override val name: String = "Khitan Small Script"
    override val meta: String = "0x18b00..0x18cff (471/41)"
    override val range: IntRange = 0x18b00..0x18cff
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x18cd6, 0x18cd7, 0x18cd8, 0x18cd9, 0x18cda, 0x18cdb, 0x18cdc, 0x18cdd, 0x18cde, 0x18cdf, 0x18ce0, 0x18ce1, 0x18ce2, 0x18ce3, 0x18ce4, 0x18ce5, 0x18ce6, 0x18ce7, 0x18ce8, 0x18ce9, 0x18cea, 0x18ceb, 0x18cec, 0x18ced, 0x18cee, 0x18cef, 0x18cf0, 0x18cf1, 0x18cf2, 0x18cf3, 0x18cf4, 0x18cf5, 0x18cf6, 0x18cf7, 0x18cf8, 0x18cf9, 0x18cfa, 0x18cfb, 0x18cfc, 0x18cfd, 0x18cfe) }
}
