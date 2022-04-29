//package com.vtuberwars.model.CLI;
//
//import com.vtuberwars.model.card.*;
//import com.vtuberwars.model.cardspace.CardSpace;
//import com.vtuberwars.model.player.Player;
//import java.io.IOException;
//import java.net.URISyntaxException;
//
//
//
//import com.vtuberwars.model.card.CharacterCard;
//
//public class GameBoard {
//    public Player player1;
//    public Player player2;
//    public int round;
//
//
//    public GameBoard(Player player1, Player player2) {
//        this.player1 = player1;
//        this.player2 = player2;
//        this.round = 1;
//    }
//
//    public void attack(Player playerNow, Player playerNext, int idx_player, int idx_enemy) {
//        SummonedCard cardNow = (SummonedCard) playerNow.getACardAtField(idx_player);
//        SummonedCard cardNext = (SummonedCard) playerNext.getACardAtField(idx_enemy);
//        cardNow.attack(cardNext);
//    }
//    public void handToField(Player p1, Player p2, int handIdx, int fieldIdx, String who) {
//        Card cardAtHand;
//        if (who == "p1") {
//            cardAtHand = p1.getACardAtHand(handIdx);
//        } else {
//            cardAtHand = p2.getACardAtHand(handIdx);
//        }
//        CardSpace cardsAtField;
//        if(fieldIdx>=5){
//            cardsAtField = p2.getCardsAtField();
//            fieldIdx -= 5;
//        }else{
//            cardsAtField = p1.getCardsAtField();
//        }
//        cardAtHand.apply(cardsAtField, fieldIdx);
//    }
//
//    public static void main(String[] args) throws IOException, URISyntaxException {
//        Player player1 = new Player("player1");
//        Player player2 = new Player("player2");
//        GameBoard gameBoard = new GameBoard(player1, player2);
//        player1.getACardAtDeck(30).printInfo();
//        player1.addToHand(player1.getACardAtDeck(30),30);
//        player1.addToHand(player1.getACardAtDeck(0),0);
//
////        for(Card i : player1.getCardAtHand().getArrayCard()){
////            if (i != null) {
////                i.printInfo();
////            }
////
////        }
//        player1.getACardAtHand(1).printInfo();
//        gameBoard.handToField(player1,player2,1,0);
//        System.out.println("KONTOL");
//        player1.getACardAtField(0).printInfo();
//        System.out.println("\nKENA SPELL\n");
//        gameBoard.handToField(player1,player2,0,0);
//        player1.getACardAtField(0).printInfo();
////        gameBoard.handToField(player2,player1,0,0);
////        player1.getACardAtField(0).printInfo();
////        player2.getACardAtField(0).printInfo();
////        gameBoard.attack(player1,player2,0,0);
////        System.out.println("ATTACK SUCCESS");
////        player1.getACardAtField(0).printInfo();
////        player2.getACardAtField(0).printInfo();
//    }
//}