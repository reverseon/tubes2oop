package com.vtuberwars.model.card;

import com.vtuberwars.model.cardspace.CardSpace;

public abstract class SpellCard extends Card implements HaveDuration, Useable {
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
//        System.out.println("Type: " + this.typeSpell);
//        System.out.println("Duration: " + this.duration);
    }
    public void apply(CardSpace Fields, int position) throws RuntimeException {
        if (Fields.getCard(position) != null) {
            SummonedCard SM = ((SummonedCard) Fields.getCard(position));
            if (this.getTypeSpell() == TypeSpell.LEVEL) {
                int level = SM.getLevel();
                int manaCost = (int) Math.ceil((level) / 2.0);
                super.setManaCost(manaCost);
                if (((SummonedCard) Fields.getCard(position)).getTotalHp() <= 0) {
                    Fields.setNullSpace(position);
                }
            }
            Fields.setCard(this.use(SM), position);
        } else {
            throw new RuntimeException("You can't use spell on empty field");
        }
    }
    public abstract SummonedCard use(SummonedCard SM);
    public abstract String getDrawDescription();
    public abstract String getHandDescription();
}