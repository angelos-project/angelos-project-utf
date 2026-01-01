package org.angproj.utf.pla

import org.angproj.utf.FileDownloader
import org.angproj.utf.helper.PropertyAliasParser
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PLATest {

    fun resourceFolder(file: String = ""): Path = Paths.get("src/jvmTest/resources/", file).toAbsolutePath()

    @Test
    fun testGeneralCategory() {
        if(!resourceFolder("PropertyValueAliases.txt").exists()) {
            FileDownloader.downloadUnicodePLAFile(resourceFolder())
        }

        val parsing = PropertyAliasParser.parseGeneralCategory().allData
        val sortedData = parsing.sortedBy { it.first.constant }
        sortedData.forEach { data ->
            val gc = GeneralCategory.entries.first { it.canonical == data.first.canonical }

            assertEquals(gc.canonical, data.first.canonical)
            assertEquals(gc.abbr, data.second)
        }

        sortedData.forEach { data ->
            val gc = GeneralCategory.entries.first { it.canonical == data.first.canonical }
            when(gc.abbr[0]) {
                'L' -> assertTrue{ gc.isLetter() }
                'M' -> assertTrue{ gc.isMark() }
                'N' -> assertTrue{ gc.isNumber() }
                'P' -> assertTrue{ gc.isPunctuation() }
                'S' -> assertTrue{ gc.isSymbol() }
                'Z' -> assertTrue{ gc.isSeparator() }
                'C' -> assertTrue{ gc.isOther() }
                else -> throw IllegalArgumentException("Unknown general category abbreviation: ${gc.abbr}")
            }

            when(gc.abbr[0]) {
                'L' -> assertFalse{ gc.isOther() }
                'M' -> assertFalse{ gc.isLetter() }
                'N' -> assertFalse{ gc.isMark() }
                'P' -> assertFalse{ gc.isNumber() }
                'S' -> assertFalse{ gc.isPunctuation() }
                'Z' -> assertFalse{ gc.isSymbol() }
                'C' -> assertFalse{ gc.isSeparator() }
                else -> throw IllegalArgumentException("Unknown general category abbreviation: ${gc.abbr}")
            }
        }

        sortedData.forEach { data ->
            val gc = GeneralCategory.entries.first { it.canonical == data.first.canonical }
            val fromValue = GeneralCategory.byAbbr(data.second)
            assertEquals(gc, fromValue)
        }
    }
}