package com.vtuberwars.model.card;

import java.util.ArrayList;
import java.util.List;

public class SummonedCard implements Summoned {
    private CharacterCard characterCard;
    private float attack;
    private float health;
    private float attackBonus;
    private float healthBonus;
    private int level;
    private int exp;
    private List<SpellCard> activeSpells;

    public SummonedCard(CharacterCard characterCard) {
        this.characterCard = characterCard;
        this.attack = characterCard.getBaseAttack();
        this.health = characterCard.getBaseHealth();
        this.attackBonus = 0;
        this.healthBonus = 0;
        this.level = 0;
        this.exp = 0;
        this.activeSpells = new ArrayList<>();
    }

    public float getAttack() {
        return this.attack;
    }
    public float getHealth() {
        return this.health;
    }
    public void setAttackBonus(float AttackBonus) {
        this.attackBonus = AttackBonus;
    }
    public float getAttackBonus() {
        return this.attackBonus;
    }
    public void setHealthBonus(float healthBonus) {
        this.healthBonus = healthBonus;
    }
    public float getHealthBonus() {
        return this.healthBonus;
    }
    public void addExp(int exp) {
        this.exp += exp;

        while (this.exp >= (this.level*2)-1) {
            this.exp -= (this.level*2)-1;
            this.levelUp();
        }
    }
    public int getExp() {
        return this.exp;
    }
    public void levelUp() {
        this.attack += this.characterCard.getAttackUp();
        this.health += this.characterCard.getHealthUp();
        this.level++;
    }

    public int getLevel() {
        return this.level;
    }
    public void addSpell(SpellCard SC) {
        for (SpellCard Spell : this.activeSpells) {
            if ((Spell.getTypeSpell() == TypeSpell.SWAP || Spell.getTypeSpell() == TypeSpell.LEVEL)
                && SC.getId() == Spell.getId()) {
                Spell.setDuration(Spell.getDuration()+ SC.getDuration());
                return;
            }
        }
        activeSpells.add(SC);
    }
    public List<SpellCard> getActiveSpells() {
        return this.activeSpells;
    }

    public void attack(SummonedCard enemy){
        enemy.takeDamage(this.getTotalAttack());
        this.takeDamage(enemy.getTotalAttack());
    }
}
