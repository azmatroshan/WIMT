package com.app.wimt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.viewpager2.widget.ViewPager2
import com.app.wimt.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, navigationDrawer, R.string.open, R.string.close)
            navigationDrawer.addDrawerListener(toggle)
            toggle.syncState()

            navView.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.shareApp -> {
                        Toast.makeText(this@MainActivity, getString(R.string.share_app), Toast.LENGTH_SHORT).show()
                        navigationDrawer.close()
                    }
                    else -> {}
                }
                true
            }

            binding.toolbar.menuIcon.setOnClickListener {
                navigationDrawer.openDrawer(navView)
            }
        }
        binding.toolbar.more.setOnClickListener { view ->

            val popupMenu = PopupMenu(this@MainActivity, view)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.shareApp -> {
                        Toast.makeText(this@MainActivity, getString(R.string.share_app), Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.settings -> {
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
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