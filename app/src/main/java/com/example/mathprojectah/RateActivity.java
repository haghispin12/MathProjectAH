package com.example.mathprojectah;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class RateActivity extends FragmentActivity {

    SeekBar skBar;
    Button save;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        skBar = findViewById(R.id.skbar);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent();
                inn.putExtra("rate",skBar.getProgress());
                setResult(RESULT_OK,inn);
                finish();
            }
        });

    }
}