package com.game.chess;

import com.game.chess.pieces.Blank;
import java.util.ArrayList;

public class Game {
    private boolean isWhiteTurn = true;
    private Game game;
    Board board = new Board();
    ChessController controller;
    public Game(ChessController controller) {this.controller = controller;}
    public Game() {}
    public boolean isWhiteTurn() {return isWhiteTurn;}
    public void changeTurn() {isWhiteTurn = !isWhiteTurn;}
    public void setController(ChessController controller) {this.controller = controller;}
    public void initGame(Game game) {
        this.game = game;
        setController(controller);
        clearBoard();
        controller.draw(board.getBoard());
    }
    public void clearBoard() {
        board.board = board.newBoard();
        isWhiteTurn = true;
    }
    public Game getGame() {return this.game;}
    public void takeTurn(Piece piece, Position start, Position end) {
        Piece endPiece = board.getPiece(end);
        if (endPiece.pieceTeam.equals(Piece.Team.BLANK)) {
        } else {
            if (endPiece.pieceTeam.equals(Piece.Team.WHITE)) {
                board.whiteTeamList.remove(endPiece);
            } else {
                board.blackTeamList.remove(endPiece);
            }
        }
        board.addPiece(start.getRow(), start.getColumn(), new Blank(Piece.Team.BLANK));
        board.addPiece(end.getRow(), end.getColumn(), piece);
    }
    public boolean checkWin() {
        if (!isWhiteTurn()) {
            return checkMate(Piece.Team.WHITE);
        } else {
            return checkMate(Piece.Team.BLACK);
        }
    }
    public ArrayList<Position> checkMoves(Piece piece, ArrayList<Position> allMoves) {
        ArrayList<Position> inCheckMoves = new ArrayList<>();
        for (Position position : allMoves) {
            if (preventsCheck(position, piece) || canCaptureAttacker(position, piece)) {
                inCheckMoves.add(position);
            }
        }
        return inCheckMoves;
    }
    public boolean preventsCheck(Position position, Piece piece) {
        ArrayList<Piece> enemies;
        if (piece.pieceTeam.equals(Piece.Team.WHITE)) {
            enemies = board.blackTeamList;
        } else {
            enemies = board.whiteTeamList;
        }
        Position kingPosition = findKingPosition(piece.pieceTeam);
        for (Piece enemy : enemies) {
            Position enemyPosition = board.getPiecePosition(enemy);
            if (enemy.isValidMove(enemyPosition, kingPosition, board) &&
                    isBetween(position, kingPosition, enemyPosition)) {
                return true;
            }
        }
        return false;
    }
    private boolean isBetween(Position position, Position start, Position end) {
        int deltaX1 = position.getColumn() - start.getColumn();
        int deltaY1 = position.getRow() - start.getRow();
        int deltaX2 = end.getColumn() - start.getColumn();
        int deltaY2 = end.getRow() - start.getRow();
        return deltaX1 * deltaY2 == deltaX2 * deltaY1 &&
                Math.min(start.getColumn(), end.getColumn()) <= position.getColumn() &&
                position.getColumn() <= Math.max(start.getColumn(), end.getColumn()) &&
                Math.min(start.getRow(), end.getRow()) <= position.getRow() &&
                position.getRow() <= Math.max(start.getRow(), end.getRow());
    }
    private boolean canCaptureAttacker(Position position, Piece piece) {
        ArrayList<Piece> enemies;
        if (piece.pieceTeam.equals(Piece.Team.WHITE)) {
            enemies = board.blackTeamList;
        } else {
            enemies = board.whiteTeamList;
        }
        for (Piece enemy : enemies) {
            if (enemy.isValidMove(board.getPiecePosition(enemy), position, board) &&
                    position.equals(board.getPiecePosition(enemy))) {
                return true;
            }
        }
        return false;
    }
    public boolean checkMate(Piece.Team team) {
        Position kingPosition = findKingPosition(team);
        if (kingPosition == null) {
            return true;
        }
        if (kingInCheck(team, kingPosition)) {
            Piece king = board.getPiece(kingPosition);
            ArrayList<Position> moves = checkKingMoves(king, king.getValidMoves(kingPosition, board));
            return moves.equals(new ArrayList<>());
        }
        return false;
    }
    public Position findKingPosition(Piece.Team team) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position currentPos = new Position(row, col);
                Piece currentPiece = board.getPiece(currentPos);
                if (currentPiece != null && currentPiece.type.equals("King") && currentPiece.pieceTeam.equals(team)) {
                    return currentPos;
                }
            }
        }
        return null;
    }
    public ArrayList<Position> checkKingMoves(Piece king, ArrayList<Position> moves) {
        ArrayList<Position> checkedMoves = new ArrayList<>();
        for (Position move : moves) {
            if (!kingInCheck(king.pieceTeam, move)) {
                checkedMoves.add(move);
            }
        }
        return checkedMoves;
    }
    public boolean kingInCheck(Piece.Team team, Position kingPosition) {
        if (kingPosition == null) {
            return true;
        }
        ArrayList<Piece> enemies;
        if (!team.equals(Piece.Team.WHITE)) {
            enemies = board.whiteTeamList;
        } else {
            enemies = board.blackTeamList;
        }
        for (Piece enemy : enemies) {
            if (enemy.isValidMove(board.getPiecePosition(enemy), kingPosition, board)) {
                return true;
            }
        }
        return false;
    }
    public Piece.Team getTurn() {
        if (isWhiteTurn()) {
            return Piece.Team.WHITE;
        } else {
            return Piece.Team.BLACK;
        }
    }
}