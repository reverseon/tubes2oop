package com.vtuberwars;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

import com.vtuberwars.model.card.Card;
import com.vtuberwars.model.card.CharacterCard;
import com.vtuberwars.model.card.SummonedCard;
import com.vtuberwars.model.cardspace.CardSpace;
import com.vtuberwars.model.code.DeckCode;
import com.vtuberwars.model.code.GameState;
import com.vtuberwars.model.code.TurnPlayer;
import com.vtuberwars.model.player.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.vtuberwars.util.CSVReader;

public class VTuberWars extends Application {
  protected static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  protected static final String UI_PATH = "/com/vtuberwars/card/ui/";
  protected static final Stage stage = new Stage();

  // GAME PROPS
  protected static Player p1;
  protected static Player p2;
  static {
    Random random = new Random();
    int randNum = random.nextInt(21)+40;
    p1 = new Player("Megumin", randNum);
    p2 = new Player("Ender", randNum);
  }
  protected static String whoseTurn = TurnPlayer.PLAYER1;
  protected static String whatPhase = GameState.DRAW;
  protected static Integer whatTurn = 1;
  protected static Integer lastBtnClicked = -1;
  protected static Button lastBtnClickedBtn = null;
  protected static boolean[] alreadyAttack = {false, false, false, false, false};
  protected static String winner = null;

  public DeckCode whichGroup(Integer btn_id) {
    if (btn_id == 16) {
      return DeckCode.P1CARD;
    } else if (btn_id == 17) {
      return DeckCode.P2CARD;
    } else if (btn_id == 18) {
      return DeckCode.DISCARDBTN;
    } else if (btn_id == 19) {
      return DeckCode.LVUPBTN;
    }else if (0 <= btn_id && btn_id <= 4) {
      return DeckCode.P1DECK;
    } else if (5 <= btn_id && btn_id <= 9) {
      return DeckCode.P2DECK;
    } else if (10 <= btn_id && btn_id <= 14) {
      return DeckCode.HANDDECK;
    } else {
      return DeckCode.OTHER;
    }
  }


  public void switchToMain() {
    try {
        if (p1.getHealth() <= 0) {
          winner = TurnPlayer.PLAYER2;
          switchToWinScreen();
        } else if (p2.getHealth() <= 0) {
          winner = TurnPlayer.PLAYER1;
          switchToWinScreen();
        } else {
          Parent root = FXMLLoader.load(VTuberWars.class.getResource(UI_PATH + "Main.fxml"));
          Scene rootScene = new Scene(root, 1280, 720);
          stage.setScene(rootScene);
          stage.show();
        }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void switchToDraw() {
    try {
//      System.out.println(whoseTurn);
      if (p1.getCardsAtDeck().getNEff() == 0 && whoseTurn.equals(TurnPlayer.PLAYER1)) {
        winner = TurnPlayer.PLAYER2;
        switchToWinScreen();
      } else if (p2.getCardsAtDeck().getNEff() == 0 && whoseTurn.equals(TurnPlayer.PLAYER2)) {
        winner = TurnPlayer.PLAYER1;
        switchToWinScreen();
      } else {
        Parent root = FXMLLoader.load(VTuberWars.class.getResource(UI_PATH + "Draw.fxml"));
        Scene rootScene = new Scene(root, 1280, 720);
        stage.setScene(rootScene);
        stage.show();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void switchToWinScreen() {
    try {
      Parent root = FXMLLoader.load(VTuberWars.class.getResource(UI_PATH + "Yeay.fxml"));
      Scene rootScene = new Scene(root, 1280, 720);
      stage.setScene(rootScene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void nextTurn() {
    whatTurn++;
    
    CardSpace p1csp = p1.getCardsAtField();
    CardSpace p2csp = p2.getCardsAtField();
    for (int i = 0; i < 5; i++) {
      if (p1csp.getCard(i) != null) {
        ((SummonedCard)p1csp.getCard(i)).reduceSpell();
      }
      if (p2csp.getCard(i) != null) {
        ((SummonedCard)p2csp.getCard(i)).reduceSpell();
      }
    }

    if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
      whoseTurn = TurnPlayer.PLAYER2;
      p2.setMana(((Integer)(whatTurn + 1) / 2));
      p2.setMaxMana(((Integer)(whatTurn + 1) / 2));
    } else {
      whoseTurn = TurnPlayer.PLAYER1;
      p1.setMana(((Integer)(whatTurn + 1) / 2));
      p1.setMaxMana(((Integer)(whatTurn + 1) / 2));
    }
    whatPhase = GameState.DRAW;

  }

  public void nextPhase() {
//      System.out.println(p1.getHealth() + " " + p2.getHealth());
      if (p1.getHealth() <= 0) {
        winner = TurnPlayer.PLAYER2;
        switchToWinScreen();
      } else if (p2.getHealth() <= 0) {
        winner = TurnPlayer.PLAYER1;
        switchToWinScreen();
      } else if (whatPhase.equals(GameState.DRAW)) {
        whatPhase = GameState.PLAN;
        switchToDraw();
      } else if (whatPhase.equals(GameState.PLAN)) {
          whatPhase = GameState.ATTACK;
          alreadyAttack = new boolean[]{false, false, false, false, false};
          switchToMain();
      } else if (whatPhase.equals(GameState.ATTACK)) {
          whatPhase = GameState.END;
          switchToMain();
      } else if (whatPhase.equals(GameState.END)) {
          nextTurn();
          switchToMain();
      }

  }


  public void attack_card(Player p1, Player p2, int attacker, int defender) {
    try{
      SummonedCard cardattacker;
      SummonedCard carddefender;
      Player playerDefend;
      Player playerAttack;
      if (attacker > defender) { // p2 v p1
        attacker -= 5;
        playerDefend = p1;
        playerAttack = p2;
        cardattacker = (SummonedCard) p2.getACardAtField(attacker);
        carddefender = (SummonedCard) p1.getACardAtField(defender);

      } else { // p1 v p2
        defender -= 5;
        playerDefend = p2;
        playerAttack = p1;
        cardattacker = (SummonedCard) p1.getACardAtField(attacker);
        carddefender = (SummonedCard) p2.getACardAtField(defender);
      }

      cardattacker.attack(carddefender);
//      System.out.println( "atkIDX " + attacker+ " defIDX " + defender + " KONTOL " + carddefender.getTotalHp() + " " + cardattacker.getTotalHp());
      if(carddefender.getTotalHp()<=0){
        if(cardattacker.getTotalHp()>0){
          ((SummonedCard) playerAttack.getACardAtField(attacker)).addExp(carddefender.getLevel());
        }
        playerDefend.discardField(defender);
      }
      if(cardattacker.getTotalHp()<=0){
        if(carddefender.getTotalHp()>0){
          ((SummonedCard) playerDefend.getACardAtField(defender)).addExp(cardattacker.getLevel());
        }
        playerAttack.discardField(attacker);
      }
    }catch (Exception e){
      throw new RuntimeException("You can't select empty space!");
    }

  }
  public void handToField(Player p1, Player p2, int handIdx, int fieldIdx, String who) throws RuntimeException {
    try{
      Card cardAtHand;
      Player playerNow;
      if (who.equals(TurnPlayer.PLAYER1)) {
        playerNow = p1;
        cardAtHand = p1.getACardAtHand(handIdx);
      } else {
        playerNow = p2;
        cardAtHand = p2.getACardAtHand(handIdx);
      }
      if (cardAtHand instanceof CharacterCard) {
        if (whoseTurn.equals(TurnPlayer.PLAYER1) && fieldIdx > 4) {
          throw new RuntimeException("P1 cant put to P2");
        } else if (whoseTurn.equals(TurnPlayer.PLAYER2) && fieldIdx < 5) {
          throw new RuntimeException("P2 cant put to P1");
        }
      }
      CardSpace cardsAtField;
      if(fieldIdx>=5){
        cardsAtField = p2.getCardsAtField();
        fieldIdx -= 5;
      }else{
        cardsAtField = p1.getCardsAtField();
      }
      if(playerNow.getMana()<cardAtHand.getManaCost()){
        throw new RuntimeException("Not enough mana!");
      }
      cardAtHand.apply(cardsAtField, fieldIdx);
      playerNow.discardHand(handIdx);
      playerNow.setMana(playerNow.getMana()-cardAtHand.getManaCost());
    }catch (RuntimeException e) {
      throw e;
    }

  }

  @Override
  public void start(Stage primaryStage) {
    try {
      Parent root = FXMLLoader.load(getClass().getResource(UI_PATH + "Main.fxml"));
      Scene rootScene = new Scene(root, 1280, 720);
      stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/vtuberwars/card/image/character/megumin.png")));
      stage.setScene(rootScene);
      stage.setTitle("VTuber Wars");
      stage.setResizable(false);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
