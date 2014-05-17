package model;

import java.io.*;
import java.util.Scanner;

public class Map {

    public static int[][] Peta;
    public static int row;
    public static int col;

    public static void readFile() throws FileNotFoundException, IOException {
        row = 15;
        col = 20;

        Peta = new int[row][col];
        Scanner fin = new Scanner(new File("matriks.txt"));
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                Peta[i][j] = fin.nextInt();
            }
        }
        fin.close();
    }

    public static int getElement(int i, int j){
        return Peta[i][j];
    }

    public static void showMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (Peta[i][j] == 256) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Map M = new Map();
        try {
            M.readFile();
        } catch (IOException ex) {
            System.out.println("File not found");
        }
        M.showMap();
    }
}
