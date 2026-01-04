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
import javax.swing.*

internal class JScrollPaneExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JScrollPane (AS_NEEDED policies)
        add(JLabel("1. Default JScrollPane (AS_NEEDED policies):"))
        val scroll1 = JScrollPane(createTextArea())
        scroll1.setPreferredSize(Dimension(300, 100))
        add(scroll1)

        // Example 2: JScrollPane with ALWAYS horizontal scrollbar
        add(JLabel("2. JScrollPane with ALWAYS horizontal scrollbar:"))
        val scroll2 = JScrollPane(createTextArea())
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS)
        scroll2.setPreferredSize(Dimension(300, 100))
        add(scroll2)

        // Example 3: JScrollPane with ALWAYS vertical scrollbar
        add(JLabel("3. JScrollPane with ALWAYS vertical scrollbar:"))
        val scroll3 = JScrollPane(createTextArea())
        scroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS)
        scroll3.setPreferredSize(Dimension(300, 100))
        add(scroll3)

        // Example 4: JScrollPane with NEVER scrollbars
        add(JLabel("4. JScrollPane with NEVER scrollbars:"))
        val scroll4 = JScrollPane(createTextArea())
        scroll4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER)
        scroll4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER)
        scroll4.setPreferredSize(Dimension(300, 100))
        add(scroll4)

        // Example 5: JScrollPane with column header
        add(JLabel("5. JScrollPane with column header:"))
        val scroll5 = JScrollPane(createTextArea())
        scroll5.setColumnHeaderView(JLabel("Column Header"))
        scroll5.setPreferredSize(Dimension(300, 100))
        add(scroll5)

        // Example 6: JScrollPane with row header
        add(JLabel("6. JScrollPane with row header:"))
        val scroll6 = JScrollPane(createTextArea())
        scroll6.setRowHeaderView(JLabel("Row Header"))
        scroll6.setPreferredSize(Dimension(300, 100))
        add(scroll6)

        // Example 7: JScrollPane with corner component (lower left)
        add(JLabel("7. JScrollPane with corner component (lower left):"))
        val scroll7 = JScrollPane(createTextArea())
        scroll7.setCorner(JScrollPane.LOWER_LEFT_CORNER, JButton("Corner"))
        scroll7.setPreferredSize(Dimension(300, 100))
        add(scroll7)

        // Example 8: Disabled JScrollPane
        add(JLabel("8. Disabled JScrollPane:"))
        val scroll8 = JScrollPane(createTextArea())
        scroll8.setEnabled(false)
        scroll8.setPreferredSize(Dimension(300, 100))
        add(scroll8)

        // Example 9: JScrollPane with tooltip
        add(JLabel("9. JScrollPane with tooltip (hover to see):"))
        val scroll9 = JScrollPane(createTextArea())
        scroll9.setToolTipText("This is a tooltip!")
        scroll9.setPreferredSize(Dimension(300, 100))
        add(scroll9)

        // Example 10: JScrollPane with custom border
        add(JLabel("10. JScrollPane with custom border:"))
        val scroll10 = JScrollPane(createTextArea())
        scroll10.setBorder(BorderFactory.createLineBorder(Color.RED, 2))
        scroll10.setPreferredSize(Dimension(300, 100))
        add(scroll10)

        // Example 11: JScrollPane with wheel scrolling disabled
        add(JLabel("11. JScrollPane with wheel scrolling disabled:"))
        val scroll11 = JScrollPane(createTextArea())
        scroll11.setWheelScrollingEnabled(false)
        scroll11.setPreferredSize(Dimension(300, 100))
        add(scroll11)

        // Example 12: JScrollPane with custom viewport
        add(JLabel("12. JScrollPane with custom viewport:"))
        val viewport = JViewport()
        viewport.setView(createTextArea())
        val scroll12 = JScrollPane()
        scroll12.setViewport(viewport)
        scroll12.setPreferredSize(Dimension(300, 100))
        add(scroll12)

        // Note: Additional configurations like setViewportBorder, but basics covered.
    }

    // Helper method to create scrollable content (e.g., large JTextArea)
    fun createTextArea(): JTextArea {
        val area = JTextArea()
        for (i in 0..49) {
            area.append("Line " + i + "\n")
        }
        return area
    }
}
