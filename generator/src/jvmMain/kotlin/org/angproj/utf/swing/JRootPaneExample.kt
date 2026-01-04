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
import java.awt.Graphics
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class JRootPaneExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JRootPane in a JFrame
        add(JLabel("1. Default JRootPane in a JFrame:"))
        val button1 = JButton("Show Default JFrame")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Default JRootPane")
            frame.add(JLabel("This is the content pane."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button1)

        // Example 2: JRootPane with custom content pane
        add(JLabel("2. JRootPane with custom content pane:"))
        val button2 = JButton("Show with Custom Content Pane")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Custom Content Pane")
            val customContent = JPanel()
            customContent.add(JLabel("Custom Content"))
            frame.getRootPane().setContentPane(customContent)
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button2)

        // Example 3: JRootPane with glass pane visible
        add(JLabel("3. JRootPane with glass pane visible (red overlay):"))
        val button3 = JButton("Show with Glass Pane")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Glass Pane Example")
            frame.add(JLabel("Content below glass pane."))
            val glass: JPanel = object : JPanel() {
                override fun paintComponent(g: Graphics) {
                    g.setColor(Color(255, 0, 0, 100))
                    g.fillRect(0, 0, getWidth(), getHeight())
                }
            }
            glass.setOpaque(false)
            frame.getRootPane().setGlassPane(glass)
            glass.setVisible(true)
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button3)

        // Example 4: JRootPane with NONE window decoration style (undecorated)
        add(JLabel("4. JRootPane with NONE window decoration (undecorated):"))
        val button4 = JButton("Show Undecorated JFrame")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Undecorated")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE)
            frame.add(JLabel("No decorations."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button4)

        // Example 5: JRootPane with FRAME window decoration style
        add(JLabel("5. JRootPane with FRAME window decoration:"))
        val button5 = JButton("Show with FRAME Decoration")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Frame Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME)
            frame.add(JLabel("Frame style decorations."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button5)

        // Example 6: JRootPane with INFORMATION_DIALOG window decoration
        add(JLabel("6. JRootPane with INFORMATION_DIALOG decoration:"))
        val button6 = JButton("Show Information Dialog Decoration")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Info Dialog Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG)
            frame.add(JLabel("Information dialog style."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button6)

        // Example 7: JRootPane with WARNING_DIALOG window decoration
        add(JLabel("7. JRootPane with WARNING_DIALOG decoration:"))
        val button7 = JButton("Show Warning Dialog Decoration")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Warning Dialog Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG)
            frame.add(JLabel("Warning dialog style."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button7)

        // Example 8: JRootPane with ERROR_DIALOG window decoration
        add(JLabel("8. JRootPane with ERROR_DIALOG decoration:"))
        val button8 = JButton("Show Error Dialog Decoration")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Error Dialog Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.ERROR_DIALOG)
            frame.add(JLabel("Error dialog style."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button8)

        // Example 9: JRootPane with QUESTION_DIALOG window decoration
        add(JLabel("9. JRootPane with QUESTION_DIALOG decoration:"))
        val button9 = JButton("Show Question Dialog Decoration")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Question Dialog Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG)
            frame.add(JLabel("Question dialog style."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button9)

        // Example 10: JRootPane with COLOR_CHOOSER_DIALOG window decoration
        add(JLabel("10. JRootPane with COLOR_CHOOSER_DIALOG decoration:"))
        val button10 = JButton("Show Color Chooser Dialog Decoration")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Color Chooser Dialog Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG)
            frame.add(JLabel("Color chooser dialog style."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button10)

        // Example 11: JRootPane with FILE_CHOOSER_DIALOG window decoration
        add(JLabel("11. JRootPane with FILE_CHOOSER_DIALOG decoration:"))
        val button11 = JButton("Show File Chooser Dialog Decoration")
        button11.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("File Chooser Dialog Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG)
            frame.add(JLabel("File chooser dialog style."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button11)

        // Example 12: JRootPane with PLAIN_DIALOG window decoration
        add(JLabel("12. JRootPane with PLAIN_DIALOG decoration:"))
        val button12 = JButton("Show Plain Dialog Decoration")
        button12.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JFrame("Plain Dialog Decoration")
            frame.setUndecorated(true)
            frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG)
            frame.add(JLabel("Plain dialog style."))
            frame.setSize(300, 200)
            frame.setVisible(true)
        })
        add(button12)

        // Note: Window decorations require the frame to be undecorated for the style to take effect.
        // Additional properties like optimized drawing are internal and not directly configurable.
    }
}
