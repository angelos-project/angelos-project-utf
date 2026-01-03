package org.angproj.utf.swing

import java.awt.Color
import java.awt.GridLayout
import java.awt.event.KeyEvent
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.SwingConstants

internal class JButtonExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JButton with text
        add(JLabel("1. Default JButton with text:"))
        val button1: JButton = JButton("Default Button")
        button1.addActionListener({ e -> JOptionPane.showMessageDialog(this, "Default Button clicked!") })
        add(button1)

        // Example 2: JButton with mnemonic (keyboard shortcut)
        add(JLabel("2. JButton with mnemonic (Alt + C):"))
        val button2: JButton = JButton("Click Me")
        button2.setMnemonic(KeyEvent.VK_C)
        button2.addActionListener({ e -> JOptionPane.showMessageDialog(this, "Button with mnemonic clicked!") })
        add(button2)

        // Example 3: Disabled JButton
        add(JLabel("3. Disabled JButton:"))
        val button3: JButton = JButton("Disabled Button")
        button3.setEnabled(false)
        add(button3)

        // Example 4: JButton with tooltip
        add(JLabel("4. JButton with tooltip (hover to see):"))
        val button4: JButton = JButton("Button with Tooltip")
        button4.setToolTipText("This is a tooltip!")
        button4.addActionListener({ e -> JOptionPane.showMessageDialog(this, "Button with tooltip clicked!") })
        add(button4)

        // Example 5: JButton with custom background and foreground
        add(JLabel("5. JButton with custom colors:"))
        val button5: JButton = JButton("Colored Button")
        button5.setBackground(Color.BLUE)
        button5.setForeground(Color.WHITE)
        button5.addActionListener({ e -> JOptionPane.showMessageDialog(this, "Colored Button clicked!") })
        add(button5)

        // Example 6: JButton without border painted
        add(JLabel("6. JButton without border:"))
        val button6: JButton = JButton("No Border Button")
        button6.setBorderPainted(false)
        button6.addActionListener({ e -> JOptionPane.showMessageDialog(this, "No Border Button clicked!") })
        add(button6)

        // Example 7: JButton without content area filled
        add(JLabel("7. JButton without content fill:"))
        val button7: JButton = JButton("Transparent Content")
        button7.setContentAreaFilled(false)
        button7.addActionListener({ e -> JOptionPane.showMessageDialog(this, "Transparent Content Button clicked!") })
        add(button7)

        // Example 8: JButton with horizontal text alignment
        add(JLabel("8. JButton with left-aligned text:"))
        val button8: JButton = JButton("Left Aligned")
        button8.setHorizontalAlignment(SwingConstants.LEFT)
        button8.addActionListener({ e -> JOptionPane.showMessageDialog(this, "Left Aligned Button clicked!") })
        add(button8)

        // Note: For icons, you would use ImageIcon, e.g., new JButton(new ImageIcon("path/to/icon.png"));
        // But since no images are provided, omitting icon examples here. You can add them similarly.

        // To make it scrollable if many examples
        // But for now, simple layout
    }
}
