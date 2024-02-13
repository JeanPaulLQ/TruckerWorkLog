package com.someware.bitacoraviajes.utils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.someware.bitacoraviajes.data.models.WorkService;
import com.someware.bitacoraviajes.databinding.WorkItemBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WorksRecyclerAdapter extends RecyclerView.Adapter<WorksRecyclerAdapter.ViewHolder> {
    List<WorkService> workServiceList = new ArrayList<>();
    @NonNull
    @Override
    public WorksRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WorkItemBinding binding = WorkItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorksRecyclerAdapter.ViewHolder holder, int position) {
        holder.bindViews(workServiceList.get(position));
    }
    void setWorkServiceList(List<WorkService> workServiceList){
        this.workServiceList = workServiceList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return workServiceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        WorkItemBinding binding;
        public ViewHolder(@NonNull WorkItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bindViews(WorkService workItem){
            SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
            Log.i("TAG", "bindViews: "+sdf.format(workItem.getOutboundStartDate()));
            //binding.tvDateStart.setText(workItem.getOutboundStartDate());

        }
    }
}
