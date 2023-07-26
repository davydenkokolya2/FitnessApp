package com.example.fitnessapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessapp.databinding.FragmentHomeBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.ui.nav_bar.NavBarViewModel
import com.example.fitnessapp.util.Screen

class HomeFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val navBarViewModel: NavBarViewModel by activityViewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.ivWarmUp.setOnClickListener {
            navigationViewModel.loadState(Screen.WORKOUT_PLAN_DETAIL)
        }
        binding.btnSeeAll.setOnClickListener {
            navBarViewModel.loadState(Screen.WORKOUT_CATEGORIES)
        }
        return binding.root
    }
}