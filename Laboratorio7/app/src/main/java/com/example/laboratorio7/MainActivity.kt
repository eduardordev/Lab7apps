package com.example.laboratorio7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratorio7.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navDrawer: NavigationView



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )

        drawerLayout=binding.drawerLayout
        navDrawer=binding.navView1

        val Controllernav=this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,Controllernav,drawerLayout)
        NavigationUI.setupWithNavController(navDrawer,Controllernav)

    }

    override fun onSupportNavigateUp(): Boolean {

        val navController=this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController,drawerLayout)
    }
}
