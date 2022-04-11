package com.vtuberwars.model;

public class SpellMorph extends Card implements UsableCard {
    private int targetId;

    SpellMorph(int id, String name, String imagePath, String description, int manaCost, int targetId) {
        super(id, name, imagePath, description, manaCost);
        this.targetId = targetId;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public void use(Player ourPlayer, int fieldPosition) {

    }
}
