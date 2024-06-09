package com.exemple.sae201;

import com.exemple.sae201.Controller.FullViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/exemple/sae201/View/FullView.fxml"));
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(loader.load(),1320,950);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
