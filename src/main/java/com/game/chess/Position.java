package com.game.chess;

public class Position {
    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {return this.row;}
    public int getColumn() {return this.column;}
    public String toString() {return "Row: " + this.row + " Column: " + this.column;}
}