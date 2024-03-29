package com.game.chess;

import com.game.chess.pieces.*;
import java.util.ArrayList;

public class Team {
    final int pawns = 8;
    final int rooks = 2;
    final int bishops = 2;
    final int kings = 1;
    final int queens = 1;
    final int knights = 2;
    String team;
    ArrayList<Pawn> pawnsList = new ArrayList<>();
    ArrayList<Bishop> bishopsList = new ArrayList<>();
    ArrayList<King> kingsList = new ArrayList<>();
    ArrayList<Queen> queensList = new ArrayList<>();
    ArrayList<Knight> knightsList = new ArrayList<>();
    ArrayList<Rook> rooksList = new ArrayList<>();
    ArrayList<Piece> wholeTeam = new ArrayList<>();
    public Team() {}
    public Team(String team) {this.team = team;}
    public void makeTeam() {
        Piece.Team teamEnum;
        if (team.equals("WHITE")) {
            teamEnum = Piece.Team.WHITE;
        } else {
            teamEnum = Piece.Team.BLACK;
        }
        for (int i = 0; i < pawns; i++) {
            Pawn pawn = new Pawn(teamEnum);
            pawnsList.add(pawn);
            wholeTeam.add(pawn);
        }
        for (int i = 0; i < rooks; i++) {
            Rook rook = new Rook(teamEnum);
            rooksList.add(rook);
            wholeTeam.add(rook);
        }
        for (int i = 0; i < bishops; i++) {
            Bishop bishop = new Bishop(teamEnum);
            bishopsList.add(bishop);
            wholeTeam.add(bishop);
        }
        for (int i = 0; i < kings; i++) {
            King king = new King(teamEnum);
            kingsList.add(king);
            wholeTeam.add(king);
        }
        for (int i = 0; i < queens; i++) {
            Queen queen = new Queen(teamEnum);
            queensList.add(queen);
            wholeTeam.add(queen);
        }
        for (int i = 0; i < knights; i++) {
            Knight knight = new Knight(teamEnum);
            knightsList.add(knight);
            wholeTeam.add(knight);
        }
    }
}