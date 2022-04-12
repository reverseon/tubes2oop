package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellMorph extends Card implements UsableCard {
    private int targetId;

    public SpellMorph(int id, String name, String imagePath, String description, int manaCost, int targetId) {
        super(id, name, imagePath, description, manaCost, TypeCard.MORPH);
        this.targetId = targetId;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public void use(Player player, int fieldPosition, Card usingCard) {
        int playerMana = player.getMana();
        int cardManaCost = usingCard.getManaCost();

        if (playerMana >= cardManaCost) {
            CardCharacter playerCard = (CardCharacter) player.getCardAtField(fieldPosition);
            // tar fungsi nyari kartu karakter berdasarkan id
        } else {
            // tar exception
        }
    }
}
