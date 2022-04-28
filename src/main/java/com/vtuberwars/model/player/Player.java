package com.vtuberwars.model.player;

import com.vtuberwars.model.card.*;
import com.vtuberwars.model.cardspace.*;
import com.vtuberwars.util.DeckGenerator;

import java.util.List;

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
        for (int i = 0; i < 5; i++) {
            this.cardAtField.getArrayCard().add(null);
            this.cardAtHand.getArrayCard().add(null);
        }
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
    public Card getACardAtDeck(int Position) {
        return this.cardAtDeck.getCard(Position);
    }
    public CardSpace getCardsAtDeck() { return this.cardAtDeck; }
    public Card getACardAtField(int Position) {
        return this.cardAtField.getArrayCard().get(Position);
    }
    public CardSpace getCardsAtField() { return this.cardAtField; }
    public Card getACardAtHand(int Position) {
        return this.cardAtHand.getCard(Position);
    }
    public CardSpace getCardsAtHand() { return this.cardAtHand; }

    public CardSpace getCardAtHand() {
        return this.cardAtHand;
    }
    public void moveToField(int handPosition, int fieldPosition) {
        Card tmp = this.cardAtHand.getCard(handPosition);
        this.cardAtField.setCard(tmp, fieldPosition);
        this.cardAtHand.deleteCard(handPosition);
    }

    public int getEmptyHandPos(){
        for (int i = 0; i < this.cardAtHand.getMaxCap(); i++) {
            if (this.cardAtHand.getCard(i) == null) {
                return i;
            }
        }
        return -1;
    }

    public void addToHand(Card kartu, int deckPosition) {
        if(getEmptyHandPos() != -1){
            this.cardAtHand.setCard(kartu, getEmptyHandPos());
            this.cardAtDeck.deleteCard(deckPosition);
        }
    }

    public void discardHand(int handPosition) {
        this.cardAtHand.deleteCard(handPosition);
    }

    public void discardField(int fieldPosition) {
        this.cardAtField.deleteCard(fieldPosition);
    }

    public void pickACardFromDeck(int id) {
        Card cardTmp = this.cardAtDeck.getCard(id);
        addToHand(cardTmp, id);
    }


    public void attack(Player playerEnemy, int enemyFieldPosition, int playerFieldPosition) {
        SummonedCard playerCard = (SummonedCard) this.getACardAtField(playerFieldPosition);
        SummonedCard enemyCard = (SummonedCard) playerEnemy.getACardAtField(enemyFieldPosition);
        int power = CharacterCard.characterType.get(enemyCard.getTypeCharacter()) - CharacterCard.characterType.get(playerCard.getTypeCharacter());
        if(power == 2){
            power = -1;
        } else if (power == -2) {
            power = 1;
        }

        playerCard.takeDamage(enemyCard.getTotalAttack()* (float)Math.pow(2,power));
        enemyCard.takeDamage(playerCard.getTotalAttack()* (float)Math.pow(2,(-power)));
    }

//    public void use(SpellCard SC) {
//        SC.use()
//    }
}
