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

import java.awt.AWTEvent
import java.awt.Color
import java.awt.Graphics
import java.awt.GridLayout
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import javax.swing.*
import javax.swing.plaf.LayerUI

internal class JLayerExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Basic JLayer around a JButton
        add(JLabel("1. Basic JLayer around a JButton:"))
        val button1 = JButton("Button inside JLayer")
        val layer1 = JLayer<JButton?>(button1)
        add(layer1)

        // Example 2: JLayer with custom LayerUI (highlight on mouse over)
        add(JLabel("2. JLayer with LayerUI (highlight on mouse over):"))
        val button2 = JButton("Hover me")
        val ui2: LayerUI<JButton?> = object : LayerUI<JButton?>() {
            override fun paint(g: Graphics, c: JComponent) {
                super.paint(g, c)
                if (c.getMousePosition() != null) {
                    g.setColor(Color(255, 0, 0, 50))
                    g.fillRect(0, 0, c.getWidth(), c.getHeight())
                }
            }

            override fun installUI(c: JComponent) {
                super.installUI(c)
                (c as JLayer<*>).setLayerEventMask(AWTEvent.MOUSE_MOTION_EVENT_MASK)
            }

            override fun uninstallUI(c: JComponent) {
                (c as JLayer<*>).setLayerEventMask(0)
                super.uninstallUI(c)
            }

            override fun processMouseMotionEvent(e: MouseEvent?, l: JLayer<out JButton?>) {
                l.repaint()
            }
        }
        val layer2 = JLayer<JButton?>(button2, ui2)
        add(layer2)

        // Example 3: JLayer around a JPanel with components
        add(JLabel("3. JLayer around a JPanel:"))
        val panel3 = JPanel()
        panel3.add(JLabel("Label"))
        panel3.add(JButton("Button"))
        val layer3 = JLayer<JPanel?>(panel3)
        add(layer3)

        // Example 4: JLayer with blur effect (simple overlay)
        add(JLabel("4. JLayer with simple blur-like overlay:"))
        val button4 = JButton("Blurred Button")
        val ui4: LayerUI<JButton?> = object : LayerUI<JButton?>() {
            override fun paint(g: Graphics, c: JComponent) {
                super.paint(g, c)
                g.setColor(Color(0, 0, 0, 100))
                g.fillRect(0, 0, c.getWidth(), c.getHeight())
            }
        }
        val layer4 = JLayer<JButton?>(button4, ui4)
        add(layer4)

        // Example 5: Disabled JLayer (disables view)
        add(JLabel("5. Disabled JLayer:"))
        val button5 = JButton("Disabled via JLayer")
        val layer5 = JLayer<JButton?>(button5)
        layer5.setEnabled(false)
        add(layer5)

        // Example 6: JLayer with tooltip on layer
        add(JLabel("6. JLayer with tooltip:"))
        val button6 = JButton("Button with Layer Tooltip")
        val layer6 = JLayer<JButton?>(button6)
        layer6.setToolTipText("This is a tooltip on the layer!")
        add(layer6)

        // Example 7: JLayer with event mask (key events)
        add(JLabel("7. JLayer processing key events (press key):"))
        val field7 = JTextField("Type here")
        val ui7: LayerUI<JTextField?> = object : LayerUI<JTextField?>() {
            override fun installUI(c: JComponent) {
                super.installUI(c)
                (c as JLayer<*>).setLayerEventMask(AWTEvent.KEY_EVENT_MASK)
            }

            override fun uninstallUI(c: JComponent) {
                (c as JLayer<*>).setLayerEventMask(0)
                super.uninstallUI(c)
            }

            override fun processKeyEvent(e: KeyEvent, l: JLayer<out JTextField?>?) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JOptionPane.showMessageDialog(l, "Enter pressed!")
                }
            }
        }
        val layer7 = JLayer<JTextField?>(field7, ui7)
        add(layer7)

        // Example 8: JLayer with custom painting (border)
        add(JLabel("8. JLayer with custom border painting:"))
        val button8 = JButton("Button with Layer Border")
        val ui8: LayerUI<JButton?> = object : LayerUI<JButton?>() {
            override fun paint(g: Graphics, c: JComponent) {
                super.paint(g, c)
                g.setColor(Color.BLUE)
                g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1)
            }
        }
        val layer8 = JLayer<JButton?>(button8, ui8)
        add(layer8)

        // Note: More advanced effects require custom LayerUI implementations.
        // For glass pane like effects, JLayer can be used similarly.
    }
}
