package com.example.hireohandyservices.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hireohandyservices.Models.JobsModel;
import com.example.hireohandyservices.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.myViewHolder> {

    List<JobsModel> data;
    Context context;

    public JobsAdapter(List<JobsModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.jobs_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.img.setImageResource(data.get(position).getImg());
        holder.jobTitle.setText(data.get(position).getJobTitle());
        holder.jobPrice.setText(data.get(position).getJobPrice());
        holder.jobPhone.setText(data.get(position).getJobPhone());
        holder.jobLocation.setText(data.get(position).getJobLocation());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView jobTitle,jobLocation,jobPrice,jobPhone;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.job_img);
            jobTitle = itemView.findViewById(R.id.job_title);
            jobLocation = itemView.findViewById(R.id.job_location);
            jobPrice = itemView.findViewById(R.id.job_price);
            jobPhone = itemView.findViewById(R.id.job_phone);
        }
    }
}
