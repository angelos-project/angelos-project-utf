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
package org.angproj.utf.gui

import java.awt.GridLayout
import java.awt.LayoutManager
import java.awt.event.ActionEvent
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JProgressBar
import javax.swing.JSeparator
import javax.swing.JSlider
import javax.swing.JSpinner
import javax.swing.JSpinner.DateEditor
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.SpinnerDateModel
import javax.swing.SpinnerListModel
import javax.swing.SpinnerNumberModel
import javax.swing.border.Border
import javax.swing.event.ChangeEvent

@SwingGui
class GuiPanelBuilder(private val panel: JPanel = JPanel()) : Component {

    var layout: LayoutManager
        get() = panel.layout
        set(value) { panel.layout = value }

    var border: Border
        get() = panel.border
        set(value) { panel.border = value }

    init {
        layout = GridLayout(0, 1, 10, 10)
        border = BorderFactory.createEmptyBorder(20, 20, 20, 20)
    }

    fun label(text: String) { panel.add(JLabel(text)) }
    fun label(init: JLabel.() -> Unit) {
        val lbl = JLabel()
        lbl.init()
        panel.add(lbl)
    }

    fun button(text: String, onClick: (ActionEvent) -> Unit = {}) {
        val b = JButton(text)
        b.addActionListener { onClick(it) }
        panel.add(b)
    }

    fun checkBox(text: String, onClick: (ActionEvent) -> Unit = {}) {
        val cb = JCheckBox(text)
        cb.addActionListener { onClick(it) }
        panel.add(cb)
    }

    fun list(items: Array<String>) {
        val lst = JList(items)
        panel.add(lst)
    }

    fun passwordField(text: String) {
        val pf = JPasswordField(text)
        panel.add(pf)
    }

    fun progressBar(text: String, value: Int, max: Int) {
        val pb = JProgressBar(0, max)
        pb.value = value
        pb.string = text
        pb.isStringPainted = true
        panel.add(pb)
    }

    fun radioButtons(init: GuiRadioButtonGroupBuilder.() -> Unit) {
        val groupBuilder = GuiRadioButtonGroupBuilder(panel)
        groupBuilder.init()
        groupBuilder.build()
    }

    fun slider(orientation: Orientation = Orientation.HORIZONTAL, onChange: (ChangeEvent) -> Unit = {}) {
        val slider = JSlider(orientation.value)
        slider.addChangeListener { onChange(it) }
        panel.add(slider)
    }

    fun dateSpinner() {
        val spinner = JSpinner(SpinnerDateModel())
        spinner.editor = DateEditor(spinner, "yyyy-MM-dd")
        panel.add(spinner)
    }

    fun numberSpinner(min: Int, max: Int, step: Int, initial: Int) {
        val spinner = JSpinner(SpinnerNumberModel(initial, min, max, step))
        panel.add(spinner)
    }

    fun listSpinner(items: Array<String>) {
        val spinner = JSpinner(SpinnerListModel(items.toList()))
        panel.add(spinner)
    }

    fun textArea(text: String, rows: Int = 5, columns: Int = 20) {
        val ta = JTextArea(text, rows, columns)
        ta.setLineWrap(true)
        ta.setWrapStyleWord(true)
        panel.add(ta)
    }

    fun textField(text: String, onEnter: (ActionEvent) -> Unit = {}) {
        val tf = JTextField(text)
        tf.addActionListener { onEnter(it) }
        panel.add(tf)
    }

    fun toggleButtons(init: GuiToggleButtonGroupBuilder.() -> Unit) {
        val groupBuilder = GuiToggleButtonGroupBuilder(panel)
        groupBuilder.init()
        groupBuilder.build()
    }

    fun separator() { panel.add(JSeparator()) }

    override fun build(): JPanel = panel
}