package com.exemple.sae201.Model;

/**
 * Classe abstraite représentant une pièce d'échecs.
 */
public abstract class Piece {
    // Attributs
    private char couleur; // Couleur de la pièce ('b' pour noir, 'w' pour blanc)
    private int x; // Position horizontale de la pièce
    private int y; // Position verticale de la pièce

    // Constructeur
    public Piece(char couleur, int x, int y) {
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

    // Méthodes d'accès aux attributs
    public char getCouleur() {
        return couleur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Méthodes de modification des attributs
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Vérifie si un mouvement à une certaine position est valide pour la pièce.
     * @param newX La nouvelle position horizontale.
     * @param newY La nouvelle position verticale.
     * @return True si le mouvement est valide, False sinon.
     */
    public abstract boolean peutBouger(int newX, int newY);

    /**
     * Vérifie si un mouvement fais sortir de la situation d'échec.
     * @param piece La pièce à déplacer.
     * @param x La nouvelle position horizontale.
     * @param y La nouvelle position verticale.
     * @return True si le mouvement est valide, False sinon.
     */
    public static boolean mouvementValide(Piece piece, int x, int y) {
        char equipe = piece.getCouleur();
        Piece save = Board.board[y][x];
        Board.board[y][x] = piece;
        Board.board[piece.getY()][piece.getX()] = null;
        boolean validation = !Roi.estEchec(equipe);
        Board.board[piece.getY()][piece.getX()] = piece;
        Board.board[y][x] = save;
        return validation;
    }
}
