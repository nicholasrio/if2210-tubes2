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
public class Map implements Cloneable{
    public Map(int maxLevel,int maxRow, int maxCol){
        this.maxLevel = maxLevel;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        matrix = new int[maxLevel][maxRow][maxCol];
    }
    public Map(Map others)
    {
        this.matrix = others.matrix;
        this.maxCol = others.maxCol;
        this.maxRow = others.maxRow;
        this.maxLevel = others.maxLevel;
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
    public Location getStart() throws Exception{
        int level = 0;
        int row = 0;
        int col = 0;
        boolean Found = false;
        Location location = new Location();
        
        while(level < maxLevel && !Found)
        {
            row = 0;
            while(row < maxRow && !Found)
            {
                col = 0;
                while(col < maxCol && !Found)
                {
                    if(getElement(level, row, col) == -1) // Menemukan posisi start
                    {
                        Found = true;
                    }
                    else
                    {
                        col++;
                    }
                }
                row++;
            }
            level++;
        }
        if(Found)
        {
            return new Location(level,row,col);
        }
        else
        {
            throw new Exception("Tidak ditemukan titik start pada map");
        }
    }
        
    private final int maxLevel,maxRow,maxCol;
    private int matrix[][][];
}
