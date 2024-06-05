package com.exemple.sae201;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Board {
    private VBox board;

    public Board() {
        board = new VBox();
        createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < 8; i++) {
            HBox row = new HBox();
            for (int j = 0; j < 8; j++) {
                StackPane square = new StackPane();
                square.setPrefSize(100, 100);
                if ((i + j) % 2 == 0) {
                    square.setStyle("-fx-background-color: #637084");
                } else {
                    square.setStyle("-fx-background-color: #282f3e");
                }
                row.getChildren().add(square);
            }
            board.getChildren().add(row);
        }
    }

    public VBox getBoard() {
        return board;
    }

}
