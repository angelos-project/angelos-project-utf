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

import javax.swing.JCheckBox

class WidgetCheckBoxBuilder : AbstractWidgetBuilder(), MetaCheckBoxWidget {
    var _checked: Boolean = false
    private var onChange: (Boolean) -> Unit = {}

    override var isChecked: Boolean
        get() = _checked
        set(value) {
            _checked = value
        }

    override fun onChange(action: (Boolean) -> Unit) {
        onChange = action
    }

    fun build(): JCheckBox = JCheckBox(text, _checked).apply {
        addActionListener {
            _checked = isSelected
            onChange(_checked)
        }
    }
}