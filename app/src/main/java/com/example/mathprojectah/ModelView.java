package com.example.mathprojectah;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ModelView extends ViewModel{
    DBHelper dataBase;
    Exercise ex;
    User us;
    Uri uri;
    MutableLiveData<String> name;
    MutableLiveData<Integer> vu;
    MutableLiveData<Integer> vl;
    int lastScore;
    int skbr;
    MutableLiveData<ArrayList<User>> myUsers;



    public ModelView(){
        ex = new Exercise();
        vu = new MutableLiveData<>();
        vl = new MutableLiveData<>();
        myUsers = new MutableLiveData<>();
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

    public int getRate(){
        int rate = us.getRate();
        return rate;
    }

    public void vInsert(Context context,Uri uri){
        dataBase = new DBHelper(context);
        this.uri =uri;
        us.setUri(uri);
        long id = dataBase.insert(us,context);
        us.setId(id);
        ArrayList<User> users = new ArrayList<>();
        users = dataBase.selectAll();
        int n= 0;
    }

    public ArrayList<User> getAll(){
        ArrayList<User> users = new ArrayList<>();
        users = dataBase.selectAll();
        return users;
    }
}
