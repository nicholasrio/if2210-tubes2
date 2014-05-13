/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

/**
 *
 * @author Winson
 */
public class Map{
    private final int maxLevel,maxRow,maxCol;
    private GameItem matrix[][][];
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
        matrix = new GameItem[maxLevel][maxRow][maxCol];
        for(int i=0;i<maxLevel;i++)
            for(int j=0;j<maxRow;j++)
                for(int k=0;k<maxCol;k++)
                    matrix[i][j][k] = new RoadItem();
    }
    
    public Map(String namaFile){
        this.maxLevel = 5;
        this.maxRow = 5;
        this.maxCol = 5;
        matrix = new GameItem[maxLevel][maxRow][maxCol];
        for(int i=0;i<maxLevel;i++)
            for(int j=0;j<maxRow;j++)
                for(int k=0;k<maxCol;k++)
                    matrix[i][j][k] = new RoadItem();
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
     * @param L Location of Map
     * @return Map element
     */
    public GameItem getElement(Location L){
        return matrix[L.getLevel()][L.getRow()][L.getCol()];
    }

    /**
     * Set element
     * @param L level of Map
     * @param value value of Map
     */
    public void setElement(Location L, GameItem value){
        matrix[L.getLevel()][L.getRow()][L.getCol()] = value; 
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
     * Find Location of start point
     * @return Location of start
     * @throws Exception
     */
    public Location getStart() throws Exception{
        for(int i=0;i<maxLevel;i++)
            for(int j=0;j<maxRow;j++)
                for(int k=0;k<maxCol;k++)
                    if(matrix[i][j][k].getName().equalsIgnoreCase("start"))
                        return new Location(i,j,k);
        throw new Exception("Tidak menemukan start.");
    }
}

