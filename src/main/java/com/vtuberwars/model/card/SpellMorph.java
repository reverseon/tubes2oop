package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellMorph extends Card implements UsableCard {
    private int targetId;

    public SpellMorph(int id, String name, String imagePath, String description, int manaCost, int targetId) {
        super(id, name, imagePath, description, manaCost);
        this.targetId = targetId;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public void useBuff(Player ourPlayer, int fieldPosition) {

    }

    public void useDebuff(Player ourPlayer, Player enemyPlayer, int fieldEnemyPosition) {

    }
}
