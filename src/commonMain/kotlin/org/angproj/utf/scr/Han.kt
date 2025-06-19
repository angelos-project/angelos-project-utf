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

public object Han : Script {
    override val name: String = "Han (Hanzi, Kanji, Hanja)"
    override val code: String = "Hani"
    override val no: Int = 500

    override val blocks: Set<UtfBlock> = setOf(
        CjkCompatibilityIdeographs,
        CjkCompatibilityIdeographsSupplement,
        CjkRadicalsSupplement,
        CjkSymbolsAndPunctuation,
        CjkUnifiedIdeographs,
        CjkUnifiedIdeographsExtensionA,
        CjkUnifiedIdeographsExtensionB,
        CjkUnifiedIdeographsExtensionC,
        CjkUnifiedIdeographsExtensionD,
        CjkUnifiedIdeographsExtensionE,
        CjkUnifiedIdeographsExtensionF,
        CjkUnifiedIdeographsExtensionG,
        CjkUnifiedIdeographsExtensionH,
        CjkUnifiedIdeographsExtensionI,
        IdeographicSymbolsAndPunctuation,
        KangxiRadicals
    )
}
