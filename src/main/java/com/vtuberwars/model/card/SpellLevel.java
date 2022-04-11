package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellLevel extends Card implements UsableCard {

    public SpellLevel(int id, String name, String imagePath, String description, int manaCost) {
        super(id, name, imagePath, description, manaCost);
    }

    public void useBuff(Player ourPlayer, int fieldPosition) {

    }

    public void useDebuff(Player ourPlayer, Player enemyPlayer, int fieldEnemyPosition) {

    }
}
