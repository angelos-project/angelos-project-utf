package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class ValidatorMockitoTest {

    @Test
    fun testMockIsValidCpWhenTrue() {
        val validator: Validator = mock()

        whenever(validator.isValid(65)).thenReturn(true)

        val result = validator.isValid(65)

        assertTrue { result }
        verify(validator, times(1)).isValid(65)
    }

    @Test
    fun testMockIsValidWhenTrue() {
        val validator: Validator = mock()

        val codePoint = CodePoint(65) // Assuming CodePoint is a simple wrapper class
        whenever(validator.isValid(codePoint)).thenReturn(true)

        val result = validator.isValid(codePoint)

        assertTrue { result }
        verify(validator, times(1)).isValid(codePoint)
    }

    @Test
    fun testMockIsValidCpWhenFalse() {
        val validator: Validator = mock()

        whenever(validator.isValid(0x1FFFF)).thenReturn(false) // Some invalid code point

        val result = validator.isValid(0x1FFFF)

        assertFalse { result }
        verify(validator).isValid(0x1FFFF)
    }

    @Test
    fun testMockIsValidWhenFalse() {
        val validator: Validator = mock()

        val codePoint = CodePoint(0x1FFFF) // Assuming CodePoint is a simple wrapper class
        whenever(validator.isValid(codePoint)).thenReturn(false) // Some invalid code point

        val result = validator.isValid(codePoint)

        assertFalse { result }
        verify(validator).isValid(codePoint)
    }
}