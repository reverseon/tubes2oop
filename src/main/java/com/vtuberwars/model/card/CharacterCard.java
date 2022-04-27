package com.vtuberwars.model.card;

import java.util.*;
import com.vtuberwars.model.CLI.GameBoard;

public class CharacterCard extends Card {
    // private TypeCharacter typeCharacter;
    private int typeCharacter;
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

    public CharacterCard(int id, String name, String imagePath, String description, int manaCost, int typeCharacter, float baseAttack, float baseHealth) {
        super(id, name, imagePath, description, manaCost);
        this.typeCharacter = typeCharacter;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
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
//    public float getAttackBonus() {
//        return this.attackBonus;
//    }
//    public void setAttackBonus(float AttackBonus) {
//        this.attackBonus = AttackBonus;
//    }
//    public float getHealthBonus() {
//        return this.healthBonus;
//    }
//    public void setHealthBonus(float healthBonus) {
//        this.healthBonus = healthBonus;
//    }
//    public int getExp() {
//        return this.exp;
//    }
//    public int getLevel() {
//        return this.level;
//    }
//    public boolean getStatusAttack() {
//        return this.statusAttack;
//    }
//    public boolean isHaveSwapSpell() {
//        for (int i = 0; i < this.effect_list.size(); i++) {
//            if (this.effect_list.get(i).getTypeCard() == TypeCard.SWAP) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public void addEffect(Card kartu) {
//        this.effect_list.add(kartu);
//    }
//    public void resetExp() {
//        this.exp = 0;
//    }
//    public void addExp(int Exp) {
//        this.exp+=Exp;
//    }
//    public void setLevel(int level) {
//        this.level = level;
//    }
}
