package Projekat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author miskecpro
 */
public class PocetniPanel extends Application {

    private static String dif;

    @Override
    public void start(Stage primaryStage) {

        HBox hbox = new HBox();
        Projektni p = new Projektni();
        Button hardBtn = new Button("Hard");
        Button iziPiziBtn = new Button("Easy-peasy");
        Button mediumBtn = new Button("Medium");
        Button uputstvoBtn = new Button("Uputstvo");
        BorderPane border = new BorderPane();

        hardBtn.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        iziPiziBtn.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        mediumBtn.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        uputstvoBtn.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");

        hardBtn.setOnMouseClicked(e -> {
            setDif("hard");

            try {
                p.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        iziPiziBtn.setOnMouseClicked(e -> {
            setDif("iziPizi");
            try {
                p.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        mediumBtn.setOnAction((ActionEvent event) -> {
            setDif("medium");
            try {
                p.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        uputstvoBtn.setOnMouseClicked(e -> {
            try {
                Uputstvo u = new Uputstvo();
                u.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        Image image = new Image("Projekat/sudoku-logo.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(610);

        hbox.getChildren().addAll(iziPiziBtn, mediumBtn, hardBtn, uputstvoBtn);
        hbox.setSpacing(30);
        hbox.setAlignment(Pos.CENTER);
        
        border.setCenter(hbox);
        border.setBottom(imageView);

        Scene scene = new Scene(border, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void setDif(String dif) {
        PocetniPanel.dif = dif;
    }

    public static String getDif() {
        return dif;
    }
}
