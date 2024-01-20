package com.game.chess;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {return this.row;}
    public int getColumn() {return this.column;}
    public void setRow(int row) {this.row = row;}
    public void setColumn(int column) {this.column = column;}
    public String toString() {return "Row: " + this.row + " Column: " + this.column;}
}