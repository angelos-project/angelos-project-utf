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
import javax.swing.JComponent
import javax.swing.JRadioButtonMenuItem

@SwingGui
class GuiRadioGroupMenuBuilder : MetaMenuNode {
    private val buttons = mutableListOf<GuiRadioButtonMenuItemBuilder>()
    private var onChange: (String, Int) -> Unit = { s, i -> }

    fun onChange(action: (String, Int) -> Unit) {
        onChange = action
    }

    fun radioItem(text: String) { radioItem { this.text = text } }
    fun radioItem(config: GuiRadioButtonMenuItemBuilder.() -> Unit) {
        val builder = GuiRadioButtonMenuItemBuilder()
        builder.config()
        buttons.add(builder)
    }

    fun build(comp: JComponent) {
        val buttonGroup = ButtonGroup()
        buttons.forEachIndexed { index, button ->
            val menuItem = button.build()
            buttonGroup.add(menuItem)
            comp.add(menuItem)
            menuItem.addActionListener { event: ActionEvent ->
                val num = index
                onChange((event.source as JRadioButtonMenuItem).text, num)
            }
        }
    }
}