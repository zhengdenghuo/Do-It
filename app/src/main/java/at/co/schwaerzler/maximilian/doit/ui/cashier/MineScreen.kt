package at.co.schwaerzler.maximilian.doit.ui.cashier

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import at.co.schwaerzler.maximilian.doit.pos.GraphicCode
import kotlinx.coroutines.launch

@Composable
fun MineScreen(onLogout: () -> Unit, onChangePassword: () -> Unit, onAbout: () -> Unit) {
    val vm = cashierViewModel()
    val session by vm.session.collectAsState()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Column(Modifier.fillMaxSize().background(Color(0xFFF3F3F3))) {
        Box(Modifier.fillMaxWidth().height(168.dp).background(Color(0xFF1558DB))) {
            Row(
                Modifier.align(Alignment.CenterStart).padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    Modifier.size(64.dp).clip(CircleShape).background(Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("收银", color = Color(0xFF1558DB), fontWeight = FontWeight.Bold)
                }
                Column(Modifier.padding(start = 12.dp)) {
                    Text(session?.displayName ?: "收银员", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(session?.userName.orEmpty(), color = Color.White)
                }
            }
        }
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
        Button(onClick = onChangePassword, modifier = Modifier.fillMaxWidth()) { Text("修改密码") }
        Button(onClick = onAbout, modifier = Modifier.fillMaxWidth()) { Text("关于我们") }
        Button(onClick = {
            context.cacheDir.deleteRecursively()
            vm.repository.toast("缓存已清理")
        }, modifier = Modifier.fillMaxWidth()) { Text("清理缓存") }
        Card(Modifier.fillMaxWidth()) {
            Text("版本信息  1.0.3.9", modifier = Modifier.padding(16.dp))
        }
        Button(onClick = {
            scope.launch {
                vm.repository.logout()
                onLogout()
            }
        }, modifier = Modifier.fillMaxWidth()) { Text("退出登录") }
        }
    }
}

@Composable
fun AboutScreen(onBack: () -> Unit) {
    val vm = cashierViewModel()
    var info by remember { mutableStateOf<at.co.schwaerzler.maximilian.doit.pos.AboutInfo?>(null) }
    LaunchedEffect(Unit) {
        info = vm.repository.about().orToast(vm.repository)
    }
    Scaffold(topBar = { CashierTopBar("关于我们", onBack = onBack) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(info?.appName?.ifBlank { null } ?: "鲜主收银", style = MaterialTheme.typography.headlineSmall)
            Text("版本 1.0.3.9")
            Text(info?.support?.ifBlank { null } ?: "技术支持")
        }
    }
}

@Composable
fun ChangePasswordScreen(onBack: () -> Unit) {
    val vm = cashierViewModel()
    val session by vm.session.collectAsState()
    val scope = rememberCoroutineScope()
    var phone by remember(session?.mobile) { mutableStateOf(session?.mobile.orEmpty()) }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }
    var sms by remember { mutableStateOf("") }
    var graphicText by remember { mutableStateOf("") }
    var graphic by remember { mutableStateOf<GraphicCode?>(null) }

    Scaffold(topBar = { CashierTopBar("修改密码", onBack = onBack) }) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).padding(16.dp).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(phone, { phone = it }, Modifier.fillMaxWidth(), label = { Text("手机号") }, keyboardOptions = KeyboardOptions.Default, singleLine = true)
            OutlinedTextField(password, { password = it }, Modifier.fillMaxWidth(), label = { Text("请输入修改密码") }, visualTransformation = PasswordVisualTransformation(), singleLine = true)
            OutlinedTextField(confirm, { confirm = it }, Modifier.fillMaxWidth(), label = { Text("确认密码") }, visualTransformation = PasswordVisualTransformation(), singleLine = true)
            OutlinedTextField(graphicText, { graphicText = it }, Modifier.fillMaxWidth(), label = { Text("图形验证码") }, singleLine = true)
            TextButton(onClick = {
                scope.launch { graphic = vm.repository.graphicCode().orToast(vm.repository) }
            }) { Text(graphic?.code?.takeIf { decodeCaptcha(it) == null && it.length < 40 } ?: "获取图形验证码") }
            OutlinedTextField(sms, { sms = it }, Modifier.fillMaxWidth(), label = { Text("短信验证码") }, singleLine = true)
            TextButton(onClick = {
                scope.launch {
                    vm.repository.sendSms(phone, "updatePwd", graphic?.key.orEmpty(), graphicText).orToast(vm.repository)
                        ?.let { vm.repository.toast("验证码已发送") }
                }
            }) { Text("获取验证码") }
            Button(onClick = {
                if (password != confirm) {
                    vm.repository.toast("修改密码和确认密码不一致")
                    return@Button
                }
                scope.launch {
                    vm.repository.updatePassword(session?.userName.orEmpty(), phone, password, sms).orToast(vm.repository)
                        ?.let {
                            vm.repository.toast("密码已更新")
                            onBack()
                        }
                }
            }, modifier = Modifier.fillMaxWidth()) { Text("确定") }
        }
    }
}
