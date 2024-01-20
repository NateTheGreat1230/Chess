package com.game.chess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Window;
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
        draw(game.board.getBoard());
        setDefaultButtonListener();
        if (event.getSource() instanceof Button clickedButton) {
            String buttonId = clickedButton.getId();
            Position clicked = getPosition(buttonId);
            Piece piece = game.board.getPiece(clicked);
            if (game.isWhiteTurn() && piece.pieceTeam.equals(Piece.Team.WHITE) || !game.isWhiteTurn() && piece.pieceTeam.equals(Piece.Team.BLACK)) {
                ArrayList<Position> moves = piece.getValidMoves(clicked, game.board);
                if (piece.type.equals("King")) {
                    moves = game.checkKingMoves(piece, moves);
                }
                for (Position position : moves) {
                    Button button = getButton(position);
                    String image = button.getStyle();
                    if (button.getStyleClass().get(2).equals("even")) {
                        button.setStyle("-fx-background-color: #501c8c;" + image);
                    } else {
                        button.setStyle("-fx-background-color: #8e53d4;" + image);
                    }
                    button.setOnAction((event2) -> {
                        Button source = (Button) event2.getSource();
                        Position selectedPosition = getPosition(source.getId());
                        executeMove(clicked, selectedPosition, piece);
                    });
                }
                errorSpot.setText("");
            } else {
                errorSpot.setText("Pick a different piece.");
            }
        }
    }
    @FXML
    public void restart() {
        clearBoard();
        game.setController(this.game.controller);
        game.clearBoard();
        draw(game.board.getBoard());
        setDefaultButtonListener();
    }
    public void draw(ArrayList<ArrayList<Piece>> arrayLists) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = arrayLists.get(i).get(j);
                if (piece.type.equals("Blank")) {
                    buttons.get(i).get(j).setStyle("-fx-background-image: null;");
                } else {
                    buttons.get(i).get(j).setStyle("-fx-background-image: url('" + piece.imgPath + "');");
                }
            }
        }
    }
    public void showWin(Piece.Team team) {
        Label label;
        if (team.equals(Piece.Team.WHITE)) {
            label = new Label("White team wins!");
        } else {
            label = new Label("Black team wins!");
        }
        Popup popup = new Popup();
        VBox vbox = new VBox();
        Button button = new Button("Play Again");
        Button button1 = new Button("Close");
        button.getStyleClass().addAll("win-button");
        button1.getStyleClass().addAll("win-button");
        label.getStyleClass().addAll("win-label");
        vbox.getStyleClass().addAll("win-screen");
        vbox.getChildren().add(label);
        vbox.getChildren().add(button);
        vbox.getChildren().add(button1);
        popup.getContent().add(vbox);
        label.setMinWidth(200);
        label.setAlignment(Pos.CENTER);
        label.setMinHeight(50);
        Window window = errorSpot.getScene().getWindow();
        popup.show(window);
        button.setOnMouseClicked(mouseEvent -> {
            restart();
            popup.hide();
        });
        button1.setOnMouseClicked(mouseEvent -> popup.hide());
    }
    private void executeMove(Position start, Position end, Piece piece) {
        game.takeTurn(piece, start, end);
        draw(game.board.getBoard());
        setDefaultButtonListener();
        if (game.checkWin()) {
            freezeBoard();
            showWin(piece.pieceTeam);
        }
        game.changeTurn();
        Piece.Team team = game.getTurn();
        if (game.kingInCheck(team, game.findKingPosition(team))) {
            errorSpot.setText("Your in Check");
        }
    }
    private void freezeBoard() {
        for (ArrayList<Button> buttonArray : buttons) {
            for (Button button : buttonArray) {
                button.setOnAction(null);
            }
        }
    }
    private void setDefaultButtonListener() {
        for (ArrayList<Button> buttonArray : buttons) {
            for (Button button : buttonArray) {
                button.setOnAction(this::handleButtonClick);
            }
        }
    }
    public Position getPosition(String string) {
        char columnChar = string.charAt(6);
        int row = Integer.parseInt(string.substring(7));
        int column = columnChar - 'A';
        return new Position(row - 1, column);
    }
    public Button getButton(Position position) {return buttons.get(position.getRow()).get(position.getColumn());}
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