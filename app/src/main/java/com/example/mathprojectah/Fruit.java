package com.example.mathprojectah;

import android.graphics.drawable.Drawable;

public class Fruit {
    private String name;
    private int drawable;

    public Fruit(String name, int drawable){
        this.name = name;
        this.drawable = drawable;
    }

    public int getDrawable(){
        return drawable;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
