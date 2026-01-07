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

import java.awt.Dimension
import java.awt.GraphicsEnvironment
import javax.swing.JDesktopPane
import javax.swing.JFrame

@SwingGui
class GuiWorkSpaceBuilder {
    var title: String = "App"
    private val menuBarBuilder = GuiMenuBarBuilder()
    private var defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    private var size: Dimension? = null

    fun menuBar(init: GuiMenuBarBuilder.() -> Unit) { menuBarBuilder.init() }
    fun size(w: Int, h: Int) { size = Dimension(w, h) }
    fun onClose(op: Int) { defaultCloseOperation = op }

    fun show() {
        build().isVisible = true
    }

    fun build(): JFrame {
        val f = JFrame(title)
        f.defaultCloseOperation = defaultCloseOperation
        f.jMenuBar = menuBarBuilder.build()
        size?.let { f.setSize(it) } ?: f.pack()

        val bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds()
        f.setBounds(bounds)
        //f.setLocationRelativeTo(null)
        return f
    }
}