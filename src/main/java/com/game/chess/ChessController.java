package com.game.chess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ChessController {
    public Label errorSpot;
    @FXML
    private Button buttonA1, buttonB1, buttonC1, buttonD1, buttonE1, buttonF1, buttonG1, buttonH1,
            buttonA2, buttonB2, buttonC2, buttonD2, buttonE2, buttonF2, buttonG2, buttonH2,
            buttonA3, buttonB3, buttonC3, buttonD3, buttonE3, buttonF3, buttonG3, buttonH3,
            buttonA4, buttonB4, buttonC4, buttonD4, buttonE4, buttonF4, buttonG4, buttonH4,
            buttonA5, buttonB5, buttonC5, buttonD5, buttonE5, buttonF5, buttonG5, buttonH5,
            buttonA6, buttonB6, buttonC6, buttonD6, buttonE6, buttonF6, buttonG6, buttonH6,
            buttonA7, buttonB7, buttonC7, buttonD7, buttonE7, buttonF7, buttonG7, buttonH7,
            buttonA8, buttonB8, buttonC8, buttonD8, buttonE8, buttonF8, buttonG8, buttonH8;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() instanceof Button clickedButton) {
            String buttonId = clickedButton.getId();
            System.out.println("Button Clicked: " + buttonId);
        }
    }
    @FXML
    public void restart() {
        System.out.println("Restart game");

    }
}
