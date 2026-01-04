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
import java.awt.*;

class JScrollPaneExample extends JPanel {

    public JScrollPaneExample() {
        setLayout(new GridLayout(0, 1, 10, 10)); // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Example 1: Default JScrollPane (AS_NEEDED policies)
        add(new JLabel("1. Default JScrollPane (AS_NEEDED policies):"));
        JScrollPane scroll1 = new JScrollPane(createTextArea());
        scroll1.setPreferredSize(new Dimension(300, 100));
        add(scroll1);

        // Example 2: JScrollPane with ALWAYS horizontal scrollbar
        add(new JLabel("2. JScrollPane with ALWAYS horizontal scrollbar:"));
        JScrollPane scroll2 = new JScrollPane(createTextArea());
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll2.setPreferredSize(new Dimension(300, 100));
        add(scroll2);

        // Example 3: JScrollPane with ALWAYS vertical scrollbar
        add(new JLabel("3. JScrollPane with ALWAYS vertical scrollbar:"));
        JScrollPane scroll3 = new JScrollPane(createTextArea());
        scroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll3.setPreferredSize(new Dimension(300, 100));
        add(scroll3);

        // Example 4: JScrollPane with NEVER scrollbars
        add(new JLabel("4. JScrollPane with NEVER scrollbars:"));
        JScrollPane scroll4 = new JScrollPane(createTextArea());
        scroll4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll4.setPreferredSize(new Dimension(300, 100));
        add(scroll4);

        // Example 5: JScrollPane with column header
        add(new JLabel("5. JScrollPane with column header:"));
        JScrollPane scroll5 = new JScrollPane(createTextArea());
        scroll5.setColumnHeaderView(new JLabel("Column Header"));
        scroll5.setPreferredSize(new Dimension(300, 100));
        add(scroll5);

        // Example 6: JScrollPane with row header
        add(new JLabel("6. JScrollPane with row header:"));
        JScrollPane scroll6 = new JScrollPane(createTextArea());
        scroll6.setRowHeaderView(new JLabel("Row Header"));
        scroll6.setPreferredSize(new Dimension(300, 100));
        add(scroll6);

        // Example 7: JScrollPane with corner component (lower left)
        add(new JLabel("7. JScrollPane with corner component (lower left):"));
        JScrollPane scroll7 = new JScrollPane(createTextArea());
        scroll7.setCorner(JScrollPane.LOWER_LEFT_CORNER, new JButton("Corner"));
        scroll7.setPreferredSize(new Dimension(300, 100));
        add(scroll7);

        // Example 8: Disabled JScrollPane
        add(new JLabel("8. Disabled JScrollPane:"));
        JScrollPane scroll8 = new JScrollPane(createTextArea());
        scroll8.setEnabled(false);
        scroll8.setPreferredSize(new Dimension(300, 100));
        add(scroll8);

        // Example 9: JScrollPane with tooltip
        add(new JLabel("9. JScrollPane with tooltip (hover to see):"));
        JScrollPane scroll9 = new JScrollPane(createTextArea());
        scroll9.setToolTipText("This is a tooltip!");
        scroll9.setPreferredSize(new Dimension(300, 100));
        add(scroll9);

        // Example 10: JScrollPane with custom border
        add(new JLabel("10. JScrollPane with custom border:"));
        JScrollPane scroll10 = new JScrollPane(createTextArea());
        scroll10.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        scroll10.setPreferredSize(new Dimension(300, 100));
        add(scroll10);

        // Example 11: JScrollPane with wheel scrolling disabled
        add(new JLabel("11. JScrollPane with wheel scrolling disabled:"));
        JScrollPane scroll11 = new JScrollPane(createTextArea());
        scroll11.setWheelScrollingEnabled(false);
        scroll11.setPreferredSize(new Dimension(300, 100));
        add(scroll11);

        // Example 12: JScrollPane with custom viewport
        add(new JLabel("12. JScrollPane with custom viewport:"));
        JViewport viewport = new JViewport();
        viewport.setView(createTextArea());
        JScrollPane scroll12 = new JScrollPane();
        scroll12.setViewport(viewport);
        scroll12.setPreferredSize(new Dimension(300, 100));
        add(scroll12);

        // Note: Additional configurations like setViewportBorder, but basics covered.
    }

    // Helper method to create scrollable content (e.g., large JTextArea)
    JTextArea createTextArea() {
        JTextArea area = new JTextArea();
        for (int i = 0; i < 50; i++) {
            area.append("Line " + i + "\n");
        }
        return area;
    }
}
