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

import java.awt.Component
import java.awt.Font
import java.awt.GridLayout
import javax.swing.*
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeCellRenderer
import javax.swing.tree.DefaultTreeModel
import javax.swing.tree.TreeSelectionModel

internal class JTreeExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Create a sample tree model for examples
        val root = DefaultMutableTreeNode("Root")
        val child1 = DefaultMutableTreeNode("Child 1")
        val child2 = DefaultMutableTreeNode("Child 2")
        root.add(child1)
        root.add(child2)
        child1.add(DefaultMutableTreeNode("Subchild 1.1"))
        val model = DefaultTreeModel(root)

        // Example 1: Default JTree
        add(JLabel("1. Default JTree:"))
        val tree1 = JTree(model)
        add(JScrollPane(tree1))

        // Example 2: JTree with root handles hidden
        add(JLabel("2. JTree with root handles hidden:"))
        val tree2 = JTree(model)
        tree2.setShowsRootHandles(false)
        add(JScrollPane(tree2))

        // Example 3: Editable JTree
        add(JLabel("3. Editable JTree (double-click to edit):"))
        val tree3 = JTree(model)
        tree3.setEditable(true)
        add(JScrollPane(tree3))

        // Example 4: JTree with single selection mode
        add(JLabel("4. JTree with single selection mode:"))
        val tree4 = JTree(model)
        tree4.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION)
        add(JScrollPane(tree4))

        // Example 5: JTree with contiguous tree selection mode
        add(JLabel("5. JTree with contiguous tree selection mode:"))
        val tree5 = JTree(model)
        tree5.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION)
        add(JScrollPane(tree5))

        // Example 6: JTree with discontiguous tree selection mode
        add(JLabel("6. JTree with discontiguous tree selection mode:"))
        val tree6 = JTree(model)
        tree6.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION)
        add(JScrollPane(tree6))

        // Example 7: JTree with root visible false
        add(JLabel("7. JTree with root visible false:"))
        val tree7 = JTree(model)
        tree7.setRootVisible(false)
        add(JScrollPane(tree7))

        // Example 8: Disabled JTree
        add(JLabel("8. Disabled JTree:"))
        val tree8 = JTree(model)
        tree8.setEnabled(false)
        add(JScrollPane(tree8))

        // Example 9: JTree with tooltip
        add(JLabel("9. JTree with tooltip (hover to see):"))
        val tree9 = JTree(model)
        tree9.setToolTipText("This is a tooltip!")
        add(JScrollPane(tree9))

        // Example 10: JTree with large model (performance hint)
        add(JLabel("10. JTree with large model hint:"))
        val tree10 = JTree(model)
        tree10.setLargeModel(true)
        add(JScrollPane(tree10))

        // Example 11: JTree with custom row height
        add(JLabel("11. JTree with custom row height (30):"))
        val tree11 = JTree(model)
        tree11.setRowHeight(30)
        add(JScrollPane(tree11))

        // Example 12: JTree with custom cell renderer (bold text)
        add(JLabel("12. JTree with custom cell renderer (bold text):"))
        val tree12 = JTree(model)
        tree12.setCellRenderer(object : DefaultTreeCellRenderer() {
            override fun getTreeCellRendererComponent(
                tree: JTree?,
                value: Any?,
                sel: Boolean,
                expanded: Boolean,
                leaf: Boolean,
                row: Int,
                hasFocus: Boolean
            ): Component {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus)
                setFont(getFont().deriveFont(Font.BOLD))
                return this
            }
        })
        add(JScrollPane(tree12))

        // Note: For icons in nodes, use custom renderer with ImageIcon; omitted since no images.
        // Add tree selection listeners if needed, e.g., tree.addTreeSelectionListener(e -> JOptionPane.showMessageDialog(this, tree.getLastSelectedPathComponent()));
    }
}
