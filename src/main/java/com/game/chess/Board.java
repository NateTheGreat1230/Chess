package com.game.chess;

import java.util.ArrayList;

public class Board {
    //ArrayList<Piece> board = new ArrayList<>();
    ArrayList<ArrayList<Piece>> board;
    public Board() {}
    public ArrayList<ArrayList<Piece>> newBoard() {
        //board = new ArrayList<>();
        Team white = new Team();
        white.makeTeam("WHITE");
        Team black = new Team();
        black.makeTeam("BLACK");
        //board.get(1).add(white.pawnsList.getFirst());
        //System.out.println(board.toString());
        return board;
    }
    public ArrayList<ArrayList<Piece>> getBoard() {
        return this.board;
    }
    public ArrayList<ArrayList<Piece>> drawBoard() {
        return this.board;
    }
}
