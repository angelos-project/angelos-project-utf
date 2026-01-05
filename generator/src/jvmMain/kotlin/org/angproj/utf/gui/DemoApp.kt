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
package org.angproj.utf.gui

import javax.swing.JFrame
import javax.swing.JMenuBar
import javax.swing.SwingUtilities
import javax.swing.UIManager

object DemoAppKt {
    private lateinit var frame: JFrame
    private lateinit var menuBar: JMenuBar

    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater {
            try {
                // Set Java cross-platform Look and Feel (Metal)
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
            } catch (e: Exception) {
                e.printStackTrace()
            }

            gui {
                frame = frame {
                    title = "Swing Component Examples"
                }.build()
            }

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
            frame.setSize(800, 600)

             gui {
                menuBar = menuBar {
                    menu("File") {
                        item("Test") {
                            println("Test menu item clicked")
                        }
                    }
                }.build()
            }

            frame.setJMenuBar(menuBar)
            frame.setVisible(true)
        }
    }
}