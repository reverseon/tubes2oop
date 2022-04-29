package com.vtuberwars.card.ui;

import com.vtuberwars.VTuberWars;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class YeayController extends VTuberWars implements Initializable {
    @FXML
    private Button exit_btn;
    @FXML
    private Label after_msg;
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        String msg = "CONGRATS\n" +
                winner.toUpperCase() + "\n" +
                "YOU WON\n" +
                "VTUBERWARS\n" +
                "SADLY\n" +
                "NO ONE CARES";
        after_msg.setText(msg);
    }
    public void exitButtonHandler(ActionEvent e) {
        System.exit(0);
        Stage stage = (Stage) exit_btn.getScene().getWindow();
        stage.close();
    }
}
