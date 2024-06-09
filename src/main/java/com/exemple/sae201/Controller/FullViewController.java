//controller
package com.exemple.sae201.Controller;

import com.exemple.sae201.Model.Board;
import com.exemple.sae201.Model.CSVManager;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Arrays;

public class FullViewController {

    @FXML
    private VBox Play,Player, Game,Gameplay,listeParties,listeJoueurs;
    @FXML
    private HBox ZoneB,ZoneW,Playbutton,Partie,vs;
    @FXML
    private BorderPane Tournament;
    @FXML
    private MenuButton TimerChooser;
    @FXML
    private Label timerW,timerB,NB,NW,coup,g1,g2,g3,g4,DMG1,DMG2,DMP1,DMP2,modeLabel;
    @FXML
    private TextField BName,WName,j1,j2,j3,j4,j5,j6,j7,j8;
    @FXML
    private ImageView WP1;
    @FXML
    private StackPane A3;
    @FXML
    private Button Ready, btnBot, btnLocal;
    @FXML
    private StackPane TimercadreW,TimercadreB;
    private Timeline timeline;
    private int timeSeconds;
    private StackPane currentcase;
    private boolean setbname,setwnam = false;
    private GridPane boardView ;
    @FXML
    private StackPane boardContainer;

    /**
     * Affiche le menu "Game" et masque les menus "Play" et "Player".
     */
    public void Game(MouseEvent mouseEvent) {
        Game.setVisible(true);
        Play.setVisible(false);
        Player.setVisible(false);
    }

    /**
     * Affiche le menu "NewGame" et masque les menus "Game" et "Player".
     */
    public void NewGame(MouseEvent mouseEvent) {
        Play.setVisible(true);
        Game.setVisible(false);
        Player.setVisible(false);
    }

    /**
     * Affiche le menu "Player" et masque les menus "Play" et "Game".
     * Masque également le bouton "Ready".
     */
    public void Player(MouseEvent mouseEvent) {
        Player.setVisible(true);
        Play.setVisible(false);
        Game.setVisible(false);
        Ready.setVisible(false);
    }

    /**
     * Réglage du timer à 5 minutes.
     */
    public void timeset5(Event event) {
        TimerChooser.setText("     5 min    ");
        timerW.setText("5:00");
        timerB.setText("5:00");
        timeSeconds = 300; // 5 minutes en secondes
        timeline.stop();
    }

    /**
     * Réglage du timer à 10 minutes.
     */
    public void timeset10(Event event) {
        TimerChooser.setText("    10 min    ");
        timerW.setText("10:00");
        timerB.setText("10:00");
        timeSeconds = 600; // 10 minutes en secondes
        timeline.stop();
    }

    /**
     * Réglage du timer à 15 minutes.
     */
    public void timeset15(Event event) {
        TimerChooser.setText("    15 min    ");
        timerW.setText("15:00");
        timerB.setText("15:00");
        timeSeconds = 900; // 15 minutes en secondes
        timeline.stop();
    }

    /**
     * Envoie le nom des joueurs noirs et vérifie si les noms ont été saisis.
     * Affiche le bouton "Ready" si les noms ont été saisis.
     */
    public void SendBName(MouseEvent mouseEvent) {
        String Bname = BName.getText();
        NB.setText(Bname);
        setbname = true;
        verifName();
    }

    /**
     * Envoie le nom des joueurs blancs et vérifie si les noms ont été saisis.
     * Affiche le bouton "Ready" si les noms ont été saisis.
     */
    public void SendWName(MouseEvent mouseEvent) {
        String Wname = WName.getText();
        NW.setText(Wname);
        setwnam = true;
        verifName();
    }

    /**
     * Vérifie si les noms des joueurs ont été saisis et affiche le bouton "Ready" si oui.
     */
    public void verifName() {
        if (!NW.getText().equals("") && !NB.getText().equals("") && setwnam && setbname) {
            Ready.setVisible(true);
        }
    }

    /**
     * Lance la partie locale après avoir vérifié que les noms des joueurs ont été saisis.
     * Affiche le plateau de jeu et masque les menus "Game", "Play" et "Player".
     * Enregistre les noms des joueurs dans un fichier CSV.
     */
    public void LocalStart(MouseEvent mouseEvent) {
            Gameplay.setVisible(true);
            Game.setVisible(false);
            Play.setVisible(false);
            Player.setVisible(false);
            CSVManager.Joueurs(WName.getText(), BName.getText());
            start();
    }

    /**
     * Fonction pour lancer une partie contre un bot (non aboutie).
     */
    public void botStart(MouseEvent mouseEvent) {
        System.out.println("Presque là...");
    }

    /**
     * Lance la partie, affiche le plateau de jeu et initialise les pièces.
     */
    public void start() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/exemple/sae201/View/BoardView.fxml"));
        loader.setController(new BoardController());
        try {
            boardView = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boardContainer.getChildren().clear();
        boardContainer.getChildren().add(boardView);
        BoardController boardController = loader.getController();
        Board.initPieces();
        System.out.println(Arrays.deepToString(Board.board));
        boardController.initDeplacement();
    }

    /**
     * Réinitialise la partie et affiche les blancs gagnant.
     */
    public void FFB(MouseEvent mouseEvent) {
        reset();
        CSVManager.Resultats(CSVManager.getNoms().get(CSVManager.getNoms().size() - 1), CSVManager.getNoms().get(CSVManager.getNoms().size() - 2), 'w');
    }

    /**
     * Réinitialise la partie et affiche les noirs gagnant.
     */
    public void FFW(MouseEvent mouseEvent) {
        reset();
        CSVManager.Resultats(CSVManager.getNoms().get(CSVManager.getNoms().size() - 1), CSVManager.getNoms().get(CSVManager.getNoms().size() - 2), 'b');
    }

    /**
     * Réinitialise l'affichage en masquant le plateau de jeu et en affichant les menus appropriés.
     * Réaffiche également le plateau de jeu en chargeant à nouveau le fichier FXML.
     */
    public void reset() {
        Play.setVisible(true);
        Gameplay.setVisible(false);
        Game.setVisible(false);
        Player.setVisible(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/exemple/sae201/View/BoardView.fxml"));
        try {
            boardView = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boardContainer.getChildren().clear();
        boardContainer.getChildren().add(boardView);
    }

    /**
     * Affiche la section "Tournament" et masque la section "Partie".
     */
    public void tournopen(MouseEvent mouseEvent) {
        Partie.setVisible(false);
        Tournament.setVisible(true);
    }

    /**
     * Affiche la section "Partie" et masque la section "Tournament".
     */
    public void tourquit(MouseEvent mouseEvent) {
        Partie.setVisible(true);
        Tournament.setVisible(false);
    }

    /**
     * Fonction pour démarrer un tournoi entre joueurs (non aboutie).
     */
    public void tourstart(MouseEvent mouseEvent) {
        String J1 = j1.getText();
        String J2 = j2.getText();
        String J3 = j3.getText();
        String J4 = j4.getText();
        String J5 = j5.getText();
        String J6 = j6.getText();
        String J7 = j7.getText();
        String J8 = j8.getText();
        g1.setText(J1);
        g2.setText(J3);
        g3.setText(J6);
        g4.setText(J8);
        DMG1.setText(J1);
        DMG2.setText(J6);
        DMP1.setText(J3);
        DMP2.setText(J8);
    }

    /**
     * Affiche le menu pour choisir le mode de jeu (local ou contre l'ordinateur).
     */
    public void setGamemode(MouseEvent mouseEvent) {
        listeParties.setVisible(false);
        modeLabel.setVisible(true);
        btnLocal.setVisible(true);
        btnBot.setVisible(true);
    }

    /**
     * Affiche l'historique des parties jouées.
     */
    public void setHistorique(MouseEvent mouseEvent) {
        modeLabel.setVisible(false);
        btnLocal.setVisible(false);
        btnBot.setVisible(false);
        listeParties.getChildren().clear();
        for (String partie : CSVManager.getParties()) {
            String[] resultat = partie.split(",");
            if (partie.charAt(partie.length() - 1) == 'w') {
                Label label = new Label(resultat[0] + " : 1 / " + resultat[1] + " : 0");
                label.setStyle("-fx-font-size: 18px;-fx-text-fill: white;");
                listeParties.getChildren().add(label);
            } else {
                Label label = new Label(resultat[1] + " : 1 / " + resultat[0] + " : 0");
                label.setStyle("-fx-font-size: 18px;-fx-text-fill: white;");
                listeParties.getChildren().add(label);
            }

        }
        listeParties.setVisible(true);
    }
    /**
     * Affiche la liste des joueurs dans une VBox.
     */
    public void afficherJoueur(MouseEvent mouseEvent) {
        vs.setVisible(false);
        ZoneB.setVisible(false);
        ZoneW.setVisible(false);
        listeJoueurs.getChildren().clear();
        for (String joueur : CSVManager.getNoms()) {
            Label label = new Label(joueur);
            label.setStyle("-fx-font-size: 18px;-fx-text-fill: white;");
            listeJoueurs.getChildren().add(label);
        }
        listeJoueurs.setVisible(true);
    }
    /**
     * Affiche les zones de nom des joueurs et masque la liste des joueurs.
     */
    public void enterName(MouseEvent mouseEvent) {
        listeJoueurs.setVisible(false);
        vs.setVisible(true);
        ZoneB.setVisible(true);
        ZoneW.setVisible(true);
    }
//    public void initialize(){
//        coup.setText("test\ntest");
//    }




//                                                                              initialiser le timer
//        if (timeline != null) {
//            timeline.stop();
//        }
//        if (timeline == null){
//            timeSeconds=600;
//        }
//
//        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
//            timeSeconds--;
////             tour des blancs
//            String timeW = formatTime(timeSeconds);
//            timerW.setText(timeW);
////             tour des noirs
////            String timeB = formatTime(timeSeconds);
////            timerB.setText(timeB);
//            if (timeSeconds <= 0) {
//                timeline.stop();
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//    }
//
//    private String formatTime(int seconds) {
//        int minutes = seconds / 60;
//        int remainingSeconds = seconds % 60;
//        return String.format("%02d:%02d", minutes, remainingSeconds);
//    }
}