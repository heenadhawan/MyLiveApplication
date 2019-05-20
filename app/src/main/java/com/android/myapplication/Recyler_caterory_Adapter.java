package com.android.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Recyler_caterory_Adapter extends
        RecyclerView.Adapter<Recyler_caterory_Adapter.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.gridview_text);
            final Context context = itemView.getContext();
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.gridview_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getPosition() == 0) {
                        Intent intent = new Intent(context,
                                CurrentLocationNearByPlacesActivity.class);
                        context.startActivity(intent);
                    }
                    if (getPosition() == 1) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }
                    if (getPosition() == 2) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }
                    if (getPosition() == 3) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }
                    if (getPosition() == 4) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }
                    if (getPosition() == 5) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }
                    if (getPosition() == 6) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                    }

                }
            });
        }
    }
        public Recyler_caterory_Adapter(ArrayList<Arraylist> data) {
            this.dataSet = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.category_recyler, parent, false);

            //view.setOnClickListener(Navigation.myOnClickListener);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

            TextView textViewName = holder.textViewName;
            // TextView textViewVersion = holder.textViewVersion;
            ImageView imageView = holder.imageViewIcon;

            textViewName.setText(dataSet.get(listPosition).getName());
            //textViewVersion.setText(dataSet.get(listPosition).getVersion());
            imageView.setImageResource(dataSet.get(listPosition).getImage());
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }}

