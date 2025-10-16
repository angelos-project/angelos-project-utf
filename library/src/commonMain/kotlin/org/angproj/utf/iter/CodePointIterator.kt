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
package org.angproj.utf.iter

import org.angproj.utf.CodePoint

public interface CodePointIterator : Iterator<CodePoint> {

    /**
     * Prevoiously [CodePoint] given by next()
     * */
    public val previous: CodePoint

    /**
     * Byte position indicator
     * */
    public val position: Int

    /**
     * Number of [CodePoint]s iterated
     * */
    public val count: Int


    override fun next(): CodePoint

    override fun hasNext(): Boolean
}