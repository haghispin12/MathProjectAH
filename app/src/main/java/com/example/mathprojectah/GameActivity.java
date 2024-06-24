package com.example.mathprojectah;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.UUID;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class GameActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText gameId;
    Button create;
    Button join;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        auth = FirebaseAuth.getInstance();
        Player p = new Player(auth.getCurrentUser().getEmail(),1);
        gameId = findViewById(R.id.gameId);
        create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UUID uuid = UUID.randomUUID();
                String uuidString = uuid.toString();
                gameId.setText(uuidString);
                game = new Game(uuidString,p);
                FirebaseFirestore.getInstance().collection("gameSessions").document(uuidString).set(game).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(GameActivity.this,"Created Succesfully",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(GameActivity.this,"Creation failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        join = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uuidString = gameId.getText().toString();
                DocumentReference doc = FirebaseFirestore.getInstance().collection("gameSessions").document(uuidString);
                doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            game = documentSnapshot.toObject(Game.class);
                            Player p = new Player(auth.getCurrentUser().getEmail(),2);
                            if(game.getP1().getName().equals(p.getName()))
                                Toast.makeText(GameActivity.this,"Player Already connected",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}