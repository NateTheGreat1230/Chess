package com.game.chess;
import com.game.chess.Game;
public class GameLogic {
    public void turn() {
        Game game = Game.getGame();
        if (game.isWhiteTurn) {
            System.out.println("White Turn");
            game.changeTurn();
        } else {
            System.out.println("Black Turn");
            game.changeTurn();
        }
    }
}
