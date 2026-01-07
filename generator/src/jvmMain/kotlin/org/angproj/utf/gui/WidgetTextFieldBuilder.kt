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

import javax.swing.JTextField

class WidgetTextFieldBuilder : AbstractWidgetBuilder() {
    private var _alignment = TextAlign.LEFT
    var align: TextAlign
        get() = _alignment
        set(value) { _alignment = value }

    private var _columns: Int = 0
    var cols: Int
        get() = _columns
        set(value) { _columns = value }

    private var onChange: (String) -> Unit = {}
    fun onChange(action: (String) -> Unit) {
        onChange = action
    }

    fun build(): JTextField {
        val textField = JTextField(_text, _columns)
        textField.horizontalAlignment = _alignment.value
        textField.addActionListener {
            _text = textField.text
            onChange(_text)
        }
        return textField
    }
}