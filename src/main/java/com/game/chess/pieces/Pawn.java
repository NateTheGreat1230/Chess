package com.game.chess.pieces;

import com.game.chess.Piece;
import com.game.chess.Position;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn() {
        type = "Pawn";
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current) {
        ArrayList<Position> possible = new ArrayList<>();
        if (current.getRow() == 1) {
            for (int i = 0; i < 2; i++) {
                int row = current.getRow();
                int column = current.getColumn();
                row++;
                possible.add(new Position(row, column));
            }
        } else {
            possible.add(new Position(current.getRow()+1, current.getColumn()));
        }
        possible.removeIf(position -> position.getRow() < 0);
        return possible;
    }
}
