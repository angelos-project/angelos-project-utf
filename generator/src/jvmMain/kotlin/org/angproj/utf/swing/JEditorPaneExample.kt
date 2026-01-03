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
import javax.swing.*
import javax.swing.event.HyperlinkEvent
import javax.swing.event.HyperlinkListener
import javax.swing.text.rtf.RTFEditorKit

internal class JEditorPaneExample : JPanel() {
    init {
        setLayout(GridLayout(0, 1, 10, 10)) // Vertical layout for examples
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

        // Example 1: Default JEditorPane (empty, editable)
        add(JLabel("1. Default JEditorPane (empty, editable):"))
        val editor1 = JEditorPane()
        editor1.setPreferredSize(Dimension(300, 100))
        add(editor1)

        // Example 2: JEditorPane with plain text
        add(JLabel("2. JEditorPane with plain text:"))
        val editor2 = JEditorPane()
        editor2.setText("This is plain text.")
        editor2.setPreferredSize(Dimension(300, 100))
        add(editor2)

        // Example 3: Non-editable JEditorPane
        add(JLabel("3. Non-editable JEditorPane:"))
        val editor3 = JEditorPane()
        editor3.setText("This text is not editable.")
        editor3.setEditable(false)
        editor3.setPreferredSize(Dimension(300, 100))
        add(editor3)

        // Example 4: JEditorPane with HTML content
        add(JLabel("4. JEditorPane with HTML content:"))
        val editor4 = JEditorPane()
        editor4.setContentType("text/html")
        editor4.setText("<html><body><h1>Hello</h1><p>This is <b>HTML</b> content.</p></body></html>")
        editor4.setPreferredSize(Dimension(300, 100))
        add(editor4)

        // Example 5: JEditorPane with hyperlink listener
        add(JLabel("5. JEditorPane with hyperlink (click the link):"))
        val editor5 = JEditorPane()
        editor5.setContentType("text/html")
        editor5.setText("<html><body>Visit <a href=\"https://www.example.com\">Example</a></body></html>")
        editor5.setEditable(false)
        editor5.addHyperlinkListener(HyperlinkListener { e: HyperlinkEvent? ->
            if (e!!.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                JOptionPane.showMessageDialog(this, "Hyperlink activated: " + e.getURL())
            }
        })
        editor5.setPreferredSize(Dimension(300, 100))
        add(editor5)

        // Example 6: Disabled JEditorPane
        add(JLabel("6. Disabled JEditorPane:"))
        val editor6 = JEditorPane()
        editor6.setText("This is disabled.")
        editor6.setEnabled(false)
        editor6.setPreferredSize(Dimension(300, 100))
        add(editor6)

        // Example 7: JEditorPane with tooltip
        add(JLabel("7. JEditorPane with tooltip (hover to see):"))
        val editor7 = JEditorPane()
        editor7.setText("Hover me.")
        editor7.setToolTipText("This is a tooltip!")
        editor7.setPreferredSize(Dimension(300, 100))
        add(editor7)

        // Example 8: JEditorPane with custom caret color
        add(JLabel("8. JEditorPane with custom caret color (red):"))
        val editor8 = JEditorPane()
        editor8.setText("Type here.")
        editor8.setCaretColor(Color.RED)
        editor8.setPreferredSize(Dimension(300, 100))
        add(editor8)

        // Example 9: JEditorPane with RTF content (requires RTFEditorKit)
        add(JLabel("9. JEditorPane with RTF content:"))
        val editor9 = JEditorPane()
        editor9.setEditorKit(RTFEditorKit())
        editor9.setText("{\\rtf1\\ansi This is \\b bold \\b0 RTF text.}") // Simple RTF
        editor9.setPreferredSize(Dimension(300, 100))
        add(editor9)

        // Example 10: JEditorPane with custom margin
        add(JLabel("10. JEditorPane with custom margin:"))
        val editor10 = JEditorPane()
        editor10.setText("This has custom margins.")
        editor10.setMargin(Insets(10, 10, 10, 10))
        editor10.setPreferredSize(Dimension(300, 100))
        add(editor10)

        // Note: For loading from URL, e.g., editor.setPage("https://www.example.com"); but may throw exceptions, so omitted.
        // Scrollbars can be added individually if needed, but since panel is scrolled, ok.
    }
}
