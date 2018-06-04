package com.time.table;
/*
 * Created by will.spitzer on 01/06/2018.
 */

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        setupTabs();

    }

    private void setupTabs() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Town"));
        tabLayout.addTab(tabLayout.newTab().setText("Work"));

//        tabLayout.addTab(tabLayout.newTab().setText("i4"));
//        tabLayout.addTab(tabLayout.newTab().setText("indigo"));
//        tabLayout.addTab(tabLayout.newTab().setText("Lenton"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                toolbar.setTitle(getTitle(viewPager));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private String getTitle(ViewPager viewPager) {
        String title = "default";
        switch (viewPager.getCurrentItem()) {
            case 0:
                title = "Train Station";
                break;
            case 1:
                title = "Wheatcrofts";
                break;
//            case 2:
//                title = "Friar Lane";
//                break;
//            case 3:
//                title = "Friar Lane";
//                break;
//            case 4:
//                title = "Canning Circus";
//                break;
        }
        return title;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
