package com.example.farmingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Config {

    static class DataItemView extends RecyclerView.ViewHolder{

        private TextView temperature;
        private TextView luminosity;
        private TextView humidity_soil;
        private TextView humidity_air;


        public DataItemView(ViewGroup parent){
            super(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.data_list_item,parent,false));

            temperature= itemView.findViewById(R.id.temperature);
            luminosity= itemView.findViewById(R.id.luminosity);
            humidity_air =itemView.findViewById(R.id.humidity_air);
            humidity_soil=itemView.findViewById(R.id.humidity_soil);
        }

        public void bind (UserRobot data){

            luminosity.setText(Float.toString(data.getLuminosity()));
            temperature.setText(Float.toString(data.getTemperature()));
            humidity_soil.setText(Float.toString(data.getHumidity_soil()));
            humidity_air.setText(Float.toString(data.getHumidity_air()));

        }


    }

    static class DataAdapter extends RecyclerView.Adapter<DataItemView>{

        private List<UserRobot> mDataList=new ArrayList<>();
        private List<String> keys = new ArrayList<>();



        public void submitList(List<UserRobot> list,List<String> keys) {
            mDataList = list;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public DataItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DataItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DataItemView holder, int position) {
            holder.bind(mDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }
}
