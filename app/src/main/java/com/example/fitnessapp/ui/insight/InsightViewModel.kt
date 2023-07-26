package com.example.fitnessapp.ui.insight

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.util.Days
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InsightViewModel : ViewModel() {
    private val _stateDays = MutableStateFlow<Days>(Days.MONDAY)
    val stateDays: StateFlow<Days> = _stateDays

    fun loadState(days: Days) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateDays.emit(days)
        }
    }
}