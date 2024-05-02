package com.example.mathprojectah.mathexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mathprojectah.R;

import java.util.ArrayList;

public class ShowUsersActivity extends AppCompatActivity {

    private RecyclerView rcShowFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        rcShowFruits = findViewById(R.id.rcShowUsers);
        initView();
    }

    public void initView(){
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Orange",R.drawable.orange));
        fruits.add(new Fruit("banana",R.drawable.banana));
        fruits.add(new Fruit("apple",R.drawable.apple));
        fruits.add(new Fruit("grapes",R.drawable.grapes));
        fruits.add(new Fruit("lemon",R.drawable.lemon));
        fruits.add(new Fruit("fruits",R.drawable.fru));

        FruitAdapter fruitAdapter = new FruitAdapter(fruits, new FruitAdapter.OnItenClickListener1() {
            @Override
            public void onItemclick(Fruit item) {
                Toast.makeText(ShowUsersActivity.this,item.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        rcShowFruits.setLayoutManager(new LinearLayoutManager(this));
        rcShowFruits.setAdapter(fruitAdapter);
        rcShowFruits.setHasFixedSize(true);
    }

}