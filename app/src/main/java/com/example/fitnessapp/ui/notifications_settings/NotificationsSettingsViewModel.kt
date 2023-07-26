package com.example.fitnessapp.ui.notifications_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsSettingsViewModel @Inject constructor() : ViewModel() {
    private val _stateWorkout = MutableStateFlow(true)
    val stateWorkout: StateFlow<Boolean> = _stateWorkout
    fun loadStateWorkout(workout: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateWorkout.emit(workout)
        }
    }

    private val _stateProgram = MutableStateFlow(true)
    val stateProgram: StateFlow<Boolean> = _stateProgram
    fun loadStateProgram(workout: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateProgram.emit(workout)
        }
    }
}