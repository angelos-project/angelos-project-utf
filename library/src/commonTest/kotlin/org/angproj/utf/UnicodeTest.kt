package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class UnicodeTest {

    @Test
    fun testToCodePoint() {
        assertEquals(Unicode.UTF_FIRST.toCodePoint(), CodePoint(0x00))
        assertEquals(Unicode.UTF_STOP.toCodePoint(), CodePoint(0x10_FFFF))
        assertEquals(Unicode.UTF_REPLACEMENT.toCodePoint(), CodePoint(0xFFFD))

        assertEquals(Unicode.RANGE_START.toCodePoint(), CodePoint(0x00))
        assertEquals(Unicode.RANGE_START_2.toCodePoint(), CodePoint(0x80))
        assertEquals(Unicode.RANGE_START_3.toCodePoint(), CodePoint(0x800))
        assertEquals(Unicode.RANGE_START_4.toCodePoint(), CodePoint(0x1_0000))

        assertEquals(Unicode.RANGE_STOP.toCodePoint(), CodePoint(0x7F))
        assertEquals(Unicode.RANGE_STOP_2.toCodePoint(), CodePoint(0x7FF))
        assertEquals(Unicode.RANGE_STOP_3.toCodePoint(), CodePoint(0xFFFF))
        assertEquals(Unicode.RANGE_STOP_4.toCodePoint(), CodePoint(0x10_FFFF))

        assertEquals(Unicode.SURROGATE_START.toCodePoint(), CodePoint(0xD800))
        assertEquals(Unicode.SURROGATE_STOP.toCodePoint(), CodePoint(0xDFFF))

        assertEquals(Unicode.SURROGATE_MIN_HIGH.toCodePoint(), CodePoint(0xD800))
        assertEquals(Unicode.SURROGATE_MAX_HIGH.toCodePoint(), CodePoint(0xDBFF))
        assertEquals(Unicode.SURROGATE_MIN_LOW.toCodePoint(), CodePoint(0xDC00))
        assertEquals(Unicode.SURROGATE_MAX_LOW.toCodePoint(), CodePoint(0xDFFF))
    }

    @Test
    fun testDecodePassthroughLatin() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsum)
        assertContentEquals(TestInformationStub.latinLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughLatinEmoji() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsumEmoji)
        assertContentEquals(TestInformationStub.latinLipsumEmoji.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughGreek() {
        val bytes = Unicode.decode(TestInformationStub.greekLipsum)
        assertContentEquals(TestInformationStub.greekLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughChinese() {
        val bytes = Unicode.decode(TestInformationStub.chineseLipsum)
        assertContentEquals(TestInformationStub.chineseLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeLatin() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsum, Policy.escape)
        assertContentEquals(TestInformationStub.latinLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeLatinEmoji() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsumEmoji, Policy.escape)
        assertContentEquals(TestInformationStub.latinLipsumEmoji.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeGreek() {
        val bytes = Unicode.decode(TestInformationStub.greekLipsum, Policy.escape)
        assertContentEquals(TestInformationStub.greekLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeChinese() {
        val bytes = Unicode.decode(TestInformationStub.chineseLipsum, Policy.escape)
        assertContentEquals(TestInformationStub.chineseLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityLatin() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsum, Policy.security)
        assertContentEquals(TestInformationStub.latinLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityLatinEmoji() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsumEmoji, Policy.security)
        assertContentEquals(TestInformationStub.latinLipsumEmoji.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityGreek() {
        val bytes = Unicode.decode(TestInformationStub.greekLipsum, Policy.security)
        assertContentEquals(TestInformationStub.greekLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityChinese() {
        val bytes = Unicode.decode(TestInformationStub.chineseLipsum, Policy.security)
        assertContentEquals(TestInformationStub.chineseLipsum.encodeToByteArray(), bytes)
    }

    @Test fun testDebugString() {
        Unicode.debugString("Testing 😀 debug 文字 string.")
    }
}