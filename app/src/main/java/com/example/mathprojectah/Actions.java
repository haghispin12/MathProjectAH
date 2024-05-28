package com.example.mathprojectah;

import java.util.Random;

public class Actions {
    Card []cards;
    public Actions(){cards = new Card[6];}

    public Card[] getB(Card []cards){
        Random num = new Random();
        cards = new Card[6];
        for(int i = 0;i< cards.length;i++){cards[i] = new Card();}

        int num1;
        int count = 0;

        for(int j=0;j< cards.length;j++){
            cards[j].setName(j);
            cards[j].setDrawable(R.drawable.card1);
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
            else if(count==2&&j< cards.length) {
                for (; j < cards.length; j++) {
                    cards[j].setDrawable(R.drawable.card1);
                    cards[j].setBomb(false);
                }
            }
            else if(j==6&&count<2)
                j=0;
        }
        this.cards = cards;
        return cards;
    }

    
}
