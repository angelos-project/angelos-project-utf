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

import org.angproj.utf.lng.Abaza
import org.angproj.utf.lng.Abkhazian
import org.angproj.utf.lng.Abron
import org.angproj.utf.lng.Achinese
import org.angproj.utf.lng.Acoli
import org.angproj.utf.lng.Adangme
import org.angproj.utf.lng.Adyghe
import org.angproj.utf.lng.Afar
import org.angproj.utf.lng.Afrikaans
import org.angproj.utf.lng.Aghem
import org.angproj.utf.lng.AinuJapan
import org.angproj.utf.lng.Akan
import org.angproj.utf.lng.Akkadian
import org.angproj.utf.lng.Akoose
import org.angproj.utf.lng.Alabama
import org.angproj.utf.lng.Albanian
import org.angproj.utf.lng.Aleut
import org.angproj.utf.lng.AlgerianArabic
import org.angproj.utf.lng.Amharic
import org.angproj.utf.lng.Amo
import org.angproj.utf.lng.AncientGreekTo1453
import org.angproj.utf.lng.AncientNorthArabian
import org.angproj.utf.lng.Angika
import org.angproj.utf.lng.Anii
import org.angproj.utf.lng.AoNaga
import org.angproj.utf.lng.Arabic
import org.angproj.utf.lng.Aragonese
import org.angproj.utf.lng.Araona
import org.angproj.utf.lng.Arapaho
import org.angproj.utf.lng.Arawak
import org.angproj.utf.lng.Armenian
import org.angproj.utf.lng.Arpitan
import org.angproj.utf.lng.Assamese
import org.angproj.utf.lng.AssyrianNeoAramaic
import org.angproj.utf.lng.Asturian
import org.angproj.utf.lng.AsuTanzania
import org.angproj.utf.lng.Atikamekw
import org.angproj.utf.lng.Atsam
import org.angproj.utf.lng.Avaric
import org.angproj.utf.lng.Avestan
import org.angproj.utf.lng.Awadhi
import org.angproj.utf.lng.Aymara
import org.angproj.utf.lng.Azerbaijani
import org.angproj.utf.lng.Badaga
import org.angproj.utf.lng.Bafia
import org.angproj.utf.lng.Bafut
import org.angproj.utf.lng.Bagheli
import org.angproj.utf.lng.Bakhtiari
import org.angproj.utf.lng.BalantaGanja
import org.angproj.utf.lng.Balinese
import org.angproj.utf.lng.BalkanGagauzTurkish
import org.angproj.utf.lng.Balti
import org.angproj.utf.lng.Baluchi
import org.angproj.utf.lng.Bambara
import org.angproj.utf.lng.Bamun
import org.angproj.utf.lng.Banjar
import org.angproj.utf.lng.Bantawa
import org.angproj.utf.lng.Baoule
import org.angproj.utf.lng.BasaCameroon
import org.angproj.utf.lng.Bashkir
import org.angproj.utf.lng.Basque
import org.angproj.utf.lng.Bassari
import org.angproj.utf.lng.BatakToba
import org.angproj.utf.lng.Bateri
import org.angproj.utf.lng.Bavarian
import org.angproj.utf.lng.Beja
import org.angproj.utf.lng.Belarusian
import org.angproj.utf.lng.BembaZambia
import org.angproj.utf.lng.BenaTanzania
import org.angproj.utf.lng.Bengali
import org.angproj.utf.lng.Betawi
import org.angproj.utf.lng.Bhilali
import org.angproj.utf.lng.Bhili
import org.angproj.utf.lng.Bhojpuri
import org.angproj.utf.lng.Bikol
import org.angproj.utf.lng.Bilin
import org.angproj.utf.lng.Bini
import org.angproj.utf.lng.Bishnupriya
import org.angproj.utf.lng.Bislama
import org.angproj.utf.lng.BodoIndia
import org.angproj.utf.lng.Bomu
import org.angproj.utf.lng.Bosnian
import org.angproj.utf.lng.Brahui
import org.angproj.utf.lng.Braj
import org.angproj.utf.lng.Breton
import org.angproj.utf.lng.Bube
import org.angproj.utf.lng.Buginese
import org.angproj.utf.lng.Buhid
import org.angproj.utf.lng.Bulgarian
import org.angproj.utf.lng.BuluCameroon
import org.angproj.utf.lng.Buriat
import org.angproj.utf.lng.Burmese
import org.angproj.utf.lng.Bushi
import org.angproj.utf.lng.Cacaopera
import org.angproj.utf.lng.Caddo
import org.angproj.utf.lng.CajunFrench
import org.angproj.utf.lng.Capiznon
import org.angproj.utf.lng.Carian
import org.angproj.utf.lng.Catalan
import org.angproj.utf.lng.Cayuga
import org.angproj.utf.lng.CebaaraSenoufo
import org.angproj.utf.lng.Cebuano
import org.angproj.utf.lng.CentralAtlasTamazight
import org.angproj.utf.lng.CentralEasternNigerFulfulde
import org.angproj.utf.lng.CentralHuastecaNahuatl
import org.angproj.utf.lng.CentralKurdish
import org.angproj.utf.lng.CentralMazahua
import org.angproj.utf.lng.CentralOkinawan
import org.angproj.utf.lng.CentralYupik
import org.angproj.utf.lng.Chakma
import org.angproj.utf.lng.Chamorro
import org.angproj.utf.lng.Chechen
import org.angproj.utf.lng.Cherokee
import org.angproj.utf.lng.Cheyenne
import org.angproj.utf.lng.Chhattisgarhi
import org.angproj.utf.lng.Chickasaw
import org.angproj.utf.lng.Chiga
import org.angproj.utf.lng.Chilcotin
import org.angproj.utf.lng.ChimborazoHighlandQuichua
import org.angproj.utf.lng.Chinese
import org.angproj.utf.lng.ChinookJargon
import org.angproj.utf.lng.Chipewyan
import org.angproj.utf.lng.Choctaw
import org.angproj.utf.lng.Chukot
import org.angproj.utf.lng.ChurchSlavic
import org.angproj.utf.lng.Chuukese
import org.angproj.utf.lng.Chuvash
import org.angproj.utf.lng.ClassicalMandaic
import org.angproj.utf.lng.Coptic
import org.angproj.utf.lng.Cornish
import org.angproj.utf.lng.Corsican
import org.angproj.utf.lng.Cree
import org.angproj.utf.lng.Creek
import org.angproj.utf.lng.CrimeanTatar
import org.angproj.utf.lng.Croatian
import org.angproj.utf.lng.Czech
import org.angproj.utf.lng.Dakota
import org.angproj.utf.lng.Dan
import org.angproj.utf.lng.DangauraTharu
import org.angproj.utf.lng.Danish
import org.angproj.utf.lng.Dargwa
import org.angproj.utf.lng.Deccan
import org.angproj.utf.lng.Delaware
import org.angproj.utf.lng.Dhivehi
import org.angproj.utf.lng.Dinka
import org.angproj.utf.lng.DogriMacrolanguage
import org.angproj.utf.lng.Domari
import org.angproj.utf.lng.Dotyali
import org.angproj.utf.lng.Duala
import org.angproj.utf.lng.Dungan
import org.angproj.utf.lng.Dutch
import org.angproj.utf.lng.Dyula
import org.angproj.utf.lng.Dzongkha
import org.angproj.utf.lng.EasternCham
import org.angproj.utf.lng.EasternFrisian
import org.angproj.utf.lng.EasternHuastecaNahuatl
import org.angproj.utf.lng.EasternKayah
import org.angproj.utf.lng.EasternLawa
import org.angproj.utf.lng.EasternMagar
import org.angproj.utf.lng.EasternTamang
import org.angproj.utf.lng.EastFutuna
import org.angproj.utf.lng.Efik
import org.angproj.utf.lng.EgyptianAncient
import org.angproj.utf.lng.EgyptianArabic
import org.angproj.utf.lng.Ekajuk
import org.angproj.utf.lng.Embu
import org.angproj.utf.lng.Emilian
import org.angproj.utf.lng.English
import org.angproj.utf.lng.Erzya
import org.angproj.utf.lng.Esperanto
import org.angproj.utf.lng.Estonian
import org.angproj.utf.lng.Eteocypriot
import org.angproj.utf.lng.Etruscan
import org.angproj.utf.lng.Evenki
import org.angproj.utf.lng.Ewe
import org.angproj.utf.lng.Ewondo
import org.angproj.utf.lng.Extremaduran
import org.angproj.utf.lng.FangEquatorialGuinea
import org.angproj.utf.lng.Farefare
import org.angproj.utf.lng.Faroese
import org.angproj.utf.lng.Fijian
import org.angproj.utf.lng.FijiHindi
import org.angproj.utf.lng.Filipino
import org.angproj.utf.lng.Finnish
import org.angproj.utf.lng.Fon
import org.angproj.utf.lng.French
import org.angproj.utf.lng.Friulian
import org.angproj.utf.lng.Fulah
import org.angproj.utf.lng.Fur
import org.angproj.utf.lng.Ga
import org.angproj.utf.lng.Gagauz
import org.angproj.utf.lng.GalibiCarib
import org.angproj.utf.lng.Galician
import org.angproj.utf.lng.GanChinese
import org.angproj.utf.lng.Ganda
import org.angproj.utf.lng.Garhwali
import org.angproj.utf.lng.Garo
import org.angproj.utf.lng.Gayo
import org.angproj.utf.lng.GbayaCentralAfricanRepublic
import org.angproj.utf.lng.Geez
import org.angproj.utf.lng.Georgian
import org.angproj.utf.lng.German
import org.angproj.utf.lng.GhegAlbanian
import org.angproj.utf.lng.Ghomala
import org.angproj.utf.lng.Gilaki
import org.angproj.utf.lng.Gilbertese
import org.angproj.utf.lng.Gondi
import org.angproj.utf.lng.Gorontalo
import org.angproj.utf.lng.Gothic
import org.angproj.utf.lng.Grebo
import org.angproj.utf.lng.Gronings
import org.angproj.utf.lng.Guajajara
import org.angproj.utf.lng.Guarani
import org.angproj.utf.lng.GuianeseCreoleFrench
import org.angproj.utf.lng.Gujarati
import org.angproj.utf.lng.Gujari
import org.angproj.utf.lng.Gurung
import org.angproj.utf.lng.Gusii
import org.angproj.utf.lng.GwichIn
import org.angproj.utf.lng.Hadothi
import org.angproj.utf.lng.Haida
import org.angproj.utf.lng.Haitian
import org.angproj.utf.lng.HakkaChinese
import org.angproj.utf.lng.Halkomelem
import org.angproj.utf.lng.Hanunoo
import org.angproj.utf.lng.Haryanvi
import org.angproj.utf.lng.Hausa
import org.angproj.utf.lng.Hawaiian
import org.angproj.utf.lng.Hazaragi
import org.angproj.utf.lng.Hebrew
import org.angproj.utf.lng.Herero
import org.angproj.utf.lng.Hiligaynon
import org.angproj.utf.lng.Hindi
import org.angproj.utf.lng.HiriMotu
import org.angproj.utf.lng.Hittite
import org.angproj.utf.lng.Hmong
import org.angproj.utf.lng.HmongNjua
import org.angproj.utf.lng.Ho
import org.angproj.utf.lng.Hopi
import org.angproj.utf.lng.Hungarian
import org.angproj.utf.lng.Hupa
import org.angproj.utf.lng.Iban
import org.angproj.utf.lng.Ibibio
import org.angproj.utf.lng.Icelandic
import org.angproj.utf.lng.Ido
import org.angproj.utf.lng.Ife
import org.angproj.utf.lng.Igbo
import org.angproj.utf.lng.Iloko
import org.angproj.utf.lng.InariSami
import org.angproj.utf.lng.Indonesian
import org.angproj.utf.lng.IndusKohistani
import org.angproj.utf.lng.Ingrian
import org.angproj.utf.lng.Ingush
import org.angproj.utf.lng.Innu
import org.angproj.utf.lng.InterlinguaInternationalAuxiliaryLanguageAssociation
import org.angproj.utf.lng.Interlingue
import org.angproj.utf.lng.Inuinnaqtun
import org.angproj.utf.lng.Inuktitut
import org.angproj.utf.lng.Inupiaq
import org.angproj.utf.lng.Irish
import org.angproj.utf.lng.Italian
import org.angproj.utf.lng.JamaicanCreoleEnglish
import org.angproj.utf.lng.Japanese
import org.angproj.utf.lng.Javanese
import org.angproj.utf.lng.JenaamaBozo
import org.angproj.utf.lng.Jju
import org.angproj.utf.lng.JolaFonyi
import org.angproj.utf.lng.JudeoArabic
import org.angproj.utf.lng.JudeoPersian
import org.angproj.utf.lng.Jumli
import org.angproj.utf.lng.Jutish
import org.angproj.utf.lng.Kabardian
import org.angproj.utf.lng.Kabuverdianu
import org.angproj.utf.lng.Kabyle
import org.angproj.utf.lng.Kachhi
import org.angproj.utf.lng.KachiKoli
import org.angproj.utf.lng.Kachin
import org.angproj.utf.lng.KadazanDusun
import org.angproj.utf.lng.Kaingang
import org.angproj.utf.lng.Kako
import org.angproj.utf.lng.Kalaallisut
import org.angproj.utf.lng.Kalanga
import org.angproj.utf.lng.Kalenjin
import org.angproj.utf.lng.Kalmyk
import org.angproj.utf.lng.KaloFinnishRomani
import org.angproj.utf.lng.KambaKenya
import org.angproj.utf.lng.Kanauji
import org.angproj.utf.lng.Kangri
import org.angproj.utf.lng.Kannada
import org.angproj.utf.lng.Kanuri
import org.angproj.utf.lng.KarachayBalkar
import org.angproj.utf.lng.KaraKalpak
import org.angproj.utf.lng.Karelian
import org.angproj.utf.lng.Kashmiri
import org.angproj.utf.lng.Kashubian
import org.angproj.utf.lng.KathoriyaTharu
import org.angproj.utf.lng.Kawi
import org.angproj.utf.lng.Kazakh
import org.angproj.utf.lng.KelengaxoBozo
import org.angproj.utf.lng.Kenyang
import org.angproj.utf.lng.Kerinci
import org.angproj.utf.lng.Khakas
import org.angproj.utf.lng.Khamti
import org.angproj.utf.lng.Khandesi
import org.angproj.utf.lng.Khanty
import org.angproj.utf.lng.Khasi
import org.angproj.utf.lng.Khmer
import org.angproj.utf.lng.Khmu
import org.angproj.utf.lng.Khoekhoe
import org.angproj.utf.lng.Khowar
import org.angproj.utf.lng.KIche
import org.angproj.utf.lng.Kikuyu
import org.angproj.utf.lng.Kimbundu
import org.angproj.utf.lng.KinarayA
import org.angproj.utf.lng.Kinyarwanda
import org.angproj.utf.lng.Kirghiz
import org.angproj.utf.lng.KirmanjkiIndividualLanguage
import org.angproj.utf.lng.KitaManinkakan
import org.angproj.utf.lng.KochilaTharu
import org.angproj.utf.lng.Kolsch
import org.angproj.utf.lng.KomCameroon
import org.angproj.utf.lng.Komering
import org.angproj.utf.lng.Komi
import org.angproj.utf.lng.KomiPermyak
import org.angproj.utf.lng.Kongo
import org.angproj.utf.lng.KonkaniIndividualLanguage
import org.angproj.utf.lng.KonkaniMacrolanguage
import org.angproj.utf.lng.Korean
import org.angproj.utf.lng.KoroCoteDIvoire
import org.angproj.utf.lng.KoroWachi
import org.angproj.utf.lng.Koryak
import org.angproj.utf.lng.Kosraean
import org.angproj.utf.lng.Kotava
import org.angproj.utf.lng.KoyraboroSenniSonghai
import org.angproj.utf.lng.KoyraChiiniSonghay
import org.angproj.utf.lng.Kpelle
import org.angproj.utf.lng.Krio
import org.angproj.utf.lng.Kuanyama
import org.angproj.utf.lng.Kumaoni
import org.angproj.utf.lng.Kumyk
import org.angproj.utf.lng.Kurdish
import org.angproj.utf.lng.Kurukh
import org.angproj.utf.lng.Kutenai
import org.angproj.utf.lng.Kuvi
import org.angproj.utf.lng.Kuy
import org.angproj.utf.lng.Kwakiutl
import org.angproj.utf.lng.Kwasio
import org.angproj.utf.lng.Ladin
import org.angproj.utf.lng.Ladino
import org.angproj.utf.lng.Lahnda
import org.angproj.utf.lng.Lak
import org.angproj.utf.lng.Laki
import org.angproj.utf.lng.Lakota
import org.angproj.utf.lng.Lamba
import org.angproj.utf.lng.Lambadi
import org.angproj.utf.lng.LampungApi
import org.angproj.utf.lng.LangoUganda
import org.angproj.utf.lng.Lao
import org.angproj.utf.lng.LargeFloweryMiao
import org.angproj.utf.lng.Latgalian
import org.angproj.utf.lng.Latin
import org.angproj.utf.lng.Latvian
import org.angproj.utf.lng.Laz
import org.angproj.utf.lng.Lenca
import org.angproj.utf.lng.Lepcha
import org.angproj.utf.lng.LevantineArabic
import org.angproj.utf.lng.Lezghian
import org.angproj.utf.lng.Ligurian
import org.angproj.utf.lng.Lillooet
import org.angproj.utf.lng.Limbu
import org.angproj.utf.lng.Limburgan
import org.angproj.utf.lng.LinearA
import org.angproj.utf.lng.Lingala
import org.angproj.utf.lng.LinguaFrancaNova
import org.angproj.utf.lng.Lisu
import org.angproj.utf.lng.LiteraryChinese
import org.angproj.utf.lng.Lithuanian
import org.angproj.utf.lng.Liv
import org.angproj.utf.lng.Lojban
import org.angproj.utf.lng.Lombard
import org.angproj.utf.lng.Lomwe
import org.angproj.utf.lng.LowerSilesian
import org.angproj.utf.lng.LowerSorbian
import org.angproj.utf.lng.LowGerman
import org.angproj.utf.lng.Lozi
import org.angproj.utf.lng.Lu
import org.angproj.utf.lng.LubaKatanga
import org.angproj.utf.lng.LubaLulua
import org.angproj.utf.lng.Luiseno
import org.angproj.utf.lng.LuleSami
import org.angproj.utf.lng.Lunda
import org.angproj.utf.lng.LuoKenyaAndTanzania
import org.angproj.utf.lng.Lushai
import org.angproj.utf.lng.Lushootseed
import org.angproj.utf.lng.Luxembourgish
import org.angproj.utf.lng.Luyia
import org.angproj.utf.lng.Lycian
import org.angproj.utf.lng.Lydian
import org.angproj.utf.lng.MaasinaFulfulde
import org.angproj.utf.lng.Macedonian
import org.angproj.utf.lng.MacedoRomanian
import org.angproj.utf.lng.Machame
import org.angproj.utf.lng.Madurese
import org.angproj.utf.lng.Mafa
import org.angproj.utf.lng.Magahi
import org.angproj.utf.lng.Maguindanaon
import org.angproj.utf.lng.Mainfrankisch
import org.angproj.utf.lng.Maithili
import org.angproj.utf.lng.Makasar
import org.angproj.utf.lng.Makhuwa
import org.angproj.utf.lng.MakhuwaMeetto
import org.angproj.utf.lng.Makonde
import org.angproj.utf.lng.Malagasy
import org.angproj.utf.lng.Malayalam
import org.angproj.utf.lng.MalayMacrolanguage
import org.angproj.utf.lng.MalecitePassamaquoddy
import org.angproj.utf.lng.Maltese
import org.angproj.utf.lng.Manchu
import org.angproj.utf.lng.Mandar
import org.angproj.utf.lng.Mandingo
import org.angproj.utf.lng.Mandjak
import org.angproj.utf.lng.ManichaeanMiddlePersian
import org.angproj.utf.lng.Manipuri
import org.angproj.utf.lng.Mankanya
import org.angproj.utf.lng.Mansi
import org.angproj.utf.lng.Manx
import org.angproj.utf.lng.Manyika
import org.angproj.utf.lng.MaoreComorian
import org.angproj.utf.lng.Maori
import org.angproj.utf.lng.Mapudungun
import org.angproj.utf.lng.Marathi
import org.angproj.utf.lng.MariRussia
import org.angproj.utf.lng.Marshallese
import org.angproj.utf.lng.Marwari
import org.angproj.utf.lng.Masaaba
import org.angproj.utf.lng.Masai
import org.angproj.utf.lng.Masalit
import org.angproj.utf.lng.Mazanderani
import org.angproj.utf.lng.Mbere
import org.angproj.utf.lng.Mbunga
import org.angproj.utf.lng.Medumba
import org.angproj.utf.lng.MendeSierraLeone
import org.angproj.utf.lng.Menik
import org.angproj.utf.lng.Mentawai
import org.angproj.utf.lng.Meroitic
import org.angproj.utf.lng.Meru
import org.angproj.utf.lng.Meta
import org.angproj.utf.lng.Mewari
import org.angproj.utf.lng.Mewati
import org.angproj.utf.lng.Michif
import org.angproj.utf.lng.MiddleDutchCa10501350
import org.angproj.utf.lng.MiddleEnglish11001500
import org.angproj.utf.lng.MiddleFrenchCa14001600
import org.angproj.utf.lng.MiddleHighGermanCa10501500
import org.angproj.utf.lng.MiKmaq
import org.angproj.utf.lng.Minangkabau
import org.angproj.utf.lng.Mingrelian
import org.angproj.utf.lng.MinNanChinese
import org.angproj.utf.lng.Mirandese
import org.angproj.utf.lng.Mocheno
import org.angproj.utf.lng.ModernGreek1453
import org.angproj.utf.lng.Mohawk
import org.angproj.utf.lng.Moksha
import org.angproj.utf.lng.Mon
import org.angproj.utf.lng.Mongo
import org.angproj.utf.lng.Mongolian
import org.angproj.utf.lng.MooseCree
import org.angproj.utf.lng.Morisyen
import org.angproj.utf.lng.MoroccanArabic
import org.angproj.utf.lng.Mossi
import org.angproj.utf.lng.Mru
import org.angproj.utf.lng.Munda
import org.angproj.utf.lng.Mundang
import org.angproj.utf.lng.Mundari
import org.angproj.utf.lng.MuslimTat
import org.angproj.utf.lng.MycenaeanGreek
import org.angproj.utf.lng.NajdiArabic
import org.angproj.utf.lng.Nanai
import org.angproj.utf.lng.Naskapi
import org.angproj.utf.lng.Nauru
import org.angproj.utf.lng.Navajo
import org.angproj.utf.lng.Naxi
import org.angproj.utf.lng.Ndau
import org.angproj.utf.lng.Ndonga
import org.angproj.utf.lng.NdzwaniComorian
import org.angproj.utf.lng.Neapolitan
import org.angproj.utf.lng.NegeriSembilanMalay
import org.angproj.utf.lng.Nenets
import org.angproj.utf.lng.NepaliMacrolanguage
import org.angproj.utf.lng.Newari
import org.angproj.utf.lng.Ngaju
import org.angproj.utf.lng.NgazidjaComorian
import org.angproj.utf.lng.Ngiemboon
import org.angproj.utf.lng.Ngomba
import org.angproj.utf.lng.Nhengatu
import org.angproj.utf.lng.Nias
import org.angproj.utf.lng.NigerianFulfulde
import org.angproj.utf.lng.NigerianPidgin
import org.angproj.utf.lng.Nimadi
import org.angproj.utf.lng.Niuean
import org.angproj.utf.lng.NKo
import org.angproj.utf.lng.Nobiin
import org.angproj.utf.lng.Nogai
import org.angproj.utf.lng.Noon
import org.angproj.utf.lng.NortheasternThai
import org.angproj.utf.lng.NorthernEastCree
import org.angproj.utf.lng.NorthernFrisian
import org.angproj.utf.lng.NorthernHindko
import org.angproj.utf.lng.NorthernKhmer
import org.angproj.utf.lng.NorthernLuri
import org.angproj.utf.lng.NorthernSami
import org.angproj.utf.lng.NorthernThai
import org.angproj.utf.lng.NorthNdebele
import org.angproj.utf.lng.NorthSlavey
import org.angproj.utf.lng.Norwegian
import org.angproj.utf.lng.NorwegianBokmal
import org.angproj.utf.lng.NorwegianNynorsk
import org.angproj.utf.lng.Novial
import org.angproj.utf.lng.Nuer
import org.angproj.utf.lng.Nyamwezi
import org.angproj.utf.lng.Nyanja
import org.angproj.utf.lng.Nyankole
import org.angproj.utf.lng.Nyoro
import org.angproj.utf.lng.Nzima
import org.angproj.utf.lng.Obolo
import org.angproj.utf.lng.OccitanPost1500
import org.angproj.utf.lng.OfficialAramaic700300Bce
import org.angproj.utf.lng.Ojibwa
import org.angproj.utf.lng.Okanagan
import org.angproj.utf.lng.OldEnglishCa4501100
import org.angproj.utf.lng.OldFrench842Ca1400
import org.angproj.utf.lng.OldHighGermanCa7501050
import org.angproj.utf.lng.OldIrishTo900
import org.angproj.utf.lng.OldNorse
import org.angproj.utf.lng.OldPersianCa600400BC
import org.angproj.utf.lng.OldProvencalTo1500
import org.angproj.utf.lng.OldTurkish
import org.angproj.utf.lng.OriyaMacrolanguage
import org.angproj.utf.lng.Oromo
import org.angproj.utf.lng.OrphanedScripts
import org.angproj.utf.lng.Osage
import org.angproj.utf.lng.Oscan
import org.angproj.utf.lng.Ossetian
import org.angproj.utf.lng.Pahlavi
import org.angproj.utf.lng.Palauan
import org.angproj.utf.lng.Pali
import org.angproj.utf.lng.Pampanga
import org.angproj.utf.lng.Pangasinan
import org.angproj.utf.lng.Panjabi
import org.angproj.utf.lng.Papiamento
import org.angproj.utf.lng.ParkariKoli
import org.angproj.utf.lng.ParsiDari
import org.angproj.utf.lng.Parthian
import org.angproj.utf.lng.PattaniMalay
import org.angproj.utf.lng.Pedi
import org.angproj.utf.lng.PennsylvaniaGerman
import org.angproj.utf.lng.Persian
import org.angproj.utf.lng.Pfaelzisch
import org.angproj.utf.lng.Phoenician
import org.angproj.utf.lng.Picard
import org.angproj.utf.lng.Piemontese
import org.angproj.utf.lng.Pijin
import org.angproj.utf.lng.Pipil
import org.angproj.utf.lng.PlainsCree
import org.angproj.utf.lng.Plautdietsch
import org.angproj.utf.lng.Pohnpeian
import org.angproj.utf.lng.Pokoot
import org.angproj.utf.lng.Polish
import org.angproj.utf.lng.Pontic
import org.angproj.utf.lng.Portuguese
import org.angproj.utf.lng.Prussian
import org.angproj.utf.lng.Punu
import org.angproj.utf.lng.Pushto
import org.angproj.utf.lng.Quechua
import org.angproj.utf.lng.Rajasthani
import org.angproj.utf.lng.Rajbanshi
import org.angproj.utf.lng.RanaTharu
import org.angproj.utf.lng.Rangi
import org.angproj.utf.lng.Rangpuri
import org.angproj.utf.lng.Rapanui
import org.angproj.utf.lng.Rarotongan
import org.angproj.utf.lng.Rejang
import org.angproj.utf.lng.ReunionCreoleFrench
import org.angproj.utf.lng.RiangIndia
import org.angproj.utf.lng.RinconadaBikol
import org.angproj.utf.lng.Rohingya
import org.angproj.utf.lng.Romagnol
import org.angproj.utf.lng.Romanian
import org.angproj.utf.lng.Romansh
import org.angproj.utf.lng.Romany
import org.angproj.utf.lng.Rombo
import org.angproj.utf.lng.Ronga
import org.angproj.utf.lng.Rotuman
import org.angproj.utf.lng.Roviana
import org.angproj.utf.lng.Rundi
import org.angproj.utf.lng.Russian
import org.angproj.utf.lng.Rusyn
import org.angproj.utf.lng.Rwa
import org.angproj.utf.lng.Sabaean
import org.angproj.utf.lng.Sadri
import org.angproj.utf.lng.Safaliba
import org.angproj.utf.lng.Saho
import org.angproj.utf.lng.Samaritan
import org.angproj.utf.lng.SamaritanAramaic
import org.angproj.utf.lng.Samburu
import org.angproj.utf.lng.Samoan
import org.angproj.utf.lng.Samogitian
import org.angproj.utf.lng.Sandawe
import org.angproj.utf.lng.Sangir
import org.angproj.utf.lng.Sango
import org.angproj.utf.lng.SanguTanzania
import org.angproj.utf.lng.Sanskrit
import org.angproj.utf.lng.Santali
import org.angproj.utf.lng.Saraiki
import org.angproj.utf.lng.Sardinian
import org.angproj.utf.lng.Sasak
import org.angproj.utf.lng.SassareseSardinian
import org.angproj.utf.lng.Saterfriesisch
import org.angproj.utf.lng.Saurashtra
import org.angproj.utf.lng.Scots
import org.angproj.utf.lng.ScottishGaelic
import org.angproj.utf.lng.Sediq
import org.angproj.utf.lng.Seki
import org.angproj.utf.lng.Selayar
import org.angproj.utf.lng.Selkup
import org.angproj.utf.lng.Sena
import org.angproj.utf.lng.Seneca
import org.angproj.utf.lng.Serbian
import org.angproj.utf.lng.Serer
import org.angproj.utf.lng.Seri
import org.angproj.utf.lng.SeselwaCreoleFrench
import org.angproj.utf.lng.SevernOjibwa
import org.angproj.utf.lng.Shambala
import org.angproj.utf.lng.Shan
import org.angproj.utf.lng.Shekhawati
import org.angproj.utf.lng.Sherpa
import org.angproj.utf.lng.Shona
import org.angproj.utf.lng.Shor
import org.angproj.utf.lng.SichuanYi
import org.angproj.utf.lng.Sicilian
import org.angproj.utf.lng.Sidamo
import org.angproj.utf.lng.Siksika
import org.angproj.utf.lng.Silesian
import org.angproj.utf.lng.Sindhi
import org.angproj.utf.lng.Sinhala
import org.angproj.utf.lng.SinteRomani
import org.angproj.utf.lng.Sirmauri
import org.angproj.utf.lng.SkoltSami
import org.angproj.utf.lng.SlaveAthapascan
import org.angproj.utf.lng.Slovak
import org.angproj.utf.lng.Slovenian
import org.angproj.utf.lng.Soga
import org.angproj.utf.lng.Somali
import org.angproj.utf.lng.Soninke
import org.angproj.utf.lng.Sora
import org.angproj.utf.lng.SouthernAltai
import org.angproj.utf.lng.SouthernEastCree
import org.angproj.utf.lng.SouthernHindko
import org.angproj.utf.lng.SouthernKurdish
import org.angproj.utf.lng.SouthernLuri
import org.angproj.utf.lng.SouthernSami
import org.angproj.utf.lng.SouthernSotho
import org.angproj.utf.lng.SouthernThai
import org.angproj.utf.lng.SouthNdebele
import org.angproj.utf.lng.Spanish
import org.angproj.utf.lng.SrananTongo
import org.angproj.utf.lng.StandardMoroccanTamazight
import org.angproj.utf.lng.SudaneseArabic
import org.angproj.utf.lng.Sukuma
import org.angproj.utf.lng.Sundanese
import org.angproj.utf.lng.Susu
import org.angproj.utf.lng.Swabian
import org.angproj.utf.lng.SwahiliMacrolanguage
import org.angproj.utf.lng.SwampyCree
import org.angproj.utf.lng.Swati
import org.angproj.utf.lng.Swedish
import org.angproj.utf.lng.SwissGerman
import org.angproj.utf.lng.Sylheti
import org.angproj.utf.lng.Syriac
import org.angproj.utf.lng.Tabassaran
import org.angproj.utf.lng.Tachelhit
import org.angproj.utf.lng.Tae
import org.angproj.utf.lng.Tagbanwa
import org.angproj.utf.lng.Tahitian
import org.angproj.utf.lng.TaiDam
import org.angproj.utf.lng.TaiNua
import org.angproj.utf.lng.Taita
import org.angproj.utf.lng.Tajik
import org.angproj.utf.lng.Talysh
import org.angproj.utf.lng.Tamashek
import org.angproj.utf.lng.Tamil
import org.angproj.utf.lng.Tarifit
import org.angproj.utf.lng.Tasawaq
import org.angproj.utf.lng.Tatar
import org.angproj.utf.lng.Tausug
import org.angproj.utf.lng.TavringerRomani
import org.angproj.utf.lng.TedimChin
import org.angproj.utf.lng.Telugu
import org.angproj.utf.lng.Tereno
import org.angproj.utf.lng.Teso
import org.angproj.utf.lng.Tetum
import org.angproj.utf.lng.Thai
import org.angproj.utf.lng.Thulung
import org.angproj.utf.lng.Tibetan
import org.angproj.utf.lng.Tigre
import org.angproj.utf.lng.Tigrinya
import org.angproj.utf.lng.Timne
import org.angproj.utf.lng.Tiv
import org.angproj.utf.lng.Tlicho
import org.angproj.utf.lng.Tlingit
import org.angproj.utf.lng.Tokelau
import org.angproj.utf.lng.TokiPona
import org.angproj.utf.lng.TokPisin
import org.angproj.utf.lng.Tolaki
import org.angproj.utf.lng.TomoKanDogon
import org.angproj.utf.lng.TongaNyasa
import org.angproj.utf.lng.TongaTongaIslands
import org.angproj.utf.lng.Tooro
import org.angproj.utf.lng.TornedalenFinnish
import org.angproj.utf.lng.Torwali
import org.angproj.utf.lng.Tsakhur
import org.angproj.utf.lng.Tsakonian
import org.angproj.utf.lng.Tshangla
import org.angproj.utf.lng.Tsimshian
import org.angproj.utf.lng.Tsonga
import org.angproj.utf.lng.Tswana
import org.angproj.utf.lng.Tulu
import org.angproj.utf.lng.Tumbuka
import org.angproj.utf.lng.TunisianArabic
import org.angproj.utf.lng.Turkish
import org.angproj.utf.lng.Turkmen
import org.angproj.utf.lng.Turoyo
import org.angproj.utf.lng.Tuvalu
import org.angproj.utf.lng.Tuvinian
import org.angproj.utf.lng.Tyap
import org.angproj.utf.lng.UabMeto
import org.angproj.utf.lng.Udihe
import org.angproj.utf.lng.Udmurt
import org.angproj.utf.lng.Ugaritic
import org.angproj.utf.lng.Uighur
import org.angproj.utf.lng.Ukrainian
import org.angproj.utf.lng.Ulithian
import org.angproj.utf.lng.Umbrian
import org.angproj.utf.lng.Umbundu
import org.angproj.utf.lng.UpperSorbian
import org.angproj.utf.lng.Urdu
import org.angproj.utf.lng.Uzbek
import org.angproj.utf.lng.Vai
import org.angproj.utf.lng.Venda
import org.angproj.utf.lng.Venetian
import org.angproj.utf.lng.Veps
import org.angproj.utf.lng.Vietnamese
import org.angproj.utf.lng.VirginIslandsCreoleEnglish
import org.angproj.utf.lng.Vlaams
import org.angproj.utf.lng.Volapuk
import org.angproj.utf.lng.Voro
import org.angproj.utf.lng.Votic
import org.angproj.utf.lng.Vunjo
import org.angproj.utf.lng.Waddar
import org.angproj.utf.lng.WadiyaraKoli
import org.angproj.utf.lng.Wagdi
import org.angproj.utf.lng.Wallisian
import org.angproj.utf.lng.Walloon
import org.angproj.utf.lng.Walser
import org.angproj.utf.lng.WarayPhilippines
import org.angproj.utf.lng.Warlpiri
import org.angproj.utf.lng.Washo
import org.angproj.utf.lng.Wayuu
import org.angproj.utf.lng.Welsh
import org.angproj.utf.lng.WesternBalochi
import org.angproj.utf.lng.WesternCham
import org.angproj.utf.lng.WesternFrisian
import org.angproj.utf.lng.WesternHuastecaNahuatl
import org.angproj.utf.lng.WesternKayah
import org.angproj.utf.lng.WesternLawa
import org.angproj.utf.lng.WesternMagar
import org.angproj.utf.lng.WesternMari
import org.angproj.utf.lng.WesternOjibwa
import org.angproj.utf.lng.WesternTamang
import org.angproj.utf.lng.Wolaytta
import org.angproj.utf.lng.Wolof
import org.angproj.utf.lng.WuChinese
import org.angproj.utf.lng.Xaasongaxango
import org.angproj.utf.lng.Xavante
import org.angproj.utf.lng.Xhosa
import org.angproj.utf.lng.XiangChinese
import org.angproj.utf.lng.Yakut
import org.angproj.utf.lng.Yangben
import org.angproj.utf.lng.Yao
import org.angproj.utf.lng.Yapese
import org.angproj.utf.lng.Yemba
import org.angproj.utf.lng.Yiddish
import org.angproj.utf.lng.Yoruba
import org.angproj.utf.lng.Yucateco
import org.angproj.utf.lng.YueChinese
import org.angproj.utf.lng.Zaghawa
import org.angproj.utf.lng.Zapotec
import org.angproj.utf.lng.Zarma
import org.angproj.utf.lng.Zaza
import org.angproj.utf.lng.Zeeuws
import org.angproj.utf.lng.Zenaga
import org.angproj.utf.lng.Zhuang
import org.angproj.utf.lng.ZoroastrianDari
import org.angproj.utf.lng.Zulu
import org.angproj.utf.lng.Zuni
import org.angproj.utf.lng.Undefined

public enum class Language(public val lang: UtfLanguage) {
    ABAZA(Abaza),
    ABKHAZIAN(Abkhazian),
    ABRON(Abron),
    ACHINESE(Achinese),
    ACOLI(Acoli),
    ADANGME(Adangme),
    ADYGHE(Adyghe),
    AFAR(Afar),
    AFRIKAANS(Afrikaans),
    AGHEM(Aghem),
    AINU_JAPAN(AinuJapan),
    AKAN(Akan),
    AKKADIAN(Akkadian),
    AKOOSE(Akoose),
    ALABAMA(Alabama),
    ALBANIAN(Albanian),
    ALEUT(Aleut),
    ALGERIAN_ARABIC(AlgerianArabic),
    AMHARIC(Amharic),
    AMO(Amo),
    ANCIENT_GREEK_TO_1453(AncientGreekTo1453),
    ANCIENT_NORTH_ARABIAN(AncientNorthArabian),
    ANGIKA(Angika),
    ANII(Anii),
    AO_NAGA(AoNaga),
    ARABIC(Arabic),
    ARAGONESE(Aragonese),
    ARAONA(Araona),
    ARAPAHO(Arapaho),
    ARAWAK(Arawak),
    ARMENIAN(Armenian),
    ARPITAN(Arpitan),
    ASSAMESE(Assamese),
    ASSYRIAN_NEO_ARAMAIC(AssyrianNeoAramaic),
    ASTURIAN(Asturian),
    ASU_TANZANIA(AsuTanzania),
    ATIKAMEKW(Atikamekw),
    ATSAM(Atsam),
    AVARIC(Avaric),
    AVESTAN(Avestan),
    AWADHI(Awadhi),
    AYMARA(Aymara),
    AZERBAIJANI(Azerbaijani),
    BADAGA(Badaga),
    BAFIA(Bafia),
    BAFUT(Bafut),
    BAGHELI(Bagheli),
    BAKHTIARI(Bakhtiari),
    BALANTA_GANJA(BalantaGanja),
    BALINESE(Balinese),
    BALKAN_GAGAUZ_TURKISH(BalkanGagauzTurkish),
    BALTI(Balti),
    BALUCHI(Baluchi),
    BAMBARA(Bambara),
    BAMUN(Bamun),
    BANJAR(Banjar),
    BANTAWA(Bantawa),
    BAOULE(Baoule),
    BASA_CAMEROON(BasaCameroon),
    BASHKIR(Bashkir),
    BASQUE(Basque),
    BASSARI(Bassari),
    BATAK_TOBA(BatakToba),
    BATERI(Bateri),
    BAVARIAN(Bavarian),
    BEJA(Beja),
    BELARUSIAN(Belarusian),
    BEMBA_ZAMBIA(BembaZambia),
    BENA_TANZANIA(BenaTanzania),
    BENGALI(Bengali),
    BETAWI(Betawi),
    BHILALI(Bhilali),
    BHILI(Bhili),
    BHOJPURI(Bhojpuri),
    BIKOL(Bikol),
    BILIN(Bilin),
    BINI(Bini),
    BISHNUPRIYA(Bishnupriya),
    BISLAMA(Bislama),
    BODO_INDIA(BodoIndia),
    BOMU(Bomu),
    BOSNIAN(Bosnian),
    BRAHUI(Brahui),
    BRAJ(Braj),
    BRETON(Breton),
    BUBE(Bube),
    BUGINESE(Buginese),
    BUHID(Buhid),
    BULGARIAN(Bulgarian),
    BULU_CAMEROON(BuluCameroon),
    BURIAT(Buriat),
    BURMESE(Burmese),
    BUSHI(Bushi),
    CACAOPERA(Cacaopera),
    CADDO(Caddo),
    CAJUN_FRENCH(CajunFrench),
    CAPIZNON(Capiznon),
    CARIAN(Carian),
    CATALAN(Catalan),
    CAYUGA(Cayuga),
    CEBAARA_SENOUFO(CebaaraSenoufo),
    CEBUANO(Cebuano),
    CENTRAL_ATLAS_TAMAZIGHT(CentralAtlasTamazight),
    CENTRAL_EASTERN_NIGER_FULFULDE(CentralEasternNigerFulfulde),
    CENTRAL_HUASTECA_NAHUATL(CentralHuastecaNahuatl),
    CENTRAL_KURDISH(CentralKurdish),
    CENTRAL_MAZAHUA(CentralMazahua),
    CENTRAL_OKINAWAN(CentralOkinawan),
    CENTRAL_YUPIK(CentralYupik),
    CHAKMA(Chakma),
    CHAMORRO(Chamorro),
    CHECHEN(Chechen),
    CHEROKEE(Cherokee),
    CHEYENNE(Cheyenne),
    CHHATTISGARHI(Chhattisgarhi),
    CHICKASAW(Chickasaw),
    CHIGA(Chiga),
    CHILCOTIN(Chilcotin),
    CHIMBORAZO_HIGHLAND_QUICHUA(ChimborazoHighlandQuichua),
    CHINESE(Chinese),
    CHINOOK_JARGON(ChinookJargon),
    CHIPEWYAN(Chipewyan),
    CHOCTAW(Choctaw),
    CHUKOT(Chukot),
    CHURCH_SLAVIC(ChurchSlavic),
    CHUUKESE(Chuukese),
    CHUVASH(Chuvash),
    CLASSICAL_MANDAIC(ClassicalMandaic),
    COPTIC(Coptic),
    CORNISH(Cornish),
    CORSICAN(Corsican),
    CREE(Cree),
    CREEK(Creek),
    CRIMEAN_TATAR(CrimeanTatar),
    CROATIAN(Croatian),
    CZECH(Czech),
    DAKOTA(Dakota),
    DAN(Dan),
    DANGAURA_THARU(DangauraTharu),
    DANISH(Danish),
    DARGWA(Dargwa),
    DECCAN(Deccan),
    DELAWARE(Delaware),
    DHIVEHI(Dhivehi),
    DINKA(Dinka),
    DOGRI_MACROLANGUAGE(DogriMacrolanguage),
    DOMARI(Domari),
    DOTYALI(Dotyali),
    DUALA(Duala),
    DUNGAN(Dungan),
    DUTCH(Dutch),
    DYULA(Dyula),
    DZONGKHA(Dzongkha),
    EASTERN_CHAM(EasternCham),
    EASTERN_FRISIAN(EasternFrisian),
    EASTERN_HUASTECA_NAHUATL(EasternHuastecaNahuatl),
    EASTERN_KAYAH(EasternKayah),
    EASTERN_LAWA(EasternLawa),
    EASTERN_MAGAR(EasternMagar),
    EASTERN_TAMANG(EasternTamang),
    EAST_FUTUNA(EastFutuna),
    EFIK(Efik),
    EGYPTIAN_ANCIENT(EgyptianAncient),
    EGYPTIAN_ARABIC(EgyptianArabic),
    EKAJUK(Ekajuk),
    EMBU(Embu),
    EMILIAN(Emilian),
    ENGLISH(English),
    ERZYA(Erzya),
    ESPERANTO(Esperanto),
    ESTONIAN(Estonian),
    ETEOCYPRIOT(Eteocypriot),
    ETRUSCAN(Etruscan),
    EVENKI(Evenki),
    EWE(Ewe),
    EWONDO(Ewondo),
    EXTREMADURAN(Extremaduran),
    FANG_EQUATORIAL_GUINEA(FangEquatorialGuinea),
    FAREFARE(Farefare),
    FAROESE(Faroese),
    FIJIAN(Fijian),
    FIJI_HINDI(FijiHindi),
    FILIPINO(Filipino),
    FINNISH(Finnish),
    FON(Fon),
    FRENCH(French),
    FRIULIAN(Friulian),
    FULAH(Fulah),
    FUR(Fur),
    GA(Ga),
    GAGAUZ(Gagauz),
    GALIBI_CARIB(GalibiCarib),
    GALICIAN(Galician),
    GAN_CHINESE(GanChinese),
    GANDA(Ganda),
    GARHWALI(Garhwali),
    GARO(Garo),
    GAYO(Gayo),
    GBAYA_CENTRAL_AFRICAN_REPUBLIC(GbayaCentralAfricanRepublic),
    GEEZ(Geez),
    GEORGIAN(Georgian),
    GERMAN(German),
    GHEG_ALBANIAN(GhegAlbanian),
    GHOMALA(Ghomala),
    GILAKI(Gilaki),
    GILBERTESE(Gilbertese),
    GONDI(Gondi),
    GORONTALO(Gorontalo),
    GOTHIC(Gothic),
    GREBO(Grebo),
    GRONINGS(Gronings),
    GUAJAJARA(Guajajara),
    GUARANI(Guarani),
    GUIANESE_CREOLE_FRENCH(GuianeseCreoleFrench),
    GUJARATI(Gujarati),
    GUJARI(Gujari),
    GURUNG(Gurung),
    GUSII(Gusii),
    GWICHIN(GwichIn),
    HADOTHI(Hadothi),
    HAIDA(Haida),
    HAITIAN(Haitian),
    HAKKA_CHINESE(HakkaChinese),
    HALKOMELEM(Halkomelem),
    HANUNOO(Hanunoo),
    HARYANVI(Haryanvi),
    HAUSA(Hausa),
    HAWAIIAN(Hawaiian),
    HAZARAGI(Hazaragi),
    HEBREW(Hebrew),
    HERERO(Herero),
    HILIGAYNON(Hiligaynon),
    HINDI(Hindi),
    HIRI_MOTU(HiriMotu),
    HITTITE(Hittite),
    HMONG(Hmong),
    HMONG_NJUA(HmongNjua),
    HO(Ho),
    HOPI(Hopi),
    HUNGARIAN(Hungarian),
    HUPA(Hupa),
    IBAN(Iban),
    IBIBIO(Ibibio),
    ICELANDIC(Icelandic),
    IDO(Ido),
    IFE(Ife),
    IGBO(Igbo),
    ILOKO(Iloko),
    INARI_SAMI(InariSami),
    INDONESIAN(Indonesian),
    INDUS_KOHISTANI(IndusKohistani),
    INGRIAN(Ingrian),
    INGUSH(Ingush),
    INNU(Innu),
    INTERLINGUA_INTERNATIONAL_AUXILIARY_LANGUAGE_ASSOCIATION(InterlinguaInternationalAuxiliaryLanguageAssociation),
    INTERLINGUE(Interlingue),
    INUINNAQTUN(Inuinnaqtun),
    INUKTITUT(Inuktitut),
    INUPIAQ(Inupiaq),
    IRISH(Irish),
    ITALIAN(Italian),
    JAMAICAN_CREOLE_ENGLISH(JamaicanCreoleEnglish),
    JAPANESE(Japanese),
    JAVANESE(Javanese),
    JENAAMA_BOZO(JenaamaBozo),
    JJU(Jju),
    JOLA_FONYI(JolaFonyi),
    JUDEO_ARABIC(JudeoArabic),
    JUDEO_PERSIAN(JudeoPersian),
    JUMLI(Jumli),
    JUTISH(Jutish),
    KABARDIAN(Kabardian),
    KABUVERDIANU(Kabuverdianu),
    KABYLE(Kabyle),
    KACHHI(Kachhi),
    KACHI_KOLI(KachiKoli),
    KACHIN(Kachin),
    KADAZAN_DUSUN(KadazanDusun),
    KAINGANG(Kaingang),
    KAKO(Kako),
    KALAALLISUT(Kalaallisut),
    KALANGA(Kalanga),
    KALENJIN(Kalenjin),
    KALMYK(Kalmyk),
    KALO_FINNISH_ROMANI(KaloFinnishRomani),
    KAMBA_KENYA(KambaKenya),
    KANAUJI(Kanauji),
    KANGRI(Kangri),
    KANNADA(Kannada),
    KANURI(Kanuri),
    KARACHAY_BALKAR(KarachayBalkar),
    KARA_KALPAK(KaraKalpak),
    KARELIAN(Karelian),
    KASHMIRI(Kashmiri),
    KASHUBIAN(Kashubian),
    KATHORIYA_THARU(KathoriyaTharu),
    KAWI(Kawi),
    KAZAKH(Kazakh),
    KELENGAXO_BOZO(KelengaxoBozo),
    KENYANG(Kenyang),
    KERINCI(Kerinci),
    KHAKAS(Khakas),
    KHAMTI(Khamti),
    KHANDESI(Khandesi),
    KHANTY(Khanty),
    KHASI(Khasi),
    KHMER(Khmer),
    KHMU(Khmu),
    KHOEKHOE(Khoekhoe),
    KHOWAR(Khowar),
    KICHE(KIche),
    KIKUYU(Kikuyu),
    KIMBUNDU(Kimbundu),
    KINARAY_A(KinarayA),
    KINYARWANDA(Kinyarwanda),
    KIRGHIZ(Kirghiz),
    KIRMANJKI_INDIVIDUAL_LANGUAGE(KirmanjkiIndividualLanguage),
    KITA_MANINKAKAN(KitaManinkakan),
    KOCHILA_THARU(KochilaTharu),
    KOLSCH(Kolsch),
    KOM_CAMEROON(KomCameroon),
    KOMERING(Komering),
    KOMI(Komi),
    KOMI_PERMYAK(KomiPermyak),
    KONGO(Kongo),
    KONKANI_INDIVIDUAL_LANGUAGE(KonkaniIndividualLanguage),
    KONKANI_MACROLANGUAGE(KonkaniMacrolanguage),
    KOREAN(Korean),
    KORO_COTE_DIVOIRE(KoroCoteDIvoire),
    KORO_WACHI(KoroWachi),
    KORYAK(Koryak),
    KOSRAEAN(Kosraean),
    KOTAVA(Kotava),
    KOYRABORO_SENNI_SONGHAI(KoyraboroSenniSonghai),
    KOYRA_CHIINI_SONGHAY(KoyraChiiniSonghay),
    KPELLE(Kpelle),
    KRIO(Krio),
    KUANYAMA(Kuanyama),
    KUMAONI(Kumaoni),
    KUMYK(Kumyk),
    KURDISH(Kurdish),
    KURUKH(Kurukh),
    KUTENAI(Kutenai),
    KUVI(Kuvi),
    KUY(Kuy),
    KWAKIUTL(Kwakiutl),
    KWASIO(Kwasio),
    LADIN(Ladin),
    LADINO(Ladino),
    LAHNDA(Lahnda),
    LAK(Lak),
    LAKI(Laki),
    LAKOTA(Lakota),
    LAMBA(Lamba),
    LAMBADI(Lambadi),
    LAMPUNG_API(LampungApi),
    LANGO_UGANDA(LangoUganda),
    LAO(Lao),
    LARGE_FLOWERY_MIAO(LargeFloweryMiao),
    LATGALIAN(Latgalian),
    LATIN(Latin),
    LATVIAN(Latvian),
    LAZ(Laz),
    LENCA(Lenca),
    LEPCHA(Lepcha),
    LEVANTINE_ARABIC(LevantineArabic),
    LEZGHIAN(Lezghian),
    LIGURIAN(Ligurian),
    LILLOOET(Lillooet),
    LIMBU(Limbu),
    LIMBURGAN(Limburgan),
    LINEAR_A(LinearA),
    LINGALA(Lingala),
    LINGUA_FRANCA_NOVA(LinguaFrancaNova),
    LISU(Lisu),
    LITERARY_CHINESE(LiteraryChinese),
    LITHUANIAN(Lithuanian),
    LIV(Liv),
    LOJBAN(Lojban),
    LOMBARD(Lombard),
    LOMWE(Lomwe),
    LOWER_SILESIAN(LowerSilesian),
    LOWER_SORBIAN(LowerSorbian),
    LOW_GERMAN(LowGerman),
    LOZI(Lozi),
    LU(Lu),
    LUBA_KATANGA(LubaKatanga),
    LUBA_LULUA(LubaLulua),
    LUISENO(Luiseno),
    LULE_SAMI(LuleSami),
    LUNDA(Lunda),
    LUO_KENYA_AND_TANZANIA(LuoKenyaAndTanzania),
    LUSHAI(Lushai),
    LUSHOOTSEED(Lushootseed),
    LUXEMBOURGISH(Luxembourgish),
    LUYIA(Luyia),
    LYCIAN(Lycian),
    LYDIAN(Lydian),
    MAASINA_FULFULDE(MaasinaFulfulde),
    MACEDONIAN(Macedonian),
    MACEDO_ROMANIAN(MacedoRomanian),
    MACHAME(Machame),
    MADURESE(Madurese),
    MAFA(Mafa),
    MAGAHI(Magahi),
    MAGUINDANAON(Maguindanaon),
    MAINFRANKISCH(Mainfrankisch),
    MAITHILI(Maithili),
    MAKASAR(Makasar),
    MAKHUWA(Makhuwa),
    MAKHUWA_MEETTO(MakhuwaMeetto),
    MAKONDE(Makonde),
    MALAGASY(Malagasy),
    MALAYALAM(Malayalam),
    MALAY_MACROLANGUAGE(MalayMacrolanguage),
    MALECITE_PASSAMAQUODDY(MalecitePassamaquoddy),
    MALTESE(Maltese),
    MANCHU(Manchu),
    MANDAR(Mandar),
    MANDINGO(Mandingo),
    MANDJAK(Mandjak),
    MANICHAEAN_MIDDLE_PERSIAN(ManichaeanMiddlePersian),
    MANIPURI(Manipuri),
    MANKANYA(Mankanya),
    MANSI(Mansi),
    MANX(Manx),
    MANYIKA(Manyika),
    MAORE_COMORIAN(MaoreComorian),
    MAORI(Maori),
    MAPUDUNGUN(Mapudungun),
    MARATHI(Marathi),
    MARI_RUSSIA(MariRussia),
    MARSHALLESE(Marshallese),
    MARWARI(Marwari),
    MASAABA(Masaaba),
    MASAI(Masai),
    MASALIT(Masalit),
    MAZANDERANI(Mazanderani),
    MBERE(Mbere),
    MBUNGA(Mbunga),
    MEDUMBA(Medumba),
    MENDE_SIERRA_LEONE(MendeSierraLeone),
    MENIK(Menik),
    MENTAWAI(Mentawai),
    MEROITIC(Meroitic),
    MERU(Meru),
    META(Meta),
    MEWARI(Mewari),
    MEWATI(Mewati),
    MICHIF(Michif),
    MIDDLE_DUTCH_CA_1050_1350(MiddleDutchCa10501350),
    MIDDLE_ENGLISH_1100_1500(MiddleEnglish11001500),
    MIDDLE_FRENCH_CA_1400_1600(MiddleFrenchCa14001600),
    MIDDLE_HIGH_GERMAN_CA_1050_1500(MiddleHighGermanCa10501500),
    MIKMAQ(MiKmaq),
    MINANGKABAU(Minangkabau),
    MINGRELIAN(Mingrelian),
    MIN_NAN_CHINESE(MinNanChinese),
    MIRANDESE(Mirandese),
    MOCHENO(Mocheno),
    MODERN_GREEK_1453_(ModernGreek1453),
    MOHAWK(Mohawk),
    MOKSHA(Moksha),
    MON(Mon),
    MONGO(Mongo),
    MONGOLIAN(Mongolian),
    MOOSE_CREE(MooseCree),
    MORISYEN(Morisyen),
    MOROCCAN_ARABIC(MoroccanArabic),
    MOSSI(Mossi),
    MRU(Mru),
    MUNDA(Munda),
    MUNDANG(Mundang),
    MUNDARI(Mundari),
    MUSLIM_TAT(MuslimTat),
    MYCENAEAN_GREEK(MycenaeanGreek),
    NAJDI_ARABIC(NajdiArabic),
    NANAI(Nanai),
    NASKAPI(Naskapi),
    NAURU(Nauru),
    NAVAJO(Navajo),
    NAXI(Naxi),
    NDAU(Ndau),
    NDONGA(Ndonga),
    NDZWANI_COMORIAN(NdzwaniComorian),
    NEAPOLITAN(Neapolitan),
    NEGERI_SEMBILAN_MALAY(NegeriSembilanMalay),
    NENETS(Nenets),
    NEPALI_MACROLANGUAGE(NepaliMacrolanguage),
    NEWARI(Newari),
    NGAJU(Ngaju),
    NGAZIDJA_COMORIAN(NgazidjaComorian),
    NGIEMBOON(Ngiemboon),
    NGOMBA(Ngomba),
    NHENGATU(Nhengatu),
    NIAS(Nias),
    NIGERIAN_FULFULDE(NigerianFulfulde),
    NIGERIAN_PIDGIN(NigerianPidgin),
    NIMADI(Nimadi),
    NIUEAN(Niuean),
    NKO(NKo),
    NOBIIN(Nobiin),
    NOGAI(Nogai),
    NOON(Noon),
    NORTHEASTERN_THAI(NortheasternThai),
    NORTHERN_EAST_CREE(NorthernEastCree),
    NORTHERN_FRISIAN(NorthernFrisian),
    NORTHERN_HINDKO(NorthernHindko),
    NORTHERN_KHMER(NorthernKhmer),
    NORTHERN_LURI(NorthernLuri),
    NORTHERN_SAMI(NorthernSami),
    NORTHERN_THAI(NorthernThai),
    NORTH_NDEBELE(NorthNdebele),
    NORTH_SLAVEY(NorthSlavey),
    NORWEGIAN(Norwegian),
    NORWEGIAN_BOKMAL(NorwegianBokmal),
    NORWEGIAN_NYNORSK(NorwegianNynorsk),
    NOVIAL(Novial),
    NUER(Nuer),
    NYAMWEZI(Nyamwezi),
    NYANJA(Nyanja),
    NYANKOLE(Nyankole),
    NYORO(Nyoro),
    NZIMA(Nzima),
    OBOLO(Obolo),
    OCCITAN_POST_1500(OccitanPost1500),
    OFFICIAL_ARAMAIC_700_300_BCE(OfficialAramaic700300Bce),
    OJIBWA(Ojibwa),
    OKANAGAN(Okanagan),
    OLD_ENGLISH_CA_450_1100(OldEnglishCa4501100),
    OLD_FRENCH_842_CA_1400(OldFrench842Ca1400),
    OLD_HIGH_GERMAN_CA_750_1050(OldHighGermanCa7501050),
    OLD_IRISH_TO_900(OldIrishTo900),
    OLD_NORSE(OldNorse),
    OLD_PERSIAN_CA_600_400_BC(OldPersianCa600400BC),
    OLD_PROVENCAL_TO_1500(OldProvencalTo1500),
    OLD_TURKISH(OldTurkish),
    ORIYA_MACROLANGUAGE(OriyaMacrolanguage),
    OROMO(Oromo),
    OSAGE(Osage),
    OSCAN(Oscan),
    OSSETIAN(Ossetian),
    PAHLAVI(Pahlavi),
    PALAUAN(Palauan),
    PALI(Pali),
    PAMPANGA(Pampanga),
    PANGASINAN(Pangasinan),
    PANJABI(Panjabi),
    PAPIAMENTO(Papiamento),
    PARKARI_KOLI(ParkariKoli),
    PARSI_DARI(ParsiDari),
    PARTHIAN(Parthian),
    PATTANI_MALAY(PattaniMalay),
    PEDI(Pedi),
    PENNSYLVANIA_GERMAN(PennsylvaniaGerman),
    PERSIAN(Persian),
    PFAELZISCH(Pfaelzisch),
    PHOENICIAN(Phoenician),
    PICARD(Picard),
    PIEMONTESE(Piemontese),
    PIJIN(Pijin),
    PIPIL(Pipil),
    PLAINS_CREE(PlainsCree),
    PLAUTDIETSCH(Plautdietsch),
    POHNPEIAN(Pohnpeian),
    POKOOT(Pokoot),
    POLISH(Polish),
    PONTIC(Pontic),
    PORTUGUESE(Portuguese),
    PRUSSIAN(Prussian),
    PUNU(Punu),
    PUSHTO(Pushto),
    QUECHUA(Quechua),
    RAJASTHANI(Rajasthani),
    RAJBANSHI(Rajbanshi),
    RANA_THARU(RanaTharu),
    RANGI(Rangi),
    RANGPURI(Rangpuri),
    RAPANUI(Rapanui),
    RAROTONGAN(Rarotongan),
    REJANG(Rejang),
    REUNION_CREOLE_FRENCH(ReunionCreoleFrench),
    RIANG_INDIA(RiangIndia),
    RINCONADA_BIKOL(RinconadaBikol),
    ROHINGYA(Rohingya),
    ROMAGNOL(Romagnol),
    ROMANIAN(Romanian),
    ROMANSH(Romansh),
    ROMANY(Romany),
    ROMBO(Rombo),
    RONGA(Ronga),
    ROTUMAN(Rotuman),
    ROVIANA(Roviana),
    RUNDI(Rundi),
    RUSSIAN(Russian),
    RUSYN(Rusyn),
    RWA(Rwa),
    SABAEAN(Sabaean),
    SADRI(Sadri),
    SAFALIBA(Safaliba),
    SAHO(Saho),
    SAMARITAN(Samaritan),
    SAMARITAN_ARAMAIC(SamaritanAramaic),
    SAMBURU(Samburu),
    SAMOAN(Samoan),
    SAMOGITIAN(Samogitian),
    SANDAWE(Sandawe),
    SANGIR(Sangir),
    SANGO(Sango),
    SANGU_TANZANIA(SanguTanzania),
    SANSKRIT(Sanskrit),
    SANTALI(Santali),
    SARAIKI(Saraiki),
    SARDINIAN(Sardinian),
    SASAK(Sasak),
    SASSARESE_SARDINIAN(SassareseSardinian),
    SATERFRIESISCH(Saterfriesisch),
    SAURASHTRA(Saurashtra),
    SCOTS(Scots),
    SCOTTISH_GAELIC(ScottishGaelic),
    SEDIQ(Sediq),
    SEKI(Seki),
    SELAYAR(Selayar),
    SELKUP(Selkup),
    SENA(Sena),
    SENECA(Seneca),
    SERBIAN(Serbian),
    SERER(Serer),
    SERI(Seri),
    SESELWA_CREOLE_FRENCH(SeselwaCreoleFrench),
    SEVERN_OJIBWA(SevernOjibwa),
    SHAMBALA(Shambala),
    SHAN(Shan),
    SHEKHAWATI(Shekhawati),
    SHERPA(Sherpa),
    SHONA(Shona),
    SHOR(Shor),
    SICHUAN_YI(SichuanYi),
    SICILIAN(Sicilian),
    SIDAMO(Sidamo),
    SIKSIKA(Siksika),
    SILESIAN(Silesian),
    SINDHI(Sindhi),
    SINHALA(Sinhala),
    SINTE_ROMANI(SinteRomani),
    SIRMAURI(Sirmauri),
    SKOLT_SAMI(SkoltSami),
    SLAVE_ATHAPASCAN(SlaveAthapascan),
    SLOVAK(Slovak),
    SLOVENIAN(Slovenian),
    SOGA(Soga),
    SOMALI(Somali),
    SONINKE(Soninke),
    SORA(Sora),
    SOUTHERN_ALTAI(SouthernAltai),
    SOUTHERN_EAST_CREE(SouthernEastCree),
    SOUTHERN_HINDKO(SouthernHindko),
    SOUTHERN_KURDISH(SouthernKurdish),
    SOUTHERN_LURI(SouthernLuri),
    SOUTHERN_SAMI(SouthernSami),
    SOUTHERN_SOTHO(SouthernSotho),
    SOUTHERN_THAI(SouthernThai),
    SOUTH_NDEBELE(SouthNdebele),
    SPANISH(Spanish),
    SRANAN_TONGO(SrananTongo),
    STANDARD_MOROCCAN_TAMAZIGHT(StandardMoroccanTamazight),
    SUDANESE_ARABIC(SudaneseArabic),
    SUKUMA(Sukuma),
    SUNDANESE(Sundanese),
    SUSU(Susu),
    SWABIAN(Swabian),
    SWAHILI_MACROLANGUAGE(SwahiliMacrolanguage),
    SWAMPY_CREE(SwampyCree),
    SWATI(Swati),
    SWEDISH(Swedish),
    SWISS_GERMAN(SwissGerman),
    SYLHETI(Sylheti),
    SYRIAC(Syriac),
    TABASSARAN(Tabassaran),
    TACHELHIT(Tachelhit),
    TAE(Tae),
    TAGBANWA(Tagbanwa),
    TAHITIAN(Tahitian),
    TAI_DAM(TaiDam),
    TAI_NUA(TaiNua),
    TAITA(Taita),
    TAJIK(Tajik),
    TALYSH(Talysh),
    TAMASHEK(Tamashek),
    TAMIL(Tamil),
    TARIFIT(Tarifit),
    TASAWAQ(Tasawaq),
    TATAR(Tatar),
    TAUSUG(Tausug),
    TAVRINGER_ROMANI(TavringerRomani),
    TEDIM_CHIN(TedimChin),
    TELUGU(Telugu),
    TERENO(Tereno),
    TESO(Teso),
    TETUM(Tetum),
    THAI(Thai),
    THULUNG(Thulung),
    TIBETAN(Tibetan),
    TIGRE(Tigre),
    TIGRINYA(Tigrinya),
    TIMNE(Timne),
    TIV(Tiv),
    TLICHO(Tlicho),
    TLINGIT(Tlingit),
    TOKELAU(Tokelau),
    TOKI_PONA(TokiPona),
    TOK_PISIN(TokPisin),
    TOLAKI(Tolaki),
    TOMO_KAN_DOGON(TomoKanDogon),
    TONGA_NYASA(TongaNyasa),
    TONGA_TONGA_ISLANDS(TongaTongaIslands),
    TOORO(Tooro),
    TORNEDALEN_FINNISH(TornedalenFinnish),
    TORWALI(Torwali),
    TSAKHUR(Tsakhur),
    TSAKONIAN(Tsakonian),
    TSHANGLA(Tshangla),
    TSIMSHIAN(Tsimshian),
    TSONGA(Tsonga),
    TSWANA(Tswana),
    TULU(Tulu),
    TUMBUKA(Tumbuka),
    TUNISIAN_ARABIC(TunisianArabic),
    TURKISH(Turkish),
    TURKMEN(Turkmen),
    TUROYO(Turoyo),
    TUVALU(Tuvalu),
    TUVINIAN(Tuvinian),
    TYAP(Tyap),
    UAB_METO(UabMeto),
    UDIHE(Udihe),
    UDMURT(Udmurt),
    UGARITIC(Ugaritic),
    UIGHUR(Uighur),
    UKRAINIAN(Ukrainian),
    ULITHIAN(Ulithian),
    UMBRIAN(Umbrian),
    UMBUNDU(Umbundu),
    UPPER_SORBIAN(UpperSorbian),
    URDU(Urdu),
    UZBEK(Uzbek),
    VAI(Vai),
    VENDA(Venda),
    VENETIAN(Venetian),
    VEPS(Veps),
    VIETNAMESE(Vietnamese),
    VIRGIN_ISLANDS_CREOLE_ENGLISH(VirginIslandsCreoleEnglish),
    VLAAMS(Vlaams),
    VOLAPUK(Volapuk),
    VORO(Voro),
    VOTIC(Votic),
    VUNJO(Vunjo),
    WADDAR(Waddar),
    WADIYARA_KOLI(WadiyaraKoli),
    WAGDI(Wagdi),
    WALLISIAN(Wallisian),
    WALLOON(Walloon),
    WALSER(Walser),
    WARAY_PHILIPPINES(WarayPhilippines),
    WARLPIRI(Warlpiri),
    WASHO(Washo),
    WAYUU(Wayuu),
    WELSH(Welsh),
    WESTERN_BALOCHI(WesternBalochi),
    WESTERN_CHAM(WesternCham),
    WESTERN_FRISIAN(WesternFrisian),
    WESTERN_HUASTECA_NAHUATL(WesternHuastecaNahuatl),
    WESTERN_KAYAH(WesternKayah),
    WESTERN_LAWA(WesternLawa),
    WESTERN_MAGAR(WesternMagar),
    WESTERN_MARI(WesternMari),
    WESTERN_OJIBWA(WesternOjibwa),
    WESTERN_TAMANG(WesternTamang),
    WOLAYTTA(Wolaytta),
    WOLOF(Wolof),
    WU_CHINESE(WuChinese),
    XAASONGAXANGO(Xaasongaxango),
    XAVANTE(Xavante),
    XHOSA(Xhosa),
    XIANG_CHINESE(XiangChinese),
    YAKUT(Yakut),
    YANGBEN(Yangben),
    YAO(Yao),
    YAPESE(Yapese),
    YEMBA(Yemba),
    YIDDISH(Yiddish),
    YORUBA(Yoruba),
    YUCATECO(Yucateco),
    YUE_CHINESE(YueChinese),
    ZAGHAWA(Zaghawa),
    ZAPOTEC(Zapotec),
    ZARMA(Zarma),
    ZAZA(Zaza),
    ZEEUWS(Zeeuws),
    ZENAGA(Zenaga),
    ZHUANG(Zhuang),
    ZOROASTRIAN_DARI(ZoroastrianDari),
    ZULU(Zulu),
    ZUNI(Zuni),
    OTHERS(OrphanedScripts),
    UNKNOWN(Undefined);
}
