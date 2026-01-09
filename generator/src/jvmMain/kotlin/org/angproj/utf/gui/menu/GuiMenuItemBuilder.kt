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
import java.awt.event.ActionEvent
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import javax.swing.JMenuItem
import javax.swing.KeyStroke

@SwingGui
class GuiMenuItemBuilder: AbstractMenuItemBuilder() {

    private var onCommand: (ActionEvent) -> Unit = {}

    fun onCommand(action: (ActionEvent) -> Unit) {
        onCommand = action
    }

    fun build(): JMenuItem {
        return JMenuItem(text).apply {
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
            this.addActionListener { onCommand(it) }
        }
    }
}