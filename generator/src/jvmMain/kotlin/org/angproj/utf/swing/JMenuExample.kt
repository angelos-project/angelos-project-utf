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
import java.awt.event.KeyEvent
import javax.swing.*

internal class JMenuExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Note: JMenu is typically added to JMenuBar, but for demonstration, we're adding them directly to the panel.
        // They will appear as clickable components that show their popup menu.

        // Example 1: Default JMenu without text
        add(JLabel("1. Default JMenu without text:"))
        val menu1 = JMenu()
        menu1.add(JMenuItem("Item 1"))
        menu1.add(JMenuItem("Item 2"))
        add(menu1)

        // Example 2: JMenu with text
        add(JLabel("2. JMenu with text:"))
        val menu2 = JMenu("Menu")
        menu2.add(JMenuItem("Item 1"))
        menu2.add(JMenuItem("Item 2"))
        add(menu2)

        // Example 3: Disabled JMenu
        add(JLabel("3. Disabled JMenu:"))
        val menu3 = JMenu("Disabled Menu")
        menu3.setEnabled(false)
        menu3.add(JMenuItem("Item 1"))
        add(menu3)

        // Example 4: JMenu with mnemonic (Alt + M)
        add(JLabel("4. JMenu with mnemonic (Alt + M):"))
        val menu4 = JMenu("Mnemonic Menu")
        menu4.setMnemonic(KeyEvent.VK_M)
        menu4.add(JMenuItem("Item 1"))
        add(menu4)

        // Example 5: JMenu with tooltip
        add(JLabel("5. JMenu with tooltip (hover to see):"))
        val menu5 = JMenu("Menu with Tooltip")
        menu5.setToolTipText("This is a tooltip!")
        menu5.add(JMenuItem("Item 1"))
        add(menu5)

        // Example 6: JMenu with custom colors
        add(JLabel("6. JMenu with custom colors:"))
        val menu6 = JMenu("Colored Menu")
        menu6.setBackground(Color.YELLOW)
        menu6.setForeground(Color.RED)
        menu6.add(JMenuItem("Item 1"))
        add(menu6)

        // Example 7: JMenu with rollover enabled
        add(JLabel("7. JMenu with rollover enabled:"))
        val menu7 = JMenu("Rollover Menu")
        menu7.setRolloverEnabled(true)
        menu7.add(JMenuItem("Item 1"))
        add(menu7)

        // Example 8: JMenu with delay (popup delay in ms)
        add(JLabel("8. JMenu with delay (500ms):"))
        val menu8 = JMenu("Delayed Menu")
        menu8.setDelay(500)
        menu8.add(JMenuItem("Item 1"))
        add(menu8)

        // Example 9: JMenu with left-aligned text
        add(JLabel("9. JMenu with left-aligned text:"))
        val menu9 = JMenu("Left Aligned")
        menu9.setHorizontalAlignment(SwingConstants.LEFT)
        menu9.add(JMenuItem("Item 1"))
        add(menu9)

        // Example 10: JMenu as submenu with nested menus
        add(JLabel("10. JMenu as submenu:"))
        val menu10 = JMenu("Parent Menu")
        val submenu = JMenu("Submenu")
        submenu.add(JMenuItem("Sub Item 1"))
        menu10.add(submenu)
        add(menu10)

        // Note: For icons, you would use setIcon(new ImageIcon("path/to/icon.png"));
        // But since no images are provided, omitting icon examples here.
    }
}
