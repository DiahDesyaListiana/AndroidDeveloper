package com.poliban.ac.id.e020320093.tabexperiment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0: return new Tab1Fragment();
            case 1: return new Tab2Fragment();
            case 2: return new Tab3Fragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs; }

}
