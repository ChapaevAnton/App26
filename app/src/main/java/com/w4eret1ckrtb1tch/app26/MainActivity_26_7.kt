package com.w4eret1ckrtb1tch.app26

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation

class MainActivity_26_7 : AppCompatActivity() {

    companion object NavigationMain {

        const val EMPLOYEE_ONE = "EMPLOYEE_ONE"
        const val EMPLOYEE_TWO = "EMPLOYEE_TWO"

        fun getNavController(activity: Activity) =
            Navigation.findNavController(activity, R.id.nav_host_fragment_container)

        fun getBackStackEntryCount(fragmentActivity: FragmentActivity): Int? {
            return fragmentActivity.supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_container)
                ?.childFragmentManager
                ?.backStackEntryCount
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_26_7)

    }

}