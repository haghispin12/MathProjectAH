package com.example.mathprojectah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;


public class FragmentUser extends Fragment {

    EditText namev;
    TextView scorev;
    TextView ratev;
    Button imageButt;
    ImageView image;
    Button addUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        namev=view.findViewById(R.id.namev);

        scorev=view.findViewById(R.id.scorev);

        ratev=view.findViewById(R.id.ratev);

        imageButt=view.findViewById(R.id.imagebut);
        imageButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        image=view.findViewById(R.id.imagev);

        addUser=view.findViewById(R.id.userBut);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return view;
    }
}