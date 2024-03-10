package com.example.mathprojectah;

import static android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;

public class User {
    private Uri uri;
    private String name;
    private int score =0;
    private int rating=0;
    private long id;

    public void addScore(int num){
        score+=num;
    }

    public void setRate(int rate){rating=rate;}

    public int getRate(){return rating;}

    public int getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public Uri getUri(){return uri;}

    public void setUri(Uri uri){
        this.uri = uri;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id =id ;
    }

}
