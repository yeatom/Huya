package com.yeatom.huya

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.yeatom.huya.databinding.ActivityMainBinding
import com.yeatom.ui.LottieBottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: LottieBottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        navView.setLottieResources(arrayOf(
            "homepage_hotlive_tab.json",
            "homepage_entertainment_tab.json",
            "homepage_subscribe_tab.json",
            "homepage_discovery_tab.json",
            "homepage_profile_tab.json"
        ))

        navView.setOnItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it, navController)
            true
        }
    }
}