package com.example.fitnessapp.ui.activity_level

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessapp.R

class ActivityLevel : Fragment() {

    companion object {
        fun newInstance() = ActivityLevel()
    }

    private lateinit var viewModel: ActivityLevelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity_level, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ActivityLevelViewModel::class.java)
        // TODO: Use the ViewModel
    }

}