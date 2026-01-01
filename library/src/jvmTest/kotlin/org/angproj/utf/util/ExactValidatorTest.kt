package org.angproj.utf.util

import org.angproj.utf.FileDownloader

import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.test.Test

class ExactValidatorTest {

    fun resourceFolder(file: String = ""): Path = Paths.get("src/jvmTest/resources/", file).toAbsolutePath()

    @Test
    fun testGeneralCategory() {
        if(!resourceFolder("DerivedGeneralCategory.txt").exists()) {
            FileDownloader.downloadUnicodeDerivedGeneralCategoryFile(resourceFolder())
        }

        /*val parsing = PropertyAliasParser.parseGeneralCategory().allData
        val sortedData = parsing.sortedBy { it.first.constant }
        sortedData.forEach { data ->
            val gc = GeneralCategory.entries.first { it.canonical == data.first.canonical }

            assertEquals(gc.canonical, data.first.canonical)
            assertEquals(gc.abbr, data.second)
        }*/
    }
}