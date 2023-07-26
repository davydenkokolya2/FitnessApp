package com.example.fitnessapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.ActivityMainBinding
import com.example.fitnessapp.ui.activity_level.ActivityLevelFragment
import com.example.fitnessapp.ui.age.AgeFragment
import com.example.fitnessapp.ui.gender.GenderFragment
import com.example.fitnessapp.ui.goal.GoalFragment
import com.example.fitnessapp.ui.height.HeightFragment
import com.example.fitnessapp.ui.nav_bar.NavBarFragment
import com.example.fitnessapp.ui.notifications_settings.NotificationsSettingsFragment
import com.example.fitnessapp.ui.onboarding_host.OnboardingHostFragment
import com.example.fitnessapp.ui.profile.ProfileFragment
import com.example.fitnessapp.ui.settings.SettingsFragment
import com.example.fitnessapp.ui.training.TrainingFragment
import com.example.fitnessapp.ui.units_of_measure.UnitsOfMeasureFragment
import com.example.fitnessapp.ui.weight.WeightFragment
import com.example.fitnessapp.ui.workout_plan_detail.WorkoutPlanDetailFragment
import com.example.fitnessapp.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navigationViewModel: NavigationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        lifecycleScope.launch {
            navigationViewModel.stateScreen.collect {
                when(it) {
                    Screen.ONBOARDING -> replaceFragment(OnboardingHostFragment())
                    Screen.ACTIVITY_LEVEL -> replaceFragment(ActivityLevelFragment())
                    Screen.AGE -> replaceFragment(AgeFragment())
                    Screen.GENDER -> replaceFragment(GenderFragment())
                    Screen.HEIGHT -> replaceFragment(HeightFragment())
                    Screen.NOTIFICATIONS_SETTINGS -> replaceFragment(NotificationsSettingsFragment())
                    Screen.PROFILE -> replaceFragment(ProfileFragment())
                    Screen.SETTINGS -> replaceFragment(SettingsFragment())
                    Screen.TRAINING -> replaceFragment(TrainingFragment())
                    Screen.WEIGHT -> replaceFragment(WeightFragment())
                    Screen.UNITS_OF_MEASURE -> replaceFragment(UnitsOfMeasureFragment())
                    Screen.WORKOUT_PLAN_DETAIL -> replaceFragment(WorkoutPlanDetailFragment())
                    Screen.GOAL -> replaceFragment(GoalFragment())
                    Screen.NAV_BAR -> replaceFragment(NavBarFragment())
                    else -> {}
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}