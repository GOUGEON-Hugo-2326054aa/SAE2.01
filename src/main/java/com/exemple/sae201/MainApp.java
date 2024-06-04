package com.exemple.sae201;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class FullViewController {
    @FXML
    private VBox plateau;

    @FXML
    public void initialize() {
        Board board = new Board();
        plateau.getChildren().add(board.getBoard());
    }
}
