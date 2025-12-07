/**
 * Copyright (c) 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
package org.angproj.utf

import org.angproj.utf.helper.BlockLoader
import org.angproj.utf.helper.ScriptLoader
import org.angproj.utf.model.Scripts
import org.angproj.utf.ui.BlockViewerDialog
import org.angproj.utf.ui.ScriptLoaderDialog

import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem
import javax.swing.JOptionPane
import javax.swing.SwingConstants
import javax.swing.SwingUtilities

class UtfInfoGenerator : JFrame() {
    init {
        setTitle("UtfInfoGenerator")
        setSize(600, 400)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setLocationRelativeTo(null)

        val menuBar: JMenuBar = JMenuBar()

        // File Menu
        val fileMenu: JMenu = JMenu("File")
        val exitItem: JMenuItem = JMenuItem("Exit")
        exitItem.addActionListener({ e -> System.exit(0) })
        fileMenu.add(exitItem)

        // Help Menu
        val helpMenu: JMenu = JMenu("Help")
        val aboutItem: JMenuItem = JMenuItem("About")
        aboutItem.addActionListener({ e -> showAboutDialog() })
        helpMenu.add(aboutItem)

        val viewMenu = JMenu("View")
        val blocksItem = JMenuItem("Show Unicode Blocks")
        blocksItem.addActionListener {
            val blocks = BlockLoader.allData
            BlockViewerDialog(this, blocks).isVisible = true
        }

        val scriptsItem = JMenuItem("Show Unicode Scripts")
        scriptsItem.addActionListener {
            val script = ScriptLoader.allScripts
            ScriptLoaderDialog(this, script).isVisible = true
        }

        viewMenu.add(blocksItem)
        viewMenu.add(scriptsItem)
        menuBar.add(viewMenu)

        menuBar.add(fileMenu)
        menuBar.add(helpMenu)

        setJMenuBar(menuBar)

        // Basic content
        val label: JLabel = JLabel("Welcome to UtfInfoGenerator!", SwingConstants.CENTER)
        add(label, BorderLayout.CENTER)
    }

    private fun showAboutDialog() {
        JOptionPane.showMessageDialog(
            this,
            "UtfInfoGenerator\nVersion 1\n© 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>",
            "About",
            JOptionPane.INFORMATION_MESSAGE
        )
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String?>?) {
            SwingUtilities.invokeLater({
                val window = UtfInfoGenerator()
                window.setVisible(true)
            })
        }
    }
}