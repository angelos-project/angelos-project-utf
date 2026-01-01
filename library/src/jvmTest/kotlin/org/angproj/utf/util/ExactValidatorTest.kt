package org.angproj.utf.util

import org.angproj.utf.AbstractUnicodeAware
import org.angproj.utf.FileDownloader
import org.angproj.utf.Unicode
import org.angproj.utf.helper.DerivedGeneralCategoryParser

import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.test.Test
import kotlin.test.assertEquals

class ExactValidatorTest : AbstractUnicodeAware() {

    fun resourceFolder(file: String = ""): Path = Paths.get("src/jvmTest/resources/", file).toAbsolutePath()

    @Test
    fun testGeneralCategory() {
        if(!resourceFolder("DerivedGeneralCategory.txt").exists()) {
            FileDownloader.downloadUnicodeDerivedGeneralCategoryFile(resourceFolder())
        }

        val parsing = DerivedGeneralCategoryParser.getUnassignedCategories()
        val validator = ExactValidator()
        (Unicode.UTF_FIRST.cp..Unicode.UTF_LAST.cp).forEach { codePoint ->
            if(isUtf8<Unit>(codePoint))
                assertEquals(validator.isValid(codePoint), !parsing.isUnassigned(codePoint))
        }
    }
}