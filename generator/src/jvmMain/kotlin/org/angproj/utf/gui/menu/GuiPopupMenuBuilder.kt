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
import javax.swing.JPopupMenu

@SwingGui
class GuiPopupMenuBuilder : AbstractMenuBuilder() {

    fun build(): JPopupMenu {
        return JPopupMenu(text).apply {
            items.forEach {
                when (it) {
                    is MetaMenuSeparator -> addSeparator()
                    is GuiMenuItemBuilder -> this.add((it).build())
                    is GuiCheckBoxMenuItemBuilder -> this.add((it).build())
                    is GuiRadioGroupMenuBuilder -> {}
                    is GuiSubMenuBuilder -> add(it.build())
                    else -> error("Unhandled GUI builder") // Ignore unknown types
                }
            }
        }
    }
}