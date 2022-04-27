package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellSwap extends SpellCard implements Useable {

    public SpellSwap(int id, String name, String imagePath, String description, int manaCost, int duration) {
        super(id, name, imagePath, description, manaCost, TypeSpell.SWAP, duration);
    }


    public void use(Player player, int fieldPosition, Card usingCard) {
        int a = 0;
//        int playerMana = player.getMana();
//        int cardManaCost = usingCard.getManaCost();
//        // check playerMana
//        if (playerMana >= cardManaCost) {
//            CardCharacter playerCard = (CardCharacter) player.getCardAtField(fieldPosition);
//            // check playerCard swap spell
//            if (!playerCard.isHaveSwapSpell()) {
//                float playerCardBaseHealth = playerCard.getBaseHealth();
//                float playerCardHealthBonus = playerCard.getHealthBonus();
//                float playerCardBaseAttack = playerCard.getBaseAttack();
//                float playerCardAttackBonus = playerCard.getAttackBonus();
//                // if baseAttack + attackBonus = 0, then discard the card
//                if (playerCardBaseAttack+playerCardAttackBonus == 0) {
//                    player.discardField(fieldPosition);
//                } else {
//                    playerCard.setBaseHealth(playerCardBaseAttack);
//                    playerCard.setBaseAttack(playerCardBaseHealth);
//                    playerCard.setHealthBonus(playerCardAttackBonus);
//                    playerCard.setAttackBonus(playerCardHealthBonus);
//                }
//            }
//            // add effect to card
//            playerCard.addEffect(usingCard);
//            // decrease playerMana
//            player.setMana(playerMana-cardManaCost);
//        } else {
//            // tar exception
//        }
    }
}
