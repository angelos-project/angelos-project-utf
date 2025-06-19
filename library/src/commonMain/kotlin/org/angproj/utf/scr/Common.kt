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
import org.angproj.utf.blk.Devanagari
import org.angproj.utf.blk.Georgian
import org.angproj.utf.blk.Hanunoo
import org.angproj.utf.blk.Hiragana
import org.angproj.utf.blk.Javanese
import org.angproj.utf.blk.Katakana
import org.angproj.utf.blk.KayahLi
import org.angproj.utf.blk.Mongolian
import org.angproj.utf.blk.Runic
import org.angproj.utf.blk.Thai
import org.angproj.utf.blk.Tibetan

public object Common : Script {
    override val name: String = "Code for undetermined script"
    override val code: String = "Zyyy"
    override val no: Int = 998

    override val blocks: Set<UtfBlock> = setOf(
        AegeanNumbers,
        AlchemicalSymbols,
        AncientSymbols,
        Arabic,
        ArabicExtendedA,
        ArabicPresentationFormsA,
        ArabicPresentationFormsB,
        Arrows,
        BasicLatin,
        BlockElements,
        BoxDrawing,
        ByzantineMusicalSymbols,
        ChessSymbols,
        CjkCompatibility,
        CjkCompatibilityForms,
        CjkStrokes,
        CjkSymbolsAndPunctuation,
        CommonIndicNumberForms,
        ControlPictures,
        CopticEpactNumbers,
        CountingRodNumerals,
        CurrencySymbols,
        Devanagari,
        Dingbats,
        DominoTiles,
        Emoticons,
        EnclosedAlphanumerics,
        EnclosedAlphanumericSupplement,
        EnclosedCjkLettersAndMonths,
        EnclosedIdeographicSupplement,
        GeneralPunctuation,
        GeometricShapes,
        GeometricShapesExtended,
        Georgian,
        GreekAndCoptic,
        HalfwidthAndFullwidthForms,
        Hanunoo,
        Hiragana,
        IdeographicDescriptionCharacters,
        IndicSiyaqNumbers,
        Javanese,
        KaktovikNumerals,
        Kanbun,
        Katakana,
        KayahLi,
        Latin1Supplement,
        LatinExtendedD,
        LatinExtendedE,
        LetterlikeSymbols,
        MahjongTiles,
        MathematicalAlphanumericSymbols,
        MathematicalOperators,
        MayanNumerals,
        MiscellaneousMathematicalSymbolsA,
        MiscellaneousMathematicalSymbolsB,
        MiscellaneousSymbols,
        MiscellaneousSymbolsAndArrows,
        MiscellaneousSymbolsAndPictographs,
        MiscellaneousTechnical,
        ModifierToneLetters,
        Mongolian,
        MusicalSymbols,
        NumberForms,
        OpticalCharacterRecognition,
        OrnamentalDingbats,
        OttomanSiyaqNumbers,
        PhaistosDisc,
        PlayingCards,
        Runic,
        ShorthandFormatControls,
        SmallFormVariants,
        SpacingModifierLetters,
        Specials,
        SuperscriptsAndSubscripts,
        SupplementalArrowsA,
        SupplementalArrowsB,
        SupplementalArrowsC,
        SupplementalMathematicalOperators,
        SupplementalPunctuation,
        SupplementalSymbolsAndPictographs,
        SymbolsAndPictographsExtendedA,
        SymbolsForLegacyComputing,
        SymbolsForLegacyComputingSupplement,
        Tags,
        TaiXuanJingSymbols,
        Thai,
        Tibetan,
        TransportAndMapSymbols,
        VedicExtensions,
        VerticalForms,
        YijingHexagramSymbols,
        ZnamennyMusicalNotation
    )
}
