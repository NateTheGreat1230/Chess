package com.game.chess;

import java.util.ArrayList;

public class Board {
    ArrayList<ArrayList<Piece>> board;

    public Board() {
        this.board = newBoard();
    }

    public ArrayList<ArrayList<Piece>> newBoard() {
        board = new ArrayList<>();

        // Initialize the board with null values
        for (int i = 0; i < 8; i++) {
            ArrayList<Piece> row = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                row.add(null);
            }
            board.add(row);
        }

        // Add white pieces
        Team whiteTeam = new Team("WHITE");
        whiteTeam.makeTeam();
        addTeamToBoard(whiteTeam, 0);

        // Add black pieces
        Team blackTeam = new Team("BLACK");
        blackTeam.makeTeam();
        addTeamToBoard(blackTeam, 7);

        return board;
    }

    private void addTeamToBoard(Team team, int row) {
        addPiece(row, 0, team.rooksList.getFirst());
        addPiece(row, 1, team.knightsList.getFirst());
        addPiece(row, 2, team.bishopsList.getFirst());
        addPiece(row, 3, team.queensList.getFirst());
        addPiece(row, 4, team.kingsList.getFirst());
        addPiece(row, 5, team.bishopsList.get(1));
        addPiece(row, 6, team.knightsList.get(1));
        addPiece(row, 7, team.rooksList.get(1));

        for (int i = 0; i < 8; i++) {
            addPiece(row + 1, i, team.pawnsList.get(i));
        }
    }
    private void addPiece(int row, int col, Piece piece) {
        ArrayList<Piece> targetRow = board.get(row);
        targetRow.set(col, piece);
    }
    public ArrayList<ArrayList<Piece>> getBoard() {
        return this.board;
    }
    public ArrayList<ArrayList<Piece>> drawBoard() {
        return this.board;
    }
}
