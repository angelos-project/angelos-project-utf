/**
 * Copyright (c) 2026 by Kristoffer Paulsson <kristoffer.paulsson></kristoffer.paulsson>@talenten.se>.
 * 
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 * 
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 * 
 * Contributors:
 * Kristoffer Paulsson - initial implementation
 */
package org.angproj.utf.swing

import java.awt.Color
import java.awt.Font
import java.awt.GridLayout
import javax.swing.*

internal class JToolTipExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Note: JToolTip is displayed on hover over components with setToolTipText.
        // Custom JToolTip requires overriding createToolTip in a JComponent subclass.

        // Example 1: Basic JToolTip on JLabel
        add(JLabel("1. Basic JToolTip on JLabel (hover):"))
        val label1 = JLabel("Hover me for basic tooltip")
        label1.setToolTipText("This is a basic tooltip")
        add(label1)

        // Example 2: Multiline JToolTip using HTML
        add(JLabel("2. Multiline JToolTip using HTML (hover):"))
        val label2 = JLabel("Hover for multiline tooltip")
        label2.setToolTipText("<html>Line 1<br>Line 2<br>Line 3</html>")
        add(label2)

        // Example 3: JToolTip with custom background (requires custom JToolTip)
        add(JLabel("3. JToolTip with custom background (yellow, hover):"))
        val custom3: JComponent = object : JLabel("Hover for custom background") {
            override fun createToolTip(): JToolTip {
                val tip = super.createToolTip()
                tip.setBackground(Color.YELLOW)
                return tip
            }
        }
        custom3.setToolTipText("Custom background tooltip")
        add(custom3)

        // Example 4: JToolTip with custom foreground (red text)
        add(JLabel("4. JToolTip with custom foreground (red, hover):"))
        val custom4: JComponent = object : JLabel("Hover for custom foreground") {
            override fun createToolTip(): JToolTip {
                val tip = super.createToolTip()
                tip.setForeground(Color.RED)
                return tip
            }
        }
        custom4.setToolTipText("Custom foreground tooltip")
        add(custom4)

        // Example 5: JToolTip with custom font (bold)
        add(JLabel("5. JToolTip with custom font (bold, hover):"))
        val custom5: JComponent = object : JLabel("Hover for custom font") {
            override fun createToolTip(): JToolTip {
                val tip = super.createToolTip()
                tip.setFont(tip.getFont().deriveFont(Font.BOLD))
                return tip
            }
        }
        custom5.setToolTipText("Custom font tooltip")
        add(custom5)

        // Example 6: JToolTip with border (line border)
        add(JLabel("6. JToolTip with border (red line, hover):"))
        val custom6: JComponent = object : JLabel("Hover for bordered tooltip") {
            override fun createToolTip(): JToolTip {
                val tip = super.createToolTip()
                tip.setBorder(BorderFactory.createLineBorder(Color.RED))
                return tip
            }
        }
        custom6.setToolTipText("Bordered tooltip")
        add(custom6)

        // Example 7: JToolTip with HTML styling
        add(JLabel("7. JToolTip with HTML styling (colored text, hover):"))
        val label7 = JLabel("Hover for styled HTML tooltip")
        label7.setToolTipText("<html><font color='blue'>Blue text</font> and <b>bold</b></html>")
        add(label7)

        // Example 8: JToolTip on JButton
        add(JLabel("8. JToolTip on JButton (hover):"))
        val button8 = JButton("Hover me")
        button8.setToolTipText("Tooltip on button")
        add(button8)

        // Note: ToolTipManager can adjust delays globally, e.g., ToolTipManager.sharedInstance().setInitialDelay(0);
        // But since global, not shown per example to avoid affecting all.
        // For more custom JToolTip subclasses, can extend JToolTip and override createToolTip to return subclass.
    }
}
