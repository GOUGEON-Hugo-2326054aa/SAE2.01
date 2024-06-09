package com.exemple.sae201.Model;

/**
 * Classe représentant le plateau de jeu.
 */
public class Board {
    // Tableau représentant le plateau de jeu avec les pièces.
    public static Piece[][] board = new Piece[8][8];

    /**
     * Initialise les pièces sur le plateau de jeu.
     */
    public static void initPieces() {
        // Parcours de toutes les cases du plateau.
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                // Initialisation de chaque case à null (pas de pièce).
                board[row][col] = null;
            }
        }
        // Placement des pièces pour le jeu de départ.
        board[0][3] = new Dame('b', 3, 0); // Dame noire
        board[7][3] = new Dame('w', 3, 7); // Dame blanche
        board[0][4] = new Roi('b', 4, 0);  // Roi noir
        board[7][4] = new Roi('w', 4, 7);  // Roi blanc

        // Placement des pions.
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pion('b', col, 1); // Pions noirs
            board[6][col] = new Pion('w', col, 6); // Pions blancs
        }

        // Placement des tours.
        for (int col = 0; col < 8; col += 7) {
            board[0][col] = new Tour('b', col, 0); // Tours noires
            board[7][col] = new Tour('w', col, 7); // Tours blanches
        }

        // Placement des cavaliers.
        for (int col = 1; col < 7; col += 5) {
            board[0][col] = new Cavalier('b', col, 0); // Cavaliers noirs
            board[7][col] = new Cavalier('w', col, 7); // Cavaliers blancs
        }

        // Placement des fous.
        for (int col = 2; col < 6; col += 3) {
            board[0][col] = new Fou('b', col, 0); // Fous noirs
            board[7][col] = new Fou('w', col, 7); // Fous blancs
        }
    }
}