module com.game.chess {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.game.chess to javafx.fxml;
    exports com.game.chess;
}