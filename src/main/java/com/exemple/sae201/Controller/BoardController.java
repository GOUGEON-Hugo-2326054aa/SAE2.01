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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
     * Initialise les déplacements des pièces sur l'échiquier.
     * Définit les gestionnaires d'événements de clic de souris pour chaque case de l'échiquier.
     */
    public void initDeplacement() {
        for (int ligne = 0; ligne < 8; ligne++) {
            for (int colonne = 0; colonne < 8; colonne++) {
                // Récupère la StackPane à la ligne et colonne actuelles
                StackPane tuile = getCase(gridPane, colonne, ligne);
                System.out.println(tuile);
                int finalLigne = ligne;
                int finalColonne = colonne;
                tuile.setOnMouseClicked(event -> deplacementJoueur(finalColonne, finalLigne));
            }
        }
    }

    /**
     * Gère le déplacement des pièces sur l'échiquier.
     * @param x l'index de la colonne de la case cliquée
     * @param y l'index de la ligne de la case cliquée
     */
    private void deplacementJoueur(int x, int y) {
        System.out.println(x);
        System.out.println(y);
        StackPane tuile = getCase(gridPane, x, y);

        if (pionChoisi == null) {
            // Sélectionne une pièce si aucune n'est actuellement sélectionnée
            if ((tour && Board.board[y][x] != null && Board.board[y][x].getCouleur() == 'w') ||
                    (!tour && Board.board[y][x] != null && Board.board[y][x].getCouleur() == 'b')) {
                pionChoisi = Board.board[y][x];
                selectionCouleur(tuile);
            }
        } // Change la sélection à une autre pièce de la même couleur
            else if (Board.board[y][x] != null && Board.board[y][x].getCouleur() == pionChoisi.getCouleur()) {
            pionChoisi = Board.board[y][x];
            selectionCouleur(tuile);
        } else {
            // Tente de déplacer la pièce sélectionnée à la nouvelle position
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
                    // Vérifie si le déplacement capture un roi
                    if (pionCapture instanceof Roi) {
                        FullViewController fullController = MainApp.loader.getController();
                        fullController.reset();
                        CSVManager.Resultats(CSVManager.getNoms().get(CSVManager.getNoms().size() - 1), CSVManager.getNoms().get(CSVManager.getNoms().size() - 2), pionChoisi.getCouleur());
                    }
                }
            }
        }
    }



    /**
     * Met à jour l'affichage après un déplacement.
     * @param x l'index de la colonne de la nouvelle position
     * @param y l'index de la ligne de la nouvelle position
     */
    private void affichage(int x, int y) {
        // Récupère la StackPane de la nouvelle position
        StackPane newTuile = getCase(gridPane, x, y);
        // Récupère la StackPane de l'ancienne position
        StackPane tuile = getCase(gridPane, pionChoisi.getX(), pionChoisi.getY());
        System.out.println(tuile.getChildren());
        // Déplace l'image de la pièce
        Node image = tuile.getChildren().get(0);
        newTuile.getChildren().clear();
        newTuile.getChildren().add((ImageView) image);
        tuile.getChildren().clear();
    }

    /**
     * Récupère la StackPane d'une case de l'échiquier.
     * @param gridPane le GridPane de l'échiquier
     * @param x l'index de la colonne
     * @param y l'index de la ligne
     * @return la StackPane de la case spécifiée
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
     * Met en surbrillance la case sélectionnée.
     * @param actTuile la StackPane de la case actuelle
     */
    private void selectionCouleur(StackPane actTuile) {
        // Réinitialise la couleur de la case précédemment sélectionnée
        if (prevTuile != null) {
            prevTuile.setStyle(prevCouleur);
        }
        // Définit la couleur de surbrillance pour la case actuelle
        if (actTuile != null) {
            prevCouleur = actTuile.getStyle();
            actTuile.setStyle("-fx-background-color: #ef785f;");
            prevTuile = actTuile;
        }
    }
}
