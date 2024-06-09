package com.exemple.sae201.Model;

/**
 * Classe représentant la pièce Fou.
 */
public class Fou extends Piece {

    /**
     * Constructeur de la classe Fou.
     * @param couleur La couleur de la pièce ('b' pour noir, 'w' pour blanc).
     * @param x La position horizontale de la pièce.
     * @param y La position verticale de la pièce.
     */
    public Fou(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    /**
     * Vérifie si le fou peut se déplacer à une certaine position (x, y).
     * @param x La position horizontale cible.
     * @param y La position verticale cible.
     * @return True si le déplacement est valide, False sinon.
     */
    @Override
    public boolean peutBouger(int x, int y) {
        // Calcul des déplacements en x et y
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());

        // Vérifie si le déplacement est diagonal
        if (depX == depY) {
            int stepX = (x - getX()) / depX;
            int stepY = (y - getY()) / depY;

            for (int i = 1; i < depX; i++) {
                if (Board.board[getY() + i * stepY][getX() + i * stepX] != null) return false;
            }
            return true;
        }
        return false;
    }
}
