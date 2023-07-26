package com.example.fitnessapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentProfileBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Screen

class ProfileFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.btnProfileBack.setOnClickListener {
            navigationViewModel.loadState(Screen.NAV_BAR)
        }
        binding.btnSettings.setOnClickListener {
            navigationViewModel.loadState(Screen.SETTINGS)
        }
        return binding.root
    }

}