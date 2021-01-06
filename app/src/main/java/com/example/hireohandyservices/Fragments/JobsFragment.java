package com.example.hireohandyservices.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hireohandyservices.Adapters.JobsAdapter;
import com.example.hireohandyservices.Adapters.JobsPagerAdapter;
import com.example.hireohandyservices.Models.JobsModel;
import com.example.hireohandyservices.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class JobsFragment extends Fragment {

    RecyclerView recyclerView;
    JobsAdapter adapter;
    List<JobsModel> data;
    ViewPager viewPager;
    TabLayout tabLayout;
    private JobsFragmentPage tab1;
    private SearchFragmentPage tab2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = connectViews(inflater,container);

        //setData();
        //setAdapter();
        //setViewPager();
        setViewPager2();

        return view;
    }

    private void setViewPager2(){
        JobsPagerAdapter adapter = new JobsPagerAdapter(getChildFragmentManager()) {
        };
        tab1 = new JobsFragmentPage();
        tab2 = new SearchFragmentPage();

        adapter.addfragment(tab1, "Jobs");
        adapter.addfragment(tab2, "Search");

        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
/*
    private void setViewPager() {

        tabLayout.addTab(tabLayout.newTab().setText("Jobs"));
        tabLayout.addTab(tabLayout.newTab().setText("Search"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final PagerAdapter adapter = new com.example.hireohandyservices.Adapters.PagerAdapter(getActivity(), getChildFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }*/

    private void setData(){
        data = new ArrayList<>();
        data.add(new JobsModel(R.drawable.ic_about,"Change Water Machine","Gulbahar,Peshawar","0333-1235152","Rs. 800"));
        data.add(new JobsModel(R.drawable.ic_alert,"Place Tv on Wall","Sadar,Peshawar","0313-1499762","Rs. 1000"));
    }

    private void setAdapter() {
        adapter = new JobsAdapter(data,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }



    private View connectViews(LayoutInflater inflater,ViewGroup container){
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);
        recyclerView = view.findViewById(R.id.jobs_recyclerView);
        tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        return view;
    }

}