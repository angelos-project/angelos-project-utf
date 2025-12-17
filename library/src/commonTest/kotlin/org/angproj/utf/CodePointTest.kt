package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertTrue

class CodePointTest {
    @Test
    fun testCodePointValue() {
        val cp = 0x1F600.toCodePoint() // 😀
        assertTrue { cp.value == 0x1F600 }
    }

    @Test
    fun testNullCodePoint() {
        val cp = Int.MIN_VALUE.toCodePoint()
        assertTrue { cp.isNull() }
        assertTrue { cp == CodePoint.nullCodePoint }
    }

    @Test
    fun testCharToCodePoint() {
        val char = 'A'
        val cp = char.toCodePoint()
        assertTrue { cp.value == 65 }
    }

    @Test
    fun testOctets() {
        val cp = 0x1F600.toCodePoint() // 😀
        assertTrue { cp.octets() == 4 }
    }
}