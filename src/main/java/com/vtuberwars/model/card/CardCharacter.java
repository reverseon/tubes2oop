package com.vtuberwars.model.card;

public class CardCharacter extends Card {
    private Type type;
    private int baseAttack;
    private int baseHealth;
    private int attackBonus;
    private int healthBonus;
    private int exp;
    private int level;
    private boolean statusAttack;

    public CardCharacter(int id, String name, String imagePath, String description, int manaCost, Type type, int baseAttack, int baseHealth) {
        super(id, name, imagePath, description, manaCost);
        this.type = type;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        this.attackBonus = 0;
        this.healthBonus = 0;
        this.exp = 0;
        this.level = 1;
        this.statusAttack = false;
    }

    public int getBaseAttack() {
        return this.baseAttack;
    }
    public int getBaseHealth() {
        return this.baseHealth;
    }
    public int getAttackBonus() {
        return this.attackBonus;
    }
    public int getHealthBonus() {
        return this.healthBonus;
    }
    public int getExp() {
        return this.exp;
    }
    public int getLevel() {
        return this.level;
    }
    public void addExp(int Exp) {

    }
    public void addLevel() {
        this.level++;
    }
}
