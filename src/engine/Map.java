/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

/**
 *
 * @author Winson
 */
public class Map {
    public Map(int maxLevel,int maxRow, int maxCol){
        this.maxLevel = maxLevel;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        matrix = new int[maxLevel][maxRow][maxCol];
    }
    public int getElement(int level,int row,int col){
        return matrix[level][row][col];
    }
    public void setElement(int level,int row, int col, int value){
        matrix[level][row][col] = value; 
    }
    public int getMaxLevel(){
        return maxLevel;
    }
    public int getMaxRow(){
        return maxRow;
    }
    public int getMaxCol(){
        return maxCol;
    }
    public void loadFromMap(){
        //Belum direalisasikan
    }
    private final int maxLevel,maxRow,maxCol;
    private int matrix[][][];
}
