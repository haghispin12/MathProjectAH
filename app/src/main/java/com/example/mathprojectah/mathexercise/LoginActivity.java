package com.example.mathprojectah.mathexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mathprojectah.R;


public class LoginActivity extends AppCompatActivity {
    EditText name;
    Button submit;
    ModelView vm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();


        ///

    }



    private void initView() {
        name = findViewById(R.id.name);
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("name",name.getText().toString());
                startActivity(intent);
                finish();

                editor.putString("saved",name.getText().toString());
                editor.apply();
            }
        });
        name.setText(sharedPreferences.getString("saved",""));
    }
}