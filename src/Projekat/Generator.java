package Projekat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {

    private final int[][] sudoku;
    private final List<Integer> mogucaResenja = new ArrayList<>();

    public Generator() {
        for (int i = 1; i <= 9; i++) {
            mogucaResenja.add(i);
        }
        sudoku = new int[9][9];
    }

    private boolean validnostRed(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean validnostKolona(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean validnostManjiGrid(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudoku[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dozvoljenoStavljanje(int row, int col, int number) {
        if (validnostRed(row, number) == false || validnostKolona(col, number) == false || validnostManjiGrid(row, col, number) == false) {
            return false;
        }
        return true;
    }

    public void stampajSudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println(" ");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("  ");
                }
                System.out.print(" " + sudoku[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(" ");
    }

    public boolean formiraj() {
        for (int i = 0; i < 81; i++) {
                int row = i / 9;
                int col = i % 9;
                if (sudoku[row][col] == 0) {
                    for (int number = 0; number < mogucaResenja.size(); number++) {
                        if (col == 0) {
                            Collections.shuffle(mogucaResenja);
                        }
                        int broj1 = mogucaResenja.get(number);
                        if (dozvoljenoStavljanje(row, col, broj1) == true) {
                            sudoku[row][col] = broj1;
                            if (formiraj() == true) {
                                return true;
                            } else {
                                sudoku[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }        
          }
        return true;
    }

    public int[][] getNiz() {
        return this.sudoku;
    }
}
