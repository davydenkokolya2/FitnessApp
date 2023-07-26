package com.example.fitnessapp.ui.workout_plan_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentWorkoutPlanDetailBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Screen

class WorkoutPlanDetailFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentWorkoutPlanDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentWorkoutPlanDetailBinding.inflate(inflater, container, false)
        binding.btnBackWorkoutPlanDetail.setOnClickListener {
            navigationViewModel.loadState(Screen.NAV_BAR)
        }
        binding.btnSimpleWarmUp.setOnClickListener {
            navigationViewModel.loadState(Screen.TRAINING)
        }
        return binding.root
    }
}