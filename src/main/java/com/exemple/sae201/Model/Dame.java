package com.exemple.sae201.Model;

public class Dame extends Piece {
    public Dame(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    @Override
    public boolean peutBouger(int x, int y) {
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());

        if (depX == depY) { // Mouvement diagonal (comme un fou)
            int stepX = (x - getX()) / depX;
            int stepY = (y - getY()) / depY;
            for (int i = 1; i < depX; i++) {
                if (Board.board[getY() + i * stepY][getX() + i * stepX] != null) return false;
            }
            return true;
        } else if (getX() == x || getY() == y) { // Mouvement horizontal ou vertical (comme une tour)
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
