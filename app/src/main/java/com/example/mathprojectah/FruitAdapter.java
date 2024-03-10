package com.example.mathprojectah;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder> {

        public interface OnItenClickListener1{
                void onItemclick(Fruit item);
        }

        private ArrayList<Fruit> fruits;
        private OnItenClickListener1 listener;

        public FruitAdapter(ArrayList<Fruit> fruits, OnItenClickListener1 listener){
                this.fruits = fruits;
                this.listener = listener;
        }

        @NonNull
        @Override
        public FruitAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

                return new MyViewHolder(view);
        }

        public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
                holder.bind(fruits.get(position),listener);
        }

        public int getItemCount(){
                return fruits.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
                TextView tvFruitName;
                ImageView tvFruitImg;

                public MyViewHolder(@NonNull View itemView){
                        super(itemView);
                        tvFruitName = itemView.findViewById(R.id.tvFruitName);
                        tvFruitImg = itemView.findViewById(R.id.tvFruitImg);
                }

                public void bind(final Fruit item, final OnItenClickListener1 listener){
                        tvFruitName.setText(item.getName());
                        tvFruitImg.setImageResource(item.getDrawable());
                        itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        listener.onItemclick(item);
                                }
                        });
                }
        }

}

