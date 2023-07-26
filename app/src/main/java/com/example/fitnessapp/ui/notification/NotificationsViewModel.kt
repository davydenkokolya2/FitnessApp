package com.example.fitnessapp.ui.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.util.Notification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotificationsViewModel : ViewModel() {
    private val _stateNotification = MutableStateFlow(Notification.NULL)
    val stateNotification: StateFlow<Notification> = _stateNotification
    fun loadState(notification: Notification) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateNotification.emit(notification)
        }
    }
    private val _stateClearNotification = MutableStateFlow(Notification.NULL)
    val stateClearNotification: StateFlow<Notification> = _stateClearNotification
    fun loadStateClearNotification(notification: Notification) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateClearNotification.emit(notification)
        }
    }
}