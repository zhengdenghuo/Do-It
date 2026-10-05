package com.anzhuo.todo.data.queue

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    val content: String = "",
    val logo: String = "",
    @SerialName("group_qrcode") val groupQrcode: String = "",
    @SerialName("group_text") val groupText: String = "",
    @SerialName("queue_text") val queueText: String = "",
    @SerialName("is_open") val isOpen: Int = 0,
    @SerialName("qrcode_url") val qrcodeUrl: String = "",
    @SerialName("queue_desc") val queueDesc: String = "",
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
