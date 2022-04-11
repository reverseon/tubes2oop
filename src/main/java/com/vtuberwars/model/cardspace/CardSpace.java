package com.vtuberwars.model.cardspace;

import com.vtuberwars.model.card.*;

public class CardSpace {
    private Card[] ArrayCard;
    private int MaxCap;

    public CardSpace(int MaxCap) {
        this.MaxCap = MaxCap;
        this.ArrayCard = new Card[this.MaxCap];
    }
    public Card getCard(int position) {
        return this.ArrayCard[position];
    }
    public void setCard(Card newCard, int position) {
        this.ArrayCard[position] = newCard;
    }
//    public Card[] getAllCard() {
//        return this.ArrayCard;
//    }
//    public void setAllCard(Card[] newArrayCard) {
//        this.ArrayCard = newArrayCard;
//    }
// gw ngerasa enakan di get satu" tapi kalo mau di get semua tar ganti aja
}
