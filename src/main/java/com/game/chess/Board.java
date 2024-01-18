package com.game.chess;

import java.util.ArrayList;

public class Board {
    //ArrayList<Piece> board = new ArrayList<>();
    ArrayList<ArrayList<String>> board;
    public Board(ArrayList<Piece> board1) {
        this.board = board1;

        //Game.changeTurn();
    }
}
