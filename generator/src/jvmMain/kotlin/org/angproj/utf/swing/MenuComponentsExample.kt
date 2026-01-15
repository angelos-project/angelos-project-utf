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
package org.angproj.utf.swing

import org.angproj.utf.gui.menu.GuiPopupMenuBuilder
import java.awt.BorderLayout
import java.awt.Color
import java.awt.image.BufferedImage
import javax.swing.*

// JToolBar Example menu item
internal class MenuComponentsExample(private val parentFrame: JFrame) : JPanel() {
    private val statusLabel: JLabel

    init {
        setLayout(BorderLayout())

        statusLabel = JLabel("Status: No action yet")
        add(statusLabel, BorderLayout.SOUTH)
        val popupButton = JButton("Right-click for Popup Menu")
        add(popupButton, BorderLayout.CENTER)

        with(GuiPopupMenuBuilder()) {
            menuItem("Popup Item") { statusLabel.text = "Popup Item selected" }
            checkItem("CheckBox") { string, bool -> statusLabel.text = "Checkbox $bool" }
            subMenu("SubMenu") {
                menuItem("Menu Item") { statusLabel.text = "Menu Item selected" }
                menuItem("Menu Item 2") { statusLabel.text = "Menu Item2 selected" }
            }
            separator()
            radioGroup(listOf("Radio 1", "Radio 2", "Radio 3"), 1) { s, i ->
                statusLabel.text = "Selected: $s at index $i"
            }

            popupButton.componentPopupMenu = build()
        }
    }

    private fun createIcon(color: Color): ImageIcon {
        val size = 16
        val img = BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB)
        val g = img.createGraphics()
        try {
            g.color = color
            g.fillRect(0, 0, size, size)
            g.color = Color(0, 0, 0, 60)
            g.drawRect(0, 0, size - 1, size - 1)
        } finally {
            g.dispose()
        }
        return ImageIcon(img)
    }
}
