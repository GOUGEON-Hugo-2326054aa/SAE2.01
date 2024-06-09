package com.exemple.sae201.Model;

public class Pion extends Piece{
    public Pion(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    @Override
    public boolean peutBouger(int x, int y) {
        int depY = Math.abs(y - getY());
        int depX = Math.abs(x - getX());

        if (Board.board[y][x] == null) {
            if (depY == 1 && depX == 0) {
                return true;
            }
            if ((getY() == 1 || getY() == 6)&& depY == 2 && depX == 0) {
                return true;
            }
        } else return depY == 1 && depX == 1;

        return false;
    }
}
