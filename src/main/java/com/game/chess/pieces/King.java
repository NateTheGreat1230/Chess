package com.game.chess.pieces;

import com.game.chess.Piece;
import com.game.chess.Position;
import java.util.ArrayList;

public class King extends Piece {
    public King(Team pieceTeam) {
        super(pieceTeam);
        type = "King";
        if (pieceTeam.equals(Team.WHITE)) {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/white-king.png";
        } else {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/black-king.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current) {
        ArrayList<Position> possible = new ArrayList<>();
        int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] move : moves) {
            int newRow = current.getRow() + move[0];
            int newCol = current.getColumn() + move[1];
            possible.add(new Position(newRow, newCol));
        }
        possible.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        return possible;
    }
}