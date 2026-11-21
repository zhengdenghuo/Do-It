package at.co.schwaerzler.maximilian.doit.ui.cashier

import android.media.AudioManager
import android.media.ToneGenerator
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import at.co.schwaerzler.maximilian.doit.pos.DeviceCode
import at.co.schwaerzler.maximilian.doit.pos.ScanLine
import at.co.schwaerzler.maximilian.doit.pos.UhfScanReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
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
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var status by remember { mutableStateOf("扫码头准备中") }
    var ready by remember { mutableStateOf(false) }
    var codes by remember { mutableStateOf<List<DeviceCode>>(emptyList()) }
    var codesReady by remember { mutableStateOf(false) }
    val seenHolder = remember { mutableStateOf<List<String>>(emptyList()) }
    val linesHolder = remember { mutableStateOf<List<ScanLine>>(emptyList()) }
    var submitting by remember { mutableStateOf(false) }
    var lastConfirm by remember { mutableStateOf(0L) }
    val seen = seenHolder.value
    val plate = matchPlates(codes, seen, tableId)
    SideEffect { linesHolder.value = plate }

    LaunchedEffect(tableId) {
        vm.repository.openScan(tableId).orToast(vm.repository)
        codes = vm.repository.deviceCodes(tableId).orToast(vm.repository).orEmpty()
        codesReady = true
    }

    DisposableEffect(tableId) {
        val reader = UhfScanReader(context)
        val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 80)
        val job: Job = scope.launch(Dispatchers.IO) {
            val opened = reader.open()
            withContext(Dispatchers.Main) {
                ready = opened
                status = reader.status
            }
            if (!opened) return@launch
            while (isActive) {
                val tags = try {
                    reader.inventory()
                } catch (cancelled: CancellationException) {
                    throw cancelled
                } catch (_: Exception) {
                    delay(200)
                    emptyList()
                }
                if (tags.isNotEmpty()) {
                    withContext(Dispatchers.Main) {
                        val known = seenHolder.value
                        val fresh = tags.filter { it !in known }
                        if (fresh.isNotEmpty()) {
                            seenHolder.value = known + fresh
                            tone.startTone(ToneGenerator.TONE_PROP_BEEP, 80)
                        }
                    }
                }
            }
        }
        val upload = scope.launch(Dispatchers.IO) {
            while (isActive) {
                val lines = linesHolder.value
                if (lines.isNotEmpty()) {
                    vm.repository.saveScanLines(tableId, lines)
                }
                delay(1000)
            }
        }
        onDispose {
            job.cancel()
            upload.cancel()
            tone.release()
            Thread {
                reader.close()
                kotlinx.coroutines.runBlocking(Dispatchers.IO) {
                    vm.repository.closeScan(tableId)
                }
            }.start()
        }
    }

    Scaffold(
        topBar = { CashierTopBar(tableNo.ifBlank { "扫盘" }, onBack = onBack) },
        bottomBar = {
            Column(Modifier.fillMaxWidth().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("合计 ${money(plate.sumText())}", fontWeight = FontWeight.Bold)
                Button(
                    onClick = {
                        val now = System.currentTimeMillis()
                        if (submitting || now - lastConfirm < 1000) return@Button
                        val picked = plate.filter { it.qty > 0 }
                        if (picked.isEmpty()) {
                            vm.repository.toast("还没有扫到盘子")
                            return@Button
                        }
                        lastConfirm = now
                        submitting = true
                        scope.launch {
                            vm.repository.addDeviceOrder(picked).orToast(vm.repository)?.let {
                                vm.repository.toast("扫盘成功")
                                onDone()
                            }
                            submitting = false
                        }
                    },
                    enabled = ready && !submitting,
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
            item { Text(status) }
            val visible = plate.filter { it.qty > 0 }
            if (!codesReady) {
                item { Text("正在读取盘子规则") }
            } else if (codes.isEmpty()) {
                item { Text("这桌没有配置盘子") }
            } else if (visible.isEmpty()) {
                item { Text("请把盘子放到扫码头上") }
            }
            items(visible, key = { it.productId + it.deviceNos.joinToString() }) { line ->
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
}

private fun matchPlates(codes: List<DeviceCode>, epcs: List<String>, tableId: String): List<ScanLine> {
    val raw = mutableListOf<ScanLine>()
    codes.forEach { code ->
        val hits = epcs.filter { epc ->
            epc.length > 8 && epc.substring(4, 8).equals(code.ruleNo, ignoreCase = true)
        }
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
    return merged
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
