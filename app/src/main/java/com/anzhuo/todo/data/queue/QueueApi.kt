package com.anzhuo.todo.data.queue

import com.anzhuo.todo.data.ServerConfig
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class QueueApi {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        explicitNulls = false
    }

    fun fetchSummary(mac: String): QueueSummaryData {
        val encodedMac = URLEncoder.encode(mac, Charsets.UTF_8.name())
        val connection = (URL("${ServerConfig.BASE_URL.trimEnd('/')}$PATH?mac=$encodedMac").openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = 8_000
            readTimeout = 8_000
            setRequestProperty("Accept", "application/json")
        }
        val body = try {
            val stream = if (connection.responseCode in 200..299) {
                connection.inputStream
            } else {
                connection.errorStream
            }
            stream?.bufferedReader()?.use { it.readText() }.orEmpty()
        } finally {
            connection.disconnect()
        }
        val trimmed = body.trimStart()
        if (!trimmed.startsWith("{")) {
            if (body.contains("方法不存在") || body.contains("method not exists")) {
                throw IllegalStateException("服务端还没有排队汇总接口")
            }
            throw IllegalStateException("服务端返回了无法识别的内容")
        }
        val response = json.decodeFromString<QueueSummaryResponse>(body)
        if (response.code != 1) {
            throw IllegalStateException(response.msg.ifBlank { "获取排队信息失败" })
        }
        return response.data?.data ?: throw IllegalStateException("排队数据为空")
    }

    private companion object {
        const val PATH = "/index.php/device/tableDevice.TableDevice/queueTableSummary"
    }
}
