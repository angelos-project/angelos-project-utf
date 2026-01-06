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

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

object SplashScreenAppKt {
    @JvmStatic
    fun main(args: Array<String>) {
        SwingUtilities.invokeLater(Runnable {
            // Create splash screen
            val splash = JWindow()
            splash.setSize(500, 300)
            splash.setLocationRelativeTo(null) // Center on screen

            // Custom panel for background image (assume "splash.jpg" in classpath; replace with your image path)
            val panel: JPanel = object : JPanel() {
                override fun paintComponent(g: Graphics) {
                    super.paintComponent(g)
                    // Load and draw imaginary background image (500x300)
                    /*val icon =
                        ImageIcon(javaClass.getResource("/splash.jpg")) // Or use a file path: new ImageIcon("path/to/splash.jpg")
                    if (icon.getImage() != null) {
                        g.drawImage(icon.getImage(), 0, 0, 500, 300, this)
                    } else {*/
                        // Fallback if image not found
                        g.setColor(Color.BLUE)
                        g.fillRect(0, 0, 500, 300)
                        g.setColor(Color.WHITE)
                        g.drawString("Imaginary Splash Image", 150, 150)
                    //}
                }
            }
            panel.setLayout(BorderLayout())

            // Progress bar at bottom
            val progressBar = JProgressBar(0, 100)
            progressBar.setStringPainted(true)
            progressBar.setPreferredSize(Dimension(500, 30))
            panel.add(progressBar, BorderLayout.SOUTH)

            splash.setContentPane(panel)
            splash.setVisible(true)

            // Simulate loading with timer
            val timer = Timer(30, object : ActionListener {
                var progress: Int = 0

                override fun actionPerformed(e: ActionEvent) {
                    progress += 1
                    progressBar.setValue(progress)
                    if (progress >= 100) {
                        (e.getSource() as Timer).stop()
                        splash.dispose()
                        showMainFrame()
                    }
                }
            })
            timer.start() // Runs for about 3 seconds (100 steps * 30ms = 3000ms)
        })
    }

    private fun showMainFrame() {
        val frame = JFrame("Almost Full Screen")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        val bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds()
        frame.setBounds(bounds)
        frame.setVisible(true)
    }
}
