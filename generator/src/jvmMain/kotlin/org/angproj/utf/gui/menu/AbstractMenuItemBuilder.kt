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
package org.angproj.utf.gui.menu

import javax.swing.ImageIcon
import javax.swing.KeyStroke

abstract class AbstractMenuItemBuilder : MetaMenuItem {
    private var _text: String = ""
    override var text: String
        get() = _text
        set(value) {
            _text = value
        }

    private var _accel: KeyStroke? = null
    override var accel: KeyStroke?
        get() = _accel
        set(value) {
            _accel = value
        }

    private var _icon: ImageIcon? = null
    override var icon: ImageIcon?
        get() = _icon
        set(value) {
            _icon = value
        }
}