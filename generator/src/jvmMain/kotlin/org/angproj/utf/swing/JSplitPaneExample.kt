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
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JSplitPane

internal class JSplitPaneExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Helper components for splits
        val left = JPanel()
        left.add(JLabel("Left/Top"))
        left.setBackground(Color.LIGHT_GRAY)
        val right = JPanel()
        right.add(JLabel("Right/Bottom"))
        right.setBackground(Color.WHITE)

        // Example 1: Default JSplitPane (horizontal split)
        add(JLabel("1. Default JSplitPane (horizontal split):"))
        val split1 = JSplitPane()
        split1.setLeftComponent(left)
        split1.setRightComponent(right)
        split1.setPreferredSize(Dimension(300, 100))
        add(split1)

        // Example 2: Vertical JSplitPane
        add(JLabel("2. Vertical JSplitPane:"))
        val split2 = JSplitPane(JSplitPane.VERTICAL_SPLIT)
        split2.setTopComponent(left)
        split2.setBottomComponent(right)
        split2.setPreferredSize(Dimension(300, 150))
        add(split2)

        // Example 3: JSplitPane with continuous layout
        add(JLabel("3. JSplitPane with continuous layout:"))
        val split3 = JSplitPane()
        split3.setContinuousLayout(true)
        split3.setLeftComponent(left)
        split3.setRightComponent(right)
        split3.setPreferredSize(Dimension(300, 100))
        add(split3)

        // Example 4: JSplitPane with one-touch expandable
        add(JLabel("4. JSplitPane with one-touch expandable:"))
        val split4 = JSplitPane()
        split4.setOneTouchExpandable(true)
        split4.setLeftComponent(left)
        split4.setRightComponent(right)
        split4.setPreferredSize(Dimension(300, 100))
        add(split4)

        // Example 5: JSplitPane with custom divider size
        add(JLabel("5. JSplitPane with custom divider size (10):"))
        val split5 = JSplitPane()
        split5.setDividerSize(10)
        split5.setLeftComponent(left)
        split5.setRightComponent(right)
        split5.setPreferredSize(Dimension(300, 100))
        add(split5)

        // Example 6: JSplitPane with custom divider location
        add(JLabel("6. JSplitPane with custom divider location (100):"))
        val split6 = JSplitPane()
        split6.setLeftComponent(left)
        split6.setRightComponent(right)
        split6.setDividerLocation(100)
        split6.setPreferredSize(Dimension(300, 100))
        add(split6)

        // Example 7: JSplitPane with resize weight (0.3)
        add(JLabel("7. JSplitPane with resize weight (0.3):"))
        val split7 = JSplitPane()
        split7.setResizeWeight(0.3)
        split7.setLeftComponent(left)
        split7.setRightComponent(right)
        split7.setPreferredSize(Dimension(300, 100))
        add(split7)

        // Example 8: Disabled JSplitPane
        add(JLabel("8. Disabled JSplitPane:"))
        val split8 = JSplitPane()
        split8.setEnabled(false)
        split8.setLeftComponent(left)
        split8.setRightComponent(right)
        split8.setPreferredSize(Dimension(300, 100))
        add(split8)

        // Example 9: JSplitPane with tooltip
        add(JLabel("9. JSplitPane with tooltip (hover to see):"))
        val split9 = JSplitPane()
        split9.setToolTipText("This is a tooltip!")
        split9.setLeftComponent(left)
        split9.setRightComponent(right)
        split9.setPreferredSize(Dimension(300, 100))
        add(split9)

        // Example 10: JSplitPane with custom border
        add(JLabel("10. JSplitPane with custom border:"))
        val split10 = JSplitPane()
        split10.setBorder(BorderFactory.createLineBorder(Color.RED))
        split10.setLeftComponent(left)
        split10.setRightComponent(right)
        split10.setPreferredSize(Dimension(300, 100))
        add(split10)

        // Note: JSplitPane can have nested splits, but keeping simple for examples.
    }
}
