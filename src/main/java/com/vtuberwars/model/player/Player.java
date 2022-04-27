package com.vtuberwars.model.player;

import com.vtuberwars.model.card.*;
import com.vtuberwars.model.cardspace.*;
import com.vtuberwars.util.DeckGenerator;

public class Player {
    private String name;
    private float health;
    private int mana;
    private int maxMana;
    private CardSpace cardAtDeck;
    private CardSpace cardAtField;
    private CardSpace cardAtHand;

    public Player(String name) {
        this.name = name;
        this.health = 80;
        this.mana = 1;
        this.maxMana = 1;
        this.cardAtDeck = DeckGenerator.generateDeck(40);
        this.cardAtField = new CardSpace(5);
        this.cardAtHand = new CardSpace(5);
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
        return this.cardAtField.getArrayCard().get(Position);
    }
    public Card getCardAtHand(int Position) {
        return this.cardAtHand.getCard(Position);
    }

    public CardSpace getCardAtHand() {
        return this.cardAtHand;
    }
    public void moveToField(int handPosition, int fieldPosition) {
        Card tmp = this.cardAtHand.getCard(handPosition);
        this.cardAtField.setCard(tmp, fieldPosition);
        this.cardAtHand.deleteCard(handPosition);
    }

//    public int getEmptyHandPos(){
//        for (int i = 0; i < this.cardAtHand.getMaxCap(); i++) {
//            if (this.cardAtHand.getCard(i) == null) {
//                return i;
//            }
//        }
//        return -1;
//    }

//    public void addToHand(Card kartu, int deckPosition) {
//        if(getEmptyHandPos() != -1){
//            this.cardAtHand.setCard(kartu, getEmptyHandPos());
//            this.DeckCardSpace.deleteCard(deckPosition);
//        }
//    }
//
//    public void discardHand(int handPosition) {
//        this.cardAtHand.deleteCard(handPosition);
//    }
//
//    public void discardField(int fieldPosition) {
//        this.cardAtField.deleteCard(fieldPosition);
//    }
//
//    public void pickACardFromDeck(int id) {
//        Card cardTmp = this.DeckCardSpace.getCard(id);
//        addToHand(cardTmp, id);
//    }
//
//    public void attack(Player playerEnemy, int enemyFieldPosition, int playerFieldPosition) {
//        Card playerCard = this.getCardAtField(playerFieldPosition);
//        Card enemyCard = playerEnemy.getCardAtField(enemyFieldPosition);
//        int power = enemyCard.getType() - playerCard.getType();
//        if(power == 2){
//            power = -1;
//        } else if (power == -2) {
//            power = 1;
//        }
//
//        playerCard.setHealth(playerCard.getHealth() - (enemyCard.getAttack() + enemyCard.getAttackBonus())*(2**power));
//        enemyCard.setHealth(enemyCard.getHealth() - (playerCard.getAttack() + playerCard.getAttackBonus())*(2**(-power)));
//    }
}
