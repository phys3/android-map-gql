package com.example.courts.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class EventUiState(
    val quantity: Int = 0,
    val flavor: String = "",
    val date: String = "",
    val price: String = "",
)

class EventViewModel : ViewModel() {

        private val _uiState = MutableStateFlow(EventUiState())
        val uiState: StateFlow<EventUiState> = _uiState.asStateFlow()

        fun setQuantity(numberCupcakes: Int) {
            _uiState.update { currentState ->
                currentState.copy(
                    quantity = numberCupcakes,
                    price = "10"
                )
            }
        }
    }