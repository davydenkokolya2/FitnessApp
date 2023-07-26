package com.example.fitnessapp.ui.onboarding1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentOnboarding1Binding
import com.example.fitnessapp.ui.onboarding_host.OnboardingHostViewModel
import com.example.fitnessapp.util.Onboarding

class Onboarding1Fragment : Fragment() {

    private val onboardingHostFragment: OnboardingHostViewModel by activityViewModels()
    private lateinit var binding: FragmentOnboarding1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboarding1Binding.inflate(inflater, container, false)
        binding.ivOnboarding1.setOnClickListener {
            onboardingHostFragment.loadState(Onboarding.ONBOARDING2)
        }
        return binding.root
    }

}