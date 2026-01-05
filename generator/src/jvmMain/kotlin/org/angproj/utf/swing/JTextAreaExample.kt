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
import java.awt.Font
import java.awt.GridLayout
import javax.swing.*

internal class JTextAreaExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JTextArea (empty)
        add(JLabel("1. Default JTextArea (empty):"))
        val area1 = JTextArea()
        area1.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area1))

        // Example 2: JTextArea with initial text
        add(JLabel("2. JTextArea with initial text:"))
        val area2 = JTextArea("This is initial text.\nLine two.")
        area2.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area2))

        // Example 3: Non-editable JTextArea
        add(JLabel("3. Non-editable JTextArea:"))
        val area3 = JTextArea("This text is not editable.")
        area3.setEditable(false)
        area3.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area3))

        // Example 4: Disabled JTextArea
        add(JLabel("4. Disabled JTextArea:"))
        val area4 = JTextArea("This is disabled.")
        area4.setEnabled(false)
        area4.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area4))

        // Example 5: JTextArea with line wrap
        add(JLabel("5. JTextArea with line wrap:"))
        val area5 = JTextArea("This text will wrap at the edge of the component without word boundaries.")
        area5.setLineWrap(true)
        area5.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area5))

        // Example 6: JTextArea with word wrap
        add(JLabel("6. JTextArea with word wrap:"))
        val area6 = JTextArea("This text will wrap at word boundaries when it reaches the edge.")
        area6.setLineWrap(true)
        area6.setWrapStyleWord(true)
        area6.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area6))

        // Example 7: JTextArea with rows and columns
        add(JLabel("7. JTextArea with rows (3) and columns (20):"))
        val area7 = JTextArea(3, 20)
        add(JScrollPane(area7))

        // Example 8: JTextArea with custom tab size
        add(JLabel("8. JTextArea with custom tab size (4):"))
        val area8 = JTextArea("Tab\tsize\tset\tto\t4.")
        area8.setTabSize(4)
        area8.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area8))

        // Example 9: JTextArea with tooltip
        add(JLabel("9. JTextArea with tooltip (hover to see):"))
        val area9 = JTextArea("Hover me.")
        area9.setToolTipText("This is a tooltip!")
        area9.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area9))

        // Example 10: JTextArea with custom background and foreground
        add(JLabel("10. JTextArea with custom colors:"))
        val area10 = JTextArea("Colored text area.")
        area10.setBackground(Color.YELLOW)
        area10.setForeground(Color.RED)
        area10.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area10))

        // Example 11: JTextArea with custom font
        add(JLabel("11. JTextArea with custom font (bold, size 14):"))
        val area11 = JTextArea("Custom font.")
        area11.setFont(Font("Serif", Font.BOLD, 14))
        area11.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area11))

        // Example 12: JTextArea with caret color
        add(JLabel("12. JTextArea with caret color (red):"))
        val area12 = JTextArea("Type here.")
        area12.setCaretColor(Color.RED)
        area12.setPreferredSize(Dimension(300, 50))
        add(JScrollPane(area12))

        // Note: For document listeners, e.g., area.getDocument().addDocumentListener(...); but omitted for static demo.
    }
}
