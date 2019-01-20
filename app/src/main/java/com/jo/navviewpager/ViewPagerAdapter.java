package com.jo.navviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragment = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        for (int i = 0; i < 5; i++) {
            mFragment.add(MoviePageItemFragment.newInstance(i));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);

    }
    @Override
    public int getCount() {
        return mFragment.size();
    }
    @Override
    public float getPageWidth(int position) {
        return (1.0f);
    }


}
