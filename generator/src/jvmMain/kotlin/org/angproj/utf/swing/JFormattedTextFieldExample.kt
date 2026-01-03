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
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.swing.BorderFactory
import javax.swing.JFormattedTextField
import javax.swing.JFormattedTextField.AbstractFormatterFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.text.DateFormatter
import javax.swing.text.DefaultFormatterFactory
import javax.swing.text.MaskFormatter
import javax.swing.text.NumberFormatter

internal class JFormattedTextFieldExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JFormattedTextField without formatter
        add(JLabel("1. Default JFormattedTextField without formatter:"))
        val field1 = JFormattedTextField()
        field1.setColumns(20)
        add(field1)

        // Example 2: JFormattedTextField with integer NumberFormatter
        add(JLabel("2. JFormattedTextField with integer NumberFormatter (0-100):"))
        val intFormatter = NumberFormatter(NumberFormat.getIntegerInstance())
        intFormatter.setValueClass(Int::class.java)
        intFormatter.setMinimum(0)
        intFormatter.setMaximum(100)
        intFormatter.setAllowsInvalid(false)
        val field2 = JFormattedTextField(intFormatter)
        field2.setColumns(20)
        field2.setValue(50)
        add(field2)

        // Example 3: JFormattedTextField with decimal NumberFormatter
        add(JLabel("3. JFormattedTextField with decimal NumberFormatter (0.0-100.0):"))
        val decimalFormatter = NumberFormatter(NumberFormat.getNumberInstance())
        decimalFormatter.setValueClass(Double::class.java)
        decimalFormatter.setMinimum(0.0)
        decimalFormatter.setMaximum(100.0)
        decimalFormatter.setAllowsInvalid(false)
        val field3 = JFormattedTextField(decimalFormatter)
        field3.setColumns(20)
        field3.setValue(50.5)
        add(field3)

        // Example 4: JFormattedTextField with DateFormatter
        add(JLabel("4. JFormattedTextField with DateFormatter (MM/dd/yyyy):"))
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        val dateFormatter = DateFormatter(dateFormat)
        dateFormatter.setAllowsInvalid(false)
        val field4 = JFormattedTextField(dateFormatter)
        field4.setColumns(20)
        field4.setValue(Date())
        add(field4)

        // Example 5: JFormattedTextField with MaskFormatter (phone number)
        add(JLabel("5. JFormattedTextField with MaskFormatter (###-###-####):"))
        var maskFormatter: MaskFormatter? = null
        try {
            maskFormatter = MaskFormatter("###-###-####")
            maskFormatter.setPlaceholderCharacter('_')
        } catch (ex: ParseException) {
            ex.printStackTrace()
        }
        val field5 = JFormattedTextField(maskFormatter)
        field5.setColumns(20)
        add(field5)

        // ?
        // Example 6: JFormattedTextField with commit on valid edit
        add(JLabel("6. JFormattedTextField with commit on valid edit:"))
        val field6 = JFormattedTextField(NumberFormat.getIntegerInstance())
        //field6.setCommitBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        field6.setColumns(20)
        add(field6)

        // Example 7: Disabled JFormattedTextField
        add(JLabel("7. Disabled JFormattedTextField:"))
        val field7 = JFormattedTextField()
        field7.setEnabled(false)
        field7.setValue("Disabled")
        field7.setColumns(20)
        add(field7)

        // Example 8: JFormattedTextField with tooltip
        add(JLabel("8. JFormattedTextField with tooltip (hover to see):"))
        val field8 = JFormattedTextField()
        field8.setToolTipText("This is a tooltip!")
        field8.setColumns(20)
        add(field8)

        // Example 9: JFormattedTextField with focus lost behavior (persist)
        add(JLabel("9. JFormattedTextField with focus lost behavior (persist):"))
        val field9 = JFormattedTextField(NumberFormat.getIntegerInstance())
        field9.setFocusLostBehavior(JFormattedTextField.PERSIST)
        field9.setColumns(20)
        add(field9)

        // Example 10: JFormattedTextField with custom formatter factory
        add(JLabel("10. JFormattedTextField with custom formatter factory:"))
        val factory: AbstractFormatterFactory =
            DefaultFormatterFactory(NumberFormatter(NumberFormat.getIntegerInstance()))
        val field10 = JFormattedTextField()
        field10.setFormatterFactory(factory)
        field10.setColumns(20)
        add(field10)

        // Note: Add action listeners if needed to show values, e.g., field.addActionListener(e -> JOptionPane.showMessageDialog(this, field.getValue()));
        // But for demonstration, just the fields are shown.
    }
}
