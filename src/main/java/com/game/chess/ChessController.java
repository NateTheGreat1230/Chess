package com.game.chess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Collections;

public class ChessController {
    Game game = new Game();
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
    private ArrayList<ArrayList<Button>> buttons;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        String imagePath = "-fx-background-image: url('file:src/main/resources/com/game/chess/piecePics/";
        if (event.getSource() instanceof Button clickedButton) {
            String buttonId = clickedButton.getId();
            System.out.println("Button Clicked: " + buttonId);
            clickedButton.setStyle(imagePath + "white-king.png');");
        }
    }
    @FXML
    public void restart() {
        System.out.println("Restart game");
        clearBoard();
        game.initGame(game);
        draw(game.board.board);
    }
    public void draw(ArrayList<ArrayList<Piece>> arrayLists) {
        String imagePath = "-fx-background-image: url('file:src/main/resources/com/game/chess/piecePics/";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = arrayLists.get(i).get(j);
                if (piece.pieceTeam.equals(Piece.Team.BLACK)) {
                    switch (piece.type) {
                        case "Pawn" ->
                                buttons.get(i).get(j).setStyle(imagePath + "black-pawn.png');");
                        case "Rook" ->
                                buttons.get(i).get(j).setStyle(imagePath + "black-rook.png');");
                        case "Knight" ->
                                buttons.get(i).get(j).setStyle(imagePath + "black-knight.png');");
                        case "Bishop" ->
                                buttons.get(i).get(j).setStyle(imagePath + "black-bishop.png');");
                        case "Queen" ->
                                buttons.get(i).get(j).setStyle(imagePath + "black-queen.png');");
                        case "King" ->
                                buttons.get(i).get(j).setStyle(imagePath + "black-king.png');");
                    }
                } else if (piece.pieceTeam.equals(Piece.Team.WHITE)) {
                    switch (piece.type) {
                        case "Pawn" ->
                                buttons.get(i).get(j).setStyle(imagePath + "white-pawn.png');");
                        case "Rook" ->
                                buttons.get(i).get(j).setStyle(imagePath + "white-rook.png');");
                        case "Knight" ->
                                buttons.get(i).get(j).setStyle(imagePath + "white-knight.png');");
                        case "Bishop" ->
                                buttons.get(i).get(j).setStyle(imagePath + "white-bishop.png');");
                        case "Queen" ->
                                buttons.get(i).get(j).setStyle(imagePath + "white-queen.png');");
                        case "King" ->
                                buttons.get(i).get(j).setStyle(imagePath + "white-king.png');");
                    }
                } else {
                    buttons.get(i).get(j).setStyle("-fx-background-image: null;");
                }
            }
        }
    }
    public void setButtons() {
        buttons = new ArrayList<>();
        buttons.add(createRow(buttonA1, buttonB1, buttonC1, buttonD1, buttonE1, buttonF1, buttonG1, buttonH1));
        buttons.add(createRow(buttonA2, buttonB2, buttonC2, buttonD2, buttonE2, buttonF2, buttonG2, buttonH2));
        buttons.add(createRow(buttonA3, buttonB3, buttonC3, buttonD3, buttonE3, buttonF3, buttonG3, buttonH3));
        buttons.add(createRow(buttonA4, buttonB4, buttonC4, buttonD4, buttonE4, buttonF4, buttonG4, buttonH4));
        buttons.add(createRow(buttonA5, buttonB5, buttonC5, buttonD5, buttonE5, buttonF5, buttonG5, buttonH5));
        buttons.add(createRow(buttonA6, buttonB6, buttonC6, buttonD6, buttonE6, buttonF6, buttonG6, buttonH6));
        buttons.add(createRow(buttonA7, buttonB7, buttonC7, buttonD7, buttonE7, buttonF7, buttonG7, buttonH7));
        buttons.add(createRow(buttonA8, buttonB8, buttonC8, buttonD8, buttonE8, buttonF8, buttonG8, buttonH8));
    }
    private ArrayList<Button> createRow(Button... buttons) {
        ArrayList<Button> rowButtons = new ArrayList<>();
        Collections.addAll(rowButtons, buttons);
        return rowButtons;
    }
    public void clearBoard() {
        if (buttons != null) {
            for (ArrayList<Button> buttonArray : buttons) {
                for (Button button : buttonArray) {
                    button.setStyle("-fx-background-image: null;");
                }
            }
        }
    }
}
