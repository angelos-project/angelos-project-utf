/**
 * Copyright (c) 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
package org.angproj.utf.ui

import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem

abstract class Widget {
    fun Widget.menubar(build: JMenuBar.() -> Unit): JMenuBar = JMenuBar().apply { build() }

    fun Widget.menu(label: String, build: JMenu.() -> Unit): JMenu = JMenu(label).apply { build() }

    fun Widget.menuItem(label: String, command: JMenuItem.() -> Unit): JMenuItem = JMenuItem(label).apply {
        addActionListener { command() }
    }
}

fun <E>widget(build: Widget.() -> E): E {
    return build(object : Widget() {})
}

fun menuBar(): JMenuBar = widget {
    menubar {
        menu("File") {
            separator()
            item("Exit") {
                System.exit(0)
            }
        }
        menu("View") {
            item("Show Unicode Blocks") {
                // Action for showing Unicode Blocks
            }
            item("Show Unicode Scripts") {
                // Action for showing Unicode Scripts
            }
        }
        menu("Help") {
            item("About") {
                // Action for showing About dialog
            }
        }
    }
}
