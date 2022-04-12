package com.vtuberwars.model.player;

import com.vtuberwars.model.card.*;
import com.vtuberwars.model.cardspace.*;

public class Player {
    private String name;
    private float health;
    private int mana;
    private int maxMana;
    private DeckCardSpace cardAtDeck;
    private ModifiableCardSpace cardAtField;
    private ModifiableCardSpace cardAtHand;

    public Player(String name) {
        this.name = name;
        this.health = 80;
        this.mana = 1;
        this.maxMana = 1;
        this.cardAtDeck = new DeckCardSpace((int)(Math.random() * ((60 - 40) + 1)+ 40));
        this.cardAtField = new ModifiableCardSpace(5);
        this.cardAtHand = new ModifiableCardSpace(5);
    }

    public String getName() {
        return this.name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public float getHealth() {
        return this.health;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getMana() {
        return this.mana;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public int getMaxMana() {
        return this.maxMana;
    }
    public Card getCardAtDeck(int Position) {
        return this.cardAtDeck.getCard(Position);
    }
    public Card getCardAtField(int Position) {
        return this.cardAtField.getCard(Position);
    }
    public Card getCardAtHand(int Position) {
        return this.cardAtHand.getCard(Position);
    }

    public void moveToField(int handPosition, int fieldPosition) {

    }

    public void addToHand(int handPosition) {

    }

    public void discardHand(int handPosition) {

    }

    public void discardField(int fieldPosition) {

    }

    public void pickACardFromDeck(int id) {

    }

    public void attack(Player playerEnemy, int enemyFieldPosition) {

    }
}
