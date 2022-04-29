package com.vtuberwars.model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SummonedCard extends CharacterCard implements Summoned {
    private float attack;
    private float health;
    private int level;
    private int exp;
    private List<SpellCard> activeSpells;

    public SummonedCard(int id, String name, String imagePath, String description,
                        int manaCost, TypeCharacter typeCharacter, float baseAttack, float baseHealth,
                        float attackUp, float healthUp) {

        super(id, name, imagePath, description, manaCost,
                typeCharacter, baseAttack, baseHealth, attackUp, healthUp);

        this.attack = super.getBaseAttack();
        this.health = super.getBaseHealth();
        this.level = 1;
        this.exp = 0;
        this.activeSpells = new ArrayList<>();
    }
    public SummonedCard (CharacterCard characterCard) {
        super((characterCard.getId()) , characterCard.getName(),
                characterCard.getImagePath(), characterCard.getDescription(),
                characterCard.getManaCost(), characterCard.getTypeCharacter(),
                characterCard.getBaseAttack(), characterCard.getBaseHealth(),
                characterCard.getAttackUp(), characterCard.getHealthUp());

        this.attack = super.getBaseAttack();
        this.health = super.getBaseHealth();
        this.level = 1;
        this.exp = 0;
        this.activeSpells = new ArrayList<>();
    }
    public float getTotalAttack(){
        return this.attack + getAttackBonus();
    }
    public float getTotalHp() {
        return this.health + getHealthBonus();
    }
    public void setAttack(float baseAttack) {
        this.attack = baseAttack;
    }
    public float getAttack() {
        return this.attack;
    }
    public void setHealth(float baseHealth) {
        this.health = baseHealth;
    }
    public float getHealth() {
        return this.health;
    }

    public float getAttackBonus() {
        return (float) this.activeSpells.stream().filter(sc -> sc.getTypeSpell() == TypeSpell.POTION).
                map(sc -> (SpellPotion) sc).mapToDouble(sc -> sc.getAttackMod()).sum();
    }

    public float getHealthBonus() {
        return (float) this.activeSpells.stream().filter(sc -> sc.getTypeSpell() == TypeSpell.POTION).
                map(sc -> (SpellPotion) sc).mapToDouble(sc -> sc.getHealthMod()).sum();
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
        if (this.level < 10) {
            this.attack += super.getAttackUp();
            this.health += super.getHealthUp();
            this.level++;
        }  else {
            this.health = super.getBaseHealth() + 9 * super.getHealthUp();
        }
    }
    public void levelDown() {
        if (this.level > 1) {
            this.attack -= super.getAttackUp();
            this.health -= super.getHealthUp();
            this.level--;
        }
    }
    public int getLevel() {
        return this.level;
    }

    public void takeDamage(float damage) {
        List<SpellCard> temp =
                this.activeSpells.stream().
                filter(SpellPotion.class::isInstance).
                map(SpellPotion.class::cast).collect(Collectors.toList());
        if (damage > 0) {
            for (SpellCard SC : temp) {
                if (SC.getTypeSpell() == TypeSpell.POTION) {
                    float healthPoint = ((SpellPotion) SC).getHealthMod();
                    ((SpellPotion) SC).setHealthMod(
                            Math.max(healthPoint - damage, 0));
                    damage = Math.max(damage - healthPoint, 0);
                }
                if (damage == 0) {
                    return;
                }
            }
        }
        if (damage > 0) {
            this.health -= damage;
        }
    }
    public void addSpell(SpellCard SC) {

        this.activeSpells.add(0, SC);

    }
    public void reduceSpell() {
        for (int i = 0; i < this.activeSpells.size(); i++) {
            SpellCard SC = this.activeSpells.get(i);
            if (SC.getDuration() == 1) {
                this.activeSpells.remove(SC);
                if (SC.getTypeSpell() == TypeSpell.SWAP) {
                    swapStat();
                }
            }
            SC.setDuration(SC.getDuration()-1);
        }
    }
    public List<SpellCard> getActiveSpells() {
        return this.activeSpells;
    }

    public void attack(SummonedCard enemy){
        enemy.takeDamage(this.getTotalAttack());
        this.takeDamage(enemy.getTotalAttack());
    }

    public void swapStat() {
        for (SpellCard SP : this.activeSpells) {
            if (SP.getTypeSpell() == TypeSpell.POTION) {
                float tempHealth = ((SpellPotion) SP).getHealthMod();
                float tempAttack = ((SpellPotion) SP).getAttackMod();
                ((SpellPotion) SP).setHealthMod(tempAttack);
                ((SpellPotion) SP).setAttackMod(tempHealth);
            }
        }

        float tempAttack = getAttack();
        float tempHealth = getHealth();
        this.setAttack(tempHealth);
        this.setHealth(tempAttack);
    }

    public void printInfo() {
        super.printInfo();
//        System.out.println("Status Summoned Card : ");
//        System.out.println("Attack: " + this.attack);
//        System.out.println("Bonus Attack: " + this.getAttackBonus());
//        System.out.println("Total Attack: " + this.getTotalAttack());
//        System.out.println("Health: " + this.health);
//        System.out.println("Bonus Health: " + this.getHealth());
//        System.out.println("Total Health: " + this.getTotalHp());
//        System.out.println("Level: " + this.level);
//        System.out.printf("Exp: %d/%d\n", this.exp, this.level*2 +1);
//        if (this.activeSpells.size() > 0) {
//            for (SpellCard SC : this.activeSpells) {
//                System.out.print("Spell :");
//                SC.printInfo();
//            }
//        } else {
//            System.out.println("Tidak memiliki Spell apapun");
//        }

    }
    public String getFieldDescription(){
        String msg = "Base ATK : " + this.attack;
        msg += "\n";
        msg += "Base HP : " + this.health;
        msg += "\n";
        msg += "Bonus ATK : " + this.getAttackBonus();
        msg += "\n";
        msg += "Bonus HP : " + this.getHealthBonus();
        msg += "\n";
        msg += "Level : " + this.getLevel();
        msg += "\n";
        msg += "EXP : " + this.getExp() + "/" + (this.getLevel()*2-1);
        msg += "\n";
        if (this.activeSpells.stream().
                filter(SC -> SC.getTypeSpell() == TypeSpell.SWAP).
                findFirst().orElse(null) != null) {
            msg += "A <-> B";
        }
        return msg;
    }
    public String getSimpleFieldDesc(){
        String msg = "A:" + this.getTotalAttack();
        msg += "\n";
        msg += "H:" + this.getTotalHp();
        return msg;
    }
}
