package com.example.mathprojectah;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModelView extends ViewModel{
    Exercise ex;
    User us;
    MutableLiveData<String> name;
    MutableLiveData<Integer> vu;
    MutableLiveData<Integer> vl;
    int lastScore;
    int skbr;


    public ModelView(){
        ex = new Exercise();
        vu = new MutableLiveData<>();
        vl = new MutableLiveData<>();
        name = new MutableLiveData<>();
        us = new User();
    }

    public void vChallange(){
        ex.challenge();
        vu.setValue(ex.getU());
        vl.setValue(ex.getL());
    }
    public void vTill20(){
        ex.till20();
        vu.setValue(ex.getU());
        vl.setValue(ex.getL());
    }
    public void vTable(){
        ex.table();
        vu.setValue(ex.getU());
        vl.setValue(ex.getL());
    }

    public int vGetScore(){
        return us.getScore();
    }

    public void score(int num){lastScore = num;}

    public boolean vCheack(String s){
        boolean b = ex.check(s);
        if(b)
            us.addScore(lastScore);
        return b;
    }

    public void setName(String name){us.setName(name);}

    public String getName(){return us.getName();}

    public void rate(int skBar){
        skbr = skBar;
    }

    public int getSkbr(){return skbr;}

    public int vGetU(){return ex.getU();}
    public int vGetL(){return ex.getL();}

    public void vSetU(int u){ex.setU(u);}
    public void vSetL(int l){ex.setL(l);}
    public void vSetName(String name){
        us.setName(name);
    }
    public void setRate(int rate){us.setRate(rate);}
    public int getRate(){return us.getRate();}

}
