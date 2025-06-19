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

public object ArabicExtendedC: UtfBlock {
    override val name: String = "Arabic Extended-C"
    override val meta: String = "0x10ec0..0x10eff (7/57)"
    override val range: IntRange = 0x10ec2..0x10eff
    override val noCtrl: Boolean = false
    override val noUse: Set<Int> by lazy { hashSetOf(0x10ec5, 0x10ec6, 0x10ec7, 0x10ec8, 0x10ec9, 0x10eca, 0x10ecb, 0x10ecc, 0x10ecd, 0x10ece, 0x10ecf, 0x10ed0, 0x10ed1, 0x10ed2, 0x10ed3, 0x10ed4, 0x10ed5, 0x10ed6, 0x10ed7, 0x10ed8, 0x10ed9, 0x10eda, 0x10edb, 0x10edc, 0x10edd, 0x10ede, 0x10edf, 0x10ee0, 0x10ee1, 0x10ee2, 0x10ee3, 0x10ee4, 0x10ee5, 0x10ee6, 0x10ee7, 0x10ee8, 0x10ee9, 0x10eea, 0x10eeb, 0x10eec, 0x10eed, 0x10eee, 0x10eef, 0x10ef0, 0x10ef1, 0x10ef2, 0x10ef3, 0x10ef4, 0x10ef5, 0x10ef6, 0x10ef7, 0x10ef8, 0x10ef9, 0x10efa, 0x10efb) }
}
