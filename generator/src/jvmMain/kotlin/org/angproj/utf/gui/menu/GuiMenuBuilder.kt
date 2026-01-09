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

import org.angproj.utf.gui.SwingGui
import javax.swing.JMenu

@SwingGui
class GuiMenuBuilder : AbstractMenuBuilder() {
    private var _mnemonic: Int = 0
    var mnemonic: Int
        get() = _mnemonic
        set(value) {
            _mnemonic = value
        }

    fun build(): JMenu {
        return JMenu(text).apply {
            if (mnemonic != 0) {
                this.mnemonic = mnemonic
            }
            items.forEach {
                when (it) {
                    is MetaMenuSeparator -> addSeparator()
                    is GuiMenuItemBuilder -> this.add((it).build())
                    is GuiCheckBoxMenuItemBuilder -> this.add((it).build())
                    is GuiRadioGroupMenuBuilder -> {}
                    is GuiSubMenuBuilder -> add(it.build())
                    else -> error("Unhandled GUI builder") // Ignore unknown types
                }
            }
        }
    }
}