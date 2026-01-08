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

import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class MenuComponentsExample(private val parentFrame: JFrame?) : JPanel() {
    private val statusLabel: JLabel

    init {
        setLayout(BorderLayout())

        statusLabel = JLabel("Status: No action yet")
        add(statusLabel, BorderLayout.SOUTH)

        // Button to show popup
        val popupButton = JButton("Right-click for Popup Menu")
        add(popupButton, BorderLayout.CENTER)

        // Create and set JMenuBar
        val menuBar = JMenuBar()
        val fileMenu = JMenu("File")
        val openItem = JMenuItem("Open")
        openItem.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Open selected") })
        fileMenu.add(openItem)

        // Radio buttons in group for menu
        val radioGroup = ButtonGroup()
        val radio1 = JRadioButtonMenuItem("Option 1", true)
        radio1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Option 1 selected") })
        val radio2 = JRadioButtonMenuItem("Option 2")
        radio2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Option 2 selected") })
        radioGroup.add(radio1)
        radioGroup.add(radio2)
        fileMenu.add(radio1)
        fileMenu.add(radio2)

        // Checkbox menu items
        val check1 = JCheckBoxMenuItem("Check 1")
        check1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Check 1 toggled to " + check1.isSelected()) })
        val check2 = JCheckBoxMenuItem("Check 2")
        check2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Check 2 toggled to " + check2.isSelected()) })
        fileMenu.add(check1)
        fileMenu.add(check2)

        menuBar.add(fileMenu)

        // Create temporary frame for demonstration
        val tempFrame = JFrame("Menu Components Demo")
        tempFrame.setJMenuBar(menuBar)
        tempFrame.add(JLabel("Main content area"), BorderLayout.CENTER)
        tempFrame.setSize(400, 300)
        tempFrame.setLocationRelativeTo(parentFrame)
        tempFrame.setVisible(true)

        // JPopupMenu on right-click
        val popup = JPopupMenu()
        val popupItem = JMenuItem("Popup Item")
        popupItem.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Item selected") })
        popup.add(popupItem)

        // Radio buttons in group for popup
        val popupRadioGroup = ButtonGroup()
        val popupRadio1 = JRadioButtonMenuItem("Popup Option 1", true)
        popupRadio1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Option 1 selected") })
        val popupRadio2 = JRadioButtonMenuItem("Popup Option 2")
        popupRadio2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Option 2 selected") })
        popupRadioGroup.add(popupRadio1)
        popupRadioGroup.add(popupRadio2)
        popup.add(popupRadio1)
        popup.add(popupRadio2)

        // Checkbox menu items for popup
        val popupCheck1 = JCheckBoxMenuItem("Popup Check 1")
        popupCheck1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Check 1 toggled to " + popupCheck1.isSelected()) })
        val popupCheck2 = JCheckBoxMenuItem("Popup Check 2")
        popupCheck2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Check 2 toggled to " + popupCheck2.isSelected()) })
        popup.add(popupCheck1)
        popup.add(popupCheck2)

        popupButton.setComponentPopupMenu(popup)

        // Note: The temporary frame demonstrates the menu bar functionality.
        // Right-click on the button for popup. Actions update the status label.
    }
}
