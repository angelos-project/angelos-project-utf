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

import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import javax.swing.*
import javax.swing.filechooser.FileNameExtensionFilter

internal class JFileChooserExample(private val parentFrame: JFrame?) : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JFileChooser (open dialog)
        add(JLabel("1. Default JFileChooser (open dialog):"))
        val button1 = JButton("Show Default Open Dialog")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button1)

        // Example 2: JFileChooser as save dialog
        add(JLabel("2. JFileChooser as save dialog:"))
        val button2 = JButton("Show Save Dialog")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            val result = chooser.showSaveDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button2)

        // Example 3: JFileChooser for directories only
        add(JLabel("3. JFileChooser for directories only:"))
        val button3 = JButton("Show Directory Chooser")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY)
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected directory: " + chooser.getSelectedFile())
            }
        })
        add(button3)

        // Example 4: JFileChooser for files only
        add(JLabel("4. JFileChooser for files only:"))
        val button4 = JButton("Show Files Only Chooser")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY)
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button4)

        // Example 5: JFileChooser with multi-selection enabled
        add(JLabel("5. JFileChooser with multi-selection:"))
        val button5 = JButton("Show Multi-Selection Chooser")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setMultiSelectionEnabled(true)
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected files: " + chooser.getSelectedFiles().contentToString())
            }
        })
        add(button5)

        // Example 6: JFileChooser with file filter (e.g., TXT files)
        add(JLabel("6. JFileChooser with TXT file filter:"))
        val button6 = JButton("Show TXT Filter Chooser")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setFileFilter(FileNameExtensionFilter("TXT files", "txt"))
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button6)

        // Example 7: JFileChooser with custom approve button text
        add(JLabel("7. JFileChooser with custom approve button text:"))
        val button7 = JButton("Show Custom Approve Button")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setApproveButtonText("Select Now")
            val result = chooser.showDialog(parentFrame, "Custom Approve")
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button7)

        // Example 8: JFileChooser with accessory (e.g., a preview label)
        add(JLabel("8. JFileChooser with accessory (preview label):"))
        val button8 = JButton("Show With Accessory")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            val accessory = JLabel("Preview:")
            chooser.setAccessory(accessory)
            chooser.addPropertyChangeListener(PropertyChangeListener { evt: PropertyChangeEvent? ->
                if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY == evt!!.getPropertyName()) {
                    accessory.setText("Selected: " + chooser.getSelectedFile())
                }
            })
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button8)

        // Example 9: JFileChooser with custom dialog title
        add(JLabel("9. JFileChooser with custom dialog title:"))
        val button9 = JButton("Show Custom Title Chooser")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setDialogTitle("Custom Title File Chooser")
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button9)

        // Example 10: JFileChooser with file hiding disabled (show hidden files)
        add(JLabel("10. JFileChooser with file hiding disabled:"))
        val button10 = JButton("Show Hidden Files Chooser")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setFileHidingEnabled(false)
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button10)

        // Example 11: JFileChooser with specific current directory
        add(JLabel("11. JFileChooser with specific current directory (user home):"))
        val button11 = JButton("Show User Home Directory Chooser")
        button11.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser(System.getProperty("user.home"))
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected file: " + chooser.getSelectedFile())
            }
        })
        add(button11)

        // Example 12: JFileChooser for both files and directories
        add(JLabel("12. JFileChooser for files and directories:"))
        val button12 = JButton("Show Files and Directories Chooser")
        button12.addActionListener(ActionListener { e: ActionEvent? ->
            val chooser = JFileChooser()
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES)
            val result = chooser.showOpenDialog(parentFrame)
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(this, "Selected: " + chooser.getSelectedFile())
            }
        })
        add(button12)

        // Note: Additional configurations like setControlButtonsAreShown(false) for embedded use, but since we're using dialogs, not shown here.
        // For custom file views or more filters, can extend further.
    }
}
