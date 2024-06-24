package com.example.mathprojectah;

public class Player {
    String name;
    int nick;
    int round;

    public Player(String name,int num){
        this.name = name;
        this.nick = num;
    }

    public void setName(String name){this.name=name;}

    public void setRound(int round){this.round=round;}

    public void setNick(int nick) {this.nick = nick;}

    public String getName(){return name;}

    public  int getNick(){return nick;}

    public int getRound(){return round;}
}
