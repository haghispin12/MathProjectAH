package com.example.mathprojectah;

import android.content.SharedPreferences;

public class User {
    private String name;
    private int score =0;
    private int rating=0;

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

}
