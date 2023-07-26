package com.example.fitnessapp.ui.age

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapp.databinding.FragmentAgeBinding
import com.example.fitnessapp.ui.IntViewAdapter
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Constants
import com.example.fitnessapp.util.Screen

class AgeFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentAgeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgeBinding.inflate(inflater, container, false)
        binding.btnNextAge.setOnClickListener {
            navigationViewModel.loadState(Screen.WEIGHT)
        }
        binding.btnBackAge.setOnClickListener {
            navigationViewModel.loadState(Screen.GENDER)
        }
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvAge.layoutManager = layoutManager
        binding.rvAge.adapter = IntViewAdapter(Constants.list)
        return binding.root
    }
}