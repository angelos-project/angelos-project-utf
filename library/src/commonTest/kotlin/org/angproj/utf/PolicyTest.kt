package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertEquals

class PolicyTest {
    @Test
    fun testPassThrough() {
        val policy = Policy.passthrough
        assertEquals(Filter.PASSTHROUGH, policy.filter)
        assertEquals(Validator.basic, policy.validator)
    }

    @Test
    fun testEscape() {
        val policy = Policy.escape
        assertEquals(Filter.ESCAPE, policy.filter)
        assertEquals(Validator.basic, policy.validator)
    }

    @Test
    fun testSecurity() {
        val policy = Policy.security
        assertEquals(Filter.SECURITY, policy.filter)
        assertEquals(Validator.basic, policy.validator)
    }
}