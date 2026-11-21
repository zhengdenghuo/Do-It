package at.co.schwaerzler.maximilian.doit.ui.cashier

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import at.co.schwaerzler.maximilian.doit.pos.OrderSummary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
object CashierLogin

@Serializable
object CashierHome

@Serializable
data class CashierMenu(val tableId: String, val tableNo: String, val giftOrderId: String? = null)

@Serializable
data class CashierOrder(val tableId: String, val tableNo: String)

@Serializable
data class CashierScan(val tableId: String, val tableNo: String)

@Serializable
data class CashierSettle(
    val orderId: String,
    val supplierId: String,
    val userId: String,
    val tableId: String = "",
    val tableLabel: String = "",
)

@Serializable
data class CashierSwitch(val orderId: String, val sourceTableId: String, val merge: Boolean = false)

@Serializable
data class CashierCoupon(
    val orderId: String,
    val tableId: String = "",
    val supplierId: String = "",
    val userId: String = "",
)

@Serializable
data class CashierFinished(val orderId: String)

@Serializable
object CashierPassword

@Serializable
object CashierAbout

@Composable
fun CashierApp() {
    CashierTheme {
        val navController = rememberNavController()
        val vm = cashierViewModel()
        val openHome: () -> Unit = {
            navController.navigate(CashierHome) {
                popUpTo(CashierLogin) { inclusive = true }
                launchSingleTop = true
            }
        }
        var notices by remember { mutableStateOf<List<CashierNotice>>(emptyList()) }
        LaunchedEffect(Unit) {
            vm.messages.collect { text ->
                val notice = CashierNotice(System.nanoTime(), text, noticeTone(text))
                notices = (notices + notice).takeLast(2)
                launch {
                    delay(2600)
                    notices = notices.filterNot { it.id == notice.id }
                }
            }
        }
        Box(Modifier.fillMaxSize()) {
            Scaffold(
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = CashierLogin,
                    modifier = Modifier.padding(padding),
                ) {
                composable<CashierLogin> {
                    LoginScreen(onLoggedIn = openHome)
                }
                composable<CashierHome> {
                    CashierHomeShell(navController)
                }
                composable<CashierMenu> { entry ->
                    val route = entry.toRoute<CashierMenu>()
                    MenuScreen(
                        tableId = route.tableId,
                        tableNo = route.tableNo,
                        giftOrderId = route.giftOrderId,
                        onBack = { navController.popBackStack() },
                        onOrdered = {
                            navController.navigate(CashierOrder(route.tableId, route.tableNo)) {
                                popUpTo<CashierMenu> { inclusive = true }
                                launchSingleTop = true
                            }
                        },
                    )
                }
                composable<CashierOrder> { entry ->
                    val route = entry.toRoute<CashierOrder>()
                    OrderDetailScreen(
                        tableId = route.tableId,
                        tableNo = route.tableNo,
                        onBack = { navController.popBackStack() },
                        onMenu = { navController.navigate(CashierMenu(route.tableId, route.tableNo)) },
                        onGift = { orderId -> navController.navigate(CashierMenu(route.tableId, route.tableNo, orderId)) },
                        onSettle = { orderId, supplierId, userId ->
                            navController.navigate(CashierSettle(orderId, supplierId, userId, route.tableId, route.tableNo))
                        },
                        onSwitch = { orderId -> navController.navigate(CashierSwitch(orderId, route.tableId)) },
                        onMerge = { orderId -> navController.navigate(CashierSwitch(orderId, route.tableId, merge = true)) },
                        onCoupon = { orderId, table, supplier, user ->
                            navController.navigate(CashierCoupon(orderId, table, supplier, user))
                        },
                        onScan = { navController.navigate(CashierScan(route.tableId, route.tableNo)) },
                    )
                }
                composable<CashierScan> { entry ->
                    val route = entry.toRoute<CashierScan>()
                    ScanPlateScreen(
                        tableId = route.tableId,
                        tableNo = route.tableNo,
                        onBack = { navController.popBackStack() },
                        onDone = { navController.popBackStack() },
                    )
                }
                composable<CashierSettle> { entry ->
                    val route = entry.toRoute<CashierSettle>()
                    SettleScreen(
                        orderId = route.orderId,
                        supplierId = route.supplierId,
                        userId = route.userId,
                        tableId = route.tableId,
                        tableLabel = route.tableLabel,
                        onBack = { navController.popBackStack() },
                        onExternalCoupon = { order ->
                            navController.navigate(CashierCoupon(order.orderId, order.tableId, order.shopSupplierId, order.userId))
                        },
                        onDone = {
                            navController.popBackStack(CashierHome, inclusive = false)
                        },
                    )
                }
                composable<CashierSwitch> { entry ->
                    val route = entry.toRoute<CashierSwitch>()
                    SwitchTableScreen(route.orderId, route.sourceTableId, route.merge, onBack = { navController.popBackStack() })
                }
                composable<CashierCoupon> { entry ->
                    val route = entry.toRoute<CashierCoupon>()
                    CouponScreen(
                        orderId = route.orderId,
                        tableId = route.tableId,
                        supplierId = route.supplierId,
                        userId = route.userId,
                        onBack = { navController.popBackStack() },
                    )
                }
                composable<CashierFinished> { entry ->
                    val route = entry.toRoute<CashierFinished>()
                    FinishedOrderScreen(route.orderId, onBack = { navController.popBackStack() })
                }
                composable<CashierPassword> {
                    ChangePasswordScreen(onBack = { navController.popBackStack() })
                }
                composable<CashierAbout> {
                    AboutScreen(onBack = { navController.popBackStack() })
                }
            }
            }
            CashierNoticeHost(notices, Modifier.align(Alignment.TopCenter))
        }
    }
}

@Composable
private fun CashierHomeShell(navController: NavHostController) {
    var tab by remember { mutableIntStateOf(0) }
    var lastBack by remember { mutableStateOf(0L) }
    val context = LocalContext.current
    val vm = cashierViewModel()
    BackHandler {
        val now = System.currentTimeMillis()
        if (now - lastBack < 1500) {
            (context as? android.app.Activity)?.finish()
        } else {
            lastBack = now
            vm.repository.toast("再按一次退出程序")
        }
    }
    Scaffold(
        bottomBar = {
            Row(Modifier.fillMaxWidth().background(Color.White).navigationBarsPadding()) {
                listOf("桌台", "订单", "我的").forEachIndexed { index, label ->
                    val selected = tab == index
                    Column(
                        Modifier
                            .weight(1f)
                            .clickable { tab = index }
                            .padding(vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            label,
                            color = if (selected) CashierBlue else CashierTextMuted,
                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 14.sp,
                        )
                    }
                }
            }
        },
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when (tab) {
                0 -> HallScreen(
                    onOpenMenu = { id, no -> navController.navigate(CashierMenu(id, no)) },
                    onOpenOrder = { id, no -> navController.navigate(CashierOrder(id, no)) },
                    onLogout = {
                        navController.navigate(CashierLogin) {
                            popUpTo(CashierHome) { inclusive = true }
                        }
                    },
                )
                1 -> OrderListScreen(onOpen = { order: OrderSummary ->
                    if (order.payStatus == "10") {
                        navController.navigate(CashierSettle(
                            order.orderId, order.shopSupplierId, order.userId, order.tableId,
                            "${order.areaName}${order.tableNo}",
                        ))
                    } else {
                        navController.navigate(CashierFinished(order.orderId))
                    }
                })
                else -> MineScreen(
                    onLogout = {
                        navController.navigate(CashierLogin) {
                            popUpTo(CashierHome) { inclusive = true }
                        }
                    },
                    onChangePassword = { navController.navigate(CashierPassword) },
                    onAbout = { navController.navigate(CashierAbout) },
                )
            }
        }
    }
}
