package com.exemple.sae201.Model;

/**
 * Classe représentant une tour dans un jeu d'échecs.
 */
public class Tour extends Piece {
    // Constructeur
    public Tour(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    /**
     * Vérifie si la tour peut se déplacer à une certaine position.
     * @param x La nouvelle position horizontale.
     * @param y La nouvelle position verticale.
     * @return True si le déplacement est possible, False sinon.
     */
    @Override
    public boolean peutBouger(int x, int y) {
        if (getX() == x || getY() == y) {
            // Vérification des pièces sur le chemin
            int minX = Math.min(getX(), x);
            int maxX = Math.max(getX(), x);
            int minY = Math.min(getY(), y);
            int maxY = Math.max(getY(), y);

            for (int i = minX + 1; i < maxX; i++) {
                if (Board.board[getY()][i] != null) return false;
            }
            for (int j = minY + 1; j < maxY; j++) {
                if (Board.board[j][getX()] != null) return false;
            }
            return true;
        }
        return false;
    }
}
