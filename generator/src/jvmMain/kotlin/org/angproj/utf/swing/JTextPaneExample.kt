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

import java.awt.Color
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.Insets
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextPane
import javax.swing.text.BadLocationException
import javax.swing.text.SimpleAttributeSet
import javax.swing.text.StyleConstants
import javax.swing.text.rtf.RTFEditorKit

internal class JTextPaneExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JTextPane (empty, editable)
        add(JLabel("1. Default JTextPane (empty, editable):"))
        val pane1 = JTextPane()
        pane1.setPreferredSize(Dimension(300, 100))
        add(pane1)

        // Example 2: JTextPane with plain text
        add(JLabel("2. JTextPane with plain text:"))
        val pane2 = JTextPane()
        pane2.setText("This is plain text.")
        pane2.setPreferredSize(Dimension(300, 100))
        add(pane2)

        // Example 3: Non-editable JTextPane
        add(JLabel("3. Non-editable JTextPane:"))
        val pane3 = JTextPane()
        pane3.setText("This text is not editable.")
        pane3.setEditable(false)
        pane3.setPreferredSize(Dimension(300, 100))
        add(pane3)

        // Example 4: JTextPane with styled text (bold and italic)
        add(JLabel("4. JTextPane with styled text (bold and italic):"))
        val pane4 = JTextPane()
        val doc4 = pane4.getStyledDocument()
        val bold = SimpleAttributeSet()
        StyleConstants.setBold(bold, true)
        val italic = SimpleAttributeSet()
        StyleConstants.setItalic(italic, true)
        try {
            doc4.insertString(0, "Bold text. ", bold)
            doc4.insertString(doc4.getLength(), "Italic text.", italic)
        } catch (ex: BadLocationException) {
            ex.printStackTrace()
        }
        pane4.setPreferredSize(Dimension(300, 100))
        add(pane4)

        // Example 5: JTextPane with HTML content
        add(JLabel("5. JTextPane with HTML content:"))
        val pane5 = JTextPane()
        pane5.setContentType("text/html")
        pane5.setText("<html><body><h1>Hello</h1><p>This is <b>HTML</b> content.</p></body></html>")
        pane5.setPreferredSize(Dimension(300, 100))
        add(pane5)

        // Example 6: Disabled JTextPane
        add(JLabel("6. Disabled JTextPane:"))
        val pane6 = JTextPane()
        pane6.setText("This is disabled.")
        pane6.setEnabled(false)
        pane6.setPreferredSize(Dimension(300, 100))
        add(pane6)

        // Example 7: JTextPane with tooltip
        add(JLabel("7. JTextPane with tooltip (hover to see):"))
        val pane7 = JTextPane()
        pane7.setText("Hover me.")
        pane7.setToolTipText("This is a tooltip!")
        pane7.setPreferredSize(Dimension(300, 100))
        add(pane7)

        // Example 8: JTextPane with custom caret color
        add(JLabel("8. JTextPane with custom caret color (red):"))
        val pane8 = JTextPane()
        pane8.setText("Type here.")
        pane8.setCaretColor(Color.RED)
        pane8.setPreferredSize(Dimension(300, 100))
        add(pane8)

        // Example 9: JTextPane with RTF content (requires RTFEditorKit)
        add(JLabel("9. JTextPane with RTF content:"))
        val pane9 = JTextPane()
        pane9.setEditorKit(RTFEditorKit())
        pane9.setText("{\\rtf1\\ansi This is \\b bold \\b0 RTF text.}") // Simple RTF
        pane9.setPreferredSize(Dimension(300, 100))
        add(pane9)

        // Example 10: JTextPane with custom margin
        add(JLabel("10. JTextPane with custom margin:"))
        val pane10 = JTextPane()
        pane10.setText("This has custom margins.")
        pane10.setMargin(Insets(10, 10, 10, 10))
        pane10.setPreferredSize(Dimension(300, 100))
        add(pane10)

        // Example 11: JTextPane with styled text color
        add(JLabel("11. JTextPane with styled text color (red):"))
        val pane11 = JTextPane()
        val doc11 = pane11.getStyledDocument()
        val red = SimpleAttributeSet()
        StyleConstants.setForeground(red, Color.RED)
        try {
            doc11.insertString(0, "Red text.", red)
        } catch (ex: BadLocationException) {
            ex.printStackTrace()
        }
        pane11.setPreferredSize(Dimension(300, 100))
        add(pane11)

        // Note: For loading from URL, e.g., pane.setPage("https://www.example.com"); but may throw exceptions, so omitted.
        // Scrollbars not added since examples are small.
    }
}
