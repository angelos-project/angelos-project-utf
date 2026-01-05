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
import java.util.*
import javax.swing.*
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener

internal class JSliderExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JSlider (horizontal, 0-100, value 50)
        add(JLabel("1. Default JSlider (horizontal, 0-100, value 50):"))
        val slider1 = JSlider()
        slider1.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider1.getValue()
            )
        })
        add(slider1)

        // Example 2: Vertical JSlider
        add(JLabel("2. Vertical JSlider:"))
        val slider2 = JSlider(SwingConstants.VERTICAL)
        slider2.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider2.getValue()
            )
        })
        add(slider2)

        // Example 3: JSlider with custom min, max, value (0-200, value 100)
        add(JLabel("3. JSlider with custom min (0), max (200), value (100):"))
        val slider3 = JSlider(0, 200, 100)
        slider3.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider3.getValue()
            )
        })
        add(slider3)

        // Example 4: JSlider with major and minor ticks
        add(JLabel("4. JSlider with major (20) and minor (5) ticks:"))
        val slider4 = JSlider()
        slider4.setMajorTickSpacing(20)
        slider4.setMinorTickSpacing(5)
        slider4.setPaintTicks(true)
        slider4.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider4.getValue()
            )
        })
        add(slider4)

        // Example 5: JSlider with labels painted
        add(JLabel("5. JSlider with labels painted:"))
        val slider5 = JSlider()
        slider5.setMajorTickSpacing(25)
        slider5.setPaintLabels(true)
        slider5.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider5.getValue()
            )
        })
        add(slider5)

        // Example 6: JSlider with snap to ticks
        add(JLabel("6. JSlider with snap to ticks:"))
        val slider6 = JSlider()
        slider6.setMajorTickSpacing(25)
        slider6.setSnapToTicks(true)
        slider6.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider6.getValue()
            )
        })
        add(slider6)

        // Example 7: JSlider without track painted
        add(JLabel("7. JSlider without track painted:"))
        val slider7 = JSlider()
        slider7.setPaintTrack(false)
        slider7.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider7.getValue()
            )
        })
        add(slider7)

        // Example 8: Inverted JSlider
        add(JLabel("8. Inverted JSlider:"))
        val slider8 = JSlider()
        slider8.setInverted(true)
        slider8.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider8.getValue()
            )
        })
        add(slider8)

        // Example 9: Disabled JSlider
        add(JLabel("9. Disabled JSlider:"))
        val slider9 = JSlider()
        slider9.setEnabled(false)
        add(slider9)

        // Example 10: JSlider with tooltip
        add(JLabel("10. JSlider with tooltip (hover to see):"))
        val slider10 = JSlider()
        slider10.setToolTipText("This is a tooltip!")
        slider10.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider10.getValue()
            )
        })
        add(slider10)

        // Example 11: JSlider with custom label table
        add(JLabel("11. JSlider with custom label table:"))
        val slider11 = JSlider(0, 100, 50)
        val labels = Hashtable<Int?, JLabel?>()
        labels.put(0, JLabel("Low"))
        labels.put(50, JLabel("Medium"))
        labels.put(100, JLabel("High"))
        slider11.setLabelTable(labels)
        slider11.setPaintLabels(true)
        slider11.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider11.getValue()
            )
        })
        add(slider11)

        // Example 12: JSlider with custom colors
        add(JLabel("12. JSlider with custom colors:"))
        val slider12 = JSlider()
        slider12.setBackground(Color.YELLOW)
        slider12.setForeground(Color.RED)
        slider12.addChangeListener(ChangeListener { e: ChangeEvent? ->
            JOptionPane.showMessageDialog(
                this,
                "Value changed to: " + slider12.getValue()
            )
        })
        add(slider12)

        // Note: For more custom UI, you can setUI, but keeping basic configurations.
    }
}
