package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith


class LangFilterTest {
    @Test
    fun testLatinLipsum() {
        assertContentEquals(
            Unicode.decode(TestInformationStub.latinLipsum, Validator.basic, FilterPolicy.SECURITY),
            TestInformationStub.latinLipsum.encodeToByteArray()
        )
    }

    @Test
    fun testLatinLipsumEmoji() {
        assertFailsWith<UnicodeError> {
            Unicode.decode(TestInformationStub.latinLipsumEmoji, Validator.basic, FilterPolicy.SECURITY)
        }
    }

    @Test
    fun testGreekLipsum() {
        assertContentEquals(
            Unicode.decode(TestInformationStub.greekLipsum, Validator.basic, FilterPolicy.SECURITY),
            TestInformationStub.greekLipsum.encodeToByteArray()
        )
    }

    @Test
    fun testChineseLipsum() {
        assertContentEquals(
            Unicode.decode(TestInformationStub.chineseLipsum, Validator.basic, FilterPolicy.SECURITY),
            TestInformationStub.chineseLipsum.encodeToByteArray()
        )
    }
}