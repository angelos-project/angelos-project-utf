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
import java.awt.ComponentOrientation
import java.awt.Dimension
import java.awt.GridLayout
import javax.swing.*

internal class JProgressBarExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JProgressBar (horizontal, determinate, 0-100)
        add(JLabel("1. Default JProgressBar (horizontal, determinate, 0-100):"))
        val bar1 = JProgressBar()
        add(bar1)

        // Example 2: Indeterminate JProgressBar
        add(JLabel("2. Indeterminate JProgressBar:"))
        val bar2 = JProgressBar()
        bar2.setIndeterminate(true)
        add(bar2)

        // Example 3: Vertical JProgressBar
        add(JLabel("3. Vertical JProgressBar:"))
        val bar3 = JProgressBar(SwingConstants.VERTICAL)
        bar3.setValue(50)
        bar3.setPreferredSize(Dimension(20, 100)) // To visualize
        add(bar3)

        // Example 4: JProgressBar with string painted
        add(JLabel("4. JProgressBar with string painted:"))
        val bar4 = JProgressBar()
        bar4.setValue(75)
        bar4.setStringPainted(true)
        add(bar4)

        // Example 5: JProgressBar with custom string
        add(JLabel("5. JProgressBar with custom string:"))
        val bar5 = JProgressBar()
        bar5.setValue(25)
        bar5.setStringPainted(true)
        bar5.setString("Loading...")
        add(bar5)

        // Example 6: JProgressBar without border painted
        add(JLabel("6. JProgressBar without border painted:"))
        val bar6 = JProgressBar()
        bar6.setValue(50)
        bar6.setBorderPainted(false)
        add(bar6)

        // Example 7: Disabled JProgressBar
        add(JLabel("7. Disabled JProgressBar:"))
        val bar7 = JProgressBar()
        bar7.setValue(50)
        bar7.setEnabled(false)
        add(bar7)

        // Example 8: JProgressBar with tooltip
        add(JLabel("8. JProgressBar with tooltip (hover to see):"))
        val bar8 = JProgressBar()
        bar8.setValue(50)
        bar8.setToolTipText("This is a tooltip!")
        add(bar8)

        // Example 9: JProgressBar with custom min/max (0-200)
        add(JLabel("9. JProgressBar with custom min/max (0-200):"))
        val bar9 = JProgressBar(0, 200)
        bar9.setValue(100)
        add(bar9)

        // Example 10: JProgressBar with custom foreground and background
        add(JLabel("10. JProgressBar with custom colors:"))
        val bar10 = JProgressBar()
        bar10.setValue(50)
        bar10.setForeground(Color.GREEN)
        bar10.setBackground(Color.BLACK)
        add(bar10)

        // Example 11: Right-to-left JProgressBar
        add(JLabel("11. Right-to-left JProgressBar:"))
        val bar11 = JProgressBar()
        bar11.setValue(50)
        bar11.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT)
        add(bar11)

        // Note: For dynamic progress, you can use SwingWorker or Timer, but for static demo, values are set.
        // Indeterminate bars will animate automatically.
    }
}
