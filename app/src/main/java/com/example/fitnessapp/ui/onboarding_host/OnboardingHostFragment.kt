package com.example.fitnessapp.ui.onboarding_host

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentOnboardingHostBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.ui.onboarding1.Onboarding1Fragment
import com.example.fitnessapp.ui.onboarding2.Onboarding2Fragment
import com.example.fitnessapp.ui.onboarding3.Onboarding3Fragment
import com.example.fitnessapp.util.Onboarding
import com.example.fitnessapp.util.Screen
import kotlinx.coroutines.launch

class OnboardingHostFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val onboardingHostFragment: OnboardingHostViewModel by activityViewModels()
    private lateinit var binding: FragmentOnboardingHostBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingHostBinding.inflate(inflater, container, false)
        binding.btnSkip.setOnClickListener {
            navigationViewModel.loadState(Screen.GENDER)
        }
        lifecycleScope.launch {
            onboardingHostFragment.stateOnboarding.collect {
                when (it) {
                    Onboarding.ONBOARDING1 -> replaceFragment(Onboarding1Fragment())
                    Onboarding.ONBOARDING2 -> {
                        replaceFragment(Onboarding2Fragment())
                        binding.ivFirstIndicator.setImageResource(R.drawable.icon_grey_indicator)
                        binding.ivSecondIndicator.setImageResource(R.drawable.icon_orange_indicator)
                        binding.ivThirdIndicator.setImageResource(R.drawable.icon_grey_indicator)
                    }
                    Onboarding.ONBOARDING3 -> {
                        replaceFragment(Onboarding3Fragment())
                        binding.ivFirstIndicator.setImageResource(R.drawable.icon_grey_indicator)
                        binding.ivSecondIndicator.setImageResource(R.drawable.icon_grey_indicator)
                        binding.ivThirdIndicator.setImageResource(R.drawable.icon_orange_indicator)
                    }
                }
            }
        }

        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView3, fragment)
        fragmentTransaction.commit()
    }
}