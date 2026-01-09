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
import javax.swing.JRadioButtonMenuItem
import javax.swing.KeyStroke

@SwingGui
class GuiRadioButtonMenuItemBuilder: AbstractMenuItemBuilder(), MetaRadioButtonMenuItem {
    private var _checked: Boolean = false

    override var isChecked: Boolean
        get() = _checked
        set(value) {
            _checked = value
        }

    fun build(): JRadioButtonMenuItem {
        return JRadioButtonMenuItem(text).apply {
            isSelected = _checked
            if(_cmd != noCmd) { this.accelerator = KeyStroke.getKeyStroke(_cmd.first, _cmd.second) }
            icon?.let { this.icon = it }
        }
    }
}