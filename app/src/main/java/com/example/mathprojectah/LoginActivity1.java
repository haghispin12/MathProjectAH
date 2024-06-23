package com.example.mathprojectah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathprojectah.mathexercise.LoginActivity;
import com.example.mathprojectah.mathexercise.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity1 extends AppCompatActivity {

    FirebaseAuth auth;
    EditText nameL;
    EditText passL;
    Button in;
    Button up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        auth = FirebaseAuth.getInstance();
        initView();
    }

    public void initView(){

        FirebaseAuth auth;
        nameL = findViewById(R.id.nameL);
        passL = findViewById(R.id.passL);
        in = findViewById(R.id.in);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = nameL.getText().toString();
                String password = passL.getText().toString();
                signIn(email,password);
            }
        });
        up = findViewById(R.id.up);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = nameL.getText().toString();
                String password = passL.getText().toString();
                signUp(email,password);
            }
        });
    }

    public void signIn(String email,String password){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity1.this,"Connected Succesfully",Toast.LENGTH_SHORT).show();
                    Intent intentL = new Intent(LoginActivity1.this, MainActivity1.class);
                    startActivity(intentL);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity1.this,"Connection Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signUp(String email,String password){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity1.this,"Connected Succesfully",Toast.LENGTH_SHORT).show();
                    Intent intentL = new Intent(LoginActivity1.this, MainActivity1.class);
                    startActivity(intentL);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity1.this,"Registeration Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}