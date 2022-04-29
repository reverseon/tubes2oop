package com.vtuberwars.card.ui;

import com.vtuberwars.VTuberWars;
import com.vtuberwars.model.card.Card;
import com.vtuberwars.model.cardspace.DrawHolder;
import com.vtuberwars.model.code.TurnPlayer;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawController extends VTuberWars implements Initializable {
    private DrawHolder deck;
    // button
    @FXML
    private Button fc_btn;
    @FXML private Button draw_1; @FXML private Button draw_2; @FXML private Button draw_3;
    // props
    @FXML private ImageView draw_1_img; @FXML private ImageView draw_2_img; @FXML private ImageView draw_3_img; @FXML private Label draw_1_desc; @FXML private Label draw_2_desc; @FXML private Label draw_3_desc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            fc_btn.requestFocus();
            if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
                deck = p1.getCardsAtDeck().getTop3Card();
            } else {
                deck = p2.getCardsAtDeck().getTop3Card();
            }
            ImageView[] draw_img = {draw_1_img, draw_2_img, draw_3_img};
            Label[] draw_desc = {draw_1_desc, draw_2_desc, draw_3_desc};
            Button[] draw_button = {draw_1, draw_2, draw_3};
            for (int i = 0; i < 3; i++) {
                final FadeTransition fadeIn = new FadeTransition(Duration.millis(100));
                fadeIn.setNode(draw_button[i]);
                fadeIn.setToValue(0.5);
                final FadeTransition fadeOut = new FadeTransition(Duration.millis(100));
                fadeOut.setNode(draw_button[i]);
                fadeOut.setToValue(1);
                draw_button[i].setOnMouseEntered(e->fadeIn.playFromStart());
                draw_button[i].setOnMouseExited(e->fadeOut.playFromStart());
               if (deck.getCard(i) != null) {
                   draw_img[i].setImage(new Image(new FileInputStream(deck.getCard(i).getImagePath())));
                   draw_button[i].setDisable(false);
                   draw_desc[i].setText("MANA: " + deck.getCard(i).getManaCost() + "\n\n" +deck.getCard(i).getDrawDescription());
               } else {
                   draw_img[i].setImage(null);
                   draw_button[i].setDisable(true);
                   draw_desc[i].setText("Empty");
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw_1_click(ActionEvent event) {
        try {
            if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
                p1.addToHand(deck.getCard(0), deck.getIndex(0));
            } else {
                p2.addToHand(deck.getCard(0), deck.getIndex(0));
            }
            switchToMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw_2_click(ActionEvent event) {
        try {
            if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
                p1.addToHand(deck.getCard(1), deck.getIndex(0));
            } else {
                p2.addToHand(deck.getCard(1), deck.getIndex(0));
            }
            switchToMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw_3_click(ActionEvent event) {
        try {
            if (whoseTurn.equals(TurnPlayer.PLAYER1)) {
                p1.addToHand(deck.getCard(2), deck.getIndex(0));
            } else {
                p2.addToHand(deck.getCard(2), deck.getIndex(0));
            }
            switchToMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
