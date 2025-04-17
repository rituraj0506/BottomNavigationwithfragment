package com.example.drawer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fragmentManager = supportFragmentManager


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


    private fun openFragment(fragment: Fragment){
        val fragmenttransaction : FragmentTransaction=fragmentManager.beginTransaction()
        fragmenttransaction.replace(R.id.frame_container,fragment)
        fragmenttransaction.commit()
    }


}