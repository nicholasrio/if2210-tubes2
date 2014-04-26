/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package theplants;

/**
 *
 * @author William Stefan
 */
import java.util.*;

public class Vehicle
{
    private int speed, capacity;
    
    public Vehicle()
    {
        this.speed = 0;
        this.capacity = 0;
    }
    
    public Vehicle(int new_speed, int new_capacity)
    {
        this.speed = new_speed;
        this.capacity = new_capacity;
    }
    
    public void setspeed(int new_speed)
    {
        this.speed = new_speed;
    }
    
    public void setcapacity(int new_capacity)
    {
        this.capacity = new_capacity;
    }
    
    public int getspeed()
    {
        return (this.speed);
    }
    
    public int getcapacity()
    {
        return (this.capacity);
    }
    
    public void print()
    {
        System.out.println("speed: " + speed);
        System.out.println("capacity: " + capacity);
    }
}