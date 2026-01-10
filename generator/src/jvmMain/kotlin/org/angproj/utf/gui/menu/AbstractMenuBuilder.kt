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

import org.angproj.utf.gui.MetaWidget
import org.angproj.utf.gui.SwingGui
import java.awt.event.ActionEvent
import javax.swing.JComponent
import javax.swing.JSeparator

@SwingGui
abstract class AbstractMenuBuilder : MetaMenuNode, MetaWidget {
    private var _text: String = ""
    override var text: String
        get() = _text
        set(value) {
            _text = value
        }

    protected val items: MutableList<MetaMenuNode> = mutableListOf()

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

    fun checkItem(text: String, action: (String, Boolean) -> Unit) { checkItem {
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

    fun subMenu(text: String, config: GuiSubMenuBuilder.() -> Unit) {
        val builder = GuiSubMenuBuilder()
        builder.config()
        builder.text = text
        items.add(builder)
    }

    /**
     * To be refactored away
     * */
    protected fun someBuild(comp: JComponent) {
        comp.apply {
            items.forEach {
                when (it) {
                    is MetaMenuSeparator -> add(JSeparator())
                    is GuiMenuItemBuilder -> add(it.build())
                    is GuiCheckBoxMenuItemBuilder -> add(it.build())
                    is GuiRadioGroupMenuBuilder -> { it.build(this) }
                    is GuiSubMenuBuilder -> add(it.build())
                    else -> error("Unhandled GUI builder") // Ignore unknown types
                }
            }
        }
    }
}