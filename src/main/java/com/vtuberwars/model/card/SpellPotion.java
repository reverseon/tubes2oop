package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellPotion extends SpellCard  {
    private float healthMod;
    private float attackMod;

    public SpellPotion(int id, String name, String imagePath, String description, int manaCost,
                       int duration, float healthMod, float attackMod) {

        super(id, name, imagePath, description, manaCost, TypeSpell.POTION, duration);
        this.healthMod = healthMod;
        this.attackMod = attackMod;
    }

    public static SpellPotion cctorPotion(SpellPotion potion) {
        return new SpellPotion(potion.getId(), potion.getName(), potion.getImagePath(),
                potion.getDescription(), potion.getManaCost(), potion.getDuration(), potion.getHealthMod(),
                potion.getAttackMod());
    }

    public void setHealthMod(float healthMod) {
        this.healthMod = healthMod;
    }
    public float getHealthMod() {
        return this.healthMod;
    }
    public void setAttackMod(float attackMod) {
        this.attackMod = attackMod;
    }
    public float getAttackMod() {
        return attackMod;
    }

    public SummonedCard use(SummonedCard SM) {
        SM.addSpell(this);
        return SM;
    }
    public void printInfo() {
        super.printInfo();
        System.out.println("Health Mod: " + this.healthMod);
        System.out.println("Attack Mod: " + this.attackMod);
        System.out.println("");
    }
}
