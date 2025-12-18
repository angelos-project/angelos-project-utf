package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class AsciiTest {
    @Test
    fun testAscii() {
        (0 until 128).forEach { i ->
            val ascii = Ascii.entries.findLast { it.cp == i }
            assertNotNull(ascii)
            assertEquals(ascii.toCodePoint(), i.toCodePoint())
        }
    }
}