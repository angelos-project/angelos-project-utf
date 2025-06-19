package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith


class LangFilterTest {
    @Test
    fun testLatinLipsum() {
        val filter = Unicode.createFilter(Language.LATIN)
        assertContentEquals(
            Unicode.decode(TestInformationStub.latinLipsum, filter, FilterPolicy.SECURITY),
            TestInformationStub.latinLipsum.encodeToByteArray()
        )
    }

    @Test
    fun testLatinLipsumEmoji() {
        val filter = Unicode.createFilter(Language.LATIN)
        assertFailsWith<UnicodeError> {
            Unicode.decode(TestInformationStub.latinLipsumEmoji, filter, FilterPolicy.SECURITY)
        }
    }

    @Test
    fun testGreekLipsum() {
        val filter = Unicode.createFilter(Language.ANCIENT_GREEK_TO_1453)
        filter.withBasicLatin()
        assertContentEquals(
            Unicode.decode(TestInformationStub.greekLipsum, filter, FilterPolicy.SECURITY),
            TestInformationStub.greekLipsum.encodeToByteArray()
        )
    }

    @Test
    fun testChineseLipsum() {
        val filter = Unicode.createFilter(Language.CHINESE)
        filter.withBasicLatin()
        assertContentEquals(
            Unicode.decode(TestInformationStub.chineseLipsum, filter, FilterPolicy.SECURITY),
            TestInformationStub.chineseLipsum.encodeToByteArray()
        )
    }
}