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

import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.beans.PropertyVetoException
import javax.swing.*

internal class JInternalFrameExample : JPanel() {
    private val desktopPane: JDesktopPane

    init {
        setLayout(BorderLayout())
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        desktopPane = JDesktopPane()
        add(desktopPane, BorderLayout.CENTER)

        // Panel for control buttons
        val controlPanel = JPanel(FlowLayout())
        add(JScrollPane(controlPanel), BorderLayout.SOUTH) // Make controls scrollable if many

        // Example 1: Basic JInternalFrame (default: resizable, closable, maximizable, iconifiable)
        val button1 = JButton("Add Basic Internal Frame")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Basic Frame")
            frame.add(JLabel("This is a basic internal frame."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button1)

        // Example 2: JInternalFrame with title only
        val button2 = JButton("Add Frame with Title")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Titled Frame")
            frame.add(JLabel("This frame has a title."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button2)

        // Example 3: Non-resizable JInternalFrame
        val button3 = JButton("Add Non-Resizable Frame")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Non-Resizable", false)
            frame.add(JLabel("This frame is not resizable."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button3)

        // Example 4: Non-closable JInternalFrame
        val button4 = JButton("Add Non-Closable Frame")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Non-Closable", true, false)
            frame.add(JLabel("This frame is not closable."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button4)

        // Example 5: Non-maximizable JInternalFrame
        val button5 = JButton("Add Non-Maximizable Frame")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Non-Maximizable", true, true, false)
            frame.add(JLabel("This frame is not maximizable."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button5)

        // Example 6: Non-iconifiable JInternalFrame
        val button6 = JButton("Add Non-Iconifiable Frame")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Non-Iconifiable", true, true, true, false)
            frame.add(JLabel("This frame is not iconifiable."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button6)

        // Example 7: JInternalFrame with custom icon
        val button7 = JButton("Add Frame with Custom Icon")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Frame with Icon")
            // Placeholder icon; in real use, load ImageIcon
            val icon = ImageIcon()
            frame.setFrameIcon(icon)
            frame.add(JLabel("This frame has a custom icon."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button7)

        // Example 8: Iconified JInternalFrame on creation
        val button8 = JButton("Add Iconified Frame")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Iconified Frame")
            frame.add(JLabel("This frame starts iconified."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            try {
                frame.setIcon(true)
            } catch (ex: PropertyVetoException) {
                ex.printStackTrace()
            }
            desktopPane.add(frame)
        })
        controlPanel.add(button8)

        // Example 9: Maximized JInternalFrame on creation
        val button9 = JButton("Add Maximized Frame")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Maximized Frame")
            frame.add(JLabel("This frame starts maximized."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            try {
                frame.setMaximum(true)
            } catch (ex: PropertyVetoException) {
                ex.printStackTrace()
            }
            desktopPane.add(frame)
        })
        controlPanel.add(button9)

        // Example 10: JInternalFrame with JMenuBar
        val button10 = JButton("Add Frame with MenuBar")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Frame with MenuBar")
            val menuBar = JMenuBar()
            val menu = JMenu("File")
            menu.add(JMenuItem("Open"))
            menuBar.add(menu)
            frame.setJMenuBar(menuBar)
            frame.add(JLabel("This frame has a menu bar."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button10)

        // Example 11: JInternalFrame with custom layer
        val button11 = JButton("Add Frame in Custom Layer")
        button11.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Custom Layer Frame")
            frame.add(JLabel("This frame is in a custom layer."))
            frame.setSize(200, 150)
            frame.setLayer(1) // Above default layer 0
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button11)

        // Example 12: JInternalFrame with DO_NOTHING_ON_CLOSE
        val button12 = JButton("Add Frame with DO_NOTHING_ON_CLOSE")
        button12.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("DO_NOTHING_ON_CLOSE Frame")
            frame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE)
            frame.add(JLabel("Closing does nothing."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button12)

        // Example 13: Close all frames
        val button13 = JButton("Close All Frames")
        button13.addActionListener(ActionListener { e: ActionEvent? ->
            for (f in desktopPane.getAllFrames()) {
                try {
                    f.setClosed(true)
                } catch (ex: PropertyVetoException) {
                    ex.printStackTrace()
                }
            }
        })
        controlPanel.add(button13)

        // Note: Additional configurations like setGlassPane, vetoable change listeners, etc., can be added.
    }
}
