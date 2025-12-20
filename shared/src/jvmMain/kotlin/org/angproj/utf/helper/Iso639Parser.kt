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
package org.angproj.utf.helper


public class Iso639Parser : DataLoader<Iso6393Language>() {

    private val parser = object : UnicodeDataParser {
        fun parseLine(line: String): Iso6393Language {
            val parts = line.split("\t".toRegex()).toTypedArray()
            return Iso6393Language(
                parts[0],  // Id
                parts[1],  // Part2b
                parts[2],  // Part2t
                parts[3],  // Part1
                parts[4],  // Scope
                parts[5],  // Language_Type
                parts[6],  // Ref_Name
                //parts[7] // Comment
            )
        }
    }

    override fun loadData(resourcePath: String): List<Iso6393Language> {
        with(parser) {
            return lineIterator(resourceStream(resourcePath)) { line ->
                parseLine(line)
            }
        }
    }

    override val allData: List<Iso6393Language> by lazy {
        loadData("/iso-639-3.tab")
    }
}


/**
 * A simple Java program (Java 17+) that downloads and parses the ISO 639-3 tab-delimited file
 * from https://iso639-3.sil.org/sites/iso639-3/files/downloads/iso-639-3.tab
 * without any external dependencies.
 *
 * Each data row is parsed into an instance of the Iso6393Entry record.
 */
/*public object Iso6393Parser {
    /**
     * Parses the remote TSV file and returns a list of entries (skipping the header row).
     */
    @Throws(Exception::class)
    public fun parseIso6393(): MutableList<Iso6393Entry?> {
        val url = URL("https://iso639-3.sil.org/sites/iso639-3/files/downloads/iso-639-3.tab")

        val entries: MutableList<Iso6393Entry?> = ArrayList<Iso6393Entry?>()

        BufferedReader(
            InputStreamReader(url.openStream(), "UTF-8")
        ).use { reader ->

            // Skip the header line
            reader.readLine()

            var line: String?
            while ((reader.readLine().also { line = it }) != null) {
                if (line!!.isBlank()) {
                    continue  // skip any empty lines (shouldn't occur, but safe)
                }

                // Split on tab characters, preserving empty fields
                val parts: Array<String?> =
                    line.split("\t".toRegex()).toTypedArray() // -1 keeps trailing empty fields

                if (parts.size != 8) {
                    // In case of malformed line, you could throw or log
                    System.err.println("Skipping malformed line: " + line)
                    continue
                }

                val entry = Iso6393Entry(
                    parts[0],  // Id
                    if (parts[1]!!.isEmpty()) null else parts[1],  // Part2b
                    if (parts[2]!!.isEmpty()) null else parts[2],  // Part2t
                    if (parts[3]!!.isEmpty()) null else parts[3],  // Part1
                    parts[4],  // Scope
                    parts[5],  // Language_Type
                    parts[6],  // Ref_Name
                    if (parts[7]!!.isEmpty()) null else parts[7] // Comment
                )

                entries.add(entry)
            }
        }
        return entries
    }

    /**
     * Example usage: parse and print the first 10 entries.
     */
    @Throws(Exception::class)
    @JvmStatic
    public fun main(args: Array<String>) {
        val entries = parseIso6393()

        println("Parsed " + entries.size + " ISO 639-3 entries.\n")
        println("First 10 entries:")

        entries.stream()
            .limit(10)
            .forEach { e: Iso6393Entry? -> println(e) }
    }

    /**
     * Record representing one row from the ISO 639-3 code table.
     *
     * Columns (all String, as some fields may be empty):
     * - id:        ISO 639-3 identifier (3 letters, always present)
     * - part2b:    ISO 639-2 bibliographic code (may be empty)
     * - part2t:    ISO 639-2 terminologic code (may be empty)
     * - part1:     ISO 639-1 code (2 letters, may be empty)
     * - scope:     Scope: I (Individual), M (Macrolanguage), S (Special)
     * - type:      Language type: L (Living), E (Extinct), A (Ancient),
     * H (Historical), C (Constructed)
     * - refName:   Reference name (language name, always present)
     * - comment:   Optional comment (may be empty)
     */
    public class Iso6393Entry(
        id: String?,
        part2b: String?,
        part2t: String?,
        part1: String?,
        scope: String?,
        type: String?,
        refName: String?,
        comment: String?
    ) {
        public val id: String?
        public val part2b: String?
        public val part2t: String?
        public val part1: String?
        public val scope: String?
        public val type: String?
        public val refName: String?
        public val comment: String?

        // Optional: compact canonical constructor for basic validation/trimming
        init {
            var id = id
            var part2b = part2b
            var part2t = part2t
            var part1 = part1
            var scope = scope
            var type = type
            var refName = refName
            var comment = comment
            Objects.requireNonNull<String?>(id, "Id cannot be null")
            Objects.requireNonNull<String?>(scope, "Scope cannot be null")
            Objects.requireNonNull<String?>(type, "Type cannot be null")
            Objects.requireNonNull<String?>(refName, "Ref_Name cannot be null")

            // Trim all fields to remove any accidental whitespace
            id = id!!.trim { it <= ' ' }
            part2b = if (part2b == null) "" else part2b.trim { it <= ' ' }
            part2t = if (part2t == null) "" else part2t.trim { it <= ' ' }
            part1 = if (part1 == null) "" else part1.trim { it <= ' ' }
            scope = scope!!.trim { it <= ' ' }
            type = type!!.trim { it <= ' ' }
            refName = refName!!.trim { it <= ' ' }
            comment = if (comment == null) "" else comment.trim { it <= ' ' }
            this.id = id
            this.part2b = part2b
            this.part2t = part2t
            this.part1 = part1
            this.scope = scope
            this.type = type
            this.refName = refName
            this.comment = comment
        }
    }
}*/