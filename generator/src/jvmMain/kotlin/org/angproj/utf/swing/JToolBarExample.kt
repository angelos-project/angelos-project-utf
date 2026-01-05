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

import java.awt.GridLayout
import java.awt.Insets
import javax.swing.*

internal class JToolBarExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JToolBar (horizontal, floatable)
        add(JLabel("1. Default JToolBar (horizontal, floatable):"))
        val bar1 = JToolBar()
        bar1.add(JButton("Button 1"))
        bar1.add(JButton("Button 2"))
        add(bar1)

        // Example 2: Vertical JToolBar
        add(JLabel("2. Vertical JToolBar:"))
        val bar2 = JToolBar(SwingConstants.VERTICAL)
        bar2.add(JButton("Button 1"))
        bar2.add(JButton("Button 2"))
        add(bar2)

        // Example 3: Non-floatable JToolBar
        add(JLabel("3. Non-floatable JToolBar:"))
        val bar3 = JToolBar()
        bar3.setFloatable(false)
        bar3.add(JButton("Button 1"))
        bar3.add(JButton("Button 2"))
        add(bar3)

        // Example 4: JToolBar with rollover enabled
        add(JLabel("4. JToolBar with rollover enabled:"))
        val bar4 = JToolBar()
        bar4.setRollover(true)
        bar4.add(JButton("Button 1"))
        bar4.add(JButton("Button 2"))
        add(bar4)

        // Example 5: JToolBar with custom name (for accessibility)
        add(JLabel("5. JToolBar with custom name:"))
        val bar5 = JToolBar("Custom Toolbar")
        bar5.add(JButton("Button 1"))
        bar5.add(JButton("Button 2"))
        add(bar5)

        // Example 6: JToolBar with border painted
        add(JLabel("6. JToolBar with border painted:"))
        val bar6 = JToolBar()
        bar6.setBorderPainted(true) // Default true, but explicit
        bar6.add(JButton("Button 1"))
        bar6.add(JButton("Button 2"))
        add(bar6)

        // Example 7: JToolBar without border painted
        add(JLabel("7. JToolBar without border painted:"))
        val bar7 = JToolBar()
        bar7.setBorderPainted(false)
        bar7.add(JButton("Button 1"))
        bar7.add(JButton("Button 2"))
        add(bar7)

        // Example 8: JToolBar with separator
        add(JLabel("8. JToolBar with separator:"))
        val bar8 = JToolBar()
        bar8.add(JButton("Button 1"))
        bar8.addSeparator()
        bar8.add(JButton("Button 2"))
        add(bar8)

        // Example 9: JToolBar with custom margin
        add(JLabel("9. JToolBar with custom margin:"))
        val bar9 = JToolBar()
        bar9.setMargin(Insets(5, 5, 5, 5))
        bar9.add(JButton("Button 1"))
        bar9.add(JButton("Button 2"))
        add(bar9)

        // Example 10: JToolBar with tooltip
        add(JLabel("10. JToolBar with tooltip (hover to see):"))
        val bar10 = JToolBar()
        bar10.setToolTipText("This is a tooltip!")
        bar10.add(JButton("Button 1"))
        bar10.add(JButton("Button 2"))
        add(bar10)

        // Example 11: Disabled JToolBar
        add(JLabel("11. Disabled JToolBar:"))
        val bar11 = JToolBar()
        bar11.setEnabled(false)
        bar11.add(JButton("Button 1"))
        bar11.add(JButton("Button 2"))
        add(bar11)

        // Example 12: JToolBar with custom orientation and floatable false
        add(JLabel("12. JToolBar vertical, non-floatable:"))
        val bar12 = JToolBar(SwingConstants.VERTICAL)
        bar12.setFloatable(false)
        bar12.add(JButton("Button 1"))
        bar12.add(JButton("Button 2"))
        add(bar12)

        // Note: Toolbars can be added to frames, but for demo, added to panel.
        // For icons on buttons, omitted since no images.
    }
}