package com.exemple.sae201.Model;

/**
 * Classe représentant la pièce Dame.
 */
public class Dame extends Piece {

    /**
     * Constructeur de la classe Dame.
     * @param couleur La couleur de la pièce ('b' pour noir, 'w' pour blanc).
     * @param x La position horizontale de la pièce.
     * @param y La position verticale de la pièce.
     */
    public Dame(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    /**
     * Vérifie si la dame peut se déplacer à une certaine position (x, y).
     * @param x La position horizontale cible.
     * @param y La position verticale cible.
     * @return True si le déplacement est valide, False sinon.
     */
    @Override
    public boolean peutBouger(int x, int y) {
        // Calcul des déplacements en x et y
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());

        // Vérifie si le déplacement est diagonal (comme un fou)
        if (depX == depY) {
            int stepX = (x - getX()) / depX;
            int stepY = (y - getY()) / depY;
            for (int i = 1; i < depX; i++) {
                if (Board.board[getY() + i * stepY][getX() + i * stepX] != null) return false;
            }
            return true;
        } else if (getX() == x || getY() == y) { // Vérifie si le déplacement est horizontal ou vertical (comme une tour)
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
