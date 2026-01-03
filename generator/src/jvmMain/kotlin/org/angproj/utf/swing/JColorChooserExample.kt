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

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.GridLayout
import javax.swing.*
import javax.swing.colorchooser.AbstractColorChooserPanel
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener

internal class JColorChooserExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // To make the panel scrollable since JColorChooser is large
        val scrollPane = JScrollPane(this)
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS)

        // Note: JColorChooser can be embedded directly.

        // Example 1: Default JColorChooser
        add(JLabel("1. Default JColorChooser:"))
        val chooser1 = JColorChooser()
        chooser1.getSelectionModel().addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Color selected: " + chooser1.getColor()
            )
        })
        add(chooser1)

        // Example 2: JColorChooser with initial color
        add(JLabel("2. JColorChooser with initial color (green):"))
        val chooser2 = JColorChooser(Color.GREEN)
        chooser2.getSelectionModel().addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Color selected: " + chooser2.getColor()
            )
        })
        add(chooser2)

        // Example 3: JColorChooser without preview panel
        add(JLabel("3. JColorChooser without preview panel:"))
        val chooser3 = JColorChooser()
        chooser3.setPreviewPanel(JPanel()) // Empty panel
        chooser3.getSelectionModel().addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Color selected: " + chooser3.getColor()
            )
        })
        add(chooser3)

        // Example 4: JColorChooser with only one chooser panel (e.g., Swatches)
        add(JLabel("4. JColorChooser with only Swatches panel:"))
        val chooser4 = JColorChooser()
        val panels4 = arrayOf<AbstractColorChooserPanel?>(chooser4.getChooserPanels()[0]) // Assuming first is Swatches
        chooser4.setChooserPanels(panels4)
        chooser4.getSelectionModel().addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Color selected: " + chooser4.getColor()
            )
        })
        add(chooser4)

        // Example 5: JColorChooser with drag enabled (for compatible panels like RGB/HSV)
        add(JLabel("5. JColorChooser with drag enabled:"))
        val chooser5 = JColorChooser()
        chooser5.setDragEnabled(true)
        chooser5.getSelectionModel().addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Color selected: " + chooser5.getColor()
            )
        })
        add(chooser5)

        // Example 6: JColorChooser with custom preview panel
        add(JLabel("6. JColorChooser with custom preview panel:"))
        val chooser6 = JColorChooser()
        val customPreview: JPanel = object : JPanel() {
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                g.setColor(chooser6.getColor())
                g.fillRect(0, 0, getWidth(), getHeight())
            }
        }
        customPreview.setPreferredSize(Dimension(100, 50))
        chooser6.setPreviewPanel(customPreview)
        chooser6.getSelectionModel().addChangeListener(ChangeListener { e: ChangeEvent? -> customPreview.repaint() })
        add(chooser6)

        // Example 7: JColorChooser with removed chooser panel (e.g., remove CMYK if present)
        add(JLabel("7. JColorChooser with removed CMYK panel (if present):"))
        val chooser7 = JColorChooser()
        val panels7 = chooser7.getChooserPanels()
        for (panel in panels7) {
            if ("CMYK" == panel.getDisplayName()) {
                chooser7.removeChooserPanel(panel)
            }
        }
        chooser7.getSelectionModel().addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Color selected: " + chooser7.getColor()
            )
        })
        add(chooser7)

        // Note: For more custom panels, you can extend AbstractColorChooserPanel and add via addChooserPanel.
        // But keeping it simple without custom implementation here.

        // To use in dialog: JColorChooser.showDialog(this, "Choose Color", Color.WHITE);
    }
}
