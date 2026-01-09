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
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.KeyStroke

@SwingGui
class GuiMenuItemBuilder(private val text: String) {
    private val menu = JMenu(text)

    fun item(text: String, accel: KeyStroke? = null, action: (ActionEvent?) -> Unit = {}) {
        val mi = JMenuItem(text)
        accel?.let { mi.accelerator = it }
        mi.addActionListener { action(it) }
        menu.add(mi)
    }

    fun separator() {
        menu.addSeparator()
    }

    fun submenu(text: String, init: GuiMenuItemBuilder.() -> Unit) {
        val sub = GuiMenuItemBuilder(text)
        sub.init()
        menu.add(sub.build())
    }

    fun build(): JMenu = menu
}