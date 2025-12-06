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

import org.angproj.utf.model.Scripts
import javax.swing.*
import java.awt.*
import javax.swing.table.DefaultTableModel


class ScriptLoaderDialog(parent: JFrame, scripts: List<Scripts>) : JDialog(parent, "Unicode Script", true) {
    private val columnNames = arrayOf("Start", "End", "Name", "Type", "Slug", "Class")
    private val allScripts = scripts
    private val tableModel = DefaultTableModel(columnNames, 0)
    private val table = JTable(tableModel).apply {
        isEnabled = false
        fillsViewportHeight = true
    }

    init {
        layout = BorderLayout()

        // Collect all unique search terms
        val searchTerms = scripts.flatMap {
            listOf(it.name, it.searchName.slug, it.searchName.klass)
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
        tableModel.setRowCount(0) // Clear existing rows

        val filteredScripts = if (query.isEmpty()) {
            allScripts
        } else {
            allScripts.filter {
                it.name.lowercase().contains(query) ||
                it.searchName.slug.contains(query) ||
                it.searchName.klass.contains(query)
            }
        }

        for (script in filteredScripts) {
            tableModel.addRow(
                arrayOf(
                    "U+%04X".format(script.start),
                    if(script.end != -1)"U+%04X".format(script.end) else "",
                    script.name,
                    script.type,
                    script.searchName.slug,
                    script.searchName.klass
                )
            )
        }
    }
}