package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;
import com.vtuberwars.util.DeckGenerator;

import java.util.stream.Collectors;

public class SpellMorph extends SpellCard implements Useable {
    private int targetId;

    public SpellMorph(int id, String name, String imagePath, String description,
                      int manaCost, int duration, int targetId) {

        super(id, name, imagePath, description, manaCost, TypeSpell.MORPH, duration);
        this.targetId = targetId;
    }

    public static SpellMorph cctorMorph(SpellMorph spellMorph) {
        return new SpellMorph(spellMorph.getId(), spellMorph.getName(), spellMorph.getImagePath(), spellMorph.getDescription(), spellMorph.getManaCost(), spellMorph.getDuration(), spellMorph.getTargetId());
    }
    public int getTargetId() {
        return this.targetId;
    }

    public SummonedCard use(SummonedCard SM) {

        SM = new SummonedCard(DeckGenerator.arrCharacter.stream().
                filter(CC -> CC.getId() == this.targetId).map(CharacterCard.class::cast).
                collect(Collectors.toList()).get(0));
        return SM;
//        int playerMana = player.getMana();
//        int cardManaCost = usingCard.getManaCost();
//
//        if (playerMana >= cardManaCost) {
//            CharacterCard playerCard = (CharacterCard) player.getCardAtField(fieldPosition);
//            // tar fungsi nyari kartu karakter berdasarkan id
//        } else {
//            // tar exception
//        }
    }
    public void printInfo() {
        super.printInfo();
//        System.out.println("Target Id: " + this.targetId);
//        System.out.println("");
    }
    public String getDrawDescription(){
        SummonedCard SM = new SummonedCard(DeckGenerator.arrCharacter.stream().
                filter(CC -> CC.getId() == this.targetId).map(CharacterCard.class::cast).
                collect(Collectors.toList()).get(0));
        return "Turn you into a\n" + SM.getName();
    }
    public String getHandDescription(){
        SummonedCard SM = new SummonedCard(DeckGenerator.arrCharacter.stream().
                filter(CC -> CC.getId() == this.targetId).map(CharacterCard.class::cast).
                collect(Collectors.toList()).get(0));
        String msg = "Target : \n" + SM.getName();
        msg += "\n\n";
        msg += "Duration : \n";
        if(this.getDuration()>0){
            msg += this.getDuration() + " Turn(s)";
        }else{
            msg += "Permanent";
        }
        return msg;
    }
    public String getSimpleDescription(){
        SummonedCard SM = new SummonedCard(DeckGenerator.arrCharacter.stream().
                filter(CC -> CC.getId() == this.targetId).map(CharacterCard.class::cast).
                collect(Collectors.toList()).get(0));
        return SM.getName();
    }
}
