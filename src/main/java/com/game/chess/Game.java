package com.game.chess;

import java.util.ArrayList;

public class Game {
    boolean isWhiteTurn = true;
    Game game;
    private ChessController controller;  // Reference to the ChessController instance

    public Game(ChessController controller) {
        this.controller = controller;
    }
    public Game() {}
//    public Game(Game game) {
//        this.game = game;
//    }
    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }
    public void changeTurn() {
        if (isWhiteTurn) {
            isWhiteTurn = false;
        } else {
            isWhiteTurn = true;
        }
    }
    public void initGame(Game game) {
        this.game = game;
        Board board = new Board();
        board.board = board.newBoard();
        System.out.println("Set buttons");
        controller.setButtons();
        //controller.draw(board.drawBoard());
    }
    public Game getGame() {
        return this.game;
    }
    public void turn(Team team) {
        //team.getPieces();
        game = game.getGame();
        if (game.isWhiteTurn) {
            System.out.println("White Turn");
            game.changeTurn();
        } else {
            System.out.println("Black Turn");
            game.changeTurn();
        }
    }
}
