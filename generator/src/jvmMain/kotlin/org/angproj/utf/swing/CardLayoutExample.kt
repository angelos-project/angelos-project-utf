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

import java.awt.BorderLayout
import java.awt.CardLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.UIManager

object CardLayoutExampleKt {
    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater {
            try {
                // Set Java cross-platform Look and Feel (Metal)
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
            } catch (e: Exception) {
                e.printStackTrace()
            }
            val frame = JFrame("CardLayout Example")
            val cardLayout = CardLayout()
            val cards = JPanel(cardLayout)

            val card1 = JPanel()
            card1.add(JLabel("Card 1"))
            card1.add(JButton("Button A"))

            val card2 = JPanel()
            card2.add(JLabel("Card 2"))
            card2.add(JButton("Button B"))

            cards.add(card1, "ONE")
            cards.add(card2, "TWO")

            val switchBtn = JButton("Switch Card")
            switchBtn.addActionListener(ActionListener { e: ActionEvent? -> cardLayout.next(cards) })

            frame.add(cards, BorderLayout.CENTER)
            frame.add(switchBtn, BorderLayout.SOUTH)

            frame.setSize(300, 200)
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
            frame.setVisible(true)
        }
    }
}

