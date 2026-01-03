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
package org.angproj.utf.swing;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

class JComboBoxExample extends JPanel {

    public JComboBoxExample() {
        setLayout(new GridLayout(0, 1, 10, 10)); // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};

        // Example 1: Default JComboBox without items
        add(new JLabel("1. Default JComboBox without items:"));
        JComboBox<String> combo1 = new JComboBox<>();
        combo1.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo1.getSelectedItem());
            }
        });
        add(combo1);

        // Example 2: JComboBox with items
        add(new JLabel("2. JComboBox with items:"));
        JComboBox<String> combo2 = new JComboBox<>(items);
        combo2.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo2.getSelectedItem());
            }
        });
        add(combo2);

        // Example 3: Editable JComboBox
        add(new JLabel("3. Editable JComboBox:"));
        JComboBox<String> combo3 = new JComboBox<>(items);
        combo3.setEditable(true);
        combo3.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected/Entered: " + combo3.getSelectedItem());
            }
        });
        add(combo3);

        // Example 4: Disabled JComboBox
        add(new JLabel("4. Disabled JComboBox:"));
        JComboBox<String> combo4 = new JComboBox<>(items);
        combo4.setEnabled(false);
        add(combo4);

        // Example 5: JComboBox with tooltip
        add(new JLabel("5. JComboBox with tooltip (hover to see):"));
        JComboBox<String> combo5 = new JComboBox<>(items);
        combo5.setToolTipText("This is a tooltip!");
        combo5.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo5.getSelectedItem());
            }
        });
        add(combo5);

        // Example 6: JComboBox with maximum row count
        add(new JLabel("6. JComboBox with maximum row count (3):"));
        JComboBox<String> combo6 = new JComboBox<>(items);
        combo6.setMaximumRowCount(3);
        combo6.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo6.getSelectedItem());
            }
        });
        add(combo6);

        // Example 7: JComboBox with prototype display value
        add(new JLabel("7. JComboBox with prototype display value:"));
        JComboBox<String> combo7 = new JComboBox<>(items);
        combo7.setPrototypeDisplayValue("Long Item Prototype");
        combo7.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo7.getSelectedItem());
            }
        });
        add(combo7);

        // Example 8: JComboBox with custom renderer
        add(new JLabel("8. JComboBox with custom renderer (bold text):"));
        JComboBox<String> combo8 = new JComboBox<>(items);
        combo8.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setFont(getFont().deriveFont(Font.BOLD));
                return this;
            }
        });
        combo8.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo8.getSelectedItem());
            }
        });
        add(combo8);

        // Example 9: JComboBox with custom editor
        add(new JLabel("9. JComboBox with custom editor (uppercase):"));
        JComboBox<String> combo9 = new JComboBox<>(items);
        combo9.setEditable(true);
        ComboBoxEditor editor = new BasicComboBoxEditor() {
            @Override
            public void setItem(Object anObject) {
                super.setItem(anObject != null ? anObject.toString().toUpperCase() : null);
            }
        };
        combo9.setEditor(editor);
        combo9.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected/Entered: " + combo9.getSelectedItem());
            }
        });
        add(combo9);

        // Example 10: JComboBox with light weight popup
        add(new JLabel("10. JComboBox with light weight popup:"));
        JComboBox<String> combo10 = new JComboBox<>(items);
        combo10.setLightWeightPopupEnabled(true); // Default is true, but explicit
        combo10.addActionListener(e -> {
            if ("comboBoxChanged".equals(e.getActionCommand())) {
                JOptionPane.showMessageDialog(this, "Selected: " + combo10.getSelectedItem());
            }
        });
        add(combo10);

        // Note: For icons in items, you can use objects with custom toString and renderer.
        // But keeping it simple with strings here.

        // To make it scrollable if many examples, but since wrapped in JScrollPane via switchPanel, it's handled.
    }
}
