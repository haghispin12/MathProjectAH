package com.example.mathprojectah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity1 extends AppCompatActivity {

    ViewModel vm = new ViewModel();
    ImageButton imageButt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
    }

    public void initView(){
        imageButt = findViewById(R.id.imageButt);
        imageButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, PlayGround.class);
                startActivity(intent);
            }
        });


    }
}