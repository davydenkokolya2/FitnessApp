package com.example.fitnessapp.ui.activity_level

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapp.databinding.FragmentActivityLevelBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.ui.StringViewAdapter
import com.example.fitnessapp.util.Constants
import com.example.fitnessapp.util.Screen

class ActivityLevelFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentActivityLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityLevelBinding.inflate(inflater, container, false)
        binding.btnStartActivityLevel.setOnClickListener {
            navigationViewModel.loadState(Screen.NAV_BAR)
        }
        binding.btnBackActivityLevel.setOnClickListener {
            navigationViewModel.loadState(Screen.GOAL)
        }
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvActivityLevel.layoutManager = layoutManager
        binding.rvActivityLevel.adapter = StringViewAdapter(Constants.listActivityLevel)
        return binding.root
    }

}