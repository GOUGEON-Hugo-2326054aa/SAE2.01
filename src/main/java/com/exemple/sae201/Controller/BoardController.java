package com.exemple.sae201.Controller;

import com.exemple.sae201.Model.Piece;
import com.exemple.sae201.Model.Pion;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class BoardController {
    @FXML
    private GridPane gridPane;

    private Piece[][] tableau = new Piece[8][8];
    private Piece pionChoisi;

    @FXML
    public void initialize() {
        initPieces();
        initEchiquier();

    }

    private void initEchiquier() {
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 8; colonne++) {
                StackPane tuile = getCase(gridPane, colonne, ligne);
                System.out.println(tuile);
                if (tuile != null) {
                    int finalLigne = ligne;
                    int finalColonne = colonne;
                    tuile.setOnMouseClicked(event -> deplacementJoueur(finalColonne, finalLigne));
                }
            }
        }
    }

    private void deplacementJoueur(int x, int y) {
        System.out.println(x);
        System.out.println(y);
        if (pionChoisi == null) {
            pionChoisi = tableau[y][x];
        } else {
            if (pionChoisi.peutBouger(x, y)) {
                tableau[pionChoisi.getY()][pionChoisi.getX()] = null;
                tableau[y][x] = pionChoisi;
                affichage(x,y);
                pionChoisi.setX(x);
                pionChoisi.setY(y);
                pionChoisi = null;
            }
        }
    }

    private void initPieces() {
        for (int col = 0; col < 8; col++) {
            tableau[1][col] = new Pion('b', col, 1);
            tableau[6][col] = new Pion('w', col, 6);
        }


    }

    private void affichage(int x, int y){
        StackPane newTuile = getCase(gridPane, x, y);
        StackPane tuile = getCase(gridPane, pionChoisi.getX(), pionChoisi.getY());
        System.out.println(tuile.getChildren());
        Node image = tuile.getChildren().get(0);
        newTuile.getChildren().add((ImageView) image);
        tuile.getChildren().remove(image);

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
