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

internal class JToggleButtonExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JToggleButton without text
        add(JLabel("1. Default JToggleButton without text:"))
        val toggle1 = JToggleButton()
        toggle1.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Default ToggleButton state changed to: " + toggle1.isSelected()
            )
        })
        add(toggle1)

        // Example 2: JToggleButton with text
        add(JLabel("2. JToggleButton with text:"))
        val toggle2 = JToggleButton("Toggle Me")
        toggle2.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "ToggleButton with text state changed to: " + toggle2.isSelected()
            )
        })
        add(toggle2)

        // Example 3: JToggleButton selected by default
        add(JLabel("3. JToggleButton selected by default:"))
        val toggle3 = JToggleButton("Selected ToggleButton", true)
        toggle3.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Selected ToggleButton state changed to: " + toggle3.isSelected()
            )
        })
        add(toggle3)

        // Example 4: Disabled JToggleButton
        add(JLabel("4. Disabled JToggleButton:"))
        val toggle4 = JToggleButton("Disabled ToggleButton")
        toggle4.setEnabled(false)
        add(toggle4)

        // Example 5: JToggleButton with mnemonic (keyboard shortcut, Alt + T)
        add(JLabel("5. JToggleButton with mnemonic (Alt + T):"))
        val toggle5 = JToggleButton("Toggle with Mnemonic")
        toggle5.setMnemonic(KeyEvent.VK_T)
        toggle5.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "ToggleButton with mnemonic state changed to: " + toggle5.isSelected()
            )
        })
        add(toggle5)

        // Example 6: JToggleButton with tooltip
        add(JLabel("6. JToggleButton with tooltip (hover to see):"))
        val toggle6 = JToggleButton("ToggleButton with Tooltip")
        toggle6.setToolTipText("This is a tooltip!")
        toggle6.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "ToggleButton with tooltip state changed to: " + toggle6.isSelected()
            )
        })
        add(toggle6)

        // Example 7: JToggleButton with custom background and foreground
        add(JLabel("7. JToggleButton with custom colors:"))
        val toggle7 = JToggleButton("Colored ToggleButton")
        toggle7.setBackground(Color.BLUE)
        toggle7.setForeground(Color.WHITE)
        toggle7.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Colored ToggleButton state changed to: " + toggle7.isSelected()
            )
        })
        add(toggle7)

        // Example 8: JToggleButton without border painted
        add(JLabel("8. JToggleButton without border:"))
        val toggle8 = JToggleButton("No Border ToggleButton")
        toggle8.setBorderPainted(false)
        toggle8.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "No Border ToggleButton state changed to: " + toggle8.isSelected()
            )
        })
        add(toggle8)

        // Example 9: JToggleButton without content area filled
        add(JLabel("9. JToggleButton without content fill:"))
        val toggle9 = JToggleButton("Transparent Content ToggleButton")
        toggle9.setContentAreaFilled(false)
        toggle9.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Transparent Content ToggleButton state changed to: " + toggle9.isSelected()
            )
        })
        add(toggle9)

        // Example 10: JToggleButton with left-aligned text
        add(JLabel("10. JToggleButton with left-aligned text:"))
        val toggle10 = JToggleButton("Left Aligned ToggleButton")
        toggle10.setHorizontalAlignment(SwingConstants.LEFT)
        toggle10.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Left Aligned ToggleButton state changed to: " + toggle10.isSelected()
            )
        })
        add(toggle10)

        // Example 11: JToggleButtons in a ButtonGroup (mutually exclusive like radio buttons)
        add(JLabel("11. JToggleButtons in a ButtonGroup:"))
        val groupPanel = JPanel(FlowLayout())
        val group = ButtonGroup()
        val toggle11a = JToggleButton("Option A", true)
        toggle11a.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Option A selected"
            )
        })
        group.add(toggle11a)
        groupPanel.add(toggle11a)
        val toggle11b = JToggleButton("Option B")
        toggle11b.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Option B selected"
            )
        })
        group.add(toggle11b)
        groupPanel.add(toggle11b)
        add(groupPanel)

        // Note: For icons, you would use setIcon(new ImageIcon("path/to/icon.png")), setSelectedIcon, etc.
        // But since no images are provided, omitting icon examples here. You can add them similarly.

        // To make it scrollable if many examples
        // But for now, simple layout
    }
}
