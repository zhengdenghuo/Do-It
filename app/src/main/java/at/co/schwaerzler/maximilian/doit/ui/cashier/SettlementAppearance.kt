package at.co.schwaerzler.maximilian.doit.ui.cashier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import at.co.schwaerzler.maximilian.doit.R
import at.co.schwaerzler.maximilian.doit.pos.PayMethod

internal val SettlementGreen = Color(0xFF468B5F)
internal val SettlementText = Color(0xFF333333)
internal val SettlementRed = Color(0xFFDA041F)
internal val SettlementPanel = Color(0xFFF6F6F6)
internal val SettlementDivider = Color(0x10000000)

@Composable
internal fun SettlementHeader(
    title: String,
    onBack: () -> Unit,
    onPrint: (() -> Unit)?,
    showPrint: Boolean = true,
) {
    Row(
        Modifier.fillMaxWidth().background(SettlementGreen).statusBarsPadding().heightIn(min = 44.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            Modifier.weight(1f).clickable(role = Role.Button, onClick = onBack).padding(start = 5.dp, top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painterResource(R.drawable.ic_settlement_back), contentDescription = "返回")
            Text(title, color = Color.White, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
        if (showPrint) {
            Text(
                "打印预结单",
                modifier = Modifier.clickable(enabled = onPrint != null, role = Role.Button) { onPrint?.invoke() }.padding(11.dp),
                color = Color.White,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
internal fun SettlementDetailLink(label: String, value: String, alignEnd: Boolean, onClick: () -> Unit) {
    Row(
        Modifier.fillMaxWidth().heightIn(min = 44.dp).clickable(role = Role.Button, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(label, color = Color.Black, fontSize = 14.sp)
        Text(
            value,
            modifier = Modifier.weight(1f).padding(horizontal = 10.dp),
            color = SettlementText,
            fontSize = 14.sp,
            textAlign = if (alignEnd) TextAlign.End else TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Image(
            painterResource(R.drawable.ic_settlement_more),
            contentDescription = null,
            modifier = Modifier.padding(end = 10.dp),
        )
    }
    HorizontalDivider(thickness = 0.5.dp, color = SettlementDivider)
}

@Composable
internal fun SettlementAmountRow(label: String, amount: String, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(label, Modifier.weight(1f), color = SettlementText, fontSize = if (label == "商品总价") 15.sp else 13.sp)
        Text(amount, Modifier.padding(end = 12.dp), color = SettlementText, fontSize = 13.sp)
    }
}

@Composable
internal fun SettlementCouponRow(discount: String, available: Int, onClick: () -> Unit) {
    Row(
        Modifier.fillMaxWidth().heightIn(min = 41.dp).clickable(role = Role.Button, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("优惠", Modifier.weight(1f), color = SettlementText, fontSize = 13.sp)
        Box(
            Modifier.height(20.dp).background(Color(0xFFF89E17), RoundedCornerShape(4.dp)).padding(horizontal = 9.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text("${available}张可用", color = SettlementText, fontSize = 13.sp)
        }
        Text(
            "-${money(discount.removePrefix("-"))}",
            Modifier.padding(start = 7.dp),
            color = SettlementRed,
            fontSize = 13.sp,
        )
        Image(painterResource(R.drawable.ic_settlement_discount), contentDescription = null)
    }
}

@Composable
internal fun SettlementPaymentCard(
    method: PayMethod,
    available: Int,
    enabled: Boolean,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    val icon = when {
        method.type == "scan" -> R.drawable.ic_payment_scan
        method.type == "inner" -> R.drawable.ic_payment_member
        method.type == "out" -> R.drawable.ic_payment_coupon
        method.type == "cash" && "美团" in method.name -> R.drawable.ic_payment_marketplace
        method.type == "cash" && "易宝" in method.name -> R.drawable.ic_payment_terminal
        method.type == "cash" -> R.drawable.ic_payment_cash
        else -> null
    }
    val shape = RoundedCornerShape(20.dp)
    Box(
        modifier.heightIn(min = 88.dp).clip(shape).background(Color.White)
            .clickable(enabled = enabled, role = Role.Button, onClick = onClick),
    ) {
        Column(
            Modifier.fillMaxWidth().padding(start = 4.dp, end = 4.dp, top = 11.dp, bottom = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(1.dp),
        ) {
            if (icon != null) Image(painterResource(icon), contentDescription = null, modifier = Modifier.size(33.4.dp))
            Text(method.name.ifBlank { method.type }, color = SettlementText, fontSize = 14.sp, textAlign = TextAlign.Center, maxLines = 2)
            if (method.description.isNotBlank()) {
                Text(
                    method.description, color = Color(0xFF666666), fontSize = 13.sp,
                    textAlign = TextAlign.Center, maxLines = 2, overflow = TextOverflow.Ellipsis,
                )
            }
        }
        if (method.type == "inner") {
            Text(
                "${available}张可用",
                modifier = Modifier.align(Alignment.TopEnd).background(Color(0xFF1384FF), RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 1.dp),
                color = Color.White,
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
internal fun SettlementAction(
    label: String, enabled: Boolean, primary: Boolean, modifier: Modifier, onClick: () -> Unit,
    shape: RoundedCornerShape = RoundedCornerShape(20.dp),
) {
    Box(
        modifier.height(39.3.dp).clip(shape)
            .background(if (primary) SettlementGreen else Color.White)
            .then(if (primary) Modifier else Modifier.border(1.dp, Color(0xFF999999), shape))
            .clickable(enabled = enabled, role = Role.Button, onClick = onClick)
            .padding(horizontal = 5.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(label, color = if (primary) Color.White else SettlementText, fontSize = 14.sp)
    }
}

@Composable
internal fun SettlementPaymentWindow(
    title: String,
    canDismiss: Boolean,
    onDismissRequest: () -> Unit,
    text: @Composable () -> Unit,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = canDismiss,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false,
        ),
    ) {
        Column(
            Modifier.fillMaxWidth(6f / 7f).clip(RoundedCornerShape(10.dp)).background(Color.White)
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp),
        ) {
            Box(Modifier.fillMaxWidth().heightIn(min = 39.dp)) {
                Text(title, Modifier.align(Alignment.Center), color = Color.Black, fontSize = 17.sp)
                Image(
                    painterResource(R.drawable.ic_settlement_close), contentDescription = "关闭",
                    modifier = Modifier.align(Alignment.CenterEnd).size(32.dp)
                        .clickable(enabled = canDismiss, role = Role.Button, onClick = onDismissRequest).padding(10.dp),
                )
            }
            text()
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                dismissButton()
                confirmButton()
            }
        }
    }
}
