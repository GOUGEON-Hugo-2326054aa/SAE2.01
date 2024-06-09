package com.exemple.sae201.Model;

public class Cavalier extends Piece {
    public Cavalier(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    @Override
    public boolean peutBouger(int x, int y) {
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());
        return (depX == 2 && depY == 1) || (depX == 1 && depY == 2);
    }
}
