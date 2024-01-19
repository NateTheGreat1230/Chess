package com.game.chess;

public class Game {
    boolean isWhiteTurn = true;
    Game game;
    Board board = new Board();
    ChessController controller;

    public Game(ChessController controller) {
        this.controller = controller;
    }
    public Game() {}
    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }
    public void changeTurn() {
        isWhiteTurn = !isWhiteTurn;
    }
    public void setController(ChessController controller) {
        this.controller = controller;
    }
    public void initGame(Game game) {
        this.game = game;
        setController(controller);
        board.board = board.newBoard();
        controller.draw(board.getBoard());
    }
    public Game getGame() {
        return this.game;
    }
    public void turn(Team team) {
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