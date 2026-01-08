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

            val menuBar = JMenuBar()
            frame.setJMenuBar(menuBar)

            // File menu with Exit
            val fileMenu = JMenu("File")
            val exitItem = JMenuItem("Exit")
            exitItem.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    System.exit(0)
                }
            })
            fileMenu.add(exitItem)
            menuBar.add(fileMenu)

            // Examples menu
            val examplesMenu = JMenu("Examples")
            menuBar.add(examplesMenu)

            // JDesktopPane Example menu item
            val jDesktopPaneExample = JMenuItem("JDesktopPane Example")
            jDesktopPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JDesktopPaneExample(frame))
                }
            })
            examplesMenu.add(jDesktopPaneExample)

            // JEditorPane Example menu item
            val jEditorPaneExample = JMenuItem("JEditorPane Example")
            jEditorPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JEditorPaneExample())
                }
            })
            examplesMenu.add(jEditorPaneExample)

            // JInternalFrame Example menu item
            val jInternalFrameExample = JMenuItem("JInternalFrame Example")
            jInternalFrameExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JInternalFrameExample())
                }
            })
            examplesMenu.add(jInternalFrameExample)

            // JLayeredPane Example menu item
            val jLayeredPaneExample = JMenuItem("JLayeredPane Example")
            jLayeredPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JLayeredPaneExample())
                }
            })
            examplesMenu.add(jLayeredPaneExample)

            // JLayer Example menu item
            val jLayerExample = JMenuItem("JLayer Example")
            jLayerExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JLayerExample())
                }
            })
            examplesMenu.add(jLayerExample)

            // JRootPane Example menu item
            val jRootPaneExample = JMenuItem("JRootPane Example")
            jRootPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JRootPaneExample())
                }
            })
            examplesMenu.add(jRootPaneExample)

            examplesMenu.add(JSeparator())



            examplesMenu.add(JSeparator())

            // JButton Example menu item
            val jButtonItem = JMenuItem("JButton Example")
            jButtonItem.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent) {
                    switchPanel(JButtonExample())
                }
            })
            examplesMenu.add(jButtonItem)

            // JCheckBox Example menu item
            val jCheckBoxItem = JMenuItem("JCheckBox Example")
            jCheckBoxItem.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JCheckBoxExample())
                }
            })
            examplesMenu.add(jCheckBoxItem)

            // JCheckBox Example menu item
            val jCheckBoxMenuItemExample = JMenuItem("JCheckBoxMenuItem Example")
            jCheckBoxMenuItemExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JCheckBoxMenuItemExample())
                }
            })
            examplesMenu.add(jCheckBoxMenuItemExample)

            // JColorChooser Example menu item
            val jColorChooserExample = JMenuItem("JColorChooser Example")
            jColorChooserExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JColorChooserExample())
                }
            })
            examplesMenu.add(jColorChooserExample)

            // JComboBox Example menu item
            val jComboBoxExample = JMenuItem("JComboBox Example")
            jComboBoxExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JComboBoxExample())
                }
            })
            examplesMenu.add(jComboBoxExample)

            // JDialog Example menu item
            val jDialogExample = JMenuItem("JDialog Example")
            jDialogExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JDialogExample(frame))
                }
            })
            examplesMenu.add(jDialogExample)

            // JFileChooser Example menu item
            val jFileChooserExample = JMenuItem("JFileChooser Example")
            jFileChooserExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JFileChooserExample(frame))
                }
            })
            examplesMenu.add(jFileChooserExample)

            // JFormattedTextField Example menu item
            val jFormattedTextFieldExample = JMenuItem("JFormattedTextField Example")
            jFormattedTextFieldExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JFormattedTextFieldExample())
                }
            })
            examplesMenu.add(jFormattedTextFieldExample)

            // JLabel Example menu item
            val jLabelExample = JMenuItem("JLabel Example")
            jLabelExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JLabelExample())
                }
            })
            examplesMenu.add(jLabelExample)

            // JList Example menu item
            val jListExample = JMenuItem("JList Example")
            jListExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JListExample())
                }
            })
            examplesMenu.add(jListExample)

            // JMenu Example menu item
            val jMenuExample = JMenuItem("JMenu Example")
            jMenuExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JMenuExample())
                }
            })
            examplesMenu.add(jMenuExample)

            // JMenuBar Example menu item
            val jMenuBarExample = JMenuItem("JMenuBar Example")
            jMenuBarExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JMenuBarExample())
                }
            })
            examplesMenu.add(jMenuBarExample)

            // JOptionPane Example menu item
            val jOptionPaneExample = JMenuItem("JOptionPane Example")
            jOptionPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JOptionPaneExample(frame))
                }
            })
            examplesMenu.add(jOptionPaneExample)

            // JPasswordField Example menu item
            val jPasswordFieldExample = JMenuItem("JPasswordField Example")
            jPasswordFieldExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JPasswordFieldExample())
                }
            })
            examplesMenu.add(jPasswordFieldExample)

            // JPopupMenu Example menu item
            val jPopupMenuExample = JMenuItem("JPopupMenu Example")
            jPopupMenuExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JPopupMenuExample())
                }
            })
            examplesMenu.add(jPopupMenuExample)

            // JProgressBar Example menu item
            val jProgressBarExample = JMenuItem("JProgressBar Example")
            jProgressBarExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JProgressBarExample())
                }
            })
            examplesMenu.add(jProgressBarExample)

            // JRadioButton Example menu item
            val jRadioButtonExample = JMenuItem("JRadioButton Example")
            jRadioButtonExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JRadioButtonExample())
                }
            })
            examplesMenu.add(jRadioButtonExample)

            // JRadioButtonMenuItem Example menu item
            val jRadioButtonMenuItemExample = JMenuItem("JRadioButtonMenuItem Example")
            jRadioButtonMenuItemExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JRadioButtonMenuItemExample())
                }
            })
            examplesMenu.add(jRadioButtonMenuItemExample)

            // JScrollBar Example menu item
            val jScrollBarExample = JMenuItem("JScrollBar Example")
            jScrollBarExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JScrollBarExample())
                }
            })
            examplesMenu.add(jScrollBarExample)

            // JScrollPane Example menu item
            val jScrollPaneExample = JMenuItem("JScrollPane Example")
            jScrollPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JScrollPaneExample())
                }
            })
            examplesMenu.add(jScrollPaneExample)

            // JSeparator Example menu item
            val jSeparatorExample = JMenuItem("JSeparator Example")
            jSeparatorExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JSeparatorExample())
                }
            })
            examplesMenu.add(jSeparatorExample)

            // JSlider Example menu item
            val jSliderExample = JMenuItem("JSlider Example")
            jSliderExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JSliderExample())
                }
            })
            examplesMenu.add(jSliderExample)

            // JSpinner Example menu item
            val jSpinnerExample = JMenuItem("JSpinner Example")
            jSpinnerExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JSpinnerExample())
                }
            })
            examplesMenu.add(jSpinnerExample)

            // JSplitPane Example menu item
            val jSplitPaneExample = JMenuItem("JSplitPane Example")
            jSplitPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JSplitPaneExample())
                }
            })
            examplesMenu.add(jSplitPaneExample)

            // JTabbedPane Example menu item
            val jTabbedPaneExample = JMenuItem("JTabbedPane Example")
            jTabbedPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JTabbedPaneExample())
                }
            })
            examplesMenu.add(jTabbedPaneExample)

            // JTable Example menu item
            val jTableExample = JMenuItem("JTable Example")
            jTableExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JTableExample())
                }
            })
            examplesMenu.add(jTableExample)

            // JTextArea Example menu item
            val jTextAreaExample = JMenuItem("JTextArea Example")
            jTextAreaExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JTextAreaExample())
                }
            })
            examplesMenu.add(jTextAreaExample)

            // JTextField Example menu item
            val jTextFieldExample = JMenuItem("JTextField Example")
            jTextFieldExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JTextFieldExample())
                }
            })
            examplesMenu.add(jTextFieldExample)

            // JTextPane Example menu item
            val jTextPaneExample = JMenuItem("JTextPane Example")
            jTextPaneExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JTextPaneExample())
                }
            })
            examplesMenu.add(jTextPaneExample)

            // JToggleButton Example menu item
            val jToggleButtonExample = JMenuItem("JToggleButton Example")
            jToggleButtonExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JToggleButtonExample())
                }
            })
            examplesMenu.add(jToggleButtonExample)

            // JToolBar Example menu item
            val jToolBarExample = JMenuItem("JToolBar Example")
            jToolBarExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JToolBarExample())
                }
            })
            examplesMenu.add(jToolBarExample)

            // JToolTip Example menu item
            val jToolTipExample = JMenuItem("JToolTip Example")
            jToolTipExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JToolTipExample())
                }
            })
            examplesMenu.add(jToolTipExample)

            // JTree Example menu item
            val jTreeExample = JMenuItem("JTree Example")
            jTreeExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JTreeExample())
                }
            })
            examplesMenu.add(jTreeExample)

            // JViewport Example menu item
            val jViewportExample = JMenuItem("JViewport Example")
            jViewportExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JViewportExample())
                }
            })
            examplesMenu.add(jViewportExample)

            // JWindow Example menu item
            val jWindowExample = JMenuItem("JWindow Example")
            jWindowExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(JWindowExample(frame))
                }
            })
            examplesMenu.add(jWindowExample)

            // MenuComponent Example menu item
            val jMenuComponentExample = JMenuItem("JMenuComponent Example")
            jMenuComponentExample.addActionListener(object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    switchPanel(MenuComponentExample(frame))
                }
            })
            examplesMenu.add(jMenuComponentExample)

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
