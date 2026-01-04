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
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class JOptionPaneExample(private var parentFrame: JFrame?) : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: showMessageDialog (plain message)
        add(JLabel("1. showMessageDialog (plain message):"))
        val button1 = JButton("Show Plain Message")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                parentFrame,
                "This is a plain message."
            )
        })
        add(button1)

        // Example 2: showMessageDialog with INFORMATION_MESSAGE
        add(JLabel("2. showMessageDialog with INFORMATION_MESSAGE:"))
        val button2 = JButton("Show Information Message")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                parentFrame,
                "This is an information message.",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
            )
        })
        add(button2)

        // Example 3: showMessageDialog with WARNING_MESSAGE
        add(JLabel("3. showMessageDialog with WARNING_MESSAGE:"))
        val button3 = JButton("Show Warning Message")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                parentFrame,
                "This is a warning message.",
                "Warning",
                JOptionPane.WARNING_MESSAGE
            )
        })
        add(button3)

        // Example 4: showMessageDialog with ERROR_MESSAGE
        add(JLabel("4. showMessageDialog with ERROR_MESSAGE:"))
        val button4 = JButton("Show Error Message")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                parentFrame,
                "This is an error message.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            )
        })
        add(button4)

        // Example 5: showMessageDialog with QUESTION_MESSAGE
        add(JLabel("5. showMessageDialog with QUESTION_MESSAGE:"))
        val button5 = JButton("Show Question Message")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            JOptionPane.showMessageDialog(
                parentFrame,
                "This is a question message.",
                "Question",
                JOptionPane.QUESTION_MESSAGE
            )
        })
        add(button5)

        // Example 6: showConfirmDialog with YES_NO_OPTION
        add(JLabel("6. showConfirmDialog with YES_NO_OPTION:"))
        val button6 = JButton("Show Yes/No Confirm")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            val result =
                JOptionPane.showConfirmDialog(parentFrame, "Do you confirm?", "Confirm", JOptionPane.YES_NO_OPTION)
            JOptionPane.showMessageDialog(
                parentFrame,
                "You selected: " + (if (result == JOptionPane.YES_OPTION) "Yes" else "No")
            )
        })
        add(button6)

        // Example 7: showConfirmDialog with YES_NO_CANCEL_OPTION
        add(JLabel("7. showConfirmDialog with YES_NO_CANCEL_OPTION:"))
        val button7 = JButton("Show Yes/No/Cancel Confirm")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val result = JOptionPane.showConfirmDialog(
                parentFrame,
                "Do you confirm?",
                "Confirm",
                JOptionPane.YES_NO_CANCEL_OPTION
            )
            val msg =
                if (result == JOptionPane.YES_OPTION) "Yes" else if (result == JOptionPane.NO_OPTION) "No" else "Cancel"
            JOptionPane.showMessageDialog(parentFrame, "You selected: " + msg)
        })
        add(button7)

        // Example 8: showConfirmDialog with OK_CANCEL_OPTION
        add(JLabel("8. showConfirmDialog with OK_CANCEL_OPTION:"))
        val button8 = JButton("Show OK/Cancel Confirm")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val result =
                JOptionPane.showConfirmDialog(parentFrame, "Do you confirm?", "Confirm", JOptionPane.OK_CANCEL_OPTION)
            JOptionPane.showMessageDialog(
                parentFrame,
                "You selected: " + (if (result == JOptionPane.OK_OPTION) "OK" else "Cancel")
            )
        })
        add(button8)

        // Example 9: showInputDialog (simple input)
        add(JLabel("9. showInputDialog (simple input):"))
        val button9 = JButton("Show Input Dialog")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val input = JOptionPane.showInputDialog(parentFrame, "Enter something:")
            if (input != null) {
                JOptionPane.showMessageDialog(parentFrame, "You entered: " + input)
            }
        })
        add(button9)

        // Example 10: showInputDialog with selection values
        add(JLabel("10. showInputDialog with selection values:"))
        val button10 = JButton("Show Input with Choices")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            val choices = arrayOf<Any?>("Option 1", "Option 2", "Option 3")
            val input = JOptionPane.showInputDialog(
                parentFrame,
                "Choose one:",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                choices[0]
            )
            if (input != null) {
                JOptionPane.showMessageDialog(parentFrame, "You selected: " + input)
            }
        })
        add(button10)

        // Example 11: showOptionDialog with custom options
        add(JLabel("11. showOptionDialog with custom options:"))
        val button11 = JButton("Show Custom Option Dialog")
        button11.addActionListener(ActionListener { e: ActionEvent? ->
            val options = arrayOf<Any?>("Choice A", "Choice B", "Choice C")
            val result = JOptionPane.showOptionDialog(
                parentFrame,
                "Pick one:",
                "Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            )
            if (result >= 0) {
                JOptionPane.showMessageDialog(parentFrame, "You selected: " + options[result])
            }
        })
        add(button11)

        // Example 12: showMessageDialog with custom icon (placeholder, use actual Icon)
        add(JLabel("12. showMessageDialog with custom icon:"))
        val button12 = JButton("Show Message with Custom Icon")
        button12.addActionListener(ActionListener { e: ActionEvent? ->
            // Placeholder icon; replace with actual ImageIcon
            val icon: Icon = ImageIcon()
            JOptionPane.showMessageDialog(
                parentFrame,
                "Message with custom icon.",
                "Custom Icon",
                JOptionPane.PLAIN_MESSAGE,
                icon
            )
        })
        add(button12)

        // Note: For more, like internal dialogs or password input, can add showInternalMessageDialog, showPasswordDialog, etc.
        // But focusing on main static methods.
    }
}
