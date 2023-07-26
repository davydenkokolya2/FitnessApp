package com.example.fitnessapp.ui.insight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentInsightBinding
import com.example.fitnessapp.util.Days
import kotlinx.coroutines.launch

class InsightFragment : Fragment() {


    private lateinit var binding: FragmentInsightBinding
    private val insightViewModel: InsightViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInsightBinding.inflate(inflater, container, false)
        binding.ivBackMonday.setOnClickListener {
            insightViewModel.loadState(Days.MONDAY)
        }
        binding.ivBackTuesday.setOnClickListener {
            insightViewModel.loadState(Days.TUESDAY)
        }
        binding.ivBackWednesday.setOnClickListener {
            insightViewModel.loadState(Days.WEDNESDAY)
        }
        binding.ivBackThursday.setOnClickListener {
            insightViewModel.loadState(Days.THURSDAY)
        }
        binding.ivBackFriday.setOnClickListener {
            insightViewModel.loadState(Days.FRIDAY)
        }
        binding.ivBackSaturday.setOnClickListener {
            insightViewModel.loadState(Days.SATURDAY)
        }
        binding.ivBackSunday.setOnClickListener {
            insightViewModel.loadState(Days.SUNDAY)
        }
        lifecycleScope.launch {
            insightViewModel.stateDays.collect {

                binding.ivBackMonday.setImageResource(R.drawable.background_day_black)
                binding.ivBackTuesday.setImageResource(R.drawable.background_day_black)
                binding.ivBackWednesday.setImageResource(R.drawable.background_day_black)
                binding.ivBackThursday.setImageResource(R.drawable.background_day_black)
                binding.ivBackFriday.setImageResource(R.drawable.background_day_black)
                binding.ivBackSaturday.setImageResource(R.drawable.background_day_black)
                binding.ivBackSunday.setImageResource(R.drawable.background_day_black)

                when (it) {
                    Days.MONDAY -> binding.ivBackMonday.setImageResource(R.drawable.background_day_orange)
                    Days.TUESDAY -> binding.ivBackTuesday.setImageResource(R.drawable.background_day_orange)
                    Days.WEDNESDAY -> binding.ivBackWednesday.setImageResource(R.drawable.background_day_orange)
                    Days.THURSDAY -> binding.ivBackThursday.setImageResource(R.drawable.background_day_orange)
                    Days.FRIDAY -> binding.ivBackFriday.setImageResource(R.drawable.background_day_orange)
                    Days.SATURDAY -> binding.ivBackSaturday.setImageResource(R.drawable.background_day_orange)
                    Days.SUNDAY -> binding.ivBackSunday.setImageResource(R.drawable.background_day_orange)
                }
            }
        }
        return binding.root
    }
}