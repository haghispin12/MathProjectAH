package com.example.mathprojectah;

import android.content.Intent;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mathprojectah.mathexercise.LoginActivity;
import com.example.mathprojectah.mathexercise.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class GameActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText gameId;
    Button create;
    Button join;
    Game game;

    public void waitFP (String uuid, Intent intent) {
        FirebaseFirestore.getInstance().collection("gameSessoins").document(uuid).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value.exists())
                    if (value.get("p2", Player.class).getName() != null) {
                        startActivity(intent);
                    }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intentX = new Intent(GameActivity.this, PlayGround.class);
        auth = FirebaseAuth.getInstance();
        Player p = new Player(auth.getCurrentUser().getEmail(),1);
        gameId = findViewById(R.id.gameId);
        create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UUID uuid = UUID.randomUUID();
                String uuidString = uuid.toString();
                Intent intent = new Intent(GameActivity.this, PlayGround.class);
                intent.putExtra("uuid",uuidString);
                startActivity(intent);
                gameId.setText(uuidString);
                game = new Game(uuidString,p);
                FirebaseFirestore.getInstance().collection("gameSessions").document(uuidString).set(game).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(GameActivity.this,"Created Succesfully",Toast.LENGTH_SHORT).show();
                        waitFP(uuidString,intentX);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(GameActivity.this,"Creation Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        join = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uuidString = gameId.getText().toString();
                Intent intent = new Intent(GameActivity.this, PlayGround.class);
                intent.putExtra("uuid", uuidString);
                startActivity(intent);
                Player p = new Player(auth.getCurrentUser().getEmail(), 2);
                FirebaseFirestore.getInstance().collection("gameSessoins").document(uuidString).update("p2", p).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(GameActivity.this, "Added succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(intentX);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(GameActivity.this, "Failed To Add", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

