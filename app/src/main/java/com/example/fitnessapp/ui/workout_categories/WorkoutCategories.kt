package com.example.fitnessapp.ui.workout_categories

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessapp.R

class WorkoutCategories : Fragment() {

    companion object {
        fun newInstance() = WorkoutCategories()
    }

    private lateinit var viewModel: WorkoutCategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workout_categories, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WorkoutCategoriesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}