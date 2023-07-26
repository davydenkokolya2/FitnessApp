package com.example.fitnessapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor() : ViewModel() {
    private val _stateScreen = MutableStateFlow<Screen>(Screen.ONBOARDING)
    val stateScreen: StateFlow<Screen> = _stateScreen

    fun loadState(screen: Screen) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateScreen.emit(screen)
        }
    }

}