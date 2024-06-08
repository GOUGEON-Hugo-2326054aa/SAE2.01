package com.exemple.sae201.Model;

public class Pion extends Piece{
    public Pion(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    @Override
    public boolean peutBouger(int x, int y) {
        int dy = y - getY();
        int dx = x - getX();

        if (getCouleur() == 'w') {
            if (dy == -1 && dx == 0) {
                return true;
            }
            if (getY() == 6 && dy == -2 && dx == 0) {
                return true;
            }
        } else {
            if (dy == 1 && dx == 0) {
                return true;
            }
            if (getY() == 1 && dy == 2 && dx == 0) {
                return true;
            }
        }

        return false;
    }
}
