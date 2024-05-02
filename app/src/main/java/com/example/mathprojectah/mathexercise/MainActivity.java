package com.example.mathprojectah.mathexercise;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mathprojectah.R;

public class MainActivity extends AppCompatActivity {

    TextView topText;
    Button rate;
    Button tableButt;
    Button tillButt;
    Button etgarButt;
    TextView firstView;
    Button cafolButt;
    TextView secondView;
    EditText awnser;
    Button cheackBox;
    Button save;
    Button showAll;
    ModelView vm;
    int vu;
    int vl;




    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int myrate=result.getData().getIntExtra("rate",-1);
                    showToast("Thank you for rating us "+myrate);
                    vm.setRate(myrate);
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT);

        vm = new ViewModelProvider(this).get(ModelView.class);

        vm.vSetName(name);
        showToast("Welcome "+name);
        vm.vu.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer vu) {
                firstView.setText(vu+"");
            }
        });

        vm.vl.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer vl) {
                secondView.setText(vl+"");
            }
        });


        topText = findViewById(R.id.topText);
        rate = findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,RateActivity.class);
                    activityResultLauncher.launch(intent1);
                editor.putInt("rate", vm.getRate());
                editor.apply();
            }
        });{

        }
        tableButt = findViewById(R.id.tableButt);
        tableButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.vTable();
                vm.score(5);
            }
        });

        tillButt = findViewById(R.id.tillButt);
        tillButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.vTill20();
                vm.score(10);
            }
        });

        etgarButt = findViewById(R.id.etgarButt);
        etgarButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.vChallange();
                vm.score(20);
            }
        });

        firstView = findViewById(R.id.firstView);

        cafolButt = findViewById(R.id.cafolButt);

        secondView = findViewById(R.id.secondView);

        awnser = findViewById(R.id.awnser);

        cheackBox = findViewById(R.id.checkBox);
        cheackBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = vm.vCheack(awnser.getText().toString());
                if(b)
                    showToast("Correct");
                else
                    showToast("Incorrect");
                topText.setText(vm.vGetScore()+"");
            }
        });

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                trans.add(R.id.frameLayout, new FragmentUser());
                trans.commit();
            }
        });

        showAll = findViewById(R.id.showAll);
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShow = new Intent(MainActivity.this,ShowUsersActivity.class);
                activityResultLauncher.launch(intentShow);

            }
        });
    }
    public void showToast(String str){
        Toast toast = Toast.makeText(this /* MyActivity */, str, Toast.LENGTH_SHORT);
        toast.show();
    }
    @Override



    protected void onStart() {
        super.onStart();
    }
}