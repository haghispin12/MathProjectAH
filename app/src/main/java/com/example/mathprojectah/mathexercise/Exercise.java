package com.example.mathprojectah.mathexercise;

import java.util.Random;

public class Exercise {
    private int u;
    private int l;
    private int awnser;

    public Exercise (){}

    public void challenge(){
        Random num = new Random();
        u = num.nextInt(9)+1;
        l = num.nextInt(90)+10;
        awnser = u*l;
    }

    public void till20(){
        Random num = new Random();
        u = num.nextInt(9)+1;
        l = num.nextInt(10)+10;
        awnser = u*l;

    }

    public void table(){
        Random num = new Random();
        u = num.nextInt(9)+1;
        l = num.nextInt(9)+10;
        awnser = u*l;
    }

    public boolean check(String s){
        int ans = Integer.valueOf(s);
        if(ans == awnser) {
            return true;
        }
        else
            return false;
    }

    public int getU(){
        return u;
    }
    public int getL(){
        return l;
    }

    public void setU(int num){
        this.u = num;
    }

    public void setL(int num){
        this.l = num;
    }

}
