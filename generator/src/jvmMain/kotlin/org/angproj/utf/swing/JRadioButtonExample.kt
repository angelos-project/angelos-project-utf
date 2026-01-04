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

internal class JRadioButtonExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JRadioButton without text
        add(JLabel("1. Default JRadioButton without text:"))
        val radio1 = JRadioButton()
        radio1.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Default RadioButton state changed to: " + radio1.isSelected()
            )
        })
        add(radio1)

        // Example 2: JRadioButton with text
        add(JLabel("2. JRadioButton with text:"))
        val radio2 = JRadioButton("Select Me")
        radio2.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "RadioButton with text state changed to: " + radio2.isSelected()
            )
        })
        add(radio2)

        // Example 3: JRadioButton selected by default
        add(JLabel("3. JRadioButton selected by default:"))
        val radio3 = JRadioButton("Selected RadioButton", true)
        radio3.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Selected RadioButton state changed to: " + radio3.isSelected()
            )
        })
        add(radio3)

        // Example 4: Disabled JRadioButton
        add(JLabel("4. Disabled JRadioButton:"))
        val radio4 = JRadioButton("Disabled RadioButton")
        radio4.setEnabled(false)
        add(radio4)

        // Example 5: JRadioButton with mnemonic (keyboard shortcut, Alt + S)
        add(JLabel("5. JRadioButton with mnemonic (Alt + S):"))
        val radio5 = JRadioButton("Select with Mnemonic")
        radio5.setMnemonic(KeyEvent.VK_S)
        radio5.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "RadioButton with mnemonic state changed to: " + radio5.isSelected()
            )
        })
        add(radio5)

        // Example 6: JRadioButton with tooltip
        add(JLabel("6. JRadioButton with tooltip (hover to see):"))
        val radio6 = JRadioButton("RadioButton with Tooltip")
        radio6.setToolTipText("This is a tooltip!")
        radio6.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "RadioButton with tooltip state changed to: " + radio6.isSelected()
            )
        })
        add(radio6)

        // Example 7: JRadioButton with custom background and foreground
        add(JLabel("7. JRadioButton with custom colors:"))
        val radio7 = JRadioButton("Colored RadioButton")
        radio7.setBackground(Color.YELLOW)
        radio7.setForeground(Color.RED)
        radio7.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Colored RadioButton state changed to: " + radio7.isSelected()
            )
        })
        add(radio7)

        // Example 8: JRadioButton without border painted
        add(JLabel("8. JRadioButton without border:"))
        val radio8 = JRadioButton("No Border RadioButton")
        radio8.setBorderPainted(false)
        radio8.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "No Border RadioButton state changed to: " + radio8.isSelected()
            )
        })
        add(radio8)

        // ?
        // Example 9: JRadioButton with flat border
        add(JLabel("9. JRadioButton with flat border:"))
        val radio9 = JRadioButton("Flat Border RadioButton")
        //radio9.setBorderPaintedFlat(true)
        radio9.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Flat Border RadioButton state changed to: " + radio9.isSelected()
            )
        })
        add(radio9)

        // Example 10: JRadioButton without content area filled
        add(JLabel("10. JRadioButton without content fill:"))
        val radio10 = JRadioButton("Transparent Content RadioButton")
        radio10.setContentAreaFilled(false)
        radio10.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Transparent Content RadioButton state changed to: " + radio10.isSelected()
            )
        })
        add(radio10)

        // Example 11: JRadioButton with left-aligned text
        add(JLabel("11. JRadioButton with left-aligned text:"))
        val radio11 = JRadioButton("Left Aligned RadioButton")
        radio11.setHorizontalAlignment(SwingConstants.LEFT)
        radio11.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Left Aligned RadioButton state changed to: " + radio11.isSelected()
            )
        })
        add(radio11)

        // Example 12: JRadioButtons in a ButtonGroup (mutually exclusive)
        add(JLabel("12. JRadioButtons in a ButtonGroup:"))
        val groupPanel = JPanel(FlowLayout())
        val group = ButtonGroup()
        val radio12a = JRadioButton("Option A", true)
        radio12a.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Option A selected"
            )
        })
        group.add(radio12a)
        groupPanel.add(radio12a)
        val radio12b = JRadioButton("Option B")
        radio12b.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Option B selected"
            )
        })
        group.add(radio12b)
        groupPanel.add(radio12b)
        add(groupPanel)

        // Note: For icons, you would use setIcon(new ImageIcon("path/to/icon.png")), setSelectedIcon, etc.
        // But since no images are provided, omitting icon examples here. You can add them similarly.
    }
}
