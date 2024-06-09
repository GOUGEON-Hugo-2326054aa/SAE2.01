package com.exemple.sae201.Controller;

import com.exemple.sae201.Model.Board;
import com.exemple.sae201.Model.Piece;
import com.exemple.sae201.Model.Pion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class BoardController {
    @FXML
    private GridPane gridPane;
    @FXML
    private StackPane boardContainer;
    private Board tableau ;
    private Piece pionChoisi;


    public void initDeplacement() {
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 8; colonne++) {
                StackPane tuile = getCase(gridPane, colonne, ligne);
                System.out.println(tuile);
                int finalLigne = ligne;
                int finalColonne = colonne;
                tuile.setOnMouseClicked(event -> deplacementJoueur(finalColonne,finalLigne));
                }
            }
        }

    private void deplacementJoueur(int x, int y) {
        System.out.println(x);
        System.out.println(y);
        if (pionChoisi == null) {
            pionChoisi = Board.board[y][x];
        } else if (Board.board[y][x] != null && Board.board[y][x].getCouleur() == pionChoisi.getCouleur()) {
            pionChoisi = Board.board[y][x];
        } else {
            if (pionChoisi.peutBouger(x, y)) {
                Board.board[pionChoisi.getY()][pionChoisi.getX()] = null;
                Board.board[y][x] = pionChoisi;
                affichage(x, y);
                pionChoisi.setX(x);
                pionChoisi.setY(y);
                pionChoisi = null;
            }
        }
    }



    private void affichage(int x, int y) {
        StackPane newTuile = getCase(gridPane, x, y);
        StackPane tuile = getCase(gridPane, pionChoisi.getX(), pionChoisi.getY());
        System.out.println(tuile.getChildren());
        Node image = tuile.getChildren().get(0);
        newTuile.getChildren().clear();
        newTuile.getChildren().add((ImageView) image);
        tuile.getChildren().clear();

    }

    private StackPane getCase(GridPane gridPane, int x, int y) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y) {
                return (StackPane) node;
            }
        }
        return null;
    }

}
