package org.angproj.utf.ui

import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem

fun JFrame.button(label: String, onPress: JFrame.() -> Unit) {
    val button = JButton(label)
    button.addActionListener { onPress(this) }
    this.add(button, BorderLayout.CENTER)
}

fun JFrame.menubar(action: JMenuBar.() -> Unit) {
    jMenuBar = JMenuBar().apply { action() }
}

fun JMenuBar.menu(label: String, action: JMenu.() -> Unit) {
    val menu = JMenu(label)
    menu.action()
    this.add(menu)
}

fun JMenu.item(label: String, onPress: JMenu.() -> Unit) {
    val menuItem = JMenuItem(label)
    menuItem.addActionListener { onPress(this) }
    this.add(menuItem)
}

fun JMenu.separator() = this.addSeparator()