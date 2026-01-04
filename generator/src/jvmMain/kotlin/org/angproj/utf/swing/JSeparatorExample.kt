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

import java.awt.*
import javax.swing.*

internal class JSeparatorExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JSeparator (horizontal)
        add(JLabel("1. Default JSeparator (horizontal):"))
        add(JSeparator())

        // Example 2: Vertical JSeparator
        add(JLabel("2. Vertical JSeparator:"))
        val verticalPanel = JPanel(FlowLayout())
        verticalPanel.add(JSeparator(SwingConstants.VERTICAL))
        add(verticalPanel)

        // Example 3: JSeparator with tooltip
        add(JLabel("3. JSeparator with tooltip (hover to see):"))
        val sep3 = JSeparator()
        sep3.setToolTipText("This is a tooltip!")
        add(sep3)

        // Example 4: JSeparator with custom foreground color
        add(JLabel("4. JSeparator with custom foreground color (red):"))
        val sep4 = JSeparator()
        sep4.setForeground(Color.RED)
        add(sep4)

        // Example 5: JSeparator with custom background color
        add(JLabel("5. JSeparator with custom background color (yellow):"))
        val sep5 = JSeparator()
        sep5.setBackground(Color.YELLOW)
        add(sep5)

        // Example 6: Disabled JSeparator
        add(JLabel("6. Disabled JSeparator:"))
        val sep6 = JSeparator()
        sep6.setEnabled(false)
        add(sep6)

        // Example 7: JSeparator with custom size (thicker via preferred size)
        add(JLabel("7. JSeparator with custom size (thicker):"))
        val sep7 = JSeparator()
        sep7.setPreferredSize(Dimension(100, 5)) // Thicker height
        sep7.setBackground(Color.BLACK)
        add(sep7)

        // Example 8: Vertical JSeparator with custom size
        add(JLabel("8. Vertical JSeparator with custom size:"))
        val verticalPanel2 = JPanel(FlowLayout())
        val sep8 = JSeparator(SwingConstants.VERTICAL)
        sep8.setPreferredSize(Dimension(5, 50)) // Thicker width
        sep8.setBackground(Color.BLACK)
        verticalPanel2.add(sep8)
        add(verticalPanel2)

        // Example 9: JSeparator with custom border
        add(JLabel("9. JSeparator with custom border:"))
        val sep9 = JSeparator()
        sep9.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2))
        add(sep9)

        // Example 10: JSeparator used to separate components
        add(JLabel("10. JSeparator separating components:"))
        val sepPanel = JPanel(BorderLayout())
        sepPanel.add(JLabel("Above"), BorderLayout.NORTH)
        sepPanel.add(JSeparator(), BorderLayout.CENTER)
        sepPanel.add(JLabel("Below"), BorderLayout.SOUTH)
        add(sepPanel)

        // Note: JSeparator is primarily for visual separation; limited interactive configurations.
    }
}
