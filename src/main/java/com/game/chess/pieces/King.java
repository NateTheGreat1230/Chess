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
            } else {
                valid.add(new Position(current.getRow(), current.getColumn() - 2));
            }
        }
        return valid;
    }
    private String canCastle(Position current, Board board) {
        int row = current.getRow();
        int column = current.getColumn();
        if (board.getPiece(new Position(row, column - 1)).type.equals("Blank") && board.getPiece(new Position(row, column - 2)).type.equals("Blank")) {
            return "Left";
        } else if (board.getPiece(new Position(row, column + 1)).type.equals("Blank") && board.getPiece(new Position(row, column + 2)).type.equals("Blank")) {
            return "Right";
        }
        return "False";
    }
}