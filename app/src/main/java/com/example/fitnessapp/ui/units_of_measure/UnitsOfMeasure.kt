package com.example.fitnessapp.ui.units_of_measure

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessapp.R

class UnitsOfMeasure : Fragment() {

    companion object {
        fun newInstance() = UnitsOfMeasure()
    }

    private lateinit var viewModel: UnitsOfMeasureViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_units_of_measure, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UnitsOfMeasureViewModel::class.java)
        // TODO: Use the ViewModel
    }

}