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

import java.awt.*
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JViewport

internal class JViewportExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // ?
        // Example 1: Default JViewport with view
        add(JLabel("1. Default JViewport with view:"))
        val viewport1 = JViewport()
        viewport1.setView(createLargeView())
        viewport1.setPreferredSize(Dimension(200, 100))
        //viewport1.setBorder(BorderFactory.createLineBorder(Color.BLACK)) // To visualize
        add(viewport1)

        // Example 2: JViewport with backing store enabled (default true)
        add(JLabel("2. JViewport with backing store enabled:"))
        val viewport2 = JViewport()
        viewport2.setView(createLargeView())
        viewport2.setBackingStoreEnabled(true)
        viewport2.setPreferredSize(Dimension(200, 100))
        //viewport2.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport2)

        // Example 3: JViewport with backing store disabled
        add(JLabel("3. JViewport with backing store disabled:"))
        val viewport3 = JViewport()
        viewport3.setView(createLargeView())
        viewport3.setBackingStoreEnabled(false)
        viewport3.setPreferredSize(Dimension(200, 100))
        //viewport3.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport3)

        // Example 4: JViewport with scroll mode BLIT_SCROLL_MODE (default)
        add(JLabel("4. JViewport with BLIT_SCROLL_MODE:"))
        val viewport4 = JViewport()
        viewport4.setView(createLargeView())
        viewport4.setScrollMode(JViewport.BLIT_SCROLL_MODE)
        viewport4.setPreferredSize(Dimension(200, 100))
        //viewport4.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport4)

        // Example 5: JViewport with BACKINGSTORE_SCROLL_MODE
        add(JLabel("5. JViewport with BACKINGSTORE_SCROLL_MODE:"))
        val viewport5 = JViewport()
        viewport5.setView(createLargeView())
        viewport5.setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE)
        viewport5.setPreferredSize(Dimension(200, 100))
        //viewport5.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport5)

        // Example 6: JViewport with SIMPLE_SCROLL_MODE
        add(JLabel("6. JViewport with SIMPLE_SCROLL_MODE:"))
        val viewport6 = JViewport()
        viewport6.setView(createLargeView())
        viewport6.setScrollMode(JViewport.SIMPLE_SCROLL_MODE)
        viewport6.setPreferredSize(Dimension(200, 100))
        //viewport6.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport6)

        // Example 7: JViewport with custom view position
        add(JLabel("7. JViewport with custom view position (scrolled to (50, 50)):"))
        val viewport7 = JViewport()
        viewport7.setView(createLargeView())
        viewport7.setViewPosition(Point(50, 50))
        viewport7.setPreferredSize(Dimension(200, 100))
        //viewport7.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport7)

        // Example 8: JViewport with custom extent size
        add(JLabel("8. JViewport with custom extent size (150x80):"))
        val viewport8 = JViewport()
        viewport8.setView(createLargeView())
        viewport8.setExtentSize(Dimension(150, 80))
        viewport8.setPreferredSize(Dimension(150, 80))
        //viewport8.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport8)

        // Example 9: JViewport with tooltip
        add(JLabel("9. JViewport with tooltip (hover to see):"))
        val viewport9 = JViewport()
        viewport9.setView(createLargeView())
        viewport9.setToolTipText("This is a tooltip!")
        viewport9.setPreferredSize(Dimension(200, 100))
        //viewport9.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport9)

        // Example 10: Disabled JViewport
        add(JLabel("10. Disabled JViewport:"))
        val viewport10 = JViewport()
        viewport10.setView(createLargeView())
        viewport10.setEnabled(false)
        viewport10.setPreferredSize(Dimension(200, 100))
        //viewport10.setBorder(BorderFactory.createLineBorder(Color.BLACK))
        add(viewport10)

        // Note: JViewport is typically used inside JScrollPane, but shown standalone here for demo.
        // In practice, use with JScrollPane for scrollbars.
    }

    // Helper method to create a large view component
    private fun createLargeView(): Component {
        val largePanel = JPanel()
        largePanel.setPreferredSize(Dimension(400, 300))
        largePanel.setBackground(Color.LIGHT_GRAY)
        largePanel.add(JLabel("Large View Content"))
        return largePanel
    }
}
