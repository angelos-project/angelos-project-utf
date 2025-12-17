package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertFailsWith

class UnicodeErrorTest {
    @Test
    fun testUnicodeErrorMessage() {
        assertFailsWith<UnicodeError> {
            throw UnicodeError("Test Unicode error message")
        }
    }
}