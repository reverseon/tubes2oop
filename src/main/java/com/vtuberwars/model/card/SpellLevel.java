package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

public class SpellLevel extends SpellCard {
    private LevelSpellType typeLevel;

    public SpellLevel(int id, String name, String imagePath, String description,
                      int duration, LevelSpellType typeLevel) {

        super(id, name, imagePath, description, 0, TypeSpell.LEVEL, duration);
        this.typeLevel = typeLevel;
    }

    public LevelSpellType getTypeLevelSpell() {
        return this.typeLevel;
    }

    public void setManaCost(int level) {
        super.setManaCost((int) Math.ceil((level)/ 2.0));
    }

    public void use(SummonedCard SM) {
        if (this.typeLevel == LevelSpellType.LVLUP) {
            SM.levelUp();
        } else {
            SM.levelDown();
        }
        SM.addSpell(this);
    }

}
