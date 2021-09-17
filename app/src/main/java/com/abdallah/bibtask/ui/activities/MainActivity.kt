package com.abdallah.bibtask.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.abdallah.bibtask.R
import com.abdallah.bibtask.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawer = binding.drawerLayout


        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        toggle= ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()



        // set the first item selected // home item
        binding.appBarHome.navViewBottom.setItemSelected(R.id.navigation_home,true)

        // make the navViewBottom show with controller
        binding.appBarHome.navViewBottom.setOnItemSelectedListener { itemId ->
            binding.appBarHome.navViewGone.selectedItemId = itemId
         }
        NavigationUI.setupWithNavController(binding.appBarHome.navViewGone,navController)
        clicks()



    }



    @SuppressLint("WrongConstant")
    private fun clicks() {
        // open drawer once you click the item menu
        binding.appBarHome.imgMenu.setOnClickListener {
            drawer.openDrawer(Gravity.START)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){

            return true
        }
        return super.onOptionsItemSelected(item)
    }



}