package com.example.raghab.cigbuild1;

import android.app.ActionBar;
import android.content.Context;
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
public class SmokeViewPager extends FragmentActivity{

    ViewPager mViewPager = null;
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smoke_viewpager_fa);

        mViewPager = (ViewPager) findViewById(R.id.smoke_pager);
        //FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }
}

class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String[] titles = new String[]{"Tab 1", "Tab 2", "Tab 3"};
    Context mContext;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SmokeFragment f1 = new SmokeFragment();
                return f1;
            case 1:
                SmokeAnalyticsFragment f2 = new SmokeAnalyticsFragment();
                return f2;
            case 2:
                SmokeAchievementFragment f3 = new SmokeAchievementFragment();
                return f3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
