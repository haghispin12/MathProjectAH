package com.example.mathprojectah;

import java.util.Random;

public class Actions {

    public Actions(){}

    public Card[] getB(Card []cards){
        Random num = new Random();
        int num1;
        for(int j=0;j<7;j++){
            num1 = num.nextInt(9) + 1;
            if (num1 % 2 == 0) {
                cards[j].setBomb(true);
            }
            else
                cards[j].setBomb(false);
            int count = 0;
            for(int z =0;z<=j;z++){
                if(cards[z].getBomb()){
                    count++;
                }
            }
            if(count==2)
                cards[j].setBomb(false);
            else if(j==6)
                j=0;
        }
        return cards;
    }
}
