package com.hungamademo.android.ui.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hungamademo.android.R
import com.hungamademo.android.databinding.ActivityMainBinding
import com.hungamademo.android.ui.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        addFragment("Discover")
        setBottomSheetListener()
    }


    //Bottom naigation item click event
    private fun setBottomSheetListener() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            addFragment(item.title as String)
            true
        }
    }

    //add the dynamic tabLayout into frame layout on item position
    private fun addFragment(bottomNavSelectedTabName: String) {
        val fragment = HomeFragment.newInstance(bottomNavSelectedTabName)
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}