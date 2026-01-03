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
import java.awt.event.KeyEvent
import javax.swing.*

internal class JCheckBoxMenuItemExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Note: JCheckBoxMenuItem is typically used in menus, but for demonstration, we're adding them directly to the panel.

        // Example 1: Default JCheckBoxMenuItem without text
        add(JLabel("1. Default JCheckBoxMenuItem without text:"))
        val item1 = JCheckBoxMenuItem()
        item1.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Default CheckBoxMenuItem state changed to: " + item1.isSelected()
            )
        })
        add(item1)

        // Example 2: JCheckBoxMenuItem with text
        add(JLabel("2. JCheckBoxMenuItem with text:"))
        val item2 = JCheckBoxMenuItem("Check Me")
        item2.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "CheckBoxMenuItem with text state changed to: " + item2.isSelected()
            )
        })
        add(item2)

        // Example 3: JCheckBoxMenuItem selected by default
        add(JLabel("3. JCheckBoxMenuItem selected by default:"))
        val item3 = JCheckBoxMenuItem("Selected CheckBoxMenuItem", true)
        item3.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Selected CheckBoxMenuItem state changed to: " + item3.isSelected()
            )
        })
        add(item3)

        // Example 4: Disabled JCheckBoxMenuItem
        add(JLabel("4. Disabled JCheckBoxMenuItem:"))
        val item4 = JCheckBoxMenuItem("Disabled CheckBoxMenuItem")
        item4.setEnabled(false)
        add(item4)

        // Example 5: JCheckBoxMenuItem with mnemonic (keyboard shortcut)
        add(JLabel("5. JCheckBoxMenuItem with mnemonic (Alt + C):"))
        val item5 = JCheckBoxMenuItem("Check with Mnemonic")
        item5.setMnemonic(KeyEvent.VK_C)
        item5.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "CheckBoxMenuItem with mnemonic state changed to: " + item5.isSelected()
            )
        })
        add(item5)

        // Example 6: JCheckBoxMenuItem with tooltip
        add(JLabel("6. JCheckBoxMenuItem with tooltip (hover to see):"))
        val item6 = JCheckBoxMenuItem("CheckBoxMenuItem with Tooltip")
        item6.setToolTipText("This is a tooltip!")
        item6.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "CheckBoxMenuItem with tooltip state changed to: " + item6.isSelected()
            )
        })
        add(item6)

        // Example 7: JCheckBoxMenuItem with custom background and foreground
        add(JLabel("7. JCheckBoxMenuItem with custom colors:"))
        val item7 = JCheckBoxMenuItem("Colored CheckBoxMenuItem")
        item7.setBackground(Color.YELLOW)
        item7.setForeground(Color.RED)
        item7.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Colored CheckBoxMenuItem state changed to: " + item7.isSelected()
            )
        })
        add(item7)

        // Example 8: JCheckBoxMenuItem without border painted
        add(JLabel("8. JCheckBoxMenuItem without border:"))
        val item8 = JCheckBoxMenuItem("No Border CheckBoxMenuItem")
        item8.setBorderPainted(false)
        item8.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "No Border CheckBoxMenuItem state changed to: " + item8.isSelected()
            )
        })
        add(item8)

        // ?
        // Example 9: JCheckBoxMenuItem with flat border
        add(JLabel("9. JCheckBoxMenuItem with flat border:"))
        val item9 = JCheckBoxMenuItem("Flat Border CheckBoxMenuItem")
        item9.setBorderPainted(true)
        //item9.setBorderPaintedFlat(true);
        item9.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Flat Border CheckBoxMenuItem state changed to: " + item9.isSelected()
            )
        })
        add(item9)

        // Example 10: JCheckBoxMenuItem without content area filled
        add(JLabel("10. JCheckBoxMenuItem without content fill:"))
        val item10 = JCheckBoxMenuItem("Transparent Content CheckBoxMenuItem")
        item10.setContentAreaFilled(false)
        item10.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Transparent Content CheckBoxMenuItem state changed to: " + item10.isSelected()
            )
        })
        add(item10)

        // Example 11: JCheckBoxMenuItem with left-aligned text
        add(JLabel("11. JCheckBoxMenuItem with left-aligned text:"))
        val item11 = JCheckBoxMenuItem("Left Aligned CheckBoxMenuItem")
        item11.setHorizontalAlignment(SwingConstants.LEFT)
        item11.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Left Aligned CheckBoxMenuItem state changed to: " + item11.isSelected()
            )
        })
        add(item11)

        // Example 12: JCheckBoxMenuItem with accelerator (Ctrl + A)
        add(JLabel("12. JCheckBoxMenuItem with accelerator (Ctrl + A):"))
        val item12 = JCheckBoxMenuItem("Check with Accelerator")
        item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK))
        item12.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "CheckBoxMenuItem with accelerator state changed to: " + item12.isSelected()
            )
        })
        add(item12)

        // Note: For icons, you would use setIcon(new ImageIcon("path/to/icon.png")), setSelectedIcon, etc.
        // But since no images are provided, omitting icon examples here. You can add them similarly.

        // To make it scrollable if many examples
        // But for now, simple layout
    }
}
