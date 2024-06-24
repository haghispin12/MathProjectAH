package com.example.mathprojectah;

import java.util.UUID;

public class Game {
    public Player p1;
    public Player p2;
    public String uuid;

    public Game(String uuid, Player p){
        this.uuid = uuid;
        this.p1=p;
    }

    public void setp1(Player p){p1=p;}

    public void setP2(Player p2) {this.p2 = p2;}

    public void setUuid(String uuid) {this.uuid = uuid;}

    public Player getP1() {return p1;}

    public Player getP2() {return p2;}

    public String getUuid() {return uuid;}

    public void addP(Player p){p2=p;}

}
