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

public object Latin : Script {
    override val name: String = "Latin"
    override val code: String = "Latn"
    override val no: Int = 215

    override val blocks: Set<UtfBlock> = setOf(
        AlphabeticPresentationForms,
        BasicLatin,
        HalfwidthAndFullwidthForms,
        IpaExtensions,
        Latin1Supplement,
        LatinExtendedA,
        LatinExtendedAdditional,
        LatinExtendedB,
        LatinExtendedC,
        LatinExtendedD,
        LatinExtendedE,
        LatinExtendedF,
        LatinExtendedG,
        LetterlikeSymbols,
        NumberForms,
        PhoneticExtensions,
        PhoneticExtensionsSupplement,
        SpacingModifierLetters,
        SuperscriptsAndSubscripts
    )
}
