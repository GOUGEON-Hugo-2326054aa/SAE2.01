package com.exemple.sae201.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestionnaire de fichiers CSV pour les joueurs et les résultats des parties.
 */
public class CSVManager {
    private static final String fichierJoueurs = "src/main/resources/com/exemple/sae201/Joueurs.csv";
    private static final String fichierResultat = "src/main/resources/com/exemple/sae201/Resultats.csv";

    /**
     * Ajoute les noms des joueurs à la liste de joueurs enregistrés.
     * @param joueur1 Nom du premier joueur.
     * @param joueur2 Nom du deuxième joueur.
     */
    public static void Joueurs(String joueur1, String joueur2) {
        try (FileWriter writer = new FileWriter(fichierJoueurs, true)) {
            if (!getNoms().contains(joueur1)) {
                writer.append(joueur1)
                        .append('\n');
            }
            if (!getNoms().contains(joueur2)) {
                writer.append(joueur2)
                        .append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Enregistre les résultats de la partie.
     * @param blancs Nom du joueur avec les pièces blanches.
     * @param noirs Nom du joueur avec les pièces noires.
     * @param gagnant Couleur du joueur gagnant ('w' ou 'b').
     */
    public static void Resultats(String blancs, String noirs, char gagnant) {
        try (FileWriter writer = new FileWriter(fichierResultat, true)) {
            writer.append(blancs)
                    .append(',')
                    .append(noirs)
                    .append(',')
                    .append(gagnant)
                    .append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupère la liste des noms des joueurs enregistrés.
     * @return Liste des noms des joueurs.
     */
    public static List<String> getNoms() {
        List<String> nomJoueurs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichierJoueurs))) {
            String ligne = br.readLine();
            while (ligne != null) {
                nomJoueurs.add(ligne.trim());
                ligne = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nomJoueurs;
    }

    /**
     * Récupère la liste des résultats des parties enregistrées.
     * @return Liste des résultats des parties.
     */
    public static List<String> getParties() {
        List<String> gameResults = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichierResultat))) {
            String line = br.readLine();
            while (line != null) {
                gameResults.add(line.trim());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameResults;
    }
}
