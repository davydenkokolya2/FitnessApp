package com.example.fitnessapp.ui.units_of_measure

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.util.UnitsOfMeasure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnitsOfMeasureViewModel @Inject constructor(): ViewModel() {
    private val _stateUnitsOfMeasure = MutableStateFlow<UnitsOfMeasure>(UnitsOfMeasure.METRIC)
    val stateUnitsOfMeasure: StateFlow<UnitsOfMeasure> = _stateUnitsOfMeasure

    fun loadState(unitsOfMeasure: UnitsOfMeasure) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateUnitsOfMeasure.emit(unitsOfMeasure)
        }
    }
}