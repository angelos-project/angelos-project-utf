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

import java.awt.Component
import java.awt.Font
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.*
import javax.swing.*
import javax.swing.plaf.basic.BasicComboBoxEditor

internal class JComboBoxExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        val items = arrayOf<String?>("Item 1", "Item 2", "Item 3", "Item 4")

        // Example 1: Default JComboBox without items
        add(JLabel("1. Default JComboBox without items:"))
        val combo1 = JComboBox<String?>()
        combo1.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo1.getSelectedItem())
            }
        })
        add(combo1)

        // Example 2: JComboBox with items
        add(JLabel("2. JComboBox with items:"))
        val combo2 = JComboBox<String?>(items)
        combo2.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo2.getSelectedItem())
            }
        })
        add(combo2)

        // Example 3: Editable JComboBox
        add(JLabel("3. Editable JComboBox:"))
        val combo3 = JComboBox<String?>(items)
        combo3.setEditable(true)
        combo3.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected/Entered: " + combo3.getSelectedItem())
            }
        })
        add(combo3)

        // Example 4: Disabled JComboBox
        add(JLabel("4. Disabled JComboBox:"))
        val combo4 = JComboBox<String?>(items)
        combo4.setEnabled(false)
        add(combo4)

        // Example 5: JComboBox with tooltip
        add(JLabel("5. JComboBox with tooltip (hover to see):"))
        val combo5 = JComboBox<String?>(items)
        combo5.setToolTipText("This is a tooltip!")
        combo5.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo5.getSelectedItem())
            }
        })
        add(combo5)

        // Example 6: JComboBox with maximum row count
        add(JLabel("6. JComboBox with maximum row count (3):"))
        val combo6 = JComboBox<String?>(items)
        combo6.setMaximumRowCount(3)
        combo6.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo6.getSelectedItem())
            }
        })
        add(combo6)

        // Example 7: JComboBox with prototype display value
        add(JLabel("7. JComboBox with prototype display value:"))
        val combo7 = JComboBox<String?>(items)
        combo7.setPrototypeDisplayValue("Long Item Prototype")
        combo7.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo7.getSelectedItem())
            }
        })
        add(combo7)

        // Example 8: JComboBox with custom renderer
        add(JLabel("8. JComboBox with custom renderer (bold text):"))
        val combo8 = JComboBox<String?>(items)
        combo8.setRenderer(object : DefaultListCellRenderer() {
            override fun getListCellRendererComponent(
                list: JList<*>?,
                value: Any?,
                index: Int,
                isSelected: Boolean,
                cellHasFocus: Boolean
            ): Component {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)
                setFont(getFont().deriveFont(Font.BOLD))
                return this
            }
        })
        combo8.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo8.getSelectedItem())
            }
        })
        add(combo8)

        // Example 9: JComboBox with custom editor
        add(JLabel("9. JComboBox with custom editor (uppercase):"))
        val combo9 = JComboBox<String?>(items)
        combo9.setEditable(true)
        val editor: ComboBoxEditor = object : BasicComboBoxEditor() {
            override fun setItem(anObject: Any?) {
                super.setItem(if (anObject != null) anObject.toString().uppercase(Locale.getDefault()) else null)
            }
        }
        combo9.setEditor(editor)
        combo9.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected/Entered: " + combo9.getSelectedItem())
            }
        })
        add(combo9)

        // Example 10: JComboBox with light weight popup
        add(JLabel("10. JComboBox with light weight popup:"))
        val combo10 = JComboBox<String?>(items)
        combo10.setLightWeightPopupEnabled(true) // Default is true, but explicit
        combo10.addActionListener(ActionListener { e: ActionEvent? ->
            if ("comboBoxChanged" == e!!.getActionCommand()) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo10.getSelectedItem())
            }
        })
        add(combo10)

        // Note: For icons in items, you can use objects with custom toString and renderer.
        // But keeping it simple with strings here.

        // To make it scrollable if many examples, but since wrapped in JScrollPane via switchPanel, it's handled.
    }
}
