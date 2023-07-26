package com.example.fitnessapp.ui.weight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessapp.databinding.FragmentWeightBinding
import com.example.fitnessapp.ui.IntViewAdapter
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.util.Constants
import com.example.fitnessapp.util.Screen

class WeightFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private lateinit var binding: FragmentWeightBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeightBinding.inflate(inflater, container, false)
        binding.btnNextWeight.setOnClickListener {
            navigationViewModel.loadState(Screen.HEIGHT)
        }
        binding.btnBackWeight.setOnClickListener {
            navigationViewModel.loadState(Screen.AGE)
        }
        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvWeight.layoutManager = layoutManager
        binding.rvWeight.adapter = IntViewAdapter(Constants.list)
        return binding.root
    }
}