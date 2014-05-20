/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;


/**
 *
 * @author Timothy
 */
public class Location
{
    /* Atribut */
    private int level;
    private int row;
    private int col;
    
    /* Constructor */
    public Location()
    {
        this.level = 0;
        this.row = 0;
        this.col = 0;
    }
    public Location(int row, int col, int level)
    {
        this.level = level;
        this.row = row;
        this.col = col;
    }
    
    /* Getter dan Setter */
    /* Setter */
    /**
     * 
     * @param level level where the player is currently at
     */
    public void setLevel(int level)
    {
        this.level = level;
    }
    /**
     * 
     * @param row row where the player is currently at
     */
    public void setRow(int row)
    {
        this.row = row;
    }
    /**
     * 
     * @param col column where the player is currently at
     */
    public void setCol(int col)
    {
        this.col = col;
    }
    /**
     * 
     * @param level level where the player is currently at
     * @param row row where the player is currently at
     * @param col column where the player is currently at
     */
    public void setLocation(int level, int row, int col)
    {
        this.level = level;
        this.row = row;
        this.col = col;
    }
    /* Getter */
    /**
     * 
     * @return level where the player is currently at
     */
    public int getLevel()
    {
        return level;
    }
    /**
     * 
     * @return row where the player is currently at
     */
    public int getRow()
    {
        return row;
    }
    /**
     * 
     * @return column where the player is currently at
     */
    public int getCol()
    {
        return col;
    }
    
    public String toString()
    {
        StringBuilder temp = new StringBuilder();
        temp.append("Baris = ");
        temp.append(row);
        temp.append("\n");
        temp.append("Kolom = ");
        temp.append(col);
        temp.append("\n");
        temp.append("Level = ");   
        temp.append(level);
        temp.append("\n");
        return temp.toString();
    }
}