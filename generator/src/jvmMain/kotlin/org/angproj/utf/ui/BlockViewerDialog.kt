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
import javax.swing.table.DefaultTableModel

class BlockViewerDialog(parent: JFrame, blocks: List<Block>) : JDialog(parent, "Unicode Blocks", true) {
    private val columnNames = arrayOf("Start", "End", "Name", "Slug", "Class")
    private val allBlocks = blocks
    private val tableModel = DefaultTableModel(columnNames, 0)
    private val table = JTable(tableModel).apply {
        isEnabled = false
        fillsViewportHeight = true
    }

    init {
        layout = BorderLayout()

        // Collect all unique search terms
        val searchTerms = blocks.flatMap {
            listOf(it.searchName.canonical, it.searchName.slug, it.searchName.klazz)
        }.distinct().sorted()

        val comboBox = JComboBox(searchTerms.toTypedArray())
        comboBox.isEditable = true

        comboBox.addActionListener {
            val query = (comboBox.editor.item as? String)?.trim()?.lowercase() ?: ""
            updateTable(query)
        }

        add(comboBox, BorderLayout.NORTH)
        add(JScrollPane(table), BorderLayout.CENTER)
        setSize(600, 400)
        setLocationRelativeTo(parent)

        updateTable("") // Show all blocks initially
    }

    private fun updateTable(query: String) {
        tableModel.setRowCount(0)
        val filtered = if (query.isEmpty()) allBlocks else allBlocks.filter {
            it.searchName.canonical.lowercase().contains(query) ||
                    it.searchName.slug.lowercase().contains(query) ||
                    it.searchName.klazz.lowercase().contains(query)
        }
        for (block in filtered) {
            tableModel.addRow(arrayOf(
                "0x%04X".format(block.unicodeBounds.first),
                "0x%04X".format(block.unicodeBounds.second),
                block.searchName.canonical,
                block.searchName.slug,
                block.searchName.klazz
            ))
        }
    }
}