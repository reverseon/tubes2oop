package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellMorph extends SpellCard implements Useable {
    private int targetId;

    public SpellMorph(int id, String name, String imagePath, String description, int manaCost, int duration, int targetId) {
        super(id, name, imagePath, description, manaCost, TypeSpell.MORPH, duration);
        this.targetId = targetId;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public void use(Player player, int fieldPosition, Card usingCard) {
        int playerMana = player.getMana();
        int cardManaCost = usingCard.getManaCost();

        if (playerMana >= cardManaCost) {
            CharacterCard playerCard = (CharacterCard) player.getCardAtField(fieldPosition);
            // tar fungsi nyari kartu karakter berdasarkan id
        } else {
            // tar exception
        }
    }
}
