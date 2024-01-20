package com.game.chess;

import com.game.chess.pieces.Blank;

import java.util.ArrayList;

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
        Piece endPiece = board.getPiece(end);
        if (endPiece.pieceTeam.equals(Piece.Team.BLANK)) {
        } else {
            if (endPiece.pieceTeam.equals(Piece.Team.WHITE)) {
                board.whiteTeamList.remove(endPiece);
            } else {
                board.blackTeamList.remove(endPiece);
            }
        }
        board.addPiece(start.getRow(), start.getColumn(), new Blank(Piece.Team.BLANK));
        board.addPiece(end.getRow(), end.getColumn(), piece);
        //changeTurn();
    }
    public boolean checkWin() {
        if (!isWhiteTurn()) {
            return checkMate(Piece.Team.WHITE);
        } else {
            return checkMate(Piece.Team.BLACK);
        }
    }
    public boolean checkMate(Piece.Team team) {
        Position kingPosition = findKingPosition(team);
        if (kingPosition == null) {
            return true;
        }
        ArrayList<Piece> enemies;
        if (!team.equals(Piece.Team.WHITE)) {
            enemies = board.whiteTeamList;
        } else {
            enemies = board.blackTeamList;
        }
        for (Piece enemy : enemies) {
            if (enemy.isValidMove(board.getPiecePosition(enemy), kingPosition, board)) {
                System.out.println("Check");
                if (board.getPiece(kingPosition).getValidMoves(kingPosition, board).equals(new ArrayList<>())) {
                    System.out.println("Check mate");
                    return true;
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