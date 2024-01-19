package com.game.chess;

import java.util.ArrayList;

public class Piece {
    public enum Team {
        WHITE, BLACK, BLANK
    }
    protected final Team pieceTeam;
    public String type;
    public Piece(Team pieceTeam) {this.pieceTeam = pieceTeam;}
    public ArrayList<Position> getValidMoves(Position current) {return new ArrayList<>();}
    public String getType() {return type;}
}