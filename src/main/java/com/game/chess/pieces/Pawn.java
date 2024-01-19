package com.game.chess.pieces;

import com.game.chess.Piece;
import com.game.chess.Position;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(Team pieceTeam) {
        super(pieceTeam);
        type = "Pawn";
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current) {
        ArrayList<Position> possible = new ArrayList<>();
        int direction = (pieceTeam == Team.WHITE) ? 1 : -1;

        // Allow moving one step forward
        possible.add(new Position(current.getRow() + direction, current.getColumn()));

        // Allow moving two steps forward on the first move
        if (current.getRow() == ((pieceTeam == Team.WHITE) ? 1 : 6)) {
            possible.add(new Position(current.getRow() + 2 * direction, current.getColumn()));
        }

        // Allow capturing diagonally
        possible.add(new Position(current.getRow() + direction, current.getColumn() + 1));
        possible.add(new Position(current.getRow() + direction, current.getColumn() - 1));

        // Remove invalid moves
        possible.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);

        return possible;
    }
//    @Override
//    public ArrayList<Position> getValidMoves(Position current) {
//
//        ArrayList<Position> possible = new ArrayList<>();
//        int direction = (pieceTeam == Team.WHITE) ? 1 : -1;
//
//        // Allow moving one step forward
//        possible.add(new Position(current.getRow() + direction, current.getColumn()));
//
//        // Allow moving two steps forward on the first move
//        if (current.getRow() == ((pieceTeam == Team.WHITE) ? 1 : 6)) {
//            possible.add(new Position(current.getRow() + 2 * direction, current.getColumn()));
//        }
//
//        // Allow capturing diagonally
//        possible.add(new Position(current.getRow() + direction, current.getColumn() + 1));
//        possible.add(new Position(current.getRow() + direction, current.getColumn() - 1));
//
//        // Remove invalid moves
//        possible.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
//
//        return possible;
//
////        ArrayList<Position> possible = new ArrayList<>();
////        if (current.getRow() == 1) {
////            for (int i = 0; i < 2; i++) {
////                int row = current.getRow();
////                int column = current.getColumn();
////                row++;
////                possible.add(new Position(row, column));
////            }
////        } else {
////            possible.add(new Position(current.getRow()+1, current.getColumn()));
////        }
////        possible.removeIf(position -> position.getRow() < 0);
////        return possible;
//    }
}
