package com.example.drawer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.drawer.Fragment.CartFragment
import com.example.drawer.Fragment.HomeFragment
import com.example.drawer.Fragment.MenuFragment
import com.example.drawer.Fragment.ProfileFragment
import com.example.drawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fragmentManager = supportFragmentManager



        // for toolbar
        setSupportActionBar(binding.toolbar)

      // for navigation drawer

        val toggle = ActionBarDrawerToggle(this,binding.drawerlayout,binding.toolbar,R.string.nav_open,R.string.nav_close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navigationDrawer.setNavigationItemSelectedListener(this)








 // for bottom navigation
        binding.bottomnavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.bottom_home ->{
                    openFragment(HomeFragment())
                    true
                }
                R.id.botoom_profile ->{
                    openFragment(ProfileFragment())
                    true
                }
                R.id.bottom_menu ->{
                    openFragment(MenuFragment())
                    true
                }
                R.id.bottom_cart ->{
                    openFragment(CartFragment())
                    true
                }
                else -> false

            }


        }






    }

    // we will use framgment transaction and fragment manager that will helps replace fragment in fragment container
    private fun openFragment(fragment: Fragment){
        val fragmenttransaction : FragmentTransaction=fragmentManager.beginTransaction()
        fragmenttransaction.replace(R.id.frame_container,fragment)
        fragmenttransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_menu -> openFragment(MenuFragment())
            R.id.nav_cart -> openFragment(CartFragment())
            R.id.nav_home -> openFragment(HomeFragment())

        }
        binding.drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }


}