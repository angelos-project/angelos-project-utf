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

@SwingGui
class AbstractMenuBuilder : MetaMenuNode {

    private val items: MutableList<MetaMenuNode> = mutableListOf()

    fun separator() {
        items.add(object : MetaMenuSeparator {})
    }

    fun menuItem(text: String, action: (ActionEvent) -> Unit) { menuItem {
        this.text = text
        onCommand(action)
    } }
    fun menuItem(config: GuiMenuItemBuilder.() -> Unit) {
        val builder = GuiMenuItemBuilder()
        builder.config()
        items.add(builder)
    }

    fun checkItem(text: String, action: (Boolean) -> Unit) { checkItem {
        this.text = text
        onChange(action)
    } }
    fun checkItem(config: GuiCheckBoxMenuItemBuilder.() -> Unit) {
        val builder = GuiCheckBoxMenuItemBuilder()
        builder.config()
        items.add(builder)
    }

    fun radioGroup(config: GuiRadioGroupMenuBuilder.() -> Unit) {
        val builder = GuiRadioGroupMenuBuilder()
        builder.config()
        items.add(builder)
    }

    fun subMenu(config: AbstractMenuBuilder.() -> Unit) {
        val builder = AbstractMenuBuilder()
        builder.config()
        items.add(builder)
    }

    fun build(): JMenu {
        /*return JMenu(text).apply {
            accel?.let { this.accelerator = it }
            this.addActionListener { onCommand(it) }
            items.forEach { this.add(it) }
        }*/
        return JMenu()
    }
}