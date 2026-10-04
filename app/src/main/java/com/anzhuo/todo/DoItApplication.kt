/*
 * Copyright 2026 Maximilian Schwärzler
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.anzhuo.todo

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import com.anzhuo.todo.data.AppPreferences
import com.anzhuo.todo.data.appPreferencesDataStore
import com.anzhuo.todo.data.db.TodoDatabase
import com.anzhuo.todo.data.db.TodoRepository
import com.anzhuo.todo.util.applyNightMode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/** Application subclass that lazily initializes the Room database singleton. */
class DoItApplication : Application() {
    private val database: TodoDatabase by lazy {
        TodoDatabase.getDatabase(this)
    }

    val repository: TodoRepository by lazy {
        TodoRepository(applicationContext, database.todoDao(), appPreferences)
    }

    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    val appPreferences by lazy { AppPreferences(appPreferencesDataStore, applicationScope) }

    override fun onCreate() {
        super.onCreate()
        val themeMode = appPreferences.themeMode.value
        themeMode.applyNightMode(this)
        setupNotificationChannel()
    }

    fun setupNotificationChannel() {
        val name = getString(R.string.todo_deadline_notif_channel_name)
        val descriptionText = getString(R.string.todo_deadline_notif_channel_description)
        val importance = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(
            getString(R.string.todo_deadline_notif_channel_id),
            name,
            importance
        )
        mChannel.description = descriptionText
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(mChannel)
    }
}