package at.co.schwaerzler.maximilian.doit.pos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import at.co.schwaerzler.maximilian.doit.DoItApplication
import kotlinx.coroutines.launch

class CashierViewModel(val repository: CashierRepository) : ViewModel() {
    val session = repository.session
    val messages = repository.messages

    init {
        viewModelScope.launch { repository.restore() }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DoItApplication
                CashierViewModel(app.cashierRepository)
            }
        }
    }
}
