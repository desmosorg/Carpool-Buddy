package com.example.carpoolbuddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;


public class VehiclesInfoAdapter extends RecyclerView.Adapter<VehiclesInfoViewHolder>{

    ArrayList<Vehicle> vehicles;

    private OnNoteListener mOnNoteListener;




    public VehiclesInfoAdapter(ArrayList<Vehicle> vehicles, OnNoteListener monNoteListener) {
        this.vehicles = vehicles;
        this.mOnNoteListener = monNoteListener;
    }


    @NonNull
    public VehiclesInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles_info_row_view, parent, false);

        VehiclesInfoViewHolder viewHolder = new VehiclesInfoViewHolder(view, mOnNoteListener);

        return viewHolder;
    }

    public void onBindViewHolder(@NonNull VehiclesInfoViewHolder holder, int position) {
        String model = vehicles.get(position).getModel();
        String type = vehicles.get(position).getVehicleType();
        String capacity = "" + vehicles.get(position).getCapacity();
        String basePrice = "" + vehicles.get(position).getBasePrice();
        String open = "" + vehicles.get(position).getOpen();


        //set EditTexts to variables
        holder.vehicleTextView.setText("Model : " + model);
        holder.ownerTextView.setText("Owner : " + type);
        holder.priceTextView.setText("Price : " + basePrice);
        holder.capacityTextView.setText("Capacity : " + capacity);
        holder.openTextView.setText("Open : " + open);

    }


    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    public interface OnVehicleListener {
        void onVehicleClick(int position);

    }

}