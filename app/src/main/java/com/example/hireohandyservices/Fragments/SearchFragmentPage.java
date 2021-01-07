package com.example.hireohandyservices.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.hireohandyservices.Adapters.SearchFragmentAdapter;
import com.example.hireohandyservices.Models.SearchFragmentModel;
import com.example.hireohandyservices.R;

import java.util.ArrayList;

public class SearchFragmentPage extends Fragment {

    ArrayList<SearchFragmentModel> data;
    SearchFragmentAdapter adapter;
    RecyclerView recyclerView;
    private SwipeRefreshLayout refreshView;
    private LottieAnimationView wait_anim;
    private LinearLayout connection_error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = connectViews(inflater, container);

        setData();
//        recyclerView.setVisibility(View.GONE);
//        connection_error.setVisibility(View.GONE);
//        wait_anim.setVisibility(View.VISIBLE);
        setRefreshView();
        setAdapter();

        return view;
    }

    private void setRefreshView(){
        refreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setAdapter();
            }
        });
    }

    private void setData(){
        data = new ArrayList<>();
        data.add(new SearchFragmentModel(R.drawable.app_icon,"asd","asd","egdd","asd"));
        data.add(new SearchFragmentModel(R.drawable.app_icon,"asd","ll","marwan","893"));
    }

    private void setAdapter(){
        if (data.isEmpty()){
            refreshView.setRefreshing(false);
            recyclerView.setVisibility(View.GONE);
            connection_error.setVisibility(View.GONE);
            wait_anim.setVisibility(View.VISIBLE);
        }else{
            refreshView.setRefreshing(false);
            connection_error.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            wait_anim.setVisibility(View.GONE);
            adapter = new SearchFragmentAdapter(data,getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }


    }


    private View connectViews(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_search_page, container, false);
        recyclerView = view.findViewById(R.id.search_recyclerView);
        refreshView = view.findViewById(R.id.search_refreshView);
        wait_anim = view.findViewById(R.id.wait_anim);
        connection_error = view.findViewById(R.id.connection_error);
        return view;
    }
}