package com.exemple.sae201.Controller;

import com.exemple.sae201.MainApp;
import com.exemple.sae201.Model.Board;
import com.exemple.sae201.Model.CSVManager;
import com.exemple.sae201.Model.Piece;
import com.exemple.sae201.Model.Roi;
import javafx.css.Style;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class BoardController {
    @FXML
    private GridPane gridPane;
    @FXML
    private StackPane boardContainer;
    private Board tableau;
    private Piece pionChoisi;
    private StackPane prevTuile = null;
    private String prevCouleur = null;
    private boolean tour = true;
    private MainApp mainApp;

    public void initDeplacement() {
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 8; colonne++) {
                StackPane tuile = getCase(gridPane, colonne, ligne);
                System.out.println(tuile);
                int finalLigne = ligne;
                int finalColonne = colonne;
                tuile.setOnMouseClicked(event -> deplacementJoueur(finalColonne, finalLigne));
            }
        }
    }

    private void deplacementJoueur(int x, int y) {
        System.out.println(x);
        System.out.println(y);
        StackPane tuile = getCase(gridPane, x, y);
        char equipe = tour ? 'w' : 'b';
        if (pionChoisi == null) {
            if ((tour && Board.board[y][x] != null && Board.board[y][x].getCouleur() == 'w') ||
                    (!tour && Board.board[y][x] != null && Board.board[y][x].getCouleur() == 'b')) {
                pionChoisi = Board.board[y][x];
                selectionCouleur(tuile);
            }
        } else if (Board.board[y][x] != null && Board.board[y][x].getCouleur() == pionChoisi.getCouleur()) {
            pionChoisi = Board.board[y][x];
            selectionCouleur(tuile);
        } else {
            if (pionChoisi.peutBouger(x, y)) {
                if (Piece.mouvementValide(pionChoisi, x, y)) {
                    Piece pionCapture = Board.board[y][x];
                    Board.board[pionChoisi.getY()][pionChoisi.getX()] = null;
                    Board.board[y][x] = pionChoisi;
                    affichage(x, y);
                    pionChoisi.setX(x);
                    pionChoisi.setY(y);
                    pionChoisi = null;
                    tour = !tour;
                    if (prevTuile != null) {
                        prevTuile.setStyle(prevCouleur);
                        prevTuile = null;
                        prevCouleur = null;
                    }
                    if (pionCapture instanceof Roi) {
                        FullViewController fullController = MainApp.loader.getController();
                        fullController.reset();
                        CSVManager.Resultats(CSVManager.getNoms().get(CSVManager.getNoms().size()-1), CSVManager.getNoms().get(CSVManager.getNoms().size()-2), pionChoisi.getCouleur());
                    }
                }

            }
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    private void affichage(int x, int y) {
        StackPane newTuile = getCase(gridPane, x, y);
        StackPane tuile = getCase(gridPane, pionChoisi.getX(), pionChoisi.getY());
        System.out.println(tuile.getChildren());
        Node image = tuile.getChildren().get(0);
        newTuile.getChildren().clear();
        newTuile.getChildren().add((ImageView) image);
        tuile.getChildren().clear();

    }

    /**
     *
     * @param gridPane
     * @param x
     * @param y
     * @return
     */
    private StackPane getCase(GridPane gridPane, int x, int y) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y) {
                return (StackPane) node;
            }
        }
        return null;
    }

    /**
     *
     * @param actTuile
     */
    private void selectionCouleur(StackPane actTuile) {
        if (prevTuile != null) {
            prevTuile.setStyle(prevCouleur);
        }
        if (actTuile != null) {
            prevCouleur = actTuile.getStyle();
            actTuile.setStyle("-fx-background-color: #ef785f;");
            prevTuile = actTuile;
        }
    }
}
