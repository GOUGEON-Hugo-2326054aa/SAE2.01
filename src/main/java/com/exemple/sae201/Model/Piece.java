package com.exemple.sae201.Model;

public abstract class Piece {
    private char couleur;
    private int x;
    private int y;
    protected Board tableau = new Board();

    public Piece(char couleur, int x, int y) {
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

    public char getCouleur() {
        return couleur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract boolean peutBouger(int newX, int newY);
}