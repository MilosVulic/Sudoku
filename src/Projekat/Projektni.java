package Projekat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author miskecpro
 */
public class Projektni extends Application {

    @Override
    public void start(Stage primaryStage) {
        Generator g = new Generator();
        KordinatePrikaza kordinata = new KordinatePrikaza();

        int[][] nizBrojeva = null;
        if (g.formiraj() == true) {
            g.stampajSudoku();
            nizBrojeva = g.getNiz();
        }

        List<Integer> mogucaPolja1 = new ArrayList<>();
        List<Integer> mogucaPolja2 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            mogucaPolja1.add(i);
            mogucaPolja2.add(i);
        }

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Greska");
        Alert alert1 = new Alert(AlertType.CONFIRMATION);
        alert1.setTitle("Potvrda");

        BorderPane border = new BorderPane();
        GridPane konacanGrid;
        HBox hbox = new HBox();
        HBox hbox1 = new HBox();
        VBox vbox = new VBox();
        Pane p = new Pane();
        Pane p1 = new Pane();
        VBox vboxRight = new VBox();
        HBox hboxRight = new HBox();

        Image image = new Image("Projekat/homebutton.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(50);

        Button btnProveri = new Button("Proveri");
        Button btnFillAll = new Button("Resi sve");
        Button btnFillOne = new Button("Hintuj mi jednom");
        Button btnBack = new Button("Back", imageView);
        Button btnClear = new Button("Clear sve");
        Button btnClearOne = new Button("Clear jedno");
        Button btnSolveMyOwn = new Button("Solve my own");

        btnProveri.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnFillAll.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnFillOne.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnBack.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnClear.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnClearOne.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnSolveMyOwn.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");    

        Line line1 = new Line(447, 44, 38, 44);
        Line line2 = new Line(447, 149, 38, 149);
        Line line3 = new Line(447, 254, 38, 254);
        Line line4 = new Line(447, 359, 38, 359);

        Line line5 = new Line(37, 45, 37, 358);
        Line line6 = new Line(172, 45, 172, 358);
        Line line7 = new Line(309, 45, 309, 358);
        Line line8 = new Line(447, 45, 447, 358);

        line1.setStrokeWidth(3);
        line2.setStrokeWidth(3);
        line3.setStrokeWidth(3);
        line4.setStrokeWidth(3);
        line5.setStrokeWidth(3);
        line6.setStrokeWidth(3);
        line7.setStrokeWidth(3);
        line8.setStrokeWidth(3);

        Label l1 = new Label("1");
        Label l2 = new Label("2");
        Label l3 = new Label("3");
        Label l4 = new Label("4");
        Label l5 = new Label("5");
        Label l6 = new Label("6");
        Label l7 = new Label("7");
        Label l8 = new Label("8");
        Label l9 = new Label("9");

        l1.setFont(Font.font("Verdana", 18));
        l2.setFont(Font.font("Verdana", 18));
        l3.setFont(Font.font("Verdana", 18));
        l4.setFont(Font.font("Verdana", 18));
        l5.setFont(Font.font("Verdana", 18));
        l6.setFont(Font.font("Verdana", 18));
        l7.setFont(Font.font("Verdana", 18));
        l8.setFont(Font.font("Verdana", 18));
        l9.setFont(Font.font("Verdana", 18));

        l1.setTranslateX(0);
        l1.setTranslateY(48);
        l2.setTranslateX(0);
        l2.setTranslateY(61);
        l3.setTranslateX(0);
        l3.setTranslateY(74);
        l4.setTranslateX(0);
        l4.setTranslateY(84);
        l5.setTranslateX(0);
        l5.setTranslateY(98);
        l6.setTranslateX(0);
        l6.setTranslateY(111);
        l7.setTranslateX(0);
        l7.setTranslateY(121);
        l8.setTranslateX(0);
        l8.setTranslateY(134);
        l9.setTranslateX(0);
        l9.setTranslateY(147);

        Label t1 = new Label("1");
        Label t2 = new Label("2");
        Label t3 = new Label("3");
        Label t4 = new Label("4");
        Label t5 = new Label("5");
        Label t6 = new Label("6");
        Label t7 = new Label("7");
        Label t8 = new Label("8");
        Label t9 = new Label("9");

        t1.setFont(Font.font("Verdana", 18));
        t2.setFont(Font.font("Verdana", 18));
        t3.setFont(Font.font("Verdana", 18));
        t4.setFont(Font.font("Verdana", 18));
        t5.setFont(Font.font("Verdana", 18));
        t6.setFont(Font.font("Verdana", 18));
        t7.setFont(Font.font("Verdana", 18));
        t8.setFont(Font.font("Verdana", 18));
        t9.setFont(Font.font("Verdana", 18));

        t1.setTranslateY(70);
        t1.setTranslateX(-145);
        t2.setTranslateY(70);
        t2.setTranslateX(-115);
        t3.setTranslateY(70);
        t3.setTranslateX(-80);
        t4.setTranslateY(70);
        t4.setTranslateX(-42);
        t5.setTranslateY(70);
        t5.setTranslateX(-14);
        t6.setTranslateY(70);
        t6.setTranslateX(20);
        t7.setTranslateY(70);
        t7.setTranslateX(54);
        t8.setTranslateY(70);
        t8.setTranslateX(88);
        t9.setTranslateY(70);
        t9.setTranslateX(120);


        vbox.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9);
        hbox1.getChildren().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(0);

        String nizStringovaResenje[][];
        nizStringovaResenje = kordinata.konvertovanNizBrojevaUString(nizBrojeva);

        String nizStringovaPocetno1[][];
        nizStringovaPocetno1 = kordinata.konvertovanNizBrojevaUString(nizBrojeva);

        String nizStringovaPocetno2[][];
        nizStringovaPocetno2 = kordinata.konvertovanNizBrojevaUString(nizBrojeva);

        String nizStringovaPocetno3[][];
        nizStringovaPocetno3 = kordinata.konvertovanNizBrojevaUString(nizBrojeva);

        String nizStringova1[][];
        nizStringova1 = kordinata.vracanjeModifikovanogNizaStringova1HardVerzija(nizStringovaPocetno1);

        String nizStringova2[][];
        nizStringova2 = kordinata.vracanjeModifikovanogNizaStringova1MediumVerzija(nizStringovaPocetno2);

        String nizStringova3[][];
        nizStringova3 = kordinata.vracanjeModifikovanogNizaStringova1IziVerzija(nizStringovaPocetno3);

        System.out.println(PocetniPanel.getDif());
        if (PocetniPanel.getDif().equals("hard")) {
            konacanGrid = kordinata.vracanjeGrida(nizStringova1);
        } else if (PocetniPanel.getDif().equals("medium")) {
            konacanGrid = kordinata.vracanjeGrida(nizStringova2);
        } else {
            konacanGrid = kordinata.vracanjeGrida(nizStringova3);
        }

        TextField[][] gridPaneNodes = new TextField[9][9];
        for (Node child : konacanGrid.getChildren()) {
            Integer column = GridPane.getColumnIndex(child);
            Integer row = GridPane.getRowIndex(child);
            if (column != null && row != null) {
                gridPaneNodes[column][row] = (TextField) child;
            }
        }

        btnProveri.setMinWidth(110);
        btnProveri.setOnAction(e -> {
            boolean flag = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (!gridPaneNodes[j][i].getText().equals(nizStringovaResenje[i][j])) {
                        System.out.println("Izfejlao si");
                        flag = false;
                        break;
                    } else {
                        System.out.println("dobar si dobar");
                        flag = true;
                    }
                }
            }

            if (flag == true) {
                alert1.setContentText("Sve ti je tacno, svaka cast brt");
                alert1.show();
            } else {
                alert.setContentText("Nije ti to nesto tacno, pokusaj opet");
                alert.show();
            }

        });
        btnFillOne.setMinWidth(110);
        btnFillOne.setOnAction(e -> {
            Collections.shuffle(mogucaPolja1);
            Collections.shuffle(mogucaPolja2);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int broj1 = mogucaPolja1.get(i);
                    int broj2 = mogucaPolja2.get(j);
                    if (gridPaneNodes[broj1][broj2].getText().equals("")) {
                        gridPaneNodes[broj1][broj2].setText(nizStringovaResenje[broj2][broj1]);
                        return;
                    }
                }
            }
        });

        btnFillAll.setMinWidth(110);
        btnFillAll.setOnAction(e -> {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (gridPaneNodes[j][i].getText().equals("")) {
                        gridPaneNodes[j][i].setText(nizStringovaResenje[i][j]);
                    }
                }
            }
        });

        btnClear.setMinWidth(110);
        btnClear.setOnAction(e -> {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (PocetniPanel.getDif().equals("hard")) {
                        gridPaneNodes[j][i].setText(nizStringova1[i][j]);
                    } else if (PocetniPanel.getDif().equals("medium")) {
                        gridPaneNodes[j][i].setText(nizStringova2[i][j]);
                    } else {
                        gridPaneNodes[j][i].setText(nizStringova3[i][j]);
                    }
                }
            }
        });

        btnClearOne.setMinWidth(110);
        btnClearOne.setOnAction(e -> {

            Collections.shuffle(mogucaPolja1);
            Collections.shuffle(mogucaPolja2);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int broj1 = mogucaPolja1.get(i);
                    int broj2 = mogucaPolja2.get(j);
                    if (PocetniPanel.getDif().equals("hard")) {
                        if (!gridPaneNodes[broj1][broj2].getText().equals(nizStringova1[broj2][broj1])) {
                            gridPaneNodes[broj1][broj2].setText(nizStringova1[broj2][broj1]);
                            return;
                        }
                    } else if (PocetniPanel.getDif().equals("medium")) {
                        if (!gridPaneNodes[broj1][broj2].getText().equals(nizStringova2[broj2][broj1])) {
                            gridPaneNodes[broj1][broj2].setText(nizStringova2[broj2][broj1]);
                            return;
                        }
                    } else {
                        if (!gridPaneNodes[broj1][broj2].getText().equals(nizStringova3[broj2][broj1])) {
                            gridPaneNodes[broj1][broj2].setText(nizStringova3[broj2][broj1]);
                            return;
                        }
                    }
                }
            }
        });

        btnBack.setMinWidth(110);
        btnBack.setOnAction(e -> {
            PocetniPanel pocetni = new PocetniPanel();
            pocetni.start(primaryStage);
        });

        btnSolveMyOwn.setMinWidth(110);
        btnSolveMyOwn.setOnAction(e -> {
            Solver s = new Solver();
            s.start(primaryStage);
        });

        konacanGrid.setVgap(10);
        konacanGrid.setHgap(10);
        konacanGrid.setAlignment(Pos.CENTER);
        konacanGrid.setMaxWidth(400);
        konacanGrid.setMinHeight(400);

        hbox.getChildren().addAll(vbox, konacanGrid);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setSpacing(30);

        vboxRight.getChildren().addAll(btnProveri, btnFillAll, btnFillOne, btnClear, btnClearOne, btnBack, btnSolveMyOwn);
        vboxRight.setAlignment(Pos.CENTER);
        vboxRight.setSpacing(30);

        hboxRight.getChildren().addAll(vboxRight, new Label());
        hboxRight.setAlignment(Pos.CENTER);
        hboxRight.setSpacing(30);

        p1.getChildren().add(hboxRight);
        p1.setTranslateX(500);
        p1.setTranslateY(20);

        p.getChildren().addAll(hbox, line1, line2, line3, line4, line5, line6, line7, line8, p1);
        p.setTranslateX(150);
        p.setTranslateY(50);

        border.setTop(hbox1);
        border.setBottom(new Label());
        border.setCenter(p);

        Scene scene = new Scene(border, 800, 500);

        primaryStage.setTitle("Sudoku!");
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
}
