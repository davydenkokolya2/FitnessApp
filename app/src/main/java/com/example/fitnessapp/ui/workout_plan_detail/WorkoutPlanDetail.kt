package com.example.fitnessapp.ui.workout_plan_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessapp.R

class WorkoutPlanDetail : Fragment() {

    companion object {
        fun newInstance() = WorkoutPlanDetail()
    }

    private lateinit var viewModel: WorkoutPlanDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_plan_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WorkoutPlanDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}