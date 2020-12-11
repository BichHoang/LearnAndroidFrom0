package com.example.learnandroidfrom0;

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
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return  tab2;
            case 2:
                Tab3 tab3 = new Tab3();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
