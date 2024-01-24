package com.game.chess.pieces;

import com.game.chess.Board;
import com.game.chess.Piece;
import com.game.chess.Position;
import java.util.ArrayList;

public class King extends Piece {
    public King(Team pieceTeam) {
        super(pieceTeam);
        type = "King";
        if (pieceTeam.equals(Team.WHITE)) {
            imgPath = "piecePics/white-king.png";
        } else {
            imgPath = "piecePics/black-king.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current, Board board) {
        ArrayList<Position> possible = new ArrayList<>();
        int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] move : moves) {
            int newRow = current.getRow() + move[0];
            int newCol = current.getColumn() + move[1];
            possible.add(new Position(newRow, newCol));
        }
        possible.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        ArrayList<Position> valid = new ArrayList<>();
        for (Position position : possible) {
            Piece piece = board.getPiece(position);
            if (piece.pieceTeam.equals(Team.BLANK)) {
                valid.add(position);
            } else if (!piece.pieceTeam.equals(this.pieceTeam)) {
                valid.add(position);
            }
        }
        if (!canCastle(current, board).equals("False")) {
            if (canCastle(current, board).equals("Right")) {
                valid.add(new Position(current.getRow(), current.getColumn() + 2));
                castle = true;
            } else {
                valid.add(new Position(current.getRow(), current.getColumn() - 3));
                castle = true;
            }
        }
        return valid;
    }
    private String canCastle(Position current, Board board) {
        if (pieceTeam.equals(Team.WHITE) && current.toString().equals(new Position(7, 4).toString())) {
            if (board.getPiece(new Position(7, 5)).type.equals("Blank") && board.getPiece(new Position(7, 6)).type.equals("Blank") && board.getPiece(new Position(7, 7)).type.equals("Rook")) {
                return "Right";
            } else if (board.getPiece(new Position(7, 3)).type.equals("Blank") && board.getPiece(new Position(7, 2)).type.equals("Blank") && board.getPiece(new Position(7, 1)).type.equals("Blank") && board.getPiece(new Position(7, 0)).type.equals("Rook")) {
                return "Left";
            }
        } else if (pieceTeam.equals(Team.BLACK) && current.toString().equals(new Position(0, 4).toString())) {
            if (board.getPiece(new Position(0, 5)).type.equals("Blank") && board.getPiece(new Position(0, 6)).type.equals("Blank") && board.getPiece(new Position(0, 7)).type.equals("Rook")) {
                return "Right";
            } else if (board.getPiece(new Position(0, 3)).type.equals("Blank") && board.getPiece(new Position(0, 2)).type.equals("Blank") && board.getPiece(new Position(0, 1)).type.equals("Blank") && board.getPiece(new Position(0, 0)).type.equals("Rook")) {
                return "Left";
            }
        }
        return "False";
    }
}