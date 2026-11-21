package at.co.schwaerzler.maximilian.doit.ui.cashier

import android.media.AudioManager
import android.media.ToneGenerator
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import at.co.schwaerzler.maximilian.doit.pos.DeviceCode
import at.co.schwaerzler.maximilian.doit.pos.ScanLine
import at.co.schwaerzler.maximilian.doit.pos.UhfScanReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import kotlin.coroutines.cancellation.CancellationException

@Composable
fun ScanPlateScreen(
    tableId: String,
    tableNo: String,
    onBack: () -> Unit,
    onDone: () -> Unit,
) {
    val repository = cashierViewModel().repository
    val scope = rememberCoroutineScope()
    val context = LocalContext.current.applicationContext
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    var status by remember { mutableStateOf("扫码头准备中") }
    var ready by remember { mutableStateOf(false) }
    var sessionOpen by remember { mutableStateOf(false) }
    var sessionFailed by remember { mutableStateOf(false) }
    var codes by remember { mutableStateOf<List<DeviceCode>?>(null) }
    var codesFailed by remember { mutableStateOf(false) }
    var sessionAttempt by remember { mutableIntStateOf(0) }
    var codeAttempt by remember { mutableIntStateOf(0) }
    var readerAttempt by remember { mutableIntStateOf(0) }
    var seen by remember { mutableStateOf<Set<String>>(emptySet()) }
    var submitting by remember { mutableStateOf(false) }
    var submitted by remember { mutableStateOf(false) }
    var acknowledgedUnmatched by remember { mutableStateOf(false) }
    val networkWrites = remember { Mutex() }
    val result = remember(codes, seen, tableId) { matchPlates(codes.orEmpty(), seen, tableId) }
    val latestLines by rememberUpdatedState(result.lines)
    val knownRules = !codes.isNullOrEmpty()
    val showUnmatched = knownRules && result.unmatched > 0 && !acknowledgedUnmatched && !submitting

    BackHandler(enabled = submitting) {}

    LaunchedEffect(tableId, sessionAttempt) {
        scanSessionAccess.withLock {
            var opened = false
            sessionFailed = false
            try {
                withContext(NonCancellable) {
                    opened = repository.openScan(tableId).orToast(repository) != null
                }
                sessionOpen = opened
                sessionFailed = !opened
                if (opened) awaitCancellation()
            } finally {
                if (opened) {
                    withContext(NonCancellable) {
                        networkWrites.withLock { repository.closeScan(tableId).orToast(repository) }
                    }
                }
            }
        }
    }

    LaunchedEffect(tableId, sessionOpen, codeAttempt) {
        if (!sessionOpen) return@LaunchedEffect
        codesFailed = false
        codes = repository.deviceCodes(tableId).orToast(repository)
        codesFailed = codes == null
    }

    LaunchedEffect(lifecycle, sessionOpen, readerAttempt) {
        if (!sessionOpen) return@LaunchedEffect
        lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            scanReaderAccess.withLock {
                val reader = UhfScanReader(context)
                val tone = runCatching { ToneGenerator(AudioManager.STREAM_MUSIC, 80) }.getOrNull()
                try {
                    status = "正在连接扫码头"
                    ready = withContext(Dispatchers.IO) { reader.open() }
                    status = reader.status
                    if (!ready) return@withLock
                    while (isActive) {
                        val tags = try {
                            withContext(Dispatchers.IO) { reader.inventory() }
                        } catch (cancelled: CancellationException) {
                            throw cancelled
                        } catch (_: Exception) {
                            status = "扫码头读取失败，请刷新连接"
                            break
                        }
                        val fresh = tags.map { it.uppercase() }.filterNot { it in seen }
                        if (fresh.isNotEmpty()) {
                            seen = seen + fresh
                            tone?.startTone(ToneGenerator.TONE_PROP_BEEP, 80)
                        }
                        delay(20)
                    }
                } finally {
                    ready = false
                    tone?.release()
                    withContext(NonCancellable + Dispatchers.IO) { reader.close() }
                }
            }
        }
    }

    LaunchedEffect(lifecycle, tableId, sessionOpen, knownRules) {
        if (!sessionOpen || !knownRules) return@LaunchedEffect
        lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            while (isActive) {
                networkWrites.withLock {
                    if (ready && !submitting && !submitted) {
                        repository.saveScanLines(tableId, latestLines)
                    }
                }
                delay(1000)
            }
        }
    }

    val visible = result.lines.filter { it.qty > 0 }
    Scaffold(
        topBar = {
            CashierTopBar(tableNo.ifBlank { "扫盘" }, onBack = { if (!submitting) onBack() }) {
                TextButton(enabled = !submitting && (sessionOpen || sessionFailed), onClick = {
                    if (sessionFailed) sessionAttempt++
                    if (codesFailed) codeAttempt++
                    readerAttempt++
                }) { Text("刷新") }
            }
        },
        bottomBar = {
            Column(Modifier.fillMaxWidth().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("已扫 ${visible.sumOf { it.qty }} 盘 · 合计 ${money(visible.sumText())}", fontWeight = FontWeight.Bold)
                Button(
                    onClick = {
                        if (submitting || submitted || visible.isEmpty()) return@Button
                        submitting = true
                        scope.launch {
                            try {
                                networkWrites.withLock {
                                    if (repository.addDeviceOrder(visible).orToast(repository) != null) {
                                        submitted = true
                                        repository.toast("扫盘成功")
                                        onDone()
                                    }
                                }
                            } finally {
                                submitting = false
                            }
                        }
                    },
                    enabled = sessionOpen && knownRules && !submitting && !submitted && visible.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth(),
                ) { Text(if (submitting) "提交中" else "确认扫盘") }
            }
        },
    ) { padding ->
        LazyColumn(
            Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                Text(when {
                    sessionFailed -> "未能开启扫盘，请刷新"
                    !sessionOpen -> "正在开启扫盘"
                    codesFailed -> "无法读取盘子规则，请刷新"
                    codes == null -> "正在读取盘子规则"
                    !knownRules -> "这桌没有配置盘子"
                    else -> status
                })
            }
            if (knownRules && ready && visible.isEmpty()) item { Text("请把盘子放到扫码头上") }
            if (knownRules && result.unmatched > 0) item { Text("有 ${result.unmatched} 个未入库盘子") }
            items(visible, key = { it.productId }) { line ->
                Card {
                    Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("${line.name}", fontWeight = FontWeight.Medium)
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("${money(line.price)}/个")
                            Text("x${line.qty}")
                            Text(money(line.amount()))
                        }
                    }
                }
            }
        }
    }
    if (showUnmatched) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text("发现未入库盘子") },
            text = { Text("有 ${result.unmatched} 个盘子未入库，请上报并保留这些盘子，结账后核查。") },
            confirmButton = { TextButton(onClick = { acknowledgedUnmatched = true }) { Text("确定") } },
        )
    }
}

private val scanReaderAccess = Mutex()
private val scanSessionAccess = Mutex()

private data class PlateMatch(val lines: List<ScanLine>, val unmatched: Int)

private fun matchPlates(codes: List<DeviceCode>, epcs: Set<String>, tableId: String): PlateMatch {
    val byRule = epcs.filter { it.length > 8 }.groupBy { it.substring(4, 8) }
    val rules = codes.map { it.ruleNo.uppercase() }.toSet()
    val unmatched = epcs.count { it.length <= 8 || it.substring(4, 8) !in rules }
    val raw = mutableListOf<ScanLine>()
    codes.forEach { code ->
        val hits = byRule[code.ruleNo.uppercase()].orEmpty()
        if (hits.isEmpty()) {
            raw += code.toLine(tableId, 0, emptyList())
        } else {
            hits.forEach { epc -> raw += code.toLine(tableId, 1, listOf(epc)) }
        }
    }
    val merged = mutableListOf<ScanLine>()
    raw.forEach { item ->
        val index = merged.indexOfFirst { it.productId == item.productId }
        if (index >= 0) {
            val current = merged[index]
            merged[index] = current.copy(
                qty = current.qty + item.qty,
                deviceNos = current.deviceNos + item.deviceNos,
            )
        } else {
            merged += item
        }
    }
    return PlateMatch(merged, unmatched)
}

private fun DeviceCode.toLine(tableId: String, qty: Int, deviceNos: List<String>) = ScanLine(
    productId = productId,
    skuId = skuId,
    price = price,
    name = name,
    icon = icon,
    tableId = tableId,
    qty = qty,
    deviceNos = deviceNos,
)

private fun ScanLine.amount(): String {
    val price = price.toBigDecimalOrNull() ?: BigDecimal.ZERO
    return price.multiply(BigDecimal(qty)).stripTrailingZeros().toPlainString()
}

private fun List<ScanLine>.sumText(): String {
    val total = fold(BigDecimal.ZERO) { acc, line ->
        val price = line.price.toBigDecimalOrNull() ?: BigDecimal.ZERO
        acc + price.multiply(BigDecimal(line.qty))
    }
    return total.stripTrailingZeros().toPlainString()
}
