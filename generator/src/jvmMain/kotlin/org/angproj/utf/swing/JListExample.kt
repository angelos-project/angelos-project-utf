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

internal class JListExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        val data = arrayOf<String?>("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8")

        // Example 1: Default JList (vertical, single selection)
        add(JLabel("1. Default JList (vertical, single selection):"))
        val list1 = JList<String?>(data)
        add(JScrollPane(list1))

        // Example 2: JList with horizontal wrap
        add(JLabel("2. JList with horizontal wrap:"))
        val list2 = JList<String?>(data)
        list2.setLayoutOrientation(JList.HORIZONTAL_WRAP)
        list2.setVisibleRowCount(-1) // All in one row if possible
        add(JScrollPane(list2))

        // Example 3: JList with vertical wrap
        add(JLabel("3. JList with vertical wrap:"))
        val list3 = JList<String?>(data)
        list3.setLayoutOrientation(JList.VERTICAL_WRAP)
        list3.setVisibleRowCount(3) // Wrap after 3 rows
        add(JScrollPane(list3))

        // Example 4: JList with single interval selection
        add(JLabel("4. JList with single interval selection:"))
        val list4 = JList<String?>(data)
        list4.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION)
        add(JScrollPane(list4))

        // Example 5: JList with multiple interval selection
        add(JLabel("5. JList with multiple interval selection:"))
        val list5 = JList<String?>(data)
        list5.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION)
        add(JScrollPane(list5))

        // Example 6: Disabled JList
        add(JLabel("6. Disabled JList:"))
        val list6 = JList<String?>(data)
        list6.setEnabled(false)
        add(JScrollPane(list6))

        // Example 7: JList with tooltip
        add(JLabel("7. JList with tooltip (hover to see):"))
        val list7 = JList<String?>(data)
        list7.setToolTipText("This is a tooltip!")
        add(JScrollPane(list7))

        // Example 8: JList with fixed cell width and height
        add(JLabel("8. JList with fixed cell width (150) and height (30):"))
        val list8 = JList<String?>(data)
        list8.setFixedCellWidth(150)
        list8.setFixedCellHeight(30)
        add(JScrollPane(list8))

        // Example 9: JList with prototype cell value (for sizing)
        add(JLabel("9. JList with prototype cell value:"))
        val list9 = JList<String?>(data)
        list9.setPrototypeCellValue("Long Item Prototype")
        add(JScrollPane(list9))

        // Example 10: JList with custom cell renderer (bold text)
        add(JLabel("10. JList with custom cell renderer (bold text):"))
        val list10 = JList<String?>(data)
        list10.setCellRenderer(object : DefaultListCellRenderer() {
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
        add(JScrollPane(list10))

        // Example 11: JList with visible row count (3 rows)
        add(JLabel("11. JList with visible row count (3):"))
        val list11 = JList<String?>(data)
        list11.setVisibleRowCount(3)
        add(JScrollPane(list11))

        // Example 12: Empty JList
        add(JLabel("12. Empty JList:"))
        val list12 = JList<String?>()
        add(JScrollPane(list12))

        // Note: For icons in cells, use custom renderer with ImageIcon; omitted since no images.
        // Add list selection listeners if needed, e.g., list.addListSelectionListener(e -> JOptionPane.showMessageDialog(this, list.getSelectedValue()));
    }
}
