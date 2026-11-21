package at.co.schwaerzler.maximilian.doit.ui.cashier

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Intent
import android.net.Uri
import at.co.schwaerzler.maximilian.doit.pos.AppRelease
import at.co.schwaerzler.maximilian.doit.pos.CashierApi
import at.co.schwaerzler.maximilian.doit.pos.DiningTable
import at.co.schwaerzler.maximilian.doit.pos.TableArea
import at.co.schwaerzler.maximilian.doit.pos.TableStatusChip
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun HallScreen(
    onOpenMenu: (tableId: String, tableNo: String) -> Unit,
    onOpenOrder: (tableId: String, tableNo: String) -> Unit,
    onLogout: () -> Unit,
) {
    val vm = cashierViewModel()
    val scope = rememberCoroutineScope()
    var search by remember { mutableStateOf("") }
    var appliedSearch by remember { mutableStateOf("") }
    var statuses by remember { mutableStateOf<List<TableStatusChip>>(emptyList()) }
    var areas by remember { mutableStateOf<List<TableArea>>(emptyList()) }
    var tables by remember { mutableStateOf<List<DiningTable>>(emptyList()) }
    var status by remember { mutableStateOf("") }
    var areaId by remember { mutableStateOf("") }
    var openClass by remember { mutableStateOf<String?>(null) }
    var loading by remember { mutableStateOf(false) }
    var reloadJob by remember { mutableStateOf<Job?>(null) }
    var tablePage by remember { mutableIntStateOf(1) }
    var tableMore by remember { mutableStateOf(false) }
    var pending by remember { mutableStateOf<DiningTable?>(null) }
    var closing by remember { mutableStateOf<DiningTable?>(null) }
    var release by remember { mutableStateOf<AppRelease?>(null) }
    val context = androidx.compose.ui.platform.LocalContext.current
    val session by vm.session.collectAsState()

    fun reload(reset: Boolean = true) {
        if (!reset && loading) return
        reloadJob?.cancel()
        loading = true
        if (reset) {
            appliedSearch = search.trim()
            tables = emptyList()
            tableMore = false
        }
        val query = appliedSearch
        reloadJob = scope.launch {
            try {
                if (reset) {
                    openClass = vm.repository.shopOpenStatus().getOrNull()?.ifBlank { null }
                    statuses = vm.repository.tableStatus().getOrElse { statuses }
                    if (status.isBlank()) status = statuses.firstOrNull()?.status.orEmpty()
                    areas = vm.repository.areas(status).getOrElse { emptyList() }.distinctBy { it.id }
                    if (areas.none { it.id == areaId }) areaId = areas.firstOrNull()?.id.orEmpty()
                }
                val next = if (reset) 1 else tablePage + 1
                val rows = vm.repository.tables(areaId, "", status, query, next.toString())
                    .orToast(vm.repository) ?: return@launch
                val unique = rows.distinctBy { it.id }
                val known = if (reset) emptySet() else tables.map { it.id }.toSet()
                tables = if (reset) unique else tables + unique.filter { it.id !in known }
                tablePage = next
                tableMore = rows.size >= 30
            } finally {
                if (kotlin.coroutines.coroutineContext[Job]?.isCancelled != true) loading = false
            }
        }
    }

    LaunchedEffect(Unit) {
        reload()
        val remote = vm.repository.cashierVersion().getOrNull()
        if (remote != null && remote.downloadUrl.isNotBlank() && newerVersion(remote.version, CashierApi.COMPATIBILITY_VERSION)) {
            release = remote
        }
    }

    Column(Modifier.fillMaxSize().background(Color(0xFFF3F5F8))) {
        if (openClass != "1" && !loading) {
            Text(
                if (openClass == null) "暂时无法确认门店开班状态" else "门店暂未开班，不可下单",
                modifier = Modifier.fillMaxWidth().background(Color(0xFFFFF3E0)).padding(8.dp),
                color = Color(0xFF8A4B08),
                textAlign = TextAlign.Center,
            )
        }
        Column(Modifier.fillMaxWidth().background(CashierHeader).padding(horizontal = 16.dp, vertical = 14.dp)) {
            Text(
                session?.displayName?.ifBlank { null } ?: "收银员",
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 13.sp,
            )
            Text("桌台", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Row(
                Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                BasicTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .padding(horizontal = 16.dp),
                    singleLine = true,
                    textStyle = androidx.compose.ui.text.TextStyle(color = CashierText, fontSize = 14.sp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { reload() }),
                    decorationBox = { inner ->
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
                            if (search.isEmpty()) Text("搜索桌号", color = Color(0xFFB0B6C0), fontSize = 14.sp)
                            inner()
                        }
                    },
                )
                Box(
                    Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f))
                        .clickable { reload() },
                    contentAlignment = Alignment.Center,
                ) {
                    Text("刷", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(statuses, key = { "${it.status}#${it.desc}" }) { chip ->
                val selectedChip = status == chip.status
                Row(
                    Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (selectedChip) CashierBlue else Color.White)
                        .clickable {
                            status = chip.status
                            reload()
                        }
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(Modifier.size(8.dp).clip(CircleShape).background(statusDotColor(chip.status)))
                    Text(
                        chip.desc,
                        modifier = Modifier.padding(start = 6.dp),
                        color = if (selectedChip) Color.White else CashierText,
                        fontSize = 13.sp,
                        maxLines = 1,
                    )
                    if (chip.num.isNotBlank()) {
                        Text(
                            chip.num,
                            modifier = Modifier.padding(start = 6.dp),
                            color = if (selectedChip) Color.White.copy(alpha = 0.85f) else CashierTextMuted,
                            fontSize = 12.sp,
                        )
                    }
                }
            }
        }
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(areas, key = { "${it.id}#${it.name}" }) { area ->
                val selectedArea = areaId == area.id
                val shape = RoundedCornerShape(18.dp)
                val label = if (area.count.isBlank()) area.name else "${area.name}(${area.count})"
                Text(
                    label,
                    modifier = Modifier
                        .clip(shape)
                        .background(if (selectedArea) CashierBlue else Color.White)
                        .border(1.dp, if (selectedArea) CashierBlue else Color(0xFFD5DAE3), shape)
                        .clickable {
                            areaId = area.id
                            reload()
                        }
                        .padding(horizontal = 14.dp, vertical = 7.dp),
                    color = if (selectedArea) Color.White else CashierText,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
            }
        }
        Box(Modifier.fillMaxSize().padding(top = 8.dp)) {
            if (!loading && tables.isEmpty()) {
                Text(
                    "这个区域还没有桌台",
                    modifier = Modifier.align(Alignment.Center),
                    color = CashierTextMuted,
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                itemsIndexed(tables, key = { index, table -> "${table.id}#$index" }) { _, table ->
                    TableCard(
                        table,
                        onClick = {
                            when {
                                openClass != "1" -> vm.repository.toast("门店暂未开班，不可下单")
                                table.status == "40" || table.status == "50" -> vm.repository.toast("当前桌台不可操作")
                                table.status == "10" -> pending = table
                                table.status == "70" -> onOpenMenu(table.id, "${table.areaName}${table.no}(${table.mealNum}/${table.maxNum})")
                                else -> {
                                    val label = listOf(table.areaName, table.no).filter { it.isNotBlank() }.joinToString("")
                                    onOpenOrder(
                                        table.id,
                                        "$label(${table.mealNum.ifBlank { "0" }}/${table.maxNum.ifBlank { "0" }})",
                                    )
                                }
                            }
                        },
                        onLongClick = {
                            if (openClass != "1") {
                                vm.repository.toast("门店暂未开班，不可操作")
                            } else if (table.status == "40" || table.status == "50" || table.status == "70") {
                                closing = table
                            }
                        },
                    )
                }
                if (tableMore) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        TextButton(onClick = { reload(reset = false) }, modifier = Modifier.fillMaxWidth()) {
                            Text("加载更多")
                        }
                    }
                }
            }
            if (loading && tables.isEmpty()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center), color = CashierBlue)
            }
        }
    }

    pending?.let { table ->
        AlertDialog(
            onDismissRequest = { pending = null },
            title = { Text("开台") },
            text = { Text("确定将 ${table.areaName}${table.no} 开台吗？") },
            confirmButton = {
                TextButton(onClick = {
                    pending = null
                    scope.launch {
                        val opened = vm.repository.openTable(table.id)
                        opened.orToast(vm.repository)?.let {
                            vm.repository.toast("开台成功")
                            reload()
                        }
                    }
                }) { Text("确定") }
            },
            dismissButton = {
                TextButton(onClick = { pending = null }) { Text("取消") }
            },
        )
    }
    closing?.let { table ->
        AlertDialog(
            onDismissRequest = { closing = null },
            title = { Text("关台") },
            text = { Text("确定将 ${table.areaName}${table.no} 关台吗？") },
            confirmButton = {
                TextButton(onClick = {
                    closing = null
                    scope.launch {
                        vm.repository.closeTable(table.id).orToast(vm.repository)?.let {
                            vm.repository.toast("已关台")
                            reload()
                        }
                    }
                }) { Text("确定") }
            },
            dismissButton = { TextButton(onClick = { closing = null }) { Text("取消") } },
        )
    }
    release?.let { info ->
        AlertDialog(
            onDismissRequest = { release = null },
            title = { Text("发现新版本 ${info.version}") },
            text = { Text(info.content.ifBlank { "收银端有新版本，可以下载更新。" }) },
            confirmButton = {
                TextButton(onClick = {
                    release = null
                    runCatching {
                        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(info.downloadUrl)))
                    }
                }) { Text("下载") }
            },
            dismissButton = { TextButton(onClick = { release = null }) { Text("稍后") } },
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TableCard(table: DiningTable, onClick: () -> Unit, onLongClick: () -> Unit) {
    val fill = tableCardColor(table.status)
    val empty = table.status == "10"
    val quiet = table.status == "40" || table.status == "50"
    val title = listOf(table.areaName, table.no).filter { it.isNotBlank() }.joinToString("").ifBlank { "桌" }
    val timeLabel = if (table.status == "30") "买单时间" else "就餐时间"
    Column(
        Modifier
            .fillMaxWidth()
            .height(156.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(fill)
            .combinedClickable(onClick = onClick, onLongClick = onLongClick)
            .padding(horizontal = 8.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = if (empty || (quiet && table.useTime.isBlank())) Arrangement.Center else Arrangement.SpaceBetween,
    ) {
        Text(
            title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = when {
                title.length > 6 -> 16.sp
                title.length > 4 -> 22.sp
                else -> 28.sp
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
        )
        if (empty) {
            Box(
                Modifier
                    .padding(top = 8.dp)
                    .size(22.dp)
                    .border(1.5.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Text("+", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Text(
                "${table.maxNum.ifBlank { "0" }}人桌${if (table.seating) " · 入座中" else ""}",
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 6.dp),
            )
        } else {
            Text(
                table.statusName.ifBlank { "使用中" },
                color = Color.White.copy(alpha = 0.95f),
                fontSize = 13.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            if (table.useTime.isNotBlank() || !quiet) {
                Column(Modifier.fillMaxWidth()) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            "${table.mealNum.ifBlank { "0" }}/${table.maxNum.ifBlank { "0" }}",
                            color = Color.White,
                            fontSize = 12.sp,
                        )
                        Text(timeLabel, color = Color.White.copy(alpha = 0.9f), fontSize = 10.sp)
                    }
                    Text(
                        table.useTime.ifBlank { "--" },
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                    )
                }
            }
        }
    }
}

private fun newerVersion(remote: String, local: String): Boolean {
    val left = remote.split(".").map { it.toIntOrNull() ?: 0 }
    val right = local.split(".").map { it.toIntOrNull() ?: 0 }
    val size = maxOf(left.size, right.size)
    for (index in 0 until size) {
        val delta = left.getOrElse(index) { 0 } - right.getOrElse(index) { 0 }
        if (delta != 0) return delta > 0
    }
    return false
}
