package com.vtuberwars.util;

import com.vtuberwars.model.card.*;
import com.vtuberwars.model.cardspace.*;
import com.vtuberwars.model.player.*;

public class GameBoard {
    Player player1;
    Player player2;
    int round;

    public GameBoard() {
        this.player1 = new Player("");
        this.player2 = new Player("");

    }

    public GameBoard getInstance() {
        GameBoard gb = new GameBoard();
        return gb;
    }

    public void doATurn(Player PlayerTurnNow,Player PlayerVersus) {

    }

    public void main() {

    }

    public void attack(Player playerNow ,Player playerEnemy , int ourFieldPosition , int enemyFieldPosition) {

    }
}
