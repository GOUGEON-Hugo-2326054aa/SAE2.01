package com.exemple.sae201.Model;

/**
 * Classe représentant un cavalier dans un jeu d'échecs.
 */
public class Cavalier extends Piece {
    // Constructeur
    public Cavalier(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    /**
     * Vérifie si le cavalier peut se déplacer à une certaine position.
     * @param x La nouvelle position horizontale.
     * @param y La nouvelle position verticale.
     * @return True si le déplacement est possible, False sinon.
     */
    @Override
    public boolean peutBouger(int x, int y) {
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());
        // Le cavalier peut se déplacer en 'L', soit 2 cases horizontalement et 1 verticalement,
        // ou 1 case horizontalement et 2 verticalement.
        return (depX == 2 && depY == 1) || (depX == 1 && depY == 2);
    }
}
