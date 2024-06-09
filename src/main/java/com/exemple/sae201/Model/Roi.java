package com.exemple.sae201.Model;

public class Roi extends Piece {
    public Roi(char couleur, int x, int y) {
        super(couleur, x, y);
    }

    @Override
    public boolean peutBouger(int x, int y) {
        int depX = Math.abs(x - getX());
        int depY = Math.abs(y - getY());
        return (depX <= 1 && depY <= 1);
    }
    public static Piece posRoi(char equipe) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = Board.board[y][x];
                if (piece != null && piece.getCouleur() == equipe && piece instanceof Roi) {
                    return piece;
                }
            }
        }
    return null;
    }

    public static boolean estEchec(char equipe) {
        Piece roi = posRoi(equipe);
        int xRoi = roi.getX();
        int yRoi = roi.getY();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = Board.board[y][x];
                if (piece != null && piece.getCouleur() != equipe) {
                    if (piece.peutBouger(xRoi, yRoi)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
