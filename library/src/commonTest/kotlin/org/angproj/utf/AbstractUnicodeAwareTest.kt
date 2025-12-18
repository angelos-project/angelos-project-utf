package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertTrue

class AbstractUnicodeAwareTest : AbstractUnicodeAware() {
    @Test
    fun testCodePointValue() {
        val cp = 0x1F600.toCodePoint() // 😀
        assertTrue { cp.value == 0x1F600 }
    }
}