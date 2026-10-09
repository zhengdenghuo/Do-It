package com.anzhuo.todo.ui.navigation.screen

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anzhuo.todo.R
import com.anzhuo.todo.data.queue.QueueBoardUiState
import com.anzhuo.todo.data.queue.QueueBoardViewModel
import com.anzhuo.todo.data.queue.QueueSummaryData
import com.anzhuo.todo.data.queue.bannerVariant
import com.anzhuo.todo.data.queue.QueueTableItem
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import java.util.LinkedHashMap
import kotlin.math.min

private val BoardBlack = Color(0xFF000000)
private val LaneAmber = Color(0xFFF0B043)
private val LetterRed = Color(0xFFE4452A)
private val CallingRed = Color(0xFFE0362C)
private val WaitingGreen = Color(0xFF2F8F5E)
private val PartyBadge = Color(0xFF143528)
private val PanelGreen = Color(0xFF5C8C4A)
private val PillGreen = Color(0xFF3F6A38)
private val SideAmber = Color(0xFFF6AE47)
private val LogoGray = Color(0xFFD5D5D5)
private val BoardWhite = Color(0xFFFFFFFF)

private val TightText = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))

private data class QueueTicket(val label: String, val calling: Boolean = false)

private data class QueueLane(
    val letter: String,
    val partySize: String,
    val checkedIn: Int,
    val total: Int,
    val tickets: List<QueueTicket>,
)

private const val CALLING_STATUS = 30
private const val TICKETS_PER_ROW = 6
private const val MAX_TICKETS = 12

@Composable
fun QueueBoardScreen(viewModel: QueueBoardViewModel = viewModel(factory = QueueBoardViewModel.Factory)) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val view = LocalView.current
    DisposableEffect(view) {
        val activity = view.context.findActivity()
        val previousOrientation = activity?.requestedOrientation
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        val insets = activity?.window?.let { window ->
            WindowInsetsControllerCompat(window, view).apply {
                hide(WindowInsetsCompat.Type.systemBars())
                systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        onDispose {
            insets?.show(WindowInsetsCompat.Type.systemBars())
            if (activity != null && previousOrientation != null) {
                activity.requestedOrientation = previousOrientation
            }
        }
    }

    BoxWithConstraints(
        Modifier
            .fillMaxSize()
            .background(BoardBlack)
    ) {
        val scale = min(maxWidth.value / 1280f, maxHeight.value / 720f)
        val pad = (14f * scale).dp
        val gap = (12f * scale).dp
        val summary = uiState.summary
        if (summary == null) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(PanelGreen)
                    .padding(pad),
                contentAlignment = Alignment.Center
            ) {
                WaitingPanel(uiState, scale, Modifier.fillMaxWidth(0.72f))
            }
        } else {
            val lanes = summary.toLanes()
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(pad),
                horizontalArrangement = Arrangement.spacedBy(gap)
            ) {
                Column(
                    Modifier
                        .weight(2.45f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(gap)
                ) {
                    if (lanes.isEmpty()) {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(
                                summary.content.ifBlank { "暂无桌型排队" },
                                color = BoardWhite,
                                fontSize = (28f * scale).sp,
                                style = TightText
                            )
                        }
                    } else {
                        lanes.forEach { lane ->
                            QueueLaneCard(lane, scale, Modifier.weight(1f))
                        }
                    }
                }
                BrandPanel(summary.toBrand(), Modifier.weight(1f).fillMaxHeight())
            }
        }
    }
}

private fun QueueSummaryData.toLanes(): List<QueueLane> = tableList.map { it.toLane() }

private fun QueueTableItem.toLane(): QueueLane {
    val letter = tableName.ifBlank { prefix }.ifBlank { "?" }
    return QueueLane(
        letter = letter,
        partySize = "$minNum-${maxNum}人",
        checkedIn = signedCount,
        total = totalCount,
        tickets = signedList.take(MAX_TICKETS).map { item ->
            QueueTicket(
                label = item.queueNoText.ifBlank { letter },
                calling = item.status == CALLING_STATUS,
            )
        }
    )
}

private fun String.toPlainBoardText(title: String): String {
    val decoded = replace("&nbsp;", " ")
        .replace("&quot;", "\"")
        .replace("&#39;", "'")
        .replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&amp;", "&")
    return decoded
        .replace(Regex("(?i)<br\\s*/?>"), "\n")
        .replace(Regex("(?i)</p>"), "\n")
        .replace(Regex("<[^>]*>"), "")
        .lines()
        .map { it.trim() }
        .filter { it.isNotEmpty() && it != title.trim() }
        .take(4)
        .joinToString("\n")
}

private fun QueueSummaryData.toBrand(): BrandContent {
    val open = isOpen == 1
    return BrandContent(
        logoUrl = logo,
        shopName = shopName,
        showBannerImage = bannerShowType != 2,
        bannerImageUrl = bannerConfig.bannerVariant(isOpen),
        bannerText = bannerString.bannerVariant(isOpen).toPlainBoardText(""),
        scanText = if (open) queueTopDesc else groupTopDesc,
        sideText = if (open) queueLeftDesc else groupLeftDesc,
        bottomText = if (open) queueDesc else groupText,
        showNoPhoto = open,
        qrUrl = if (open) qrcodeUrl else groupQrcode,
    )
}

private data class BrandContent(
    val logoUrl: String,
    val shopName: String,
    val showBannerImage: Boolean,
    val bannerImageUrl: String,
    val bannerText: String,
    val scanText: String,
    val sideText: String,
    val bottomText: String,
    val showNoPhoto: Boolean,
    val qrUrl: String,
)

@Composable
private fun QueueLaneCard(lane: QueueLane, scale: Float, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape((18f * scale).dp))
            .background(LaneAmber)
            .padding(start = (12f * scale).dp, end = (16f * scale).dp, top = (4f * scale).dp, bottom = (6f * scale).dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoxWithConstraints(Modifier.fillMaxHeight()) {
            val block = maxHeight.value.coerceAtLeast(1f)
            Row(Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    lane.letter,
                    color = LetterRed,
                    fontSize = (block * 0.72f).sp,
                    lineHeight = (block * 0.72f).sp,
                    fontWeight = FontWeight.Black,
                    style = TightText
                )
                Spacer(Modifier.width((block * 0.1f).dp))
                Column(Modifier.padding(top = (block * 0.02f).dp)) {
                    Text(
                        lane.partySize,
                        color = BoardWhite,
                        fontSize = (block * 0.22f).sp,
                        fontWeight = FontWeight.Bold,
                        style = TightText,
                        modifier = Modifier
                            .clip(RoundedCornerShape((block * 0.05f).dp))
                            .background(PartyBadge)
                            .padding(horizontal = (block * 0.09f).dp, vertical = (block * 0.02f).dp)
                    )
                    Spacer(Modifier.height((block * 0.06f).dp))
                    LaneCount("签到", lane.checkedIn, block)
                    Spacer(Modifier.height((block * 0.02f).dp))
                    LaneCount("总", lane.total, block)
                }
            }
        }
        Spacer(Modifier.width((16f * scale).dp))
        BoxWithConstraints(
            Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            val rowCount = if (lane.tickets.size > TICKETS_PER_ROW) 2 else 1
            val rowGap = maxHeight.value * 0.04f
            val rowHeight = (maxHeight.value - rowGap * (rowCount - 1)) / rowCount
            val cellWidth = maxWidth.value / TICKETS_PER_ROW
            val numberSize = min(cellWidth * 0.28f, rowHeight * 0.46f)
            val badgeSize = min(cellWidth * 0.15f, rowHeight * 0.20f)
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(rowGap.dp, Alignment.CenterVertically)
            ) {
                lane.tickets.chunked(TICKETS_PER_ROW).forEach { row ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(rowHeight.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        row.forEach { ticket ->
                            Box(Modifier.weight(if (ticket.calling) 1.4f else 1f)) {
                                TicketChip(ticket, badgeSize, numberSize)
                            }
                        }
                        repeat(TICKETS_PER_ROW - row.size) {
                            Spacer(Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun LaneCount(label: String, value: Int, blockHeight: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            label,
            color = BoardBlack,
            fontSize = (blockHeight * 0.16f).sp,
            fontWeight = FontWeight.Medium,
            style = TightText,
            modifier = Modifier.width((blockHeight * 0.40f).dp)
        )
        Spacer(Modifier.width((blockHeight * 0.08f).dp))
        Text(
            value.toString(),
            color = BoardBlack,
            fontSize = (blockHeight * 0.26f).sp,
            lineHeight = (blockHeight * 0.26f).sp,
            fontWeight = FontWeight.Black,
            style = TightText
        )
    }
}

@Composable
private fun TicketChip(ticket: QueueTicket, badgeSize: Float, numberSize: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        val badge = if (ticket.calling) "叫号" else "等待"
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape((badgeSize * 0.22f).dp))
                .background(if (ticket.calling) CallingRed else WaitingGreen)
                .padding(horizontal = (badgeSize * 0.35f).dp, vertical = (badgeSize * 0.12f).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            badge.forEach { character ->
                Text(
                    character.toString(),
                    color = BoardWhite,
                    fontSize = badgeSize.sp,
                    lineHeight = (badgeSize * 1.05f).sp,
                    fontWeight = FontWeight.Bold,
                    style = TightText
                )
            }
        }
        Spacer(Modifier.width((numberSize * 0.16f).dp))
        val shownSize = if (ticket.calling) numberSize * 1.28f else numberSize
        Text(
            ticket.label,
            color = if (ticket.calling) CallingRed else BoardWhite,
            fontSize = shownSize.sp,
            lineHeight = shownSize.sp,
            fontWeight = FontWeight.Black,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Clip,
            style = TightText
        )
    }
}

@Composable
private fun WaitingPanel(state: QueueBoardUiState, scale: Float, modifier: Modifier = Modifier) {
    Column(
        modifier
            .clip(RoundedCornerShape((24f * scale).dp))
            .background(LaneAmber)
            .padding(horizontal = (36f * scale).dp, vertical = (28f * scale).dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = when {
                state.loading -> "正在连接门店…"
                else -> state.errorMessage ?: "暂时没有排队数据"
            },
            color = LetterRed,
            fontSize = (28f * scale).sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = TightText
        )
        Spacer(Modifier.height((28f * scale).dp))
        Text(
            "设备 MAC",
            color = BoardBlack,
            fontSize = (16f * scale).sp,
            style = TightText
        )
        Spacer(Modifier.height((8f * scale).dp))
        Text(
            state.mac,
            color = BoardBlack,
            fontSize = (40f * scale).sp,
            fontWeight = FontWeight.Black,
            style = TightText
        )
        Spacer(Modifier.height((12f * scale).dp))
        Text(
            "把这个地址填到后台，绑定这台屏幕",
            color = BoardBlack,
            fontSize = (16f * scale).sp,
            style = TightText
        )
    }
}

@Composable
private fun BrandPanel(brand: BrandContent, modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        val panel = maxHeight.value.coerceAtLeast(1f)
        val panelWidth = maxWidth.value.coerceAtLeast(1f)
        val qr = min(panelWidth * 0.55f, panel * 0.28f)
        Column(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape((panel * 0.03f).dp))
                .background(PanelGreen)
                .padding(horizontal = (panel * 0.028f).dp, vertical = (panel * 0.024f).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (brand.logoUrl.isNotBlank()) {
                RemoteImage(
                    url = brand.logoUrl,
                    modifier = Modifier
                        .width((panelWidth * 0.58f).dp)
                        .height((panel * 0.09f).dp)
                        .clip(RoundedCornerShape((panel * 0.008f).dp)),
                    fallback = {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(LogoGray)
                        )
                    }
                )
            }
            if (brand.shopName.isNotBlank()) {
                Spacer(Modifier.height((panel * 0.012f).dp))
                Text(
                    brand.shopName,
                    color = BoardWhite,
                    fontSize = (panel * 0.04f).sp,
                    lineHeight = (panel * 0.048f).sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = TightText
                )
            }
            if (brand.showBannerImage && brand.bannerImageUrl.isNotBlank()) {
                Spacer(Modifier.weight(1f))
                RemoteImage(
                    url = brand.bannerImageUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((panel * 0.18f).dp)
                        .clip(RoundedCornerShape((panel * 0.012f).dp)),
                    fallback = {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(LogoGray)
                        )
                    }
                )
                Spacer(Modifier.weight(1f))
            } else if (!brand.showBannerImage && brand.bannerText.isNotBlank()) {
                Spacer(Modifier.weight(1f))
                Text(
                    brand.bannerText,
                    color = BoardWhite,
                    fontSize = (panel * 0.026f).sp,
                    lineHeight = (panel * 0.034f).sp,
                    textAlign = TextAlign.Center,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    style = TightText
                )
                Spacer(Modifier.weight(1f))
            } else {
                Spacer(Modifier.weight(1f))
            }
            if (brand.scanText.isNotBlank()) {
                Text(
                    brand.scanText,
                    color = BoardWhite,
                    fontSize = (panel * 0.03f).sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = TightText
                )
                Spacer(Modifier.height((panel * 0.012f).dp))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (brand.sideText.isNotEmpty()) {
                    val count = brand.sideText.length
                    val sideSize = qr * 0.58f / count
                    Column(
                        Modifier
                            .height(qr.dp)
                            .background(SideAmber)
                            .padding(horizontal = (qr * 0.045f).dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        brand.sideText.forEach { character ->
                            Text(
                                character.toString(),
                                color = BoardBlack,
                                fontSize = sideSize.sp,
                                lineHeight = sideSize.sp,
                                style = TightText
                            )
                        }
                    }
                }
                Box(
                    Modifier
                        .width(qr.dp)
                        .aspectRatio(1f)
                        .background(BoardWhite)
                ) {
                    if (brand.qrUrl.isNotBlank()) {
                        RemoteImage(
                            url = brand.qrUrl,
                            modifier = Modifier.fillMaxSize(),
                            fallback = { QrMark(Modifier.fillMaxSize()) }
                        )
                    } else {
                        QrMark(Modifier.fillMaxSize())
                    }
                }
            }
            if (brand.bottomText.isNotBlank()) {
                Spacer(Modifier.height((panel * 0.016f).dp))
                Row(
                    Modifier
                        .clip(RoundedCornerShape(50))
                        .background(PillGreen)
                        .padding(horizontal = (panel * 0.02f).dp, vertical = (panel * 0.008f).dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (brand.showNoPhoto) {
                        Image(
                            painterResource(R.drawable.ic_queue_gift),
                            contentDescription = null,
                            modifier = Modifier.size((panel * 0.032f).dp)
                        )
                        Spacer(Modifier.width((panel * 0.006f).dp))
                    }
                    Text(
                        brand.bottomText,
                        color = BoardWhite,
                        fontSize = (panel * 0.022f).sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TightText
                    )
                }
            }
        }
    }
}

private object RemoteImageCache {
    private const val MAX_ENTRIES = 16
    private val lock = Any()
    private val images = object : LinkedHashMap<String, ImageBitmap>(MAX_ENTRIES, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, ImageBitmap>?) = size > MAX_ENTRIES
    }

    fun get(url: String): ImageBitmap? = synchronized(lock) { images[cacheKey(url)] }

    fun put(url: String, bitmap: ImageBitmap) {
        synchronized(lock) { images[cacheKey(url)] = bitmap }
    }

    private fun cacheKey(url: String) = url.substringBefore('?')
}

@Composable
private fun RemoteImage(
    url: String,
    modifier: Modifier = Modifier,
    fallback: @Composable () -> Unit,
) {
    var image by remember { mutableStateOf(RemoteImageCache.get(url)) }
    LaunchedEffect(url) {
        if (url.isBlank()) return@LaunchedEffect
        val cached = RemoteImageCache.get(url)
        if (cached != null) {
            image = cached
            return@LaunchedEffect
        }
        val loaded = withContext(Dispatchers.IO) {
            runCatching {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.connectTimeout = 8_000
                connection.readTimeout = 8_000
                connection.inputStream.use { BitmapFactory.decodeStream(it) }
            }.getOrNull()?.asImageBitmap()
        }
        if (loaded != null) {
            RemoteImageCache.put(url, loaded)
            image = loaded
        }
    }
    val shown = image
    if (shown == null) {
        Box(modifier) { fallback() }
    } else {
        Image(
            bitmap = shown,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
private fun QrMark(modifier: Modifier = Modifier) {
    Canvas(
        modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(2.dp))
    ) {
        val modules = 25
        val cell = size.minDimension / modules
        drawRect(Color.White)
        fun paint(x: Int, y: Int) {
            drawRect(
                Color.Black,
                topLeft = Offset(x * cell, y * cell),
                size = Size(cell, cell)
            )
        }
        fun finder(originX: Int, originY: Int) {
            for (y in 0..6) {
                for (x in 0..6) {
                    val border = x == 0 || y == 0 || x == 6 || y == 6
                    val core = x in 2..4 && y in 2..4
                    if (border || core) paint(originX + x, originY + y)
                }
            }
        }
        fun inFinder(x: Int, y: Int): Boolean {
            val topLeft = x <= 7 && y <= 7
            val topRight = x >= 17 && y <= 7
            val bottomLeft = x <= 7 && y >= 17
            return topLeft || topRight || bottomLeft
        }
        finder(0, 0)
        finder(18, 0)
        finder(0, 18)
        for (y in 0 until modules) {
            for (x in 0 until modules) {
                if (inFinder(x, y)) continue
                if (x in 9..15 && y in 9..15) continue
                if (((x * 17 + y * 13) % 5) < 2) paint(x, y)
            }
        }
        val center = Offset(size.width / 2f, size.height / 2f)
        val radius = cell * 3.2f
        drawCircle(Color.White, radius = radius, center = center)
        drawCircle(
            Color.Black,
            radius = radius * 0.72f,
            center = center,
            style = Stroke(width = cell * 0.45f)
        )
        drawCircle(Color.Black, radius = radius * 0.28f, center = center)
        drawLine(
            Color.Black,
            start = Offset(center.x + radius * 0.5f, center.y + radius * 0.5f),
            end = Offset(center.x + radius * 1.15f, center.y + radius * 1.15f),
            strokeWidth = cell * 0.55f
        )
    }
}

private fun Context.findActivity(): Activity? {
    var current: Context = this
    while (current is ContextWrapper) {
        if (current is Activity) return current
        current = current.baseContext
    }
    return null
}
