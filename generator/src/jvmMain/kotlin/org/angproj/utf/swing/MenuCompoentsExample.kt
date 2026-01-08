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
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JCheckBoxMenuItem
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem
import javax.swing.JPanel
import javax.swing.JPopupMenu
import javax.swing.JRadioButtonMenuItem

class MenuComponentsExample(parent: JFrame) : JPanel() {
    private val parentFrame: JFrame
    private val statusLabel: JLabel

    init {
        this.parentFrame = parent
        setLayout(BorderLayout())

        statusLabel = JLabel("Status: No action yet")
        add(statusLabel, BorderLayout.SOUTH)

        // Create temporary frame for demonstration
        val tempFrame: JFrame = JFrame("Menu Components Demo")

        // Create and set JMenuBar
        val menuBar: JMenuBar = JMenuBar()
        val fileMenu: JMenu = JMenu("File")
        val openItem: JMenuItem = JMenuItem("Open")
        openItem.addActionListener({ e -> statusLabel.setText("Status: Open selected") })
        fileMenu.add(openItem)

        // Checkbox menu items
        val check1: JCheckBoxMenuItem = JCheckBoxMenuItem("Check 1")
        check1.addActionListener({ e -> statusLabel.setText("Status: Check 1 toggled to " + check1.isSelected()) })
        val check2: JCheckBoxMenuItem = JCheckBoxMenuItem("Check 2")
        check2.addActionListener({ e -> statusLabel.setText("Status: Check 2 toggled to " + check2.isSelected()) })
        fileMenu.add(check1)
        fileMenu.add(check2)

        // Submenu for menubar
        val submenu: JMenu = JMenu("Submenu")
        val subItem1: JMenuItem = JMenuItem("Sub Item 1")
        subItem1.addActionListener({ e -> statusLabel.setText("Status: Sub Item 1 selected") })
        val subItem2: JMenuItem = JMenuItem("Sub Item 2")
        subItem2.addActionListener({ e -> statusLabel.setText("Status: Sub Item 2 selected") })
        submenu.add(subItem1)
        submenu.add(subItem2)
        fileMenu.add(submenu)

        // Radio buttons in group for menu
        val radioGroup: ButtonGroup = ButtonGroup()
        val radio1: JRadioButtonMenuItem = JRadioButtonMenuItem("Option 1", true)
        radio1.addActionListener({ e -> statusLabel.setText("Status: Option 1 selected") })
        val radio2: JRadioButtonMenuItem = JRadioButtonMenuItem("Option 2")
        radio2.addActionListener({ e -> statusLabel.setText("Status: Option 2 selected") })
        radioGroup.add(radio1)
        radioGroup.add(radio2)
        submenu.add(radio1)
        submenu.add(radio2)

        menuBar.add(fileMenu)
        tempFrame.setJMenuBar(menuBar)

        // Button to show popup, placed in tempFrame
        val popupButton: JButton = JButton("Right-click for Popup Menu")
        tempFrame.add(popupButton, BorderLayout.CENTER)

        // JPopupMenu on right-click
        val popup: JPopupMenu = JPopupMenu()
        val popupItem: JMenuItem = JMenuItem("Popup Item")
        popupItem.addActionListener({ e -> statusLabel.setText("Status: Popup Item selected") })
        popup.add(popupItem)

        // Radio buttons in group for popup
        val popupRadioGroup: ButtonGroup = ButtonGroup()
        val popupRadio1: JRadioButtonMenuItem = JRadioButtonMenuItem("Popup Option 1", true)
        popupRadio1.addActionListener({ e -> statusLabel.setText("Status: Popup Option 1 selected") })
        val popupRadio2: JRadioButtonMenuItem = JRadioButtonMenuItem("Popup Option 2")
        popupRadio2.addActionListener({ e -> statusLabel.setText("Status: Popup Option 2 selected") })
        popupRadioGroup.add(popupRadio1)
        popupRadioGroup.add(popupRadio2)
        popup.add(popupRadio1)
        popup.add(popupRadio2)

        // Checkbox menu items for popup
        val popupCheck1: JCheckBoxMenuItem = JCheckBoxMenuItem("Popup Check 1")
        popupCheck1.addActionListener({ e -> statusLabel.setText("Status: Popup Check 1 toggled to " + popupCheck1.isSelected()) })
        val popupCheck2: JCheckBoxMenuItem = JCheckBoxMenuItem("Popup Check 2")
        popupCheck2.addActionListener({ e -> statusLabel.setText("Status: Popup Check 2 toggled to " + popupCheck2.isSelected()) })
        popup.add(popupCheck1)
        popup.add(popupCheck2)

        // Submenu for popup
        val popupSubmenu: JMenu = JMenu("Popup Submenu")
        val popupSubItem1: JMenuItem = JMenuItem("Popup Sub Item 1")
        popupSubItem1.addActionListener({ e -> statusLabel.setText("Status: Popup Sub Item 1 selected") })
        val popupSubItem2: JMenuItem = JMenuItem("Popup Sub Item 2")
        popupSubItem2.addActionListener({ e -> statusLabel.setText("Status: Popup Sub Item 2 selected") })
        popupSubmenu.add(popupSubItem1)
        popupSubmenu.add(popupSubItem2)
        popup.add(popupSubmenu)

        popupButton.setComponentPopupMenu(popup)

        tempFrame.setSize(400, 300)
        tempFrame.setLocationRelativeTo(parentFrame)
        tempFrame.setVisible(true)

        // Note: The temporary frame demonstrates the menu bar and popup functionality.
        // Actions update the status label in the example panel.
    }
}
