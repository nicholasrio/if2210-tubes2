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

    /**
     * Constructor
     * 
     * @param maxLevel maximum Level of Map
     * @param maxRow maximum Row of Map
     * @param maxCol maximum Col of Map
     */
    public Map(int maxLevel,int maxRow, int maxCol){
        this.maxLevel = maxLevel;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        matrix = new int[maxLevel][maxRow][maxCol];
    }

    /**
     * Copy Constructor
     * <p>
     * This copy constructor copy Map entity by reference
     * </p>
     * @param others Map
     */
    public Map(Map others)
    {
        this.matrix = others.matrix;
        this.maxCol = others.maxCol;
        this.maxRow = others.maxRow;
        this.maxLevel = others.maxLevel;
    }

    /**
     * Get element
     * @param level level of Map
     * @param row row of Map
     * @param col column of Map
     * @return Map element
     */
    public int getElement(int level,int row,int col){
        return matrix[level][row][col];
    }

    /**
     * Set element
     * @param level level of Map
     * @param row row of Map
     * @param col column of Map
     * @param value integer value
     */
    public void setElement(int level,int row, int col, int value){
        matrix[level][row][col] = value; 
    }

    /**
     * Get max level
     * @return max level of Map
     */
    public int getMaxLevel(){
        return maxLevel;
    }

    /**
     * Get max row
     * @return max row of Map
     */
    public int getMaxRow(){
        return maxRow;
    }

    /**
     * Get max column
     * @return max column of Map
     */
    public int getMaxCol(){
        return maxCol;
    }

    /**
     *Load data to this Map from file
     */
    public void loadFromMap(){
        //Belum direalisasikan
    }

    /**
     * Find Location of start point
     * @return Location of start
     * @throws Exception
     */
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
