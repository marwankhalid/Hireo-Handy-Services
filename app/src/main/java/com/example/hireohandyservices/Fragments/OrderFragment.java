package com.example.hireohandyservices.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hireohandyservices.Adapters.JobsPagerAdapter;
import com.example.hireohandyservices.Adapters.OrderPagersAdapter;
import com.example.hireohandyservices.R;
import com.google.android.material.tabs.TabLayout;

public class OrderFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    private ActiveOrderFragment tab1;
    private CompletedOrderFragment tab2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = connectViews(inflater,container);

        setViewPager2();

        return view;
    }

    private void setViewPager2(){
        OrderPagersAdapter adapter = new OrderPagersAdapter(getChildFragmentManager()) {
        };
        tab1 = new ActiveOrderFragment();
        tab2 = new CompletedOrderFragment();

        adapter.addfragment(tab1, "Active Order");
        adapter.addfragment(tab2, "Completed Order");

        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private View connectViews(LayoutInflater inflater,ViewGroup container){
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        tabLayout=(TabLayout)view.findViewById(R.id.tabLayoutOrder);
        viewPager=(ViewPager)view.findViewById(R.id.viewPagerOrder);
        return view;
    }
}