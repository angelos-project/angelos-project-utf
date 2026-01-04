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
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class JLayeredPaneExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Note: JLayeredPane uses absolute positioning, so examples will overlap to demonstrate layers.

        // Example 1: Default JLayeredPane with components in DEFAULT_LAYER
        add(JLabel("1. Default JLayeredPane with components in DEFAULT_LAYER:"))
        val layered1 = JLayeredPane()
        layered1.setPreferredSize(Dimension(300, 150))
        layered1.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        val panel1a = JPanel()
        panel1a.add(JLabel("Layer 0 (Default)"))
        panel1a.setBackground(Color.RED)
        panel1a.setBounds(10, 10, 100, 50)
        layered1.add(panel1a, JLayeredPane.DEFAULT_LAYER)
        val panel1b = JPanel()
        panel1b.add(JLabel("Also Layer 0"))
        panel1b.setBackground(Color.GREEN)
        panel1b.setBounds(50, 30, 100, 50)
        layered1.add(panel1b, JLayeredPane.DEFAULT_LAYER)
        add(layered1)

        // Example 2: JLayeredPane with component in PALETTE_LAYER (above default)
        add(JLabel("2. JLayeredPane with component in PALETTE_LAYER:"))
        val layered2 = JLayeredPane()
        layered2.setPreferredSize(Dimension(300, 150))
        layered2.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        val panel2a = JPanel()
        panel2a.add(JLabel("Layer 0"))
        panel2a.setBackground(Color.RED)
        panel2a.setBounds(10, 10, 100, 50)
        layered2.add(panel2a, JLayeredPane.DEFAULT_LAYER)
        val panel2b = JPanel()
        panel2b.add(JLabel("Palette Layer (100)"))
        panel2b.setBackground(Color.BLUE)
        panel2b.setBounds(50, 30, 100, 50)
        layered2.add(panel2b, JLayeredPane.PALETTE_LAYER)
        add(layered2)

        // Example 3: JLayeredPane with component in MODAL_LAYER (above palette)
        add(JLabel("3. JLayeredPane with component in MODAL_LAYER:"))
        val layered3 = JLayeredPane()
        layered3.setPreferredSize(Dimension(300, 150))
        layered3.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        val panel3a = JPanel()
        panel3a.add(JLabel("Layer 0"))
        panel3a.setBackground(Color.RED)
        panel3a.setBounds(10, 10, 100, 50)
        layered3.add(panel3a, JLayeredPane.DEFAULT_LAYER)
        val panel3b = JPanel()
        panel3b.add(JLabel("Modal Layer (200)"))
        panel3b.setBackground(Color.CYAN)
        panel3b.setBounds(50, 30, 100, 50)
        layered3.add(panel3b, JLayeredPane.MODAL_LAYER)
        add(layered3)

        // Example 4: JLayeredPane with component in POPUP_LAYER (above modal)
        add(JLabel("4. JLayeredPane with component in POPUP_LAYER:"))
        val layered4 = JLayeredPane()
        layered4.setPreferredSize(Dimension(300, 150))
        layered4.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        val panel4a = JPanel()
        panel4a.add(JLabel("Layer 0"))
        panel4a.setBackground(Color.RED)
        panel4a.setBounds(10, 10, 100, 50)
        layered4.add(panel4a, JLayeredPane.DEFAULT_LAYER)
        val panel4b = JPanel()
        panel4b.add(JLabel("Popup Layer (300)"))
        panel4b.setBackground(Color.MAGENTA)
        panel4b.setBounds(50, 30, 100, 50)
        layered4.add(panel4b, JLayeredPane.POPUP_LAYER)
        add(layered4)

        // Example 5: JLayeredPane with component in DRAG_LAYER (above popup)
        add(JLabel("5. JLayeredPane with component in DRAG_LAYER:"))
        val layered5 = JLayeredPane()
        layered5.setPreferredSize(Dimension(300, 150))
        layered5.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        val panel5a = JPanel()
        panel5a.add(JLabel("Layer 0"))
        panel5a.setBackground(Color.RED)
        panel5a.setBounds(10, 10, 100, 50)
        layered5.add(panel5a, JLayeredPane.DEFAULT_LAYER)
        val panel5b = JPanel()
        panel5b.add(JLabel("Drag Layer (400)"))
        panel5b.setBackground(Color.ORANGE)
        panel5b.setBounds(50, 30, 100, 50)
        layered5.add(panel5b, JLayeredPane.DRAG_LAYER)
        add(layered5)

        // Example 6: JLayeredPane with custom layer (e.g., between default and palette)
        add(JLabel("6. JLayeredPane with custom layer (50):"))
        val layered6 = JLayeredPane()
        layered6.setPreferredSize(Dimension(300, 150))
        layered6.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        val panel6a = JPanel()
        panel6a.add(JLabel("Layer 0"))
        panel6a.setBackground(Color.RED)
        panel6a.setBounds(10, 10, 100, 50)
        layered6.add(panel6a, JLayeredPane.DEFAULT_LAYER)
        val panel6b = JPanel()
        panel6b.add(JLabel("Custom Layer 50"))
        panel6b.setBackground(Color.YELLOW)
        panel6b.setBounds(50, 30, 100, 50)
        layered6.add(panel6b, 50)
        add(layered6)

        // Example 7: JLayeredPane with moveToFront
        add(JLabel("7. JLayeredPane with moveToFront (click button to move red to front):"))
        val layered7 = JLayeredPane()
        layered7.setPreferredSize(Dimension(300, 150))
        layered7.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        val panel7a = JPanel()
        panel7a.add(JLabel("Layer 0 - Red"))
        panel7a.setBackground(Color.RED)
        panel7a.setBounds(10, 10, 100, 50)
        layered7.add(panel7a, JLayeredPane.DEFAULT_LAYER)
        val panel7b = JPanel()
        panel7b.add(JLabel("Layer 0 - Green"))
        panel7b.setBackground(Color.GREEN)
        panel7b.setBounds(50, 30, 100, 50)
        layered7.add(panel7b, JLayeredPane.DEFAULT_LAYER)
        val moveButton = JButton("Move Red to Front")
        moveButton.addActionListener(ActionListener { e: ActionEvent? -> layered7.moveToFront(panel7a) })
        add(layered7)
        add(moveButton)

        // ?
        // Example 8: JLayeredPane with optimized drawing disabled
        add(JLabel("8. JLayeredPane with optimized drawing disabled:"))
        val layered8 = JLayeredPane()
        layered8.setPreferredSize(Dimension(300, 150))
        layered8.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        //layered8.setOptimizedDrawingEnabled(false);
        val panel8a = JPanel()
        panel8a.add(JLabel("Layer 0"))
        panel8a.setBackground(Color.RED)
        panel8a.setBounds(10, 10, 100, 50)
        layered8.add(panel8a, JLayeredPane.DEFAULT_LAYER)
        val panel8b = JPanel()
        panel8b.add(JLabel("Palette Layer"))
        panel8b.setBackground(Color.BLUE)
        panel8b.setBounds(50, 30, 100, 50)
        layered8.add(panel8b, JLayeredPane.PALETTE_LAYER)
        add(layered8)

        // Note: JLayeredPane requires manual bounds setting for components.
        // Additional methods like moveToBack, setPosition, etc., can be demonstrated similarly.
    }
}
