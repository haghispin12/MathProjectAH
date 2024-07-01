package com.example.mathprojectah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
public class PlayGround extends AppCompatActivity {

    FirebaseAuth auth;
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
        SharedPreferences sharedPreferences = getSharedPreferences("getUUid",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        auth = FirebaseAuth.getInstance();
        initView();
    }

    public void initView(){
        int round =0;
        vm = new ViewModel();
        cards = new ArrayList<>();
        cards = vm.setArr();
        Intent intent = getIntent();
        String uuid = intent.getStringExtra("uuid");

        cardsAdapter = new CardsAdapter(cards,new CardsAdapter.OnItenClickListener1() {

            Game game = new Game();
            @Override
            public void onItemclick(Card item) {
                boolean b = check(item,round);
//                game.setP1(FirebaseFirestore.getInstance().collection("gameSessions").document(uuid).get("p1"));
                FirebaseFirestore.getInstance().collection("gameSessions").document(uuid).update("cards",cards).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PlayGround.this,"Eror",Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(PlayGround.this, "Sucsses", Toast.LENGTH_SHORT).show();
                        cardsAdapter.update(FirebaseFirestore.getInstance().collection("gameSessions").document(uuid).get("cards"));
                        cardsAdapter.notifyDataSetChanged();
                    }
                        });
                if(round%2==0) {
                    //open you lose
                }
                else{
                    //continue
                }
            }

            @Override
            public void onItemclick1(Card item){
            boolean b = check(item, round);
            FirebaseFirestore.getInstance().collection("gameSessions").document(uuid).update("cards", cards).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(PlayGround.this, "Eror", Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(PlayGround.this, "Sucsses", Toast.LENGTH_SHORT).show();
                    cardsAdapter.update(cards);
                    cardsAdapter.notifyDataSetChanged();
                }
            });
            if (b) {
                    //thr your opponent loses
            }
            else {
                //continue
            }
            }
        });
        rcPlayGround.setAdapter(cardsAdapter);
        rcPlayGround.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rcPlayGround.setHasFixedSize(true);
    }

    public boolean check(Card item,int round) {
        boolean b = false;
        if (item.getBomb()) {
            item.setDrawable(R.drawable.bomb);
            b=true;
        } else {
            item.setDrawable(R.drawable.panda);
            round++;
        }
        return b;
    }
}