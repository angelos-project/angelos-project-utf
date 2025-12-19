package org.angproj.utf.pla

import org.angproj.utf.FileDownloader
import org.angproj.utf.helper.BlockRangeParser
import kotlin.test.Test
import kotlin.test.assertEquals

class BlockTest {

    @Test
    fun testBlockEnum() {
        //FileDownloader.downloadUnicodeBlocksFile()

        val parsing = BlockRangeParser().allData
        val sortedData = parsing.sortedBy { it.searchName.canonical }
        sortedData.forEach { data ->
            val block = Block.valueOf(data.searchName.constant)

            assertEquals(block.title, data.searchName.canonical)
            assertEquals(block.canonical, data.searchName.klazz)
            assertEquals(block.abbr, data.searchName.klazz)
            assertEquals(block.range.first, data.unicodeBounds.first)
            assertEquals(block.range.last, data.unicodeBounds.second)
        }
    }
}