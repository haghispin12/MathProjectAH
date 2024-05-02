package com.example.mathprojectah.mathexercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathprojectah.R;

import java.util.ArrayList;

public class UserAdapter {
    public interface OnItenClickListener1{
        void onItemclick(User item);
    }

    private ArrayList<User> users;
    private UserAdapter.OnItenClickListener1 listener;

    public UserAdapter(ArrayList<User> users, UserAdapter.OnItenClickListener1 listener){
        this.users = users;
        this.listener = listener;
    }

    @NonNull

    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new UserAdapter.MyViewHolder(view);
    }

    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position){
        holder.bind(users.get(position),listener);
    }

    public int getItemCount(){
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFruitName;
        ImageView tvFruitImg;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tvFruitName = itemView.findViewById(R.id.tvFruitName);
            tvFruitImg = itemView.findViewById(R.id.tvFruitImg);
        }

        public void bind(final User item, final UserAdapter.OnItenClickListener1 listener){
            tvFruitName.setText(item.getName());
            tvFruitImg.setImageBitmap(item.getBitmap());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemclick(item);
                }
            });
        }
    }

}
