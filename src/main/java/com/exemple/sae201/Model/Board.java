package com.exemple.sae201.Model;

public class Board {
    public static Piece[][] board = new Piece[8][8];


    public static void initPieces() {
        for (int col =0; col < 8; col++){
            for (int row = 0; row < 8; row++) {
                board[row][col] = null;
            }
        }
        board[0][3] = new Dame('b', 3, 0);
        board[7][3] = new Dame('w', 3, 7);
        board[0][4] = new Roi('b', 4, 0);
        board[7][4] = new Roi('w', 4, 7);
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pion('b', col, 1);
            board[6][col] = new Pion('w', col, 6);
        }
        for (int col = 0; col < 8; col+=7) {
            board[0][col] = new Tour('b', col, 0);
            board[7][col] = new Tour('w', col, 7);
        }
        for (int col = 1; col < 7; col+=5) {
            board[0][col] = new Cavalier('b', col, 0);
            board[7][col] = new Cavalier('w', col, 7);
        }
        for (int col = 2; col < 6; col+=3) {
            board[0][col] = new Fou('b', col, 0);
            board[7][col] = new Fou('w', col, 7);
        }

    }
}
