package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertEquals

class HexTest: AbstractUnicodeAware() {

    @Test
    fun testDigitToNumber() {
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_ZERO.cp), 0)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_ONE.cp), 1)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_TWO.cp), 2)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_THREE.cp), 3)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_FOUR.cp), 4)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_FIVE.cp), 5)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_SIX.cp), 6)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_SEVEN.cp), 7)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_EIGHT.cp), 8)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_NINE.cp), 9)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_A_UP.cp), 10)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_A_LOW.cp), 10)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_B_UP.cp), 11)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_B_LOW.cp), 11)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_C_UP.cp), 12)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_C_LOW.cp), 12)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_D_UP.cp), 13)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_D_LOW.cp), 13)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_E_UP.cp), 14)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_E_LOW.cp), 14)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_F_UP.cp), 15)
        assertEquals(digitToNumber<Unit>(Ascii.PRNT_F_LOW.cp), 15)
    }

    @Test
    fun testNuberToDigit() {
        assertEquals(numberToDigit<Unit>(0), Ascii.PRNT_ZERO.cp)
        assertEquals(numberToDigit<Unit>(1), Ascii.PRNT_ONE.cp)
        assertEquals(numberToDigit<Unit>(2), Ascii.PRNT_TWO.cp)
        assertEquals(numberToDigit<Unit>(3), Ascii.PRNT_THREE.cp)
        assertEquals(numberToDigit<Unit>(4), Ascii.PRNT_FOUR.cp)
        assertEquals(numberToDigit<Unit>(5), Ascii.PRNT_FIVE.cp)
        assertEquals(numberToDigit<Unit>(6), Ascii.PRNT_SIX.cp)
        assertEquals(numberToDigit<Unit>(7), Ascii.PRNT_SEVEN.cp)
        assertEquals(numberToDigit<Unit>(8), Ascii.PRNT_EIGHT.cp)
        assertEquals(numberToDigit<Unit>(9), Ascii.PRNT_NINE.cp)
        assertEquals(numberToDigit<Unit>(10), Ascii.PRNT_A_LOW.cp)
        assertEquals(numberToDigit<Unit>(11), Ascii.PRNT_B_LOW.cp)
        assertEquals(numberToDigit<Unit>(12), Ascii.PRNT_C_LOW.cp)
        assertEquals(numberToDigit<Unit>(13), Ascii.PRNT_D_LOW.cp)
        assertEquals(numberToDigit<Unit>(14), Ascii.PRNT_E_LOW.cp)
        assertEquals(numberToDigit<Unit>(15), Ascii.PRNT_F_LOW.cp)
    }
}