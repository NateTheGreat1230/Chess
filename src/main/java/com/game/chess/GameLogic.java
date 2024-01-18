package com.game.chess;
import com.game.chess.Game;
public class GameLogic {
    Game game = new Game();

    public void turn(Team team) {
        //team.getPecies();
        game = game.getGame();
        if (game.isWhiteTurn) {
            System.out.println("White Turn");
            game.changeTurn();
        } else {
            System.out.println("Black Turn");
            game.changeTurn();
        }
    }
}
