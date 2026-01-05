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

import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.UIManager

object FlowLayoutExampleKt {
    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater {
            try {
                // Set Java cross-platform Look and Feel (Metal)
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
            } catch (e: Exception) {
                e.printStackTrace()
            }

            val frame = JFrame("FlowLayout Example")
            frame.setLayout(FlowLayout(FlowLayout.CENTER, 10, 10))

            frame.add(JButton("Button 1"))
            frame.add(JButton("Button 2"))
            frame.add(JButton("Button 3"))
            frame.add(JButton("Button 4"))

            frame.setSize(300, 150)
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
            frame.setVisible(true)
        }
    }
}

