package com.exemple.sae201;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class FullViewController {
    @FXML
    private ImageView ppb,ppw,bb,bk,bn,bp,bq,br,wb,wn,wk,wp,wq,wr;

    @FXML
    private Pane Board;

    public void initialize() {
//        Image image = new Image(getClass().getResource("/img/pp1.png").toString());
//        ppb.setImage(image);
        Board board = new Board();
        Board.getChildren().add(board.getBoard());

    }
}
