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
package org.angproj.utf.scr

import org.angproj.utf.Script
import org.angproj.utf.UtfBlock
import org.angproj.utf.blk.*
import org.angproj.utf.blk.Arabic
import org.angproj.utf.blk.Cyrillic
import org.angproj.utf.blk.Devanagari
import org.angproj.utf.blk.Grantha
import org.angproj.utf.blk.Hiragana

public object Inherited : Script {
    override val name: String = "Code for inherited script"
    override val code: String = "Zinh"
    override val no: Int = 994

    override val blocks: Set<UtfBlock> = setOf(
        Arabic,
        CjkSymbolsAndPunctuation,
        CombiningDiacriticalMarks,
        CombiningDiacriticalMarksExtended,
        CombiningDiacriticalMarksForSymbols,
        CombiningDiacriticalMarksSupplement,
        CombiningHalfMarks,
        CopticEpactNumbers,
        Cyrillic,
        Devanagari,
        GeneralPunctuation,
        Grantha,
        Hiragana,
        MusicalSymbols,
        PhaistosDisc,
        VariationSelectors,
        VariationSelectorsSupplement,
        VedicExtensions,
        ZnamennyMusicalNotation
    )
}
