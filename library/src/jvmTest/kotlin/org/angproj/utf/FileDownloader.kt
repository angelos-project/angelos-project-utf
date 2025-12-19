package org.angproj.utf

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


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
class FileDownloaderKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            /*if (args.size != 1) {
                println("Usage: java FileDownloader <URL>")
                System.exit(1)
            }*/
            val saveDir: Path = Paths.get(System.getProperty("user.home"), ".myapp", "downloads");
            println(saveDir)

            val fileUrl = "https://www.unicode.org/Public/17.0.0/ucd/Blocks.txt" // args[0]
            val resourcesPath = "src/main/resources"

            try {
                // Ensure the resources directory exists
                Files.createDirectories(Paths.get(resourcesPath))

                // Download and get the suggested filename
                val fileName = downloadFile(fileUrl, resourcesPath)
                println("File downloaded successfully: " + resourcesPath + "/" + fileName)
            } catch (e: IOException) {
                System.err.println("Error downloading file: " + e.message)
                e.printStackTrace()
            }
        }

        @Throws(IOException::class)
        private fun downloadFile(fileUrl: String, saveDir: String?): String {
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
}