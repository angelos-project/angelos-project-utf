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

import org.angproj.utf.gui.OrdinaryKey
import org.angproj.utf.gui.SpecialKey
import org.angproj.utf.gui.menu.GuiMenuBarBuilder

import javax.swing.*
import kotlin.system.exitProcess


object TestAppKt {
    private lateinit var frame: JFrame
    private lateinit var currentPanel: JPanel

    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater {
            try {
                // Set Java cross-platform Look and Feel (Metal)
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
            } catch (e: Exception) {
                e.printStackTrace()
            }

            frame = JFrame("Application Framework")
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
            frame.setSize(800, 600)

            with(GuiMenuBarBuilder()) {
                menu {
                    text = "File"
                    mnemonic = OrdinaryKey.F
                    menuItem {
                        text = "Exit"
                        setCmd(OrdinaryKey.Q, SpecialKey.META)
                        onCommand { exitProcess(0)  }
                    }
                }
                menu {
                    text = "Examples"
                    mnemonic = OrdinaryKey.E

                    menuItem("JDesktopPane Example") { switchPanel(JDesktopPaneExample(frame)) }
                    menuItem("JEditorPane Example") { switchPanel(JEditorPaneExample()) }
                    menuItem("JInternalFrame Example") { switchPanel(JInternalFrameExample()) }
                    menuItem("JLayeredPane Example") { switchPanel(JLayeredPaneExample()) }
                    menuItem("JLayer Example") { switchPanel(JLayerExample()) }
                    menuItem("JRootPane Example") { switchPanel(JRootPaneExample()) }
                    separator()

                    menuItem("JMenuComponent Example") { switchPanel(MenuComponentsExample(frame)) }
                    separator()

                    menuItem("JButton Example") { switchPanel(JButtonExample()) }
                    menuItem("JCheckBox Example") { switchPanel(JCheckBoxExample()) }
                    menuItem("JColorChooser Example") { switchPanel(JColorChooserExample()) }
                    menuItem("JComboBox Example") { switchPanel(JComboBoxExample()) }
                    menuItem {
                        text = "JDialog Example"
                        setCmd(OrdinaryKey.D, SpecialKey.META)
                        onCommand { switchPanel(JDialogExample(frame)) }
                    }
                    menuItem("JFileChooser Example") { switchPanel(JFileChooserExample(frame)) }
                    menuItem("JFormattedTextField Example") { switchPanel(JFormattedTextFieldExample()) }
                    menuItem("JLabel Example") { switchPanel(JLabelExample()) }
                    menuItem("JList Example") { switchPanel(JListExample()) }
                    menuItem("JOptionPane Example") { switchPanel(JOptionPaneExample(frame)) }
                    menuItem("JPasswordField Example") { switchPanel(JPasswordFieldExample()) }
                    menuItem {
                        text = "JProgressBar Example"
                        setCmd(OrdinaryKey.P, SpecialKey.META)
                        onCommand { switchPanel(JProgressBarExample()) }
                    }
                    menuItem("JRadioButton Example") { switchPanel(JRadioButtonExample()) }
                    menuItem("JScrollBar Example") { switchPanel(JScrollBarExample()) }
                    menuItem("JScrollPane Example") { switchPanel(JScrollPaneExample()) }
                    menuItem("JSeparator Example") { switchPanel(JSeparatorExample()) }
                    menuItem("JSlider Example") { switchPanel(JSliderExample()) }
                    menuItem("JSpinner Example") { switchPanel(JSpinnerExample()) }
                    menuItem("JSplitPane Example") { switchPanel(JSplitPaneExample()) }
                    menuItem("JTabbedPane Example") { switchPanel(JTabbedPaneExample()) }
                    menuItem("JTable Example") { switchPanel(JTableExample()) }
                    menuItem("JTextArea Example") { switchPanel(JTextAreaExample()) }
                    menuItem("JTextField Example") { switchPanel(JTextFieldExample()) }
                    menuItem("JTextPane Example") { switchPanel(JTextPaneExample()) }
                    menuItem("JToggleButton Example") { switchPanel(JToggleButtonExample()) }
                    menuItem("JToolBar Example") { switchPanel(JToolBarExample()) }
                    menuItem("JToolTip Example") { switchPanel(JToolTipExample()) }
                    menuItem("JTree Example") { switchPanel(JTreeExample()) }
                    menuItem("JViewport Example") { switchPanel(JViewportExample()) }
                    menuItem("JWindow Example") { switchPanel(JWindowExample(frame)) }
                }
                menu {
                    text = "Demo"
                    mnemonic = OrdinaryKey.D

                    subMenu("Checkboxes") {
                        checkItem {
                            text = "Checkbox 1"
                            onChange { s, b -> println("${if(b) "C" else "Unc"}hecked $s") }
                        }
                        checkItem {
                            text = "Checkbox 2"
                            onChange { s, b -> println("${if(b) "C" else "Unc"}hecked $s") }
                        }
                        checkItem("Checkbox 3") { s, b -> println("${if(b) "C" else "Unc"}hecked $s") }
                    }
                    subMenu("Radiobuttons") {
                        radioGroup {
                            onChange { s, i -> println("Selected Radio: $s - at $i") }
                            radioItem("Radiobutton 1")
                            radioItem("Radiobutton 2")
                            radioItem("Radiobutton 3")
                        }
                    }
                }

                frame.jMenuBar = build()
            }

            // Add more example menu items here as framework grows

            // Initial empty panel or welcome
            currentPanel = JPanel()
            frame.setContentPane(currentPanel)

            frame.setVisible(true)
        }
    }

    private fun switchPanel(newPanel: JPanel) {
        //frame.getContentPane().remove(currentContent)
        val scrollPane = JScrollPane(newPanel)
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED)
        val currentContent = scrollPane
        frame.setContentPane(currentContent)
        frame.revalidate()
        frame.repaint()
    }
}
