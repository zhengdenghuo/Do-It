package com.anzhuo.todo.data.queue

import android.content.Context
import android.provider.Settings
import java.security.MessageDigest
import java.security.SecureRandom

/** Stable device id stored as a MAC address. Android no longer exposes the hardware MAC. */
class DeviceMacStore(context: Context) {
    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val contentResolver = context.contentResolver

    fun getOrCreate(): String {
        preferences.getString(KEY_MAC, null)?.takeIf { it.isNotBlank() }?.let { return it }
        val created = macFromAndroidId() ?: generateLocalMac()
        preferences.edit().putString(KEY_MAC, created).apply()
        return created
    }

    /** Same signing key keeps the same ANDROID_ID across uninstall and reinstall. */
    private fun macFromAndroidId(): String? {
        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            ?.takeIf { it.isNotBlank() }
            ?: return null
        val digest = MessageDigest.getInstance("SHA-256").digest(androidId.toByteArray(Charsets.UTF_8))
        val bytes = digest.copyOf(6)
        bytes[0] = ((bytes[0].toInt() and 0xFE) or 0x02).toByte()
        return bytes.joinToString(":") { "%02X".format(it) }
    }

    private fun generateLocalMac(): String {
        val bytes = ByteArray(6)
        SecureRandom().nextBytes(bytes)
        bytes[0] = ((bytes[0].toInt() and 0xFE) or 0x02).toByte()
        return bytes.joinToString(":") { "%02X".format(it) }
    }

    private companion object {
        const val PREFS_NAME = "queue_device"
        const val KEY_MAC = "mac"
    }
}
