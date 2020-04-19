package com.example.drinkmachine;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new beverages();
            case 1:
                return new map();
            case 2:
                return new comment();
            default:
                return null;
        }

    }


    @Override
    public int getCount() {
        return 3;
    }


}

