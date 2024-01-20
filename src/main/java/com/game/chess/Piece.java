package com.game.chess;

import java.util.ArrayList;

public class Piece {
    public enum Team {WHITE, BLACK, BLANK}
    public String imgPath;
    public final Team pieceTeam;
    public String type;
    public Piece(Team pieceTeam) {this.pieceTeam = pieceTeam;}
    public ArrayList<Position> getValidMoves(Position current, Board board) {return new ArrayList<>();}
    public boolean isValidMove(Position from, Position to, Board board){
        ArrayList<Position> moves = getValidMoves(from, board);
        for (Position position : moves) {
            if (to.toString().equals(position.toString())) {
                return true;
            }
        }
        return false;
    }
    public String getType() {return type;}
}