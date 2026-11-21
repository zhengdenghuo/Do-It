package at.co.schwaerzler.maximilian.doit.ui.cashier

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.co.schwaerzler.maximilian.doit.pos.CartSnapshot
import at.co.schwaerzler.maximilian.doit.pos.Feed
import at.co.schwaerzler.maximilian.doit.pos.Product
import at.co.schwaerzler.maximilian.doit.pos.ProductCategory
import at.co.schwaerzler.maximilian.doit.pos.Sku
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(tableId: String, tableNo: String, giftOrderId: String?, onBack: () -> Unit, onOrdered: () -> Unit) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var categories by remember { mutableStateOf<List<ProductCategory>>(emptyList()) }
    var categoryId by remember { mutableStateOf("") }
    var search by remember { mutableStateOf("") }
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var productPage by remember { mutableIntStateOf(1) }
    var productMore by remember { mutableStateOf(false) }
    var cart by remember { mutableStateOf(CartSnapshot("", "", emptyList())) }
    var picking by remember { mutableStateOf<Product?>(null) }
    var showCart by remember { mutableStateOf(false) }
    var askSubmit by remember { mutableStateOf(false) }
    var mealNum by remember { mutableStateOf("1") }
    var remark by remember { mutableStateOf("") }
    var printKitchen by remember { mutableStateOf(true) }
    var submitting by remember { mutableStateOf(false) }
    val giftMode = giftOrderId != null
    var giftOrder by remember(giftMode) { mutableStateOf(giftMode) }

    fun loadCart() {
        scope.launch { cart = vm.repository.cart(tableId).getOrElse { cart } }
    }

    fun loadProducts(reset: Boolean = true) {
        scope.launch {
            val next = if (reset) 1 else productPage + 1
            val rows = vm.repository.products(categoryId, search.trim(), next.toString()).orToast(vm.repository).orEmpty()
            val known = if (reset) emptySet() else products.map { it.id }.toSet()
            val fresh = rows.filter { it.id !in known }
            products = if (reset) rows.distinctBy { it.id } else (products + fresh).distinctBy { it.id }
            productPage = next
            productMore = fresh.size >= 10
        }
    }

    LaunchedEffect(Unit) {
        categories = vm.repository.categories().orToast(vm.repository).orEmpty()
        categoryId = categories.firstOrNull()?.id.orEmpty()
        loadProducts()
        loadCart()
    }

    Scaffold(
        topBar = {
            CashierTopBar(
                title = "${tableNo.ifBlank { "桌台" }} · ${if (giftMode) "赠送商品" else "商品"}",
                onBack = onBack,
            ) {
                TextButton(onClick = { loadProducts() }) { Text("搜索") }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(Modifier.clickable { showCart = true }) {
                    Text("已选 ${cart.totalNum.ifBlank { cart.lines.size.toString() }}", fontWeight = FontWeight.Bold)
                    Text(money(cart.totalPay), color = MaterialTheme.colorScheme.primary)
                }
                Button(onClick = { showCart = true }) { Text("去下单") }
            }
        },
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                label = { Text("搜索") },
                singleLine = true,
            )
            Row(Modifier.fillMaxSize()) {
                LazyColumn(Modifier.fillMaxHeight().weight(0.28f).background(Color(0xFFF5F5F5))) {
                    items(categories, key = { it.id }) { category ->
                        val selected = category.id == categoryId
                        Text(
                            category.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(if (selected) Color(0xFFF8F8F8) else Color(0xFFF5F5F5))
                                .clickable {
                                    categoryId = category.id
                                    loadProducts()
                                }
                                .padding(horizontal = 8.dp, vertical = 16.dp),
                            color = if (selected) CashierBlue else CashierText,
                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 14.sp,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        )
                    }
                }
                LazyColumn(Modifier.weight(0.66f).padding(horizontal = 8.dp)) {
                    items(products, key = { it.id }) { product ->
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .clickable { picking = product }
                                .padding(12.dp),
                        ) {
                            Text(product.name, fontWeight = FontWeight.Medium)
                            Text(
                                "${money(product.price)}${if (product.unit.isBlank()) "" else " / ${product.unit}"}",
                                color = CashierPrice,
                            )
                            if (product.stock == "0") Text("已售罄", color = MaterialTheme.colorScheme.secondary)
                        }
                        HorizontalDivider()
                    }
                    if (productMore) {
                        item {
                            TextButton(onClick = { loadProducts(reset = false) }, modifier = Modifier.fillMaxWidth()) {
                                Text("加载更多")
                            }
                        }
                    }
                }
            }
        }
    }

    picking?.let { product ->
        ProductSheet(
            product = product,
            giftMode = giftMode,
            onDismiss = { picking = null },
            onAdd = { sku, attr, feed, describe, gift ->
                scope.launch {
                    val added = vm.repository.addToCart(product, tableId, "1", sku, attr, feed, describe, gift)
                    added.orToast(vm.repository)?.let {
                        vm.repository.toast("已加入购物车")
                        picking = null
                        loadCart()
                    }
                }
            },
        )
    }

    if (showCart) {
        ModalBottomSheet(onDismissRequest = { showCart = false }, sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("购物车", style = MaterialTheme.typography.titleLarge)
                    TextButton(onClick = {
                        scope.launch {
                            vm.repository.clearCart(tableId).orToast(vm.repository)?.let { loadCart() }
                        }
                    }) { Text("清空") }
                }
                cart.lines.forEach { line ->
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text(line.name)
                            val extra = listOf(line.feed, line.describe).filter { it.isNotBlank() }.joinToString(" ")
                            if (extra.isNotBlank()) Text(extra, style = MaterialTheme.typography.bodySmall)
                            Text(money(line.payPrice.ifBlank { line.price }))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            TextButton(onClick = {
                                val next = (line.qty.toIntOrNull() ?: 1) - 1
                                scope.launch {
                                    if (next <= 0) vm.repository.changeCartQty("0", line.cartId) else vm.repository.changeCartQty(next.toString(), line.cartId)
                                    loadCart()
                                }
                            }) { Text("-") }
                            Text(line.qty.ifBlank { "1" })
                            TextButton(onClick = {
                                val next = (line.qty.toIntOrNull() ?: 1) + 1
                                scope.launch {
                                    vm.repository.changeCartQty(next.toString(), line.cartId)
                                    loadCart()
                                }
                            }) { Text("+") }
                        }
                    }
                }
                if (cart.lines.isEmpty()) Text("购物车是空的")
                OutlinedTextField(remark, { remark = it }, Modifier.fillMaxWidth(), label = { Text("备注：请输入备注") })
                OutlinedTextField(mealNum, { mealNum = it }, Modifier.fillMaxWidth(), label = { Text("就餐人数") }, singleLine = true)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(selected = printKitchen, onClick = { printKitchen = !printKitchen }, label = { Text("打印厨单") })
                    if (!giftMode) {
                        FilterChip(selected = giftOrder, onClick = { giftOrder = !giftOrder }, label = { Text("整单赠送") })
                    }
                }
                Button(
                    onClick = { askSubmit = true },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = cart.lines.isNotEmpty() && !submitting,
                ) { Text(if (giftMode) "提交赠送" else "去下单  ${money(cart.totalPay)}") }
            }
        }
    }

    if (askSubmit) {
        AlertDialog(
            onDismissRequest = { if (!submitting) askSubmit = false },
            title = { Text(if (giftMode) "赠送" else "下单") },
            text = { Text(if (giftMode) "确认将当前购物车的商品作为赠品提交？" else "确认提交当前购物车？") },
            confirmButton = {
                TextButton(enabled = !submitting, onClick = {
                    submitting = true
                    scope.launch {
                        try {
                            val existing = vm.repository.orderOnTable(tableId).orToast(vm.repository)?.orderId ?: return@launch
                            if (giftOrderId != null && giftOrderId != existing) {
                                vm.repository.toast("订单已变化，请返回桌台重新确认")
                                return@launch
                            }
                            val done = if (existing.isNotBlank()) {
                                vm.repository.addMeal(tableId, remark, existing, giftOrder, printKitchen)
                            } else {
                                vm.repository.submitOrder(tableId, remark, mealNum.ifBlank { "1" }, giftOrder, printKitchen)
                            }
                            done.orToast(vm.repository)?.let {
                                vm.repository.toast(if (giftMode) "赠送成功" else if (existing.isNotBlank()) "加菜成功" else "下单成功")
                                askSubmit = false
                                showCart = false
                                onOrdered()
                            }
                        } finally {
                            submitting = false
                        }
                    }
                }) { Text(if (submitting) "提交中" else "确定") }
            },
            dismissButton = { TextButton(onClick = { askSubmit = false }, enabled = !submitting) { Text("取消") } },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductSheet(
    product: Product,
    giftMode: Boolean,
    onDismiss: () -> Unit,
    onAdd: (Sku?, String, String, String, Boolean) -> Unit,
) {
    var sku by remember { mutableStateOf(product.skus.firstOrNull()) }
    var attr by remember { mutableStateOf("") }
    var feeds by remember { mutableStateOf(setOf<Feed>()) }
    var describe by remember { mutableStateOf("") }
    var gift by remember(giftMode) { mutableStateOf(giftMode) }
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(product.name, style = MaterialTheme.typography.titleLarge)
            Text(money(sku?.price?.ifBlank { product.price } ?: product.price), color = MaterialTheme.colorScheme.primary)
            if (product.skus.isNotEmpty()) {
                Text("规格")
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    product.skus.forEach { item ->
                        FilterChip(
                            selected = sku?.id == item.id,
                            onClick = { sku = item },
                            label = { Text(item.name.ifBlank { money(item.price) }) },
                        )
                    }
                }
            }
            product.attrs.forEach { group ->
                Text(group.name.ifBlank { "属性" })
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    group.values.forEach { value ->
                        FilterChip(selected = attr == value, onClick = { attr = value }, label = { Text(value) })
                    }
                }
            }
            if (product.feeds.isNotEmpty()) {
                Text("加料")
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    product.feeds.forEach { feed ->
                        FilterChip(
                            selected = feeds.contains(feed),
                            onClick = {
                                feeds = if (feeds.contains(feed)) feeds - feed else feeds + feed
                            },
                            label = { Text("${feed.name} ${money(feed.price)}") },
                        )
                    }
                }
            }
            OutlinedTextField(describe, { describe = it }, Modifier.fillMaxWidth(), label = { Text("备注") })
            if (!giftMode) FilterChip(selected = gift, onClick = { gift = !gift }, label = { Text("赠送") })
            Button(
                onClick = {
                    if (product.stock == "0") return@Button
                    onAdd(sku, attr, feeds.joinToString(",") { it.name }, describe, gift)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = product.stock != "0",
            ) { Text(if (product.stock == "0") "已售罄" else "加入购物车") }
        }
    }
}
