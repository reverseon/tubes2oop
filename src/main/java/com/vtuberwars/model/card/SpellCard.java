package com.vtuberwars.model.card;

public class SpellCard extends Card {
    private TypeSpell typeSpell;
    private int duration;

    public SpellCard(int id, String name, String imagePath, String description, int manaCost, TypeSpell typeSpell, int duration) {
        super(id, name, imagePath, description, manaCost);
        this.typeSpell = typeSpell;
        this.duration = duration;
    }

    public getTypeSpell() {
        return this.typeSpell;
    }
}