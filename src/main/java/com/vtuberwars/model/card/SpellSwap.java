package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellSwap extends Card implements HaveDuration, UsableCard {
    int duration;
    boolean active;

    public SpellSwap(int id, String name, String imagePath, String description, int manaCost, int duration) {
        super(id, name, imagePath, description, manaCost);
        this.duration = duration;
        this.active = false;
    }

    public void reduceDuration() { this.duration--;}
    public int getDuration() {
        return this.duration;
    }
    public void activedSpell() {
        this.active = true;
    }
    public void deactivedSpell() {
        this.active = false;
    }
    public boolean isActive() {
        return this.active;
    }

    public void useBuff(Player ourPlayer, int fieldPosition) {

    }

    public void useDebuff(Player ourPlayer, Player enemyPlayer, int fieldEnemyPosition) {

    }
}
