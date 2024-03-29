package com.game.chess.pieces;

import com.game.chess.Board;
import com.game.chess.Piece;
import com.game.chess.Position;
import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Team pieceTeam) {
        super(pieceTeam);
        type = "Knight";
        if (pieceTeam.equals(Team.WHITE)) {
            imgPath = "piecePics/white-knight.png";
        } else {
            imgPath = "piecePics/black-knight.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current, Board board) {
        ArrayList<Position> possible = new ArrayList<>();
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
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
        return valid;
    }
}