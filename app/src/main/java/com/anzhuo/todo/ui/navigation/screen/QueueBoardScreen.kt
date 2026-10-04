package com.anzhuo.todo.ui.navigation.screen

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Canvas
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import kotlin.math.min

private val BoardBlack = Color(0xFF000000)
private val LaneAmber = Color(0xFFF0B043)
private val LetterRed = Color(0xFFE4452A)
private val CallingRed = Color(0xFFE0362C)
private val WaitingGreen = Color(0xFF2F8F5E)
private val PanelGreen = Color(0xFF5C8C4A)
private val PillGreen = Color(0xFF3F6A38)
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

private fun sampleLane(letter: String, callingFirst: Boolean) = QueueLane(
    letter = letter,
    partySize = "1-2人",
    checkedIn = 24,
    total = 64,
    tickets = List(12) { index ->
        QueueTicket(label = "A145延", calling = callingFirst && index == 0)
    },
)

private val SampleLanes = listOf(
    sampleLane("A", callingFirst = true),
    sampleLane("B", callingFirst = false),
    sampleLane("C", callingFirst = false),
    sampleLane("F", callingFirst = false),
)

@Composable
fun QueueBoardScreen() {
    val view = LocalView.current
    DisposableEffect(view) {
        val activity = view.context.findActivity()
        val previousOrientation = activity?.requestedOrientation
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        val controller = activity?.window?.let { window ->
            WindowCompat.getInsetsController(window, view).also {
                it.hide(WindowInsetsCompat.Type.systemBars())
                it.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        onDispose {
            if (activity != null && previousOrientation != null) {
                activity.requestedOrientation = previousOrientation
            }
            controller?.show(WindowInsetsCompat.Type.systemBars())
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
                SampleLanes.forEach { lane ->
                    QueueLaneCard(lane, scale, Modifier.weight(1f))
                }
            }
            BrandPanel(scale, Modifier.weight(1f).fillMaxHeight())
        }
    }
}

@Composable
private fun QueueLaneCard(lane: QueueLane, scale: Float, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape((18f * scale).dp))
            .background(LaneAmber)
            .padding(horizontal = (18f * scale).dp, vertical = (6f * scale).dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            Modifier.width((168f * scale).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                lane.letter,
                color = LetterRed,
                fontSize = (52f * scale).sp,
                fontWeight = FontWeight.Black,
                style = TightText
            )
            Spacer(Modifier.width((10f * scale).dp))
            Column {
                Text(
                    lane.partySize,
                    color = BoardWhite,
                    fontSize = (22f * scale).sp,
                    fontWeight = FontWeight.Bold,
                    style = TightText
                )
                Spacer(Modifier.height((6f * scale).dp))
                Text(
                    "签到  ${lane.checkedIn}",
                    color = BoardWhite,
                    fontSize = (16f * scale).sp,
                    style = TightText
                )
                Spacer(Modifier.height((2f * scale).dp))
                Text(
                    "总  ${lane.total}",
                    color = BoardWhite,
                    fontSize = (16f * scale).sp,
                    style = TightText
                )
            }
        }
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy((8f * scale).dp)
        ) {
            lane.tickets.chunked(6).forEach { row ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    row.forEach { ticket -> TicketChip(ticket, scale) }
                }
            }
        }
    }
}

@Composable
private fun TicketChip(ticket: QueueTicket, scale: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = if (ticket.calling) "叫号" else "等",
            color = BoardWhite,
            fontSize = (13f * scale).sp,
            fontWeight = FontWeight.Bold,
            style = TightText,
            modifier = Modifier
                .clip(RoundedCornerShape((3f * scale).dp))
                .background(if (ticket.calling) CallingRed else WaitingGreen)
                .padding(horizontal = (4f * scale).dp, vertical = (2f * scale).dp)
        )
        Spacer(Modifier.width((4f * scale).dp))
        Text(
            ticket.label,
            color = BoardWhite,
            fontSize = (18f * scale).sp,
            fontWeight = FontWeight.Medium,
            style = TightText
        )
    }
}

@Composable
private fun BrandPanel(scale: Float, modifier: Modifier = Modifier) {
    Column(
        modifier
            .clip(RoundedCornerShape((22f * scale).dp))
            .background(PanelGreen)
            .padding(horizontal = (16f * scale).dp, vertical = (14f * scale).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "鲜主",
                color = BoardWhite,
                fontSize = (46f * scale).sp,
                fontWeight = FontWeight.Black,
                style = TightText
            )
            Spacer(Modifier.width((8f * scale).dp))
            Column {
                Text(
                    "牛肉海鲜",
                    color = BoardWhite,
                    fontSize = (18f * scale).sp,
                    fontWeight = FontWeight.Bold,
                    style = TightText
                )
                Text(
                    "自选火锅",
                    color = BoardWhite,
                    fontSize = (18f * scale).sp,
                    fontWeight = FontWeight.Bold,
                    style = TightText
                )
            }
        }
        Spacer(Modifier.height((12f * scale).dp))
        Text(
            "鲜主牛肉海鲜火锅",
            color = BoardWhite,
            fontSize = (18f * scale).sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TightText
        )
        Text(
            "(百联又一城店)",
            color = BoardWhite,
            fontSize = (18f * scale).sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TightText
        )
        Spacer(Modifier.height((16f * scale).dp))
        Box(
            Modifier
                .width((150f * scale).dp)
                .height((96f * scale).dp)
                .clip(RoundedCornerShape((4f * scale).dp))
                .background(LogoGray)
        )
        Spacer(Modifier.weight(1f))
        Text(
            "排队取号&扫码签到",
            color = BoardWhite,
            fontSize = (18f * scale).sp,
            fontWeight = FontWeight.Medium,
            style = TightText
        )
        Spacer(Modifier.height((8f * scale).dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                "过滤空号，排队更快".forEach { character ->
                    Text(
                        character.toString(),
                        color = BoardWhite,
                        fontSize = (13f * scale).sp,
                        lineHeight = (15f * scale).sp,
                        style = TightText
                    )
                }
            }
            Spacer(Modifier.width((8f * scale).dp))
            QrMark(Modifier.width((150f * scale).dp))
        }
        Spacer(Modifier.height((12f * scale).dp))
        Row(
            Modifier
                .clip(RoundedCornerShape((20f * scale).dp))
                .background(PillGreen)
                .padding(horizontal = (12f * scale).dp, vertical = (5f * scale).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("🎁", fontSize = (16f * scale).sp)
            Spacer(Modifier.width((4f * scale).dp))
            Text(
                "排队码截图无效",
                color = BoardWhite,
                fontSize = (15f * scale).sp,
                fontWeight = FontWeight.Medium,
                style = TightText
            )
        }
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
