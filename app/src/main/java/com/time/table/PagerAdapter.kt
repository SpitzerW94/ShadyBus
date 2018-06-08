package com.time.table

/*
 * Created by will.spitzer on 01/06/2018.
 */

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager, private val mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabFragment1()
            1 -> TabFragment2()
            2 -> TabFragment3()
            3 -> TabFragment4()
            4 -> TabFragment5()
            else -> TabFragment1()
        }

    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}
