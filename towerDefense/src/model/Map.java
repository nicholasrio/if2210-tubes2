/**
 *
 * @author 
 * Darwin Prasetio (13512015)
 * Chrestella Stephanie (13512005)
 * Jan Wira Gotama Putra (13512015)
 * Eric (13512021)
 * Willy(13512070)
 * Melvin FOnda (13512085)
 */

package model;

import java.io.*;
import java.util.Scanner;

public class Map {

    public static int[][] Peta;
    public static int row;
    public static int col;

    /** Read Map data from file */
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

    /** Show map to layar */
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

    /** Testing purpose only */
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
