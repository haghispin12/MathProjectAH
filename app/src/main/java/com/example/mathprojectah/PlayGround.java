package com.example.mathprojectah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mathprojectah.R;

import java.util.ArrayList;
public class PlayGround extends AppCompatActivity {
    ViewModel vm;
    private RecyclerView rcPlayGround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);

        rcPlayGround.findViewById(R.id.rcPlayGround);
        initView();
    }

    public void initView(){
        ArrayList<Card> cards = new ArrayList<>();
        cards = vm.setArr();
    }
}