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

import java.awt.event.ActionEvent
import javax.swing.ButtonGroup
import javax.swing.JPanel
import javax.swing.JRadioButton

@SwingGui
class GuiRadioButtonGroupBuilder(private val panel: JPanel) {
    private val buttons = mutableListOf<JRadioButton>()
    private val group: ButtonGroup = ButtonGroup()
    private var onClick: (ActionEvent) -> Unit = {}

    fun radioButton(text: String, selected: Boolean = false) {
        buttons.add(JRadioButton(text, selected))
    }

    fun onClick(action: (ActionEvent) -> Unit) {
        onClick = action
    }

    fun build() {
        for (button in buttons) {
            button.addActionListener { event -> onClick(event) }
            group.add(button)
            panel.add(button)
        }
    }
}