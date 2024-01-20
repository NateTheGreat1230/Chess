package com.game.chess;

import com.game.chess.pieces.Blank;

public class Game {
    private boolean isWhiteTurn = true;
    private Game game;
    Board board = new Board();
    ChessController controller;
    public Game(ChessController controller) {this.controller = controller;}
    public Game() {}
    public boolean isWhiteTurn() {return isWhiteTurn;}
    public void changeTurn() {isWhiteTurn = !isWhiteTurn;}
    public void setController(ChessController controller) {this.controller = controller;}
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
    public void takeTurn(Piece piece, Position start, Position end) {
        board.addPiece(start.getRow(), start.getColumn(), new Blank(Piece.Team.BLANK));
        board.addPiece(end.getRow(), end.getColumn(), piece);
        if (checkMate(piece.pieceTeam)) {
            System.out.println(piece.pieceTeam + " wins!");
            //win screen
        } else {
            changeTurn();
        }
    }
    public boolean checkMate(Piece.Team team) {
        Position kingPosition = findKingPosition(team);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position currentPos = new Position(row, col);
                Piece currentPiece = board.getPiece(currentPos);
                if (currentPiece != null && !currentPiece.pieceTeam.equals(team)) {
                    if (currentPiece.isValidMove(currentPos, kingPosition, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private Position findKingPosition(Piece.Team team) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position currentPos = new Position(row, col);
                Piece currentPiece = board.getPiece(currentPos);
                if (currentPiece != null && currentPiece.type.equals("King") && currentPiece.pieceTeam.equals(team)) {
                    return currentPos;
                }
            }
        }
        return null;
    }
}