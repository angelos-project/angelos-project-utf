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
import javax.swing.JTabbedPane

internal class JTabbedPaneExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Helper components for tabs
        val panel1 = JPanel()
        panel1.add(JLabel("Tab 1 Content"))
        val panel2 = JPanel()
        panel2.add(JLabel("Tab 2 Content"))
        val panel3 = JPanel()
        panel3.add(JLabel("Tab 3 Content"))

        // Example 1: Default JTabbedPane (top tabs, wrap layout)
        add(JLabel("1. Default JTabbedPane (top tabs, wrap layout):"))
        val tabs1 = JTabbedPane()
        tabs1.addTab("Tab 1", panel1)
        tabs1.addTab("Tab 2", panel2)
        tabs1.setPreferredSize(Dimension(300, 100))
        add(tabs1)

        // Example 2: JTabbedPane with tabs on bottom
        add(JLabel("2. JTabbedPane with tabs on bottom:"))
        val tabs2 = JTabbedPane(JTabbedPane.BOTTOM)
        tabs2.addTab("Tab 1", panel1)
        tabs2.addTab("Tab 2", panel2)
        tabs2.setPreferredSize(Dimension(300, 100))
        add(tabs2)

        // Example 3: JTabbedPane with tabs on left
        add(JLabel("3. JTabbedPane with tabs on left:"))
        val tabs3 = JTabbedPane(JTabbedPane.LEFT)
        tabs3.addTab("Tab 1", panel1)
        tabs3.addTab("Tab 2", panel2)
        tabs3.setPreferredSize(Dimension(300, 150))
        add(tabs3)

        // Example 4: JTabbedPane with tabs on right
        add(JLabel("4. JTabbedPane with tabs on right:"))
        val tabs4 = JTabbedPane(JTabbedPane.RIGHT)
        tabs4.addTab("Tab 1", panel1)
        tabs4.addTab("Tab 2", panel2)
        tabs4.setPreferredSize(Dimension(300, 150))
        add(tabs4)

        // Example 5: JTabbedPane with scroll tab layout
        add(JLabel("5. JTabbedPane with scroll tab layout:"))
        val tabs5 = JTabbedPane()
        tabs5.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT)
        for (i in 1..10) { // Many tabs to show scrolling
            tabs5.addTab("Tab " + i, JPanel().add(JLabel("Content " + i)))
        }
        tabs5.setPreferredSize(Dimension(300, 100))
        add(tabs5)

        // Example 6: JTabbedPane with wrap tab layout (default, but explicit)
        add(JLabel("6. JTabbedPane with wrap tab layout:"))
        val tabs6 = JTabbedPane()
        tabs6.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT)
        tabs6.addTab("Tab 1", panel1)
        tabs6.addTab("Tab 2", panel2)
        tabs6.setPreferredSize(Dimension(300, 100))
        add(tabs6)

        // Example 7: JTabbedPane with disabled tab
        add(JLabel("7. JTabbedPane with disabled tab:"))
        val tabs7 = JTabbedPane()
        tabs7.addTab("Tab 1", panel1)
        tabs7.addTab("Disabled Tab", panel2)
        tabs7.setEnabledAt(1, false)
        tabs7.setPreferredSize(Dimension(300, 100))
        add(tabs7)

        // Example 8: JTabbedPane with tooltip on tab
        add(JLabel("8. JTabbedPane with tooltip on tab (hover Tab 1):"))
        val tabs8 = JTabbedPane()
        tabs8.addTab("Tab 1", panel1)
        tabs8.setToolTipTextAt(0, "This is a tooltip!")
        tabs8.addTab("Tab 2", panel2)
        tabs8.setPreferredSize(Dimension(300, 100))
        add(tabs8)

        // Example 9: JTabbedPane with mnemonic on tab (Alt + 1 for Tab 1)
        add(JLabel("9. JTabbedPane with mnemonic on tab (Alt + 1):"))
        val tabs9 = JTabbedPane()
        tabs9.addTab("Tab 1", panel1)
        tabs9.setMnemonicAt(0, KeyEvent.VK_1)
        tabs9.addTab("Tab 2", panel2)
        tabs9.setPreferredSize(Dimension(300, 100))
        add(tabs9)

        // Example 10: JTabbedPane with custom tab color
        add(JLabel("10. JTabbedPane with custom tab color (red background for Tab 1):"))
        val tabs10 = JTabbedPane()
        tabs10.addTab("Tab 1", panel1)
        tabs10.setBackgroundAt(0, Color.RED)
        tabs10.addTab("Tab 2", panel2)
        tabs10.setPreferredSize(Dimension(300, 100))
        add(tabs10)

        // Example 11: JTabbedPane with selected tab (Tab 2 selected)
        add(JLabel("11. JTabbedPane with selected tab (Tab 2):"))
        val tabs11 = JTabbedPane()
        tabs11.addTab("Tab 1", panel1)
        tabs11.addTab("Tab 2", panel2)
        tabs11.setSelectedIndex(1)
        tabs11.setPreferredSize(Dimension(300, 100))
        add(tabs11)

        // Note: For icons on tabs, use setIconAt(index, new ImageIcon("path")); omitted since no images.
    }
}
