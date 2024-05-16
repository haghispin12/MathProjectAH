package com.example.mathprojectah;

import java.util.Random;

public class Actions {

    public Actions(){}

    public Card[] getB(Card []cards){
        Random num = new Random();
        int num1;
        int count = 0;
        for(int j=0;j< cards.length;j++){
            if(count<2) {
                num1 = num.nextInt(9) + 1;
                if (num1 % 2 == 0) {
                    cards[j].setBomb(true);
                } else
                    cards[j].setBomb(false);
                for (int z = 0; z <= j; z++) {
                    if (cards[z].getBomb()) {
                        count++;
                    }
                }
            }
            if(count==2&&j< cards.length) {
                for (; j < cards.length; j++) {
                    cards[j].setBomb(false);
                }
            }
            if(j==6&&count<2)
                j=0;
        }
        return cards;
    }


}
