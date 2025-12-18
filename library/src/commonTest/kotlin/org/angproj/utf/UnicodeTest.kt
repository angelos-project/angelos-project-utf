package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertContentEquals

class UnicodeTest {
    @Test
    fun testDecodePassthroughLatin() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsum, Validator.basic, FilterPolicy.PASSTHROUGH)
        assertContentEquals(TestInformationStub.latinLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughLatinEmoji() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsumEmoji, Validator.basic, FilterPolicy.PASSTHROUGH)
        assertContentEquals(TestInformationStub.latinLipsumEmoji.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughGreek() {
        val bytes = Unicode.decode(TestInformationStub.greekLipsum, Validator.basic, FilterPolicy.PASSTHROUGH)
        assertContentEquals(TestInformationStub.greekLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodePassthroughChinese() {
        val bytes = Unicode.decode(TestInformationStub.chineseLipsum, Validator.basic, FilterPolicy.PASSTHROUGH)
        assertContentEquals(TestInformationStub.chineseLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeLatin() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsum, Validator.basic, FilterPolicy.ESCAPE)
        assertContentEquals(TestInformationStub.latinLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeLatinEmoji() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsumEmoji, Validator.basic, FilterPolicy.ESCAPE)
        assertContentEquals(TestInformationStub.latinLipsumEmoji.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeGreek() {
        val bytes = Unicode.decode(TestInformationStub.greekLipsum, Validator.basic, FilterPolicy.ESCAPE)
        assertContentEquals(TestInformationStub.greekLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeEscapeChinese() {
        val bytes = Unicode.decode(TestInformationStub.chineseLipsum, Validator.basic, FilterPolicy.ESCAPE)
        assertContentEquals(TestInformationStub.chineseLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityLatin() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsum, Validator.basic, FilterPolicy.SECURITY)
        assertContentEquals(TestInformationStub.latinLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityLatinEmoji() {
        val bytes = Unicode.decode(TestInformationStub.latinLipsumEmoji, Validator.basic, FilterPolicy.SECURITY)
        assertContentEquals(TestInformationStub.latinLipsumEmoji.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityGreek() {
        val bytes = Unicode.decode(TestInformationStub.greekLipsum, Validator.basic, FilterPolicy.SECURITY)
        assertContentEquals(TestInformationStub.greekLipsum.encodeToByteArray(), bytes)
    }

    @Test
    fun testDecodeSecurityChinese() {
        val bytes = Unicode.decode(TestInformationStub.chineseLipsum, Validator.basic, FilterPolicy.SECURITY)
        assertContentEquals(TestInformationStub.chineseLipsum.encodeToByteArray(), bytes)
    }

    @Test fun testDebugString() {
        Unicode.debugString("Testing 😀 debug 文字 string.")
    }
}