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

internal class JCheckBoxExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JCheckBox without text
        add(JLabel("1. Default JCheckBox without text:"))
        val checkBox1 = JCheckBox()
        checkBox1.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Default CheckBox state changed to: " + checkBox1.isSelected()
            )
        })
        add(checkBox1)

        // Example 2: JCheckBox with text
        add(JLabel("2. JCheckBox with text:"))
        val checkBox2 = JCheckBox("Check Me")
        checkBox2.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "CheckBox with text state changed to: " + checkBox2.isSelected()
            )
        })
        add(checkBox2)

        // Example 3: JCheckBox selected by default
        add(JLabel("3. JCheckBox selected by default:"))
        val checkBox3 = JCheckBox("Selected CheckBox", true)
        checkBox3.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Selected CheckBox state changed to: " + checkBox3.isSelected()
            )
        })
        add(checkBox3)

        // Example 4: Disabled JCheckBox
        add(JLabel("4. Disabled JCheckBox:"))
        val checkBox4 = JCheckBox("Disabled CheckBox")
        checkBox4.setEnabled(false)
        add(checkBox4)

        // Example 5: JCheckBox with mnemonic (keyboard shortcut)
        add(JLabel("5. JCheckBox with mnemonic (Alt + C):"))
        val checkBox5 = JCheckBox("Check with Mnemonic")
        checkBox5.setMnemonic(KeyEvent.VK_C)
        checkBox5.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "CheckBox with mnemonic state changed to: " + checkBox5.isSelected()
            )
        })
        add(checkBox5)

        // Example 6: JCheckBox with tooltip
        add(JLabel("6. JCheckBox with tooltip (hover to see):"))
        val checkBox6 = JCheckBox("CheckBox with Tooltip")
        checkBox6.setToolTipText("This is a tooltip!")
        checkBox6.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "CheckBox with tooltip state changed to: " + checkBox6.isSelected()
            )
        })
        add(checkBox6)

        // Example 7: JCheckBox with custom background and foreground
        add(JLabel("7. JCheckBox with custom colors:"))
        val checkBox7 = JCheckBox("Colored CheckBox")
        checkBox7.setBackground(Color.YELLOW)
        checkBox7.setForeground(Color.RED)
        checkBox7.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Colored CheckBox state changed to: " + checkBox7.isSelected()
            )
        })
        add(checkBox7)

        // Example 8: JCheckBox without border painted
        add(JLabel("8. JCheckBox without border:"))
        val checkBox8 = JCheckBox("No Border CheckBox")
        checkBox8.setBorderPainted(false)
        checkBox8.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "No Border CheckBox state changed to: " + checkBox8.isSelected()
            )
        })
        add(checkBox8)

        // Example 9: JCheckBox with flat border (border painted flat)
        add(JLabel("9. JCheckBox with flat border:"))
        val checkBox9 = JCheckBox("Flat Border CheckBox")
        checkBox9.setBorderPaintedFlat(true)
        checkBox9.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Flat Border CheckBox state changed to: " + checkBox9.isSelected()
            )
        })
        add(checkBox9)

        // Example 10: JCheckBox without content area filled
        add(JLabel("10. JCheckBox without content fill:"))
        val checkBox10 = JCheckBox("Transparent Content CheckBox")
        checkBox10.setContentAreaFilled(false)
        checkBox10.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Transparent Content CheckBox state changed to: " + checkBox10.isSelected()
            )
        })
        add(checkBox10)

        // Example 11: JCheckBox with left-aligned text
        add(JLabel("11. JCheckBox with left-aligned text:"))
        val checkBox11 = JCheckBox("Left Aligned CheckBox")
        checkBox11.setHorizontalAlignment(SwingConstants.LEFT)
        checkBox11.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Left Aligned CheckBox state changed to: " + checkBox11.isSelected()
            )
        })
        add(checkBox11)

        // Note: For icons, you would use setIcon(new ImageIcon("path/to/icon.png")), setSelectedIcon, etc.
        // But since no images are provided, omitting icon examples here. You can add them similarly.

        // To make it scrollable if many examples
        // But for now, simple layout
    }
}
