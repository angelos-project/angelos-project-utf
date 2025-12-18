package org.angproj.utf

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertContentEquals

class UnicodeAwareTest : UnicodeAware {

    @Test
    fun testFilterGlyphPolicy() {
        listOf(Policy.passthrough, Policy.escape, Policy.security).forEach { policy ->
            var inPos = 0
            val strm1 = Unicode.decode(TestInformationStub.latinLipsum)
            while (inPos < strm1.size) {
                val cp = readGlyphStrm { strm1[inPos++] }
                filterGlyphByPolicy(cp, policy)
            }

            inPos = 0
            val strm2 = Unicode.decode(TestInformationStub.latinLipsumEmoji)
            while (inPos < strm2.size) {
                val cp = readGlyphStrm { strm2[inPos++] }
                filterGlyphByPolicy(cp, policy)
            }

            inPos = 0
            val strm3 = Unicode.decode(TestInformationStub.greekLipsum)
            while (inPos < strm3.size) {
                val cp = readGlyphStrm { strm3[inPos++] }
                filterGlyphByPolicy(cp, policy)
            }

            inPos = 0
            val strm4 = Unicode.decode(TestInformationStub.chineseLipsum)
            while (inPos < strm4.size) {
                val cp = readGlyphStrm { strm4[inPos++] }
                filterGlyphByPolicy(cp, policy)
            }
        }
    }

    @Test
    fun testOctetReadWriteStrm() {
        listOf(Policy.passthrough, Policy.escape, Policy.security).forEach { policy ->
            var inPos = 0
            var outPos = 0
            val strm1 = Unicode.decode(TestInformationStub.latinLipsum)
            val outStrm1 = ByteArray(strm1.size)
            while (inPos < strm1.size) {
                val cp = readGlyphByPolicyStrm(policy) { strm1[inPos++] }
                writeGlyphByPolicyStrm(cp, policy) { outStrm1[outPos++] = it }
            }
            assertContentEquals(strm1, outStrm1)

            inPos = 0
            outPos = 0
            val strm2 = Unicode.decode(TestInformationStub.latinLipsumEmoji)
            val outStrm2 = ByteArray(strm2.size)
            while (inPos < strm2.size) {
                val cp = readGlyphByPolicyStrm(policy) { strm2[inPos++] }
                writeGlyphByPolicyStrm(cp, policy) { outStrm2[outPos++] = it }
            }
            assertContentEquals(strm2, outStrm2)

            inPos = 0
            outPos = 0
            val strm3 = Unicode.decode(TestInformationStub.greekLipsum)
            val outStrm3 = ByteArray(strm3.size)
            while (inPos < strm3.size) {
                val cp = readGlyphByPolicyStrm(policy) { strm3[inPos++] }
                writeGlyphByPolicyStrm(cp, policy) { outStrm3[outPos++] = it }
            }
            assertContentEquals(strm3, outStrm3)

            inPos = 0
            outPos = 0
            val strm4 = Unicode.decode(TestInformationStub.chineseLipsum)
            val outStrm4 = ByteArray(strm4.size)
            while (inPos < strm4.size) {
                val cp = readGlyphByPolicyStrm(policy) { strm4[inPos++] }
                writeGlyphByPolicyStrm(cp, policy) { outStrm4[outPos++] = it }
            }
            assertContentEquals(strm4, outStrm4)
        }
    }

    @Test
    fun testOctetReadBlk() {
        var inPos = 0
        var outPos = 0
        val strm1 = Unicode.decode(TestInformationStub.latinLipsum)
        val outStrm1 = ByteArray(strm1.size)
        while (inPos < strm1.size) {
            val cp = readGlyphBlk(strm1.size-inPos) { strm1[inPos++] }
            writeGlyphBlk(cp, outStrm1.size-outPos) { outStrm1[outPos++] = it }
        }
        assertContentEquals(strm1, outStrm1)

        inPos = 0
        outPos = 0
        val strm2 = Unicode.decode(TestInformationStub.latinLipsumEmoji)
        val outStrm2 = ByteArray(strm2.size)
        while (inPos < strm2.size) {
            val cp = readGlyphBlk(strm2.size-inPos) { strm2[inPos++] }
            writeGlyphBlk(cp, outStrm2.size-outPos) { outStrm2[outPos++] = it }
        }
        assertContentEquals(strm2, outStrm2)

        inPos = 0
        outPos = 0
        val strm3 = Unicode.decode(TestInformationStub.greekLipsum)
        val outStrm3 = ByteArray(strm3.size)
        while (inPos < strm3.size) {
            val cp = readGlyphBlk(strm3.size-inPos) { strm3[inPos++] }
            writeGlyphBlk(cp, outStrm3.size-outPos) { outStrm3[outPos++] = it }
        }
        assertContentEquals(strm3, outStrm3)

        inPos = 0
        outPos = 0
        val strm4 = Unicode.decode(TestInformationStub.chineseLipsum)
        val outStrm4 = ByteArray(strm4.size)
        while (inPos < strm4.size) {
            val cp = readGlyphBlk(strm4.size-inPos) { strm4[inPos++] }
            writeGlyphBlk(cp, outStrm4.size-outPos) { outStrm4[outPos++] = it }
        }
        assertContentEquals(strm4, outStrm4)
    }
}