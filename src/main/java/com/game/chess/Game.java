package com.game.chess;

import java.util.ArrayList;

public class Game {
    boolean isWhiteTurn = true;
    Game game;
    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }
    public void changeTurn() {
        if (isWhiteTurn) {
            isWhiteTurn = false;
        } else {
            isWhiteTurn = true;
        }
    }
    public void initGame(Game game) {
        this.game = game;
        new Board(new ArrayList<>());
    }
    public Game getGame() {
        return this.game;
    }
}
