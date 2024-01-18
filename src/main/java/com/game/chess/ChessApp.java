package com.game.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChessApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChessApp.class.getResource("chess-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 800);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Chess.css")).toExternalForm());
        stage.getIcons().add(new Image(Objects.requireNonNull(ChessApp.class.getResourceAsStream("favicon.png"))));
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
        Game game = new Game();
        game.initGame(game);
    }
    public static void main(String[] args) {launch();}
}