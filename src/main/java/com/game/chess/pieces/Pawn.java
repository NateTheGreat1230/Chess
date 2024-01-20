package com.game.chess.pieces;

import com.game.chess.Piece;
import com.game.chess.Position;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(Team pieceTeam) {
        super(pieceTeam);
        type = "Pawn";
        if (pieceTeam.equals(Team.WHITE)) {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/white-pawn.png";
        } else {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/black-pawn.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current) {
        ArrayList<Position> possible = new ArrayList<>();
        int direction = (pieceTeam == Team.WHITE) ? -1 : 1;
        possible.add(new Position(current.getRow() + direction, current.getColumn()));
        if (current.getRow() == ((pieceTeam == Team.WHITE) ? 6 : 1)) {
            possible.add(new Position(current.getRow() + 2 * direction, current.getColumn()));
        }
        possible.add(new Position(current.getRow() + direction, current.getColumn() + 1));
        possible.add(new Position(current.getRow() + direction, current.getColumn() - 1));
        possible.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        return possible;
    }
}