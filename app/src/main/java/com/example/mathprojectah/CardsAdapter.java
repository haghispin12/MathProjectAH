package com.example.mathprojectah;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder>{

        public interface OnItenClickListener1{
            void onItemclick(Card item);
        }

        private ArrayList<Card> cards;
        private CardsAdapter.OnItenClickListener1 listener;

        public CardsAdapter(ArrayList<Card> cards, CardsAdapter.OnItenClickListener1 listener){
            this.cards = cards;
            this.listener = listener;
        }

        @NonNull
        @Override
        public CardsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

            return new CardsAdapter.MyViewHolder(view);
        }

        public void onBindViewHolder(@NonNull CardsAdapter.MyViewHolder holder, int position){
            holder.bind(cards.get(position),listener);
        }

        public int getItemCount(){
            return cards.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            ImageButton tvCardImg;

            public MyViewHolder(@NonNull View itemView){
                super(itemView);
                tvCardImg = itemView.findViewById(R.id.tvCardImg);
            }

            public void bind(final Card item, final OnItenClickListener1 listener){
                tvCardImg.setImageResource(item.getDrawable());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemclick(item);
                    }
                });
            }
        }

}