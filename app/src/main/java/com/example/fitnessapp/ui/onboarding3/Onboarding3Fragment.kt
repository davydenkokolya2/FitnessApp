package com.example.fitnessapp.ui.onboarding3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentOnboarding3Binding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Screen

class Onboarding3Fragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentOnboarding3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboarding3Binding.inflate(inflater, container, false)
        binding.btnStartNow.setOnClickListener {
            navigationViewModel.loadState(Screen.GENDER)
        }
        binding.ivOnboarding3.setOnClickListener {  }
        return binding.root
    }

}