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
import javax.swing.JFrame

@SwingGui
class GuiFrameBuilder {
    var title: String = "App"
    private val contentBuilder = GuiPanelBuilder()
    private var defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    private var size: Dimension? = null

    fun content(init: GuiPanelBuilder.() -> Unit) { contentBuilder.init() }
    fun size(w: Int, h: Int) { size = Dimension(w, h) }
    fun closeOperation(op: Int) { defaultCloseOperation = op }

    fun show() {
        build().isVisible = true
    }

    fun build(): JFrame {
        val f = JFrame(title)
        f.defaultCloseOperation = defaultCloseOperation
        f.contentPane = contentBuilder.build()
        size?.let { f.setSize(it) } ?: f.pack()
        f.setLocationRelativeTo(null)
        return f
    }
}