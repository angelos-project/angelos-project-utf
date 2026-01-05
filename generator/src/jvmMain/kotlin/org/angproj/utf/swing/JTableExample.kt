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
import javax.swing.*
import javax.swing.table.DefaultTableCellRenderer

internal class JTableExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        val data = arrayOf<Array<Any?>?>(
            arrayOf<Any?>("Row1-Col1", "Row1-Col2", "Row1-Col3"),
            arrayOf<Any?>("Row2-Col1", "Row2-Col2", "Row2-Col3"),
            arrayOf<Any?>("Row3-Col1", "Row3-Col2", "Row3-Col3")
        )
        val columns = arrayOf<String?>("Column 1", "Column 2", "Column 3")

        // Example 1: Default JTable (empty)
        add(JLabel("1. Default JTable (empty):"))
        val table1 = JTable()
        add(JScrollPane(table1))

        // Example 2: JTable with data and columns
        add(JLabel("2. JTable with data and columns:"))
        val table2 = JTable(data, columns)
        add(JScrollPane(table2))

        // Example 3: Non-editable JTable
        add(JLabel("3. Non-editable JTable:"))
        val table3: JTable = object : JTable(data, columns) {
            override fun isCellEditable(row: Int, column: Int): Boolean {
                return false
            }
        }
        add(JScrollPane(table3))

        // Example 4: JTable with single selection mode
        add(JLabel("4. JTable with single selection mode:"))
        val table4 = JTable(data, columns)
        table4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
        add(JScrollPane(table4))

        // Example 5: JTable with single interval selection mode
        add(JLabel("5. JTable with single interval selection mode:"))
        val table5 = JTable(data, columns)
        table5.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION)
        add(JScrollPane(table5))

        // Example 6: JTable with row selection only
        add(JLabel("6. JTable with row selection only:"))
        val table6 = JTable(data, columns)
        table6.setRowSelectionAllowed(true)
        table6.setColumnSelectionAllowed(false)
        add(JScrollPane(table6))

        // Example 7: JTable with column selection only
        add(JLabel("7. JTable with column selection only:"))
        val table7 = JTable(data, columns)
        table7.setRowSelectionAllowed(false)
        table7.setColumnSelectionAllowed(true)
        add(JScrollPane(table7))

        // Example 8: JTable with auto resize off
        add(JLabel("8. JTable with auto resize off:"))
        val table8 = JTable(data, columns)
        table8.setAutoResizeMode(JTable.AUTO_RESIZE_OFF)
        add(JScrollPane(table8))

        // Example 9: JTable with auto resize all columns
        add(JLabel("9. JTable with auto resize all columns:"))
        val table9 = JTable(data, columns)
        table9.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS)
        add(JScrollPane(table9))

        // Example 10: JTable with row sorter
        add(JLabel("10. JTable with row sorter (click headers to sort):"))
        val table10 = JTable(data, columns)
        table10.setAutoCreateRowSorter(true)
        add(JScrollPane(table10))

        // Example 11: Disabled JTable
        add(JLabel("11. Disabled JTable:"))
        val table11 = JTable(data, columns)
        table11.setEnabled(false)
        add(JScrollPane(table11))

        // Example 12: JTable with tooltip
        add(JLabel("12. JTable with tooltip (hover to see):"))
        val table12 = JTable(data, columns)
        table12.setToolTipText("This is a tooltip!")
        add(JScrollPane(table12))

        // Example 13: JTable with custom cell renderer (bold text)
        add(JLabel("13. JTable with custom cell renderer (bold text):"))
        val table13 = JTable(data, columns)
        table13.setDefaultRenderer(Any::class.java, object : DefaultTableCellRenderer() {
            override fun getTableCellRendererComponent(
                table: JTable?,
                value: Any?,
                isSelected: Boolean,
                hasFocus: Boolean,
                row: Int,
                column: Int
            ): Component {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column)
                setFont(getFont().deriveFont(Font.BOLD))
                return this
            }
        })
        add(JScrollPane(table13))

        // Example 14: JTable with custom column width
        add(JLabel("14. JTable with custom column width (100 for first column):"))
        val table14 = JTable(data, columns)
        table14.getColumnModel().getColumn(0).setPreferredWidth(100)
        add(JScrollPane(table14))

        // Example 15: JTable without grid shown
        add(JLabel("15. JTable without grid shown:"))
        val table15 = JTable(data, columns)
        table15.setShowGrid(false)
        add(JScrollPane(table15))

        // Example 16: JTable with row height set
        add(JLabel("16. JTable with row height set (30):"))
        val table16 = JTable(data, columns)
        table16.setRowHeight(30)
        add(JScrollPane(table16))

        // Note: For more, like custom editors or models, but covering main configs.
    }
}
