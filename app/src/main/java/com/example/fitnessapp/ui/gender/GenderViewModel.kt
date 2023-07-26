package com.example.fitnessapp.ui.gender

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.util.Gender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor() : ViewModel() {
    private val _stateGender = MutableStateFlow<Gender>(Gender.MALE)
    val stateGender: StateFlow<Gender> = _stateGender

    fun loadState(gender: Gender) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateGender.emit(gender)
        }
    }
}