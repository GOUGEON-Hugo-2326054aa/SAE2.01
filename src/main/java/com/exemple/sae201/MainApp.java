package com.exemple.sae201;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Board board = new Board();
        VBox layout = new VBox();
        layout.getChildren().add(board.getBoard());
        Scene scene = new Scene(layout, 800, 800);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
