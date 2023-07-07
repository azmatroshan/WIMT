package com.app.wimt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.app.wimt.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()
    }

    private fun setupViewPager() {
        val tabLayout: TabLayout = binding.tabLayout
        val viewPager: ViewPager2 = binding.viewPager

        val adapter = TabPagerAdapter( supportFragmentManager, lifecycle)
        adapter.addFragment(SpotFragment(), getString(R.string.spot))
        adapter.addFragment(PnrFragment(), getString(R.string.pnr))
        adapter.addFragment(TicketFragment(), getString(R.string.tickets))

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }
}