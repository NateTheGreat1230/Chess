package com.game.chess.pieces;

import com.game.chess.Board;
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
    public ArrayList<Position> getValidMoves(Position current, Board board) {
        ArrayList<Position> possible = new ArrayList<>();
        int direction = (pieceTeam == Team.WHITE) ? -1 : 1;
        possible.add(new Position(current.getRow() + direction, current.getColumn()));
        if (current.getRow() == ((pieceTeam == Team.WHITE) ? 6 : 1)) {
            possible.add(new Position(current.getRow() + 2 * direction, current.getColumn()));
        }
        possible.add(new Position(current.getRow() + direction, current.getColumn() + 1));
        possible.add(new Position(current.getRow() + direction, current.getColumn() - 1));
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