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

    public Player(String name, int cardNum) {
        try {
            this.name = name;
            this.health = 80;
            this.mana = 1;
            this.maxMana = 1;
            this.cardAtDeck = DeckGenerator.generateDeck(cardNum);
            this.cardAtField = new CardSpace(5);
            this.cardAtHand = new CardSpace(5);
            for (int i = 0; i < 5; i++) {
                this.cardAtField.getArrayCard().add(null);
                this.cardAtHand.getArrayCard().add(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Player(String name, String fileName) {
        try {
            this.name = name;
            this.health = 80;
            this.mana = 1;
            this.maxMana = 1;
            this.cardAtDeck = DeckGenerator.loadDeck(fileName);
            this.cardAtField = new CardSpace(5);
            this.cardAtHand = new CardSpace(5);
            for (int i = 0; i < 5; i++) {
                this.cardAtField.getArrayCard().add(null);
                this.cardAtHand.getArrayCard().add(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return this.name;
    }
    public void setHealth(float health) {
        this.health = health;
    }
    public float getHealth() {
        return this.health;
    }
    public void setMana(int mana) {
        if(mana <= 10) {
            this.mana = mana;
        }else{
            this.mana = 10;
        }
    }
    public int getMana() {
        return this.mana;
    }
    public void setMaxMana(int maxMana) {
        if(maxMana<=10){
            this.maxMana = maxMana;
        }
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
        this.cardAtField.setNEff((this.cardAtField.getNEff()+1));
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
        if(this.cardAtHand.getNEff()==5){
            this.cardAtHand.setNullSpace(0);
        }
//        System.out.println("wakwaw " + this.cardAtHand.getNEff() + " " + getEmptyHandPos());
        this.cardAtHand.setCard(kartu, getEmptyHandPos());
        this.cardAtDeck.deleteCard(deckPosition);
        this.cardAtHand.setNEff(this.cardAtHand.getNEff()+1);
    }

    public void discardHand(int handPosition) {
        this.cardAtHand.setNullSpace(handPosition);
    }

    public void discardField(int fieldPosition) {
        this.cardAtField.setNullSpace(fieldPosition);
    }

    public void pickACardFromDeck(int id) {
        Card cardTmp = this.cardAtDeck.getCard(id);
        addToHand(cardTmp, id);
    }


    public void attack(Player playerEnemy, int enemyFieldPosition, int playerFieldPosition) throws Exception {
        try{
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
        }catch (Exception e){
            throw new RuntimeException("You can't attack an empty space");
        }

    }

//    public void use(SpellCard SC) {
//        SC.use()
//    }
}
