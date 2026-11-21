package at.co.schwaerzler.maximilian.doit.pos

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ScanPayResultTest {
    @Test
    fun pendingAndMissingStatusesDoNotConfirmPayment() {
        assertFalse(ScanPayResult("0", "trade", "交易进行中").paid)
        assertFalse(ScanPayResult("", "trade", "查询成功").paid)
        assertFalse(ScanPayResult("", "trade", "未支付").paid)
    }

    @Test
    fun explicitPaidStatusOrMessageConfirmsPayment() {
        assertTrue(ScanPayResult("1", "trade", "").paid)
        assertTrue(ScanPayResult("", "trade", "已支付").paid)
    }
}
