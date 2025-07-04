package org.angproj.utf.scr

import org.angproj.utf.Script
import org.angproj.utf.UtfBlock
import org.angproj.utf.blk.HighPrivateUseSurrogates
import org.angproj.utf.blk.HighSurrogates
import org.angproj.utf.blk.LowSurrogates
import org.angproj.utf.blk.PrivateUseArea
import org.angproj.utf.blk.SupplementaryPrivateUseAreaA
import org.angproj.utf.blk.SupplementaryPrivateUseAreaB

/**
 * Leave orphaned blocks orphaned, special cases that collide with security
 * */
public object OrphanedBlocks : Script {
    override val name: String = "Orphans"
    override val code: String = "Orph"
    override val no: Int = 0

    override val blocks: Set<UtfBlock> = setOf(
        HighPrivateUseSurrogates, HighSurrogates, LowSurrogates, PrivateUseArea,
        SupplementaryPrivateUseAreaA, SupplementaryPrivateUseAreaB,
    )
}