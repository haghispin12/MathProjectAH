package com.example.mathprojectah;

public class User {
    private String name;
    private int score =0;


    public void addScore(int num){
        score+=num;
    }

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
