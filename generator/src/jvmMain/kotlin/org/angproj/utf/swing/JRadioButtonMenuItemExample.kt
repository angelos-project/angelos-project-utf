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
import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent
import javax.swing.*

internal class JRadioButtonMenuItemExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Note: JRadioButtonMenuItem is typically used in menus, but for demonstration, we're adding them directly to the panel.

        // Example 1: Default JRadioButtonMenuItem without text
        add(JLabel("1. Default JRadioButtonMenuItem without text:"))
        val item1 = JRadioButtonMenuItem()
        item1.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Default RadioButtonMenuItem state changed to: " + item1.isSelected()
            )
        })
        add(item1)

        // Example 2: JRadioButtonMenuItem with text
        add(JLabel("2. JRadioButtonMenuItem with text:"))
        val item2 = JRadioButtonMenuItem("Select Me")
        item2.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "RadioButtonMenuItem with text state changed to: " + item2.isSelected()
            )
        })
        add(item2)

        // Example 3: JRadioButtonMenuItem selected by default
        add(JLabel("3. JRadioButtonMenuItem selected by default:"))
        val item3 = JRadioButtonMenuItem("Selected RadioButtonMenuItem", true)
        item3.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Selected RadioButtonMenuItem state changed to: " + item3.isSelected()
            )
        })
        add(item3)

        // Example 4: Disabled JRadioButtonMenuItem
        add(JLabel("4. Disabled JRadioButtonMenuItem:"))
        val item4 = JRadioButtonMenuItem("Disabled RadioButtonMenuItem")
        item4.setEnabled(false)
        add(item4)

        // Example 5: JRadioButtonMenuItem with mnemonic (keyboard shortcut, Alt + S)
        add(JLabel("5. JRadioButtonMenuItem with mnemonic (Alt + S):"))
        val item5 = JRadioButtonMenuItem("Select with Mnemonic")
        item5.setMnemonic(KeyEvent.VK_S)
        item5.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "RadioButtonMenuItem with mnemonic state changed to: " + item5.isSelected()
            )
        })
        add(item5)

        // Example 6: JRadioButtonMenuItem with tooltip
        add(JLabel("6. JRadioButtonMenuItem with tooltip (hover to see):"))
        val item6 = JRadioButtonMenuItem("RadioButtonMenuItem with Tooltip")
        item6.setToolTipText("This is a tooltip!")
        item6.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "RadioButtonMenuItem with tooltip state changed to: " + item6.isSelected()
            )
        })
        add(item6)

        // Example 7: JRadioButtonMenuItem with custom background and foreground
        add(JLabel("7. JRadioButtonMenuItem with custom colors:"))
        val item7 = JRadioButtonMenuItem("Colored RadioButtonMenuItem")
        item7.setBackground(Color.YELLOW)
        item7.setForeground(Color.RED)
        item7.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Colored RadioButtonMenuItem state changed to: " + item7.isSelected()
            )
        })
        add(item7)

        // Example 8: JRadioButtonMenuItem without border painted
        add(JLabel("8. JRadioButtonMenuItem without border:"))
        val item8 = JRadioButtonMenuItem("No Border RadioButtonMenuItem")
        item8.setBorderPainted(false)
        item8.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "No Border RadioButtonMenuItem state changed to: " + item8.isSelected()
            )
        })
        add(item8)

        // ?
        // Example 9: JRadioButtonMenuItem with flat border
        add(JLabel("9. JRadioButtonMenuItem with flat border:"))
        val item9 = JRadioButtonMenuItem("Flat Border RadioButtonMenuItem")
        //item9.setBorderPaintedFlat(true);
        item9.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Flat Border RadioButtonMenuItem state changed to: " + item9.isSelected()
            )
        })
        add(item9)

        // Example 10: JRadioButtonMenuItem without content area filled
        add(JLabel("10. JRadioButtonMenuItem without content fill:"))
        val item10 = JRadioButtonMenuItem("Transparent Content RadioButtonMenuItem")
        item10.setContentAreaFilled(false)
        item10.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Transparent Content RadioButtonMenuItem state changed to: " + item10.isSelected()
            )
        })
        add(item10)

        // Example 11: JRadioButtonMenuItem with left-aligned text
        add(JLabel("11. JRadioButtonMenuItem with left-aligned text:"))
        val item11 = JRadioButtonMenuItem("Left Aligned RadioButtonMenuItem")
        item11.setHorizontalAlignment(SwingConstants.LEFT)
        item11.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Left Aligned RadioButtonMenuItem state changed to: " + item11.isSelected()
            )
        })
        add(item11)

        // Example 12: JRadioButtonMenuItem with accelerator (Ctrl + S)
        add(JLabel("12. JRadioButtonMenuItem with accelerator (Ctrl + S):"))
        val item12 = JRadioButtonMenuItem("Select with Accelerator")
        item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK))
        item12.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "RadioButtonMenuItem with accelerator state changed to: " + item12.isSelected()
            )
        })
        add(item12)

        // Example 13: JRadioButtonMenuItems in a ButtonGroup (mutually exclusive)
        add(JLabel("13. JRadioButtonMenuItems in a ButtonGroup:"))
        val groupPanel = JPanel(FlowLayout())
        val group = ButtonGroup()
        val item13a = JRadioButtonMenuItem("Option A", true)
        item13a.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Option A selected"
            )
        })
        group.add(item13a)
        groupPanel.add(item13a)
        val item13b = JRadioButtonMenuItem("Option B")
        item13b.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Option B selected"
            )
        })
        group.add(item13b)
        groupPanel.add(item13b)
        add(groupPanel)

        // Note: For icons, you would use setIcon(new ImageIcon("path/to/icon.png")), setSelectedIcon, etc.
        // But since no images are provided, omitting icon examples here. You can add them similarly.
    }
}
