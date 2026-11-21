package at.co.schwaerzler.maximilian.doit.ui.cashier

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LifecycleResumeEffect
import at.co.schwaerzler.maximilian.doit.R
import at.co.schwaerzler.maximilian.doit.pos.DiningTable
import at.co.schwaerzler.maximilian.doit.pos.ConsumptionGroup
import at.co.schwaerzler.maximilian.doit.pos.FinishedOrder
import at.co.schwaerzler.maximilian.doit.pos.GroupCouponType
import at.co.schwaerzler.maximilian.doit.pos.MemberCoupon
import at.co.schwaerzler.maximilian.doit.pos.OrderSummary
import at.co.schwaerzler.maximilian.doit.pos.PayMethod
import at.co.schwaerzler.maximilian.doit.pos.PaymentLine
import at.co.schwaerzler.maximilian.doit.pos.SettleOrder
import at.co.schwaerzler.maximilian.doit.pos.TableOrder
import at.co.schwaerzler.maximilian.doit.pos.OrderLine
import at.co.schwaerzler.maximilian.doit.pos.cashierField
import kotlin.math.roundToInt
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.JsonObject

@Composable
fun OrderDetailScreen(
    tableId: String,
    tableNo: String,
    onBack: () -> Unit,
    onMenu: () -> Unit,
    onGift: (orderId: String) -> Unit,
    onSettle: (orderId: String, supplierId: String, userId: String) -> Unit,
    onSwitch: (orderId: String) -> Unit,
    onMerge: (orderId: String) -> Unit,
    onCoupon: (orderId: String, tableId: String, supplierId: String, userId: String) -> Unit,
    onScan: () -> Unit,
) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var order by remember { mutableStateOf<TableOrder?>(null) }
    var guests by remember { mutableStateOf("") }
    var askScan by remember { mutableStateOf(false) }
    var returning by remember { mutableStateOf<at.co.schwaerzler.maximilian.doit.pos.OrderLine?>(null) }
    var returnQty by remember { mutableStateOf("1") }
    var returnPrint by remember { mutableStateOf(false) }
    var editingGuests by remember { mutableStateOf(false) }
    var closing by remember { mutableStateOf(false) }
    var clearPlatesClosesOrder by remember { mutableStateOf<Boolean?>(null) }
    var clearingPlates by remember { mutableStateOf(false) }
    var checkingAverage by remember { mutableStateOf(false) }
    var seasoningWarning by remember { mutableStateOf<TableOrder?>(null) }
    var averageWarning by remember { mutableStateOf<TableOrder?>(null) }
    var more by remember { mutableStateOf(false) }
    var pickingReturn by remember { mutableStateOf(false) }
    var openSwipe by remember { mutableStateOf<String?>(null) }

    fun load() {
        scope.launch {
            order = vm.repository.orderOnTable(tableId).orToast(vm.repository)
            guests = order?.mealNum.orEmpty()
        }
    }

    LaunchedEffect(tableId) { load() }
    val current = order
    val desk = tableNo.substringBefore("(").ifBlank { current?.tableNo ?: "订单" }
    val maxGuests = tableNo.substringAfter("/", "").substringBefore(")").takeIf { tableNo.contains("/") }.orEmpty()
    val meal = current?.mealNum?.ifBlank { null } ?: tableNo.substringAfter("(", "").substringBefore("/").ifBlank { "" }
    val title = if (maxGuests.isNotBlank() && meal.isNotBlank()) "$desk($meal/$maxGuests)" else tableNo.ifBlank { desk }
    fun requireOrder(block: (orderId: String) -> Unit) {
        val id = current?.orderId.orEmpty()
        if (id.isBlank()) vm.repository.toast("还没有订单") else block(id)
    }

    fun checkAverage(snapshot: TableOrder) {
        if (checkingAverage) return
        checkingAverage = true
        scope.launch {
            try {
                when (vm.repository.isLowAverageSpend(snapshot.orderId).orToast(vm.repository)) {
                    true -> averageWarning = snapshot
                    false -> onSettle(snapshot.orderId, snapshot.shopSupplierId, snapshot.userId)
                    null -> Unit
                }
            } finally {
                checkingAverage = false
            }
        }
    }
    fun beginReturn(line: at.co.schwaerzler.maximilian.doit.pos.OrderLine) {
        returnQty = line.qty.substringBefore(".").ifBlank { "1" }
        returnPrint = false
        returning = line
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            Row(
                Modifier.fillMaxWidth().background(CashierHeader).height(52.dp).padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "‹",
                    modifier = Modifier.clickable(onClick = onBack).padding(horizontal = 14.dp),
                    color = Color.White,
                    fontSize = 28.sp,
                )
                Text(
                    title,
                    modifier = Modifier.weight(1f),
                    color = Color.White,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    "编辑人数",
                    modifier = Modifier.clickable { editingGuests = true }.padding(horizontal = 8.dp),
                    color = Color.White,
                    fontSize = 15.sp,
                )
            }
        },
        bottomBar = {
            Column(Modifier.fillMaxWidth().background(Color.White)) {
                HorizontalDivider(color = Color(0xFFE6E8EE))
                Row(
                    Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("已点${current?.productNum?.ifBlank { portionCount(current.lines) } ?: "0"}份", color = CashierText, fontSize = 16.sp)
                    Box(Modifier.weight(1f))
                    Text("小计：", color = CashierText, fontSize = 16.sp)
                    Text(
                        plainAmount(current?.payPrice.orEmpty()),
                        color = Color(0xFFE23B3B),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
                Box(Modifier.fillMaxWidth().height(168.dp)) {
                    Row(Modifier.fillMaxWidth().padding(top = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                        OrderDockAction("加菜", onMenu)
                        OrderDockAction("单品转台") { requireOrder(onMerge) }
                        Box(Modifier.width(84.dp))
                        OrderDockAction("换台") { requireOrder(onSwitch) }
                        OrderDockAction(if (checkingAverage) "核对中" else "结账") {
                            val snapshot = current
                            when {
                                snapshot == null || snapshot.orderId.isBlank() -> vm.repository.toast("还没有订单")
                                snapshot.hasSeasoningWarning -> seasoningWarning = snapshot
                                else -> checkAverage(snapshot)
                            }
                        }
                    }
                    ScanDockButton(Modifier.align(Alignment.TopCenter).padding(top = 18.dp)) { askScan = true }
                    Row(Modifier.align(Alignment.BottomStart).padding(start = 8.dp, bottom = 4.dp)) {
                        OrderDockAction("赠送") { requireOrder(onGift) }
                        OrderDockAction("退菜") {
                            val lines = current?.lines.orEmpty()
                            when {
                                lines.isEmpty() -> vm.repository.toast("还没有菜品")
                                lines.size == 1 -> beginReturn(lines.first())
                                else -> pickingReturn = true
                            }
                        }
                    }
                }
                Text(
                    if (more) "下拉收起" else "上滑展开",
                    modifier = Modifier.fillMaxWidth().clickable { more = !more }.padding(vertical = 8.dp),
                    color = CashierTextMuted,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                )
                if (more) {
                    Row(Modifier.fillMaxWidth().padding(bottom = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                        TextButton(onClick = {
                            requireOrder { id ->
                                onCoupon(id, tableId, current?.shopSupplierId.orEmpty(), current?.userId.orEmpty())
                            }
                        }) { Text("验券") }
                        TextButton(onClick = {
                            scope.launch {
                                vm.repository.printBill(current?.orderId.orEmpty()).orToast(vm.repository)
                                    ?.let { vm.repository.toast("打印成功") }
                            }
                        }) { Text("打印") }
                        TextButton(onClick = { closing = true }) { Text("关台") }
                        TextButton(
                            enabled = !clearingPlates && current?.lines?.any { it.scanned } == true,
                            onClick = {
                                clearingPlates = true
                                scope.launch {
                                    try {
                                        clearPlatesClosesOrder = vm.repository.clearPlatesClosesOrder(tableId).orToast(vm.repository)
                                    } finally {
                                        clearingPlates = false
                                    }
                                }
                            },
                        ) { Text("清盘") }
                    }
                }
            }
        },
    ) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding).background(Color.White)) {
            itemsIndexed(current?.lines.orEmpty(), key = { index, line -> "${line.orderProductId}#$index" }) { index, line ->
                SwipeDishRow(
                    line = line,
                    index = index,
                    open = openSwipe == line.orderProductId,
                    onOpen = { openSwipe = line.orderProductId },
                    onClose = { if (openSwipe == line.orderProductId) openSwipe = null },
                    onServe = {
                        openSwipe = null
                        scope.launch {
                            val result = if (line.served) {
                                vm.repository.undoServe(line.orderProductId, current?.orderId.orEmpty())
                            } else {
                                vm.repository.serve(line.orderProductId, current?.orderId.orEmpty())
                            }
                            result.orToast(vm.repository)?.let {
                                vm.repository.toast(if (line.served) "已撤销上菜" else "上菜成功")
                                load()
                            }
                        }
                    },
                    onReturn = {
                        openSwipe = null
                        beginReturn(line)
                    },
                )
            }
        }
    }

    if (editingGuests) {
        AlertDialog(
            onDismissRequest = { editingGuests = false },
            title = { Text("就餐人数") },
            text = {
                OutlinedTextField(guests, { guests = it }, label = { Text("人数") }, singleLine = true)
            },
            confirmButton = {
                TextButton(onClick = {
                    editingGuests = false
                    scope.launch {
                        vm.repository.changeGuestCount(current?.orderId.orEmpty(), guests).orToast(vm.repository)
                            ?.let { vm.repository.toast("修改人数成功"); load() }
                    }
                }) { Text("确定") }
            },
            dismissButton = { TextButton(onClick = { editingGuests = false }) { Text("取消") } },
        )
    }
    if (closing) {
        AlertDialog(
            onDismissRequest = { closing = false },
            title = { Text("关台") },
            text = { Text("确定将 $tableNo 关台吗？") },
            confirmButton = {
                TextButton(onClick = {
                    closing = false
                    scope.launch {
                        vm.repository.closeTable(tableId).orToast(vm.repository)?.let {
                            vm.repository.toast("已关台")
                            onBack()
                        }
                    }
                }) { Text("确定") }
            },
            dismissButton = { TextButton(onClick = { closing = false }) { Text("取消") } },
        )
    }
    if (askScan) {
        val desk = tableNo.substringBefore("(").ifBlank { tableNo }
        AlertDialog(
            onDismissRequest = { askScan = false },
            title = { Text("提示") },
            text = { Text("当前桌号为 $desk，确定扫盘吗?") },
            confirmButton = {
                TextButton(onClick = {
                    askScan = false
                    onScan()
                }) { Text("确定") }
            },
            dismissButton = { TextButton(onClick = { askScan = false }) { Text("取消") } },
        )
    }
    clearPlatesClosesOrder?.let { closesOrder ->
        AlertDialog(
            onDismissRequest = { if (!clearingPlates) clearPlatesClosesOrder = null },
            title = { Text("清盘") },
            text = { Text(if (closesOrder) "清盘后没有剩余菜品，订单将关闭。确定继续？" else "确定清除该桌扫盘加入的菜品？") },
            confirmButton = {
                TextButton(enabled = !clearingPlates, onClick = {
                    clearingPlates = true
                    scope.launch {
                        try {
                            if (vm.repository.clearPlates(tableId).orToast(vm.repository) != null) {
                                vm.repository.toast("清盘成功")
                                clearPlatesClosesOrder = null
                                if (closesOrder) onBack() else load()
                            }
                        } finally {
                            clearingPlates = false
                        }
                    }
                }) { Text(if (clearingPlates) "处理中" else "确定") }
            },
            dismissButton = { TextButton(onClick = { clearPlatesClosesOrder = null }, enabled = !clearingPlates) { Text("取消") } },
        )
    }
    seasoningWarning?.let { snapshot ->
        AlertDialog(
            onDismissRequest = { seasoningWarning = null },
            title = { Text("核对调料费") },
            text = { Text("当前锅底数量大于调料数量。请核对调料费。") },
            confirmButton = {
                TextButton(onClick = {
                    seasoningWarning = null
                    checkAverage(snapshot)
                }) { Text("继续结账") }
            },
            dismissButton = { TextButton(onClick = { seasoningWarning = null }) { Text("返回调整") } },
        )
    }
    averageWarning?.let { snapshot ->
        AlertDialog(
            onDismissRequest = { averageWarning = null },
            title = { Text("核对订单金额") },
            text = { Text("当前订单人均低于 70 元。请确认金额是否正确。") },
            confirmButton = {
                TextButton(onClick = {
                    averageWarning = null
                    onSettle(snapshot.orderId, snapshot.shopSupplierId, snapshot.userId)
                }) { Text("确认并结账") }
            },
            dismissButton = { TextButton(onClick = { averageWarning = null }) { Text("返回调整") } },
        )
    }
    if (pickingReturn) {
        AlertDialog(
            onDismissRequest = { pickingReturn = false },
            title = { Text("选择退菜") },
            text = {
                Column {
                    current?.lines.orEmpty().forEach { line ->
                        TextButton(onClick = {
                            pickingReturn = false
                            beginReturn(line)
                        }) { Text("${line.name}  x${qtyLabel(line.qty)}") }
                    }
                }
            },
            confirmButton = { TextButton(onClick = { pickingReturn = false }) { Text("取消") } },
        )
    }
    returning?.let { line ->
        AlertDialog(
            onDismissRequest = { returning = null },
            title = { Text("退菜") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("${line.name}，数量不能超过 ${line.qty}")
                    OutlinedTextField(returnQty, { returnQty = it }, label = { Text("退菜数量") }, singleLine = true)
                    FilterChip(selected = returnPrint, onClick = { returnPrint = !returnPrint }, label = { Text("打印退菜单") })
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    val qty = returnQty.toIntOrNull() ?: 0
                    val max = line.qty.toDoubleOrNull()?.toInt() ?: 0
                    if (qty < 1) {
                        vm.repository.toast("退菜数量不能小于1")
                        return@TextButton
                    }
                    if (max > 0 && qty > max) {
                        vm.repository.toast("退菜数量不能大于商品数量")
                        return@TextButton
                    }
                    returning = null
                    scope.launch {
                        vm.repository.returnDish(line.orderProductId, current?.orderId.orEmpty(), qty.toString(), returnPrint)
                            .orToast(vm.repository)
                            ?.let { vm.repository.toast("退菜成功"); load() }
                    }
                }) { Text("确定") }
            },
            dismissButton = { TextButton(onClick = { returning = null }) { Text("取消") } },
        )
    }
}

@Composable
private fun SwipeDishRow(
    line: OrderLine,
    index: Int,
    open: Boolean,
    onOpen: () -> Unit,
    onClose: () -> Unit,
    onServe: () -> Unit,
    onReturn: () -> Unit,
) {
    val reveal = if (line.scanned) 76.dp else 152.dp
    val revealPx = with(androidx.compose.ui.platform.LocalDensity.current) { reveal.toPx() }
    val offset = remember(line.orderProductId) { Animatable(0f) }
    val dragScope = rememberCoroutineScope()
    LaunchedEffect(open) {
        if (!open && offset.value != 0f) offset.animateTo(0f)
    }
    Box(Modifier.fillMaxWidth().clipToBounds()) {
        Row(Modifier.matchParentSize(), horizontalArrangement = Arrangement.End) {
            Box(
                Modifier.width(76.dp).fillMaxHeight().background(CashierBlue).clickable(onClick = onServe),
                contentAlignment = Alignment.Center,
            ) {
                Text(if (line.served) "撤销上菜" else "上菜", color = Color.White, fontSize = 14.sp)
            }
            if (!line.scanned) {
                Box(
                    Modifier.width(76.dp).fillMaxHeight().background(Color(0xFFE23B3B)).clickable(onClick = onReturn),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("退菜", color = Color.White, fontSize = 14.sp)
                }
            }
        }
        Column(
            Modifier
                .offset { IntOffset(offset.value.roundToInt(), 0) }
                .background(Color.White)
                .pointerInput(revealPx) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            dragScope.launch {
                                val target = if (offset.value < -revealPx / 3f) -revealPx else 0f
                                offset.animateTo(target)
                                if (target == 0f) onClose() else onOpen()
                            }
                        },
                        onHorizontalDrag = { change, drag ->
                            change.consume()
                            dragScope.launch {
                                offset.snapTo((offset.value + drag).coerceIn(-revealPx, 0f))
                            }
                        },
                    )
                }
                .padding(horizontal = 18.dp, vertical = 16.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "${index + 1}.${line.name}",
                    modifier = Modifier.weight(1f),
                    color = if (line.served) CashierTextMuted else CashierText,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textDecoration = if (line.served) TextDecoration.LineThrough else TextDecoration.None,
                )
                Text(
                    "x${qtyLabel(line.qty)}",
                    modifier = Modifier.width(42.dp),
                    color = if (line.served) CashierTextMuted else CashierText,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                )
                Text(
                    money(line.total),
                    modifier = Modifier.width(78.dp),
                    color = if (line.served) CashierTextMuted else CashierPrice,
                    fontSize = 15.sp,
                    textAlign = TextAlign.End,
                )
            }
            if (line.gift || line.remark.isNotBlank()) {
                Text(
                    listOf(if (line.gift) "赠" else "", line.remark).filter { it.isNotBlank() }.joinToString("  "),
                    color = CashierTextMuted,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 18.dp, top = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun OrderDockAction(label: String, onClick: () -> Unit) {
    Column(
        Modifier.width(68.dp).clickable(onClick = onClick).padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier.size(22.dp).clip(CircleShape).background(CashierBlue),
            contentAlignment = Alignment.Center,
        ) {
            Text("i", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        Text(label, color = CashierText, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp), maxLines = 1)
    }
}

@Composable
private fun ScanDockButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier.size(96.dp).clickable(onClick = onClick), contentAlignment = Alignment.Center) {
        Canvas(Modifier.size(84.dp)) {
            drawArc(
                color = Color(0xFF8ED63A),
                startAngle = -70f,
                sweepAngle = 300f,
                useCenter = false,
                style = Stroke(width = 7.dp.toPx(), cap = StrokeCap.Round),
            )
        }
        Text("智能扫盘", color = Color(0xFF67B51A), fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}

private fun portionCount(lines: List<at.co.schwaerzler.maximilian.doit.pos.OrderLine>): String {
    val total = lines.sumOf { it.qty.toDoubleOrNull() ?: 0.0 }
    return if (total % 1.0 == 0.0) total.toInt().toString() else total.toString()
}

private fun qtyLabel(qty: String): String {
    val number = qty.toDoubleOrNull() ?: return qty.ifBlank { "0" }
    return if (number % 1.0 == 0.0) number.toInt().toString() else qty
}

private fun plainAmount(value: String): String {
    val raw = value.trim().removePrefix("¥").removePrefix("￥")
    val number = raw.toDoubleOrNull() ?: return raw.ifBlank { "0.00" }
    return String.format("%.2f", number)
}

@Composable
fun SettleScreen(
    orderId: String,
    supplierId: String,
    userId: String,
    tableId: String,
    tableLabel: String,
    onBack: () -> Unit,
    onExternalCoupon: (SettleOrder) -> Unit,
    onDone: () -> Unit,
) {
    val vm = cashierViewModel()
    val repository = vm.repository
    val scope = rememberCoroutineScope()
    var order by remember { mutableStateOf<SettleOrder?>(null) }
    var loadingOrder by remember { mutableStateOf(false) }
    var orderFailed by remember { mutableStateOf(false) }
    var paymentMethodsFailed by remember { mutableStateOf(false) }
    var methods by remember { mutableStateOf<List<PayMethod>>(emptyList()) }
    var remark by remember { mutableStateOf("") }
    var quota by remember { mutableStateOf("") }
    var quotaRemark by remember { mutableStateOf("") }
    var cash by remember { mutableStateOf("") }
    var authCode by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<PayMethod?>(null) }
    var allowQuota by remember { mutableStateOf(false) }
    var pendingTrade by remember { mutableStateOf("") }
    var paying by remember { mutableStateOf(false) }
    var showConsumption by remember(orderId) { mutableStateOf(false) }
    var showQuota by remember(orderId) { mutableStateOf(false) }
    var editingRemark by remember(orderId) { mutableStateOf(false) }
    var remarkDraft by remember(orderId) { mutableStateOf("") }
    var submittingQuota by remember(orderId) { mutableStateOf(false) }
    var finishing by remember(orderId) { mutableStateOf(false) }
    var settlementLocked by remember(orderId) { mutableStateOf(false) }
    var lockFailed by remember(orderId) { mutableStateOf(false) }
    var lockAttempt by remember(orderId) { mutableIntStateOf(0) }
    var otherCashier by remember(orderId) { mutableStateOf<String?>(null) }
    var proceedWithOtherCashier by remember(orderId) { mutableStateOf(false) }
    var couponPage by remember(orderId) { mutableStateOf<Boolean?>(null) }
    var memberCouponCount by remember(orderId) { mutableIntStateOf(0) }
    var packCouponCount by remember(orderId) { mutableIntStateOf(0) }
    var paymentToRemove by remember(orderId) { mutableStateOf<PaymentLine?>(null) }
    var removingPayment by remember(orderId) { mutableStateOf(false) }
    val scanPaymentSelected = settlementLocked && selected?.type == "scan" && !paying && pendingTrade.isBlank()
    if (scanPaymentSelected) {
        ReceivePaymentBarcode { scanned -> authCode = scanned }
    }

    BackHandler(enabled = paying || finishing) {}

    fun load() {
        if (loadingOrder) return
        loadingOrder = true
        orderFailed = false
        paymentMethodsFailed = false
        order = null
        scope.launch {
            try {
                val loaded = repository.orderInfo(orderId, supplierId, userId).orToast(repository)
                if (loaded == null) {
                    orderFailed = true
                    return@launch
                }
                val resolvedTableId = tableId.ifBlank { loaded.tableId }
                val options = if (resolvedTableId.isNotBlank()) {
                    repository.paymentMethods(resolvedTableId).orToast(repository)
                } else {
                    null
                }
                methods = options.orEmpty()
                paymentMethodsFailed = options == null
                if (selected !in methods) selected = null
                cash = loaded.payPrice
                order = loaded.copy(tableId = resolvedTableId)
            } finally {
                loadingOrder = false
            }
        }
    }

    LaunchedEffect(orderId, lockAttempt) {
        lockFailed = false
        val owner = repository.otherSettlementCashier(orderId)
        if (owner.isFailure) {
            owner.orToast(repository)
            lockFailed = true
            return@LaunchedEffect
        }
        val cashier = owner.getOrNull()
        if (cashier != null && !proceedWithOtherCashier) {
            otherCashier = cashier
            return@LaunchedEffect
        }
        proceedWithOtherCashier = false
        var acquired = false
        try {
            withContext(NonCancellable) {
                acquired = repository.lockSettlement(orderId).orToast(repository) != null
            }
            if (!acquired) {
                lockFailed = true
                return@LaunchedEffect
            }
            settlementLocked = true
            load()
            allowQuota = repository.permissions().getOrNull().orEmpty().any { it.type == "quota" && it.allowed }
            awaitCancellation()
        } finally {
            if (acquired) {
                withContext(NonCancellable) { repository.unlockSettlement(orderId).orToast(repository) }
            }
        }
    }
    val current = order
    LaunchedEffect(current) {
        if (current != null && current.tableId.isNotBlank()) {
            memberCouponCount = repository.memberCoupons(current.tableId, orderId, current.shopSupplierId)
                .getOrNull().orEmpty().sumOf { it.coupons.size }
            packCouponCount = repository.packCoupons(current.tableId, orderId, current.shopSupplierId)
                .getOrNull().orEmpty().sumOf { it.coupons.size }
        }
    }
    val isPack = couponPage
    if (isPack != null && current != null) {
        MemberCouponScreen(
            order = current,
            isPack = isPack,
            onBack = { couponPage = null },
            onApplied = {
                couponPage = null
                load()
            },
        )
        return
    }

    Scaffold(
        containerColor = SettlementPanel,
        topBar = {
            SettlementHeader(
                title = tableLabel.ifBlank { "结账" },
                onBack = { if (!paying && !finishing) onBack() },
                onPrint = current?.let { snapshot ->
                    {
                        scope.launch {
                            repository.printPreview(orderId, snapshot.payments).orToast(repository)
                                ?.let { repository.toast("预结单已发送") }
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (current != null) {
                val remaining = current.payPrice.toBigDecimalOrNull()
                val canClear = remaining?.signum() == 0
                Row(
                    Modifier.fillMaxWidth().background(SettlementPanel).navigationBarsPadding()
                        .padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                        if (allowQuota) {
                            SettlementAction(
                                label = "手工定额",
                                primary = false,
                                modifier = Modifier.weight(1f),
                                enabled = !paying && !finishing && pendingTrade.isBlank(),
                                onClick = { showQuota = true },
                            )
                        }
                        SettlementAction(
                            label = when {
                                finishing -> "正在清台"
                                canClear -> "清台"
                                remaining == null -> "应收金额待确认"
                                else -> "还需收款  ${money(current.payPrice)}"
                            },
                            primary = true,
                            modifier = Modifier.weight(3f),
                            enabled = canClear && !paying && !finishing && pendingTrade.isBlank(),
                            onClick = {
                                if (!finishing) {
                                    finishing = true
                                    scope.launch {
                                        try {
                                            repository.finishPay(current, remark, quotaRemark).orToast(repository)?.let {
                                                repository.toast("结账成功")
                                                onDone()
                                            }
                                        } finally {
                                            finishing = false
                                        }
                                    }
                                }
                            },
                        )
                }
            }
        },
    ) { padding ->
        if (!settlementLocked) {
            Column(Modifier.padding(padding).padding(16.dp)) {
                if (lockFailed) {
                    TextButton(onClick = { lockAttempt++ }) { Text("获取结账权限失败，重试") }
                } else {
                    Text("正在确认订单结账状态")
                }
            }
            return@Scaffold
        }
        if (current == null) {
            Column(Modifier.padding(padding).padding(16.dp)) {
                if (orderFailed) {
                    Text("未能读取结账明细")
                    TextButton(onClick = ::load, enabled = !loadingOrder) { Text("重试") }
                } else {
                    Text("正在读取结账明细")
                }
            }
            return@Scaffold
        }
        LazyColumn(
            Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(start = 18.5.dp, end = 18.5.dp, top = 6.dp, bottom = 6.dp),
        ) {
            item {
                SettlementDetailLink("消费明细", "共${current.productNum.ifBlank { current.lines.size.toString() }}件", alignEnd = false) {
                    showConsumption = true
                }
                SettlementDetailLink("结算备注", remark.ifBlank { "无备注" }, alignEnd = true) {
                    remarkDraft = remark
                    editingRemark = true
                }
                SettlementAmountRow("商品总价", current.totalPrice.ifBlank { current.orderPrice }, Modifier.padding(top = 30.5.dp))
                SettlementCouponRow(current.discount, memberCouponCount) {
                    if (!paying && !finishing && pendingTrade.isBlank()) couponPage = false
                }
                SettlementAmountRow("应收", current.receivable.ifBlank { current.payPrice })
                SettlementAmountRow("找零", money(current.giveChange), Modifier.padding(top = 14.dp))
            }
            item {
                Text("结算明细", Modifier.padding(start = 4.dp, top = 49.dp, bottom = 4.dp), color = SettlementText, fontSize = 15.sp)
                current.payments.forEach { pay ->
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Row(
                            Modifier.weight(1f).heightIn(min = 43.dp).background(Color.White, RoundedCornerShape(4.dp)).padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(pay.name.ifBlank { pay.type }, Modifier.weight(1f), color = SettlementText, fontSize = 13.sp)
                            Text(money(pay.money), color = SettlementText, fontSize = 13.sp)
                        }
                        Image(
                            painterResource(R.drawable.ic_settlement_remove), contentDescription = "撤销${pay.name}",
                            modifier = Modifier.size(49.dp)
                                .clickable(enabled = !paying && !finishing && pendingTrade.isBlank()) { paymentToRemove = pay }
                                .padding(15.7.dp),
                        )
                    }
                }
                Text(
                    "支付方式", Modifier.padding(top = 39.dp).heightIn(min = 29.dp),
                    color = SettlementText, fontSize = 13.sp,
                )
                if (paymentMethodsFailed) {
                    TextButton(onClick = ::load, enabled = !loadingOrder) { Text("支付方式加载失败，重试") }
                }
                methods.chunked(3).forEach { row ->
                    Row(Modifier.fillMaxWidth().padding(bottom = 5.dp), horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        row.forEach { method ->
                            SettlementPaymentCard(
                                method = method,
                                available = packCouponCount,
                                modifier = Modifier.weight(1f),
                                enabled = !paying && !finishing && pendingTrade.isBlank() &&
                                    current.payPrice.toBigDecimalOrNull()?.signum() == 1,
                                onClick = {
                                    when (method.type) {
                                        "cash", "scan" -> {
                                            cash = current.payPrice
                                            authCode = ""
                                            selected = method
                                        }
                                        "inner" -> couponPage = true
                                        "out" -> onExternalCoupon(current)
                                        else -> repository.toast("暂不支持该付款方式")
                                    }
                                },
                            )
                        }
                        repeat(3 - row.size) { Spacer(Modifier.weight(1f)) }
                    }
                }
            }
        }
    }
    otherCashier?.let { cashier ->
        AlertDialog(
            onDismissRequest = onBack,
            title = { Text("订单正在结账") },
            text = { Text("$cashier 正在结账。是否继续请求结账？") },
            confirmButton = {
                TextButton(onClick = {
                    otherCashier = null
                    proceedWithOtherCashier = true
                    lockAttempt++
                }) { Text("继续") }
            },
            dismissButton = { TextButton(onClick = onBack) { Text("返回") } },
        )
    }
    if (showConsumption && current != null) {
        ConsumptionDetailsDialog(orderId, current.payments, onDismiss = { showConsumption = false })
    }
    paymentToRemove?.let { payment ->
        AlertDialog(
            onDismissRequest = { if (!removingPayment) paymentToRemove = null },
            title = { Text("撤销结算") },
            text = { Text("确定撤销 ${payment.name.ifBlank { payment.type }} ${money(payment.money)}？") },
            confirmButton = {
                TextButton(
                    enabled = !removingPayment,
                    onClick = {
                        removingPayment = true
                        scope.launch {
                            try {
                                if (repository.refundPayment(payment).orToast(repository) != null) {
                                    paymentToRemove = null
                                    repository.toast("已撤销")
                                    load()
                                }
                            } finally {
                                removingPayment = false
                            }
                        }
                    },
                ) { Text(if (removingPayment) "处理中" else "确定") }
            },
            dismissButton = { TextButton(onClick = { paymentToRemove = null }, enabled = !removingPayment) { Text("取消") } },
        )
    }
    val method = selected
    if (method != null && current != null) {
        val isScan = method.type == "scan"
        val editing = !paying && pendingTrade.isBlank()
        SettlementPaymentWindow(
            canDismiss = editing,
            onDismissRequest = { if (editing) selected = null },
            title = method.name.ifBlank { if (isScan) "扫码支付" else "现金" },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    if (isScan && pendingTrade.isBlank()) {
                        OutlinedTextField(
                            authCode, { authCode = it.trim() }, Modifier.fillMaxWidth(),
                            enabled = editing,
                            label = { Text("付款码") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
                            singleLine = true,
                        )
                    }
                    Row(
                        Modifier.fillMaxWidth().padding(top = 10.dp),
                        horizontalArrangement = if (isScan) Arrangement.Center else Arrangement.Start,
                    ) {
                        Text("当前还需收款：", color = SettlementText, fontSize = 14.sp)
                        Text(money(current.payPrice), color = SettlementRed, fontSize = 14.sp)
                    }
                    OutlinedTextField(
                        cash, { cash = it }, Modifier.fillMaxWidth(),
                        enabled = editing,
                        label = { Text("收款金额") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        singleLine = true,
                    )
                    if (pendingTrade.isNotBlank() && !paying) {
                        Text("支付结果尚未确认，请继续查询该笔交易。")
                    }
                }
            },
            confirmButton = {
                TextButton(enabled = !paying, onClick = {
                    val tradeToCheck = pendingTrade
                    val amount = cash.trim().toBigDecimalOrNull()
                    val code = authCode.trim()
                    if (tradeToCheck.isBlank()) {
                        if (amount == null || amount.signum() <= 0 || amount.scale() !in 0..2 || amount.precision() > 12) {
                            repository.toast("请输入有效的收款金额")
                            return@TextButton
                        }
                        if (isScan) {
                            val remaining = current.payPrice.toBigDecimalOrNull()
                            if (remaining == null || amount > remaining) {
                                repository.toast("扫码收款金额不能超过还需收款金额")
                                return@TextButton
                            }
                            if (!validPaymentBarcode(code)) {
                                repository.toast("请扫描或输入有效的付款码")
                                return@TextButton
                            }
                        }
                    }
                    paying = true
                    authCode = ""
                    scope.launch {
                        try {
                            if (!isScan) {
                                val lockedAmount = checkNotNull(amount).toPlainString()
                                if (repository.addCashSettle(orderId, method.settleType, lockedAmount, "13").orToast(repository) != null) {
                                    selected = null
                                    repository.toast("已记入现金")
                                    load()
                                }
                                return@launch
                            }
                            if (tradeToCheck.isBlank()) {
                                val lockedAmount = checkNotNull(amount).toPlainString()
                                val result = repository.scanPay(orderId, lockedAmount, code).orToast(repository) ?: return@launch
                                if (result.outTradeNo.isBlank()) {
                                    selected = null
                                    repository.toast(result.message.ifBlank { "服务器未返回交易单号，请先核对订单" })
                                    load()
                                    return@launch
                                }
                                pendingTrade = result.outTradeNo
                            }
                            val trade = pendingTrade
                            repeat(40) {
                                if (repository.scanPayQuery(trade).getOrNull()?.paid == true) {
                                    pendingTrade = ""
                                    selected = null
                                    repository.toast("支付成功")
                                    load()
                                    return@launch
                                }
                                delay(3000)
                            }
                            repository.toast("支付结果未确认，可继续查询这笔交易")
                        } finally {
                            paying = false
                        }
                    }
                }) {
                    Text(
                        when {
                            paying -> if (isScan) "正在查询支付结果" else "正在记录现金"
                            pendingTrade.isNotBlank() -> "继续查询支付"
                            isScan -> "确认收款"
                            else -> "确定"
                        },
                        color = Color(0xFF4A87D9),
                        fontSize = 17.sp,
                    )
                }
            },
            dismissButton = {
                if (!isScan) {
                    TextButton(enabled = editing, onClick = { selected = null }) {
                        Text("取消", color = Color(0xFF4A87D9), fontSize = 17.sp)
                    }
                }
            },
        )
    }
    if (editingRemark) {
        AlertDialog(
            onDismissRequest = { editingRemark = false },
            title = { Text("结算备注") },
            text = {
                OutlinedTextField(
                    remarkDraft, { remarkDraft = it }, Modifier.fillMaxWidth(),
                    label = { Text("备注") },
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    remark = remarkDraft
                    editingRemark = false
                }) { Text("保存") }
            },
            dismissButton = { TextButton(onClick = { editingRemark = false }) { Text("取消") } },
        )
    }
    if (showQuota) {
        AlertDialog(
            onDismissRequest = { if (!submittingQuota) showQuota = false },
            title = { Text("手工定额") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        quota, { quota = it }, Modifier.fillMaxWidth(),
                        label = { Text("手工定额金额") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        enabled = !submittingQuota,
                    )
                    OutlinedTextField(
                        quotaRemark, { quotaRemark = it }, Modifier.fillMaxWidth(),
                        label = { Text("定额备注") },
                        enabled = !submittingQuota,
                    )
                }
            },
            confirmButton = {
                TextButton(
                    enabled = !submittingQuota,
                    onClick = {
                        submittingQuota = true
                        scope.launch {
                            try {
                                repository.addCashSettle(orderId, "1", quota, "1").orToast(repository)?.let {
                                    repository.toast("已记入手工定额")
                                    showQuota = false
                                    load()
                                }
                            } finally {
                                submittingQuota = false
                            }
                        }
                    },
                ) { Text(if (submittingQuota) "提交中" else "确定") }
            },
            dismissButton = { TextButton(onClick = { showQuota = false }, enabled = !submittingQuota) { Text("取消") } },
        )
    }
}

private const val PDA_BARCODE_ACTION = "android.rfid.INPUT"

private fun validPaymentBarcode(code: String): Boolean = code.length in 18..32 && code.all { it in '0'..'9' }

@Composable
private fun ReceivePaymentBarcode(onBarcode: (String) -> Unit) {
    val context = LocalContext.current
    val receiverCallback by rememberUpdatedState(onBarcode)
    LifecycleResumeEffect(context) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (intent.action != PDA_BARCODE_ACTION) return
                val code = runCatching { intent.getStringExtra("data")?.trim() }.getOrNull() ?: return
                if (validPaymentBarcode(code)) receiverCallback(code)
            }
        }
        val registered = runCatching {
            ContextCompat.registerReceiver(
                context, receiver, IntentFilter(PDA_BARCODE_ACTION), ContextCompat.RECEIVER_EXPORTED,
            )
        }.isSuccess
        onPauseOrDispose {
            if (registered) context.unregisterReceiver(receiver)
        }
    }
}

@Composable
private fun ConsumptionDetailsDialog(orderId: String, payments: List<PaymentLine>, onDismiss: () -> Unit) {
    val repository = cashierViewModel().repository
    val scope = rememberCoroutineScope()
    var groups by remember { mutableStateOf<List<ConsumptionGroup>>(emptyList()) }
    var attempt by remember { mutableIntStateOf(0) }
    var loading by remember { mutableStateOf(true) }
    var failed by remember { mutableStateOf(false) }
    var printing by remember { mutableStateOf(false) }

    LaunchedEffect(orderId, payments, attempt) {
        loading = true
        val result = repository.consumptionDetails(orderId, payments)
        groups = result.orToast(repository).orEmpty()
        failed = result.isFailure
        loading = false
    }

    AlertDialog(
        onDismissRequest = { if (!printing) onDismiss() },
        title = { Text("消费明细") },
        text = {
            when {
                loading -> Text("正在读取消费明细")
                failed -> TextButton(onClick = { attempt++ }) { Text("读取失败，重试") }
                groups.isEmpty() -> Text("暂无消费明细")
                else -> LazyColumn(
                    Modifier.fillMaxWidth().heightIn(max = 440.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(groups) { group ->
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            val name = group.name.ifBlank { "商品" }
                            Text(if (group.isCoupon) "$name · 优惠券" else name, fontWeight = FontWeight.Bold)
                            ConsumptionAmounts(group.qty, group.total, group.payable)
                            if (group.tip.isNotBlank()) Text(group.tip)
                            group.products.forEach { product ->
                                Text(
                                    when {
                                        product.isGift -> "${product.name} · 赠品"
                                        product.isPromotion -> "${product.name} · 促销"
                                        else -> product.name
                                    },
                                )
                                ConsumptionAmounts(product.qty, product.total, product.payable)
                                if (product.refundQty.isNotBlank() && product.refundMoney.isNotBlank()) {
                                    Text("已退 ${product.refundQty} 件 · ${money(product.refundMoney)}")
                                }
                            }
                            HorizontalDivider()
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                enabled = !loading && !failed && !printing,
                onClick = {
                    printing = true
                    scope.launch {
                        try {
                            repository.printPreview(orderId, payments).orToast(repository)
                                ?.let { repository.toast("预结单已发送") }
                        } finally {
                            printing = false
                        }
                    }
                },
            ) { Text(if (printing) "发送中" else "打印预结单") }
        },
        dismissButton = { TextButton(onClick = onDismiss, enabled = !printing) { Text("关闭") } },
    )
}

@Composable
private fun ConsumptionAmounts(qty: String, total: String, payable: String) {
    val amounts = listOfNotNull(
        qty.takeIf { it.isNotBlank() }?.let { "×$it" },
        total.takeIf { it.isNotBlank() }?.let { "原价 ${money(it)}" },
        payable.takeIf { it.isNotBlank() }?.let { "应收 ${money(it)}" },
    )
    if (amounts.isNotEmpty()) Text(amounts.joinToString("  "), style = MaterialTheme.typography.bodySmall)
}

@Composable
fun OrderListScreen(onOpen: (OrderSummary) -> Unit) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var keyword by remember { mutableStateOf("") }
    var appliedKeyword by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var orders by remember { mutableStateOf<List<OrderSummary>>(emptyList()) }
    var page by remember { mutableIntStateOf(1) }
    var more by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }
    var request by remember { mutableStateOf<Job?>(null) }
    val tabs = listOf("" to "全部", "0" to "未完成", "1" to "已完成")

    fun load(reset: Boolean = true) {
        if (!reset && loading) return
        request?.cancel()
        if (reset) {
            appliedKeyword = keyword.trim()
            orders = emptyList()
            more = false
        }
        val query = appliedKeyword
        val filter = status
        val next = if (reset) 1 else page + 1
        loading = true
        request = scope.launch {
            try {
                val rows = vm.repository.orders(filter, query, next.toString()).orToast(vm.repository) ?: return@launch
                orders = (orders + rows).distinctBy { it.orderId }
                page = next
                more = rows.size >= 10
            } finally {
                if (kotlin.coroutines.coroutineContext[Job]?.isCancelled != true) loading = false
            }
        }
    }

    LaunchedEffect(Unit) { load() }

    Column(Modifier.fillMaxSize()) {
        OutlinedTextField(
            keyword,
            { keyword = it },
            Modifier.fillMaxWidth().padding(12.dp),
            label = { Text("订单号 / 桌号") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { load() }),
            trailingIcon = { TextButton(onClick = { load() }) { Text("搜索") } },
        )
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            tabs.forEach { (value, label) ->
                FilterChip(selected = status == value, onClick = { status = value; load() }, label = { Text(label) })
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            itemsIndexed(orders, key = { index, order -> "${order.orderId}#$index" }) { _, order ->
                Card(
                    onClick = { onOpen(order) },
                    enabled = order.orderStatus != "20" && order.orderId.isNotBlank(),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column(Modifier.fillMaxWidth().padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(order.orderNo.ifBlank { order.orderId }, fontWeight = FontWeight.Bold)
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("${order.areaName} ${order.tableNo}".trim())
                            Text(order.payStatusName, color = if (order.payStatus == "10") MaterialTheme.colorScheme.error else CashierTextMuted)
                        }
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(order.createTime, style = MaterialTheme.typography.bodySmall)
                            Text(money(order.income), fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
            if (orders.isEmpty()) {
                item { Text(if (loading) "正在读取订单" else "暂无订单", Modifier.padding(12.dp)) }
            }
            if (more) {
                item {
                    TextButton(onClick = { load(reset = false) }, enabled = !loading, modifier = Modifier.fillMaxWidth()) {
                        Text(if (loading) "加载中" else "加载更多")
                    }
                }
            }
        }
    }
}

@Composable
fun FinishedOrderScreen(orderId: String, onBack: () -> Unit) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var order by remember { mutableStateOf<FinishedOrder?>(null) }

    LaunchedEffect(orderId) {
        order = vm.repository.finishedOrder(orderId).orToast(vm.repository)
    }
    val current = order

    Scaffold(topBar = { CashierTopBar("订单详情", onBack = onBack) }) { padding ->
        if (current == null) {
            Text("正在读取订单", modifier = Modifier.padding(padding).padding(16.dp))
        } else {
            LazyColumn(
                Modifier.fillMaxSize().padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                item {
                    Text(current.tableNo.ifBlank { "订单" }, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                    Text("人数 ${current.mealNum}")
                    Text("订单号 ${current.orderNo.ifBlank { orderId }}")
                    Text("下单 ${current.createTime}")
                    if (current.payTime.isNotBlank()) Text("支付 ${current.payTime}")
                    if (current.cashier.isNotBlank()) Text("收银 ${current.cashier}")
                    if (current.guest.isNotBlank() || current.mobile.isNotBlank()) {
                        Text("${current.guest}  ${maskMobile(current.mobile)}".trim())
                    }
                }
                item { Text("商品", fontWeight = FontWeight.Bold) }
                items(current.lines) { (name, detail) ->
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(name, modifier = Modifier.weight(1f))
                        Text(detail)
                    }
                }
                if (current.discounts.isNotEmpty()) {
                    item { Text("优惠", fontWeight = FontWeight.Bold) }
                    items(current.discounts) { (name, money) ->
                        Text("$name  $money")
                    }
                }
                if (current.payments.isNotEmpty()) {
                    item { Text("结算", fontWeight = FontWeight.Bold) }
                    items(current.payments) { (name, money) ->
                        Text("$name  $money")
                    }
                }
                item {
                    HorizontalDivider()
                    Text("商品合计 ${money(current.total)}")
                    Text("优惠 ${money(current.discount)}")
                    Text("应收 ${money(current.receivable)}")
                    Text("退款 ${money(current.refund)}")
                    Text("实收 ${money(current.real)}", fontWeight = FontWeight.Bold)
                    listOf(
                        "订单备注" to current.orderRemark,
                        "赠送备注" to current.presentRemark,
                        "结算备注" to current.settleRemark,
                        "退款备注" to current.refundRemark,
                    ).filter { it.second.isNotBlank() }.forEach { (label, value) ->
                        Text("$label $value")
                    }
                    Button(onClick = {
                        scope.launch {
                            vm.repository.printBill(orderId).orToast(vm.repository)?.let { vm.repository.toast("打印成功") }
                        }
                    }, modifier = Modifier.fillMaxWidth()) { Text("打印") }
                }
            }
        }
    }
}

private fun maskMobile(mobile: String): String =
    if (mobile.length >= 7) mobile.replaceRange(3, 7, "****") else mobile

@Composable
fun SwitchTableScreen(orderId: String, sourceTableId: String, merge: Boolean, onBack: () -> Unit) {
    val repository = cashierViewModel().repository
    val scope = rememberCoroutineScope()
    var source by remember { mutableStateOf<TableOrder?>(null) }
    var sourceLoaded by remember { mutableStateOf(false) }
    var entered by remember { mutableStateOf<Map<String, String>>(emptyMap()) }
    var quantities by remember { mutableStateOf<Map<String, String>?>(null) }
    var transferAll by remember { mutableStateOf(false) }
    var search by remember { mutableStateOf("") }
    var tables by remember { mutableStateOf<List<DiningTable>>(emptyList()) }
    var loadingTables by remember { mutableStateOf(false) }
    var target by remember { mutableStateOf<DiningTable?>(null) }
    var submitting by remember { mutableStateOf(false) }
    val choosingTable = !merge || quantities != null

    fun loadTables() {
        if (loadingTables) return
        loadingTables = true
        scope.launch {
            try {
                tables = repository.tables("", "", if (merge) "" else "10", search.trim())
                    .orToast(repository).orEmpty().filter { it.id.isNotBlank() && it.id != sourceTableId }
            } finally {
                loadingTables = false
            }
        }
    }

    fun goBack() {
        if (submitting) return
        if (merge && choosingTable) quantities = null else onBack()
    }

    BackHandler(enabled = submitting || (merge && choosingTable)) { goBack() }
    LaunchedEffect(sourceTableId, orderId, merge) {
        if (merge) {
            source = repository.orderOnTable(sourceTableId).orToast(repository)?.takeIf { it.orderId == orderId }
            sourceLoaded = true
        }
    }
    LaunchedEffect(choosingTable) {
        if (choosingTable) loadTables()
    }

    val selectedSource = source
    val transferable = selectedSource?.lines.orEmpty().filter {
        it.orderProductId.isNotBlank() && it.qty.toBigDecimalOrNull()?.signum() == 1
    }
    val title = when {
        !merge -> "换台"
        choosingTable -> "选择目标桌台"
        else -> "单品转台"
    }
    Scaffold(topBar = { CashierTopBar(title, onBack = ::goBack) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            if (!choosingTable) {
                TextButton(
                    onClick = { entered = transferable.associate { it.orderProductId to it.qty } },
                    enabled = transferable.isNotEmpty(),
                ) { Text("全选") }
                LazyColumn(
                    Modifier.weight(1f),
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    if (transferable.isEmpty()) {
                        item { Text(if (sourceLoaded) "当前订单没有可转台的商品" else "正在读取订单") }
                    }
                    itemsIndexed(transferable) { _, line ->
                        val id = line.orderProductId
                        val input = entered[id].orEmpty()
                        val amount = input.trim().toBigDecimalOrNull()
                        val invalid = input.isNotBlank() && (amount == null || amount.signum() < 0 ||
                            amount > line.qty.toBigDecimal())
                        OutlinedTextField(
                            input,
                            { value ->
                                if (value.length <= 16 && value.all { it in '0'..'9' || it == '.' }) {
                                    entered = entered + (id to value)
                                }
                            },
                            Modifier.fillMaxWidth(),
                            label = { Text("${line.name}（可转 ${line.qty}）") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            isError = invalid,
                            singleLine = true,
                        )
                    }
                }
                Button(
                    enabled = transferable.isNotEmpty(),
                    onClick = {
                        val selected = mutableMapOf<String, String>()
                        for (line in transferable) {
                            val raw = entered[line.orderProductId].orEmpty().trim()
                            if (raw.isBlank()) continue
                            val amount = raw.toBigDecimalOrNull()
                            if (amount == null || amount.signum() < 0 || amount > line.qty.toBigDecimal()) {
                                repository.toast("请输入正确的转台数量")
                                return@Button
                            }
                            if (amount.signum() > 0) selected[line.orderProductId] = amount.stripTrailingZeros().toPlainString()
                        }
                        if (selected.isEmpty()) {
                            repository.toast("请选择要转台的商品和数量")
                            return@Button
                        }
                        val all = selectedSource != null && selectedSource.lines.all { line ->
                            val qty = line.qty.toBigDecimalOrNull()
                            qty != null && (qty.signum() == 0 ||
                                selected[line.orderProductId]?.toBigDecimalOrNull()?.compareTo(qty) == 0)
                        }
                        if (all && selectedSource.hasPaymentRecord) {
                            repository.toast("该订单已支付部分金额，不可全部转台")
                            return@Button
                        }
                        transferAll = all
                        quantities = selected
                    },
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                ) { Text("下一步") }
                return@Column
            }
            OutlinedTextField(
                search,
                { search = it },
                Modifier.fillMaxWidth().padding(12.dp),
                label = { Text(if (merge) "搜索桌号" else "搜索空闲桌") },
                trailingIcon = { TextButton(onClick = ::loadTables, enabled = !loadingTables) { Text("搜索") } },
            )
            LazyColumn(contentPadding = PaddingValues(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                if (loadingTables || tables.isEmpty()) {
                    item { Text(if (loadingTables) "正在读取桌台" else "没有可选桌台") }
                }
                itemsIndexed(tables, key = { index, table -> "${table.id}#$index" }) { _, table ->
                    Card(onClick = { target = table }, enabled = !loadingTables && !submitting) {
                        Column(Modifier.padding(12.dp)) {
                            Text("${table.areaName} ${table.no}", fontWeight = FontWeight.Bold)
                            Text(table.statusName)
                        }
                    }
                }
            }
        }
    }
    target?.let { table ->
        AlertDialog(
            onDismissRequest = { if (!submitting) target = null },
            title = { Text(if (merge) "确认转台" else "确认换台") },
            text = { Text("目标桌台：${table.areaName} ${table.no}") },
            confirmButton = {
                TextButton(
                    enabled = !submitting,
                    onClick = {
                        val selection = quantities
                        if (merge && selection.isNullOrEmpty()) return@TextButton
                        submitting = true
                        scope.launch {
                            try {
                                val result = when {
                                    selection == null -> repository.switchTable(table.id, orderId)
                                    transferAll -> repository.mergeTable(orderId, table.id)
                                    else -> repository.transferProducts(orderId, table.id, selection)
                                }
                                if (result.orToast(repository) != null) {
                                    repository.toast(if (merge) "转台成功" else "换台成功")
                                    onBack()
                                }
                            } finally {
                                submitting = false
                                target = null
                            }
                        }
                    },
                ) { Text(if (submitting) "处理中" else "确认") }
            },
            dismissButton = { TextButton(onClick = { target = null }, enabled = !submitting) { Text("取消") } },
        )
    }
}

@Composable
fun CouponScreen(orderId: String, tableId: String, supplierId: String, userId: String, onBack: () -> Unit) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var code by remember { mutableStateOf("") }
    var types by remember { mutableStateOf<List<GroupCouponType>>(emptyList()) }
    var selected by remember { mutableStateOf<GroupCouponType?>(null) }
    var groupRows by remember { mutableStateOf<List<MemberCoupon>>(emptyList()) }
    var platformRows by remember { mutableStateOf<List<MemberCoupon>>(emptyList()) }
    var pending by remember { mutableStateOf<JsonObject?>(null) }
    var pendingMeituan by remember { mutableStateOf(false) }
    var pendingTitle by remember { mutableStateOf("券") }
    var qty by remember { mutableStateOf("1") }
    var maxQty by remember { mutableIntStateOf(1) }

    fun loadCoupons(type: GroupCouponType?) {
        scope.launch {
            if (type == null || type.type == "douyin" || type.type == "meituan") {
                groupRows = emptyList()
                val kind = if (type?.type == "meituan") "1" else "2"
                platformRows = vm.repository.platformCoupons(orderId, kind).orToast(vm.repository).orEmpty()
            } else {
                platformRows = emptyList()
                groupRows = vm.repository.groupCoupons(tableId, orderId, supplierId, userId, type.sourceId)
                    .orToast(vm.repository)
                    .orEmpty()
            }
        }
    }

    fun verify(payload: JsonObject, meituan: Boolean, title: String, count: String) {
        scope.launch {
            vm.repository.verifyLookedUp(meituan, payload, orderId, count).orToast(vm.repository)?.let {
                vm.repository.toast("${title}核验成功")
                code = ""
                pending = null
                loadCoupons(selected)
            }
        }
    }

    fun lookup(raw: String) {
        val text = raw.trim()
        if (text.isBlank()) return
        val meituan = selected?.type == "meituan"
        scope.launch {
            val looked = vm.repository.lookupCoupon(meituan, text, orderId).orToast(vm.repository) ?: return@launch
            val title = looked.cashierField("title").ifBlank { looked.cashierField("content") }.ifBlank { "券" }
            val count = looked.cashierField("num").toIntOrNull() ?: 1
            if (count == 1) {
                verify(looked, meituan, title, "1")
            } else {
                pending = looked
                pendingMeituan = meituan
                pendingTitle = title
                maxQty = count.coerceAtLeast(1)
                qty = maxQty.toString()
            }
        }
    }

    LaunchedEffect(Unit) {
        val loaded = vm.repository.groupCouponTypes().orToast(vm.repository).orEmpty()
        types = loaded.ifEmpty {
            listOf(
                GroupCouponType("抖音验券", "", "douyin"),
                GroupCouponType("美团验券", "", "meituan"),
            )
        }
        selected = types.firstOrNull()
        loadCoupons(selected)
    }

    val scanType = selected?.type == "douyin" || selected?.type == "meituan" || selected == null

    Scaffold(topBar = { CashierTopBar("选择外部券", onBack = onBack) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                types.forEach { type ->
                    FilterChip(
                        selected = selected == type,
                        onClick = {
                            selected = type
                            loadCoupons(type)
                        },
                        label = { Text(type.name.ifBlank { type.type }) },
                    )
                }
            }
            if (scanType) {
                OutlinedTextField(
                    code,
                    {
                        code = it
                        if (it.endsWith("\n")) lookup(it)
                    },
                    Modifier.fillMaxWidth(),
                    label = { Text("扫码或输入券码") },
                )
                Button(onClick = { lookup(code) }, modifier = Modifier.fillMaxWidth()) { Text("查券") }
                platformRows.forEach { coupon ->
                    Text("${coupon.name}  ${money(coupon.money)}")
                }
            } else {
                LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(groupRows) { coupon ->
                        Card(onClick = {
                            scope.launch {
                                vm.repository.applyCoupon(orderId, "12", coupon).orToast(vm.repository)?.let {
                                    vm.repository.toast("已使用${coupon.name}")
                                    onBack()
                                }
                            }
                        }) {
                            Column(Modifier.padding(12.dp)) {
                                Text(coupon.name, fontWeight = FontWeight.Bold)
                                Text(money(coupon.money))
                            }
                        }
                    }
                }
            }
        }
    }

    pending?.let { payload ->
        AlertDialog(
            onDismissRequest = { pending = null },
            title = { Text(pendingTitle) },
            text = {
                OutlinedTextField(
                    qty,
                    { qty = it.filter { char -> char.isDigit() }.take(4) },
                    label = { Text("核销数量，最多 $maxQty") },
                    singleLine = true,
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    val count = qty.toIntOrNull() ?: 0
                    if (count < 1) {
                        vm.repository.toast("核销数量不能小于1")
                    } else if (count > maxQty) {
                        vm.repository.toast("核销数量不能大于券数量")
                    } else {
                        verify(payload, pendingMeituan, pendingTitle, count.toString())
                    }
                }) { Text("核销") }
            },
            dismissButton = { TextButton(onClick = { pending = null }) { Text("取消") } },
        )
    }
}
