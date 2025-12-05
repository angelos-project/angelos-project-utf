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
package org.angproj.utf.ui

import org.angproj.utf.model.Block
import javax.swing.*
import java.awt.*

class BlockViewerDialog(parent: JFrame, blocks: List<Block>) : JDialog(parent, "Unicode Blocks", true) {
    init {
        val textArea = JTextArea()
        textArea.isEditable = false
        textArea.text = blocks.joinToString("\n") {
            "U+%04X..U+%04X: %s".format(it.start, it.end, it.name)
        }
        add(JScrollPane(textArea), BorderLayout.CENTER)
        setSize(500, 400)
        setLocationRelativeTo(parent)
    }
}