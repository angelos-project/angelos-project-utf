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
package org.angproj.utf.ui

import java.awt.*
import java.awt.event.*
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.util.*
import javax.swing.*

class SimpleSwingDesignerKt : JFrame() {
    private val designPanel = JPanel(null) // Absolute layout for drag/drop
    private val componentList: JList<String?>
    private val codeArea = JTextArea()
    private val componentNames: MutableMap<JComponent?, String?> = HashMap<JComponent?, String?>()
    private var componentCounter = 0

    init {
        setTitle("Simple Swing GUI Designer")
        setSize(800, 600)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setLayout(BorderLayout())

        // Palette
        val components = arrayOf<String?>("JButton", "JLabel", "JTextField", "JPanel")
        componentList = JList<String?>(components)
        componentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
        val paletteScroll = JScrollPane(componentList)
        add(paletteScroll, BorderLayout.WEST)

        // Design area
        designPanel.setBackground(Color.WHITE)
        designPanel.setPreferredSize(Dimension(600, 600))
        val designScroll = JScrollPane(designPanel)
        add(designScroll, BorderLayout.CENTER)

        // Code area
        val codeScroll = JScrollPane(codeArea)
        codeScroll.setPreferredSize(Dimension(800, 200))
        add(codeScroll, BorderLayout.SOUTH)

        // Menu for export
        val menuBar = JMenuBar()
        val fileMenu = JMenu("File")
        val generateItem = JMenuItem("Generate Code")
        generateItem.addActionListener(ActionListener { e: ActionEvent? -> generateCode() })
        val exportItem = JMenuItem("Export to File")
        exportItem.addActionListener(ActionListener { e: ActionEvent? -> exportCode() })
        fileMenu.add(generateItem)
        fileMenu.add(exportItem)
        menuBar.add(fileMenu)
        setJMenuBar(menuBar)

        // Drag from palette to design
        componentList.addMouseListener(object : MouseAdapter() {
            var startPoint: Point? = null
            override fun mousePressed(e: MouseEvent) {
                startPoint = e.getPoint()
            }

            override fun mouseReleased(e: MouseEvent?) {
                if (componentList.getSelectedValue() != null) {
                    addComponentToDesign(componentList.getSelectedValue()!!)
                }
            }
        })

        // Enable dragging on design panel components
        designPanel.addMouseListener(DesignMouseAdapter())
        designPanel.addMouseMotionListener(DesignMouseMotionAdapter())
    }

    private fun addComponentToDesign(type: String) {
        val comp = createComponent(type)
        val name = type.lowercase(Locale.getDefault()) + componentCounter++
        componentNames.put(comp, name)
        comp.setBounds(10, 10, 100, 30)
        designPanel.add(comp)
        comp.addMouseListener(DesignMouseAdapter())
        comp.addMouseMotionListener(DesignMouseMotionAdapter())
        designPanel.revalidate()
        designPanel.repaint()
    }

    private fun createComponent(type: String): JComponent {
        return when (type) {
            "JButton" -> JButton("Button")
            "JLabel" -> JLabel("Label")
            "JTextField" -> JTextField("Text")
            "JPanel" -> JPanel()
            else -> JLabel("Unknown")
        }
    }

    private fun generateCode() {
        val sb = StringBuilder()
        sb.append("import javax.swing.*;\n")
        sb.append("import java.awt.*;\n\n")
        sb.append("public class GeneratedGUI extends JFrame {\n")
        sb.append("    public GeneratedGUI() {\n")
        sb.append("        setLayout(null);\n")

        for (entry in componentNames.entries) {
            val comp: JComponent = entry.key!!
            val name = entry.value
            val bounds = comp.getBounds()
            sb.append("        ").append(comp.javaClass.getSimpleName()).append(" ").append(name)
                .append(" = new ").append(comp.javaClass.getSimpleName()).append("();\n")
            if (comp is JButton) sb.append("        ").append(name).append(".setText(\"Button\");\n")
            if (comp is JLabel) sb.append("        ").append(name).append(".setText(\"Label\");\n")
            if (comp is JTextField) sb.append("        ").append(name).append(".setText(\"Text\");\n")
            sb.append("        ").append(name).append(".setBounds(")
                .append(bounds.x).append(", ").append(bounds.y).append(", ")
                .append(bounds.width).append(", ").append(bounds.height).append(");\n")
            sb.append("        add(").append(name).append(");\n\n")
        }

        sb.append("    }\n")
        sb.append("}\n")
        codeArea.setText(sb.toString())
    }

    private fun exportCode() {
        generateCode()
        val chooser = JFileChooser()
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedWriter(FileWriter(chooser.getSelectedFile())).use { writer ->
                    writer.write(codeArea.getText())
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
        }
    }

    private inner class DesignMouseAdapter : MouseAdapter() {
        override fun mousePressed(e: MouseEvent?) {
            designPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR))
        }

        override fun mouseReleased(e: MouseEvent?) {
            designPanel.setCursor(Cursor.getDefaultCursor())
        }
    }

    private inner class DesignMouseMotionAdapter : MouseMotionAdapter() {
        private var dx = 0
        private var dy = 0
        override fun mouseDragged(e: MouseEvent) {
            val comp = e.getComponent() as JComponent
            if (comp === designPanel) return
            val bounds = comp.getBounds()
            bounds.x += e.getX() - dx
            bounds.y += e.getY() - dy
            comp.setBounds(bounds)
            designPanel.repaint()
        }

        override fun mouseMoved(e: MouseEvent) {
            dx = e.getX()
            dy = e.getY()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SwingUtilities.invokeLater(Runnable { SimpleSwingDesignerKt().setVisible(true) })
        }
    }
}
