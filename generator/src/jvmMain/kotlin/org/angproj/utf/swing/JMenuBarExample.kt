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
import java.awt.GridLayout
import java.awt.Insets
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class JMenuBarExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Helper method to create a standard menu for demonstration
        // Each JMenuBar will have a "File" menu with an "Open" item that shows a message

        // Example 1: Default JMenuBar
        add(JLabel("1. Default JMenuBar:"))
        val bar1 = JMenuBar()
        bar1.add(createDemoMenu())
        add(bar1)

        // Example 2: JMenuBar with margin
        add(JLabel("2. JMenuBar with margin (Insets 5,5,5,5):"))
        val bar2 = JMenuBar()
        bar2.setMargin(Insets(5, 5, 5, 5))
        bar2.add(createDemoMenu())
        add(bar2)

        // Example 3: JMenuBar without border painted
        add(JLabel("3. JMenuBar without border painted:"))
        val bar3 = JMenuBar()
        bar3.setBorderPainted(false)
        bar3.add(createDemoMenu())
        add(bar3)

        // ?
        // Example 4: JMenuBar with help menu
        add(JLabel("4. JMenuBar with help menu:"))
        val bar4 = JMenuBar()
        bar4.add(createDemoMenu())
        val helpMenu = JMenu("Help")
        helpMenu.add(JMenuItem("About"))
        //bar4.setHelpMenu(helpMenu)
        add(bar4)

        // Example 5: Disabled JMenuBar
        add(JLabel("5. Disabled JMenuBar:"))
        val bar5 = JMenuBar()
        bar5.setEnabled(false)
        bar5.add(createDemoMenu())
        add(bar5)

        // Example 6: JMenuBar with custom background and foreground
        add(JLabel("6. JMenuBar with custom colors:"))
        val bar6 = JMenuBar()
        bar6.setBackground(Color.YELLOW)
        bar6.setForeground(Color.RED)
        bar6.add(createDemoMenu())
        add(bar6)

        // Example 7: JMenuBar with tooltip
        add(JLabel("7. JMenuBar with tooltip (hover to see):"))
        val bar7 = JMenuBar()
        bar7.setToolTipText("This is a tooltip!")
        bar7.add(createDemoMenu())
        add(bar7)

        // Example 8: JMenuBar with left-to-right component orientation
        add(JLabel("8. JMenuBar with left-to-right orientation:"))
        val bar8 = JMenuBar()
        bar8.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT)
        bar8.add(createDemoMenu())
        add(bar8)

        // Example 9: JMenuBar with right-to-left component orientation
        add(JLabel("9. JMenuBar with right-to-left orientation:"))
        val bar9 = JMenuBar()
        bar9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT)
        bar9.add(createDemoMenu())
        add(bar9)

        // Example 10: JMenuBar with selected menu
        add(JLabel("10. JMenuBar with selected menu:"))
        val bar10 = JMenuBar()
        val selectedMenu = createDemoMenu()
        bar10.add(selectedMenu)
        bar10.setSelected(selectedMenu)
        add(bar10)

        // Note: For more advanced features like custom selection model, you can setMenuBarSelectionModel, but keeping simple here.
    }

    private fun createDemoMenu(): JMenu {
        val menu = JMenu("File")
        val item = JMenuItem("Open")
        item.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Open selected!"
            )
        })
        menu.add(item)
        return menu
    }
}
