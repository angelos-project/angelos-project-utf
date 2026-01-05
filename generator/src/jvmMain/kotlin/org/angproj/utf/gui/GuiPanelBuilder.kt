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
package org.angproj.utf.gui

import java.awt.GridLayout
import java.awt.LayoutManager
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.Border

@SwingGui
class GuiPanelBuilder(private val panel: JPanel = JPanel()) : Component {

    var layout: LayoutManager
        get() = panel.layout
        set(value) { panel.layout = value }

    var border: Border
        get() = panel.border
        set(value) { panel.border = value }

    init {
        layout = GridLayout(0, 1, 10, 10)
        border = BorderFactory.createEmptyBorder(20, 20, 20, 20)
    }

    fun label(text: String) { panel.add(JLabel(text)) }
    fun label(init: JLabel.() -> Unit) {
        val lbl = JLabel()
        lbl.init()
        panel.add(lbl)
    }

    override fun build(): JPanel = panel
}