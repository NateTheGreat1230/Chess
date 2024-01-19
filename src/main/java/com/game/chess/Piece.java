package com.game.chess;

import java.util.ArrayList;

public class Piece {
    // Add the Team enum here
    public enum Team {
        WHITE, BLACK
    }

    // Add the team property and set it in the constructor
    protected final Team pieceTeam;
    public String type;

    // Add a constructor to set the team
    public Piece(Team pieceTeam) {
        this.pieceTeam = pieceTeam;
    }

    public ArrayList<Position> getValidMoves(Position current) {
        return new ArrayList<>();
    }

    public String getType() {
        return "";
    }
}
