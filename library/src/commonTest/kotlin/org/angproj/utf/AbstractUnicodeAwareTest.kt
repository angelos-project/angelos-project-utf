package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertContentEquals

class AbstractUnicodeAwareTest : AbstractUnicodeAware() {

    @Test
    fun testUnicodePrint() {
        assertContains(unicodePrint<Unit>(Unicode.UTF_REPLACEMENT.toInt()), "0xFFFD")
        assertContains(unicodePrint<Unit>(Unicode.UTF_REPLACEMENT.toInt()), "65533")
    }

    @Test
    fun testIsUnicode() {
        assertTrue(isUnicode<Unit>(Unicode.UTF_REPLACEMENT.toInt()))
        assertFalse(isUnicode<Unit>(0x20_0000))
    }

    @Test
    fun testIsSurrogate() {
        assertTrue(isSurrogate<Unit>(0xDB01))
        assertFalse(isSurrogate<Unit>(Unicode.UTF_REPLACEMENT.toInt()))
    }

    @Test
    fun testIsUtf8() {
        assertTrue(isUtf8<Unit>(Unicode.UTF_REPLACEMENT.toInt()))
        assertFalse(isUtf8<Unit>(0xDB01))
    }

    @Test
    fun testEscapeNonUtf8() {
        assertEquals(escapeNonUtf8<Unit>(Ascii.PRNT_A_UP.toInt()), Ascii.PRNT_A_UP.toInt())
        assertEquals(escapeNonUtf8<Unit>(0xDB01), Unicode.UTF_REPLACEMENT.toInt())
    }

    @Test
    fun testUnicodeOctetSize() {
        assertEquals(unicodeOctetSize<Unit>(0x20), 1)
        assertEquals(unicodeOctetSize<Unit>(0x200), 2)
        assertEquals(unicodeOctetSize<Unit>(0x2000), 3)
        assertEquals(unicodeOctetSize<Unit>(0x10001), 4)
        assertFailsWith<UnicodeError> {
            unicodeOctetSize<Unit>(-1)
        }
    }

    @Test
    fun testIsSurrogateChar() {
        assertTrue(isSurrogate<Unit>('\uDB01'))
        assertFalse(isSurrogate<Unit>('A'))
    }

    @Test
    fun testIsHighSurrogateChar() {
        assertTrue(isHighSurrogate<Unit>('\uDB01'))
        assertFalse(isHighSurrogate<Unit>('A'))
    }

    @Test
    fun testIsLowSurrogateChar() {
        assertTrue(isLowSurrogate<Unit>('\uDC01'))
        assertFalse(isLowSurrogate<Unit>('A'))
    }

    @Test
    fun testSurrogatesToCodePoint() {
        val txt = "\uD83E\uDD23"
        val txt2 = "🤣"
        assertEquals(txt, txt2)
        val codePoint = surrogatesToCodePoint<Unit>(txt.get(0), txt.get(1))
        assertEquals(0x1F923, codePoint)
    }

    @Test
    fun testOctetReadWriteStrm() {
        var inPos = 0
        var outPos = 0
        val strm1 = Unicode.decode(TestInformationStub.latinLipsum)
        val outStrm1 = ByteArray(strm1.size)
        while (inPos < strm1.size) {
            val cp = octetReadStrm<Unit> { strm1[inPos++] }
            octetWriteStrm<Unit>(cp) { outStrm1[outPos++] = it }
        }
        assertContentEquals(strm1, outStrm1)

        inPos = 0
        outPos = 0
        val strm2 = Unicode.decode(TestInformationStub.latinLipsumEmoji)
        val outStrm2 = ByteArray(strm2.size)
        while (inPos < strm2.size) {
            val cp = octetReadStrm<Unit> { strm2[inPos++] }
            octetWriteStrm<Unit>(cp) { outStrm2[outPos++] = it }
        }
        assertContentEquals(strm2, outStrm2)

        inPos = 0
        outPos = 0
        val strm3 = Unicode.decode(TestInformationStub.greekLipsum)
        val outStrm3 = ByteArray(strm3.size)
        while (inPos < strm3.size) {
            val cp = octetReadStrm<Unit> { strm3[inPos++] }
            octetWriteStrm<Unit>(cp) { outStrm3[outPos++] = it }
        }
        assertContentEquals(strm3, outStrm3)

        inPos = 0
        outPos = 0
        val strm4 = Unicode.decode(TestInformationStub.chineseLipsum)
        val outStrm4 = ByteArray(strm4.size)
        while (inPos < strm4.size) {
            val cp = octetReadStrm<Unit> { strm4[inPos++] }
            octetWriteStrm<Unit>(cp) { outStrm4[outPos++] = it }
        }
        assertContentEquals(strm4, outStrm4)
    }

    @Test
    fun testOctetReadBlk() {
        var inPos = 0
        var outPos = 0
        val strm1 = Unicode.decode(TestInformationStub.latinLipsum)
        val outStrm1 = ByteArray(strm1.size)
        while (inPos < strm1.size) {
            val cp = octetReadBlk<Unit>(strm1.size-inPos) { strm1[inPos++] }
            octetWriteBlk<Unit>(cp, outStrm1.size-outPos) { outStrm1[outPos++] = it }
        }
        assertContentEquals(strm1, outStrm1)

        inPos = 0
        outPos = 0
        val strm2 = Unicode.decode(TestInformationStub.latinLipsumEmoji)
        val outStrm2 = ByteArray(strm2.size)
        while (inPos < strm2.size) {
            val cp = octetReadBlk<Unit>(strm2.size-inPos) { strm2[inPos++] }
            octetWriteBlk<Unit>(cp, outStrm2.size-outPos) { outStrm2[outPos++] = it }
        }
        assertContentEquals(strm2, outStrm2)

        inPos = 0
        outPos = 0
        val strm3 = Unicode.decode(TestInformationStub.greekLipsum)
        val outStrm3 = ByteArray(strm3.size)
        while (inPos < strm3.size) {
            val cp = octetReadBlk<Unit>(strm3.size-inPos) { strm3[inPos++] }
            octetWriteBlk<Unit>(cp, outStrm3.size-outPos) { outStrm3[outPos++] = it }
        }
        assertContentEquals(strm3, outStrm3)

        inPos = 0
        outPos = 0
        val strm4 = Unicode.decode(TestInformationStub.chineseLipsum)
        val outStrm4 = ByteArray(strm4.size)
        while (inPos < strm4.size) {
            val cp = octetReadBlk<Unit>(strm4.size-inPos) { strm4[inPos++] }
            octetWriteBlk<Unit>(cp, outStrm4.size-outPos) { outStrm4[outPos++] = it }
        }
        assertContentEquals(strm4, outStrm4)
    }

    @Test
    fun testRanges() {
        assertEquals(0x0, UTF8_RANGE.first)
        assertEquals(0x10_FFFF, UTF8_RANGE.last)
        assertEquals(Unicode.UTF_FIRST.toInt(), UTF8_RANGE.first)
        assertEquals(Unicode.UTF_LAST.toInt(), UTF8_RANGE.last)

        assertEquals(0x0, RANGE_SIZE_1.first)
        assertEquals(0x7F, RANGE_SIZE_1.last)
        assertEquals(Unicode.RANGE_START.toInt(), RANGE_SIZE_1.first)
        assertEquals(Unicode.RANGE_STOP.toInt(), RANGE_SIZE_1.last)

        assertEquals(0x80, RANGE_SIZE_2.first)
        assertEquals(0x7FF, RANGE_SIZE_2.last)
        assertEquals(Unicode.RANGE_START_2.toInt(), RANGE_SIZE_2.first)
        assertEquals(Unicode.RANGE_STOP_2.toInt(), RANGE_SIZE_2.last)

        assertEquals(0x800, RANGE_SIZE_3.first)
        assertEquals(0xFFFF, RANGE_SIZE_3.last)
        assertEquals(Unicode.RANGE_START_3.toInt(), RANGE_SIZE_3.first)
        assertEquals(Unicode.RANGE_STOP_3.toInt(), RANGE_SIZE_3.last)

        assertEquals(0x1_0000, RANGE_SIZE_4.first)
        assertEquals(0x10_FFFF, RANGE_SIZE_4.last)
        assertEquals(Unicode.RANGE_START_4.toInt(), RANGE_SIZE_4.first)
        assertEquals(Unicode.RANGE_STOP_4.toInt(), RANGE_SIZE_4.last)

        assertEquals(0xD800, SURROGATE_RANGE.first)
        assertEquals(0xDFFF, SURROGATE_RANGE.last)
        assertEquals(Unicode.SURROGATE_START.toInt(), SURROGATE_RANGE.first)
        assertEquals(Unicode.SURROGATE_STOP.toInt(), SURROGATE_RANGE.last)

        assertEquals(0xDC00, SURROGATE_LOW_RANGE.first)
        assertEquals(0xDFFF, SURROGATE_LOW_RANGE.last)
        assertEquals(Unicode.SURROGATE_MIN_LOW.toInt(), SURROGATE_LOW_RANGE.first)
        assertEquals(Unicode.SURROGATE_MAX_LOW.toInt(), SURROGATE_LOW_RANGE.last)

        assertEquals(0xD800, SURROGATE_HIGH_RANGE.first)
        assertEquals(0xDBFF, SURROGATE_HIGH_RANGE.last)
        assertEquals(Unicode.SURROGATE_MIN_HIGH.toInt(), SURROGATE_HIGH_RANGE.first)
        assertEquals(Unicode.SURROGATE_MAX_HIGH.toInt(), SURROGATE_HIGH_RANGE.last)
    }
}