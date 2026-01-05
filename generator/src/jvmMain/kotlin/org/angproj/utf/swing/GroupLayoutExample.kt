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

import javax.swing.*

object GroupLayoutExampleKt {
    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater {
            try {
                // Set Java cross-platform Look and Feel (Metal)
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
            } catch (e: Exception) {
                e.printStackTrace()
            }
            val frame = JFrame("GroupLayout Example")

            val label = JLabel("Email:")
            val field = JTextField(15)
            val button = JButton("Send")

            val layout = GroupLayout(frame.getContentPane())
            frame.getContentPane().setLayout(layout)

            layout.setAutoCreateGaps(true)
            layout.setAutoCreateContainerGaps(true)

            layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addComponent(label)
                    .addComponent(field)
                    .addComponent(button)
            )

            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(field)
                    .addComponent(button)
            )

            frame.pack()
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
            frame.setVisible(true)
        }
    }
}

