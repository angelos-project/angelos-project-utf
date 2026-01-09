/**
 * Copyright (c) 2026 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
package org.angproj.utf.gui.menu

import org.angproj.utf.gui.MetaWidget
import org.angproj.utf.gui.OrdinaryKey
import org.angproj.utf.gui.SpecialKey
import javax.swing.ImageIcon

interface MetaMenuItem : MetaWidget, MetaMenuNode {
    fun setCmd(key: OrdinaryKey, vararg mask: SpecialKey)
    var icon: ImageIcon?
}