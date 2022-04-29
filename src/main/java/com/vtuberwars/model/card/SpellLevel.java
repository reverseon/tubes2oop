package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

import java.util.HashMap;

public class SpellLevel extends SpellCard implements Useable {
    private LevelSpellType typeLevel;
    public static HashMap<String,LevelSpellType> stringToLevelType = new HashMap<String, LevelSpellType>();
    static {
        stringToLevelType.put("+",LevelSpellType.LVLUP);
        stringToLevelType.put("-",LevelSpellType.LVLDOWN);
    }

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

    public SummonedCard use(SummonedCard SM) {
        if (this.typeLevel == LevelSpellType.LVLUP) {
            SM.levelUp();
        } else {
            SM.levelDown();
        }
        return SM;
    }
    public static SpellLevel cctorLevel(SpellLevel spellLevel) {
        return new SpellLevel(spellLevel.getId(), spellLevel.getName(), spellLevel.getImagePath(), spellLevel.getDescription(), 0, spellLevel.getTypeLevelSpell());
    }
    public String getDrawDescription(){
        return "Level " + (this.getTypeLevelSpell().equals(LevelSpellType.LVLUP)? "up" : "down") + "\none card";
    }
    public String getHandDescription(){
        return "";
    }
    public String getSimpleDescription(){ return "Lvl " + (this.getTypeLevelSpell().equals(LevelSpellType.LVLUP)? "up" : "down");}
}
