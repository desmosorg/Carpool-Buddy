package com.example.carpoolbuddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class VehiclesInfoAdapter extends RecyclerView.Adapter<VehiclesInfoViewHolder>
{
    
    @NonNull
    @Override
    public VehiclesInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles_info_row_view, parent, false);
        
        VehiclesInfoViewHolder holder = new VehiclesInfoViewHolder(myView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesInfoViewHolder holder, int position)
    {
//        holder.vehicleTextView.setText();
//        holder.ownerTextView.setText();
//        holder.openTextView.setText();
//        holder.priceTextView.setText();
//        holder.capacityTextView.setText();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
