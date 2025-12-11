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

import org.angproj.utf.helper.BlockRangeLoader
import org.angproj.utf.helper.ScriptLoader
import org.angproj.utf.ui.BlockViewerDialog
import org.angproj.utf.ui.ScriptLoaderDialog
import org.angproj.utf.ui.item
import org.angproj.utf.ui.menu
import org.angproj.utf.ui.menubar

import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.SwingConstants

class UtfInfoGenerator(onPress: UtfInfoGenerator.() -> Unit = {
    JOptionPane.showMessageDialog(this, "Button clicked!")
}) : JFrame() {
    init {
        setTitle("UtfInfoGenerator")
        setSize(600, 400)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setLocationRelativeTo(null)

        menubar {
            menu("File") {
                item("Exit") {
                    System.exit(0)
                }
            }
            menu("View") {
                item("Show Unicode Blocks") {
                    val blocks = BlockRangeLoader.allData
                    BlockViewerDialog(this@UtfInfoGenerator, blocks).isVisible = true
                }
                item("Show Unicode Scripts") {
                    val script = ScriptLoader.allScripts
                    ScriptLoaderDialog(this@UtfInfoGenerator, script).isVisible = true
                }
            }
            menu("Help") {
                item("About") {
                    showAboutDialog()
                }
            }
        }

        // Basic content
        val label: JLabel = JLabel("Welcome to UtfInfoGenerator!", SwingConstants.CENTER)
        add(label, BorderLayout.CENTER)
        val button = JButton("Click Me")
        button.addActionListener() { onPress() }
        add(button, BorderLayout.SOUTH)
    }

    private fun showAboutDialog() {
        JOptionPane.showMessageDialog(
            this,
            "UtfInfoGenerator\nVersion 1\n© 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>",
            "About",
            JOptionPane.INFORMATION_MESSAGE
        )
    }
}