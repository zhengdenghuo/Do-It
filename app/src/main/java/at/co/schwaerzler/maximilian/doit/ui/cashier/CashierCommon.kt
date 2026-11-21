package at.co.schwaerzler.maximilian.doit.ui.cashier

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import at.co.schwaerzler.maximilian.doit.pos.CashierRepository
import at.co.schwaerzler.maximilian.doit.pos.CashierViewModel

val CashierBlue = Color(0xFF1384FF)
val CashierHeader = Color(0xFF5798FF)
val CashierPage = Color(0xFFF6F6F6)
val CashierText = Color(0xFF333333)
val CashierTextMuted = Color(0xFF696969)
val CashierPrice = Color(0xFFFF6030)

private val CashierLight = lightColorScheme(
    primary = CashierBlue,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD6E8FF),
    onPrimaryContainer = Color(0xFF0D3F86),
    secondary = CashierPrice,
    onSecondary = Color.White,
    background = CashierPage,
    onBackground = CashierText,
    surface = Color.White,
    onSurface = CashierText,
    surfaceVariant = Color(0xFFF5F5F5),
    outline = Color(0xFFE1E1E1),
)

@Composable
fun CashierTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = CashierLight, content = content)
}

@Composable
fun cashierViewModel(): CashierViewModel {
    val activity = LocalContext.current as ComponentActivity
    return viewModel(viewModelStoreOwner = activity, factory = CashierViewModel.Factory)
}

fun tableCardColor(status: String): Color = when (status) {
    "10" -> Color(0xFF2FBE78)
    "20" -> Color(0xFFF07178)
    "30", "40", "50" -> Color(0xFFA0A4AB)
    else -> Color(0xFFF2C94C)
}

fun statusDotColor(status: String): Color = when (status) {
    "10" -> Color(0xFF02D19B)
    "20" -> Color(0xFFFBAD24)
    "30" -> Color(0xFFF77A7E)
    else -> Color.White
}

fun money(value: String): String {
    val raw = value.trim().removePrefix("¥").removePrefix("￥")
    if (raw.isBlank()) return "¥0.00"
    return if (raw.startsWith("¥") || raw.startsWith("￥")) raw else "¥$raw"
}

fun decodeCaptcha(code: String): ImageBitmap? {
    val payload = code.substringAfter("base64,", code).trim()
    if (payload.length < 80) return null
    return runCatching {
        val bytes = Base64.decode(payload, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size)?.asImageBitmap()
    }.getOrNull()
}

suspend fun <T> Result<T>.orToast(repository: CashierRepository): T? = fold(
    onSuccess = { it },
    onFailure = {
        repository.toast(it.message?.ifBlank { null } ?: "请求失败")
        null
    },
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CashierTopBar(
    title: String,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (onBack != null) {
                IconButton(onClick = onBack) { Text("返回", color = Color.White) }
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = CashierHeader,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
    )
}

enum class NoticeTone { Success, Error, Info }

data class CashierNotice(val id: Long, val text: String, val tone: NoticeTone)

fun noticeTone(message: String): NoticeTone {
    val text = message.trim()
    return when {
        text.contains("成功") || text.startsWith("已") -> NoticeTone.Success
        text.contains("再按一次") || text.contains("未确认") -> NoticeTone.Info
        else -> NoticeTone.Error
    }
}

@Composable
fun CashierNoticeHost(notices: List<CashierNotice>, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = 12.dp, start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        notices.takeLast(2).forEach { notice ->
            CashierNoticeCard(notice)
        }
    }
}

@Composable
private fun CashierNoticeCard(notice: CashierNotice) {
    val accent = when (notice.tone) {
        NoticeTone.Success -> Color(0xFF1FA971)
        NoticeTone.Error -> Color(0xFFE85D4C)
        NoticeTone.Info -> CashierBlue
    }
    val mark = when (notice.tone) {
        NoticeTone.Success -> "✓"
        NoticeTone.Error -> "!"
        NoticeTone.Info -> "i"
    }
    Row(
        Modifier
            .fillMaxWidth()
            .shadow(12.dp, RoundedCornerShape(18.dp))
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(accent),
            contentAlignment = Alignment.Center,
        ) {
            Text(mark, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
        Text(
            notice.text,
            modifier = Modifier.padding(start = 12.dp),
            color = CashierText,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
        )
    }
}
