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

import javax.swing.JComponent
import javax.swing.JDesktopPane
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.JInternalFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.UIManager


object DemoWorkspaceKt {
    private lateinit var frame: JFrame
    private lateinit var desktop: JDesktopPane

    fun testPanel(): JPanel {
        var panel = JPanel()
        gui {
            panel = panel {
                label("This is a test panel")
                buildTextField {
                    text = "Edit Me"
                    onChange { newText ->
                        println("Text field changed: $newText")
                    }
                }
                buildCheckBox {
                    text = "Check Me"
                    isChecked = true
                    onChange { selected ->
                        println("Checkbox changed: $selected")
                    }
                }
                buildButton {
                    text = "Click Me"
                    onClick {
                        println("Button in test panel clicked")
                    }
                }
            }.build()
        }
        return panel
    }

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
                    fullSize()
                    menuBar {
                        menu("File") {
                            item("New Frame") {
                                val internalFrame = JInternalFrame(
                                    "Internal Frame",
                                    true,
                                    true,
                                    true,
                                    true
                                )
                                internalFrame.setSize(300, 200)
                                internalFrame.contentPane = testPanel()
                                internalFrame.pack()
                                desktop.add(internalFrame)
                                internalFrame.isVisible = true
                            }
                            item("New Dialog") {
                                val dialog = JDialog(frame, "Dialog", true)
                                dialog.contentPane = testPanel()
                                dialog.pack()
                                dialog.isVisible = true
                            }
                            separator()
                            item ("Exit") {
                                frame.dispose()
                            }
                        }
                        menu("Edit") {
                            item("Cut") {}
                            item("Copy") {}
                            item("Paste") {}
                            item("Select All") {}
                        }
                        menu("Layout") {
                            item("Minimize All") {
                                desktop.allFrames.forEach {
                                    it.isIcon = true
                                }
                            }
                        }
                    }
                    onClose(JFrame.EXIT_ON_CLOSE)
                }.build()
            }

            desktop = JDesktopPane()
            switchPanel(desktop)
            frame.isVisible = true
        }
    }

    private fun<P: JComponent> switchPanel(newPanel: P) {
        frame.contentPane = newPanel
        frame.revalidate()
        frame.repaint()
    }
}