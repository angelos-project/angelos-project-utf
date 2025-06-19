from .block import parse_blk
from .script import parse_scr


def tmpl(klass, name, meta, rng, ctrl, use):
    return f"""/**
 * Copyright (c) 2024-2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
package org.angproj.utf.blk

import org.angproj.utf.UtfBlock

public object {klass}: UtfBlock {{
    override val name: String = "{name}"
    override val meta: String = "{meta}"
    override val range: IntRange = {rng}
    override val noCtrl: Boolean = {ctrl}
    override val noUse: Set<Int> by lazy {{ hashSetOf({use}) }}
}}
"""


noctrl = {
    "High Surrogates",
    "High Private Use Surrogates",
    "Low Surrogates",
    "Private Use Area",
    "Enclosed Ideographic Supplement",
    "Supplementary Private Use Area-A",
    "Supplementary Private Use Area-B"
}


def reduce_start(cp, r):
    for i in range(r[0], r[1]):
        if i in cp: return i
    return r[1]


def reduce_end(cp, r):
    for i in range(r[1], r[0], -1):
        if i in cp: return i
    return r[0]


def blk_generate():
    blks = parse_blk()
    scrs = parse_scr()

    cp = set()
    for sd in scrs.data:
        cp |= sd.points
    cp = frozenset(cp)

    for blk in blks.data:
        limit = (reduce_start(cp, blk.range), reduce_end(cp, blk.range))
        reserved = list()
        for i in range(blk.range[0], blk.range[1]+1):
            if i not in cp:
                reserved.append(i)
        meta = "{}..{} ({}/{})".format(
            hex(blk.range[0]),
            hex(blk.range[1]),
            blk.range[1] - blk.range[0] - len(reserved)+1,
            len(reserved)
        )
        noCtrl = len(reserved) == blk.range[1] - blk.range[0] + 1
        ctrl = "true" if noCtrl or blk.name in noctrl else "false"
        rl = blk.range if noCtrl else limit
        rrl = "{}..{}".format(hex(rl[0]), hex(rl[1]))
        reserved2 = list()
        for i in range(limit[0], limit[1]+1):
            if i not in cp:
                reserved2.append(i)
        noUse = ", ".join([hex(p) for p in reserved2])

        output = tmpl(blk.klass, blk.name, meta, rrl, ctrl, noUse)
        with open("src/commonMain/kotlin/org/angproj/utf/blk/" + blk.klass + ".kt", "w") as fd:
            fd.write(output)