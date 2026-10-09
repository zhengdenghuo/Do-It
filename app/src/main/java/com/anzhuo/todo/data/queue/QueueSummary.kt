package com.anzhuo.todo.data.queue

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull

@Serializable
data class QueueSummaryResponse(
    val code: Int = 0,
    val msg: String = "",
    val data: QueueSummaryEnvelope? = null,
)

@Serializable
data class QueueSummaryEnvelope(
    val data: QueueSummaryData? = null,
)

@Serializable
data class QueueSummaryData(
    @SerialName("shop_name") val shopName: String = "",
    val content: String = "",
    val logo: String = "",
    @SerialName("banner_show_type") val bannerShowType: Int = 1,
    @SerialName("banner_config") val bannerConfig: JsonElement? = null,
    @SerialName("banner_string") val bannerString: JsonElement? = null,
    @SerialName("group_qrcode") val groupQrcode: String = "",
    @SerialName("group_text") val groupText: String = "",
    @SerialName("group_top_desc") val groupTopDesc: String = "",
    @SerialName("group_left_desc") val groupLeftDesc: String = "",
    @SerialName("queue_text") val queueText: String = "",
    @SerialName("is_open") val isOpen: Int = 0,
    @SerialName("qrcode_url") val qrcodeUrl: String = "",
    @SerialName("queue_desc") val queueDesc: String = "",
    @SerialName("queue_top_desc") val queueTopDesc: String = "",
    @SerialName("queue_left_desc") val queueLeftDesc: String = "",
    @SerialName("signed_count") val signedCount: Int = 0,
    @SerialName("unsigned_count") val unsignedCount: Int = 0,
    @SerialName("total_count") val totalCount: Int = 0,
    @SerialName("table_list") val tableList: List<QueueTableItem> = emptyList(),
)

@Serializable
data class QueueTableItem(
    @SerialName("table_id") val tableId: Int = 0,
    @SerialName("table_name") val tableName: String = "",
    val prefix: String = "",
    @SerialName("min_num") val minNum: Int = 0,
    @SerialName("max_num") val maxNum: Int = 0,
    @SerialName("signed_count") val signedCount: Int = 0,
    @SerialName("total_count") val totalCount: Int = 0,
    @SerialName("signed_list") val signedList: List<QueueSignedItem> = emptyList(),
)

@Serializable
data class QueueSignedItem(
    @SerialName("record_id") val recordId: Int = 0,
    @SerialName("queue_no_text") val queueNoText: String = "",
    val status: Int = 20,
    @SerialName("status_text") val statusText: String = "",
)

/** is_open 为 1 时取第一份，其他状态取第二份。支持 {"1":"...","2":"..."}、数组，或包在字符串里的 JSON。 */
internal fun JsonElement?.bannerVariant(isOpen: Int): String {
    if (this == null || this is JsonNull) return ""
    val open = isOpen == 1
    return when (this) {
        is JsonObject -> {
            val key = if (open) "1" else "2"
            this[key].asBannerText().ifBlank {
                val values = values.toList()
                values.getOrNull(if (open) 0 else 1).asBannerText()
                    .ifBlank { values.firstOrNull().asBannerText() }
            }
        }
        is JsonArray -> {
            getOrNull(if (open) 0 else 1).asBannerText()
                .ifBlank { firstOrNull().asBannerText() }
        }
        is JsonPrimitive -> {
            val raw = contentOrNull.orEmpty()
            val nested = raw.trimStart()
            if (nested.startsWith("{") || nested.startsWith("[")) {
                val parsed = runCatching { Json.parseToJsonElement(raw) }.getOrNull()
                if (parsed != null && parsed !is JsonPrimitive) return parsed.bannerVariant(isOpen)
            }
            raw
        }
    }
}

private fun JsonElement?.asBannerText(): String {
    val primitive = this as? JsonPrimitive ?: return ""
    return primitive.contentOrNull.orEmpty()
}
