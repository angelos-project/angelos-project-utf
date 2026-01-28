package org.angproj.utf

import java.util.*

class TocParserKt(input: String) {

    interface Numeral<E: Enum<E>> {
        val numeral: String
        val value: Int
    }

    interface NumeralParser<E: Enum<E>> {
        fun fromNumeral(numeral: String): E
    }

    enum class AlphabeticNumeral(override val numeral: String, override val value: Int) : Numeral<AlphabeticNumeral> {
        A_("A.", 1),
        B_("B.", 2),
        C_("C.", 3),
        D_("D.", 4),
        E_("E.", 5),
        F_("F.", 6),
        G_("G.", 7),
        H_("H.", 8),
        I_("I.", 9),
        J_("J.", 10),
        K_("K.", 11),
        L_("L.", 12),
        M_("M.", 13),
        N_("N.", 14),
        O_("O.", 15),
        P_("P.", 16),
        Q_("Q.", 17),
        R_("R.", 18),
        S_("S.", 19),
        T_("T.", 20),
        U("", 0);  // Placeholder for invalid

        companion object : NumeralParser<AlphabeticNumeral> {
            override fun fromNumeral(numeral: String): AlphabeticNumeral {
                return AlphabeticNumeral.entries.find { it.numeral == numeral } ?: U
            }
        }
    }

    enum class RomanNumeral(override val numeral: String, override val value: Int) : Numeral<RomanNumeral> {
        I_("I.", 1),
        II_("II.", 2),
        III_("III.", 3),
        IV_("IV.", 4),
        V_("V.", 5),
        VI_("VI.", 6),
        VII_("VII.", 7),
        VIII_("VIII.", 8),
        IX_("IX.", 9),
        X_("X.", 10),
        XI_("XI.", 11),
        XII_("XII.", 12),
        XIII_("XIII.", 13),
        XIV_("XIV.", 14),
        XV_("XV.", 15),
        XVI_("XVI.", 16),
        XVII_("XVII.", 17),
        XVIII_("XVIII.", 18),
        XIX_("XIX.", 19),
        XX_("XX.", 20),
        U("", 0);  // Placeholder for invalid

        companion object : NumeralParser<RomanNumeral> {
            override fun fromNumeral(numeral: String): RomanNumeral {
                return RomanNumeral.entries.find { it.numeral == numeral } ?: U
            }
        }
    }

    enum class IntegerNumeral(override val numeral: String, override val value: Int) : Numeral<IntegerNumeral> {
        ONE("1.", 1),
        TWO("2.", 2),
        THREE("3.", 3),
        FOUR("4.", 4),
        FIVE("5.", 5),
        SIX("6.", 6),
        SEVEN("7.", 7),
        EIGHT("8.", 8),
        NINE("9.", 9),
        TEN("10.", 10),
        ELEVEN("11.", 11),
        TWELVE("12.", 12),
        THIRTEEN("13.", 13),
        FOURTEEN("14.", 14),
        FIFTEEN("15.", 15),
        SIXTEEN("16.", 16),
        SEVENTEEN("17.", 17),
        EIGHTEEN("18.", 18),
        NINETEEN("19.", 19),
        TWENTY("20.", 20),
        U("", 0);  // Placeholder for invalid

        companion object : NumeralParser<IntegerNumeral> {
            override fun fromNumeral(numeral: String): IntegerNumeral {
                return IntegerNumeral.entries.find { it.numeral == numeral } ?: U
            }
        }
    }

    enum class LowercaseAlphabeticNumeral(override val numeral: String, override val value: Int) : Numeral<LowercaseAlphabeticNumeral> {
        a_("a.", 1),
        b_("b.", 2),
        c_("c.", 3),
        d_("d.", 4),
        e_("e.", 5),
        f_("f.", 6),
        g_("g.", 7),
        h_("h.", 8),
        i_("i.", 9),
        j_("j.", 10),
        k_("k.", 11),
        l_("l.", 12),
        m_("m.", 13),
        n_("n.", 14),
        o_("o.", 15),
        p_("p.", 16),
        q_("q.", 17),
        r_("r.", 18),
        s_("s.", 19),
        t_("t.", 20),
        U("", 0);  // Placeholder for invalid

        companion object : NumeralParser<LowercaseAlphabeticNumeral> {
            override fun fromNumeral(numeral: String): LowercaseAlphabeticNumeral {
                return LowercaseAlphabeticNumeral.entries.find { it.numeral == numeral } ?: U
            }
        }
    }

    enum class LowercaseParenthesizedAlphabeticNumeral(override val numeral: String, override val value: Int) : Numeral<LowercaseAlphabeticNumeral> {
        a__("(a)", 1),
        b__("(b)", 2),
        c__("(c)", 3),
        d__("(d)", 4),
        e__("(e)", 5),
        f__("(f)", 6),
        g__("(g)", 7),
        h__("(h)", 8),
        i__("(i)", 9),
        j__("(j)", 10),
        k__("(k)", 11),
        l__("(l)", 12),
        m__("(m)", 13),
        n__("(n)", 14),
        o__("(o)", 15),
        p__("(p)", 16),
        q__("(q)", 17),
        r__("(r)", 18),
        s__("(s)", 19),
        t__("(t)", 20),
        U("", 0);  // Placeholder for invalid

        companion object : NumeralParser<LowercaseParenthesizedAlphabeticNumeral> {
            override fun fromNumeral(numeral: String): LowercaseParenthesizedAlphabeticNumeral {
                return LowercaseParenthesizedAlphabeticNumeral.entries.find { it.numeral == numeral } ?: U
            }
        }
    }

    private val input: String
    private var pos = 0

    init {
        this.input = input.replace("\\s+".toRegex(), " ").trim { it <= ' ' }
    }

    fun toMarkdown(): String {
        val sb = StringBuilder()
        if (input.startsWith("Contents: ")) {
            sb.append("# Contents\n")
            pos += "Contents: ".length
        }

        val levelStack = Stack<Int?>()
        levelStack.push(0)

        while (pos < input.length) {
            skipSpaces()
            if (pos >= input.length) break

            val c = input.get(pos)
            var prefix = ""
            var thisLevel = -1

            // Try to parse Roman numeral first
            val roman = parseRoman()
            if (!roman.isEmpty()) {
                prefix = roman + ". "
                thisLevel = 2
            } else if (Character.isUpperCase(c)) {
                // Single uppercase for level 1
                val start = pos
                pos++
                var hasDot = false
                if (pos < input.length && input.get(pos) == '.') {
                    hasDot = true
                    pos++
                }
                prefix = input.substring(start, start + 1) + (if (hasDot) ". " else " ")
                thisLevel = 1
            } else if (Character.isDigit(c)) {
                // Number for level 3
                val start = pos
                while (pos < input.length && Character.isDigit(input.get(pos))) pos++
                val num = input.substring(start, pos)
                if (pos < input.length && input.get(pos) == '.') {
                    pos++
                }
                prefix = num + ". "
                thisLevel = 3
            } else if (Character.isLowerCase(c) && pos + 1 < input.length && input.get(pos + 1) == '.') {
                // Lowercase letter for level 4
                prefix = input.get(pos).toString() + ". "
                pos += 2
                thisLevel = 4
            } else if (c == '(' && pos + 2 < input.length && Character.isLowerCase(input.get(pos + 1)) && input.get(pos + 2) == ')') {
                // Parenthesized lowercase for level 5
                prefix = "(" + input.get(pos + 1) + ") "
                pos += 3
                thisLevel = 5
            } else {
                // Unknown, skip
                pos++
                continue
            }

            skipSpaces()

            // Get title with special handling for :
            val titleBuilder = StringBuilder()
            while (pos < input.length) {
                val ch = input.get(pos)
                if (ch == ';' || ch == '.') {
                    break
                }
                if (ch == ':') {
                    var tempPos = pos + 1
                    while (tempPos < input.length && input.get(tempPos) == ' ') {
                        tempPos++
                    }
                    if (tempPos >= input.length) {
                        break
                    }
                    val nextC = input.get(tempPos)
                    var isSub = false
                    if (Character.isLowerCase(nextC) && tempPos + 1 < input.length && input.get(tempPos + 1) == '.') {
                        isSub = true
                    } else if (nextC == '(' && tempPos + 2 < input.length && Character.isLowerCase(input.get(tempPos + 1)) && input.get(
                            tempPos + 2
                        ) == ')'
                    ) {
                        isSub = true
                    } else if (Character.isDigit(nextC)) {
                        isSub = true
                    } else if ("IVXLCDM".indexOf(nextC) != -1) {
                        isSub = true
                    }
                    if (isSub) {
                        break
                    } else {
                        titleBuilder.append(':')
                        pos++
                        continue
                    }
                }
                titleBuilder.append(ch)
                pos++
            }
            val title = titleBuilder.toString().trim { it <= ' ' }

            // Consume separator if present
            var sep = ' '
            if (pos < input.length) {
                sep = input.get(pos)
                if (sep == ':' || sep == ';' || sep == '.') {
                    pos++
                }
            }

            // Handle hierarchy
            while (!levelStack.isEmpty() && levelStack.peek()!! >= thisLevel) {
                levelStack.pop()
            }
            levelStack.push(thisLevel)

            // Append to Markdown
            val indent = "  ".repeat(levelStack.size - 1)
            sb.append(indent).append("- ").append(prefix).append(title).append("\n")
        }

        return sb.toString()
    }

    private fun skipSpaces() {
        while (pos < input.length && input.get(pos) == ' ') pos++
    }

    private fun parseRoman(): String {
        val start = pos
        while (pos < input.length && "IVXLCDM".indexOf(input.get(pos)) != -1) {
            pos++
        }
        val candidate = input.substring(start, pos)
        if (pos < input.length && input.get(pos) == '.' && isValidRoman(candidate)) {
            pos++
            return candidate
        }
        pos = start
        return ""
    }

    private fun isValidRoman(s: String): Boolean {
        if (s.isEmpty()) return false
        // Simple validation via conversion to int
        try {
            romanToInt(s)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    private fun romanToInt(s: String): Int {
        val map: MutableMap<Char?, Int?> = HashMap<Char?, Int?>()
        map.put('I', 1)
        map.put('V', 5)
        map.put('X', 10)
        map.put('L', 50)
        map.put('C', 100)
        map.put('D', 500)
        map.put('M', 1000)

        var num = 0
        var prev = 0
        for (i in s.length - 1 downTo 0) {
            val ch = s.get(i)
            require(map.containsKey(ch))
            val curr: Int = map.get(ch)!!
            if (curr < prev) {
                num -= curr
            } else {
                num += curr
            }
            prev = curr
        }
        return num
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val toc =
                "Contents: A πνεῦμα in the Greek World: I. The Meaning of the Term: 1. Wind ; 2. Breath ; 3. Life ; 4. Soul ; 5. Transferred Meaning: Spirit ; 6. πνεῦμα and νοῦς; 7. μαντικὸν πνεῦμα; 8. θεῖον πνεῦμα; 9. θεὸς πνεῦμα; 10. Ungreek Development of the Meaning. II. πνεῦμα in Mythology and Religion: 1. Life-creating πνεῦμα; 2. πνεῦμα and Inspiration: a. In Poetry ; b. in Manticism. III. πνεῦμα in Natural Science and Philosophy. IV. The Greek Concept of Pneuma and the NT. B. Spirit in the OT: I. Review of the Term: 1. רוּחַ‎ in the OT: a. רוּחַ‎ as Breath, Wind: (a) Breath of the Mouth ; (b) Breath of Air, Wind ; b. רוּחַ‎ in Man: (a) The Principle which Gives Life to the Body ; (b) The Seat of Emotions, Intellectual Functions and Attitude of Will ; (c) Divinely Effected רוּחַ; c. The רוּחַ‎ of God: (a) Effective Divine Power ; (b) Specifically God’s Creative Power ; (c) The Inner Nature of God ; (d) רוּחַ‎ as Personal Being ; 2. נְשָׁמָה‎ in the OT: a. נְשָׁמָה‎ as Breath ; b. נְשָׁמָה‎ in Man ; c. The נְשָׁמָה‎ of God: (a) The Principle which Gives Physical Life ; (b) That which Gives Man Insight ; 3. א/ב‎ in the OT: a. Spirit of the Dead ; b. Conjurer up of Spirits of the Dead. II. The Spirit of God. C. Spirit in Judaism: I. πνεῦμα in the LXX: 1. The Translation of the Hebrew Terms in the LXX ; 2. πνεῦμα as Wind ; 3. πνεῦμα the Breath of Life ; 4. πνεῦμα as the Superhuman Power of Blessing and Punishment ; 5. πνεῦμα as Spiritual Ability, Resolve of the Will, Constitution of Soul ; 6. πνεῦμα as Eschatological Gift ; 7. πνεῦμα in Qoheleth ; 8. πνεῦμα in Wisdom. II. πνεῦμα in Hellenistic Judaism: 1. Philo; 2. Josephus. III. רוּחַ‎ in Palestinian Judaism: 1. Wind, Quarter of the World, Direction ; 2. Angels and Evil Spirits ; 3. The Deceased in the Grave ; 4. The Spirit of Man: a. Terminology ; b. Legacy of the OT ; c. Spirit and Body in Rabbinic Anthropology ; d. Age of the Idea of the Pre-existence and Immortality of the Soul ; e. The Historical Problem ; 5. The Spirit of God: a. Terminology ; b. The Works of the Spirit ; c. The Spirit and the OT ; d. The Spirit and Righteousness ; e. Endowment with the Spirit in Past, Future and Present ; f. The Cosmic Function of the Spirit ; g. The Autonomy of the Spirit ; h. The Spirit as Advocate. D. Development to the Pneumatic Self in Gnosticism: I. The Dead Sea Scrolls and Their Influence ; II. Gnosticism: 1. The Problem: The Spirit as Creator of Matter ; 2. The Redemption of the πνεῦμα from Matter ; 3. Trichotomy. E. The New Testament: I. Mark and Matthew: 1. The Demonic and the Anthropological Spirit ; 2. The Spirit as the Power of God ; 3. General Endowment with the Spirit ; 4. Jesus’ Endowment with the Spirit at Baptism ; 5. Verses Peculiar to Matthew ; 6. Jesus’ Supernatural Conception by the Spirit ; 7. Summary. II. Luke and Acts: 1. The Relation of the Spirit to Jesus ; 2. The Abiding of the Spirit with the Community ; 3. The Outward Manifestations of the Spirit ; 4. The Works of the Spirit ; 5. The Spirit as a Feature of the Age of the Church ; 6. The Reception of the Spirit ; 7. Different Meanings of πνεῦμα. III. Paul: 1. The OT and Hellenistic Strands: a. The Problem ; b. Adoption of Hellenistic Ideas in Paul ; c. Correction in the Light of Primitive Christian Eschatology ; d. πνεῦμα as a Sign of What is to Come ; 2. Paul’s Own Interpretation: a. The Problem ; b. πνεῦμα as the Power of πιστις ; c. πνεῦμα as Renunciation of the σάρξ; d. πνεῦμα as Openness for God and One’s Neighbour ; 3. The Relation of the Spirit to Christ ; 4. The Anthropological πνεῦμα ; 5. πνευματικός. IV. John: 1. The Significance of Eschatology ; 2. πνεῦμα as a Sphere in Antithesis to σάρξ; 3. πνεῦμα as a Life-Giving Power in Antithesis to σάρξ; 4. The Paraclete. V. The Rest of the New Testament: 1. The Pauline Circle: a. Ephesians ; b. The Pastorals ; 2. Hebrews ; 3. The Catholic Epistles: a. James ; b. 1 Peter ; c. 2 Peter ; d. 1 John ; 4. Revelation. F. The Post-Apostolic Fathers: 1. The Gnostic-Substantial Line ; 2. The Ecstatic Line ; 3. The Official Line."
            val parser = TocParserKt(toc)
            println(parser.toMarkdown())
        }
    }
}
