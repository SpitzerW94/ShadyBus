package com.time.table;
/*
 * Created by will.spitzer on 01/06/2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment2();
//            case 2:
//                return new TabFragment3();
//            case 3:
//                return new TabFragment4();
//            case 4:
//                return new TabFragment5();
            default:
                return new TabFragment1();
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
