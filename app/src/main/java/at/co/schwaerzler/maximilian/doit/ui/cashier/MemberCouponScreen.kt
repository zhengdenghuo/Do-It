package at.co.schwaerzler.maximilian.doit.ui.cashier

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.co.schwaerzler.maximilian.doit.R
import at.co.schwaerzler.maximilian.doit.pos.MemberAccount
import at.co.schwaerzler.maximilian.doit.pos.MemberCoupon
import at.co.schwaerzler.maximilian.doit.pos.SettleOrder
import at.co.schwaerzler.maximilian.doit.pos.cashierField
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject

@Composable
internal fun MemberCouponScreen(order: SettleOrder, isPack: Boolean, onBack: () -> Unit, onApplied: () -> Unit) {
    val repository = cashierViewModel().repository
    val scope = rememberCoroutineScope()
    val focus = LocalFocusManager.current
    val initial = remember(order, isPack) {
        (order.settle + order.coupon).filterIsInstance<JsonObject>().filter {
            val type = it.cashierField("settle_type")
            if (isPack) type in setOf("11", "12") && (it.cashierField("settle_id").toDoubleOrNull() ?: 0.0) < 100_000_000
            else type in setOf("2", "3")
        }.distinctBy(::couponKey)
    }
    var selected by remember(initial) { mutableStateOf(initial) }
    var accounts by remember { mutableStateOf<List<MemberAccount>>(emptyList()) }
    var phone by remember { mutableStateOf("") }
    var query by remember { mutableStateOf("") }
    var attempt by remember { mutableIntStateOf(0) }
    var loading by remember { mutableStateOf(true) }
    var failed by remember { mutableStateOf(false) }
    var submitting by remember { mutableStateOf(false) }

    fun search() {
        if (phone.length != 11) {
            repository.toast("请输入正确的手机号")
            return
        }
        focus.clearFocus()
        query = phone
        attempt++
    }

    LaunchedEffect(order.orderId, isPack, query, attempt) {
        loading = true
        failed = false
        val result = if (isPack) {
            repository.packCoupons(order.tableId, order.orderId, order.shopSupplierId, query)
        } else {
            repository.memberCoupons(order.tableId, order.orderId, order.shopSupplierId, query)
        }
        accounts = result.orToast(repository).orEmpty()
        failed = result.isFailure
        loading = false
    }
    BackHandler { if (!submitting) onBack() }

    Scaffold(
        modifier = Modifier.imePadding(),
        containerColor = Color(0xFFDDDDDD),
        topBar = {
            SettlementHeader(
                title = if (isPack) "选择会员卡券" else "选择会员优惠",
                onBack = { if (!submitting) onBack() },
                onPrint = null,
                showPrint = false,
            )
        },
        bottomBar = {
            SettlementAction(
                label = if (submitting) "提交中" else "确定",
                enabled = !loading && !failed && !submitting && (selected.isNotEmpty() || initial.isNotEmpty()),
                primary = true,
                modifier = Modifier.fillMaxWidth().navigationBarsPadding().padding(16.dp),
                onClick = {
                    if (!submitting) {
                        val picked = selected
                        val settleValue = when {
                            isPack -> "11"
                            picked.any { it.cashierField("settle_type") == "3" } -> "3"
                            else -> "2"
                        }
                        focus.clearFocus()
                        submitting = true
                        scope.launch {
                            try {
                                if (repository.applyCoupons(order.orderId, settleValue, picked).orToast(repository) != null) {
                                    onApplied()
                                }
                            } finally {
                                submitting = false
                            }
                        }
                    }
                },
                shape = RoundedCornerShape(5.dp),
            )
        },
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            Row(
                Modifier.fillMaxWidth().background(Color.White).padding(horizontal = 13.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BasicTextField(
                    value = phone,
                    onValueChange = { phone = it.filter { digit -> digit in '0'..'9' }.take(11) },
                    modifier = Modifier.weight(1f),
                    enabled = !submitting,
                    textStyle = TextStyle(color = SettlementText, fontSize = 14.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { search() }),
                    decorationBox = { input ->
                        Row(
                            Modifier.fillMaxWidth().heightIn(min = 30.dp).background(Color(0xFFE8F3EC)).padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                        ) {
                            Image(painterResource(R.drawable.ic_member_coupon_search), null, Modifier.size(15.dp))
                            Box(Modifier.weight(1f)) {
                                if (phone.isEmpty()) Text("请输入手机号", color = Color(0xFF999999), fontSize = 14.sp)
                                input()
                            }
                        }
                    },
                )
                TextButton(
                    enabled = !submitting,
                    onClick = {
                        if (query.isNotEmpty() && query == phone) {
                            phone = ""
                            query = ""
                            focus.clearFocus()
                        } else search()
                    },
                ) { Text(if (query.isNotEmpty() && query == phone) "取消" else "搜索", color = SettlementText) }
            }
            if (!isPack) {
                Text(
                    "【会员优惠】最多只能选择一个折扣（会员折扣/折扣券）+一张满减券哦~",
                    Modifier.padding(horizontal = 13.dp, vertical = 8.dp),
                    color = Color(0xFFF6992C), fontSize = 12.sp,
                )
            }
            if (loading || failed || accounts.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    when {
                        loading -> Text("正在读取优惠券", color = SettlementText)
                        failed -> TextButton(onClick = { attempt++ }) { Text("读取失败，重试") }
                        else -> Text("暂无数据", color = SettlementText)
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 13.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(accounts) { account ->
                        val discount = account.equity.toBigDecimalOrNull()
                        val memberSelected = selected.any { isMemberDiscount(it) && it.cashierField("user_id") == account.userId }
                        MemberCouponAccount(
                            account = account,
                            showDiscount = !isPack,
                            memberSelected = memberSelected,
                            enabled = !submitting,
                            selectedKeys = selected.map(::couponKey).toSet(),
                            onMember = {
                                if (discount != null && discount.signum() > 0 && account.userId.isNotBlank()) {
                                    selected = selected.filterNot { isMemberDiscount(it) || (!memberSelected && couponType(it) == "20") }
                                    if (!memberSelected) {
                                        selected = selected + buildJsonObject {
                                            put("settle_type", JsonPrimitive("2"))
                                            put("user_id", JsonPrimitive(account.userId))
                                            put("radio", JsonPrimitive(account.equity))
                                        }
                                    }
                                }
                            },
                            onCoupon = { coupon ->
                                val key = couponKey(coupon.raw)
                                if (selected.any { couponKey(it) == key }) {
                                    selected = selected.filterNot { couponKey(it) == key }
                                } else {
                                    val type = couponType(coupon.raw)
                                    selected = selected.filterNot {
                                        !isPack && (it.cashierField("settle_type") == "3" ||
                                            (type == "20" && isMemberDiscount(it)))
                                    } + coupon.raw
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MemberCouponAccount(
    account: MemberAccount,
    showDiscount: Boolean,
    memberSelected: Boolean,
    enabled: Boolean,
    selectedKeys: Set<String>,
    onMember: () -> Unit,
    onCoupon: (MemberCoupon) -> Unit,
) {
    var unavailable by remember(account.userId, account.mobile) { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth().background(Color.White).padding(10.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(painterResource(R.drawable.ic_member_coupon_avatar), null, Modifier.size(32.dp))
            Text(maskedMobile(account.mobile), Modifier.padding(horizontal = 6.dp), color = SettlementText, fontSize = 14.sp)
            if (account.name.isNotBlank()) {
                val tier = when {
                    "一" in account.name -> R.drawable.ic_member_coupon_tier_one
                    "二" in account.name -> R.drawable.ic_member_coupon_tier_two
                    "三" in account.name -> R.drawable.ic_member_coupon_tier_three
                    "四" in account.name -> R.drawable.ic_member_coupon_tier_four
                    else -> R.drawable.ic_member_coupon_tier_five
                }
                Image(painterResource(tier), account.name, Modifier.size(20.dp))
            }
            if (showDiscount) {
                val equity = account.equity.toBigDecimalOrNull()?.movePointLeft(1)?.stripTrailingZeros()?.toPlainString()
                Text("全场菜金", Modifier.weight(1f).padding(start = 6.dp), color = SettlementText, fontSize = 12.sp)
                if (equity != null) Text("${equity}折", color = SettlementRed, fontSize = 13.sp)
                if (equity != null && account.userId.isNotBlank()) {
                    Image(
                        painterResource(if (memberSelected) R.drawable.ic_member_coupon_checked else R.drawable.ic_member_coupon_unchecked),
                        "会员折扣", Modifier.padding(start = 5.dp).size(24.dp).clickable(enabled = enabled, onClick = onMember),
                    )
                }
            }
        }
        Row(Modifier.padding(vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            Text("可用(${account.coupons.size})", Modifier.clickable { unavailable = false },
                color = if (!unavailable) SettlementGreen else SettlementText, fontSize = 14.sp)
            Text("不可用(${account.unavailableCoupons.size})", Modifier.clickable { unavailable = true },
                color = if (unavailable) SettlementGreen else SettlementText, fontSize = 14.sp)
        }
        val coupons = if (unavailable) account.unavailableCoupons else account.coupons
        if (coupons.isEmpty()) Text(if (unavailable) "暂无不可用的券" else "暂无可用的券哦~", color = SettlementText, fontSize = 13.sp)
        coupons.forEach { coupon ->
            val hasId = coupon.raw.cashierField("settle_id").isNotBlank()
            MemberCouponCard(coupon, selected = couponKey(coupon.raw) in selectedKeys, available = !unavailable && hasId,
                enabled = enabled, onClick = { onCoupon(coupon) })
        }
    }
}

@Composable
private fun MemberCouponCard(coupon: MemberCoupon, selected: Boolean, available: Boolean, enabled: Boolean, onClick: () -> Unit) {
    val data = coupon.raw
    val type = couponType(data)
    val content = data.cashierField("content")
    val minimum = data.cashierField("min_price")
    val validity = listOf("start_time", "end_time").mapNotNull { (data[it] as? JsonObject)?.cashierField("text")?.ifBlank { null } }
    var expanded by remember(data) { mutableStateOf(false) }
    val value = when (type) {
        "20" -> data.cashierField("discount").ifBlank { null }?.plus("折")
        "30" -> null
        else -> coupon.money.ifBlank { null }?.plus("元")
    }
    Column(
        Modifier.fillMaxWidth().padding(bottom = 6.dp).background(SettlementPanel, RoundedCornerShape(8.dp))
            .clickable(enabled = enabled && available, role = Role.Checkbox, onClick = onClick).padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(coupon.name, Modifier.weight(1f), color = SettlementText, fontSize = 14.sp)
            if (value != null) Text(value, color = if (available) SettlementRed else Color(0xFF999999), fontSize = 15.sp)
            Image(
                painterResource(when {
                    !available -> R.drawable.ic_member_coupon_unavailable
                    selected -> R.drawable.ic_member_coupon_checked
                    else -> R.drawable.ic_member_coupon_unchecked
                }),
                if (selected) "已选" else if (available) "未选" else "不可用",
                Modifier.size(20.dp),
            )
        }
        if (validity.isNotEmpty()) Text(validity.joinToString("至"), color = Color(0xFF666666), fontSize = 12.sp)
        if (type == "10" || type == "40") {
            Text(if (minimum.toBigDecimalOrNull()?.signum() == 1) "满${minimum}可用" else "无门槛", color = SettlementText, fontSize = 12.sp)
        }
        val reason = data.cashierField("no_use_reason")
        if (reason.isNotBlank()) Text(reason, color = SettlementRed, fontSize = 12.sp)
        if (content.isNotBlank()) {
            Text(content, color = SettlementText, fontSize = 12.sp,
                maxLines = if (expanded) Int.MAX_VALUE else 2, overflow = TextOverflow.Ellipsis)
            if (content.length >= 40) {
                Text(if (expanded) "收起" else "展开", Modifier.clickable { expanded = !expanded },
                    color = SettlementGreen, fontSize = 12.sp)
            }
        }
    }
}

private fun couponType(data: JsonObject): String =
    (data["coupon_type"] as? JsonObject)?.cashierField("value") ?: data.cashierField("coupon_type")

private fun isMemberDiscount(data: JsonObject): Boolean = data.cashierField("settle_type") == "2"

private fun couponKey(data: JsonObject): String {
    val id = data.cashierField("settle_id")
    return if (id.isNotBlank()) "coupon:$id" else "member:${data.cashierField("user_id")}"
}

private fun maskedMobile(value: String): String =
    if (value.length >= 11 && '*' !in value) value.dropLast(8) + "****" + value.takeLast(4) else value
