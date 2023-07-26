package com.example.fitnessapp.ui.height

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapp.databinding.FragmentHeightBinding
import com.example.fitnessapp.ui.IntViewAdapter
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Constants
import com.example.fitnessapp.util.Screen

class HeightFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentHeightBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeightBinding.inflate(inflater, container, false)
        binding.btnNextHeight.setOnClickListener {
            navigationViewModel.loadState(Screen.GOAL)
        }
        binding.btnBackHeight.setOnClickListener {
            navigationViewModel.loadState(Screen.WEIGHT)
        }
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvHeight.layoutManager = layoutManager
        binding.rvHeight.adapter = IntViewAdapter(Constants.list)
        return binding.root
    }

}