package com.example.mathprojectah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mathprojectah.R;

import java.util.ArrayList;
public class PlayGround extends AppCompatActivity {
    ViewModel vm;
    private RecyclerView rcPlayGround;
    ImageButton imbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        rcPlayGround=findViewById(R.id.rcPlayGround);

        initView();
    }

    public void initView(){
        vm = new ViewModel();
        ArrayList<Card> cards = new ArrayList<>();
        cards = vm.setArr();
        CardsAdapter cardsAdapter = new CardsAdapter(cards, new CardsAdapter.OnItenClickListener1() {
            @Override
            public void onItemclick(Card item) {
                if(item.getBomb()){
                    int n = 10;
                    item.setDrawable(R.drawable.bomb);
                    finish();
                }
                else
                    //item.setDrawable(R.drawable.fru);
                Toast.makeText(PlayGround.this,item.getName()+"",Toast.LENGTH_SHORT).show();
            }
        });
        rcPlayGround.setAdapter(cardsAdapter);
        rcPlayGround.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcPlayGround.setHasFixedSize(true);



    }
}