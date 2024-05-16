package com.example.mathprojectah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PlayGround extends AppCompatActivity {

    private RecyclerView rcPlayGround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);

        rcPlayGround.findViewById(R.id.rcPlayGround);
        initView();
    }

    public void initView(){

    }
}