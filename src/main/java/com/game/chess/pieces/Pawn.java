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
            imgPath = "piecePics/white-pawn.png";
        } else {
            imgPath = "piecePics/black-pawn.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current, Board board) {
        ArrayList<Position> possible = new ArrayList<>();
        int direction = (pieceTeam == Team.WHITE) ? -1 : 1;
        Position forwardOne = new Position(current.getRow() + direction, current.getColumn());
        Position forwardTwo = new Position(current.getRow() + 2 * direction, current.getColumn());
        Position leftAttack = new Position(current.getRow() + direction, current.getColumn() - 1);
        Position rightAttack = new Position(current.getRow() + direction, current.getColumn() + 1);
        if (isValidMove(forwardOne, board)) {
            possible.add(forwardOne);
            if (current.getRow() == ((pieceTeam == Team.WHITE) ? 6 : 1) && isValidMove(forwardTwo, board)) {
                possible.add(forwardTwo);
            }
        }
        if (isValidAttack(leftAttack, board)) {
            possible.add(leftAttack);
        }
        if (isValidAttack(rightAttack, board)) {
            possible.add(rightAttack);
        }
        if (!enPassant(current, board).equals("False")) {
            if (enPassant(current, board).equals("Right")) {
                possible.add(rightAttack);
                canEnpassant = true;
            } else {
                possible.add(leftAttack);
                canEnpassant = true;
            }
        }
        return possible;
    }
    private String enPassant(Position current, Board board) {
        if (pieceTeam.equals(Team.WHITE)) {
            if (current.getRow() == 3) {
                if (current.getColumn() != 0 && board.getPiece(new Position(3, current.getColumn() - 1)).type.equals("Pawn")) {
                    return "Left";
                } else if (current.getColumn() != 7 && board.getPiece(new Position(3, current.getColumn() + 1)).type.equals("Pawn")) {
                    return "Right";
                }
            }
        } else if (pieceTeam.equals(Team.BLACK)){
            if (current.getRow() == 4) {
                if (current.getColumn() != 0 && board.getPiece(new Position(4, current.getColumn() - 1)).type.equals("Pawn")) {
                    return "Left";
                } else if (current.getColumn() != 7 && board.getPiece(new Position(4, current.getColumn() + 1)).type.equals("Pawn")) {
                    return "Right";
                }
            }
        }
        return "False";
    }
    private boolean isValidMove(Position position, Board board) {
        return position.getRow() >= 0 && position.getRow() <= 7 && position.getColumn() >= 0 &&
               position.getColumn() <= 7 && board.getPiece(position).pieceTeam.equals(Team.BLANK);
    }
    private boolean isValidAttack(Position position, Board board) {
        return position.getRow() >= 0 && position.getRow() <= 7 && position.getColumn() >= 0 &&
               position.getColumn() <= 7 && !board.getPiece(position).pieceTeam.equals(Team.BLANK) &&
               !board.getPiece(position).pieceTeam.equals(this.pieceTeam);
    }
}