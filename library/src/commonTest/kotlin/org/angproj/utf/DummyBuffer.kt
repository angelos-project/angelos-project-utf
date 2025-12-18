/**
 * Copyright (c) 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
 *
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 *
 *      https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *      Kristoffer Paulsson - initial implementation
 */
package org.angproj.utf

import org.angproj.utf.iter.CodePointIterable
import org.angproj.utf.iter.CodePointIterator

/**
 * A dummy buffer for reading and writing glyphs as [CodePoint]s with an underlying [ByteArray].
 *
 * This buffer tracks the current position and supports rewinding to the start.
 * It uses a [Policy] to determine how glyphs are read and written.
 * The buffer does not enforce a size limit, but operations are limited by the current [ByteArray] size.
 *
 * @property buffer The underlying byte array storage.
 * @property policy The policy used for reading and writing glyphs.
 * @constructor Creates a [DummyBuffer] with the given [buffer] and [policy].
 */
class DummyBuffer(buffer: ByteArray, policy: Policy) : UnicodeAware, CodePointIterable {
    private var _buffer = buffer
    private var _position = 0
    private var _policy = policy

    /**
     * The underlying byte array storage.
     */
    val buffer: ByteArray
        get() = _buffer

    /**
     * The total size of the buffer in bytes.
     */
    val size: Int
        get() = _buffer.size

    /**
     * The current position in the buffer (in bytes).
     */
    val position: Int
        get() = _position

    /**
     * The policy used for reading and writing glyphs.
     */
    val policy: Policy
        get() = _policy

    /**
     * The number of bytes remaining from the current position to the end of the buffer.
     */
    val remaining: Int
        get() = size - position

    /**
     * Rewinds the buffer position to the start (position 0).
     */
    fun rewind() {
        _position = 0
    }

    /**
     * Reads a [CodePoint] from the current position in the buffer using the configured [policy].
     *
     * @return The [CodePoint] read from the buffer.
     * @throws Exception if reading fails or there is insufficient data.
     */
    fun read(): CodePoint = readGlyphByPolicyBlk(remaining, policy) {
        _buffer[_position++]
    }

    /**
     * Writes a [CodePoint] to the current position in the buffer using the configured [policy].
     *
     * @param codePoint The [CodePoint] to write.
     * @return The number of bytes written.
     * @throws Exception if writing fails or there is insufficient space.
     */
    fun write(codePoint: CodePoint): Int = writeGlyphByPolicyBlk(codePoint, remaining, policy) {
        buffer[_position++] = it
    }

    override fun iterator(): CodePointIterator {
        rewind()
        return object : CodePointIterator {
            private val buffer = this@DummyBuffer
            private var _cnt = 0
            private var _last: CodePoint = CodePoint(0)

            override val previous: CodePoint
                get() = _last
            override val position: Int
                get() = buffer.position
            override val count: Int
                get() = _cnt

            override fun next(): CodePoint = read().also {
                _last = it
                _cnt++
            }

            override fun hasNext(): Boolean = remaining > 0
        }
    }
}