package com.example.fitnessapp.ui.units_of_measure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentUnitsOfMeasureBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Screen
import com.example.fitnessapp.util.UnitsOfMeasure
import kotlinx.coroutines.launch

class UnitsOfMeasureFragment : Fragment() {
    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentUnitsOfMeasureBinding

    private val unitsOfMeasureViewModel: UnitsOfMeasureViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUnitsOfMeasureBinding.inflate(inflater, container, false)
        binding.btnBackUnits.setOnClickListener {
            navigationViewModel.loadState(Screen.SETTINGS)
        }
        binding.btnImperal.setOnClickListener {
            unitsOfMeasureViewModel.loadState(UnitsOfMeasure.IMPERIAL)
        }
        binding.btnMetric.setOnClickListener {
            unitsOfMeasureViewModel.loadState(UnitsOfMeasure.METRIC)
        }
        lifecycleScope.launch {
            unitsOfMeasureViewModel.stateUnitsOfMeasure.collect {
                when(it) {
                    UnitsOfMeasure.METRIC -> {
                        binding.btnMetric.setImageResource(R.drawable.icon_checked_true)
                        binding.btnImperal.setImageResource(R.drawable.icon_checked_false)
                    }
                    UnitsOfMeasure.IMPERIAL -> {
                        binding.btnMetric.setImageResource(R.drawable.icon_checked_false)
                        binding.btnImperal.setImageResource(R.drawable.icon_checked_true)
                    }
                }
            }
        }
        return binding.root
    }


}