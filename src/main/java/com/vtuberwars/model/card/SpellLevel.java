package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellLevel extends SpellCard implements Useable {
    private int modLevel;

    public SpellLevel(int id, String name, String imagePath, String description, int modLevel, int duration) {
        super(id, name, imagePath, description, (int) Math.ceil((double) modLevel/2.0), TypeSpell.LEVEL, duration);
        this.modLevel = modLevel;
    }

    public int getModLevel() {
        return this.modLevel;
    }

    public void render() {
        // nampilin kartu
    }

    public void use(Player player, int fieldPosition, Card usingCard) {
//        int playerMana = player.getMana();
//        int cardManaCost = usingCard.getManaCost();
//        // check playerMana
//        if (playerMana >= cardManaCost) {
//            CardCharacter playerCard = (CardCharacter) player.getCardAtField(fieldPosition);
//            int modLevel = ((SpellLevel) usingCard).getModLevel();
//            int playerCardLevel = playerCard.getLevel();
//            // reset playerCard Exp
//            playerCard.resetExp();
//            // condition after adding/ decreasing level
//            if (playerCardLevel+modLevel <= 1) {
//                playerCard.setLevel(1);
//            } else if (playerCardLevel+modLevel >= 10) {
//                playerCard.setLevel(10);
//            } else {
//                playerCard.setLevel(playerCardLevel+modLevel);
//            }
//            // decrease playerMana
//            player.setMana(playerMana-cardManaCost);
//        } else {
//            // tar exception
//        }
    }

}
