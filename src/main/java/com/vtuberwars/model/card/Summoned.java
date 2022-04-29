package com.vtuberwars.model.card;

import java.util.*;

public interface Summoned {

    public void setAttack(float baseAttack);
    public float getAttack();

    public void setHealth(float baseHealth);
    public float getHealth();



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
