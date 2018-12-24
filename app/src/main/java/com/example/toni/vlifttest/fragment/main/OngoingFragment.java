package com.example.toni.vlifttest.fragment.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.fragment.ongoing.AllFragment;
import com.example.toni.vlifttest.fragment.ongoing.CallsFragment;
import com.example.toni.vlifttest.fragment.ongoing.SharedNumbersFragment;


public class OngoingFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    public OngoingFragment() {

    }

    public static OngoingFragment newInstance() {
        OngoingFragment fragment = new OngoingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ongoing, container, false);
        tabLayout = view.findViewById(R.id.tab_layout_ongoing);
        viewPager = view.findViewById(R.id.view_pager_ongoing);
        toolbar = view.findViewById(R.id.toolbar_ongoing);

        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        toolbar.setTitle("Ongoing");

        return view;
    }




    private class PagerAdapter extends FragmentPagerAdapter {
        private static final int TAB_COUNT = 3;

        PagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int i) {
            Fragment fragment;
            switch (i) {
                case 0 : {
                    fragment = AllFragment.newInstance();
                    break;
                }

                case 1 : {
                    fragment = new SharedNumbersFragment();
                    break;
                }

                case 2 : {
                    fragment = new CallsFragment();
                    break;
                }

                default : {
                    fragment = null;
                    break;
                }
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0 : {
                    return "All";

                }

                case 1 : {
                    return "Number Shared";
                }

                case 2 : {
                    return "Call";
                }
            }
            return null;        }
    }
}
