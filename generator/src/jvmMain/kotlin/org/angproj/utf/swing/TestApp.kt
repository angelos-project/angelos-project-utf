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
            examplesMenu.add(jCheckBoxItem)

            // Add more example menu items here as framework grows

            // Initial empty panel or welcome
            currentPanel = JPanel()
            frame.setContentPane(currentPanel)

            frame.setVisible(true)
        }
    }

    private fun switchPanel(newPanel: JPanel) {
        frame.getContentPane().remove(currentPanel)
        currentPanel = newPanel
        frame.getContentPane().add(currentPanel)
        frame.revalidate()
        frame.repaint()
    }
}
