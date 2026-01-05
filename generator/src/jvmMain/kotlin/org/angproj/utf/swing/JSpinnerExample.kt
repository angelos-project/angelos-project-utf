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
import javax.swing.JSpinner.DateEditor

internal class JSpinnerExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JSpinner (SpinnerNumberModel, 0 to Integer.MAX_VALUE)
        add(JLabel("1. Default JSpinner (number model):"))
        val spinner1 = JSpinner()
        add(spinner1)

        // Example 2: JSpinner with custom number model (min 0, max 100, step 5, initial 50)
        add(JLabel("2. JSpinner with custom number model (0-100, step 5):"))
        val numberModel = SpinnerNumberModel(50, 0, 100, 5)
        val spinner2 = JSpinner(numberModel)
        add(spinner2)

        // Example 3: JSpinner with list model
        add(JLabel("3. JSpinner with list model:"))
        val items = arrayOf<String?>("Item 1", "Item 2", "Item 3")
        val listModel = SpinnerListModel(items)
        val spinner3 = JSpinner(listModel)
        add(spinner3)

        // Example 4: JSpinner with date model
        add(JLabel("4. JSpinner with date model:"))
        val dateModel = SpinnerDateModel()
        val spinner4 = JSpinner(dateModel)
        spinner4.setEditor(DateEditor(spinner4, "MM/dd/yyyy"))
        add(spinner4)

        // Example 5: Disabled JSpinner
        add(JLabel("5. Disabled JSpinner:"))
        val spinner5 = JSpinner()
        spinner5.setEnabled(false)
        add(spinner5)

        // Example 6: JSpinner with tooltip
        add(JLabel("6. JSpinner with tooltip (hover to see):"))
        val spinner6 = JSpinner()
        spinner6.setToolTipText("This is a tooltip!")
        add(spinner6)

        // Example 7: JSpinner with custom border
        add(JLabel("7. JSpinner with custom border:"))
        val spinner7 = JSpinner()
        spinner7.setBorder(BorderFactory.createLineBorder(Color.RED))
        add(spinner7)

        // Example 8: JSpinner with custom editor (for number, formatted)
        add(JLabel("8. JSpinner with custom editor (formatted number):"))
        val spinner8 = JSpinner(SpinnerNumberModel(50.0, 0.0, 100.0, 0.5))
        spinner8.setEditor(JSpinner.NumberEditor(spinner8, "#.##"))
        add(spinner8)

        // ?
        // Example 9: JSpinner with inverted (reversed) order
        add(JLabel("9. JSpinner with inverted order:"))
        val spinner9 = JSpinner()
        //spinner9.setInverted(true);
        add(spinner9)

        // Example 10: JSpinner with custom background and foreground
        add(JLabel("10. JSpinner with custom colors:"))
        val spinner10 = JSpinner()
        spinner10.setBackground(Color.YELLOW)
        spinner10.setForeground(Color.RED)
        add(spinner10)

        // Note: Add change listeners if needed, e.g., spinner.addChangeListener(e -> JOptionPane.showMessageDialog(this, spinner.getValue()));
        // But for demonstration, just the spinners are shown.
    }
}
