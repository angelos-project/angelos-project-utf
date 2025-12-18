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
}