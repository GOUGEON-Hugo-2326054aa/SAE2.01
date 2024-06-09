package com.exemple.sae201.Model;

public class Fou extends Piece {
    public Fou(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    @Override
    public boolean peutBouger(int x, int y) {
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());
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
