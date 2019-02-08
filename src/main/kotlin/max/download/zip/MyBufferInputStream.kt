package max.download.zip

import java.io.BufferedInputStream
import java.io.InputStream

internal class MyBufferInputStream(`in`: InputStream?) : BufferedInputStream(`in`) {
    private var countByte: Long = 0

    val sizeLoad: Long get() = countByte

    override fun read(b: ByteArray?, off: Int, len: Int): Int {
        countByte += len
        return super.read(b, off, len)
    }
}
