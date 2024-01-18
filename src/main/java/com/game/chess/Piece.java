package com.game.chess;

import java.util.ArrayList;

public class Piece {
    final Team pieceTeam;
    public abstract List<Move> findPossibleMoves(Board board);
    Piece(Team pieceTeam) {
        this.pieceTeam = pieceTeam;
    }
    public Team getPieceTeam() {
        return this.pieceTeam;
    }

}
class Knight extends Piece {
    ArrayList<Integer> moves = new ArrayList<>();
    Knight() {

        super();
    }
}