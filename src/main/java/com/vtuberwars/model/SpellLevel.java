package com.vtuberwars.model;

public class SpellLevel extends Card implements UsableCard {

    SpellLevel(int id, String name, String imagePath, String description, int manaCost) {
        super(id, name, imagePath, description, manaCost);
    }

    public void use(Player ourPlayer, int fieldPosition) {

    }
}
