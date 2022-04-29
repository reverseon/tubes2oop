package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellPotion extends SpellCard implements Useable {
    private float healthMod;
    private float attackMod;

    public SpellPotion(int id, String name, String imagePath, String description, int manaCost,
                       int duration, float healthMod, float attackMod) {

        super(id, name, imagePath, description, manaCost, TypeSpell.POTION, duration);
        this.healthMod = healthMod;
        this.attackMod = attackMod;
    }

    public static SpellPotion cctorPotion(SpellPotion potion) {
        return new SpellPotion(potion.getId(), potion.getName(), potion.getImagePath(),
                potion.getDescription(), potion.getManaCost(), potion.getDuration(), potion.getHealthMod(),
                potion.getAttackMod());
    }

    public void setHealthMod(float healthMod) {
        this.healthMod = healthMod;
    }
    public float getHealthMod() {
        return this.healthMod;
    }
    public void setAttackMod(float attackMod) {
        this.attackMod = attackMod;
    }
    public float getAttackMod() {
        return attackMod;
    }

    public SummonedCard use(SummonedCard SM) {
        SM.addSpell(this);
        if (SM.getTotalHp() <= 0) {
            SM = null;
        }
        return SM;
    }
    public void printInfo() {
        super.printInfo();
//        System.out.println("Health Mod: " + this.healthMod);
//        System.out.println("Attack Mod: " + this.attackMod);
//        System.out.println("");
    }
    public String getDrawDescription(){
        String desc = "ATK";
        if(this.attackMod >=0){
            desc += "+";
        }
        desc += this.attackMod + "/HP";
        if(this.healthMod >=0){
            desc += "+";
        }
        desc += this.healthMod;
        return desc;
    }
    public String getHandDescription(){
        String msg = "ATK : ";
        if(this.attackMod>=0){
            msg += "+";
        }
        msg += this.attackMod;
        msg += "\n";
        msg += "HP : ";
        if(this.healthMod>=0){
            msg += "+";
        }
        msg += this.healthMod;
        msg += "\n";
        msg += "Duration : \n";
        if(this.getDuration()>0){
            msg += this.getDuration() + " Turn(s)";
        }else{
            msg += "Permanent";
        }
        return msg;
    }
    public String getSimpleDescription(){
        String msg = "H: ";
        if(this.healthMod>=0){
            msg += "+";
        }
        msg += this.getHealthMod() + " A: ";
        if(this.attackMod>=0){
            msg+= "+";
        }
        msg += this.attackMod;
        return msg;
    }
}
