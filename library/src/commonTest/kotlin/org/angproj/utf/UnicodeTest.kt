package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertContentEquals

class UnicodeTest {
    @Test
    fun testDecodePassthroughLatin() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsum, Policy.passthrough)
        assertContentEquals(TestInformationStub.latinLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughLatinEmoji() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsumEmoji, Policy.passthrough)
        assertContentEquals(TestInformationStub.latinLipsumEmoji.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughGreek() {
        val bytes = Unicode.decode(TestInformationStub.greekLipsum, Policy.passthrough)
        assertContentEquals(TestInformationStub.greekLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughChinese() {
        val bytes = Unicode.decode(TestInformationStub.chineseLipsum, Policy.passthrough)
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