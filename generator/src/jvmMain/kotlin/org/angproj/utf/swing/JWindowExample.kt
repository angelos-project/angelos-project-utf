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
import java.awt.Dialog
import java.awt.GridLayout
import java.awt.Window
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.geom.RoundRectangle2D
import javax.swing.*

internal class JWindowExample(private val ownerFrame: JFrame?) : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JWindow (without owner)
        add(JLabel("1. Default JWindow (without owner):"))
        val button1 = JButton("Show Default Window")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.add(JLabel("This is a default window."))
            window.setSize(300, 200)
            window.setVisible(true)
        })
        add(button1)

        // Example 2: JWindow with owner (blocks input to owner)
        add(JLabel("2. JWindow with owner:"))
        val button2 = JButton("Show Window with Owner")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow(ownerFrame)
            window.add(JLabel("This window has an owner."))
            window.setSize(300, 200)
            window.setVisible(true)
        })
        add(button2)

        // Example 3: JWindow always on top
        add(JLabel("3. JWindow always on top:"))
        val button3 = JButton("Show Always on Top Window")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.add(JLabel("This window is always on top."))
            window.setAlwaysOnTop(true)
            window.setSize(300, 200)
            window.setVisible(true)
        })
        add(button3)

        // Example 4: JWindow with custom location (centered)
        add(JLabel("4. JWindow with custom location (centered):"))
        val button4 = JButton("Show Centered Window")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.add(JLabel("This window is centered."))
            window.setSize(300, 200)
            window.setLocationRelativeTo(ownerFrame)
            window.setVisible(true)
        })
        add(button4)

        // Example 5: JWindow with opacity (0.7f, requires Java 7+)
        add(JLabel("5. JWindow with opacity (0.7):"))
        val button5 = JButton("Show Semi-Transparent Window")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.add(JLabel("This window is semi-transparent."))
            window.setSize(300, 200)
            window.setOpacity(0.7f)
            window.setVisible(true)
        })
        add(button5)

        // Example 6: JWindow with shaped (round rectangle, requires Java 7+)
        add(JLabel("6. JWindow with shaped (round rectangle):"))
        val button6 = JButton("Show Shaped Window")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.add(JLabel("This is a shaped window."))
            window.setSize(300, 200)
            window.setShape(RoundRectangle2D.Double(0.0, 0.0, 300.0, 200.0, 50.0, 50.0))
            window.setVisible(true)
        })
        add(button6)

        // Example 7: JWindow with background color
        add(JLabel("7. JWindow with background color (yellow):"))
        val button7 = JButton("Show Colored Window")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.getContentPane().setBackground(Color.YELLOW)
            window.add(JLabel("This window has yellow background."))
            window.setSize(300, 200)
            window.setVisible(true)
        })
        add(button7)

        // Example 8: JWindow with modal exclusion (ignores modality of dialogs)
        add(JLabel("8. JWindow with modal exclusion:"))
        val button8 = JButton("Show Modal Excluded Window")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE)
            window.add(JLabel("This window excludes modality."))
            window.setSize(300, 200)
            window.setVisible(true)
        })
        add(button8)

        // Example 9: JWindow with type UTILITY
        add(JLabel("9. JWindow with type UTILITY:"))
        val button9 = JButton("Show Utility Window")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.setType(Window.Type.UTILITY)
            window.add(JLabel("This is a utility window."))
            window.setSize(300, 200)
            window.setVisible(true)
        })
        add(button9)

        // Example 10: JWindow with type POPUP
        add(JLabel("10. JWindow with type POPUP:"))
        val button10 = JButton("Show Popup Window")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            val window = JWindow()
            window.setType(Window.Type.POPUP)
            window.add(JLabel("This is a popup window."))
            window.setSize(300, 200)
            window.setVisible(true)
        })
        add(button10)

        // Note: JWindow is undecorated by default. For opacity and shape, requires per-pixel translucency support.
    }
}
