package com.anzhuo.todo.data.queue

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

data class QueueBoardUiState(
    val mac: String,
    val loading: Boolean = true,
    val errorMessage: String? = null,
    val summary: QueueSummaryData? = null,
)

class QueueBoardViewModel(
    application: Application,
    private val api: QueueApi = QueueApi(),
) : ViewModel() {
    private val mac = DeviceMacStore(application).getOrCreate()
    private val _uiState = MutableStateFlow(QueueBoardUiState(mac = mac))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            while (isActive) {
                refresh()
                delay(REFRESH_INTERVAL_MS)
            }
        }
    }

    private suspend fun refresh() {
        try {
            val summary = withContext(Dispatchers.IO) { api.fetchSummary(mac) }
            _uiState.update { it.copy(loading = false, errorMessage = null, summary = summary) }
        } catch (cancelled: CancellationException) {
            throw cancelled
        } catch (error: Exception) {
            _uiState.update {
                it.copy(loading = false, errorMessage = error.message ?: "获取排队信息失败")
            }
        }
    }

    companion object {
        private const val REFRESH_INTERVAL_MS = 5_000L

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as Application
                QueueBoardViewModel(application)
            }
        }
    }
}
