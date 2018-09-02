package com.example.david0926.firebasechat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyleAdapter extends RecyclerView.Adapter<RecycleHolder>{

    List<RecycleModel> items = new ArrayList<>();

    public void add(RecycleModel data){
        items.add(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new RecycleHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder holder, int position) {
        RecycleModel item = items.get(position);
        holder.name.setText(item.getName());
        holder.msg.setText(item.getMsg());
        holder.time.setText(item.getTime());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
