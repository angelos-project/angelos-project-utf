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
import org.angproj.utf.gui.SwingGui
import java.awt.event.InputEvent
import javax.swing.JCheckBoxMenuItem
import javax.swing.KeyStroke

@SwingGui
class GuiCheckBoxMenuItemBuilder: AbstractMenuItemBuilder(), MetaCheckBoxMenuItem {
    private var _checked: Boolean = false
    private var onChange: (Boolean) -> Unit = {}

    override var isChecked: Boolean
        get() = _checked
        set(value) {
            _checked = value
        }

    override fun onChange(action: (Boolean) -> Unit) {
        onChange = action
    }

    fun build(): JCheckBoxMenuItem {
        return JCheckBoxMenuItem(text).apply {
            isSelected = _checked
            if(_cmd.first != OrdinaryKey.DISABLED) {
                var modifiers = 0
                _cmd.second.forEach {
                    modifiers = modifiers or when(it) {
                        SpecialKey.ALT -> InputEvent.ALT_DOWN_MASK
                        SpecialKey.CTRL -> InputEvent.CTRL_DOWN_MASK
                        SpecialKey.META -> InputEvent.META_DOWN_MASK
                        SpecialKey.SHIFT -> InputEvent.SHIFT_DOWN_MASK
                    }
                }
                this.accelerator = KeyStroke.getKeyStroke(_cmd.first.code, modifiers)
            }
            icon?.let { this.icon = it }
            addActionListener {
                onChange(isSelected)
            }
        }
    }
}