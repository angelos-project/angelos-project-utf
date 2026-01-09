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
import javax.swing.ButtonGroup
import javax.swing.JRadioButtonMenuItem

@SwingGui
class GuiRadioGroupMenuBuilder : MetaMenuNode {
    private val buttons = mutableListOf<GuiRadioButtonMenuItemBuilder>()
    private var onChange: (String) -> Unit = {}

    fun onChange(action: (String) -> Unit) {
        onChange = action
    }

    fun radioItem(text: String) { radioItem { this.text = text } }
    fun radioItem(init: GuiRadioButtonMenuItemBuilder.() -> Unit) {
        val builder = GuiRadioButtonMenuItemBuilder()
        builder.init()
        buttons.add(builder)
    }

    fun build() {
        val buttonGroup = ButtonGroup()
        for (button in buttons) {
            val menuItem = button.build()
            buttonGroup.add(menuItem)
            menuItem.addActionListener { event: ActionEvent ->
                onChange((event.source as JRadioButtonMenuItem).text)
            }
        }
    }
}