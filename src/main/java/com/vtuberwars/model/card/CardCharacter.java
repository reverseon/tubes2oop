package com.vtuberwars.model.card;

import java.util.ArrayList;

public class CardCharacter extends Card {
    private TypeCharacter typeCharacter;
    private float baseAttack;
    private float baseHealth;
    private float attackBonus;
    private float healthBonus;
    private int exp;
    private int level;
    private boolean statusAttack;
    private ArrayList<Card> effect_list;

    public CardCharacter(int id, String name, String imagePath, String description, int manaCost, TypeCharacter typeCharacter, float baseAttack, float baseHealth) {
        super(id, name, imagePath, description, manaCost, TypeCard.CHARACTER);
        this.typeCharacter = typeCharacter;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        this.attackBonus = 0;
        this.healthBonus = 0;
        this.exp = 0;
        this.level = 1;
        this.statusAttack = false;
        this.effect_list = new ArrayList<Card>();
    }

    public float getBaseAttack() {
        return this.baseAttack;
    }
    public void setBaseAttack(float baseAttack) {
        this.baseAttack = baseAttack;
    }
    public float getBaseHealth() {
        return this.baseHealth;
    }
    public void setBaseHealth(float baseHealth) {
        this.baseHealth = baseHealth;
    }
    public float getAttackBonus() {
        return this.attackBonus;
    }
    public void setAttackBonus(float AttackBonus) {
        this.attackBonus = AttackBonus;
    }
    public float getHealthBonus() {
        return this.healthBonus;
    }
    public void setHealthBonus(float healthBonus) {
        this.healthBonus = healthBonus;
    }
    public int getExp() {
        return this.exp;
    }
    public int getLevel() {
        return this.level;
    }
    public boolean getStatusAttack() {
        return this.statusAttack;
    }
    public boolean isHaveSwapSpell() {
        for (int i = 0; i < this.effect_list.size(); i++) {
            if (this.effect_list.get(i).getTypeCard() == TypeCard.SWAP) {
                return true;
            }
        }
        return false;
    }
    public void addEffect(Card kartu) {
        this.effect_list.add(kartu);
    }
    public void resetExp() {
        this.exp = 0;
    }
    public void addExp(int Exp) {

    }
    public void setLevel(int level) {
        this.level = level;
    }
}
