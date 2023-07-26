package com.example.fitnessapp.ui.goal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapp.databinding.FragmentGoalBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.ui.StringViewAdapter
import com.example.fitnessapp.util.Constants
import com.example.fitnessapp.util.Screen

class GoalFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentGoalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoalBinding.inflate(inflater, container, false)
        binding.btnNextGoal.setOnClickListener {
            navigationViewModel.loadState(Screen.ACTIVITY_LEVEL)
        }
        binding.btnBackGoal.setOnClickListener {
            navigationViewModel.loadState(Screen.HEIGHT)
        }
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvGoal.layoutManager = layoutManager
        binding.rvGoal.adapter = StringViewAdapter(Constants.listGoal)
        return binding.root
    }
}