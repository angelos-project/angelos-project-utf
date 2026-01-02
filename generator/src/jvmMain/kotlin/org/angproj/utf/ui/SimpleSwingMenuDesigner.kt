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
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel
import javax.swing.tree.TreePath

class SimpleSwingMenuDesignerKt : JFrame() {
    private val designPanel = JPanel(null) // Absolute layout for drag/drop
    private val componentList: JList<String?>
    private val codeArea = JTextArea()
    private val componentNames: MutableMap<JComponent?, String?> = HashMap<JComponent?, String?>()
    private val nodeToComp: MutableMap<DefaultMutableTreeNode?, JComponent> =
        HashMap<DefaultMutableTreeNode?, JComponent>()
    private var componentCounter = 0
    private val menuTree: JTree
    private val treeModel: DefaultTreeModel
    private val root: DefaultMutableTreeNode
    private val designedMenuBar = JMenuBar()

    init {
        setTitle("Simple Swing GUI Designer")
        setSize(1000, 600)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setLayout(BorderLayout())

        // Palette
        val components = arrayOf<String?>("JButton", "JLabel", "JTextField", "JPanel")
        componentList = JList<String?>(components)
        componentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
        val paletteScroll = JScrollPane(componentList)
        paletteScroll.setPreferredSize(Dimension(150, 600))
        add(paletteScroll, BorderLayout.WEST)

        // Design area
        designPanel.setBackground(Color.WHITE)
        designPanel.setPreferredSize(Dimension(600, 600))
        val designScroll = JScrollPane(designPanel)
        add(designScroll, BorderLayout.CENTER)

        // Menu designer
        val menuPanel = JPanel(BorderLayout())
        menuPanel.setPreferredSize(Dimension(200, 600))
        root = DefaultMutableTreeNode("MenuBar")
        treeModel = DefaultTreeModel(root)
        nodeToComp.put(root, designedMenuBar)
        menuTree = JTree(treeModel)
        val menuScroll = JScrollPane(menuTree)
        menuPanel.add(menuScroll, BorderLayout.CENTER)

        val buttonPanel = JPanel()
        val addMenuBtn = JButton("Add Menu")
        val addItemBtn = JButton("Add Item")
        val removeBtn = JButton("Remove")
        val renameBtn = JButton("Rename")
        buttonPanel.add(addMenuBtn)
        buttonPanel.add(addItemBtn)
        buttonPanel.add(removeBtn)
        buttonPanel.add(renameBtn)
        menuPanel.add(buttonPanel, BorderLayout.SOUTH)
        add(menuPanel, BorderLayout.EAST)

        // Code area
        val codeScroll = JScrollPane(codeArea)
        codeScroll.setPreferredSize(Dimension(1000, 200))
        add(codeScroll, BorderLayout.SOUTH)

        // Designer menu
        val designerMenuBar = JMenuBar()
        val fileMenu = JMenu("File")
        val generateItem = JMenuItem("Generate Code")
        generateItem.addActionListener(ActionListener { e: ActionEvent? -> generateCode() })
        val exportItem = JMenuItem("Export to File")
        exportItem.addActionListener(ActionListener { e: ActionEvent? -> exportCode() })
        fileMenu.add(generateItem)
        fileMenu.add(exportItem)
        designerMenuBar.add(fileMenu)
        setJMenuBar(designerMenuBar)

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

        // Menu actions
        addMenuBtn.addActionListener(ActionListener { e: ActionEvent? -> addMenu() })
        addItemBtn.addActionListener(ActionListener { e: ActionEvent? -> addItem() })
        removeBtn.addActionListener(ActionListener { e: ActionEvent? -> removeSelected() })
        renameBtn.addActionListener(ActionListener { e: ActionEvent? -> renameSelected() })
    }

    private fun addComponentToDesign(type: String) {
        val comp = createComponent(type)
        val name = type.lowercase(Locale.getDefault()).replace("j", "") + componentCounter++
        componentNames.put(comp, name)
        comp.setBounds(10, 10, 100, 30)
        if (comp is JPanel) comp.setLayout(null)
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

    private fun addMenu() {
        var selected = menuTree.getLastSelectedPathComponent() as DefaultMutableTreeNode?
        if (selected == null) selected = root
        val parentComp = nodeToComp.get(selected)
        if (!(parentComp is JMenuBar || parentComp is JMenu)) return
        val name = JOptionPane.showInputDialog(this, "Menu name:", "Menu")
        if (name == null || name.isEmpty()) return
        val menu = JMenu(name)
        val compName = "menu" + componentCounter++
        componentNames.put(menu, compName)
        val node = DefaultMutableTreeNode(name)
        nodeToComp.put(node, menu)
        treeModel.insertNodeInto(node, selected, selected.getChildCount())
        if (parentComp is JMenuBar) parentComp.add(menu)
        else (parentComp as JMenu).add(menu)
        menuTree.expandPath(TreePath(selected.getPath()))
    }

    private fun addItem() {
        val selected = menuTree.getLastSelectedPathComponent() as DefaultMutableTreeNode?
        if (selected == null || nodeToComp.get(selected) !is JMenu) return
        val parentComp: JComponent = nodeToComp.get(selected)!!
        val name = JOptionPane.showInputDialog(this, "Item name:", "Item")
        if (name == null || name.isEmpty()) return
        val item = JMenuItem(name)
        val compName = "menuItem" + componentCounter++
        componentNames.put(item, compName)
        val node = DefaultMutableTreeNode(name)
        nodeToComp.put(node, item)
        treeModel.insertNodeInto(node, selected, selected.getChildCount())
        (parentComp as JMenu).add(item)
        menuTree.expandPath(TreePath(selected.getPath()))
    }

    private fun removeSelected() {
        val selected = menuTree.getLastSelectedPathComponent() as DefaultMutableTreeNode?
        if (selected == null || selected === root) return
        removeNodeAndChildren(selected)
    }

    private fun removeNodeAndChildren(node: DefaultMutableTreeNode) {
        while (node.getChildCount() > 0) {
            removeNodeAndChildren((node.getChildAt(0) as DefaultMutableTreeNode?)!!)
        }
        val comp = nodeToComp.get(node)
        if (comp != null) {
            val parentNode = node.getParent() as DefaultMutableTreeNode?
            val parentComp = nodeToComp.get(parentNode)
            if (parentComp is Container) (parentComp as Container).remove(comp)
            componentNames.remove(comp)
            nodeToComp.remove(node)
        }
        if (node.getParent() != null) {
            treeModel.removeNodeFromParent(node)
        }
    }

    private fun renameSelected() {
        val selected = menuTree.getLastSelectedPathComponent() as DefaultMutableTreeNode?
        if (selected == null || selected === root) return
        val oldName = selected.getUserObject() as String?
        val newName = JOptionPane.showInputDialog(this, "Rename:", oldName)
        if (newName == null || newName == oldName) return
        selected.setUserObject(newName)
        treeModel.nodeChanged(selected)
        val comp = nodeToComp.get(selected)
        if (comp is JMenu) comp.setText(newName)
        else if (comp is JMenuItem) comp.setText(newName)
    }

    private fun generateCode() {
        val sb = StringBuilder()
        sb.append("import javax.swing.*;\n")
        sb.append("import java.awt.*;\n\n")
        sb.append("public class GeneratedGUI extends JFrame {\n")
        sb.append("    public GeneratedGUI() {\n")
        sb.append("        setLayout(null);\n\n")

        for (child in designPanel.getComponents()) {
            if (child !is JComponent) continue
            val name = componentNames.get(child)
            val bounds = child.getBounds()
            sb.append("        ").append(child.javaClass.getSimpleName()).append(" ").append(name)
                .append(" = new ").append(child.javaClass.getSimpleName()).append("();\n")
            if (child is JButton) sb.append("        ").append(name).append(".setText(\"Button\");\n")
            if (child is JLabel) sb.append("        ").append(name).append(".setText(\"Label\");\n")
            if (child is JTextField) sb.append("        ").append(name).append(".setText(\"Text\");\n")
            sb.append("        ").append(name).append(".setBounds(")
                .append(bounds.x).append(", ").append(bounds.y).append(", ")
                .append(bounds.width).append(", ").append(bounds.height).append(");\n")
            sb.append("        add(").append(name).append(");\n\n")
        }

        if (root.getChildCount() > 0) {
            generateMenuRecursive(sb, root, null)
        }

        sb.append("    }\n")
        sb.append("}\n")
        codeArea.setText(sb.toString())
    }

    private fun generateMenuRecursive(sb: StringBuilder, node: DefaultMutableTreeNode, parentName: String?) {
        if (node === root) {
            val barName = "menuBar"
            sb.append("        JMenuBar ").append(barName).append(" = new JMenuBar();\n\n")
            for (i in 0..<node.getChildCount()) {
                val child = node.getChildAt(i) as DefaultMutableTreeNode
                generateMenuRecursive(sb, child, barName)
            }
            sb.append("        setJMenuBar(").append(barName).append(");\n\n")
        } else {
            val comp: JComponent = nodeToComp.get(node)!!
            val name = componentNames.get(comp)
            val text = node.getUserObject() as String
            val className = comp.javaClass.getSimpleName()
            sb.append("        ").append(className).append(" ").append(name).append(" = new ").append(className)
                .append("(\"").append(text.replace("\"", "\\\"")).append("\");\n")
            sb.append("        ").append(parentName).append(".add(").append(name).append(");\n\n")
            if (comp is JMenu) {
                for (i in 0..<node.getChildCount()) {
                    val child = node.getChildAt(i) as DefaultMutableTreeNode
                    generateMenuRecursive(sb, child, name)
                }
            }
        }
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

    public inner class DesignMouseAdapter : MouseAdapter() {
        override fun mousePressed(e: MouseEvent) {
            if (e.getComponent() !== designPanel) {
                designPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR))
            }
        }

        override fun mouseReleased(e: MouseEvent?) {
            designPanel.setCursor(Cursor.getDefaultCursor())
        }
    }

    public inner class DesignMouseMotionAdapter : MouseMotionAdapter() {
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
            SwingUtilities.invokeLater(Runnable { SimpleSwingMenuDesignerKt().setVisible(true) })
        }
    }
}
