package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellPotion extends SpellCard implements Useable {
    float healthMod;
    float attackMod;

    public SpellPotion(int id, String name, String imagePath, String description, int manaCost, int duration, float healthMod, float attackMod) {
        super(id, name, imagePath, description, manaCost, TypeSpell.POTION, duration);
        this.healthMod = healthMod;
        this.attackMod = attackMod;
    }

    public static SpellPotion cctorPotion(SpellPotion potion) {
        return new SpellPotion(potion.getId(), potion.getName(), potion.getImagePath(),
                potion.getDescription(), potion.getManaCost(), potion.getDuration(), potion.getHealthMod(),
                potion.getAttackMod());
    }

    public float getHealthMod() {
        return this.healthMod;
    }

    public float getAttackMod() {
        return attackMod;
    }

    public void use(Player player, int fieldPosition, Card usingCard) {
//        int playerMana = player.getMana();
//        int cardManaCost = usingCard.getManaCost();
//
//        if (playerMana >= cardManaCost) {
//            CardCharacter playerCard = (CardCharacter) player.getCardAtField(fieldPosition);
//            float attackBonus = ((SpellPotion) usingCard).getAttackMod();
//            float healthBonus = ((SpellPotion) usingCard).getHealthMod();
//
//            // set attack and health bonus
//            playerCard.setAttackBonus(attackBonus);
//            playerCard.setHealthBonus(healthBonus);
//
//            float playerCardBaseHealth = playerCard.getBaseHealth();
//            float playerCardHealthBonus = playerCard.getHealthBonus();
//            float playerCardBaseAttack = playerCard.getBaseAttack();
//            float playerCardAttackBonus = playerCard.getAttackBonus();
//            // check condition after getting health bonus
//            if (playerCardBaseHealth+playerCardHealthBonus <= 0) {
//                player.discardField(fieldPosition);
//            }
//            // check condition after getting attack bonus
//            if (playerCardBaseAttack+playerCardAttackBonus <= 0) {
//                playerCard.setAttackBonus(-playerCardBaseAttack);
//            }
//            // add effect to card
//            playerCard.addEffect(usingCard);
//            // decrease playerMana
//            player.setMana(playerMana-cardManaCost);
//        } else {
//            // tar exception
//        }
    }
    public void printInfo() {
        super.printInfo();
        System.out.println("Health Mod: " + this.healthMod);
        System.out.println("Attack Mod: " + this.attackMod);
        System.out.println("");
    }
}
