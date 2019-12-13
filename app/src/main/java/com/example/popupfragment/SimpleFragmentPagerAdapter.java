package com.example.popupfragment;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    //Context of the a[[
    private Context context;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new PopUp();
        }else {
            return new PopUpTwo();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
