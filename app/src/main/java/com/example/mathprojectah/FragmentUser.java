package com.example.mathprojectah;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.CONTEXT_IGNORE_SECURITY;
import static android.content.Context.CONTEXT_INCLUDE_CODE;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

import javax.xml.transform.Result;


public class FragmentUser extends Fragment {

    EditText nameV;
    TextView scoreV;
    TextView rateV;
    Button imageButt;
    ImageView image;
    Button addUser;
    ModelView vm;
    Uri uri;

    ActivityResultLauncher<Intent> startCamera = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()== RESULT_OK){
                        image.setImageURI(uri);
                    }
                }
            }
    );

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new ViewModelProvider(requireActivity()).get(ModelView.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        String name = vm.getName();
        int score = vm.vGetScore();
        int rate = vm.getRate();

        nameV=view.findViewById(R.id.namev);
        nameV.setText(name);

        scoreV=view.findViewById(R.id.scorev);
        scoreV.setText("score:"+score);

        rateV=view.findViewById(R.id.ratev);
        rateV.setText("rate:"+rate);

        image=view.findViewById(R.id.imagev);

        imageButt=view.findViewById(R.id.imagebut);
        imageButt.setOnClickListener(v -> {

            ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE,"NewPicture");
                values.put(MediaStore.Images.Media.DESCRIPTION,"From Camera");
                uri = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startCamera.launch(cameraIntent);

        });

        addUser=view.findViewById(R.id.userBut);
        addUser.setOnClickListener(v -> {
            vm.vInsert(requireActivity());
        });

        return view;
    }
}
