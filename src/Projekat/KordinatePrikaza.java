package Projekat;


import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class KordinatePrikaza {

    public KordinatePrikaza() {
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

    public String[][] vracanjeModifikovanogNizaStringova1HardVerzija(String[][] nizStringova1) {
        for (int i = 0; i < 60; i++) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            if (nizStringova1[row][col].equals("")) {
                i--;
            } else {
                nizStringova1[row][col] = "";
            }
        }
        return nizStringova1;
    }

    public String[][] vracanjeModifikovanogNizaStringova1MediumVerzija(String[][] nizStringova2) {
        for (int i = 0; i < 40; i++) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            if (nizStringova2[row][col].equals("")) {
                i--;
            } else {
                nizStringova2[row][col] = "";
            }
        }
        return nizStringova2;
    }

    public String[][] vracanjeModifikovanogNizaStringova1IziVerzija(String[][] nizStringova3) {
        for (int i = 0; i < 20; i++) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            if (nizStringova3[row][col].equals("")) {
                i--;
            } else {
                nizStringova3[row][col] = "";
            }
        }
        return nizStringova3;
    }

    public GridPane vracanjeGrida(String[][] nizStringova) {

        GridPane gr = new GridPane();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField txt = new TextField();
                TextField txt1 = new TextField();
                txt.setStyle("-fx-background-color: orange;");
                txt1.setStyle("-fx-background-color: green;");
                txt.setText(nizStringova[j][i]);
                txt.setEditable(false);
                gr.add(txt, i, j);
                if (nizStringova[j][i].equals("")) {
                    gr.add(txt1, i, j);
                }
            }
        }
        return gr;
    }
}
