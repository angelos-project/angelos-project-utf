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

internal class JTextFieldExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JTextField
        add(JLabel("1. Default JTextField:"))
        val field1 = JTextField()
        field1.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field1.getText()
            )
        })
        add(field1)

        // Example 2: JTextField with initial text
        add(JLabel("2. JTextField with initial text:"))
        val field2 = JTextField("Initial text")
        field2.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field2.getText()
            )
        })
        add(field2)

        // Example 3: JTextField with columns (20)
        add(JLabel("3. JTextField with columns (20):"))
        val field3 = JTextField(20)
        field3.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field3.getText()
            )
        })
        add(field3)

        // Example 4: Non-editable JTextField
        add(JLabel("4. Non-editable JTextField:"))
        val field4 = JTextField("Not editable")
        field4.setEditable(false)
        add(field4)

        // Example 5: Disabled JTextField
        add(JLabel("5. Disabled JTextField:"))
        val field5 = JTextField("Disabled")
        field5.setEnabled(false)
        add(field5)

        // Example 6: JTextField with horizontal alignment (right)
        add(JLabel("6. JTextField with right horizontal alignment:"))
        val field6 = JTextField("Right aligned")
        field6.setHorizontalAlignment(SwingConstants.RIGHT)
        field6.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field6.getText()
            )
        })
        add(field6)

        // Example 7: JTextField with tooltip
        add(JLabel("7. JTextField with tooltip (hover to see):"))
        val field7 = JTextField()
        field7.setToolTipText("This is a tooltip!")
        field7.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field7.getText()
            )
        })
        add(field7)

        // Example 8: JTextField with custom background and foreground
        add(JLabel("8. JTextField with custom colors:"))
        val field8 = JTextField("Colored field")
        field8.setBackground(Color.YELLOW)
        field8.setForeground(Color.RED)
        field8.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field8.getText()
            )
        })
        add(field8)

        // Example 9: JTextField with custom caret color
        add(JLabel("9. JTextField with custom caret color (blue):"))
        val field9 = JTextField("Type here")
        field9.setCaretColor(Color.BLUE)
        field9.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field9.getText()
            )
        })
        add(field9)

        // Example 10: JTextField with columns and initial text
        add(JLabel("10. JTextField with columns (15) and initial text:"))
        val field10 = JTextField("Initial with columns", 15)
        field10.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Entered: " + field10.getText()
            )
        })
        add(field10)

        // Note: For input masks or formatters, use JFormattedTextField; here focusing on basic JTextField.
        // Add more if needed, like setMargin, but basics covered.
    }
}
