package com.example.fitnessapp.ui.notifications_settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessapp.R

class NotificationsSettings : Fragment() {

    companion object {
        fun newInstance() = NotificationsSettings()
    }

    private lateinit var viewModel: NotificationsSettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications_settings, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NotificationsSettingsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}