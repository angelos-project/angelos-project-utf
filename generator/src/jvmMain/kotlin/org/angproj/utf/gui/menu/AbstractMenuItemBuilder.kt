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

import org.angproj.utf.gui.OrdinaryKey
import org.angproj.utf.gui.SpecialKey
import javax.swing.ImageIcon

abstract class AbstractMenuItemBuilder : MetaMenuItem {
    private var _text: String = ""
    override var text: String
        get() = _text
        set(value) {
            _text = value
        }

    protected var _cmd: Pair<OrdinaryKey, List<SpecialKey>> = noCmd

    override fun setCmd(key: OrdinaryKey, vararg mask: SpecialKey) {
        _cmd = Pair(key, mask.toList())
    }

    private var _icon: ImageIcon? = null
    override var icon: ImageIcon?
        get() = _icon
        set(value) {
            _icon = value
        }

    companion object {
        val noCmd = Pair(OrdinaryKey.DISABLED, listOf<SpecialKey>())
    }
}