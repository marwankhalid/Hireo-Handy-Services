package com.example.hireohandyservices.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hireohandyservices.Fragments.SearchFragmentPage;
import com.example.hireohandyservices.Models.SearchFragmentModel;
import com.example.hireohandyservices.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentAdapter.myViewHolder> {

    ArrayList<SearchFragmentModel> data;
    Context context;

    public SearchFragmentAdapter(ArrayList<SearchFragmentModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.search_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder{

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
