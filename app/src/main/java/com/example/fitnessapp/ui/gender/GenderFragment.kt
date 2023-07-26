package com.example.fitnessapp.ui.gender

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentGenderBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Gender
import com.example.fitnessapp.util.Screen
import kotlinx.coroutines.launch

class GenderFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val genderViewModel: GenderViewModel by activityViewModels()
    private lateinit var binding: FragmentGenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenderBinding.inflate(inflater, container, false)
        binding.btnNextGender.setOnClickListener {
            navigationViewModel.loadState(Screen.AGE)
        }
        binding.btnMale.setOnClickListener {
            genderViewModel.loadState(Gender.MALE)
        }
        binding.btnFemale.setOnClickListener {
            genderViewModel.loadState(Gender.FEMALE)
        }
        lifecycleScope.launch {
            genderViewModel.stateGender.collect {
                when(it) {
                    Gender.MALE -> {
                        binding.btnMale.setImageResource(R.drawable.icon_male_true)
                        binding.btnFemale.setImageResource(R.drawable.icon_female_false)
                    }
                    Gender.FEMALE -> {
                        binding.btnMale.setImageResource(R.drawable.icon_male_false)
                        binding.btnFemale.setImageResource(R.drawable.icon_female_true)
                    }
                }
            }
        }
        binding
        return binding.root
    }
}