package com.vtuberwars.model.CLI;

import com.vtuberwars.model.card.*;
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
        SummonedCard cardNow = (SummonedCard) playerNow.getCardAtField(idx_player);
        SummonedCard cardNext = (SummonedCard) playerNext.getCardAtField(idx_enemy);
        cardNow.attack(cardNext);
    }
    public void handToField(Player player, Player enemy,int handIdx, int fieldIdx) {
        Card cardAtHand = player.getCardAtHand(handIdx);
        Card cardAtField;
        if(fieldIdx>5){
            cardAtField = enemy.getCardAtField(fieldIdx-5);
        }else{
            cardAtField = player.getCardAtField(fieldIdx);
        }
        cardAtHand.apply(cardAtHand, cardAtField);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        GameBoard gameBoard = new GameBoard(player1, player2);
        player1.addToHand(player1.getCardAtDeck(0),0);
        player1.addToHand(player1.getCardAtDeck(1),1);
        for(Card i : player1.getCardAtHand().getArrayCard()){
            if (i != null) {
                i.printInfo();
            }

        }

        gameBoard.handToField(player1,player2,0,0);
        player1.getCardAtField(0).printInfo();
    }
}