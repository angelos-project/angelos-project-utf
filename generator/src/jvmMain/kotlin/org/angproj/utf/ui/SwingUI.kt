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

import org.angproj.utf.model.SearchName

enum class SwingUI(val component: String) {
    GUI_APPLET("JApplet"),
    GUI_BUTTON("JButton"),
    GUI_CHECK_BOX("JCheckBox"),
    GUI_CHECK_BOX_MENU_ITEM("JCheckBoxMenuItem"),
    GUI_COLOR_CHOOSER("JColorChooser"),
    GUI_COMBO_BOX("JComboBox"),
    GUI_COMPONENT("JComponent"), // --
    GUI_DESKTOP_PANE("JDesktopPane"), // --
    GUI_DIALOG("JDialog"),
    GUI_EDITOR_PANE("JEditorPane"), // --
    GUI_FILE_CHOOSER("JFileChooser"),
    GUI_FORMATTED_TEXT_FIELD("JFormattedTextField"),
    GUI_FRAME("JFrame"),
    GUI_INTERNAL_FRAME("JInternalFrame"),
    GUI_LABEL("JLabel"),
    GUI_LAYER("JLayer"),
    GUI_LAYERED_PANE("JLayeredPane"),
    GUI_LIST("JList"),
    GUI_MENU("JMenu"),
    GUI_MENU_BAR("JMenuBar"),
    GUI_MENU_ITEM("JMenuItem"),
    GUI_OPTION_PANE("JOptionPane"),
    GUI_PANEL("JPanel"),
    GUI_PASSWORD_FIELD("JPasswordField"),
    GUI_POPUP_MENU("JPopupMenu"),
    GUI_PROGRESS_BAR("JProgressBar"),
    GUI_RADIO_BUTTON("JRadioButton"),
    GUI_RADIO_BUTTON_MENU_ITEM("JRadioButtonMenuItem"),
    GUI_ROOT_PANE("JRootPane"),
    GUI_SCROLL_BAR("JScrollBar"),
    GUI_SCROLL_PANE("JScrollPane"),
    GUI_SEPARATOR("JSeparator"),
    GUI_SLIDER("JSlider"),
    GUI_SPINNER("JSpinner"),
    GUI_SPLIT_PANE("JSplitPane"),
    GUI_TABBED_PANE("JTabbedPane"),
    GUI_TABLE("JTable"),
    GUI_TEXT_AREA("JTextArea"),
    GUI_TEXT_FIELD("JTextField"),
    GUI_TEXT_PANE("JTextPane"),
    GUI_TOGGLE_BUTTON("JToggleButton"),
    GUI_TOOL_BAR("JToolBar"),
    GUI_TOOL_TIP("JToolTip"),
    GUI_TREE("JTree"),
    GUI_VIEWPORT("JViewport"),
    GUI_WINDOW("JWindow");

    companion object {

        fun generateCode() {
            SwingUI.entries.forEachIndexed { idx, data ->
                val lineEnding = SearchName(data.component)
                println(
                    "    ${SearchName.camelCaseSplitAndUnderscore(lineEnding.canonical).replace("J_", "GUI_")}(\"${lineEnding.canonical}\"),"
                )
            }
        }
    }
}