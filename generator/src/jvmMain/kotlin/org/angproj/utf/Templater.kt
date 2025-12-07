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

import java.lang.System
import java.io.PrintWriter

fun copyrightNotice(pw: PrintWriter): String =  """/**
 * Copyright (c) 2024-${currentYear()} by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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
""".trimIndent()

fun currentYear(): Int = System.getProperty("year")?.toIntOrNull() ?: java.time.Year.now().value

fun packageName(pkgName: String): String = "package org.angproj.utf.$pkgName"

fun fileHeader(pw: PrintWriter, pkgName: String) {
    pw.println(copyrightNotice(pw))
    pw.println(packageName(pkgName))
    pw.println()
}