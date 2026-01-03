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
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.KeyEvent
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants

internal class JLabelExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JLabel (empty)
        add(JLabel("1. Default JLabel (empty):"))
        val label1 = JLabel()
        add(label1)

        // Example 2: JLabel with text
        add(JLabel("2. JLabel with text:"))
        val label2 = JLabel("This is a label with text.")
        add(label2)

        // Example 3: Disabled JLabel
        add(JLabel("3. Disabled JLabel:"))
        val label3 = JLabel("This label is disabled.")
        label3.setEnabled(false)
        add(label3)

        // Example 4: JLabel with tooltip
        add(JLabel("4. JLabel with tooltip (hover to see):"))
        val label4 = JLabel("Label with Tooltip")
        label4.setToolTipText("This is a tooltip!")
        add(label4)

        // Example 5: JLabel with custom foreground and background
        add(JLabel("5. JLabel with custom colors:"))
        val label5 = JLabel("Colored Label")
        label5.setForeground(Color.RED)
        label5.setBackground(Color.YELLOW)
        label5.setOpaque(true) // Needed for background to show
        add(label5)

        // Example 6: JLabel with horizontal alignment (left)
        add(JLabel("6. JLabel with left horizontal alignment:"))
        val label6 = JLabel("Left Aligned")
        label6.setHorizontalAlignment(SwingConstants.LEFT)
        label6.setPreferredSize(Dimension(200, 30))
        label6.setBorder(BorderFactory.createLineBorder(Color.BLACK)) // To visualize
        add(label6)

        // Example 7: JLabel with vertical alignment (top)
        add(JLabel("7. JLabel with top vertical alignment:"))
        val label7 = JLabel("Top Aligned")
        label7.setVerticalAlignment(SwingConstants.TOP)
        label7.setPreferredSize(Dimension(200, 50))
        label7.setBorder(BorderFactory.createLineBorder(Color.BLACK)) // To visualize
        add(label7)

        // Example 8: JLabel with mnemonic (keyboard shortcut, Alt + L)
        add(JLabel("8. JLabel with mnemonic (Alt + L):"))
        val label8 = JLabel("Label with Mnemonic")
        label8.setDisplayedMnemonic(KeyEvent.VK_L)
        add(label8)

        // Example 9: JLabel with text and icon position (text below icon)
        add(JLabel("9. JLabel with text below (no icon for demo):"))
        val label9 = JLabel("Text Below")
        label9.setVerticalTextPosition(SwingConstants.BOTTOM)
        label9.setHorizontalTextPosition(SwingConstants.CENTER)
        // For icon: label9.setIcon(new ImageIcon("path/to/icon.png"));
        add(label9)

        // Example 10: JLabel with HTML text
        add(JLabel("10. JLabel with HTML text:"))
        val label10 = JLabel("<html><b>Bold</b> and <i>Italic</i> Text</html>")
        add(label10)

        // Note: For icons, use setIcon(new ImageIcon("path/to/icon.png")); omitted since no images.
        // Additional: setBorder, setFont, etc., but covered basics.
    }
}
