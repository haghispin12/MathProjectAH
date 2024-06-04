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
    private CardsAdapter cardsAdapter;
    ArrayList<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        rcPlayGround=findViewById(R.id.rcPlayGround);

        initView();
    }

    public void initView(){
        vm = new ViewModel();
        cards = new ArrayList<>();
        cards = vm.setArr();
        cardsAdapter = new CardsAdapter(cards, new CardsAdapter.OnItenClickListener1() {
            @Override
            public void onItemclick(Card item) {
                if(item.getBomb()){
                    //
                }
                else {
                    cards.get(item.getName()).setDrawable(R.drawable.panda);
                    cardsAdapter.update(cards);
                    cardsAdapter.notifyDataSetChanged();
                }
                Toast.makeText(PlayGround.this,item.getName()+"",Toast.LENGTH_SHORT).show();
            }
        });
        rcPlayGround.setAdapter(cardsAdapter);
        rcPlayGround.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcPlayGround.setHasFixedSize(true);



    }
}