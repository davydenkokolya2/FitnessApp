package com.example.fitnessapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentSettingsBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Screen

class SettingsFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentSettingsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.btnUnitsOfMeasure.setOnClickListener {
            navigationViewModel.loadState(Screen.UNITS_OF_MEASURE)
        }
        binding.btnNotifications.setOnClickListener {
            navigationViewModel.loadState(Screen.NOTIFICATIONS_SETTINGS)
        }
        binding.btnBackSettings.setOnClickListener {
            navigationViewModel.loadState(Screen.PROFILE)
        }
        return binding.root
    }
}