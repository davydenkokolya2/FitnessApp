package com.example.fitnessapp.ui.nav_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentNavBarBinding
import com.example.fitnessapp.ui.NavigationViewModel
import com.example.fitnessapp.ui.home.HomeFragment
import com.example.fitnessapp.ui.insight.InsightFragment
import com.example.fitnessapp.ui.notification.NotificationsFragment
import com.example.fitnessapp.ui.workout_categories.WorkoutCategoriesFragment
import com.example.fitnessapp.util.Screen
import kotlinx.coroutines.launch

class NavBarFragment : Fragment() {

    private val navigationViewModel: NavigationViewModel by activityViewModels()
    private val navBarViewModel: NavBarViewModel by activityViewModels()
    private lateinit var binding: FragmentNavBarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavBarBinding.inflate(inflater, container, false)
        binding.btnNavBarInsight.setOnClickListener {
            navBarViewModel.loadState(Screen.INSIGHT)
        }
        binding.btnNavBarHome.setOnClickListener {
            navBarViewModel.loadState(Screen.HOME)
        }
        binding.btnNavBarNotification.setOnClickListener {
            navBarViewModel.loadState(Screen.NOTIFICATION)
        }
        binding.btnNavBarProfile.setOnClickListener {
            navigationViewModel.loadState(Screen.PROFILE)
        }
        lifecycleScope.launch {
            navBarViewModel.stateScreen.collect {
                when(it) {
                    Screen.HOME -> {
                        binding.btnNavBarHome.setImageResource(R.drawable.icon_nav_bar_home_white)
                        binding.btnNavBarInsight.setImageResource(R.drawable.icon_nav_bar_insight)
                        binding.btnNavBarNotification.setImageResource(R.drawable.icon_nav_bar_notification)
                        replaceFragment(HomeFragment())
                    }
                    Screen.WORKOUT_CATEGORIES -> replaceFragment(WorkoutCategoriesFragment())
                    Screen.INSIGHT -> {
                        binding.btnNavBarHome.setImageResource(R.drawable.icon_nav_bar_home)
                        binding.btnNavBarInsight.setImageResource(R.drawable.icon_nav_bar_insight_white)
                        binding.btnNavBarNotification.setImageResource(R.drawable.icon_nav_bar_notification)
                        replaceFragment(InsightFragment())
                    }
                    Screen.NOTIFICATION -> {
                        binding.btnNavBarHome.setImageResource(R.drawable.icon_nav_bar_home)
                        binding.btnNavBarInsight.setImageResource(R.drawable.icon_nav_bar_insight)
                        binding.btnNavBarNotification.setImageResource(R.drawable.icon_nav_bar_notification_white)
                        replaceFragment(NotificationsFragment())
                    }
                    else -> {}
                }
            }
        }
        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()
    }
}