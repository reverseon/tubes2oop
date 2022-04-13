package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellPotion extends Card implements HaveDuration, UsableCard {
    int duration;
    float healthMod;
    float attackMod;

    public SpellPotion(int id, String name, String imagePath, String description, int manaCost, int duration, float healthMod, float attackMod) {
        super(id, name, imagePath, description, manaCost, TypeCard.POTION);
        this.duration = duration;
        this.healthMod = healthMod;
        this.attackMod = attackMod;
    }

    public float getHealthMod() {
        return this.healthMod;
    }

    public float getAttackMod() {
        return attackMod;
    }
    public void reduceDuration() {
        this.duration--;
    }
    public int getDuration() {
        return this.duration;
    }

    public void use(Player player, int fieldPosition, Card usingCard) {
        int playerMana = player.getMana();
        int cardManaCost = usingCard.getManaCost();

        if (playerMana >= cardManaCost) {
            CardCharacter playerCard = (CardCharacter) player.getCardAtField(fieldPosition);
            float attackBonus = ((SpellPotion) usingCard).getAttackMod();
            float healthBonus = ((SpellPotion) usingCard).getHealthMod();

            // set attack and health bonus
            playerCard.setAttackBonus(attackBonus);
            playerCard.setHealthBonus(healthBonus);

            float playerCardBaseHealth = playerCard.getBaseHealth();
            float playerCardHealthBonus = playerCard.getHealthBonus();
            float playerCardBaseAttack = playerCard.getBaseAttack();
            float playerCardAttackBonus = playerCard.getAttackBonus();
            // check condition after getting health bonus
            if (playerCardBaseHealth+playerCardHealthBonus <= 0) {
                player.discardField(fieldPosition);
            }
            // check condition after getting attack bonus
            if (playerCardBaseAttack+playerCardAttackBonus <= 0) {
                playerCard.setAttackBonus(-playerCardBaseAttack);
            }
            // add effect to card
            playerCard.addEffect(usingCard);
            // decrease playerMana
            player.setMana(playerMana-cardManaCost);
        } else {
            // tar exception
        }
    }
}