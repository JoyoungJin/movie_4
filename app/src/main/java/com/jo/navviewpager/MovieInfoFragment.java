package com.jo.navviewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MovieInfoFragment extends Fragment {


    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static MovieInfoFragment newInstance() {

        Bundle args = new Bundle();

        MovieInfoFragment fragment = new MovieInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movie_info_fragment, container, false);

        final ViewPager viewPager = rootView.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(40, 0, 50, 0);
        viewPager.setPageMargin(getResources().getDisplayMetrics().widthPixels / -9);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        return rootView;
    }


}