package com.game.chess.pieces;

import com.game.chess.Piece;

public class Blank extends Piece {
    public Blank(Team pieceTeam) {
        super(pieceTeam);
        type = "Blank";
    }
}