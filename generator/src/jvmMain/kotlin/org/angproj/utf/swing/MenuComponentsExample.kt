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
import java.awt.event.KeyEvent
import javax.swing.*

// JToolBar Example menu item
internal class MenuComponentsExample(private val parentFrame: JFrame?) : JPanel() {
    private val statusLabel: JLabel

    init {
        setLayout(BorderLayout())

        statusLabel = JLabel("Status: No action yet")
        add(statusLabel, BorderLayout.SOUTH)

        // Create temporary frame for demonstration
        val tempFrame = JFrame("Menu Components Demo")

        // Create and set JMenuBar
        val menuBar = JMenuBar()
        val fileMenu = JMenu("File")
        fileMenu.setMnemonic(KeyEvent.VK_F) // Alt + F for File

        val openItem = JMenuItem("Open")
        openItem.setMnemonic(KeyEvent.VK_O) // Alt + O for Open
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)) // Ctrl + O
        openItem.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Open selected") })
        fileMenu.add(openItem)

        // Radio buttons in group for menu
        val radioGroup = ButtonGroup()
        val radio1 = JRadioButtonMenuItem("Option 1", true)
        radio1.setMnemonic(KeyEvent.VK_1) // Alt + 1
        radio1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK)) // Ctrl + 1
        radio1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Option 1 selected") })
        val radio2 = JRadioButtonMenuItem("Option 2")
        radio2.setMnemonic(KeyEvent.VK_2) // Alt + 2
        radio2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK)) // Ctrl + 2
        radio2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Option 2 selected") })
        radioGroup.add(radio1)
        radioGroup.add(radio2)
        fileMenu.add(radio1)
        fileMenu.add(radio2)

        // Checkbox menu items
        val check1 = JCheckBoxMenuItem("Check 1")
        check1.setMnemonic(KeyEvent.VK_C) // Alt + C
        check1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)) // Ctrl + C
        check1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Check 1 toggled to " + check1.isSelected()) })
        val check2 = JCheckBoxMenuItem("Check 2")
        check2.setMnemonic(KeyEvent.VK_H) // Alt + H
        check2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK)) // Ctrl + H
        check2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Check 2 toggled to " + check2.isSelected()) })
        fileMenu.add(check1)
        fileMenu.add(check2)

        // Submenu for menubar
        val submenu = JMenu("Submenu")
        submenu.setMnemonic(KeyEvent.VK_S) // Alt + S
        val subItem1 = JMenuItem("Sub Item 1")
        subItem1.setMnemonic(KeyEvent.VK_A) // Alt + A
        subItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)) // Ctrl + A
        subItem1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Sub Item 1 selected") })
        val subItem2 = JMenuItem("Sub Item 2")
        subItem2.setMnemonic(KeyEvent.VK_B) // Alt + B
        subItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK)) // Ctrl + B
        subItem2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Sub Item 2 selected") })
        submenu.add(subItem1)
        submenu.add(subItem2)
        fileMenu.add(submenu)

        menuBar.add(fileMenu)
        tempFrame.setJMenuBar(menuBar)

        // Button to show popup, placed in tempFrame
        val popupButton = JButton("Right-click for Popup Menu")
        tempFrame.add(popupButton, BorderLayout.CENTER)

        // JPopupMenu on right-click
        val popup = JPopupMenu()
        val popupItem = JMenuItem("Popup Item")
        popupItem.setMnemonic(KeyEvent.VK_P) // Alt + P
        popupItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK)) // Ctrl + P
        popupItem.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Item selected") })
        popup.add(popupItem)

        // Radio buttons in group for popup
        val popupRadioGroup = ButtonGroup()
        val popupRadio1 = JRadioButtonMenuItem("Popup Option 1", true)
        popupRadio1.setMnemonic(KeyEvent.VK_3) // Alt + 3
        popupRadio1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK)) // Ctrl + 3
        popupRadio1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Option 1 selected") })
        val popupRadio2 = JRadioButtonMenuItem("Popup Option 2")
        popupRadio2.setMnemonic(KeyEvent.VK_4) // Alt + 4
        popupRadio2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK)) // Ctrl + 4
        popupRadio2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Option 2 selected") })
        popupRadioGroup.add(popupRadio1)
        popupRadioGroup.add(popupRadio2)
        popup.add(popupRadio1)
        popup.add(popupRadio2)

        // Checkbox menu items for popup
        val popupCheck1 = JCheckBoxMenuItem("Popup Check 1")
        popupCheck1.setMnemonic(KeyEvent.VK_E) // Alt + E
        popupCheck1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK)) // Ctrl + E
        popupCheck1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Check 1 toggled to " + popupCheck1.isSelected()) })
        val popupCheck2 = JCheckBoxMenuItem("Popup Check 2")
        popupCheck2.setMnemonic(KeyEvent.VK_F) // Alt + F
        popupCheck2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK)) // Ctrl + F
        popupCheck2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Check 2 toggled to " + popupCheck2.isSelected()) })
        popup.add(popupCheck1)
        popup.add(popupCheck2)

        // Submenu for popup
        val popupSubmenu = JMenu("Popup Submenu")
        popupSubmenu.setMnemonic(KeyEvent.VK_U) // Alt + U
        val popupSubItem1 = JMenuItem("Popup Sub Item 1")
        popupSubItem1.setMnemonic(KeyEvent.VK_G) // Alt + G
        popupSubItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK)) // Ctrl + G
        popupSubItem1.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Sub Item 1 selected") })
        val popupSubItem2 = JMenuItem("Popup Sub Item 2")
        popupSubItem2.setMnemonic(KeyEvent.VK_I) // Alt + I
        popupSubItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK)) // Ctrl + I
        popupSubItem2.addActionListener(ActionListener { e: ActionEvent? -> statusLabel.setText("Status: Popup Sub Item 2 selected") })
        popupSubmenu.add(popupSubItem1)
        popupSubmenu.add(popupSubItem2)
        popup.add(popupSubmenu)

        popupButton.setComponentPopupMenu(popup)

        tempFrame.setSize(400, 300)
        tempFrame.setLocationRelativeTo(parentFrame)
        tempFrame.setVisible(true)

        // Note: The temporary frame demonstrates the menu bar and popup functionality.
        // Actions update the status label in the example panel. Mnemonics and accelerators added.
    }
}
