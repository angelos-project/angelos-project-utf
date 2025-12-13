/**
 * Copyright (c) 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
package org.angproj.utf

import org.angproj.utf.helper.BlockRangeLoader
import org.angproj.utf.helper.DerivedGeneralCategoryLoader
import org.angproj.utf.helper.LanguageBuilder
import org.angproj.utf.helper.ScriptCodeLoader
import org.angproj.utf.model.BlockRange
import org.angproj.utf.ui.button
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

object MainKt {
    @JvmStatic
    fun main(args: Array<String>) {
        //DerivedGeneralCategoryLoader.generateUnassignedCategories()
        //LanguageBuilder.generateLanguageEnumFile()
        println(BlockRangeLoader.generateBlockRangeEnum())

        SwingUtilities.invokeLater({
            val window = UtfInfoGenerator {
                JOptionPane.showMessageDialog(this, "Button clicked from MainKt!")
                //ScriptCodeLoader.allData.forEach { println(it) }
                //DerivedGeneralCategoryLoader.generateUnassignedCategories()
            }
            with(window) {

                button("Load Script Codes") {
                    println("Loading script code from MainKt")
                }
            }
            window.setVisible(true)
        })
    }
}