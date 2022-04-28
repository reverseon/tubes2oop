package com.vtuberwars.model.card;

import com.vtuberwars.model.cardspace.CardSpace;

public abstract class SpellCard extends Card implements HaveDuration {
    private TypeSpell typeSpell;
    private int duration;

    public SpellCard(int id, String name, String imagePath, String description,
                     int manaCost, TypeSpell typeSpell, int duration) {

        super(id, name, imagePath, description, manaCost);
        this.typeSpell = typeSpell;
        this.duration = duration;
    }

    public TypeSpell getTypeSpell() {
        return this.typeSpell;
    }
    public int getDuration() {
        return this.duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: " + this.typeSpell);
        System.out.println("Duration: " + this.duration);
    }
    public void apply(CardSpace Fields, int position) {
        if (Fields.getCard(position) != null) {
            ((SummonedCard) Fields.getCard(position)).addSpell((SpellCard) this);
        }
    }
    public abstract SummonedCard use(SummonedCard SM);
}