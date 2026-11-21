package at.co.schwaerzler.maximilian.doit.ui.cashier

import android.os.SystemClock
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import at.co.schwaerzler.maximilian.doit.pos.GraphicCode
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ChangePasswordScreen(onBack: () -> Unit) {
    val vm = cashierViewModel()
    val session by vm.session.collectAsState()
    val account = session ?: return
    val repository = vm.repository
    val scope = rememberCoroutineScope()
    val userCode = account.userCode.ifBlank { account.userId.ifBlank { account.userName } }
    var phone by rememberSaveable(account.mobile) { mutableStateOf(account.mobile) }
    var sms by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }
    var graphicText by remember { mutableStateOf("") }
    var graphic by remember { mutableStateOf<GraphicCode?>(null) }
    var requestingCode by remember { mutableStateOf(false) }
    var submitting by remember { mutableStateOf(false) }
    var resendAt by rememberSaveable { mutableLongStateOf(0L) }
    var secondsLeft by remember { mutableIntStateOf(0) }

    suspend fun refreshGraphic() {
        graphicText = ""
        graphic = repository.graphicCode().orToast(repository)
    }

    LaunchedEffect(Unit) {
        requestingCode = true
        try {
            refreshGraphic()
        } finally {
            requestingCode = false
        }
    }
    LaunchedEffect(resendAt) {
        var remaining = resendAt - SystemClock.elapsedRealtime()
        while (remaining > 0) {
            secondsLeft = ((remaining + 999) / 1000).toInt()
            delay(minOf(remaining, 1000L))
            remaining = resendAt - SystemClock.elapsedRealtime()
        }
        secondsLeft = 0
    }

    val captchaImage = remember(graphic) { graphic?.code?.let(::decodeCaptcha) }
    Scaffold(topBar = { CashierTopBar("修改密码", onBack = onBack) }) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).imePadding().verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                phone, { phone = it; sms = "" }, Modifier.fillMaxWidth(),
                enabled = !requestingCode && !submitting,
                label = { Text("手机号") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true,
            )
            OutlinedTextField(
                graphicText, { graphicText = it }, Modifier.fillMaxWidth(),
                enabled = !requestingCode && !submitting,
                label = { Text("图形验证码") },
                singleLine = true,
            )
            TextButton(
                enabled = !requestingCode && !submitting,
                onClick = {
                    requestingCode = true
                    scope.launch {
                        try {
                            refreshGraphic()
                        } finally {
                            requestingCode = false
                        }
                    }
                },
            ) {
                if (captchaImage != null) {
                    Image(captchaImage, contentDescription = "图形验证码，点击刷新", modifier = Modifier.height(44.dp))
                } else {
                    Text("刷新图形验证码")
                }
            }
            OutlinedTextField(
                sms, { sms = it }, Modifier.fillMaxWidth(),
                enabled = !submitting,
                label = { Text("短信验证码") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
            )
            TextButton(
                enabled = !requestingCode && !submitting && secondsLeft == 0 &&
                    phone.isNotBlank() && graphicText.isNotBlank() && !graphic?.key.isNullOrBlank(),
                onClick = {
                    val challenge = graphic ?: return@TextButton
                    if (resendAt > SystemClock.elapsedRealtime()) return@TextButton
                    requestingCode = true
                    scope.launch {
                        try {
                            val result = repository.sendSms(phone, "updatePwd", challenge.key, graphicText)
                            if (result.orToast(repository) != null) {
                                resendAt = SystemClock.elapsedRealtime() + 60_000L
                                repository.toast("验证码已发送")
                            } else {
                                refreshGraphic()
                            }
                        } finally {
                            requestingCode = false
                        }
                    }
                },
            ) {
                Text(if (secondsLeft > 0) "${secondsLeft} 秒后重新获取" else "获取短信验证码")
            }
            OutlinedTextField(
                password, { password = it }, Modifier.fillMaxWidth(),
                enabled = !submitting,
                label = { Text("新密码") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
            )
            OutlinedTextField(
                confirm, { confirm = it }, Modifier.fillMaxWidth(),
                enabled = !submitting,
                label = { Text("确认新密码") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                isError = confirm.isNotEmpty() && confirm != password,
                supportingText = if (confirm.isNotEmpty() && confirm != password) {
                    { Text("两次输入的密码不一致") }
                } else null,
            )
            Button(
                enabled = !requestingCode && !submitting && phone.isNotBlank() && sms.isNotBlank() &&
                    password.isNotBlank() && password == confirm,
                onClick = {
                    submitting = true
                    scope.launch {
                        try {
                            val result = repository.updatePassword(userCode, phone, password, sms)
                            if (result.orToast(repository) != null) {
                                repository.toast("密码已更新")
                                onBack()
                            }
                        } finally {
                            submitting = false
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            ) { Text(if (submitting) "处理中" else "保存新密码") }
        }
    }
}
