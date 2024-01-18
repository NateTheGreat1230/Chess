package com.game.chess;

import java.util.ArrayList;

public class Piece {
    final Team pieceTeam = null;
    public String type = null;
    //public abstract List<Move> findPossibleMoves(Board board);
    public Piece() {}
    Piece(Team pieceTeam) {
        //this.pieceTeam = pieceTeam;
    }
    public ArrayList<Position> getValidMoves(Position current) {
        return new ArrayList<>();
    }
    public String getType() {
        return this.type;
    }
}
//    public static Team getPieceTeam() {
//        return pieceTeam;
//    }
