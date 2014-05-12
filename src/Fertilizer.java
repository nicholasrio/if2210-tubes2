/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author William Stefan
 */
import java.util.*;

public class Fertilizer
{
    private int level, buyprice;
    
    public Fertilizer()
    {
        this.level = 0;
        this.buyprice = 0;
    }
    
    public Fertilizer(int new_level, int new_buyprice)
    {
        this.level = new_level;
        this.buyprice = new_buyprice;
    }
    
    public void setlevel(int new_level)
    {
        this.level = new_level;
    }
    
    public void setbuyprice(int new_buyprice)
    {
        this.buyprice = new_buyprice;
    }
    
    public int getlevel()
    {
        return (this.level);
    }
    
    public int getbuyprice()
    {
        return (this.buyprice);
    }
    
    public void print()
    {
        System.out.println("level: " + level);
        System.out.println("buyprice: " + buyprice);
    }
}