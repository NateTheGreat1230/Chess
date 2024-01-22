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
            imgPath = "piecePics/white-rook.png";
        } else {
            imgPath = "piecePics/black-rook.png";
        }
    }
    @Override
    public ArrayList<Position> getValidMoves(Position current, Board board) {
        ArrayList<Position> possibleUp = new ArrayList<>();
        ArrayList<Position> possibleDn = new ArrayList<>();
        ArrayList<Position> possibleR = new ArrayList<>();
        ArrayList<Position> possibleL = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            possibleUp.add(new Position(current.getRow() + i, current.getColumn()));
            possibleDn.add(new Position(current.getRow() - i, current.getColumn()));
            possibleR.add(new Position(current.getRow(), current.getColumn() + i));
            possibleL.add(new Position(current.getRow(), current.getColumn() - i));
        }
        possibleUp.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        possibleDn.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        possibleR.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        possibleL.removeIf(position -> position.getRow() < 0 || position.getRow() > 7 || position.getColumn() < 0 || position.getColumn() > 7);
        ArrayList<Position> valid = new ArrayList<>();
        for (Position position : possibleUp) {
            String temp = checkDirection(position, board);
            if (temp == null) {
                valid.add(position);
            } else if (temp.equals("Opposite")){
                valid.add(position);
                break;
            } else {
                break;
            }
        }
        for (Position position : possibleDn) {
            String temp = checkDirection(position, board);
            if (temp == null) {
                valid.add(position);
            } else if (temp.equals("Opposite")){
                valid.add(position);
                break;
            } else {
                break;
            }
        }
        for (Position position : possibleR) {
            String temp = checkDirection(position, board);
            if (temp == null) {
                valid.add(position);
            } else if (temp.equals("Opposite")){
                valid.add(position);
                break;
            } else {
                break;
            }
        }
        for (Position position : possibleL) {
            String temp = checkDirection(position, board);
            if (temp == null) {
                valid.add(position);
            } else if (temp.equals("Opposite")){
                valid.add(position);
                break;
            } else {
                break;
            }
        }
        return valid;
    }
    private String checkDirection(Position position, Board board) {
        Piece piece = board.getPiece(position);
        if (piece.pieceTeam.equals(this.pieceTeam)) {
            return "Same";
        } else if (piece.pieceTeam.equals(Team.BLANK)) {
            return null;
        } else {
            return "Opposite";
        }
    }
}