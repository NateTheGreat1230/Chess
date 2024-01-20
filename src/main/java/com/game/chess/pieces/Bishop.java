package com.game.chess.pieces;

import com.game.chess.Board;
import com.game.chess.Piece;
import com.game.chess.Position;
import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(Team pieceTeam) {
        super(pieceTeam);
        type = "Bishop";
        if (pieceTeam.equals(Team.WHITE)) {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/white-bishop.png";
        } else {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/black-bishop.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current, Board board) {
        ArrayList<Position> possible = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            possible.add(new Position(current.getRow() + i, current.getColumn() + i));
            possible.add(new Position(current.getRow() + i, current.getColumn() - i));
            possible.add(new Position(current.getRow() - i, current.getColumn() + i));
            possible.add(new Position(current.getRow() - i, current.getColumn() - i));
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