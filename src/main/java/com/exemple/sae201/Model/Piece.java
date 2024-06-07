package com.exemple.sae201.Model;

abstract class Piece {
    private String couleur;
    private int x;
    private int y;

    public Piece(String couleur, int x, int y) {
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

    public String getCouleur() {
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