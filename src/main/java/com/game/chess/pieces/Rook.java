package com.game.chess.pieces;

import com.game.chess.Board;
import com.game.chess.Piece;
import com.game.chess.Position;
import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Team pieceTeam) {
        super(pieceTeam);
        type = "Rook";
        if (pieceTeam.equals(Team.WHITE)) {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/white-rook.png";
        } else {
            imgPath = "file:src/main/resources/com/game/chess/piecePics/black-rook.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current, Board board) {
        ArrayList<Position> validMoves = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            validMoves.add(new Position(current.getRow() + i, current.getColumn()));
            validMoves.add(new Position(current.getRow() - i, current.getColumn()));
            validMoves.add(new Position(current.getRow(), current.getColumn() + i));
            validMoves.add(new Position(current.getRow(), current.getColumn() - i));
        }
        validMoves.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        return validMoves;
    }
}