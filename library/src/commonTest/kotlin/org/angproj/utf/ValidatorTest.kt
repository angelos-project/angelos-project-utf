package org.angproj.utf

import org.angproj.utf.util.ExactValidator
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse


class ValidatorTest {

    private object MockValidator: Validator() {
        override fun isValid(cp: Int): Boolean {
            return cp == 65
        }
    }

    @Test
    fun testIsValid() {
        val validator = MockValidator
        assertTrue { validator.isValid(65.toCodePoint()) }
        assertFalse { validator.isValid(0x1FFFFF.toCodePoint()) }
    }

    @Test
    fun testBasicValidatorInstance() {
        assertTrue { Validator.basic is ExactValidator }
    }
}