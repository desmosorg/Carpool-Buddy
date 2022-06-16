package com.example.carpoolbuddy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VehiclesInfoViewHolder extends RecyclerView.ViewHolder
{
    protected TextView vehicleTextView;
    protected TextView ownerTextView;
    protected TextView openTextView;
    protected TextView priceTextView;
    protected TextView capacityTextView;

    public VehiclesInfoViewHolder(@NonNull View itemView) {
        super(itemView);
        vehicleTextView = itemView.findViewById(R.id.vehicleTextView);
        ownerTextView = itemView.findViewById(R.id.ownerTextView);
        openTextView = itemView.findViewById(R.id.openTextView);
        priceTextView = itemView.findViewById(R.id.priceTextView);
        capacityTextView = itemView.findViewById(R.id.priceTextView);

    }
}
