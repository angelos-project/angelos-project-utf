package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class AsciiTest {
    @Test
    fun testAscii() {
        (0 until 128).forEach { i ->
            val ascii = Ascii.entries.findLast { it.toInt() == i }
            assertNotNull(ascii)
            assertEquals(ascii.toCodePoint(), i.toCodePoint())
        }
    }

    @Test
    fun testCtrlAndPrintable() {
        var ctrlCount = 0
        var prntCount = 0
        (0 until 128).forEach { i ->
            if(Ascii.isCtrl(i)) { ctrlCount++ }
            if(Ascii.isPrintable(i)) { prntCount++ }
        }
        assertEquals(128, ctrlCount + prntCount)
    }
}