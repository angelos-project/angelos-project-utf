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

@SwingGui
class Gui {
    fun frame(block: GuiFrameBuilder.() -> Unit): GuiFrameBuilder {
        val builder = GuiFrameBuilder()
        builder.block()
        return builder
    }

    fun menuBar(block: GuiMenuBarBuilder.() -> Unit): GuiMenuBarBuilder {
        val builder = GuiMenuBarBuilder()
        builder.block()
        return builder
    }

    fun menu(text: String, block: GuiMenuBuilder.() -> Unit): GuiMenuBuilder {
        val builder = GuiMenuBuilder(text)
        builder.block()
        return builder
    }
}

fun gui(block: Gui.() -> Unit): Gui {
    val gui = Gui()
    gui.block()
    return gui
}