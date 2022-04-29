package com.vtuberwars.model.cardspace;
import java.util.ArrayList;
import com.vtuberwars.model.card.*;

public class DrawHolder {
    private ArrayList<Card> cardHolder;
    private ArrayList<Integer> cardIndex;
    public DrawHolder(){
        this.cardHolder = new ArrayList<>();
        this.cardIndex = new ArrayList<>();
    }

    public void insertCard(Card cardInsert, int cardIndex){
        this.cardHolder.add(cardInsert);
        this.cardIndex.add(cardIndex);
    }

    public Card getCard(int index){
        Card card;
        try{
            card = this.cardHolder.get(index);
        }catch (Exception e){
            card = null;
        }
        return card;
    }
    public Integer getIndex(int index){
        return this.cardIndex.get(index);
    }
}
