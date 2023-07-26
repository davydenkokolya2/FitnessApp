package com.example.fitnessapp.ui.notifications_settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentNotificationsSettingsBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Screen
import kotlinx.coroutines.launch

class NotificationsSettingsFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentNotificationsSettingsBinding

    private val notificationsSettingsViewModel: NotificationsSettingsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationsSettingsBinding.inflate(inflater, container, false)
        binding.btnBackNotifications.setOnClickListener {
            navigationViewModel.loadState(Screen.SETTINGS)
        }
        binding.btnSwitchWorkout.setOnClickListener {
            notificationsSettingsViewModel.loadStateWorkout(!notificationsSettingsViewModel.stateWorkout.value)
        }
        binding.btnSwitchProgram.setOnClickListener {
            notificationsSettingsViewModel.loadStateProgram(!notificationsSettingsViewModel.stateProgram.value)
        }
        lifecycleScope.launch {
            notificationsSettingsViewModel.stateProgram.collect {
                when(it) {
                    true -> binding.btnSwitchProgram.setImageResource(R.drawable.icon_switch_on)
                    false -> binding.btnSwitchProgram.setImageResource(R.drawable.icon_switch_off)
                }
            }
        }
        lifecycleScope.launch {
            notificationsSettingsViewModel.stateWorkout.collect {
                when(it) {
                    true -> binding.btnSwitchWorkout.setImageResource(R.drawable.icon_switch_on)
                    false -> binding.btnSwitchWorkout.setImageResource(R.drawable.icon_switch_off)
                }
            }
        }
        return binding.root
    }
}