package com.example.mathprojectah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mathprojectah.R;

import java.util.ArrayList;
public class PlayGround extends AppCompatActivity {

    ViewModel vm;
    private RecyclerView rcPlayGround;
    ImageButton imbt;
    ArrayList<Card> cards;
    CardsAdapter cardsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        rcPlayGround=findViewById(R.id.rcPlayGround);

        initView();
    }

    public void initView(){
        int round =0;
        vm = new ViewModel();
        cards = new ArrayList<>();
        cards = vm.setArr();
        cardsAdapter = new CardsAdapter(cards,new CardsAdapter.OnItenClickListener1() {
            @Override
            public void onItemclick(Card item) {
                check(item,round);
                cardsAdapter.update(cards);
                cardsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemclick1(Card item) {
                check(item,round);
                cardsAdapter.update(cards);
                cardsAdapter.notifyDataSetChanged();
            }
        });
        rcPlayGround.setAdapter(cardsAdapter);
        rcPlayGround.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcPlayGround.setHasFixedSize(true);



    }

    public void check(Card item,int round) {
        if (item.getBomb()) {
            item.setDrawable(R.drawable.bomb);
        } else {
            item.setDrawable(R.drawable.panda);
            round++;
        }
    }
}