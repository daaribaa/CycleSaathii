package com.example.cycle_saathi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    ArrayList<DetailsDTO> detailsList;
    String distance, time, avgSpeed, elevationGain;

    public DetailsAdapter(ArrayList<DetailsDTO> detailsList) {
        this.detailsList = detailsList;
    }

    public DetailsAdapter (String distance, String time, String avgSpeed, String elevationGain){
        this.distance = distance;
        this.time = time;
        this.avgSpeed = avgSpeed;
        this.elevationGain = elevationGain;
    }

    @NonNull
    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lin = LayoutInflater.from(parent.getContext());
        View view = lin.inflate(R.layout.layout_single_detail,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.ViewHolder holder, int position) {

        /*holder.titleTV.setText("Distance");
        holder.dataTV.setText(detailsList.get(position).getDistance());*/

    }

    @Override
    public int getItemCount() {
        return 0;
        //return detailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTV , dataTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleTV = itemView.findViewById(R.id.detailTitle);
            this.dataTV = itemView.findViewById(R.id.detailData);
        }
    }


}
