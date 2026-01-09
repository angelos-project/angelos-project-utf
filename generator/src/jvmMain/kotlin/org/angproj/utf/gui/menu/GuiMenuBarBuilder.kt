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
import javax.swing.JMenuBar

@SwingGui
class GuiMenuBarBuilder {

    private val menus: MutableList<GuiMenuBuilder> = mutableListOf()

    fun menu(init: GuiMenuBuilder.() -> Unit) {
        val menuBuilder = GuiMenuBuilder()
        menuBuilder.init()
        menus.add(menuBuilder)
    }

    fun build(): JMenuBar {
        return JMenuBar().apply {
            menus.forEach {
                add(it.build())
            }
        }
    }
}