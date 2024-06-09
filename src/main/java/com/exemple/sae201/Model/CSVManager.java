package com.exemple.sae201.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    private static final String fichierJoueurs = "src/main/resources/com/exemple/sae201/Joueurs.csv";
    private static final String fichierResultat = "src/main/resources/com/exemple/sae201/Resultats.csv";

    /**
     *
     * @param joueur1
     * @param joueur2
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
     *
     * @param blancs
     * @param noirs
     * @param gagnant
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
     *
     * @return
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