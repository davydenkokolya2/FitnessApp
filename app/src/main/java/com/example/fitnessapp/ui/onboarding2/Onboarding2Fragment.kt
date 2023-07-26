package com.example.fitnessapp.ui.onboarding2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentOnboarding2Binding
import com.example.fitnessapp.ui.onboarding_host.OnboardingHostViewModel
import com.example.fitnessapp.util.Onboarding

class Onboarding2Fragment : Fragment() {

    private val onboardingHostFragment: OnboardingHostViewModel by activityViewModels()
    private lateinit var binding: FragmentOnboarding2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboarding2Binding.inflate(inflater, container, false)
        binding.imageView25.setOnClickListener {
            onboardingHostFragment.loadState(Onboarding.ONBOARDING3)
        }
        return binding.root
    }


}