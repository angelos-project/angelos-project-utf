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

internal class JDesktopPaneExample(private val parentFrame: JFrame?) : JPanel() {
    init {
        setLayout(BorderLayout())
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // JDesktopPane is typically used with JInternalFrames, so we'll embed one here
        val desktopPane = JDesktopPane()
        add(desktopPane, BorderLayout.CENTER)

        // Panel for control buttons
        val controlPanel = JPanel(FlowLayout())
        add(controlPanel, BorderLayout.SOUTH)

        // Example 1: Add a basic JInternalFrame
        val button1 = JButton("Add Basic Internal Frame")
        button1.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Basic Frame", true, true, true, true)
            frame.add(JLabel("This is a basic internal frame."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame)
        })
        controlPanel.add(button1)

        // Example 2: JDesktopPane with continuous drag mode
        val button2 = JButton("Set Continuous Drag Mode")
        button2.addActionListener(ActionListener { e: ActionEvent? ->
            desktopPane.setDragMode(JDesktopPane.LIVE_DRAG_MODE)
            JOptionPane.showMessageDialog(this, "Drag mode set to continuous (live).")
        })
        controlPanel.add(button2)

        // Example 3: JDesktopPane with outline drag mode (default)
        val button3 = JButton("Set Outline Drag Mode")
        button3.addActionListener(ActionListener { e: ActionEvent? ->
            desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE)
            JOptionPane.showMessageDialog(this, "Drag mode set to outline.")
        })
        controlPanel.add(button3)

        // Example 4: Add layered JInternalFrame (e.g., in palette layer)
        val button4 = JButton("Add Frame in Palette Layer")
        button4.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Palette Layer Frame", true, true, true, true)
            frame.add(JLabel("This frame is in the palette layer."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame, JLayeredPane.PALETTE_LAYER)
        })
        controlPanel.add(button4)

        // Example 5: Add modal JInternalFrame (using JLayeredPane.MODAL_LAYER)
        val button5 = JButton("Add Modal Layer Frame")
        button5.addActionListener(ActionListener { e: ActionEvent? ->
            val frame = JInternalFrame("Modal Layer Frame", true, true, true, true)
            frame.add(JLabel("This frame is in the modal layer."))
            frame.setSize(200, 150)
            frame.setVisible(true)
            desktopPane.add(frame, JLayeredPane.MODAL_LAYER)
        })
        controlPanel.add(button5)

        // Example 6: Select all frames
        val button6 = JButton("Select All Frames")
        button6.addActionListener(ActionListener { e: ActionEvent? ->
            for (f in desktopPane.getAllFrames()) {
                try {
                    f.setSelected(true)
                } catch (ex: PropertyVetoException) {
                    ex.printStackTrace()
                }
            }
            JOptionPane.showMessageDialog(this, "All frames selected.")
        })
        controlPanel.add(button6)

        // Example 7: Cascade frames
        val button7 = JButton("Cascade Frames")
        button7.addActionListener(ActionListener { e: ActionEvent? ->
            val frames = desktopPane.getAllFrames()
            var x = 0
            var y = 0
            for (f in frames) {
                f.setLocation(x, y)
                f.setSize(200, 150)
                x += 20
                y += 20
            }
            JOptionPane.showMessageDialog(this, "Frames cascaded.")
        })
        controlPanel.add(button7)

        // Example 8: Tile frames horizontally
        val button8 = JButton("Tile Horizontally")
        button8.addActionListener(ActionListener { e: ActionEvent? ->
            val frames = desktopPane.getAllFrames()
            if (frames.size > 0) {
                val height = desktopPane.getHeight() / frames.size
                var y = 0
                for (f in frames) {
                    f.setBounds(0, y, desktopPane.getWidth(), height)
                    y += height
                }
            }
            JOptionPane.showMessageDialog(this, "Frames tiled horizontally.")
        })
        controlPanel.add(button8)

        // Example 9: Tile frames vertically
        val button9 = JButton("Tile Vertically")
        button9.addActionListener(ActionListener { e: ActionEvent? ->
            val frames = desktopPane.getAllFrames()
            if (frames.size > 0) {
                val width = desktopPane.getWidth() / frames.size
                var x = 0
                for (f in frames) {
                    f.setBounds(x, 0, width, desktopPane.getHeight())
                    x += width
                }
            }
            JOptionPane.showMessageDialog(this, "Frames tiled vertically.")
        })
        controlPanel.add(button9)

        // Example 10: Close all frames
        val button10 = JButton("Close All Frames")
        button10.addActionListener(ActionListener { e: ActionEvent? ->
            for (f in desktopPane.getAllFrames()) {
                f.dispose()
            }
            JOptionPane.showMessageDialog(this, "All frames closed.")
        })
        controlPanel.add(button10)

        // Note: JDesktopPane can have background set, e.g., desktopPane.setBackground(Color.LIGHT_GRAY);
        // But for simplicity, not added here.
        // Additional features like desktop manager customization can be explored further.
    }
}
