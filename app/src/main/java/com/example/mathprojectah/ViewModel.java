package com.example.mathprojectah;

import java.util.ArrayList;

public class ViewModel extends androidx.lifecycle.ViewModel {
    Actions getCB;
    Card []cards;

    public ViewModel(){
        getCB = new Actions();
        cards=new Card[6];
    }

    public ArrayList<Card> setArr(){
        ArrayList<Card> card = new ArrayList<>();
        cards = getCB.getB(cards);
        for(int i=0;i<cards.length;i++){
            card.add(cards[i]);
        }
        return card;
    }

}
