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
import com.example.hireohandyservices.Models.JobsModel;
import com.example.hireohandyservices.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class JobsFragmentPage extends Fragment {

    RecyclerView recyclerView;
    JobsAdapter adapter;
    List<JobsModel> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = connectViews(inflater,container);

        setData();
        setAdapter();

        return view;
    }
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
        View view = inflater.inflate(R.layout.fragment_jobs_page, container, false);
        recyclerView = view.findViewById(R.id.jobs_recyclerView);
        return view;
    }
}