package com.exemple.sae201;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FullViewController {

    @FXML
    private Button button;

    @FXML
    public void initialize() {
        button.setOnAction(event -> System.out.println("Button clicked!"));
    }
}
