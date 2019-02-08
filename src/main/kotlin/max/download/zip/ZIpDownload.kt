package max.download.zip

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

/**
 * Support file only not support dir.
 */
class ZIpDownload(
    val url: URL,
    val callBackDelay: Long = 1000, // Default 1 sec
    val callBackDownloadSize: (Double) -> Unit = {}
) {
    fun download(destDir: File = File("temp.download")) {

        val webInputStream = MyBufferInputStream(url.openStream())

        Thread {
            while (true) {
                callBackDownloadSize(webInputStream.sizeLoad.toDouble())
                Thread.sleep(callBackDelay)
            }
        }.start()

        val zis = ZipInputStream(webInputStream)

        val buffer = ByteArray(1024)

        var zipEntry = zis.nextEntry
        while (zipEntry != null) {
            val newFile = newFile(destDir, zipEntry)
            val fos = FileOutputStream(newFile)
            var len: Int = zis.read(buffer)
            while (len > 0) {
                fos.write(buffer, 0, len)
                len = zis.read(buffer)
            }
            fos.close()
            zipEntry = zis.nextEntry
        }
        zis.closeEntry()
        zis.close()
    }

    private fun newFile(destinationDir: File, zipEntry: ZipEntry): File {
        val destFile = File(destinationDir.absolutePath, zipEntry.name)

        val destDirPath = destinationDir.canonicalPath
        val destFilePath = destFile.canonicalPath

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw IOException("Entry is outside of the target dir: " + zipEntry.name)
        }

        return destFile
    }
}
