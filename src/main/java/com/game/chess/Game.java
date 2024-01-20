package com.game.chess;

import com.game.chess.pieces.Blank;

public class Game {
    private boolean isWhiteTurn = true;
    private Game game;
    Board board = new Board();
    ChessController controller;
    public Game(ChessController controller) {
        this.controller = controller;
    }
    public Game() {}
    public boolean isWhiteTurn() {return isWhiteTurn;}
    public void changeTurn() {
        isWhiteTurn = !isWhiteTurn;
    }
    public void setController(ChessController controller) {
        this.controller = controller;
    }
    public void initGame(Game game) {
        this.game = game;
        setController(controller);
        clearBoard();
        controller.draw(board.getBoard());
    }
    public void clearBoard() {
        board.board = board.newBoard();
        isWhiteTurn = true;
    }
    public Game getGame() {return this.game;}
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
    public void takeTurn(Piece piece, Position start, Position end) {
        board.addPiece(start.getRow(), start.getColumn(), new Blank(Piece.Team.BLANK));
        board.addPiece(end.getRow(), end.getColumn(), piece);
        changeTurn();
    }
}