package com.exemple.sae201.Model;

/**
 * Classe représentant un pion dans un jeu d'échecs.
 */
public class Pion extends Piece {
    // Constructeur
    public Pion(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    /**
     * Vérifie si le pion peut se déplacer à une certaine position.
     * @param x La nouvelle position horizontale.
     * @param y La nouvelle position verticale.
     * @return True si le déplacement est possible, False sinon.
     */
    @Override
    public boolean peutBouger(int x, int y) {
        int depY = Math.abs(y - getY());
        int depX = Math.abs(x - getX());

        // Si la case cible est vide, le pion peut avancer d'une case vers le haut (pour les blancs)
        // ou d'une case vers le bas (pour les noirs).
        if (Board.board[y][x] == null) {
            if (depY == 1 && depX == 0) {
                return true;
            }
            // Si le pion n'a pas encore bougé, il peut avancer de deux cases s'il n'y a aucun obstacle.
            if ((getY() == 1 || getY() == 6)&& depY == 2 && depX == 0) {
                return true;
            }
        } else {
            // Si la case cible est occupée par une pièce adverse, le pion peut se déplacer en diagonale pour la capturer.
            return depY == 1 && depX == 1;
        }

        return false;
    }
}
