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
import java.awt.GridLayout
import java.awt.event.AdjustmentEvent
import java.awt.event.AdjustmentListener
import javax.swing.*

internal class JScrollBarExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JScrollBar (horizontal, 0-100)
        add(JLabel("1. Default JScrollBar (horizontal, 0-100):"))
        val bar1 = JScrollBar()
        bar1.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar1.getValue()
            )
        })
        add(bar1)

        // Example 2: Vertical JScrollBar
        add(JLabel("2. Vertical JScrollBar:"))
        val bar2 = JScrollBar(SwingConstants.VERTICAL)
        bar2.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar2.getValue()
            )
        })
        add(bar2)

        // Example 3: JScrollBar with custom min, max, value, extent
        add(JLabel("3. JScrollBar with custom min (0), max (200), value (50), extent (20):"))
        val bar3 = JScrollBar(SwingConstants.HORIZONTAL, 50, 20, 0, 200)
        bar3.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar3.getValue()
            )
        })
        add(bar3)

        // Example 4: Disabled JScrollBar
        add(JLabel("4. Disabled JScrollBar:"))
        val bar4 = JScrollBar()
        bar4.setEnabled(false)
        add(bar4)

        // Example 5: JScrollBar with tooltip
        add(JLabel("5. JScrollBar with tooltip (hover to see):"))
        val bar5 = JScrollBar()
        bar5.setToolTipText("This is a tooltip!")
        bar5.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar5.getValue()
            )
        })
        add(bar5)

        // Example 6: JScrollBar with custom unit and block increments
        add(JLabel("6. JScrollBar with unit (5) and block (20) increments:"))
        val bar6 = JScrollBar()
        bar6.setUnitIncrement(5)
        bar6.setBlockIncrement(20)
        bar6.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar6.getValue()
            )
        })
        add(bar6)

        // Example 7: JScrollBar with custom background and foreground
        add(JLabel("7. JScrollBar with custom colors:"))
        val bar7 = JScrollBar()
        bar7.setBackground(Color.YELLOW)
        bar7.setForeground(Color.RED)
        bar7.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar7.getValue()
            )
        })
        add(bar7)

        // Example 8: JScrollBar without border painted
        add(JLabel("8. JScrollBar without border:"))
        val bar8 = JScrollBar()
        bar8.setBorder(null)
        bar8.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar8.getValue()
            )
        })
        add(bar8)

        // ?
        // Example 9: JScrollBar with inverted direction
        add(JLabel("9. JScrollBar with inverted direction:"))
        val bar9 = JScrollBar()
        //bar9.setInverted(true);
        bar9.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar9.getValue()
            )
        })
        add(bar9)

        // Example 10: JScrollBar with custom model
        add(JLabel("10. JScrollBar with custom model (min 0, max 500, value 100, extent 50):"))
        val model = DefaultBoundedRangeModel(100, 50, 0, 500)
        val bar10 = JScrollBar(SwingConstants.HORIZONTAL)
        bar10.setModel(model)
        bar10.addAdjustmentListener(AdjustmentListener { e: AdjustmentEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + bar10.getValue()
            )
        })
        add(bar10)

        // Note: JScrollBars can be attached to scroll panes, but for demo, standalone with listeners.
    }
}
