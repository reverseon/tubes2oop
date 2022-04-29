package com.vtuberwars.model.cardspace;

import com.vtuberwars.model.card.*;
import java.util.*;

public class CardSpace {
    private List<Card> ArrayCard;
    private int MaxCap;
    private int NEff;

    public List<Card> getArrayCard() {
        return ArrayCard;
    }
    public CardSpace(int MaxCap) {
        this.MaxCap = MaxCap;
        this.NEff = 0;
        this.ArrayCard = new ArrayList<Card>();
    }
    public void insertCard(Card newCard) {
        this.ArrayCard.add(newCard);
        this.NEff++;
    }
    public Card getCard(int position) {
        return this.ArrayCard.get(position);
    }
    public void setCard(Card newCard, int position) {
        this.ArrayCard.set(position,newCard);
    }

    public int getNEff() {
        return this.NEff;
    }

    public void setNEff(int NEff) {
        this.NEff = NEff;
    }
    public DrawHolder getTop3Card() {
        Random random = new Random();
        DrawHolder holder = new DrawHolder();
        for(int i = 0;i<this.NEff;i++){
            if (this.NEff <= 3) {
                holder.insertCard(this.ArrayCard.get(i), i);
            } else {
                int randomNum = random.nextInt(this.NEff);
                holder.insertCard(this.ArrayCard.get(randomNum),randomNum);
            }
        }
        return holder;
    }
    public void deleteCard(int Position) {
        this.ArrayCard.remove(Position);
        this.setNEff(this.getNEff()-1);
    }
    public void setNullSpace(int Position){
        this.ArrayCard.set(Position,null);
        this.setNEff(this.getNEff()-1);
    }
    public int getMaxCap(){return this.MaxCap;}

    public void setArrayCard(List<Card> ArrayCard) {
        this.ArrayCard = ArrayCard;
    }

    public void swapPlace(int former, int latter) {
        Card temp = this.ArrayCard.get(former);
        this.ArrayCard.set(former,this.ArrayCard.get(latter));
        this.ArrayCard.set(latter,temp);
    }

//    public Card[] getAllCard() {
//        return this.ArrayCard;
//    }
//    public void setAllCard(Card[] newArrayCard) {
//        this.ArrayCard = newArrayCard;
//    }
// gw ngerasa enakan di get satu" tapi kalo mau di get semua tar ganti aja
}