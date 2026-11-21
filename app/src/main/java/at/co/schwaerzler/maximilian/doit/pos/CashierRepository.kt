package at.co.schwaerzler.maximilian.doit.pos

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import at.co.schwaerzler.maximilian.doit.data.appPreferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.JsonObject

class CashierRepository(context: Context) {
    private val dataStore = context.appPreferencesDataStore
    private val api = CashierApi { session.value?.token.orEmpty() }

    private val _session = MutableStateFlow<CashierSession?>(null)
    val session = _session.asStateFlow()

    private val _messages = MutableSharedFlow<String>(extraBufferCapacity = 16)
    val messages = _messages.asSharedFlow()

    suspend fun restore() {
        val prefs = dataStore.data.first()
        val token = prefs[TOKEN].orEmpty()
        if (token.isBlank()) {
            _session.value = null
            return
        }
        _session.value = CashierSession(
            token = token,
            userName = prefs[USER_NAME].orEmpty(),
            displayName = prefs[DISPLAY_NAME].orEmpty(),
            cashierId = prefs[CASHIER_ID].orEmpty(),
            shopSupplierId = prefs[SUPPLIER_ID].orEmpty(),
            userId = prefs[USER_ID].orEmpty(),
            appId = prefs[APP_ID].orEmpty().ifBlank { "10001" },
            mobile = prefs[MOBILE].orEmpty(),
        )
    }

    suspend fun login(userName: String, password: String): Result<Unit> = call {
        val session = api.login(userName.trim(), password)
        if (session.token.isBlank()) error("登录成功但没有返回 token")
        save(session)
    }

    suspend fun loginBySms(phone: String, code: String): Result<Unit> = call {
        val session = api.mobileLogin(phone.trim(), code.trim())
        if (session.token.isBlank()) error("登录成功但没有返回 token")
        save(session.copy(mobile = session.mobile.ifBlank { phone.trim() }))
    }

    suspend fun graphicCode(): Result<GraphicCode> = call { api.graphicCode() }

    suspend fun sendSms(phone: String, smsType: String, key: String, code: String): Result<Unit> = call {
        api.sendSms(phone.trim(), smsType, key, code.trim())
    }

    suspend fun updatePassword(userCode: String, phone: String, password: String, verifyCode: String): Result<Unit> = call {
        api.updatePassword(userCode.trim(), phone.trim(), password, verifyCode.trim())
    }

    suspend fun logout() {
        dataStore.edit { prefs ->
            listOf(TOKEN, USER_NAME, DISPLAY_NAME, CASHIER_ID, SUPPLIER_ID, USER_ID, APP_ID, MOBILE)
                .forEach { prefs.remove(it) }
        }
        _session.value = null
    }

    suspend fun shopOpenStatus(): Result<String> = call { api.shopOpenStatus() }

    suspend fun tableStatus(): Result<List<TableStatusChip>> = call { api.tableStatus() }

    suspend fun areas(status: String): Result<List<TableArea>> = call { api.areas(status) }

    suspend fun tables(areaId: String, typeId: String, status: String, tableNo: String, page: String = "1"): Result<List<DiningTable>> =
        call { api.tables(areaId, typeId, status, tableNo, page) }

    suspend fun openTable(tableId: String): Result<Unit> = call { api.openTable(tableId) }

    suspend fun closeTable(tableId: String): Result<Unit> = call { api.closeTable(tableId) }

    suspend fun categories(): Result<List<ProductCategory>> = call { api.categories() }

    suspend fun products(categoryId: String, search: String, page: String = "1"): Result<List<Product>> =
        call { api.products(categoryId, search, page) }

    suspend fun cart(tableId: String): Result<CartSnapshot> = call { api.cart(tableId) }

    suspend fun addToCart(
        product: Product,
        tableId: String,
        qty: String,
        sku: Sku?,
        attr: String,
        feed: String,
        describe: String,
        gift: Boolean,
    ): Result<Unit> = call {
        val price = sku?.price?.ifBlank { null } ?: product.price
        api.addToCart(
            productId = product.id,
            qty = qty,
            skuId = sku?.id.orEmpty(),
            attr = attr,
            price = price,
            bagPrice = product.bagPrice.ifBlank { "0" },
            tableId = tableId,
            feed = feed,
            describe = describe,
            isGift = if (gift) "1" else "0",
        )
    }

    suspend fun changeCartQty(qty: String, cartId: String): Result<Unit> = call { api.changeCartQty(qty, cartId) }

    suspend fun clearCart(tableId: String): Result<Unit> = call { api.clearCart(tableId) }

    suspend fun submitOrder(tableId: String, remark: String, mealNum: String, gift: Boolean, print: Boolean): Result<Unit> =
        call { api.submitOrder(tableId, remark, mealNum, currentUserId(), gift, print) }

    suspend fun addMeal(tableId: String, remark: String, orderId: String, gift: Boolean, print: Boolean): Result<Unit> =
        call { api.addMeal(tableId, remark, orderId, currentUserId(), gift, print) }

    suspend fun returnDish(orderProductId: String, orderId: String, num: String, print: Boolean): Result<Unit> =
        call { api.returnDish(orderProductId, orderId, num, print) }

    suspend fun orderOnTable(tableId: String): Result<TableOrder> = call { api.orderOnTable(tableId) }

    suspend fun orderInfo(orderId: String, supplierId: String, userId: String): Result<SettleOrder> = call {
        val session = _session.value
        api.orderInfo(
            orderId,
            supplierId.ifBlank { session?.shopSupplierId.orEmpty() },
            userId.ifBlank { currentUserId() },
        )
    }

    suspend fun paymentMethods(tableId: String): Result<List<PayMethod>> = call { api.paymentMethods(tableId) }

    suspend fun addCashSettle(orderId: String, settleType: String, money: String, settleValue: String): Result<Unit> =
        call { api.addCashSettle(orderId, settleType, money, settleValue) }

    suspend fun scanPay(orderId: String, money: String, authCode: String): Result<ScanPayResult> =
        call { api.scanPay(orderId, money, authCode) }

    suspend fun scanPayQuery(outTradeNo: String): Result<ScanPayResult> =
        call { api.scanPayQuery(outTradeNo) }

    suspend fun finishPay(order: SettleOrder, remark: String, quotaRemark: String): Result<Unit> =
        call { api.finishPay(order, remark, quotaRemark) }

    suspend fun orders(status: String, keyword: String, page: String): Result<List<OrderSummary>> =
        call { api.orders(status, keyword, page) }

    suspend fun printBill(orderId: String): Result<Unit> = call { api.printBill(orderId) }

    suspend fun finishedOrder(orderId: String): Result<FinishedOrder> = call { api.finishedOrder(orderId) }

    suspend fun changeGuestCount(orderId: String, mealNum: String): Result<Unit> =
        call { api.changeGuestCount(orderId, mealNum) }

    suspend fun serve(orderProductId: String, orderId: String): Result<Unit> =
        call { api.serve(orderProductId, orderId) }

    suspend fun undoServe(orderProductId: String, orderId: String): Result<Unit> =
        call { api.undoServe(orderProductId, orderId) }

    suspend fun urge(orderProductId: String, orderId: String): Result<Unit> =
        call { api.urge(orderProductId, orderId) }

    suspend fun switchTable(newTableId: String, orderId: String): Result<Unit> =
        call { api.switchTable(newTableId, orderId) }

    suspend fun mergeTable(orderId: String, tableId: String): Result<Unit> =
        call { api.mergeTable(orderId, tableId) }

    suspend fun memberCoupons(tableId: String, orderId: String, supplierId: String): Result<List<MemberAccount>> =
        call { api.memberCoupons(tableId, orderId, supplierId) }

    suspend fun packCoupons(tableId: String, orderId: String, supplierId: String): Result<List<MemberAccount>> =
        call { api.packCoupons(tableId, orderId, supplierId) }

    suspend fun applyCoupon(orderId: String, settleValue: String, coupon: MemberCoupon): Result<Unit> =
        call { api.applyCoupons(orderId, settleValue, listOf(coupon.raw)) }

    suspend fun lookupCoupon(meituan: Boolean, code: String, orderId: String): Result<JsonObject> =
        call { api.lookupCoupon(meituan, code, orderId) }

    suspend fun verifyLookedUp(meituan: Boolean, payload: JsonObject, orderId: String, num: String): Result<Unit> =
        call { api.verifyLookedUp(meituan, payload, orderId, num) }

    suspend fun groupCouponTypes(): Result<List<GroupCouponType>> = call { api.groupCouponTypes() }

    suspend fun groupCoupons(
        tableId: String,
        orderId: String,
        supplierId: String,
        userId: String,
        sourceId: String,
    ): Result<List<MemberCoupon>> = call { api.groupCoupons(tableId, orderId, supplierId, userId, sourceId) }

    suspend fun platformCoupons(orderId: String, type: String): Result<List<MemberCoupon>> =
        call { api.platformCoupons(orderId, type) }

    suspend fun refundPayment(line: PaymentLine): Result<Unit> = call {
        when {
            line.type == "10" -> error("当前页面无法撤销赠送优惠，可回到订单退菜")
            line.meituan -> api.refundMeituan(line.id)
            line.douyin -> api.refundDouyin(line.id)
            line.type == "14" || line.type == "15" || line.type == "16" -> {
                if (line.outTradeNo.isBlank()) error("没有支付单号")
                api.microRefund(line.outTradeNo)
            }
            line.id.isBlank() -> error("没有可退的记录")
            else -> api.refundOrderCoupon(line.id)
        }
    }

    suspend fun permissions(): Result<List<CashierPermission>> = call { api.permissions() }

    suspend fun printPreview(orderId: String, payments: List<PaymentLine>): Result<Unit> =
        call { api.printPreview(orderId, payments) }

    suspend fun cashierVersion(): Result<AppRelease> = call { api.cashierVersion() }

    suspend fun about(): Result<AboutInfo> = call { api.about(currentUserId().ifBlank { _session.value?.userName.orEmpty() }) }

    suspend fun deviceCodes(tableId: String): Result<List<DeviceCode>> = call { api.deviceCodes(tableId) }

    suspend fun openScan(tableId: String): Result<Unit> = call { api.openScan(tableId) }

    suspend fun closeScan(tableId: String): Result<Unit> = call { api.closeScan(tableId) }

    suspend fun saveScan(tableId: String, code: String): Result<Unit> = call { api.saveScan(tableId, code) }

    suspend fun saveScanLines(tableId: String, lines: List<ScanLine>): Result<Unit> =
        call { api.saveScanLines(tableId, lines) }

    suspend fun addDeviceOrder(lines: List<ScanLine>): Result<Unit> = call { api.addDeviceOrder(lines) }

    suspend fun verifyDouyin(code: String, orderId: String): Result<Unit> = call { api.verifyDouyin(code, orderId) }

    suspend fun verifyMeituan(code: String, orderId: String): Result<Unit> = call { api.verifyMeituan(code, orderId) }

    fun toast(message: String) {
        _messages.tryEmit(message)
    }

    private fun currentUserId(): String {
        val session = _session.value
        return session?.userId?.ifBlank { session.cashierId }.orEmpty()
    }

    private suspend fun save(session: CashierSession) {
        dataStore.edit { prefs ->
            prefs[TOKEN] = session.token
            prefs[USER_NAME] = session.userName
            prefs[DISPLAY_NAME] = session.displayName
            prefs[CASHIER_ID] = session.cashierId
            prefs[SUPPLIER_ID] = session.shopSupplierId
            prefs[USER_ID] = session.userId
            prefs[APP_ID] = session.appId
            prefs[MOBILE] = session.mobile
        }
        _session.value = session
    }

    private suspend fun <T> call(block: suspend () -> T): Result<T> = withContext(Dispatchers.IO) {
        runCatching { block() }
    }

    companion object {
        private val TOKEN = stringPreferencesKey("cashier_token")
        private val USER_NAME = stringPreferencesKey("cashier_user_name")
        private val DISPLAY_NAME = stringPreferencesKey("cashier_display_name")
        private val CASHIER_ID = stringPreferencesKey("cashier_id")
        private val SUPPLIER_ID = stringPreferencesKey("cashier_supplier_id")
        private val USER_ID = stringPreferencesKey("cashier_user_id")
        private val APP_ID = stringPreferencesKey("cashier_app_id")
        private val MOBILE = stringPreferencesKey("cashier_mobile")
    }
}
