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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Arrays;

public class FullViewController {

    @FXML
    private VBox Play,Player, Game,Gameplay;
    @FXML
    private HBox ZoneB,ZoneW,Playbutton,Tournament,Partie;
    @FXML
    private MenuButton TimerChooser;
    @FXML
    private Label timerW,timerB,NB,NW,coup,g1,g2,g3,g4,DMG1,DMG2,DMP1,DMP2;
    @FXML
    private TextField BName,WName,j1,j2,j3,j4,j5,j6,j7,j8;
    @FXML
    private ImageView WP1;
    @FXML
    private StackPane A3;
    @FXML
    private Button Ready;
    @FXML
    private StackPane TimercadreW,TimercadreB;
    private Timeline timeline;
    private int timeSeconds;
    private StackPane currentcase;
    private boolean setbname,setwnam = false;
    private GridPane boardView ;
    @FXML
    private StackPane boardContainer;

    public void Game(MouseEvent mouseEvent) {           //affiche le menu Game
        Game.setVisible(true);
        Play.setVisible(false);
        Player.setVisible(false);
    }

    public void NewGame(MouseEvent mouseEvent) {        //affiche le menu NewGame
        Play.setVisible(true);
        Game.setVisible(false);
        Player.setVisible(false);
    }

    public void Player(MouseEvent mouseEvent) {         //affiche le menu Player
        Player.setVisible(true);
        Play.setVisible(false);
        Game.setVisible(false);
        Ready.setVisible(false);
    }

    public void timeset5(Event event){                   //set le timer a 5 minutes
        TimerChooser.setText("     5 min    ");
        timerW.setText("5:00");
        timerB.setText("5:00");
        timeSeconds = 300; // 5 minutes en secondes
        timeline.stop();
    }

    public void timeset10(Event event) {                // set le timer a 10 minutes
        TimerChooser.setText("    10 min    ");
        timerW.setText("10:00");
        timerB.setText("10:00");
        timeSeconds = 600; // 10 minutes en secondes
        timeline.stop();
    }

    public void timeset15(Event event) {                //set le timer a 15 minutes
        TimerChooser.setText("    15 min    ");
        timerW.setText("15:00");
        timerB.setText("15:00");
        timeSeconds = 900; // 15 minutes en secondes
        timeline.stop();
    }
    public void SendBName (MouseEvent mouseEvent) {   //set le nom des noirs
        String Bname = BName.getText();
        NB.setText(Bname);
        setbname=true;
        verifName();
    }
    public void SendWName (MouseEvent mouseEvent) {   //set le nom des blancs
        String Wname = WName.getText();
        NW.setText(Wname);
        System.out.println(NW.getText());
        setwnam = true;
        verifName();
    }

    public void verifName(){
        if (!NW.getText().equals("") && !NB.getText().equals("") && setwnam == true && setbname == true){
            Ready.setVisible(true);
        }
    }

    public void LocalStart(MouseEvent mouseEvent) {     //start la partie locale
        if (setwnam == true && setbname == true) {
            Gameplay.setVisible(true);
            Game.setVisible(false);
            Play.setVisible(false);
            Player.setVisible(false);
            CSVManager.Joueurs(WName.getText(), BName.getText());
            start();
        }
    }
    public void start(){
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
    public void FFB(MouseEvent mouseEvent){
        reset();
        CSVManager.Resultats(CSVManager.getNoms().get(CSVManager.getNoms().size()-1), CSVManager.getNoms().get(CSVManager.getNoms().size()-2),'w');
    }
    public void FFW(MouseEvent mouseEvent){
        reset();
        CSVManager.Resultats(CSVManager.getNoms().get(CSVManager.getNoms().size()-1), CSVManager.getNoms().get(CSVManager.getNoms().size()-2),'b');
    }
    public void reset(){
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
    public void tournopen(MouseEvent mouseEvent){
        Partie.setVisible(false);
        Tournament.setVisible(true);
    }
    public void tourquit(MouseEvent mouseEvent) {
        Partie.setVisible(true);
        Tournament.setVisible(false);
    }
    public void tourstart(MouseEvent mouseEvent){
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