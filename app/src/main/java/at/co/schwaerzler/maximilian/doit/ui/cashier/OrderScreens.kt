package at.co.schwaerzler.maximilian.doit.ui.cashier

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.co.schwaerzler.maximilian.doit.pos.DiningTable
import at.co.schwaerzler.maximilian.doit.pos.FinishedOrder
import at.co.schwaerzler.maximilian.doit.pos.GroupCouponType
import at.co.schwaerzler.maximilian.doit.pos.MemberCoupon
import at.co.schwaerzler.maximilian.doit.pos.OrderSummary
import at.co.schwaerzler.maximilian.doit.pos.PayMethod
import at.co.schwaerzler.maximilian.doit.pos.SettleOrder
import at.co.schwaerzler.maximilian.doit.pos.TableOrder
import at.co.schwaerzler.maximilian.doit.pos.OrderLine
import at.co.schwaerzler.maximilian.doit.pos.cashierField
import kotlin.math.roundToInt
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonObject

@Composable
fun OrderDetailScreen(
    tableId: String,
    tableNo: String,
    onBack: () -> Unit,
    onMenu: () -> Unit,
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
                        OrderDockAction("结账") {
                            requireOrder { onSettle(it, current?.shopSupplierId.orEmpty(), current?.userId.orEmpty()) }
                        }
                    }
                    ScanDockButton(Modifier.align(Alignment.TopCenter).padding(top = 18.dp)) { askScan = true }
                    Row(Modifier.align(Alignment.BottomStart).padding(start = 8.dp, bottom = 4.dp)) {
                        OrderDockAction("赠送", onMenu)
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
fun SettleScreen(orderId: String, supplierId: String, userId: String, onBack: () -> Unit, onDone: () -> Unit) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var order by remember { mutableStateOf<SettleOrder?>(null) }
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
    var couponKind by remember { mutableStateOf("") }
    var accounts by remember { mutableStateOf<List<at.co.schwaerzler.maximilian.doit.pos.MemberAccount>>(emptyList()) }

    fun load() {
        scope.launch {
            order = vm.repository.orderInfo(orderId, supplierId, userId).orToast(vm.repository)
            val tableId = order?.tableId.orEmpty()
            if (tableId.isNotBlank()) methods = vm.repository.paymentMethods(tableId).getOrElse { emptyList() }
            cash = order?.payPrice.orEmpty()
        }
    }

    LaunchedEffect(orderId) {
        load()
        val rights = vm.repository.permissions().getOrNull()
        if (rights != null) allowQuota = rights.any { it.type == "quota" && it.allowed }
    }
    val current = order

    Scaffold(topBar = { CashierTopBar("结账", onBack = onBack) }) { padding ->
        LazyColumn(
            Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                Text("商品总价 ${money(current?.totalPrice ?: current?.orderPrice.orEmpty())}")
                Text("优惠 ${money(current?.discount.orEmpty())}")
                Text("应收 ${money(current?.payPrice.orEmpty())}", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("实收 ${money(current?.realMoney.orEmpty())}    找零 ${money(current?.giveChange.orEmpty())}")
                HorizontalDivider()
                Text("订单明细")
            }
            items(current?.lines.orEmpty()) { line ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("${line.name} × ${line.qty}", Modifier.weight(1f))
                    Text(money(line.total))
                }
            }
            item {
                Text("结算明细")
                current?.payments.orEmpty().forEach { pay ->
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                        Text("${pay.name.ifBlank { pay.type }}  ${money(pay.money)}  ×${pay.num.ifBlank { "1" }}", Modifier.weight(1f))
                        TextButton(onClick = {
                            scope.launch {
                                vm.repository.refundPayment(pay).orToast(vm.repository)?.let {
                                    vm.repository.toast("已撤销")
                                    load()
                                }
                            }
                        }) { Text("撤销") }
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TextButton(onClick = {
                        scope.launch {
                            vm.repository.printPreview(orderId, current?.payments.orEmpty()).orToast(vm.repository)
                                ?.let { vm.repository.toast("预结单已发送") }
                        }
                    }) { Text("打印预结单") }
                    TextButton(onClick = {
                        scope.launch {
                            couponKind = "member"
                            accounts = vm.repository.memberCoupons(current?.tableId.orEmpty(), orderId, current?.shopSupplierId.orEmpty())
                                .orToast(vm.repository).orEmpty()
                        }
                    }) { Text("会员券") }
                    TextButton(onClick = {
                        scope.launch {
                            couponKind = "pack"
                            accounts = vm.repository.packCoupons(current?.tableId.orEmpty(), orderId, current?.shopSupplierId.orEmpty())
                                .orToast(vm.repository).orEmpty()
                        }
                    }) { Text("套餐券") }
                }
                OutlinedTextField(remark, { remark = it }, Modifier.fillMaxWidth(), label = { Text("结算备注") })
                Text("结算方式")
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    methods.forEach { method ->
                        FilterChip(
                            selected = selected == method,
                            onClick = { selected = method },
                            label = { Text(method.name.ifBlank { method.type }) },
                        )
                    }
                }
                val method = selected
                if (method?.type == "cash") {
                    OutlinedTextField(cash, { cash = it }, Modifier.fillMaxWidth(), label = { Text("收款金额") })
                    Button(onClick = {
                        scope.launch {
                            vm.repository.addCashSettle(orderId, method.settleType, cash, "13").orToast(vm.repository)
                                ?.let { vm.repository.toast("已记入现金"); load() }
                        }
                    }, modifier = Modifier.fillMaxWidth()) { Text("确认现金") }
                }
                if (method?.type == "scan") {
                    OutlinedTextField(cash, { cash = it }, Modifier.fillMaxWidth(), label = { Text("收款金额") })
                    OutlinedTextField(authCode, { authCode = it }, Modifier.fillMaxWidth(), label = { Text("扫码支付") })
                    Button(onClick = {
                        scope.launch {
                            paying = true
                            try {
                                val result = vm.repository.scanPay(orderId, cash, authCode.trim()).orToast(vm.repository) ?: return@launch
                                val trade = result.outTradeNo
                                if (trade.isBlank()) {
                                    vm.repository.toast(result.message.ifBlank { "支付已提交" })
                                    load()
                                    return@launch
                                }
                                pendingTrade = trade
                                repeat(40) {
                                    if (vm.repository.scanPayQuery(trade).isSuccess) {
                                        pendingTrade = ""
                                        vm.repository.toast("支付成功")
                                        onDone()
                                        return@launch
                                    }
                                    delay(3000)
                                }
                                vm.repository.toast("支付结果未确认")
                                load()
                            } finally {
                                paying = false
                            }
                        }
                    }, enabled = !paying, modifier = Modifier.fillMaxWidth()) { Text(if (paying) "正在查询支付结果" else "扫码收款") }
                    if (paying && pendingTrade.isNotBlank()) Text("支付单号 $pendingTrade")
                }
                if (method?.type == "inner" || method?.type == "out") {
                    Text(if (method.type == "inner") "会员券和套餐券在上方列表里选择" else "外部券请到验券页，先查券再核销")
                }
                if (allowQuota) {
                    OutlinedTextField(quota, { quota = it }, Modifier.fillMaxWidth(), label = { Text("手工定额金额") })
                    OutlinedTextField(quotaRemark, { quotaRemark = it }, Modifier.fillMaxWidth(), label = { Text("定额备注") })
                    Button(onClick = {
                        scope.launch {
                            vm.repository.addCashSettle(orderId, "1", quota, "1").orToast(vm.repository)
                                ?.let { vm.repository.toast("已记入手工定额"); load() }
                        }
                    }, modifier = Modifier.fillMaxWidth()) { Text("手工定额") }
                }
                Button(onClick = {
                    val snapshot = current ?: return@Button
                    scope.launch {
                        vm.repository.finishPay(snapshot, remark, quotaRemark).orToast(vm.repository)?.let {
                            vm.repository.toast("结账成功")
                            onDone()
                        }
                    }
                }, modifier = Modifier.fillMaxWidth()) { Text("清台结账") }
            }
        }
    }
    if (couponKind.isNotBlank()) {
        AlertDialog(
            onDismissRequest = { couponKind = "" },
            title = { Text(if (couponKind == "pack") "套餐券" else "会员券") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    if (accounts.isEmpty()) Text("没有可用的券")
                    accounts.forEach { account ->
                        Text("${account.name}  ${account.mobile}", fontWeight = FontWeight.Bold)
                        account.coupons.forEach { coupon ->
                            TextButton(onClick = {
                                val settleValue = when {
                                    couponKind == "pack" -> "11"
                                    coupon.settleType == "3" -> "3"
                                    else -> "2"
                                }
                                couponKind = ""
                                scope.launch {
                                    vm.repository.applyCoupon(orderId, settleValue, coupon).orToast(vm.repository)
                                        ?.let { vm.repository.toast("已使用${coupon.name}"); load() }
                                }
                            }) { Text("${coupon.name}  ${money(coupon.money)}") }
                        }
                    }
                }
            },
            confirmButton = { TextButton(onClick = { couponKind = "" }) { Text("关闭") } },
        )
    }
}

@Composable
fun OrderListScreen(onOpen: (OrderSummary) -> Unit) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var keyword by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var orders by remember { mutableStateOf<List<OrderSummary>>(emptyList()) }
    var page by remember { mutableIntStateOf(1) }
    var more by remember { mutableStateOf(false) }
    val tabs = listOf("" to "全部", "0" to "未完成", "1" to "已完成")

    fun load(reset: Boolean = true) {
        scope.launch {
            val next = if (reset) 1 else page + 1
            val rows = vm.repository.orders(status, keyword.trim(), next.toString()).orToast(vm.repository).orEmpty()
            val known = if (reset) emptySet() else orders.map { it.orderId }.toSet()
            val fresh = rows.filter { it.orderId !in known }
            orders = if (reset) rows.distinctBy { it.orderId } else (orders + fresh).distinctBy { it.orderId }
            page = next
            more = fresh.size >= 10
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
                Card(onClick = { onOpen(order) }) {
                    Column(Modifier.padding(12.dp)) {
                        Text("${order.areaName} ${order.tableNo}", fontWeight = FontWeight.Bold)
                        Text(order.orderNo.ifBlank { order.orderId })
                        Text("${order.payStatusName}    ${money(order.income)}")
                        Text(order.createTime, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
            if (more) {
                item {
                    TextButton(onClick = { load(reset = false) }, modifier = Modifier.fillMaxWidth()) { Text("加载更多") }
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
fun SwitchTableScreen(orderId: String, merge: Boolean, onBack: () -> Unit) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var search by remember { mutableStateOf("") }
    var tables by remember { mutableStateOf<List<DiningTable>>(emptyList()) }

    fun load() {
        scope.launch {
            tables = vm.repository.tables("", "", if (merge) "" else "10", search.trim()).orToast(vm.repository).orEmpty()
        }
    }

    LaunchedEffect(Unit) { load() }

    Scaffold(topBar = { CashierTopBar(if (merge) "并台" else "换台", onBack = onBack) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            OutlinedTextField(
                search,
                { search = it },
                Modifier.fillMaxWidth().padding(12.dp),
                label = { Text("搜索空闲桌") },
                trailingIcon = { TextButton(onClick = { load() }) { Text("搜索") } },
            )
            LazyColumn(contentPadding = PaddingValues(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                itemsIndexed(tables, key = { index, table -> "${table.id}#$index" }) { _, table ->
                    Card(onClick = {
                        scope.launch {
                            val result = if (merge) vm.repository.mergeTable(orderId, table.id) else vm.repository.switchTable(table.id, orderId)
                            result.orToast(vm.repository)?.let {
                                vm.repository.toast(if (merge) "并台成功" else "换台成功")
                                onBack()
                            }
                        }
                    }) {
                        Column(Modifier.padding(12.dp)) {
                            Text("${table.areaName} ${table.no}", fontWeight = FontWeight.Bold)
                            Text(table.statusName)
                        }
                    }
                }
            }
        }
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
