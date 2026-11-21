package at.co.schwaerzler.maximilian.doit.pos

import android.os.Build
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import java.net.HttpURLConnection
import java.net.URL

class CashierApi(
    private val tokenProvider: () -> String,
) {

    fun login(userName: String, password: String): CashierSession = post(
        "index.php/cashier/passport/login",
        json(
            "user_name" to userName,
            "password" to password,
            "deviceToken" to "",
            "systemCode" to "elementCollection",
            "versionNo" to "1.0.3.9",
            "softSort" to "collectpoint",
            "deviceModel" to Build.MODEL,
        ),
    ).requireOk().asObject().toSession(userName)

    fun graphicCode(): GraphicCode {
        val data = post("api/login/getGraphicCode", json()).requireOk().asObject()
        return GraphicCode(key = data.s("key"), code = data.s("code"))
    }

    fun sendSms(phone: String, smsType: String, graphicKey: String, graphicCode: String) {
        post(
            "api/sendSms/sendSms",
            json(
                "phone" to phone,
                "smsType" to smsType,
                "graphicKey" to graphicKey,
                "graphicCode" to graphicCode,
                "appType" to "collectpoint",
            ),
        ).requireOk()
    }

    fun mobileLogin(phone: String, verifyCode: String): CashierSession = post(
        "api/login/mobileLogin",
        json(
            "phone" to phone,
            "verifyCode" to verifyCode,
            "deviceModel" to Build.MODEL,
            "systemCode" to "elementCollection",
            "versionNo" to "1.0.3.9",
            "softSort" to "collectpoint",
        ),
    ).requireOk().asObject().toSession(phone)

    fun updatePassword(userCode: String, phone: String, password: String, verifyCode: String) {
        post(
            "api/login/updateUserPwd",
            json(
                "userCode" to userCode,
                "userPhone" to phone,
                "password" to password,
                "verifyCode" to verifyCode,
            ),
        ).requireOk()
    }

    fun shopOpenStatus(): String {
        val data = post("index.php/cashier/index/index", json()).requireOk().asObject()
        return data.obj("detail").s("open_class_status")
    }

    fun tableStatus(): List<TableStatusChip> {
        val data = post("index.php/cashier/store.table/getTableStatusNum", json()).requireOk()
        val box = data.obj("data").ifEmpty { data.asObject() }
        return listOf("all", "noStart", "eating", "paying").mapNotNull { key ->
            val item = box.obj(key)
            val status = item.s("status")
            val desc = item.s("desc")
            if (desc.isBlank() && status.isBlank()) null
            else TableStatusChip(status = status, desc = desc.ifBlank { key }, num = item.s("num"))
        }
    }

    fun areas(status: String): List<TableArea> {
        val data = post("index.php/cashier/store.table/area", json("table_status" to status)).requireOk()
        return data.array("list").map { it.toArea() }
    }

    fun tables(areaId: String, typeId: String, status: String, tableNo: String, page: String = "1"): List<DiningTable> {
        val data = post(
            "index.php/cashier/store.table/table",
            json(
                "area_id" to areaId,
                "type_id" to typeId,
                "table_status" to status,
                "table_no" to tableNo,
                "is_merge" to "",
                "page" to page,
                "list_rows" to "30",
            ),
        ).requireOk()
        return data.array("list").map { it.toTable() }
    }

    fun openTable(tableId: String) {
        post("index.php/cashier/order.HallCart/open", json("table_id" to tableId)).requireOk()
    }

    fun closeTable(tableId: String) {
        post("index.php/cashier/order.HallCart/cancel", json("table_id" to tableId)).requireOk()
    }

    fun categories(): List<ProductCategory> {
        val data = post("index.php/cashier/product.category/index", json()).requireOk()
        return data.array("list").map {
            ProductCategory(id = it.s("category_id"), name = it.s("name"))
        }
    }

    fun products(categoryId: String, search: String, page: String = "1"): List<Product> {
        val data = post(
            "index.php/cashier/product.product/index",
            json(
                "category_id" to categoryId,
                "page" to page,
                "list_rows" to "10",
                "search" to search,
            ),
        ).requireOk()
        val list = data.obj("list")
        val rows = list.array("data").ifEmpty { data.array("data") }
        return rows.map { it.toProduct() }
    }

    fun cart(tableId: String): CartSnapshot {
        val data = post("index.php/cashier/order.HallCart/list", json("table_id" to tableId)).requireOk().asObject()
        val info = data.obj("cartInfo")
        val lines = data.array("productList").map { row ->
            val product = row.obj("product")
            CartLine(
                cartId = row.s("cart_id"),
                name = product.s("product_name").ifBlank { row.s("product_name") },
                qty = row.s("product_num"),
                price = row.s("product_price").ifBlank { row.s("pay_price") },
                payPrice = row.s("pay_price"),
                feed = row.s("feed"),
                describe = row.s("describe"),
            )
        }
        return CartSnapshot(
            totalNum = info.s("cart_total_num"),
            totalPay = info.s("total_pay_price"),
            lines = lines,
        )
    }

    fun addToCart(
        productId: String,
        qty: String,
        skuId: String,
        attr: String,
        price: String,
        bagPrice: String,
        tableId: String,
        feed: String,
        describe: String,
        isGift: String,
    ) {
        post(
            "index.php/cashier/order.HallCart/add",
            json(
                "product_id" to productId,
                "product_num" to qty,
                "product_sku_id" to skuId,
                "attr" to attr,
                "price" to price,
                "product_price" to price,
                "bag_price" to bagPrice,
                "table_id" to tableId,
                "feed" to feed,
                "describe" to describe,
                "is_gift" to isGift,
            ),
        ).requireOk()
    }

    fun changeCartQty(qty: String, cartId: String) {
        post(
            "index.php/cashier/order.HallCart/sub",
            json("product_num" to qty, "cart_id" to cartId, "type" to "mid"),
        ).requireOk()
    }

    fun clearCart(tableId: String) {
        post("index.php/cashier/order.HallCart/delete", json("table_id" to tableId)).requireOk()
    }

    fun submitOrder(
        tableId: String,
        remark: String,
        mealNum: String,
        userId: String,
        gift: Boolean,
        print: Boolean,
    ) {
        post(
            "index.php/cashier/order.Order/tableBuy",
            buildJsonObject {
                put("table_id", JsonPrimitive(tableId))
                put("order_id", JsonPrimitive(""))
                put("meal_num", JsonPrimitive(mealNum))
                put("user_id", JsonPrimitive(userId))
                put("is_print", JsonPrimitive(if (print) "1" else "0"))
                put(if (gift) "gift_remark" else "remark", JsonPrimitive(remark))
            },
        ).requireOk()
    }

    fun addMeal(tableId: String, remark: String, orderId: String, userId: String, gift: Boolean, print: Boolean) {
        post(
            "index.php/cashier/order.Order/addMeal",
            buildJsonObject {
                put("table_id", JsonPrimitive(tableId))
                put("order_id", JsonPrimitive(orderId))
                put("meal_num", JsonPrimitive(""))
                put("user_id", JsonPrimitive(userId))
                put("is_print", JsonPrimitive(if (print) "1" else "0"))
                put(if (gift) "gift_remark" else "remark", JsonPrimitive(remark))
            },
        ).requireOk()
    }

    fun returnDish(orderProductId: String, orderId: String, num: String, print: Boolean) {
        post(
            "index.php/cashier/order.order/moveProduct",
            json(
                "order_product_id" to orderProductId,
                "order_id" to orderId,
                "num" to num,
                "is_print" to if (print) "1" else "0",
            ),
        ).requireOk()
    }

    fun orderOnTable(tableId: String): TableOrder {
        val detail = post("index.php/cashier/order.HallCart/detail", json("table_id" to tableId))
            .requireOk()
            .obj("detail")
        return detail.toTableOrder()
    }

    fun orderInfo(orderId: String, supplierId: String, userId: String): SettleOrder {
        val data = post(
            "index.php/cashier/order.HallCart/getOrderInfo",
            json("order_id" to orderId, "shop_supplier_id" to supplierId, "user_id" to userId),
        ).requireOk()
        val box = data.obj("data").ifEmpty { data.asObject() }
        return box.toSettleOrder()
    }

    fun paymentMethods(tableId: String): List<PayMethod> {
        val data = post("index.php/cashier/order.HallCart/getPaymentMethod", json("table_id" to tableId)).requireOk()
        val rows = data.array("data").ifEmpty { data.array("list") }
        return rows.map {
            PayMethod(
                name = it.s("name"),
                type = it.s("type"),
                settleType = it.s("settle_type"),
                payMethodId = it.s("pay_method_id"),
            )
        }
    }

    fun addCashSettle(orderId: String, settleType: String, money: String, settleValue: String) {
        post(
            "index.php/cashier/order.OrderCoupon/addOrderCoupon",
            buildJsonObject {
                put("order_id", JsonPrimitive(orderId))
                put("settle_value", JsonPrimitive(settleValue))
                put(
                    "data",
                    buildJsonArray {
                        add(
                            buildJsonObject {
                                put("settle_type", JsonPrimitive(settleType))
                                put("settle_money", JsonPrimitive(money))
                                put("num", JsonPrimitive("1"))
                                put("order_id", JsonPrimitive(orderId))
                            },
                        )
                    },
                )
            },
        ).requireOk()
    }

    fun scanPay(orderId: String, money: String, authCode: String): ScanPayResult {
        val data = post(
            "index.php/cashier/order.Order/ScanPay",
            json("order_id" to orderId, "money" to money, "auth_code" to authCode),
        ).requireOk()
        val box = data.obj("data").ifEmpty { data.asObject() }
        return ScanPayResult(
            status = box.s("status"),
            outTradeNo = box.s("out_trade_no"),
            message = box.s("msg"),
        )
    }

    fun scanPayQuery(outTradeNo: String): ScanPayResult {
        val data = post(
            "index.php/cashier/order.Order/ScanPayQuery",
            json("out_trade_no" to outTradeNo),
        ).requireOk().asObject()
        val box = data.obj("data").ifEmpty { data }
        return ScanPayResult(status = box.s("status"), outTradeNo = box.s("out_trade_no"), message = box.s("msg"))
    }

    fun finishPay(order: SettleOrder, remark: String, quotaRemark: String) {
        post(
            "index.php/cashier/order.Order/newPay",
            buildJsonObject {
                put("order_id", JsonPrimitive(order.orderId))
                put("shop_supplier_id", JsonPrimitive(order.shopSupplierId))
                put("user_id", JsonPrimitive(order.userId))
                put("table_id", JsonPrimitive(order.tableId))
                put("mobile", JsonPrimitive(order.mobile))
                put("remark", JsonPrimitive(remark))
                put("quota_remark", JsonPrimitive(quotaRemark))
                put("coupon", order.coupon)
                put("settle", order.settle)
            },
        ).requireOk()
    }

    fun orders(status: String, keyword: String, page: String): List<OrderSummary> {
        val data = post(
            "index.php/cashier/order.OrderDetail/OrderList",
            json("status" to status, "table_order_no" to keyword, "list_rows" to "10", "page" to page),
        ).requireOk()
        val rows = data.findOrderRows()
        return rows.map {
            OrderSummary(
                orderId = it.s("order_id"),
                orderNo = it.s("order_no"),
                tableNo = it.s("table_no"),
                areaName = it.s("area_name"),
                mealNum = it.s("meal_num"),
                income = it.s("order_real_income"),
                payStatusName = it.s("pay_status_name"),
                payStatus = it.s("pay_status"),
                createTime = it.s("create_time"),
                tableId = it.s("table_id"),
                userId = it.s("user_id"),
                shopSupplierId = it.s("shop_supplier_id"),
            )
        }
    }

    fun finishedOrder(orderId: String): FinishedOrder {
        val data = post("index.php/cashier/order.OrderDetail/OrderDetail", json("order_id" to orderId)).requireOk()
        val box = data.obj("data").ifEmpty { data.asObject() }
        val guest = box.obj("user_info")
        return FinishedOrder(
            orderNo = box.s("order_no"),
            tableNo = listOf(box.s("area_name"), box.s("type_name"), box.s("table_no")).filter { it.isNotBlank() }.joinToString(""),
            mealNum = box.s("meal_num"),
            total = box.s("total_price"),
            discount = box.s("discount_money"),
            receivable = box.s("receivable_money"),
            refund = box.s("refund_money"),
            real = box.s("real_receivable_money"),
            createTime = box.s("create_time"),
            payTime = box.s("pay_time"),
            cashier = box.s("cashier_name"),
            guest = guest.s("name"),
            mobile = guest.s("mobile"),
            orderRemark = box.s("order_remark"),
            presentRemark = box.s("present_remark"),
            settleRemark = box.s("settle_remark"),
            refundRemark = box.s("refund_remark"),
            lines = box.array("productList").flatMap { group ->
                val nested = group.array("canpin").ifEmpty { group.array("canpin_arr") }
                if (nested.isEmpty()) {
                    listOf(group.s("name") to "${group.s("num")}  ${group.s("total_pay_price").ifBlank { group.s("total_price") }}")
                } else {
                    nested.map { item ->
                        item.s("product_name") to "${item.s("total_num")}  ${item.s("total_pay_price").ifBlank { item.s("total_price") }}"
                    }
                }
            },
            discounts = box.array("discount_list").map { it.s("name") to it.s("discount_money") },
            payments = box.array("settle_list").map { it.s("name") to it.s("real_money").ifBlank { it.s("settle_money") } },
        )
    }

    fun printBill(orderId: String) {
        post("index.php/cashier/order.OrderDetail/PrintBill", json("order_id" to orderId)).requireOk()
    }

    fun changeGuestCount(orderId: String, mealNum: String) {
        post("index.php/cashier/order.Order/changeNum", json("order_id" to orderId, "meal_num" to mealNum)).requireOk()
    }

    fun serve(orderProductId: String, orderId: String) {
        post(
            "index.php/cashier/order.HallCart/productPass",
            json("order_product_id" to orderProductId, "order_id" to orderId),
        ).requireOk()
    }

    fun undoServe(orderProductId: String, orderId: String) {
        post(
            "index.php/cashier/order.HallCart/productPassRollback",
            json("order_product_id" to orderProductId, "order_id" to orderId),
        ).requireOk()
    }

    fun urge(orderProductId: String, orderId: String) {
        post(
            "/index.php/cashier/order.HallCart/urgedishes",
            json("order_product_id" to orderProductId, "order_id" to orderId),
        ).requireOk()
    }

    fun switchTable(newTableId: String, orderId: String) {
        post(
            "index.php/cashier/order.Order/changeTable",
            json("table_id" to newTableId, "order_id" to orderId),
        ).requireOk()
    }

    fun mergeTable(orderId: String, tableId: String) {
        post(
            "index.php/cashier/order.Order/mergeTable",
            json("order_id" to orderId, "table_id" to tableId),
        ).requireOk()
    }

    fun memberCoupons(tableId: String, orderId: String, supplierId: String): List<MemberAccount> =
        couponAccounts("index.php/cashier/order.HallCart/getCouponList", tableId, orderId, supplierId)

    fun packCoupons(tableId: String, orderId: String, supplierId: String): List<MemberAccount> =
        couponAccounts("index.php/cashier/order.HallCart/getPackCouponList", tableId, orderId, supplierId)

    fun applyCoupons(orderId: String, settleValue: String, coupons: List<JsonObject>) {
        post(
            "index.php/cashier/order.OrderCoupon/addOrderCoupon",
            buildJsonObject {
                put("order_id", JsonPrimitive(orderId))
                put("settle_value", JsonPrimitive(settleValue))
                put(
                    "data",
                    buildJsonArray {
                        coupons.forEach { coupon ->
                            add(
                                buildJsonObject {
                                    coupon.forEach { (key, value) -> put(key, value) }
                                    put("order_id", JsonPrimitive(orderId))
                                },
                            )
                        }
                    },
                )
            },
        ).requireOk()
    }

    fun lookupCoupon(meituan: Boolean, code: String, orderId: String): JsonObject {
        val data = post(
            if (meituan) {
                "index.php/cashier/order.ThirdParty/getMeiTuanCouponInfo"
            } else {
                "index.php/cashier/order.ThirdParty/getCouponInfo"
            },
            json("code" to code, "order_id" to orderId),
        ).requireOk()
        return data.obj("data").ifEmpty { data.asObject() }
    }

    fun groupCouponTypes(): List<GroupCouponType> {
        val data = post("index.php/cashier/order.ThirdParty/getGroupTypeList", json()).requireOk()
        return data.array("list").ifEmpty { data.array("data") }.map {
            GroupCouponType(name = it.s("name"), sourceId = it.s("plat_source_id"), type = it.s("type"))
        }
    }

    fun groupCoupons(
        tableId: String,
        orderId: String,
        supplierId: String,
        userId: String,
        sourceId: String,
    ): List<MemberCoupon> {
        val data = post(
            "index.php/cashier/order.HallCart/getGroupCouponList",
            buildJsonObject {
                put("table_id", JsonPrimitive(tableId))
                put("order_id", JsonPrimitive(orderId))
                put("shop_supplier_id", JsonPrimitive(supplierId))
                put("user_id", JsonPrimitive(userId))
                put("mobile", JsonPrimitive(""))
                put("plat_source_id", JsonPrimitive(sourceId))
                put("coupon", buildJsonArray { })
                put("settle", buildJsonArray { })
            },
        ).requireOk()
        return data.array("data").ifEmpty { data.array("list") }.map { it.toMemberCoupon() }
    }

    fun platformCoupons(orderId: String, type: String): List<MemberCoupon> {
        val data = post(
            "index.php/cashier/order.ThirdParty/getCouponList",
            json("order_id" to orderId, "type" to type),
        ).requireOk()
        return data.array("data").ifEmpty { data.array("list") }.map { it.toMemberCoupon() }
    }

    fun verifyLookedUp(meituan: Boolean, payload: JsonObject, orderId: String, num: String) {
        post(
            if (meituan) {
                "index.php/cashier/order.ThirdParty/verifyMeituanCoupon"
            } else {
                "index.php/cashier/order.ThirdParty/verifyCouponNew"
            },
            buildJsonObject {
                payload.forEach { (key, value) -> put(key, value) }
                put("in_order_id", JsonPrimitive(orderId))
                put("num", JsonPrimitive(num.ifBlank { "1" }))
            },
        ).requireOk()
    }

    fun refundDouyin(payMethodId: String) {
        post("index.php/cashier/order.ThirdParty/refundCouponNew", json("pay_method_id" to payMethodId)).requireOk()
    }

    fun refundMeituan(payMethodId: String) {
        post("index.php/cashier/order.ThirdParty/refundMeituanCoupon", json("pay_method_id" to payMethodId)).requireOk()
    }

    fun refundOrderCoupon(payMethodId: String) {
        post("index.php/cashier/order.OrderCoupon/refundOrderCoupon", json("pay_method_id" to payMethodId)).requireOk()
    }

    fun microRefund(outTradeNo: String) {
        post("index.php/cashier/order.Order/microRefund", json("out_trade_no" to outTradeNo)).requireOk()
    }

    fun permissions(): List<CashierPermission> {
        val data = post("index.php/cashier/order.OrderDetail/permissionList", json()).requireOk()
        return data.array("list").ifEmpty { data.array("data") }.map {
            CashierPermission(type = it.s("type"), name = it.s("name"), allowed = it.s("is_permission") == "1")
        }
    }

    fun printPreview(orderId: String, payments: List<PaymentLine>) {
        post(
            "index.php/cashier/order.OrderDetail/printOrder",
            buildJsonObject {
                put("order_id", JsonPrimitive(orderId))
                put(
                    "settle",
                    buildJsonArray {
                        payments.forEach { line ->
                            add(
                                buildJsonObject {
                                    put("settle_id", JsonPrimitive(line.settleId))
                                    put("settle_type", JsonPrimitive(line.type))
                                    put("settle_money", JsonPrimitive(line.money))
                                    put("num", JsonPrimitive(line.num.ifBlank { "1" }))
                                    put("out_trade_no", JsonPrimitive(line.outTradeNo))
                                },
                            )
                        }
                    },
                )
            },
        ).requireOk()
    }

    fun cashierVersion(): AppRelease {
        val data = post(
            "index.php/device/tableDevice.tableDevice/getVensionInfo",
            json("type" to "cashier"),
        ).requireOk()
        val box = data.obj("data").ifEmpty { data.asObject() }
        return AppRelease(version = box.s("version"), downloadUrl = box.s("downUrl"), content = box.s("content"))
    }

    fun about(userCode: String): AboutInfo {
        val data = post(
            "api/appDownloadQRCode/getAppDownloadQRCode",
            json("userCode" to userCode, "softType" to "android", "softSort" to "collectpoint"),
        ).requireOk().asObject()
        return AboutInfo(
            appName = data.s("appName"),
            support = data.s("technicalSupport"),
            imagePath = data.s("imagePath"),
        )
    }

    private fun couponAccounts(path: String, tableId: String, orderId: String, supplierId: String): List<MemberAccount> {
        val data = post(
            path,
            buildJsonObject {
                put("table_id", JsonPrimitive(tableId))
                put("order_id", JsonPrimitive(orderId))
                put("shop_supplier_id", JsonPrimitive(supplierId))
                put("user_id", JsonPrimitive(""))
                put("mobile", JsonPrimitive(""))
                put("coupon", buildJsonArray { })
                put("settle", buildJsonArray { })
            },
        ).requireOk()
        return data.array("data").ifEmpty { data.array("list") }.map { account ->
            MemberAccount(
                name = account.s("name"),
                mobile = account.s("mobile"),
                userId = account.s("user_id"),
                coupons = account.array("coupon").map { coupon ->
                    MemberCoupon(
                        name = coupon.s("name").ifBlank { coupon.s("apply_name") },
                        money = coupon.s("coupon_money").ifBlank { coupon.s("reduce_price") },
                        settleType = coupon.s("settle_type"),
                        raw = coupon,
                    )
                },
            )
        }
    }

    fun deviceCodes(tableId: String): List<DeviceCode> {
        val data = post(
            "index.php/cashier/product.product/getDeviceCode",
            json("table_id" to tableId),
        ).requireOk()
        return data.array("list").ifEmpty { data.array("data") }.map { it.toDeviceCode() }
    }

    fun openScan(tableId: String) {
        post("index.php/cashier/order.Cart/openScan", json("table_id" to tableId)).requireOk()
    }

    fun closeScan(tableId: String) {
        post("index.php/cashier/order.Cart/closeScan", json("table_id" to tableId)).requireOk()
    }

    fun saveScan(tableId: String, code: String) {
        post(
            "index.php/cashier/order.Cart/saveScanInfo",
            json("table_id" to tableId, "scan_info" to code),
        ).requireOk()
    }

    fun saveScanLines(tableId: String, lines: List<ScanLine>) {
        saveScan(tableId, buildJsonArray { lines.forEach { add(it.toScanJson()) } }.toString())
    }

    fun addDeviceOrder(lines: List<ScanLine>) {
        post(
            "index.php/cashier/order.Cart/addDeviceOrder",
            buildJsonObject {
                put("products", buildJsonArray { lines.forEach { add(it.toScanJson()) } })
            },
        ).requireOk()
    }

    fun verifyDouyin(code: String, orderId: String) {
        post(
            "index.php/cashier/order.ThirdParty/verifyCouponNew",
            json("code" to code, "order_id" to orderId, "in_order_id" to orderId, "num" to "1"),
        ).requireOk()
    }

    fun verifyMeituan(code: String, orderId: String) {
        post(
            "/index.php/cashier/order.ThirdParty/verifyMeituanCoupon",
            json("code" to code, "order_id" to orderId, "in_order_id" to orderId, "num" to "1"),
        ).requireOk()
    }

    private fun post(path: String, body: JsonObject): JsonObject {
        val connection = (URL(BASE + path.trimStart('/')).openConnection() as HttpURLConnection).apply {
            requestMethod = "POST"
            connectTimeout = 20_000
            readTimeout = 30_000
            doOutput = true
            setRequestProperty("Content-Type", "application/json; charset=utf-8")
            setRequestProperty("token", tokenProvider())
            setRequestProperty("appid", APP_ID)
        }
        connection.outputStream.use { stream ->
            stream.write(body.toString().toByteArray(Charsets.UTF_8))
        }
        val code = connection.responseCode
        val text = (if (code in 200..299) connection.inputStream else connection.errorStream)
            ?.bufferedReader()
            ?.use { it.readText() }
            .orEmpty()
        connection.disconnect()
        if (text.isBlank()) error("服务器没有返回内容 ($code)")
        val element = runCatching { Json.parseToJsonElement(text) }.getOrElse {
            error("无法解析响应 ($code)")
        }
        val obj = element as? JsonObject ?: error("响应格式不正确")
        if (code !in 200..299) {
            error(obj.s("msg").ifBlank { "网络错误 $code" })
        }
        return obj
    }

    companion object {
        const val BASE = "http://114.55.219.79/"
        const val APP_ID = "10001"
    }
}

private fun json(vararg pairs: Pair<String, String>): JsonObject = buildJsonObject {
    pairs.forEach { (key, value) -> put(key, JsonPrimitive(value)) }
}

private fun JsonObject.requireOk(): JsonElement {
    val code = s("code")
    if (code != "1") {
        error(s("msg").ifBlank { s("message") }.ifBlank { "请求失败" })
    }
    return this["data"] ?: JsonObject(emptyMap())
}

private fun JsonElement?.asObject(): JsonObject = this as? JsonObject ?: JsonObject(emptyMap())

private fun JsonElement?.obj(key: String): JsonObject = asObject().obj(key)

private fun JsonObject.s(key: String): String {
    val value = this[key] ?: return ""
    return when (value) {
        is JsonNull -> ""
        is JsonPrimitive -> value.contentOrNull.orEmpty()
        else -> ""
    }
}

private fun JsonObject.obj(key: String): JsonObject = this[key] as? JsonObject ?: JsonObject(emptyMap())

private fun JsonObject.ifEmpty(fallback: () -> JsonObject): JsonObject = if (isEmpty()) fallback() else this

private fun JsonElement?.array(key: String): List<JsonObject> {
    val obj = this as? JsonObject ?: return emptyList()
    val value = obj[key]
    return when (value) {
        is JsonArray -> value.mapNotNull { it as? JsonObject }
        is JsonObject -> value.array("data").ifEmpty { value.array("list") }
        else -> emptyList()
    }
}

private fun JsonElement?.findOrderRows(): List<JsonObject> {
    val root = this as? JsonObject ?: return emptyList()
    val direct = root.array("data").ifEmpty { root.array("list") }
    if (direct.isNotEmpty() && direct.first().containsKey("order_id")) return direct
    val nested = root.obj("data")
    val fromList = nested.array("list")
    val fromData = nested.array("data")
    val candidate = fromData.ifEmpty { fromList }
    if (candidate.isNotEmpty() && candidate.first().containsKey("order_id")) return candidate
    val deeper = nested.obj("list").array("data")
    if (deeper.isNotEmpty()) return deeper
    return nested.obj("data").array("data").ifEmpty { nested.obj("data").array("list") }
}

private fun JsonObject.toSession(fallbackName: String) = CashierSession(
    token = s("token"),
    userName = s("user_name").ifBlank { s("account").ifBlank { fallbackName } },
    displayName = s("name").ifBlank { s("nickName").ifBlank { s("user_name").ifBlank { fallbackName } } },
    cashierId = s("cashier_id"),
    shopSupplierId = s("shop_supplier_id"),
    userId = s("user_id").ifBlank { s("userCode").ifBlank { s("cashier_id") } },
    appId = s("app_id").ifBlank { "10001" },
    mobile = s("mobile").ifBlank { s("userPhone") },
)

private fun JsonObject.toArea() = TableArea(
    id = s("area_id"),
    name = s("area_name"),
    count = s("tableNum"),
    types = array("typeList").map { TableType(id = it.s("type_id"), name = it.s("type_name")) },
)

private fun JsonObject.toTable() = DiningTable(
    id = s("table_id"),
    no = s("table_no"),
    areaName = s("area_name"),
    status = s("table_status"),
    statusName = s("table_status_name"),
    mealNum = s("meal_num"),
    maxNum = s("max_num"),
    useTime = s("use_time"),
)

private fun JsonObject.toProduct(): Product {
    val skus = array("sku").map {
        Sku(id = it.s("product_sku_id"), name = it.s("spec_name"), price = it.s("product_price"), stock = it.s("stock_num"))
    }
    val feeds = array("product_feed").map { Feed(name = it.s("feed_name"), price = it.s("price")) }
    val image = array("image").firstOrNull()?.s("file_path").orEmpty()
    return Product(
        id = s("product_id"),
        name = s("product_name"),
        price = s("product_price"),
        unit = s("product_unit"),
        stock = s("product_stock"),
        bagPrice = s("bag_price"),
        image = image,
        skus = skus,
        feeds = feeds,
        attrs = array("product_attr").map { attr ->
            ProductAttr(
                name = attr.s("attribute_name"),
                values = (attr["attribute_value"] as? JsonArray)?.mapNotNull { (it as? JsonPrimitive)?.contentOrNull }.orEmpty(),
            )
        },
    )
}

private fun JsonObject.toTableOrder() = TableOrder(
    orderId = s("order_id"),
    tableNo = s("table_no"),
    mealNum = s("meal_num"),
    orderPrice = s("order_price"),
    payPrice = s("pay_price"),
    productNum = s("product_num"),
    userId = s("user_id"),
    shopSupplierId = s("shop_supplier_id"),
    lines = array("product").map {
        OrderLine(
            orderProductId = it.s("order_product_id"),
            name = it.s("product_name"),
            qty = it.s("total_num"),
            price = it.s("product_price"),
            total = it.s("total_price"),
            remark = it.s("buyer_remark"),
            served = (it.s("pass_time").toDoubleOrNull() ?: 0.0) > 0.0,
            gift = it.s("is_gift") == "1",
            scanned = it.s("is_sweeing") == "1",
        )
    },
)

private fun JsonObject.toSettleOrder(): SettleOrder {
    val info = obj("settleInfo")
    return SettleOrder(
        orderId = s("order_id"),
        orderNo = s("order_no"),
        tableId = info.s("table_id"),
        shopSupplierId = s("shop_supplier_id").ifBlank { info.s("shop_supplier_id") },
        userId = info.s("user_id"),
        mobile = s("mobile"),
        totalPrice = s("total_price"),
        orderPrice = s("order_price"),
        payPrice = s("pay_price").ifBlank { s("should_pay_price") },
        discount = s("discount_money"),
        giveChange = s("giveChange"),
        realMoney = s("real_money"),
        mealNum = s("meal_num"),
        productNum = s("product_num"),
        lines = array("product").map {
            OrderLine(
                orderProductId = it.s("order_product_id"),
                name = it.s("product_name"),
                qty = it.s("total_num"),
                price = it.s("product_price"),
                total = it.s("total_pay_price").ifBlank { it.s("total_price") },
                remark = it.s("buyer_remark"),
                served = false,
                gift = it.s("is_gift") == "1",
            )
        },
        payments = info.array("settle").map { it.toPayment() },
        coupon = info["coupon"] as? JsonArray ?: JsonArray(emptyList()),
        settle = info["settle"] as? JsonArray ?: JsonArray(emptyList()),
    )
}

private fun JsonObject.toPayment() = PaymentLine(
    name = s("name").ifBlank { s("apply_name") },
    money = s("settle_money").ifBlank { s("discount_money").ifBlank { s("realMoney") } },
    num = s("num"),
    type = s("settle_type"),
    id = s("id").ifBlank { s("pay_method_id") },
    settleId = s("settle_id"),
    outTradeNo = s("out_trade_no"),
    douyin = s("is_douyin") == "1",
    meituan = s("is_meituan") == "1",
)

data class CashierSession(
    val token: String,
    val userName: String,
    val displayName: String,
    val cashierId: String,
    val shopSupplierId: String,
    val userId: String,
    val appId: String,
    val mobile: String,
)

data class GraphicCode(val key: String, val code: String)

data class TableStatusChip(val status: String, val desc: String, val num: String)

data class TableArea(val id: String, val name: String, val count: String, val types: List<TableType>)

data class TableType(val id: String, val name: String)

data class DiningTable(
    val id: String,
    val no: String,
    val areaName: String,
    val status: String,
    val statusName: String,
    val mealNum: String,
    val maxNum: String,
    val useTime: String,
)

data class ProductCategory(val id: String, val name: String)

data class Product(
    val id: String,
    val name: String,
    val price: String,
    val unit: String,
    val stock: String,
    val bagPrice: String,
    val image: String,
    val skus: List<Sku>,
    val feeds: List<Feed>,
    val attrs: List<ProductAttr>,
)

data class Sku(val id: String, val name: String, val price: String, val stock: String)

data class Feed(val name: String, val price: String)

data class ProductAttr(val name: String, val values: List<String>)

data class CartLine(
    val cartId: String,
    val name: String,
    val qty: String,
    val price: String,
    val payPrice: String,
    val feed: String,
    val describe: String,
)

data class CartSnapshot(val totalNum: String, val totalPay: String, val lines: List<CartLine>)

data class OrderLine(
    val orderProductId: String,
    val name: String,
    val qty: String,
    val price: String,
    val total: String,
    val remark: String,
    val served: Boolean,
    val gift: Boolean,
    val scanned: Boolean = false,
)

data class TableOrder(
    val orderId: String,
    val tableNo: String,
    val mealNum: String,
    val orderPrice: String,
    val payPrice: String,
    val productNum: String,
    val userId: String,
    val shopSupplierId: String,
    val lines: List<OrderLine>,
)

data class SettleOrder(
    val orderId: String,
    val orderNo: String,
    val tableId: String,
    val shopSupplierId: String,
    val userId: String,
    val mobile: String,
    val totalPrice: String,
    val orderPrice: String,
    val payPrice: String,
    val discount: String,
    val giveChange: String,
    val realMoney: String,
    val mealNum: String,
    val productNum: String,
    val lines: List<OrderLine>,
    val payments: List<PaymentLine>,
    val coupon: JsonArray,
    val settle: JsonArray,
)

data class PaymentLine(
    val name: String,
    val money: String,
    val num: String,
    val type: String,
    val id: String = "",
    val settleId: String = "",
    val outTradeNo: String = "",
    val douyin: Boolean = false,
    val meituan: Boolean = false,
)

data class MemberCoupon(
    val name: String,
    val money: String,
    val settleType: String,
    val raw: JsonObject,
)

data class GroupCouponType(val name: String, val sourceId: String, val type: String)

private fun JsonObject.toMemberCoupon() = MemberCoupon(
    name = s("name").ifBlank { s("apply_name") }.ifBlank { s("content") }.ifBlank { "券" },
    money = s("coupon_money").ifBlank { s("reduce_price") }.ifBlank { s("couponMoney") },
    settleType = s("settle_type"),
    raw = this,
)

data class MemberAccount(
    val name: String,
    val mobile: String,
    val userId: String,
    val coupons: List<MemberCoupon>,
)

data class CashierPermission(val type: String, val name: String, val allowed: Boolean)

data class AppRelease(val version: String, val downloadUrl: String, val content: String)

data class AboutInfo(val appName: String, val support: String, val imagePath: String)

data class PayMethod(val name: String, val type: String, val settleType: String, val payMethodId: String)

data class ScanPayResult(val status: String, val outTradeNo: String, val message: String)

data class DeviceCode(
    val productId: String,
    val skuId: String,
    val price: String,
    val name: String,
    val icon: String,
    val ruleNo: String,
)

data class ScanLine(
    val productId: String,
    val skuId: String,
    val price: String,
    val name: String,
    val icon: String,
    val tableId: String,
    val qty: Int,
    val deviceNos: List<String>,
)

private fun JsonObject.toDeviceCode() = DeviceCode(
    productId = s("product_id"),
    skuId = s("product_sku_id"),
    price = s("product_price"),
    name = s("product_name"),
    icon = s("icon"),
    ruleNo = s("device_rule_no"),
)

private fun ScanLine.toScanJson(): JsonObject = buildJsonObject {
    put("product_id", JsonPrimitive(productId))
    put("product_num", JsonPrimitive(qty))
    put("product_sku_id", JsonPrimitive(skuId))
    put("product_price", JsonPrimitive(price))
    put("table_id", JsonPrimitive(tableId))
    if (deviceNos.isNotEmpty()) {
        put("device_no", buildJsonArray { deviceNos.forEach { add(JsonPrimitive(it)) } })
    }
    put("product_name", JsonPrimitive(name))
    put("icon", JsonPrimitive(icon))
}

fun JsonObject.cashierField(key: String): String = s(key)

data class FinishedOrder(
    val orderNo: String,
    val tableNo: String,
    val mealNum: String,
    val total: String,
    val discount: String,
    val receivable: String,
    val refund: String,
    val real: String,
    val createTime: String,
    val payTime: String,
    val cashier: String,
    val guest: String,
    val mobile: String,
    val orderRemark: String,
    val presentRemark: String,
    val settleRemark: String,
    val refundRemark: String,
    val lines: List<Pair<String, String>>,
    val discounts: List<Pair<String, String>>,
    val payments: List<Pair<String, String>>,
)

data class OrderSummary(
    val orderId: String,
    val orderNo: String,
    val tableNo: String,
    val areaName: String,
    val mealNum: String,
    val income: String,
    val payStatusName: String,
    val payStatus: String,
    val createTime: String,
    val tableId: String,
    val userId: String,
    val shopSupplierId: String,
)
