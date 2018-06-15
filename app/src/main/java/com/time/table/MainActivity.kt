package com.time.table

/*
 * Created by will.spitzer on 01/06/2018.
 */

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu

class MainActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        toolbar = findViewById(R.id.toolbar)

        setupTabs()
    }

    private fun setupTabs() {
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        // Bus stops for the station and outside work
        tabLayout.addTab(tabLayout.newTab().setText("Station"))
        tabLayout.addTab(tabLayout.newTab().setText("Work"))

        // Additional bus stops in town and lenton
        tabLayout.addTab(tabLayout.newTab().setText("i4"))
        tabLayout.addTab(tabLayout.newTab().setText("indigo"))
        tabLayout.addTab(tabLayout.newTab().setText("Lenton"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val viewPager = findViewById<ViewPager>(R.id.pager)
        val adapter = PagerAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                toolbar!!.title = getTitle(viewPager)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun getTitle(viewPager: ViewPager): String {
        var title = "default"
        when (viewPager.currentItem) {
            0 -> title = "Train Station"
            1 -> title = "Wheatcrofts"
            2 -> title = "Friar Lane"
            3 -> title = "Friar Lane"
            4 -> title = "Canning Circus"
        }
        return title
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}
