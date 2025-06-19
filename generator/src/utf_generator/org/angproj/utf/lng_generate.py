from natsort import os_sorted, as_utf8
from .block import parse_blk
from .script import parse_scr
from .iso15924 import parse_doc
from .supplementalData_language import parse_lang
from .iso639 import parse_iso


def tmpl_lngmap(short, long):
    short2long = ""
    for k, v in short.items():
        short2long += "        \"" + k + "\" to \"" + v + "\",\n"

    long2enum = ""
    for k, v in long.items():
        long2enum += "        \"" + k + "\" to " + v + ",\n"

    return f"""/**
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
import org.angproj.utf.Language.*


public abstract class LanguageMap {{
    protected val short2Long: Map<String, String> = hashMapOf(
{ short2long }
    )

    protected val long2Lang: Map<String, Language> = hashMapOf(
{ long2enum }
    )
}}
"""


def tmpl_lngenum(keys, langs):
    paths = "\nimport org.angproj.utf.lng.".join(keys)
    objs = ""
    for k in keys:
        objs += "    " + langs[k] + "(" + k + "),\n"

    return f"""/**
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

import org.angproj.utf.lng.{ paths }
import org.angproj.utf.lng.Undefined


public enum class Language(public val lang: UtfLanguage) {{
{ objs }    UNKNOWN(Undefined);
}}
"""


def tmpl_lng(klass, scrs, name, short, long):
    paths = "\nimport org.angproj.utf.scr.".join(scrs)
    objs = ", ".join(scrs)
    return f"""/**
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
package org.angproj.utf.lng

import org.angproj.utf.Script
import org.angproj.utf.UtfLanguage
import org.angproj.utf.scr.{ paths }

public object { klass } : UtfLanguage {{
    override val name: String = "{ name }"
    override val short: String = "{ short }"
    override val long: String = "{ long }"

    override val scripts: Set<Script> = setOf({ objs })
}}
"""


def lng_generate():
    lcc = parse_doc()
    lang = parse_lang()
    iso = parse_iso()

    enum = dict()
    short2long = dict()
    long2enum = dict()
    output = tmpl_lng(
        "Undefined",
        ["Common"],
        "Undefined",
        "",
        ""
    )
    with open("src/commonMain/kotlin/org/angproj/utf/lng/Undefined.kt", "w") as fd:
        fd.write(output)

    for k, v in lang.lang.items():
        if len(k) == 2:
            code = iso.short[k].long
            short2long[k] = code
        else:
            code = k

        enum[iso.long[code].klass] = iso.long[code].enum
        long2enum[code] = iso.long[code].enum

        l = list(set([lcc.code[x].klass if lcc.code[x].klass != '' else 'Han' for x in v]))
        l = os_sorted(l, key=as_utf8)
        output = tmpl_lng(
            iso.long[code].klass,
            l,
            iso.long[code].name,
            iso.long[code].short,
            iso.long[code].long
        )
        with open("src/commonMain/kotlin/org/angproj/utf/lng/" + iso.long[code].klass + ".kt", "w") as fd:
            fd.write(output)

    k = os_sorted(enum.keys(), key=as_utf8)
    output = tmpl_lngenum(k, enum)
    with open("src/commonMain/kotlin/org/angproj/utf/Language.kt", "w") as fd:
        fd.write(output)

    output = tmpl_lngmap(short2long, long2enum)
    with open("src/commonMain/kotlin/org/angproj/utf/LanguageMap.kt", "w") as fd:
        fd.write(output)