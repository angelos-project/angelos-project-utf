package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertContains

class AbstractUnicodeAwareTest : AbstractUnicodeAware() {

    @Test
    fun testUnicodePrint() {
        assertContains(unicodePrint<Unit>(Unicode.UTF_REPLACEMENT.toInt()), "0xFFFD")
        assertContains(unicodePrint<Unit>(Unicode.UTF_REPLACEMENT.toInt()), "65533")
    }

    /*@Test
    fun testCodePointValue() {
        val cp = 0x1F600.toCodePoint() // 😀
        assertTrue { cp.value == 0x1F600 }
    }*/
}