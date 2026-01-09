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
import java.awt.event.ActionEvent
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
            if(_cmd != noCmd) { this.accelerator = KeyStroke.getKeyStroke(_cmd.first, _cmd.second) }
            icon?.let { this.icon = it }
            this.addActionListener { onCommand(it) }
        }
    }
}