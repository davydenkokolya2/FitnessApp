package com.example.fitnessapp.ui.onboarding_host

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.util.Onboarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingHostViewModel @Inject constructor() : ViewModel() {
    private val _stateOnboarding = MutableStateFlow(Onboarding.ONBOARDING1)
    val stateOnboarding: StateFlow<Onboarding> = _stateOnboarding

    fun loadState(onboarding: Onboarding) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateOnboarding.emit(onboarding)
        }
    }
}