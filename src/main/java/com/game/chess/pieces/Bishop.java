package com.game.chess.pieces;

import com.game.chess.Piece;
import com.game.chess.Position;
import com.game.chess.Team;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(Team pieceTeam) {
        super(pieceTeam);
        type = "Bishop";
    }

    @Override
    public ArrayList<Position> getValidMoves(Position current) {
        ArrayList<Position> validMoves = new ArrayList<>();

        // Implement valid moves for the bishop
        // For example, diagonal movements
        for (int i = 1; i <= 7; i++) {
            validMoves.add(new Position(current.getRow() + i, current.getColumn() + i));
            validMoves.add(new Position(current.getRow() + i, current.getColumn() - i));
            validMoves.add(new Position(current.getRow() - i, current.getColumn() + i));
            validMoves.add(new Position(current.getRow() - i, current.getColumn() - i));
        }

        // Filter out invalid moves (outside the board)
        validMoves.removeIf(position ->
                position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);

        return validMoves;
    }
}
