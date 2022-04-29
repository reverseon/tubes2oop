package com.vtuberwars.model.card;

import com.vtuberwars.model.player.*;

import java.util.List;
import java.util.stream.Collectors;

public class SpellSwap extends SpellCard implements Useable {

    public SpellSwap(int id, String name, String imagePath,
                     String description, int manaCost, int duration) {

        super(id, name, imagePath, description, manaCost, TypeSpell.SWAP, duration);
    }


    public static SpellSwap cctorSwap(SpellSwap card) {
        return new SpellSwap(card.getId(), card.getName(), card.getImagePath(),card.getDescription(), card.getManaCost(), card.getDuration());
    }
    public SummonedCard use(SummonedCard SM) {
        List<SpellPotion> temp =
                SM.getActiveSpells().stream().
                        filter(SpellPotion.class::isInstance).
                        map(SpellPotion.class::cast).collect(Collectors.toList());

        for (SpellCard Spell : SM.getActiveSpells()) {
            if (Spell.getTypeSpell() == TypeSpell.SWAP) {
                Spell.setDuration(Spell.getDuration()+this.getDuration());
                return SM;
            }
        }

        SM.addSpell(this);
        SM.swapStat();
        return SM;

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
    public void printInfo() {
        super.printInfo();
//        System.out.println("");
    }
    public String getDrawDescription(){
        return "ATK <-> HP(" + this.getDuration() + ")";
    }
    public String getHandDescription(){
        String msg = "Duration : \n";
        if(this.getDuration()>0){
            msg += this.getDuration() + " Turn(s)";
        }else{
            msg += "Permanent";
        }
        return msg;
    }
    public String getSimpleDescription(){
        String msg = "Dur: ";
        if(this.getDuration()>0){
            msg += this.getDuration();
        }else{
            msg += "inf";
        }
        return msg;
    }
}
