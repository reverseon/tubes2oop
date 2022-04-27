package com.vtuberwars.model.card;

public abstract class SpellCard extends Card implements HaveDuration {
    private TypeSpell typeSpell;
    private int duration;

    public SpellCard(int id, String name, String imagePath, String description, int manaCost, TypeSpell typeSpell, int duration) {
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
}