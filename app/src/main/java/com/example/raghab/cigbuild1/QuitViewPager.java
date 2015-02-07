package com.example.raghab.cigbuild1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by Raghab on 2/3/2015.
 *
 */
public class QuitViewPager extends FragmentActivity{

    ViewPager mViewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quit_viewpager_fa);

        mViewPager = (ViewPager) findViewById(R.id.quit_pager);
        //FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }


    private static class ViewPagerAdapter extends FragmentPagerAdapter {

        private String[] titles = new String[]{"Tab 1", "Tab 2", "Tab 3"};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new QuitHomeFragment();
                case 1:
                    return new SmokeAnalyticsFragment();
                case 2:
                    return new SmokeAchievementFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }
}


