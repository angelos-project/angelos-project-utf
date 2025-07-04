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

/**
 * Represents a Unicode-aware language, associating it with its scripts and standard codes.
 *
 * A `UtfLanguage` defines a natural language in terms of its name, ISO codes, and the set of
 * [Script]s (writing systems) that are valid for expressing the language. This interface is
 * intended to be implemented by language definitions that need to specify which Unicode scripts
 * are used for their written form.
 *
 * @property name The human-readable name of the language (e.g., "English", "Russian").
 * @property short The ISO 639-1 two-letter code for the language (e.g., "en", "ru").
 * @property long The ISO 639-3 three-letter code for the language (e.g., "eng", "rus").
 * @property scripts The set of [Script]s (writing systems) that are valid for this language.
 */
public interface UtfLanguage {
    /**
     * The human-readable name of the language (e.g., "English", "Russian").
     */
    public val name: String

    /**
     * The ISO 639-1 two-letter code for the language (e.g., "en", "ru").
     */
    public val short: String

    /**
     * The ISO 639-3 three-letter code for the language (e.g., "eng", "rus").
     */
    public val long: String

    /**
     * The set of [Script]s (writing systems) that are valid within this language.
     *
     * Each script represents a collection of Unicode blocks used to write the language.
     */
    public val scripts: Set<Script>
}