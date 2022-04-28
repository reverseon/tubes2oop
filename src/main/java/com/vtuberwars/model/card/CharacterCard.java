package com.vtuberwars.model.card;

import java.util.*;
import com.vtuberwars.model.CLI.GameBoard;
import com.vtuberwars.model.cardspace.CardSpace;

public class CharacterCard extends Card {
    private TypeCharacter typeCharacter;
    private float baseAttack;
    private float baseHealth;
    private float attackUp;
    private float healthUp;
    public static Hashtable<TypeCharacter, Integer> characterType = new Hashtable<TypeCharacter, Integer>();
    public static Hashtable<String, TypeCharacter> characterTypeDeckParsing = new Hashtable<String, TypeCharacter>();
    static {
        characterType.put(TypeCharacter.OVERWORLD, 1);
        characterType.put(TypeCharacter.NETHER, 2);
        characterType.put(TypeCharacter.END, 3);

        characterTypeDeckParsing.put("OVERWORLD", TypeCharacter.OVERWORLD);
        characterTypeDeckParsing.put("NETHER", TypeCharacter.NETHER);
        characterTypeDeckParsing.put("END", TypeCharacter.END);
    }

    // private float attackBonus;
    // private float healthBonus;
    // private int exp;
    // private int level;
    // private boolean statusAttack;
    // private ArrayList<Card> effect_list;

    // public CardCharacter(int id, String name, String imagePath, String description, int manaCost, TypeCharacter typeCharacter, float baseAttack, float baseHealth) {
    //     super(id, name, imagePath, description, manaCost, TypeCard.CHARACTER);
    //     this.typeCharacter = typeCharacter;
    //     this.baseAttack = baseAttack;
    //     this.baseHealth = baseHealth;
    //     this.attackBonus = 0;
    //     this.healthBonus = 0;
    //     this.exp = 0;
    //     this.level = 1;
    //     this.statusAttack = false;
    //     this.effect_list = new ArrayList<Card>();
    // }

    public CharacterCard(int id, String name, String imagePath, String description,
                         int manaCost, TypeCharacter typeCharacter, float baseAttack, float baseHealth,
                         float attackUp, float healthUp) {

        super(id, name, imagePath, description, manaCost);
        this.typeCharacter = typeCharacter;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        this.attackUp = attackUp;
        this.healthUp = healthUp;
//        this.attackBonus = 0;
//        this.healthBonus = 0;
//        this.exp = 0;
//        this.level = 1;
//        this.statusAttack = false;
//        this.effect_list = new ArrayList<Card>();
    }

    public static CharacterCard cctorCharacter(CharacterCard CC) {
        CharacterCard newCC = new CharacterCard(CC.getId(), CC.getName(), CC.getImagePath(), CC.getDescription(), CC.getManaCost(), CC.getTypeCharacter(), CC.getBaseAttack(), CC.getBaseHealth(), CC.getAttackUp(), CC.getHealthUp());
        return newCC;
    }
    public void setTypeCharacter(TypeCharacter typeCharacter) {
        this.typeCharacter = typeCharacter;
    }
    public TypeCharacter getTypeCharacter() {
        return this.typeCharacter;
    }
    public float getBaseAttack() {
        return this.baseAttack;
    }
    public float getAttackUp() {
        return this.attackUp;
    }
    public float getBaseHealth() {
        return this.baseHealth;
    }
    public float getHealthUp() {
        return this.attackUp;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Type: " + this.typeCharacter);
        System.out.println("Base Attack: " + this.baseAttack);
        System.out.println("Attak Up : " + this.attackUp);
        System.out.println("Base Health: " + this.baseHealth);
        System.out.println("Health Up: " + this.healthUp);
        System.out.println("");
    }
    public void apply(CardSpace Fields, int position) {
        System.out.println("Masuk");
        if (Fields.getCard(position) == null) {
            SummonedCard SM = new SummonedCard(this);
            Fields.setCard(SM, position);
        }
    }
}
