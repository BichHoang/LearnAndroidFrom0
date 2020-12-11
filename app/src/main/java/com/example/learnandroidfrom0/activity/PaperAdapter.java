package com.example.learnandroidfrom0.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by Bich Hoang on 12/11/2020.
 */
public class PaperAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PaperAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.mNoOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                TabMain tabMain = new TabMain();
                return tabMain;
            case 1:
                TabDiary tabDiary = new TabDiary();
                return tabDiary;
            case 2:
                TabPlan tabPlan = new TabPlan();
                return tabPlan;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
