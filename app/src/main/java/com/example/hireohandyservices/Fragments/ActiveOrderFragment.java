package com.example.hireohandyservices.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hireohandyservices.Adapters.ActiveOrderAdapter;
import com.example.hireohandyservices.Models.ActiveOrderModel;
import com.example.hireohandyservices.R;

import java.util.ArrayList;
import java.util.List;

public class ActiveOrderFragment extends Fragment {

    RecyclerView recyclerView;
    ActiveOrderAdapter adapter;
    List<ActiveOrderModel> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = connectViews(inflater,container);

        setData();
        setAdapter();


        return view;
    }

    private void setAdapter(){
        adapter = new ActiveOrderAdapter(data,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void setData(){
        data = new ArrayList<>();
        data.add(new ActiveOrderModel(R.drawable.ic_about,"blue","Blah","Blah 1","123123","342"));
        data.add(new ActiveOrderModel(R.drawable.ic_user_img,"green","agesad","saasg 1","456","567"));
    }

    private View connectViews(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_active_order, container, false);
        recyclerView = view.findViewById(R.id.activeOrder_recyclerView);
        return view;
    }


}