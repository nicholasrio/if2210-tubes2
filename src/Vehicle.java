/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
/**
 *
 * @author William Stefan
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Vehicle
{
    private int speed, capacity, distance = 100;
    private ArrayList<SaleableObjects> ArrofSaleableObjects = new ArrayList<SaleableObjects>(capacity);
    private Image imgVeh;
    
    public Vehicle()
    {
        ImageIcon ii = ii = new ImageIcon("tanker-truck.png");
        imgVeh = ii.getImage();
        this.speed = 10;
        this.capacity = 10;
    }
    
    public void Upgrade()
    {
        this.speed += 2;
        this.capacity += 2;
    }
    
    public int getSpeed()
    {
        return (this.speed);
    }
    
    public int getCapacity()
    {
        return (this.capacity);
    }
    
    public Image getImage(){
        return imgVeh;
    }
    
    public void printVehicleStat()
    {
        System.out.println("speed: " + speed);
        System.out.println("capacity: " + capacity);
    }
    
    public void printVehicleContents()
    {
        for(int i = 0; i < ArrofSaleableObjects.size(); i++)
        {
            System.out.println("nama: " + ArrofSaleableObjects.get(i).getName());
            System.out.println("harga: " + ArrofSaleableObjects.get(i).getPrice());
            System.out.println("kapasitas: " + ArrofSaleableObjects.get(i).getCapacity());
            System.out.println();
        }
    }
    
    public void emptyAll()
    {
        ArrofSaleableObjects.removeAll(ArrofSaleableObjects);
    }
    
    public int saleAll()
    {
        int sumMoney = 0;
        for(int i = 0; i < ArrofSaleableObjects.size(); i++)
        {
            sumMoney += ArrofSaleableObjects.get(i).getPrice();
        }
        emptyAll();
        return sumMoney;
    }
    
    public void addItem(SaleableObjects item)
    {
        ArrofSaleableObjects.add(item);
    }
    
    public void go()
    {
        while (distance > 0)
        {
            distance -= speed;
        }
        System.out.println("Sudah sampai.");
        distance = 100;
    }
}