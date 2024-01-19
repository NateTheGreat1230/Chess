package com.game.chess.pieces;

import com.game.chess.Piece;
import com.game.chess.Position;
import com.game.chess.Team;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Team pieceTeam) {
        super(pieceTeam);
        type = "Queen";
    }

    @Override
    public ArrayList<Position> getValidMoves(Position current) {
        ArrayList<Position> validMoves = new ArrayList<>();

        // Implement valid moves for the queen
        // Combining movements of rook and bishop
        for (int i = 1; i <= 7; i++) {
            // Rook-like movements (horizontal and vertical)
            validMoves.add(new Position(current.getRow() + i, current.getColumn()));
            validMoves.add(new Position(current.getRow() - i, current.getColumn()));
            validMoves.add(new Position(current.getRow(), current.getColumn() + i));
            validMoves.add(new Position(current.getRow(), current.getColumn() - i));

            // Bishop-like movements (diagonal)
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
