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

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory


object SupplementDataLoaderKt {

    private fun resourceStream(resourcePath: String): InputStream = ScriptLoader::class.java.getResourceAsStream(resourcePath)
        ?: throw IllegalArgumentException("Resource not found: $resourcePath")

    @Throws(Exception::class)
    fun main() {
        // Step 1: Load the XML as a resource from classpath (inside ICU4J JAR)
        val resourcePath = "/supplementalData.xml"

        // Adjust version if needed (e.g., icudt73l, icudt74l — check your ICU JAR)
        val inputStream = resourceStream(resourcePath)

        checkNotNull(inputStream) { "Cannot find supplementalData.xml at " + resourcePath }

        // Step 2: Parse the XML using only JDK classes
        val factory = DocumentBuilderFactory.newInstance()


        // Optional: Make it namespace-aware (supplementalData.xml uses namespaces)
        factory.setNamespaceAware(true)

        val builder = factory.newDocumentBuilder()
        val document: Document = builder.parse(inputStream)


        // Normalize the document (helps with text nodes)
        document.getDocumentElement().normalize()

        // Step 3: Example - Traverse and extract data
        val root: Element = document.getDocumentElement()
        println("Root element: " + root.getTagName()) // supplementalData

        // Example: Find all <currency> elements under currencyData/fractions
        val currencyNodes: NodeList = root.getElementsByTagName("currency")
        println("Found " + currencyNodes.getLength() + " <currency> elements")

        for (i in 0..<currencyNodes.getLength()) {
            val node: Node = currencyNodes.item(i)
            if (node.getNodeType() === Node.ELEMENT_NODE) {
                val currency: Element = node as Element
                val code: String? = currency.getAttribute("iso4217")
                println("Currency code: " + code)
            }
        }

        // Example: Get default digits for fractions
        val infoNodes: NodeList = document.getElementsByTagName("info")
        for (i in 0..<infoNodes.getLength()) {
            val info: Element = infoNodes.item(i) as Element
            if (info.hasAttribute("iso4217") && "_DEFAULT" == info.getAttribute("iso4217")) {
                val digits: String? = info.getAttribute("digits")
                val rounding: String? = info.getAttribute("rounding")
                println("Default fraction digits: " + digits + ", rounding: " + rounding)
            }
        }

        inputStream.close()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        try {
            main()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}