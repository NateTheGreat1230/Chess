package com.game.chess;

import com.game.chess.pieces.Blank;
import java.util.ArrayList;

public class Board {
    public ArrayList<ArrayList<Piece>> board;
    public ArrayList<Piece> blackTeamList = new ArrayList<>();
    public ArrayList<Piece> whiteTeamList = new ArrayList<>();
    public Board() {this.board = newBoard();}
    public ArrayList<ArrayList<Piece>> newBoard() {
        board = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ArrayList<Piece> row = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                row.add(null);
            }
            board.add(row);
        }
        Team blackTeam = new Team("BLACK");
        blackTeamList = blackTeam.wholeTeam;
        blackTeam.makeTeam();
        addTeamToBoard(blackTeam, 0);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                addPiece(i+2,j,new Blank(Piece.Team.BLANK));
            }
        }
        Team whiteTeam = new Team("WHITE");
        whiteTeamList = whiteTeam.wholeTeam;
        whiteTeam.makeTeam();
        addTeamToBoard(whiteTeam, 7);
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
        if (team.team.equals("WHITE")) {
            for (int i = 0; i < 8; i++) {
                addPiece(row-1, i, team.pawnsList.get(i));
            }
        } else if (team.team.equals("BLACK")){
            for (int i = 0; i < 8; i++) {
                addPiece(row+1, i, team.pawnsList.get(i));
            }
        }
    }
    public Position getPiecePosition(Piece piece) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.get(i).get(j).equals(piece)) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }
    void addPiece(int row, int col, Piece piece) {
        ArrayList<Piece> targetRow = board.get(row);
        targetRow.set(col, piece);
    }
    public ArrayList<ArrayList<Piece>> getBoard() {
        return this.board;
    }
    public Piece getPiece(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return board.get(row).get(column);
    }
}