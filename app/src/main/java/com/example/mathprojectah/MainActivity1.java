package com.example.mathprojectah;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity1 extends AppCompatActivity {

    FirebaseAuth auth;
    ViewModel vm = new ViewModel();
    ImageButton imageButt;
    Button log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        auth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

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

        log = findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intentLog = new Intent(MainActivity1.this, LoginActivity1.class);
                startActivity(intentLog);
                finish();
            }
        });
    }
}