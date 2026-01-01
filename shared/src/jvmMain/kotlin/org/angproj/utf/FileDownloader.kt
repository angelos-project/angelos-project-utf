package org.angproj.utf

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Path
import java.nio.file.Paths


public enum class UnicodeVersion(public val version: String) {
    VERSION_17("17.0.0")
}

/**
 * A simple Java program that downloads a text file from a given URL
 * and saves it to the project's src/main/resources folder (during development),
 * preserving the original filename from the server.
 *
 * Note: This works when running from an IDE like Eclipse or IntelliJ,
 * where src/main/resources is writable. When running from a packaged JAR,
 * writing to resources is not possible (resources are inside the JAR).
 *
 * Usage: Provide the URL as a command-line argument, e.g.:
 * java FileDownloader https://example.com/data.txt
 */
public object FileDownloader {

    public val version: String = UnicodeVersion.VERSION_17.version

    public fun downloadUnicodeBlocksFile(resourcePath: Path) {
        val fileUrl = "https://www.unicode.org/Public/${version}/ucd/Blocks.txt" // args[0]

        downloadFile(fileUrl, resourcePath.toString())
    }

    public fun downloadUnicodeIso15924File(resourcePath: Path) {
        val fileUrl = "https://www.unicode.org/iso15924/iso15924.txt"

        downloadFile(fileUrl, resourcePath.toString())
    }

    public fun downloadUnicodeIso6393File(resourcePath: Path) {
        val fileUrl = "https://iso639-3.sil.org/sites/iso639-3/files/downloads/iso-639-3.tab"

        downloadFile(fileUrl, resourcePath.toString())
    }

    public fun downloadUnicodePLAFile(resourcePath: Path) {
        val fileUrl = "https://www.unicode.org/Public/${version}/ucd/PropertyValueAliases.txt"

        downloadFile(fileUrl, resourcePath.toString())
    }

    public fun downloadUnicodeDerivedGeneralCategoryFile(resourcePath: Path) {
        val fileUrl = "https://www.unicode.org/Public/${version}/ucd/extracted/DerivedGeneralCategory.txt"

        downloadFile(fileUrl, resourcePath.toString())
    }

    @Throws(IOException::class)
    public fun downloadFile(fileUrl: String, saveDir: String): String {
        val url = URL(fileUrl)
        val httpConn = url.openConnection() as HttpURLConnection
        val responseCode = httpConn.getResponseCode()

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw IOException("Server returned HTTP " + responseCode)
        }

        // Extract filename from Content-Disposition header if available
        val disposition = httpConn.getHeaderField("Content-Disposition")
        var fileName: String? = null

        if (disposition != null && disposition.contains("filename=")) {
            val index = disposition.indexOf("filename=")
            fileName = disposition.substring(index + 9).replace("\"".toRegex(), "")
        }

        // Fallback: extract from URL path
        if (fileName == null || fileName.isEmpty()) {
            val path = url.getPath()
            fileName = path.substring(path.lastIndexOf('/') + 1)
            if (fileName.isEmpty()) {
                fileName = "downloaded.txt" // default if no name
            }
        }

        // Save the file
        val saveFile = File(saveDir, fileName)

        httpConn.getInputStream().use { inputStream ->
            FileOutputStream(saveFile).use { outputStream ->
                val buffer = ByteArray(4096)
                var bytesRead: Int
                while ((inputStream.read(buffer).also { bytesRead = it }) != -1) {
                    outputStream.write(buffer, 0, bytesRead)
                }
            }
        }
        httpConn.disconnect()
        return fileName
    }
}