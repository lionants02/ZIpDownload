package max.download.zip

import org.junit.Ignore
import java.io.File
import java.net.URL

class ZIpDownloadTest {

    @Ignore("How to use")
    fun download() {
        val zd = ZIpDownload(URL("https://github.com/ffc-nectec/AirSyncLauncher/releases/download/0.0.1/t1.zip")) {
            println(it / (1024L * 1024L))
        }
        zd.download(File("temp"))
    }
}
