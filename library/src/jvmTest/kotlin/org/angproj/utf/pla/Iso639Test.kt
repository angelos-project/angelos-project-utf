package org.angproj.utf.pla

import org.angproj.utf.FileDownloader
import org.angproj.utf.helper.BlockRangeParser
import org.angproj.utf.helper.Iso639Parser
import org.angproj.utf.helper.ScriptCodeParser
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.test.Test
import kotlin.test.assertEquals

class Iso639Test {

    fun resourceFolder(file: String = ""): Path = Paths.get("src/jvmTest/resources/", file).toAbsolutePath()

    @Test
    fun testScriptEnum() {
        if(!resourceFolder("is-639-3.tab").exists()) {
            FileDownloader.downloadUnicodeIso6393File(resourceFolder())
        }

        val parsing = Iso639Parser().allData
        val sortedData = parsing.sortedBy { it.part1 }
        sortedData.forEach { data ->
            //val script = Script.valueOf(data.name.constant)

            //assertEquals(script.abbr, data.script)
            //assertEquals(script.canonical, data.pva)
            println(data)
        }
    }
}