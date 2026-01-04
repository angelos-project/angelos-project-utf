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
import java.awt.GridLayout
import javax.swing.*

internal class JPasswordFieldExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JPasswordField
        add(JLabel("1. Default JPasswordField:"))
        val field1 = JPasswordField()
        field1.setColumns(20)
        add(field1)

        // Example 2: JPasswordField with initial text
        add(JLabel("2. JPasswordField with initial text:"))
        val field2 = JPasswordField("password")
        field2.setColumns(20)
        add(field2)

        // Example 3: JPasswordField with echo char (*)
        add(JLabel("3. JPasswordField with echo char (*):"))
        val field3 = JPasswordField()
        field3.setEchoChar('*')
        field3.setColumns(20)
        add(field3)

        // Example 4: JPasswordField with custom echo char (#)
        add(JLabel("4. JPasswordField with custom echo char (#):"))
        val field4 = JPasswordField()
        field4.setEchoChar('#')
        field4.setColumns(20)
        add(field4)

        // Example 5: Disabled JPasswordField
        add(JLabel("5. Disabled JPasswordField:"))
        val field5 = JPasswordField()
        field5.setEnabled(false)
        field5.setColumns(20)
        add(field5)

        // Example 6: JPasswordField with tooltip
        add(JLabel("6. JPasswordField with tooltip (hover to see):"))
        val field6 = JPasswordField()
        field6.setToolTipText("This is a tooltip!")
        field6.setColumns(20)
        add(field6)

        // Example 7: JPasswordField with custom background and foreground
        add(JLabel("7. JPasswordField with custom colors:"))
        val field7 = JPasswordField()
        field7.setBackground(Color.YELLOW)
        field7.setForeground(Color.RED)
        field7.setColumns(20)
        add(field7)

        // Example 8: Non-editable JPasswordField
        add(JLabel("8. Non-editable JPasswordField:"))
        val field8 = JPasswordField("password")
        field8.setEditable(false)
        field8.setColumns(20)
        add(field8)

        // Example 9: JPasswordField with horizontal alignment (right)
        add(JLabel("9. JPasswordField with right horizontal alignment:"))
        val field9 = JPasswordField()
        field9.setHorizontalAlignment(SwingConstants.RIGHT)
        field9.setColumns(20)
        add(field9)

        // Example 10: JPasswordField without echo char (shows plain text)
        add(JLabel("10. JPasswordField without echo char (shows plain text):"))
        val field10 = JPasswordField("visible")
        field10.setEchoChar(0.toChar())
        field10.setColumns(20)
        add(field10)

        // Note: Add action listeners if needed to show values, e.g., field.addActionListener(e -> JOptionPane.showMessageDialog(this, new String(field.getPassword())));
        // But for demonstration, just the fields are shown.
    }
}
