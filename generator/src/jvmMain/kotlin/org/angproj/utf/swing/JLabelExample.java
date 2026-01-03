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
import java.awt.event.KeyEvent;

class JLabelExample extends JPanel {

    public JLabelExample() {
        setLayout(new GridLayout(0, 1, 10, 10)); // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Example 1: Default JLabel (empty)
        add(new JLabel("1. Default JLabel (empty):"));
        JLabel label1 = new JLabel();
        add(label1);

        // Example 2: JLabel with text
        add(new JLabel("2. JLabel with text:"));
        JLabel label2 = new JLabel("This is a label with text.");
        add(label2);

        // Example 3: Disabled JLabel
        add(new JLabel("3. Disabled JLabel:"));
        JLabel label3 = new JLabel("This label is disabled.");
        label3.setEnabled(false);
        add(label3);

        // Example 4: JLabel with tooltip
        add(new JLabel("4. JLabel with tooltip (hover to see):"));
        JLabel label4 = new JLabel("Label with Tooltip");
        label4.setToolTipText("This is a tooltip!");
        add(label4);

        // Example 5: JLabel with custom foreground and background
        add(new JLabel("5. JLabel with custom colors:"));
        JLabel label5 = new JLabel("Colored Label");
        label5.setForeground(Color.RED);
        label5.setBackground(Color.YELLOW);
        label5.setOpaque(true); // Needed for background to show
        add(label5);

        // Example 6: JLabel with horizontal alignment (left)
        add(new JLabel("6. JLabel with left horizontal alignment:"));
        JLabel label6 = new JLabel("Left Aligned");
        label6.setHorizontalAlignment(SwingConstants.LEFT);
        label6.setPreferredSize(new Dimension(200, 30));
        label6.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // To visualize
        add(label6);

        // Example 7: JLabel with vertical alignment (top)
        add(new JLabel("7. JLabel with top vertical alignment:"));
        JLabel label7 = new JLabel("Top Aligned");
        label7.setVerticalAlignment(SwingConstants.TOP);
        label7.setPreferredSize(new Dimension(200, 50));
        label7.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // To visualize
        add(label7);

        // Example 8: JLabel with mnemonic (keyboard shortcut, Alt + L)
        add(new JLabel("8. JLabel with mnemonic (Alt + L):"));
        JLabel label8 = new JLabel("Label with Mnemonic");
        label8.setDisplayedMnemonic(KeyEvent.VK_L);
        add(label8);

        // Example 9: JLabel with text and icon position (text below icon)
        add(new JLabel("9. JLabel with text below (no icon for demo):"));
        JLabel label9 = new JLabel("Text Below");
        label9.setVerticalTextPosition(SwingConstants.BOTTOM);
        label9.setHorizontalTextPosition(SwingConstants.CENTER);
        // For icon: label9.setIcon(new ImageIcon("path/to/icon.png"));
        add(label9);

        // Example 10: JLabel with HTML text
        add(new JLabel("10. JLabel with HTML text:"));
        JLabel label10 = new JLabel("<html><b>Bold</b> and <i>Italic</i> Text</html>");
        add(label10);

        // Note: For icons, use setIcon(new ImageIcon("path/to/icon.png")); omitted since no images.
        // Additional: setBorder, setFont, etc., but covered basics.
    }
}
