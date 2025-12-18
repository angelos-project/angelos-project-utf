package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertContains
import kotlin.test.assertEquals

class AbstractUnicodeAwareTest : AbstractUnicodeAware() {

    @Test
    fun testUnicodePrint() {
        assertContains(unicodePrint<Unit>(Unicode.UTF_REPLACEMENT.toInt()), "0xFFFD")
        assertContains(unicodePrint<Unit>(Unicode.UTF_REPLACEMENT.toInt()), "65533")
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