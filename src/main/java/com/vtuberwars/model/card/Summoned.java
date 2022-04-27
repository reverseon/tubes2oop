package com.vtuberwars.model.card;

import java.util.*;

public interface Summoned {

    public void setBaseAttack(float baseAttack);
    public float getBaseAttack();

    public void setBaseHealth(float baseHealth);
    public float getBaseHealth();

    public float getAttackBonus();
    public float getHealthBonus();

    public void levelUp();
    public void levelDown();

    public int getLevel();

    public int getExp();

    public void takeDamage(float damage);

    public void addSpell(SpellCard s);
    public List<SpellCard> getActiveSpells();
}
