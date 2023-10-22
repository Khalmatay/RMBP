package com.example.kh_lab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MultiscreenActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiscreen)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.setupWithViewPager(viewPager)

        val vpAdapter = VPAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        vpAdapter.addFragment(ScreenActivity1(), "Home")
        vpAdapter.addFragment(ScreenActivity2(), "My Network")
        vpAdapter.addFragment(ScreenActivity3(), "Post")
        vpAdapter.addFragment(ScreenActivity4(), "Notifications")
        vpAdapter.addFragment(ScreenActivity5(), "Jobs")
        viewPager.adapter = vpAdapter
    }
}
