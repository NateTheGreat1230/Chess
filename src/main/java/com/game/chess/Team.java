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

    public Team() {}
    public void makeTeam(String team) {
        Piece.Team teamEnum;
        this.team = team;
        if (team.equals("WHITE")) {
            teamEnum = Piece.Team.WHITE;
        } else {
            teamEnum = Piece.Team.BLACK;
        }
        for (int i = 0; i < pawns; i++) {
            Pawn pawn = new Pawn(teamEnum);
            pawnsList.add(pawn);
        }
        for (int i = 0; i < rooks; i++) {
            Rook rook = new Rook(teamEnum);
            rooksList.add(rook);
        }
        for (int i = 0; i < bishops; i++) {
            Bishop bishop = new Bishop(teamEnum);
            bishopsList.add(bishop);
        }
        for (int i = 0; i < kings; i++) {
            King king = new King(teamEnum);
            kingsList.add(king);
        }
        for (int i = 0; i < queens; i++) {
            Queen queen = new Queen(teamEnum);
            queensList.add(queen);
        }
        for (int i = 0; i < knights; i++) {
            Knight knight = new Knight(teamEnum);
            knightsList.add(knight);
        }
    }
}