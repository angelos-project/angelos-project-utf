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

public class GlobalValidator : Validator() {

    private val values: Set<Int> = buildValuesSet()
    private val ranges: Set<IntRange> = buildRangesSet()

    override fun isValid(cp: Int): Boolean = isUtf8<Unit>(cp) && !isUnassigned<Unit>(cp)

    private inline fun <reified R: Any> isUnassigned(cp: Int): Boolean {
        for (range in ranges) {
            if (cp in range) return true
        }
        return values.contains(cp)
    }

    private companion object : AbstractUnicodeAware() {
        private fun buildValuesSet(): Set<Int> {
            return buildSet {

            }
        }
        private fun buildRangesSet(): Set<IntRange> {
            return buildSet {

            }
        }
    }
}