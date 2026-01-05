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
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.UIManager

object DemoAppKt {
    private lateinit var frame: JFrame

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
                    menuBar {
                        menu("File") {
                            item("Test") {
                                println("Test menu item clicked")
                            }
                            separator()
                            item ("Exit") {
                                frame.dispose()
                            }
                        }
                    }
                    content {
                        label("Hello, World!")
                        label("This is a demo application using the GUI DSL.")
                        label {
                            text = "This label has custom font and color."
                            font = font.deriveFont(16f)
                            foreground = java.awt.Color.BLUE
                        }
                    }
                    onClose(JFrame.EXIT_ON_CLOSE)
                }.build()
            }

            frame.setSize(800, 600)

            frame.setVisible(true)
        }
    }

    private fun switchPanel(newPanel: JPanel) {
        frame.contentPane = newPanel
        frame.revalidate()
        frame.repaint()
    }
}