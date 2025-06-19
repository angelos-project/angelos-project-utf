from natsort import os_sorted, as_utf8
from .block import parse_blk
from .script import parse_scr
from .iso15924 import parse_doc


def tmpl_scr(klass, blks, name, code, num):
    paths = "\nimport org.angproj.utf.blk.".join(blks)
    objs = ", ".join(blks)
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
package org.angproj.utf.scr

import org.angproj.utf.Script
import org.angproj.utf.UtfBlock
import org.angproj.utf.blk.{ paths }

public object { klass }: Script {{
    override val name: String = "{ name }"
    override val code: String = "{ code }"
    override val no: Int = { num }
    
    override val blocks: Set<UtfBlock> = setOf({ objs })
}}
"""


def scr_generate():
    blks = parse_blk()
    scrs = parse_scr()
    lcc = parse_doc()

    scripts = {k: list() for k in scrs.klass.keys()}
    for scr in scrs.data:
        for b in blks.data:
            reserved = set(list(range(b.range[0], b.range[1] + 1)))
            if len(reserved.intersection(scr.points)) > 0:
                scripts[scr.klass].append(b.klass)

    for k, v in scripts.items():
        if k in lcc.klass.keys():
            lc = lcc.klass[k]
        else:
            lc = lcc.num[999]
        v = os_sorted(v, key=as_utf8)
        output = tmpl_scr(k, v, scrs.klass[k].name if lc.num == 999 else lc.en, lc.code, lc.num)
        with open("src/commonMain/kotlin/org/angproj/utf/scr/" + k + ".kt", "w") as fd:
            fd.write(output)