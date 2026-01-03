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

import java.awt.Dialog
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class JDialogExample(private val parentFrame: JFrame?) : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JDialog (modeless, with parent)
        add(JLabel("1. Default JDialog (modeless, with parent):"))
        val button1 = JButton("Show Default Dialog")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Default Dialog")
            dialog.add(JLabel("This is a default dialog."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button1)

        // Example 2: Modal JDialog
        add(JLabel("2. Modal JDialog:"))
        val button2 = JButton("Show Modal Dialog")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Modal Dialog", true)
            dialog.add(JLabel("This is a modal dialog."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button2)

        // Example 3: JDialog without parent (top-level)
        add(JLabel("3. JDialog without parent:"))
        val button3 = JButton("Show Dialog without Parent")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog()
            dialog.setTitle("Dialog without Parent")
            dialog.add(JLabel("This is a dialog without parent."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button3)

        // Example 4: Undecorated JDialog
        add(JLabel("4. Undecorated JDialog:"))
        val button4 = JButton("Show Undecorated Dialog")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Undecorated Dialog")
            dialog.setUndecorated(true)
            dialog.add(JLabel("This is an undecorated dialog."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button4)

        // Example 5: Non-resizable JDialog
        add(JLabel("5. Non-resizable JDialog:"))
        val button5 = JButton("Show Non-resizable Dialog")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Non-resizable Dialog")
            dialog.setResizable(false)
            dialog.add(JLabel("This dialog is not resizable."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button5)

        // Example 6: JDialog with custom icon
        add(JLabel("6. JDialog with custom icon (using default icon for demo):"))
        val button6 = JButton("Show Dialog with Icon")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Dialog with Icon")
            // For demo, use a simple icon; in real use, load ImageIcon
            val icon = ImageIcon() // Placeholder; replace with actual icon
            dialog.setIconImage(icon.getImage())
            dialog.add(JLabel("This dialog has a custom icon."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button6)

        // Example 7: JDialog with APPLICATION_MODAL modality
        add(JLabel("7. JDialog with APPLICATION_MODAL:"))
        val button7 = JButton("Show Application Modal Dialog")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Application Modal Dialog", Dialog.ModalityType.APPLICATION_MODAL)
            dialog.add(JLabel("This is an application modal dialog."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button7)

        // Example 8: JDialog with DOCUMENT_MODAL modality
        add(JLabel("8. JDialog with DOCUMENT_MODAL:"))
        val button8 = JButton("Show Document Modal Dialog")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Document Modal Dialog", Dialog.ModalityType.DOCUMENT_MODAL)
            dialog.add(JLabel("This is a document modal dialog."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button8)

        // Example 9: JDialog with TOOLKIT_MODAL modality
        add(JLabel("9. JDialog with TOOLKIT_MODAL:"))
        val button9 = JButton("Show Toolkit Modal Dialog")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Toolkit Modal Dialog", Dialog.ModalityType.TOOLKIT_MODAL)
            dialog.add(JLabel("This is a toolkit modal dialog."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button9)

        // Example 10: JDialog with MODELESS modality
        add(JLabel("10. JDialog with MODELESS:"))
        val button10 = JButton("Show Modeless Dialog")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            val dialog = JDialog(parentFrame, "Modeless Dialog", Dialog.ModalityType.MODELESS)
            dialog.add(JLabel("This is a modeless dialog."))
            dialog.setSize(300, 200)
            dialog.setVisible(true)
        })
        add(button10)

        // Note: For icons, you would use ImageIcon with actual paths.
        // Additional configurations like setLocationRelativeTo, setDefaultCloseOperation, etc., can be added similarly.
    }
}
