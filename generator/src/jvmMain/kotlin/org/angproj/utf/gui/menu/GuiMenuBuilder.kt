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

import org.angproj.utf.gui.OrdinaryKey
import org.angproj.utf.gui.SwingGui
import javax.swing.JMenu

@SwingGui
class GuiMenuBuilder : AbstractMenuBuilder() {
    private var _mnemonic: OrdinaryKey = OrdinaryKey.DISABLED
    var mnemonic: OrdinaryKey
        get() = _mnemonic
        set(value) {
            _mnemonic = value
        }

    fun build(): JMenu {
        return JMenu(text).apply {
            if (_mnemonic != OrdinaryKey.DISABLED) {
                mnemonic = _mnemonic.code
            }
            someBuild(this)
        }
    }
}