package com.vtuberwars.model.card;

import java.util.*;

public interface Summoned {

    public float getAttack();
    public float getHealth();

    public void setAttackBonus(float attackBonus);
    public float getAttackBonus();

    public void setHealthBonus(float healthBonus);
    public float getHealthBonus();

    public void levelUp();
    public int getLevel();

    public int getExp();

    public void addSpell(SpellCard s);
    public List<SpellCard> getActiveSpells();
}
