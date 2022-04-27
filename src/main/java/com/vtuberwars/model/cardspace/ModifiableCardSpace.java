package com.vtuberwars.model.cardspace;

import com.vtuberwars.model.card.*;

public class ModifiableCardSpace extends CardSpace {

    public ModifiableCardSpace(int MaxCap) {
        super(MaxCap);
    }



    public void addCard(Card Kartu, int Position) {
        this.setCard(Kartu,Position);
        this.setNEff(this.getNEff()+1);
    }
}
