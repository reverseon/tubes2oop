package com.vtuberwars.model.cardspace;

import com.vtuberwars.model.card.*;

public class ModifiableCardSpace extends CardSpace {

    public ModifiableCardSpace(int MaxCap) {
        super(MaxCap);
    }

    public void deleteCard(int Position) {
        this.ArrayCard[Position] = null;
    }

    public void addCard(Card Kartu, int Position) {
        this.ArrayCard[Position] = Kartu;
    }
}
