package at.co.schwaerzler.maximilian.doit.pos

import android.content.Context
import com.magicrf.uhfreaderlib.reader.ReaderPort
import java.io.File
import java.io.FileWriter
import java.io.InputStream
import java.io.OutputStream

/**
 * UHF 扫码头。上电写 `/dev/l550_card`，串口默认 `/dev/ttyS1` 115200，盘点指令与原收银包一致。
 */
class UhfScanReader(context: Context) {
    private val appContext = context.applicationContext
    private val lock = Any()
    private var port: ReaderPort? = null
    private var input: InputStream? = null
    private var output: OutputStream? = null

    var status: String = "扫码头准备中"
        private set

    fun open(): Boolean {
        val powered = power(true)
        if (!powered) status = "扫码头上电失败"
        val path = appContext.getSharedPreferences("portPath", Context.MODE_PRIVATE)
            .getString("portPath", DEFAULT_PORT)
            ?: DEFAULT_PORT
        return try {
            val reader = ReaderPort(path, BAUD, 0)
            synchronized(lock) {
                port = reader
                input = reader.inputStream
                output = reader.outputStream
            }
            if (powered) status = "扫码头已连接 $path"
            Thread.sleep(100)
            true
        } catch (_: Throwable) {
            status = "串口打开失败"
            false
        }
    }

    fun inventory(): List<String> {
        synchronized(lock) {
            val inputStream = input ?: return emptyList()
            val outputStream = output ?: return emptyList()
            send(outputStream, UNSELECT)
            readFrame(inputStream)
            send(outputStream, INVENTORY)
            val response = readFrame(inputStream) ?: return emptyList()
            return parseEpcs(response)
        }
    }

    fun close() {
        synchronized(lock) {
            runCatching { port?.close() }
            port = null
            input = null
            output = null
        }
        power(false)
    }

    private fun power(on: Boolean): Boolean {
        val file = File(POWER_NODE)
        if (!file.exists()) return true
        return try {
            FileWriter(file).use { it.write(if (on) "1" else "0") }
            true
        } catch (_: Exception) {
            false
        }
    }

    private fun send(outputStream: OutputStream, command: ByteArray) {
        outputStream.write(command)
        outputStream.flush()
    }

    private fun readFrame(inputStream: InputStream): ByteArray? {
        var available = 0
        run {
            repeat(10) {
                Thread.sleep(50)
                available = inputStream.available()
                if (available > 7) return@run
            }
        }
        Thread.sleep(50)
        val size = inputStream.available()
        if (size <= 0) return null
        val raw = ByteArray(size)
        val read = inputStream.read(raw)
        if (read <= 0) return null
        val head = raw.indexOfFirst { it == FRAME_BEGIN }
        if (head < 0) return null
        return raw.copyOfRange(head, read)
    }

    private fun parseEpcs(response: ByteArray): List<String> {
        if (response.size < 12) return emptyList()
        val epcs = mutableListOf<String>()
        var start = 0
        var remaining = response.size
        while (remaining > 11 && start + 4 < response.size) {
            val paraLen = response[start + 4].toInt() and 0xFF
            val cardLen = paraLen + 7
            if (cardLen > remaining || start + cardLen > response.size) break
            val card = response.copyOfRange(start, start + cardLen)
            val payload = handlerResponse(card)
            if (payload != null && paraLen > 5) {
                val epcLen = paraLen - 5
                if (payload.size >= 4 + epcLen) {
                    epcs += payload.copyOfRange(4, 4 + epcLen).toHex()
                }
            }
            start += cardLen
            remaining -= cardLen
        }
        return epcs
    }

    private fun handlerResponse(response: ByteArray): ByteArray? {
        val length = response.size
        if (length < 7) return null
        if (response[0] != FRAME_BEGIN || response[length - 1] != FRAME_END) return null
        val dataLength = ((response[3].toInt() and 0xFF) shl 8) or (response[4].toInt() and 0xFF)
        if (checksum(response) != response[length - 2]) return null
        if (dataLength == 0 || length != dataLength + 7) return null
        val data = ByteArray(dataLength + 1)
        data[0] = response[2]
        response.copyInto(data, destinationOffset = 1, startIndex = 5, endIndex = 5 + dataLength)
        return data
    }

    private fun checksum(data: ByteArray): Byte {
        var crc = 0
        for (index in 1 until data.size - 2) {
            crc += data[index].toInt()
        }
        return crc.toByte()
    }

    private fun ByteArray.toHex(): String = joinToString("") { "%02X".format(it.toInt() and 0xFF) }

    companion object {
        const val DEFAULT_PORT = "/dev/ttyS1"
        private const val POWER_NODE = "/dev/l550_card"
        private const val BAUD = 115200
        private const val FRAME_BEGIN = 0xBB.toByte()
        private const val FRAME_END = 0x7E.toByte()

        private val UNSELECT = byteArrayOf(
            FRAME_BEGIN, 0x00, 0x12, 0x00, 0x01, 0x01, 0x14, FRAME_END,
        )
        private val INVENTORY = byteArrayOf(
            FRAME_BEGIN, 0x00, 0x22, 0x00, 0x00, 0x22, FRAME_END,
        )
    }
}
