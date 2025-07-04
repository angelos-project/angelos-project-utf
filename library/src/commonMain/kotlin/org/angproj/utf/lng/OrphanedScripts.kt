package org.angproj.utf.lng

import org.angproj.utf.Script
import org.angproj.utf.UtfLanguage
import org.angproj.utf.scr.Ahom
import org.angproj.utf.scr.AnatolianHieroglyphs
import org.angproj.utf.scr.BassaVah
import org.angproj.utf.scr.Bhaiksuki
import org.angproj.utf.scr.Brahmi
import org.angproj.utf.scr.Braille
import org.angproj.utf.scr.Chorasmian
import org.angproj.utf.scr.CyproMinoan
import org.angproj.utf.scr.DivesAkuru
import org.angproj.utf.scr.Dogra
import org.angproj.utf.scr.Elymaic
import org.angproj.utf.scr.Garay
import org.angproj.utf.scr.Glagolitic
import org.angproj.utf.scr.GunjalaGondi
import org.angproj.utf.scr.GurungKhema
import org.angproj.utf.scr.Hangul
import org.angproj.utf.scr.Hatran
import org.angproj.utf.scr.Hiragana
import org.angproj.utf.scr.Inherited
import org.angproj.utf.scr.Kaithi
import org.angproj.utf.scr.Kharoshthi
import org.angproj.utf.scr.KhitanSmallScript
import org.angproj.utf.scr.KiratRai
import org.angproj.utf.scr.Makasar
import org.angproj.utf.scr.Marchen
import org.angproj.utf.scr.MasaramGondi
import org.angproj.utf.scr.Medefaidrin
import org.angproj.utf.scr.MeroiticHieroglyphs
import org.angproj.utf.scr.Multani
import org.angproj.utf.scr.NagMundari
import org.angproj.utf.scr.Nandinagari
import org.angproj.utf.scr.Newa
import org.angproj.utf.scr.Nushu
import org.angproj.utf.scr.NyiakengPuachueHmong
import org.angproj.utf.scr.OlOnal
import org.angproj.utf.scr.OldHungarian
import org.angproj.utf.scr.OldSogdian
import org.angproj.utf.scr.OldUyghur
import org.angproj.utf.scr.OrphanedBlocks
import org.angproj.utf.scr.PauCinHau
import org.angproj.utf.scr.SignWriting
import org.angproj.utf.scr.Sogdian
import org.angproj.utf.scr.Soyombo
import org.angproj.utf.scr.Sunuwar
import org.angproj.utf.scr.Tangsa
import org.angproj.utf.scr.Tangut
import org.angproj.utf.scr.Todhri
import org.angproj.utf.scr.Toto
import org.angproj.utf.scr.TuluTigalari
import org.angproj.utf.scr.Vithkuqi
import org.angproj.utf.scr.Wancho
import org.angproj.utf.scr.Yezidi
import org.angproj.utf.scr.ZanabazarSquare

public object OrphanedScripts : UtfLanguage {
    override val name: String = "Orphans"
    override val short: String = ""
    override val long: String = "000"

    override val scripts: Set<Script> = setOf(
        Ahom, AnatolianHieroglyphs, BassaVah, Bhaiksuki, Brahmi, Braille,
        Chorasmian, CyproMinoan, DivesAkuru, Dogra, Elymaic, Garay, Glagolitic, GunjalaGondi, GurungKhema, Hangul,
        Hatran, Hiragana, Inherited, Kaithi, Kharoshthi, KhitanSmallScript, KiratRai, Makasar, Marchen, MasaramGondi,
        Medefaidrin, MeroiticHieroglyphs, Multani, NagMundari, Nandinagari, Newa, Nushu, NyiakengPuachueHmong, OlOnal,
        OldHungarian, OldSogdian, OldUyghur, PauCinHau, SignWriting, Sogdian, Soyombo, Sunuwar, Tangsa, Tangut, Todhri,
        Toto, TuluTigalari, Vithkuqi, Wancho, Yezidi, ZanabazarSquare
    )
}