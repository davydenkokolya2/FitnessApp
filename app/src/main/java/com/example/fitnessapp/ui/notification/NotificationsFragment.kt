package com.example.fitnessapp.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.databinding.FragmentNotificationsBinding
import com.example.fitnessapp.util.Notification
import kotlinx.coroutines.launch

class NotificationsFragment : Fragment() {

    private val notificationsViewModel: NotificationsViewModel by activityViewModels()
    private lateinit var binding: FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        binding.ivFirstNotification.setOnClickListener {
            if (notificationsViewModel.stateNotification.value == Notification.FIRST)
                notificationsViewModel.loadState(Notification.NULL)
            else
                notificationsViewModel.loadState(Notification.FIRST)
        }
        binding.ivSecondNotification.setOnClickListener {
            if (notificationsViewModel.stateNotification.value == Notification.SECOND)
                notificationsViewModel.loadState(Notification.NULL)
            else
                notificationsViewModel.loadState(Notification.SECOND)
        }
        binding.ivThirdNotification.setOnClickListener {
            if (notificationsViewModel.stateNotification.value == Notification.THIRD)
                notificationsViewModel.loadState(Notification.NULL)
            else
                notificationsViewModel.loadState(Notification.THIRD)
        }
        binding.ivFIrstTrash.setOnClickListener {
            notificationsViewModel.loadStateClearNotification(Notification.FIRST)
        }
        binding.ivSecondTrash.setOnClickListener {
            notificationsViewModel.loadStateClearNotification(Notification.SECOND)
        }
        binding.ivThirdTrash.setOnClickListener {
            notificationsViewModel.loadStateClearNotification(Notification.THIRD)
        }
        lifecycleScope.launch {
            notificationsViewModel.stateClearNotification.collect {
                when(it) {
                    Notification.FIRST -> {
                        binding.ivFirstNotification.visibility = View.GONE
                        binding.ivFIrstTrash.visibility = View.GONE
                    }
                    Notification.SECOND -> {
                        binding.ivSecondNotification.visibility = View.GONE
                        binding.ivSecondTrash.visibility = View.GONE
                    }
                    Notification.THIRD -> {
                        binding.ivThirdNotification.visibility = View.GONE
                        binding.ivThirdTrash.visibility = View.GONE
                    }
                    else -> {}
                }
            }
        }
        lifecycleScope.launch {
            notificationsViewModel.stateNotification.collect {
                when(it) {
                    Notification.NULL -> {
                        binding.ivFIrstTrash.visibility = View.GONE
                        binding.ivSecondTrash.visibility = View.GONE
                        binding.ivThirdTrash.visibility = View.GONE
                    }
                    Notification.FIRST -> {
                        binding.ivFIrstTrash.visibility = View.VISIBLE
                        binding.ivSecondTrash.visibility = View.GONE
                        binding.ivThirdTrash.visibility = View.GONE
                    }
                    Notification.SECOND -> {
                        binding.ivFIrstTrash.visibility = View.GONE
                        binding.ivSecondTrash.visibility = View.VISIBLE
                        binding.ivThirdTrash.visibility = View.GONE
                    }
                    Notification.THIRD -> {
                        binding.ivFIrstTrash.visibility = View.GONE
                        binding.ivSecondTrash.visibility = View.GONE
                        binding.ivThirdTrash.visibility = View.VISIBLE
                    }
                }
            }
        }
        return binding.root
    }


}