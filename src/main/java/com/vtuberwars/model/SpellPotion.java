package com.vtuberwars.model;

public class SpellPotion extends Card implements HaveDuration, UsableCard {
    int duration;
    boolean active;
    float healthMod;
    float attackMod;

    SpellPotion(int id, String name, String imagePath, String description, int manaCost, int duration, float healthMod, float attackMod) {
        super(id, name, imagePath, description, manaCost);
        this.duration = duration;
        this.active = false;
        this.healthMod = healthMod;
        this.attackMod = attackMod;
    }

    public void reduceDuration() {
        this.duration--;
    }
    public int getDuration() {
        return this.duration;
    }
    public void activedSpell() {
        this.active = true;
    }
    public void deactivedSpell() {
        this.active = false;
    }
    public boolean isActive() {
        return this.active;
    }
    public void use(Player ourPlayer, int fieldPosition) {

    }
}
