package com.vtuberwars.model.CLI;

import com.vtuberwars.model.card.*;
import com.vtuberwars.model.cardspace.CardSpace;
import com.vtuberwars.model.player.Player;
import java.io.IOException;
import java.net.URISyntaxException;



import com.vtuberwars.model.card.CharacterCard;

public class GameBoard {
    public Player player1;
    public Player player2;
    public int round;


    public GameBoard(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.round = 1;
    }

    public void attack(Player playerNow, Player playerNext, int idx_player, int idx_enemy) {
        SummonedCard cardNow = (SummonedCard) playerNow.getACardAtField(idx_player);
        SummonedCard cardNext = (SummonedCard) playerNext.getACardAtField(idx_enemy);
        cardNow.attack(cardNext);
    }
    public void handToField(Player player, Player enemy,int handIdx, int fieldIdx) {
        Card cardAtHand = player.getACardAtHand(handIdx);
        CardSpace cardsAtField;
        if(fieldIdx>5){
            cardsAtField = enemy.getCardsAtField();
            fieldIdx -= 5;
        }else{
            cardsAtField = player.getCardsAtField();
        }
        cardAtHand.apply(cardsAtField, fieldIdx);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        GameBoard gameBoard = new GameBoard(player1, player2);
        player1.addToHand(player1.getACardAtDeck(0),0);
        player1.addToHand(player1.getACardAtDeck(1),1);
//        for(Card i : player1.getCardAtHand().getArrayCard()){
//            if (i != null) {
//                i.printInfo();
//            }
//
//        }

        gameBoard.handToField(player1,player2,0,0);
        player1.getACardAtField(0).printInfo();
    }
}