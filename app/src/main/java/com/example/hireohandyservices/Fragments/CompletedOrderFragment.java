package com.example.hireohandyservices.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hireohandyservices.Adapters.CompletedOrderAdapter;
import com.example.hireohandyservices.Models.CompletedOrderModel;
import com.example.hireohandyservices.R;

import java.util.ArrayList;
import java.util.List;

public class CompletedOrderFragment extends Fragment {

    RecyclerView recyclerView;
    CompletedOrderAdapter adapter;
    List<CompletedOrderModel> data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = connectViews(inflater,container);

        setData();
        setAdapter();


        return view;
    }

    private void setData() {
        data = new ArrayList<>();
        data.add(new CompletedOrderModel(R.drawable.ic_user_img,"asd","asd","asd","asd","asd"));
        data.add(new CompletedOrderModel(R.drawable.ic_user_img,"asd","asd","asd","asd","asd"));
    }

    private void setAdapter(){
        adapter = new CompletedOrderAdapter(data,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private View connectViews(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_completed_order, container, false);
        recyclerView = view.findViewById(R.id.completed_recyclerView);
        return view;
    }
}