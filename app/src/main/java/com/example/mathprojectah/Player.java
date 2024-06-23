package com.example.mathprojectah;

public class Player {
    String name;
    String pass;
    int round;

    public Player(String name,String pass,int round){
        this.name = name;
        this.pass=pass;
        this.round = round;
    }

    public void setName(String name){this.name=name;}

    public void setPass(String pass){this.pass=pass;}

    public void setRound(int round){this.round=round;}

    public String getName(){return name;}

    public String getPass(){return pass;}

    public int getRound(){return round;}
}
