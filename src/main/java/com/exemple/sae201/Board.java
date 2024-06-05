//controller
//package com.exemple.sae201;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Board {
//
//    private VBox board;
//    private Map<StackPane, int[]> squareCoordinates;
//
//    public Board() {            //appel la fonction qui initialise l echequier
//        board = new VBox();
//        squareCoordinates = new HashMap<>();
//        createBoard();
//    }
//
//    public void createBoard() {
//        for (int i = 0; i < 8; i++) {                                        //initialise l echequier
//            HBox row = new HBox();
//            for (int j = 0; j < 8; j++) {
//                StackPane square = new StackPane();
//                square.setPrefSize(100, 100);
//                if ((i + j) % 2 == 0) {
//                    square.setStyle("-fx-background-color: #637084");
//                } else {
//                    square.setStyle("-fx-background-color: #282f3e");
//                }
//                squareCoordinates.put(square, new int[]{i, j});             //permet de garder les var i et j pour le placement des piece et leur deplecment
//                row.getChildren().add(square);
//                placePiece(i, j, square);                                   //appel la fonction pour initialiser les piece
//            }
//            board.getChildren().add(row);
//        }
//    }
//
//    public VBox getBoard() {
//        return board;
//    }
//
//    private void placePiece(int i, int j, StackPane square) {
//        String imagePath = null;
//
//        if (i == 0 && j == 0 || i == 0 && j == 7) {                     //initialise les piece  |
//            imagePath = "/com/exemple/sae201/img/br.png";               //                      V
//        } else if (i == 1 && j >= 0 && j <= 7) {
//            imagePath = "/com/exemple/sae201/img/bp.png";
//        } else if (i == 0 && j == 1 || i == 0 && j == 6) {
//            imagePath = "/com/exemple/sae201/img/bn.png";
//        } else if (i == 0 && j == 2 || i == 0 && j == 5) {
//            imagePath = "/com/exemple/sae201/img/bb.png";
//        } else if (i == 0 && j == 3) {
//            imagePath = "/com/exemple/sae201/img/bq.png";
//        } else if (i == 0 && j == 4) {
//            imagePath = "/com/exemple/sae201/img/bk.png";
//        } else if (i == 7 && j == 0 || i == 7 && j == 7) {
//            imagePath = "/com/exemple/sae201/img/wr.png";
//        } else if (i == 6 && j >= 0 && j <= 7) {
//            imagePath = "/com/exemple/sae201/img/wp.png";
//        } else if (i == 7 && j == 1 || i == 7 && j == 6) {
//            imagePath = "/com/exemple/sae201/img/wn.png";
//        } else if (i == 7 && j == 2 || i == 7 && j == 5) {
//            imagePath = "/com/exemple/sae201/img/wb.png";
//        } else if (i == 7 && j == 3) {
//            imagePath = "/com/exemple/sae201/img/wq.png";
//        } else if (i == 7 && j == 4) {
//            imagePath = "/com/exemple/sae201/img/wk.png";
//        }
//
//        if (imagePath != null) {
//            Image image = new Image(getClass().getResource(imagePath).toString());
//            ImageView imageView = new ImageView(image);
//            imageView.setFitWidth(100);
//            imageView.setFitHeight(100);
//            square.getChildren().add(imageView);
//        }
//    }
//}