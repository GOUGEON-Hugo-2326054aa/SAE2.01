//controller
package com.exemple.sae201.Controller;

import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class FullViewController {

    @FXML
    private VBox Play,Player, Game,Gameplay;
    @FXML
    private HBox ZoneB,ZoneW,Playbutton,Tournament,Partie;
    @FXML
    private MenuButton TimerChooser;
    @FXML
    private Label timerW,timerB,NB,NW,coup;
    @FXML
    private TextField BName,WName;
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
        if (setwnam == true && setbname == true) {
            Ready.setVisible(true);
        }
    }
    public void SendWName (MouseEvent mouseEvent) {   //set le nom des blancs
        String Wname = WName.getText();
        NW.setText(Wname);
        setwnam = true;
        if (setwnam == true && setbname == true){
            Ready.setVisible(true);
        }
    }

    public void LocalStart(MouseEvent mouseEvent) {     //start la partie locale
        if (setwnam == true && setbname == true) {
            Gameplay.setVisible(true);
            Game.setVisible(false);
            Play.setVisible(false);
            Player.setVisible(false);
        }
    }
    public void FFB(MouseEvent mouseEvent){
        Play.setVisible(true);
        Gameplay.setVisible(false);
        Game.setVisible(false);
        Player.setVisible(false);
    }
    public void FFW(MouseEvent mouseEvent){
        Play.setVisible(true);
        Gameplay.setVisible(false);
        Game.setVisible(false);
        Player.setVisible(false);
    }
    public void tournopen(MouseEvent mouseEvent){
        Partie.setVisible(false);
        Tournament.setVisible(true);
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