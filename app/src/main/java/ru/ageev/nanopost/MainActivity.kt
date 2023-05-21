package ru.ageev.nanopost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.nanopost.data.PrefsStorage
import ru.ageev.nanopost.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var prefsStorage: PrefsStorage
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        val token = prefsStorage.token


        val navGraph = navController.navInflater.inflate(
            if (token != null) {
                R.navigation.nav_graph
            } else {
                R.navigation.nav_graph_auth
            }
        )

        navGraph.setStartDestination(
            if (token != null) {
                R.id.myProfileFragment
            } else {
                R.id.authFragment
            }
        )

        navController.setGraph(navGraph, savedInstanceState)
    }
}