/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author miskecpro
 */
public class Solver extends Application {

    static int[][] samostalniSudoku = new int[9][9];
    static int[][] proveraSamostalnogSudokua = new int[9][9];
    GeneratorSolvera gs;

    @Override
    public void start(Stage primaryStage) {
        gs = new GeneratorSolvera();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Greska");
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
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

        Button btnProveri = new Button("Proveri");
        Button btnClearAll = new Button("Clear all");
        Button btnBack = new Button("Back");
        btnProveri.setMinWidth(110);
        btnProveri.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnClearAll.setMinWidth(110);
        btnClearAll.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");
        btnBack.setMinWidth(110);
        btnBack.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");

        Line line1 = new Line(437, 44, 24, 44);
        Line line2 = new Line(437, 149, 24, 149);
        Line line3 = new Line(437, 254, 24, 254);
        Line line4 = new Line(437, 359, 24, 359);

        Line line5 = new Line(24, 45, 24, 358);
        Line line6 = new Line(160, 45, 160, 358);
        Line line7 = new Line(297, 45, 297, 358);
        Line line8 = new Line(437, 45, 437, 358);

        line1.setStrokeWidth(3);
        line2.setStrokeWidth(3);
        line3.setStrokeWidth(3);
        line4.setStrokeWidth(3);
        line5.setStrokeWidth(3);
        line6.setStrokeWidth(3);
        line7.setStrokeWidth(3);
        line8.setStrokeWidth(3);

        konacanGrid = vracanjeGrida();
        konacanGrid.setVgap(10);
        konacanGrid.setHgap(10);
        konacanGrid.setAlignment(Pos.CENTER);
        konacanGrid.setMaxWidth(400);
        konacanGrid.setMinHeight(400);

        TextField[][] gridPaneNodes = new TextField[9][9];
        for (Node child : konacanGrid.getChildren()) {
            Integer column = GridPane.getColumnIndex(child);
            Integer row = GridPane.getRowIndex(child);
            if (column != null && row != null) {
                gridPaneNodes[row][column] = (TextField) child;
            }
        }

        btnProveri.setOnAction(e -> {
            uzimanjeVrednostisaGrida(gridPaneNodes);
            boolean flag = true;
            for (int g = 0; g < 9; g++) {
                for (int r = 0; r < 9; r++) {
                    gridPaneNodes[g][r].setStyle("-fx-background-color: orange;");
                    if (samostalniSudoku[g][r] == 0) {
                        proveraSamostalnogSudokua[g][r] = samostalniSudoku[g][r];
                    } else if (samostalniSudoku[g][r] >= 10) {
                            flag = false;
                            gridPaneNodes[g][r].setStyle("-fx-background-color: red;");
                            brisanjeUzetihVrednostiSaGrida();
                            brisanjeVrednostiZaGenerator();
                    } else if (samostalniSudoku[g][r] != 0 && samostalniSudoku[g][r] < 10) {
                        if (gs.dozvoljenoStavljanje(g, r, samostalniSudoku[g][r])) {
                            proveraSamostalnogSudokua[g][r] = samostalniSudoku[g][r];
                            gridPaneNodes[g][r].setStyle("-fx-background-color: orange;");
                        } else {
                            flag = false;
                            gridPaneNodes[g][r].setStyle("-fx-background-color: red;");
                            brisanjeUzetihVrednostiSaGrida();
                            brisanjeVrednostiZaGenerator();
                            break;

                        }
                    }
                }
            }

            if (flag == false) {
                alert.setContentText("Nije ti to nesto tacno, pokusaj opet");
                alert.show();
            } else {
                alert1.setContentText("Lepo si popunio");
                alert1.show();
                gs.formiraj();
                gs.stampajSudoku();
                popuniRealGrid(gridPaneNodes);
                brisanjeUzetihVrednostiSaGrida();
                brisanjeVrednostiZaGenerator();
            }
        });

        btnBack.setOnAction(e -> {
            Projektni projekt = new Projektni();
            projekt.start(primaryStage);
        });

        btnClearAll.setOnAction(e -> {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    gridPaneNodes[i][j].setText("");
                }
            }
        });

        hbox.getChildren().addAll(vbox, konacanGrid);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setSpacing(30);

        vboxRight.getChildren().addAll(btnProveri, btnBack, btnClearAll);
        vboxRight.setAlignment(Pos.CENTER);
        vboxRight.setSpacing(30);

        hboxRight.getChildren().addAll(vboxRight, new Label());
        hboxRight.setAlignment(Pos.CENTER);
        hboxRight.setSpacing(30);

        p1.getChildren().add(hboxRight);
        p1.setTranslateX(500);
        p1.setTranslateY(50);

        p.getChildren().addAll(hbox, line1, line2, line3, line4, line5, line6, line7, line8, p1);
        p.setTranslateX(150);
        p.setTranslateY(50);

        border.setTop(hbox1);
        border.setBottom(new Label());
        border.setCenter(p);

        Scene scene = new Scene(border, 800, 500);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public GridPane vracanjeGrida() {

        GridPane gr = new GridPane();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField txt = new TextField();
                txt.setStyle("-fx-background-color: orange;");
                txt.setEditable(true);
                gr.add(txt, i, j);
            }
        }
        return gr;
    }

    public String[][] konvertovanjeTxtFildovaUNizStringova(TextField[][] gridPaneNodes) {
        String nizStringovaResenje[][] = new String[gridPaneNodes.length][gridPaneNodes.length];
        for (int i = 0; i < gridPaneNodes.length; i++) {
            for (int j = 0; j < gridPaneNodes.length; j++) {
                nizStringovaResenje[i][j] = gridPaneNodes[i][j].getText();
            }
        }
        return nizStringovaResenje;
    }

    public int[][] konvertovanjeNizaStringovaUNizBrojeva(String[][] nizStringova) {
        int[][] niz = new int[nizStringova.length][nizStringova.length];
        for (int i = 0; i < nizStringova.length; i++) {
            for (int j = 0; j < nizStringova.length; j++) {
                try {
                    niz[i][j] = Integer.parseInt(nizStringova[i][j]);
                } catch (NumberFormatException ex) {
                }
            }
        }
        return niz;
    }

    public String[][] konvertovanNizBrojevaUString(int[][] nizBrojeva) {
        String str[][] = new String[nizBrojeva.length][nizBrojeva.length];
        for (int i = 0; i < nizBrojeva.length; i++) {
            for (int j = 0; j < nizBrojeva.length; j++) {
                str[i][j] = String.valueOf(nizBrojeva[i][j]);
            }
        }
        return str;
    }

    public static int[][] getSamostaniSudoku() {
        return samostalniSudoku;
    }

    public static int[][] getProveraSamostaniSudoku() {
        return proveraSamostalnogSudokua;
    }

    public void popuniRealGrid(TextField[][] gridPaneNodes) {
        int[][] nizBrojevaResenje;
        nizBrojevaResenje = gs.getNiz();
        String nizStampanjeKonacno[][];
        nizStampanjeKonacno = konvertovanNizBrojevaUString(nizBrojevaResenje);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                gridPaneNodes[i][j].setText(nizStampanjeKonacno[i][j]);
            }
        }
    }

    public void uzimanjeVrednostisaGrida(TextField[][] gridPaneNodes) {
        String nizStringovaResenje[][];
        nizStringovaResenje = konvertovanjeTxtFildovaUNizStringova(gridPaneNodes);
        int[][] nizBrojeva;
        nizBrojeva = konvertovanjeNizaStringovaUNizBrojeva(nizStringovaResenje);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                samostalniSudoku[i][j] = nizBrojeva[i][j];
            }
        }
    }

    public void brisanjeUzetihVrednostiSaGrida() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                samostalniSudoku[i][j] = 0;
            }
        }
    }

    public void brisanjeVrednostiZaGenerator() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                proveraSamostalnogSudokua[i][j] = 0;
            }
        }
    }

}
