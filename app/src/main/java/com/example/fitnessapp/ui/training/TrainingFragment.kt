package com.example.fitnessapp.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentTrainingBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Screen

class TrainingFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentTrainingBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrainingBinding.inflate(inflater, container, false)
        binding.btnBackTraining.setOnClickListener {
            navigationViewModel.loadState(Screen.WORKOUT_PLAN_DETAIL)
        }
        return binding.root
    }

}