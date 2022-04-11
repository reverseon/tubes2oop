package com.vtuberwars.model.cardspace;

import com.vtuberwars.model.card.*;

public class DeckCardSpace extends CardSpace {

    public DeckCardSpace(int MaxCap) {
        super(MaxCap);
    }

    public Card[] getTop3Card() {
        Card[] result = new Card[3];

        return result;
    }

    public void deleteCard(int id) {

    }
}
