package com.exemple.sae201.Model;

/**
 * Classe représentant un roi dans un jeu d'échecs.
 */
public class Roi extends Piece {
    // Constructeur
    public Roi(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    /**
     * Vérifie si le roi peut se déplacer à une certaine position.
     * @param x La nouvelle position horizontale.
     * @param y La nouvelle position verticale.
     * @return True si le déplacement est possible, False sinon.
     */
    @Override
    public boolean peutBouger(int x, int y) {
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());
        return (depX <= 1 && depY <= 1);
    }

    /**
     * Trouve la position du roi d'une certaine équipe sur le plateau.
     * @param equipe La couleur de l'équipe du roi.
     * @return La pièce représentant le roi de l'équipe spécifiée.
     */
    public static Piece posRoi(char equipe) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = Board.board[y][x];
                if (piece != null && piece.getCouleur() == equipe && piece instanceof Roi) {
                    return piece;
                }
            }
        }
        return null;
    }

    /**
     * Vérifie si le roi d'une certaine équipe est en échec.
     * @param equipe La couleur de l'équipe du roi.
     * @return True si le roi est en échec, False sinon.
     */
    public static boolean estEchec(char equipe) {
        Piece roi = posRoi(equipe);
        int xRoi = roi.getX();
        int yRoi = roi.getY();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = Board.board[y][x];
                if (piece != null && piece.getCouleur() != equipe) {
                    if (piece.peutBouger(xRoi, yRoi)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
