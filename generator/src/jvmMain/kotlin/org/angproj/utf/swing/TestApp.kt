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

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

object TestAppKt {
    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater(object : Runnable {
            override fun run() {
                try {
                    // Set Java cross-platform Look and Feel (Metal)
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                val frame = JFrame("Application Framework")
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
                frame.setSize(800, 600)

                val menuBar = JMenuBar()
                frame.setJMenuBar(menuBar)

                // Initial menu example: File menu with Exit
                val fileMenu = JMenu("File")
                val exitItem = JMenuItem("Exit")
                exitItem.addActionListener(object : ActionListener {
                    override fun actionPerformed(e: ActionEvent?) {
                        System.exit(0)
                    }
                })
                fileMenu.add(exitItem)
                menuBar.add(fileMenu)

                // Add more menus here as examples grow, e.g.:
                // JMenu exampleMenu = new JMenu("Example");
                // menuBar.add(exampleMenu);
                frame.setVisible(true)
            }
        })
    }
}
