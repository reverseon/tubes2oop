package com.vtuberwars.card.ui;

import com.vtuberwars.VTuberWars;
import com.vtuberwars.model.card.*;
import com.vtuberwars.model.cardspace.CardSpace;
import com.vtuberwars.model.code.DeckCode;
import com.vtuberwars.model.code.GameState;
import com.vtuberwars.model.code.TurnPlayer;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class MainController extends VTuberWars implements Initializable {
    // misc btn
    @FXML private Button discard_hand_btn;
    @FXML private Button up_card_btn;
    // player btn
    @FXML private Button field_p1_ava_atk;
    @FXML private Button field_p2_ava_atk;
    // getfocus
    @FXML Button fc_btn;
    // game control
    @FXML
    private Button next_phase_btn;
    // bar and status
    @FXML private Label game_current_state; @FXML private ProgressBar p1_hbar; @FXML private ProgressBar p2_hbar; @FXML private Label turn_feedback;
    // avatar
    @FXML private ImageView field_p1_ava;@FXML private ImageView field_p2_ava; @FXML private ImageView card_ava;
    // field controller
    @FXML private ImageView field_p1_1_img;@FXML private Label field_p1_1_desc;@FXML private ImageView field_p1_2_img;@FXML private Label field_p1_2_desc;@FXML private ImageView field_p1_3_img;@FXML private Label field_p1_3_desc; @FXML private ImageView field_p1_4_img;@FXML private Label field_p1_4_desc; @FXML private ImageView field_p1_5_img; @FXML private Label field_p1_5_desc; @FXML private ImageView field_p2_1_img; @FXML private Label field_p2_1_desc; @FXML private ImageView field_p2_2_img; @FXML private Label field_p2_2_desc; @FXML private ImageView field_p2_3_img; @FXML private Label field_p2_3_desc; @FXML private ImageView field_p2_4_img; @FXML private Label field_p2_4_desc; @FXML private ImageView field_p2_5_img; @FXML private Label field_p2_5_desc; @FXML private Button field_p2_1; @FXML private Button field_p2_2; @FXML private Button field_p2_3; @FXML private Button field_p2_4; @FXML private Button field_p2_5; @FXML private Button field_p1_1; @FXML private Button field_p1_2; @FXML private Button field_p1_3; @FXML private Button field_p1_4; @FXML private Button field_p1_5;

    // hand
    @FXML private Button hand_1; @FXML private Button hand_2; @FXML private Button hand_3; @FXML private Button hand_4; @FXML private Button hand_5; @FXML ImageView hand_1_img; @FXML ImageView hand_2_img; @FXML ImageView hand_3_img; @FXML ImageView hand_4_img; @FXML ImageView hand_5_img; @FXML Label hand_1_desc; @FXML Label hand_2_desc; @FXML Label hand_3_desc; @FXML Label hand_4_desc; @FXML Label hand_5_desc;

    // detail
    @FXML private Label detail_title; @FXML private Label detail_deck; @FXML private Label detail_mana; @FXML private Text detail_stats; @FXML private Text detail_desc;

    // button grouping

    @Override
    public void initialize(URL loc, ResourceBundle res) {
        try {
            fc_btn.requestFocus();
            // button implement animation
            Button[] field_p1_gl = {field_p1_1, field_p1_2, field_p1_3, field_p1_4, field_p1_5};
            Button[] field_p2_gl = {field_p2_1, field_p2_2, field_p2_3, field_p2_4, field_p2_5};
            Button[] hand_gl = {hand_1, hand_2, hand_3, hand_4, hand_5};
            for (int i = 0; i < 5; i++) {
                final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
                fadeIn.setNode(field_p1_gl[i]);
                fadeIn.setToValue(0.5);
                final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
                fadeOut.setNode(field_p1_gl[i]);
                fadeOut.setToValue(1);
                field_p1_gl[i].setOnMouseEntered(e -> fadeIn.playFromStart());
                field_p1_gl[i].setOnMouseExited(e -> fadeOut.playFromStart());
            }
            for (int i = 0; i < 5; i++) {
                final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
                fadeIn.setNode(field_p2_gl[i]);
                fadeIn.setToValue(0.5);
                final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
                fadeOut.setNode(field_p2_gl[i]);
                fadeOut.setToValue(1);
                field_p2_gl[i].setOnMouseEntered(e -> fadeIn.playFromStart());
                field_p2_gl[i].setOnMouseExited(e -> fadeOut.playFromStart());
            }
            for (int i = 0; i < 5; i++) {
                final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
                fadeIn.setNode(hand_gl[i]);
                fadeIn.setToValue(0.5);
                final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
                fadeOut.setNode(hand_gl[i]);
                fadeOut.setToValue(1);
                hand_gl[i].setOnMouseEntered(e -> fadeIn.playFromStart());
                hand_gl[i].setOnMouseExited(e -> fadeOut.playFromStart());
            }
            // Field Setting P1
            ImageView[] p1_img = {field_p1_1_img, field_p1_2_img, field_p1_3_img, field_p1_4_img, field_p1_5_img};
            Button[] p1_btn = {field_p1_1, field_p1_2, field_p1_3, field_p1_4, field_p1_5};
            Label[] p1_desc = {field_p1_1_desc, field_p1_2_desc, field_p1_3_desc, field_p1_4_desc, field_p1_5_desc};
            for (int i = 0; i < 5; i++) {
                Card temp = this.p1.getACardAtField(i);
                if (temp != null) {
                    p1_img[i].setImage(new Image(new FileInputStream(temp.getImagePath())));
                    p1_desc[i].setText(((SummonedCard)temp).getSimpleFieldDesc());
                } else {
                    p1_img[i].setImage(null);
                    p1_desc[i].setText("Empty");
                }
            }
            // Field Setting P2
            ImageView[] p2_img = {field_p2_1_img, field_p2_2_img, field_p2_3_img, field_p2_4_img, field_p2_5_img};
            Button[] p2_btn = {field_p2_1, field_p2_2, field_p2_3, field_p2_4, field_p2_5};
            Label[] p2_desc = {field_p2_1_desc, field_p2_2_desc, field_p2_3_desc, field_p2_4_desc, field_p2_5_desc};
            for (int i = 0; i < 5; i++) {
                Card temp = this.p2.getACardAtField(i);
                if (temp != null) {
                    p2_img[i].setImage(new Image(new FileInputStream(temp.getImagePath())));
                    p2_desc[i].setText(((SummonedCard)temp).getSimpleFieldDesc());
                } else {
                    p2_img[i].setImage(null);
                    p2_desc[i].setText("Empty");
                }
            }

            // hand setting
            Button[] hand_btn = {hand_1, hand_2, hand_3, hand_4, hand_5};
            ImageView[] hand_img = {hand_1_img, hand_2_img, hand_3_img, hand_4_img, hand_5_img};
            Label[] hand_desc = {hand_1_desc, hand_2_desc, hand_3_desc, hand_4_desc, hand_5_desc};
            for (int i = 0; i < 5; i++) {
                Card temp;
                if (whoseTurn.equals(TurnPlayer.PLAYER1)){
                    temp = this.p1.getACardAtHand(i);
                } else {
                    temp = this.p2.getACardAtHand(i);
                }

                if (temp != null) {
                    hand_img[i].setImage(new Image(new FileInputStream(temp.getImagePath())));
                    hand_desc[i].setText("MANA: " + temp.getManaCost() + "\n" + temp.getSimpleDescription());
                } else {
                    hand_img[i].setImage(null);
                    hand_desc[i].setText("Empty");
                }
            }

            // detail setting

            if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
                detail_deck.setText("Deck\n" + p1.getCardsAtDeck().getNEff() + "/" + p1.getCardsAtDeck().getMaxCap());
                detail_mana.setText("Mana\n" + p1.getMana()+"/" +p1.getMaxMana());
            } else {
                detail_deck.setText("Deck\n" + p2.getCardsAtDeck().getNEff() + "/" + p2.getCardsAtDeck().getMaxCap());
                detail_mana.setText("Mana\n" + p2.getMana()+"/" +p2.getMaxMana());
            }
            card_ava.setImage(null);
            detail_stats.setText("Nothing Selected");
            detail_desc.setText("Nothing Selected");
            detail_title.setText("Nothing");

            // state settings
            game_current_state.setText("Round " + ((Integer)(whatTurn + 1) / 2) + "\n"+ whoseTurn +"\n" + whatPhase);
            double hp1p = (double)this.p1.getHealth()/80.0;
            double hp2p = (double)this.p2.getHealth()/80.0;
            p1_hbar.setProgress(hp1p > 0 ? hp1p : 0);
            p2_hbar.setProgress(hp2p > 0 ? hp2p : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnlistener(Integer btn_id, Button clicked_btn) {
        turn_feedback.setText("");
        try {
            DeckCode last = whichGroup(lastBtnClicked);
            DeckCode now = whichGroup(btn_id);
//            System.out.println("lastid:" + lastBtnClicked + " nowid:" + btn_id + "who:" + whoseTurn);
//            System.out.println("last: " + last + " now: " + now);
            if (whatPhase.equals(GameState.ATTACK)) {
                // ATTACK OTHER PLAYER
                // P1 v P2
                if (whoseTurn.equals(TurnPlayer.PLAYER1) && last == DeckCode.P1DECK && now == DeckCode.P2DECK) {
                    // attack
                    if (alreadyAttack[lastBtnClicked % 5] == false) {
//                        System.out.println("1");
                        alreadyAttack[lastBtnClicked % 5] = true;
                        attack_card(p1, p2, lastBtnClicked, btn_id);
                    } else if (alreadyAttack[lastBtnClicked % 5] == true) {
//                        System.out.println("2");
                        throw new Exception("You can't attack Twice");
                    }
                    switchToMain();
                }
                // P2 v P1
                if (whoseTurn.equals(TurnPlayer.PLAYER2) &&  last == DeckCode.P2DECK && now == DeckCode.P1DECK) {
                    // attack
                    if (alreadyAttack[lastBtnClicked % 5] == false) {
//                        System.out.println("1");
                        alreadyAttack[lastBtnClicked % 5] = true;
                        attack_card(p1, p2, lastBtnClicked, btn_id);
                    } else if (alreadyAttack[lastBtnClicked % 5] == true) {
//                        System.out.println("2");
                        throw new Exception("You can't attack twice!");
                    }
                    switchToMain();
                }

                // P2 v Real P1
                if (whoseTurn.equals(TurnPlayer.PLAYER2) && last == DeckCode.P2DECK && now == DeckCode.P1CARD) {
//                    System.out.println("neff:" + p1.getCardsAtField().getNEff());
                    if (p1.getCardsAtField().getNEff() != 0) {
                        throw new Exception("You can't attack the player!");
                    } else {
                        if (alreadyAttack[lastBtnClicked % 5] == false) {
                            alreadyAttack[lastBtnClicked % 5] = true;
                            p1.setHealth(p1.getHealth() - ((SummonedCard)p2.getACardAtField(lastBtnClicked % 5)).getTotalAttack());
                            switchToMain();
                        } else {
                            throw new Exception("You can't attack twice!");
                        }

                    }
                }
                // P1 v Real P2
                if (whoseTurn.equals(TurnPlayer.PLAYER1) && last == DeckCode.P1DECK && now == DeckCode.P2CARD) {
                    System.out.println("neff:" + p2.getCardsAtField().getNEff());
                    if (p2.getCardsAtField().getNEff() != 0) {
                        throw new Exception("You can't attack the player!");
                    }
                    else {
                        if (alreadyAttack[lastBtnClicked % 5] == false) {
                            alreadyAttack[lastBtnClicked % 5] = true;
                            p2.setHealth(p2.getHealth() - ((SummonedCard)p1.getACardAtField(lastBtnClicked % 5)).getTotalAttack());
                            switchToMain();
                        } else {
                            throw new Exception("You can't attack twice!");
                        }

                    }
                }
            } else if (whatPhase.equals(GameState.PLAN)) {
                // MOVE TO DECK
                if (last == DeckCode.HANDDECK && (now == DeckCode.P2DECK || now == DeckCode.P1DECK) && whoseTurn.equals(TurnPlayer.PLAYER1)) {
                    handToField(p1, p2, lastBtnClicked - 10, btn_id, whoseTurn);
                    switchToMain();
                }
                if (last == DeckCode.HANDDECK && (now == DeckCode.P2DECK || now == DeckCode.P1DECK) && whoseTurn.equals(TurnPlayer.PLAYER2)) {
                    handToField(p1, p2, lastBtnClicked - 10, btn_id, whoseTurn);
                    switchToMain();
                }
                if (last == DeckCode.HANDDECK && now == DeckCode.DISCARDBTN) {
                    if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
                        p1.discardHand(lastBtnClicked - 10);
                    } else {
                        p2.discardHand(lastBtnClicked - 10);
                    }
                    switchToMain();
                }

                if (last == DeckCode.P1DECK && now == DeckCode.DISCARDBTN && whoseTurn.equals(TurnPlayer.PLAYER1)) {
                    p1.discardField(lastBtnClicked % 5);
                    switchToMain();
                }
                if (last == DeckCode.P2DECK && now == DeckCode.DISCARDBTN && whoseTurn.equals(TurnPlayer.PLAYER2)) {
                    p2.discardField(lastBtnClicked % 5);
                    switchToMain();
                }

            }
            // ANYTIME ACTION
            if (last == DeckCode.P1DECK && now == DeckCode.LVUPBTN && whoseTurn.equals(TurnPlayer.PLAYER1)) {
                SummonedCard tgt = (SummonedCard) p1.getACardAtField(lastBtnClicked % 5);
                tgt.addExp(p1.getMana());
                p1.setMana(0);
                switchToMain();
            }
            if (last == DeckCode.P2DECK && now == DeckCode.LVUPBTN && whoseTurn.equals(TurnPlayer.PLAYER2)) {
                SummonedCard tgt = (SummonedCard) p2.getACardAtField(lastBtnClicked % 5);
                tgt.addExp(p2.getMana());
                p2.setMana(0);
                switchToMain();
            }
            lastBtnClicked = btn_id;
            lastBtnClickedBtn = clicked_btn;
        } catch (Exception e) {
            turn_feedback.setText(e.getMessage());
        }

    }
    public void fieldDetails(Card card) {
        try {
            if (card == null) {
                return;
            } else {
                SummonedCard castedcard = (SummonedCard) card;
                detail_title.setText(castedcard.getName());
                detail_desc.setText(castedcard.getDescription());
                detail_stats.setText(castedcard.getFieldDescription());
                card_ava.setImage(new Image(new FileInputStream(castedcard.getImagePath())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void card_p1_1_click(ActionEvent event) {
        btnlistener(0, field_p1_1);
        fieldDetails(p1.getACardAtField(0));
    }
    public void card_p1_2_click(ActionEvent event) {
        btnlistener(1, field_p1_2);
        fieldDetails(p1.getACardAtField(1));
    }
    public void card_p1_3_click(ActionEvent event) {
        btnlistener(2, field_p1_3);
        fieldDetails(p1.getACardAtField(2));
    }
    public void card_p1_4_click(ActionEvent event) {
        btnlistener(3, field_p1_4);
        fieldDetails(p1.getACardAtField(3));
    }
    public void card_p1_5_click(ActionEvent event) {
        btnlistener(4, field_p1_5);
        fieldDetails(p1.getACardAtField(4));
    }
    public void card_p2_1_click(ActionEvent event) {
        btnlistener(5, field_p2_1);
        fieldDetails(p2.getACardAtField(0));
    }
    public void card_p2_2_click(ActionEvent event) {
        btnlistener(6, field_p2_2);
        fieldDetails(p2.getACardAtField(1));
    }
    public void card_p2_3_click(ActionEvent event) {
        btnlistener(7, field_p2_3);
        fieldDetails(p2.getACardAtField(2));
    }
    public void card_p2_4_click(ActionEvent event) {
        btnlistener(8, field_p2_4);
        fieldDetails(p2.getACardAtField(3));
    }
    public void card_p2_5_click(ActionEvent event) {
        btnlistener(9, field_p2_5);
        fieldDetails(p2.getACardAtField(4));
    }

    public void discard_hand(ActionEvent event) {
        btnlistener(18, discard_hand_btn);
    }
    public void lvup_fields(ActionEvent event) {
        btnlistener(19, up_card_btn);
    }
    public void hand_1_click(ActionEvent event) {
        btnlistener(10, hand_1);
        Card card;
        if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
            card = this.p1.getACardAtHand(0);
        } else {
            card = this.p2.getACardAtHand(0);
        }
        if (card != null) {
            try {
                card_ava.setImage(new Image(new FileInputStream(card.getImagePath())));
                detail_title.setText(card.getName());
                detail_stats.setText(card.getHandDescription());
                detail_desc.setText(card.getDescription());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void hand_2_click(ActionEvent event) {
        btnlistener(11, hand_2);
        Card card;
        if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
            card = this.p1.getACardAtHand(1);
        } else {
            card = this.p2.getACardAtHand(1);
        }
        if (card != null) {
            try {
                card_ava.setImage(new Image(new FileInputStream(card.getImagePath())));
                detail_title.setText(card.getName());
                detail_stats.setText(card.getHandDescription());
                detail_desc.setText(card.getDescription());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void hand_3_click(ActionEvent event) {
        btnlistener(12, hand_3);
        Card card;
        if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
            card = this.p1.getACardAtHand(2);
        } else {
            card = this.p2.getACardAtHand(2);
        }
        if (card != null) {
            try {
                card_ava.setImage(new Image(new FileInputStream(card.getImagePath())));
                detail_title.setText(card.getName());
                detail_stats.setText(card.getHandDescription());
                detail_desc.setText(card.getDescription());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void hand_4_click(ActionEvent event) {
        btnlistener(13, hand_4);
        Card card;
        if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
            card = this.p1.getACardAtHand(3);
        } else {
            card = this.p2.getACardAtHand(3);
        }
        if (card != null) {
            try {
                card_ava.setImage(new Image(new FileInputStream(card.getImagePath())));
                detail_title.setText(card.getName());
                detail_stats.setText(card.getHandDescription());
                detail_desc.setText(card.getDescription());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void hand_5_click(ActionEvent event) {
        btnlistener(14, hand_5);
        Card card;
        if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
            card = this.p1.getACardAtHand(4);
        } else {
            card = this.p2.getACardAtHand(4);
        }
        if (card != null) {
            try {
                card_ava.setImage(new Image(new FileInputStream(card.getImagePath())));
                detail_title.setText(card.getName());
                detail_stats.setText(card.getHandDescription());
                detail_desc.setText(card.getDescription());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void nextAction(ActionEvent e) throws IOException {
        btnlistener(15, next_phase_btn);
//        Parent root = FXMLLoader.load(getClass().getResource(this.UI_PATH + "Draw.fxml"));
//        Scene scene = new Scene(root, 1280, 720);
//        stage.setScene(scene);
        nextPhase();
    }
    public void atkP1(ActionEvent event) {
        btnlistener(16, field_p1_ava_atk);
        try {
            card_ava.setImage(field_p1_ava.getImage());
            detail_title.setText(p1.getName());
            detail_stats.setText("Player 1");
            detail_desc.setText("Humanely Human");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void atkP2(ActionEvent e) {
        btnlistener(17, field_p2_ava_atk);
        try {
            card_ava.setImage(field_p2_ava.getImage());
            detail_title.setText(p2.getName());
            detail_stats.setText("Player 2");
            detail_desc.setText("Humanely Human");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
