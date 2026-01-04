/**
 * Copyright (c) 2026 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
 *
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 *
 *      https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *      Kristoffer Paulsson - initial implementation
 */
package org.angproj.utf.swing

import java.awt.Color
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class JPopupMenuExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JPopupMenu (empty)
        add(JLabel("1. Default JPopupMenu (empty):"))
        val button1 = JButton("Show Default Popup")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.show(button1, button1.width, button1.height)
        })
        add(button1)

        // Example 2: JPopupMenu with menu items
        add(JLabel("2. JPopupMenu with menu items:"))
        val button2 = JButton("Show Popup with Items")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.add(JMenuItem("Item 1"))
            popup.add(JMenuItem("Item 2"))
            popup.show(button2, button2.width, button2.height)
        })
        add(button2)

        // Example 3: JPopupMenu with submenu
        add(JLabel("3. JPopupMenu with submenu:"))
        val button3 = JButton("Show Popup with Submenu")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            val submenu = JMenu("Submenu")
            submenu.add(JMenuItem("Sub Item 1"))
            popup.add(submenu)
            popup.show(button3, button3.width, button3.height)
        })
        add(button3)

        // Example 4: JPopupMenu with separator
        add(JLabel("4. JPopupMenu with separator:"))
        val button4 = JButton("Show Popup with Separator")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.add(JMenuItem("Item 1"))
            popup.addSeparator()
            popup.add(JMenuItem("Item 2"))
            popup.show(button4, button4.width, button4.height)
        })
        add(button4)

        // Example 5: JPopupMenu with checkbox menu item
        add(JLabel("5. JPopupMenu with checkbox menu item:"))
        val button5 = JButton("Show Popup with Checkbox")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.add(JCheckBoxMenuItem("Check Me"))
            popup.show(button5, button5.width, button5.height)
        })
        add(button5)

        // Example 6: JPopupMenu with radio button menu item
        add(JLabel("6. JPopupMenu with radio button menu item:"))
        val button6 = JButton("Show Popup with Radio Button")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.add(JRadioButtonMenuItem("Select Me"))
            popup.show(button6, button6.width, button6.height)
        })
        add(button6)

        // Example 7: JPopupMenu with tooltip
        add(JLabel("7. JPopupMenu with tooltip (hover after show):"))
        val button7 = JButton("Show Popup with Tooltip")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.setToolTipText("This is a tooltip!")
            popup.add(JMenuItem("Item 1"))
            popup.show(button7, button7.width, button7.height)
        })
        add(button7)

        // Example 8: JPopupMenu with custom border
        add(JLabel("8. JPopupMenu with custom border:"))
        val button8 = JButton("Show Popup with Custom Border")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.setBorder(BorderFactory.createLineBorder(Color.RED, 2))
            popup.add(JMenuItem("Item 1"))
            popup.show(button8, button8.width, button8.height)
        })
        add(button8)

        // Example 9: Light weight JPopupMenu
        add(JLabel("9. Light weight JPopupMenu:"))
        val button9 = JButton("Show Light Weight Popup")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.setLightWeightPopupEnabled(true) // Default
            popup.add(JMenuItem("Item 1"))
            popup.show(button9, button9.width, button9.height)
        })
        add(button9)

        // Example 10: Heavy weight JPopupMenu
        add(JLabel("10. Heavy weight JPopupMenu:"))
        val button10 = JButton("Show Heavy Weight Popup")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu()
            popup.setLightWeightPopupEnabled(false)
            popup.add(JMenuItem("Item 1"))
            popup.show(button10, button10.width, button10.height)
        })
        add(button10)

        // Example 11: JPopupMenu with label (for accessibility)
        add(JLabel("11. JPopupMenu with label:"))
        val button11 = JButton("Show Popup with Label")
        button11.addActionListener(ActionListener { e: ActionEvent? ->
            val popup = JPopupMenu("Popup Label")
            popup.add(JMenuItem("Item 1"))
            popup.show(button11, button11.width, button11.height)
        })
        add(button11)

        // Note: For icons on items, use JMenuItem with ImageIcon; omitted since no images.
        // Popups can be attached to components via component.setComponentPopupMenu(popup);
    }
}
