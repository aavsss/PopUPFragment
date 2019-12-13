package com.example.popupfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PopUp extends Fragment {

    public PopUp(){
        //Empty Constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pop_up, container, false);

        final TextView press = rootView.findViewById(R.id.presss);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), MainActivity.class));
                if(getFragmentManager().getBackStackEntryCount()>0){
                    getFragmentManager().popBackStack();
                }
            }
        });
//
//        ViewPager viewPager = rootView.findViewById(R.id.pager);
//        SimpleFragmentPagerAdapter adaper = new SimpleFragmentPagerAdapter(this, )

        return rootView;
    }
}
