package com.exemple.sae201;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class FullViewController {

    @FXML
    private VBox Play;
    @FXML
    private VBox Game;
    @FXML
    private VBox Player;
    @FXML
    private MenuButton TimerChooser;
    @FXML
    private Label timerW;
    @FXML
    private Label timerB;
    @FXML
    private StackPane TimercadreW,TimercadreB;
    private Timeline timeline;
    private int timeSeconds;

    public void Game(MouseEvent mouseEvent) {
        Game.setVisible(true);
        Play.setVisible(false);
        Player.setVisible(false);
        System.out.println("Game");
    }

    public void NewGame(MouseEvent mouseEvent) {
        Play.setVisible(true);
        Game.setVisible(false);
        Player.setVisible(false);
        System.out.println("Play");
    }

    public void Player(MouseEvent mouseEvent) {
        Player.setVisible(true);
        Play.setVisible(false);
        Game.setVisible(false);
        System.out.println("Player");
    }

    public void timeset5(Event event) {
        TimerChooser.setText("     5 min    ");
        timerW.setText("5:00");
        timerB.setText("5:00");
        timeSeconds = 300; // 5 minutes in seconds
        System.out.println("time5");
        timeline.stop();
    }

    public void timeset10(Event event) {
        TimerChooser.setText("    10 min    ");
        timerW.setText("10:00");
        timerB.setText("10:00");
        timeSeconds = 600; // 10 minutes in seconds
        System.out.println("time10");
        timeline.stop();
    }

    public void timeset15(Event event) {
        TimerChooser.setText("    15 min    ");
        timerW.setText("15:00");
        timerB.setText("15:00");
        timeSeconds = 900; // 15 minutes in seconds
        System.out.println("time15");
        timeline.stop();
    }

    public void Start(MouseEvent mouseEvent) {
        Game.setVisible(true);
        Play.setVisible(false);
        Player.setVisible(false);
        System.out.println("Game");
    }







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