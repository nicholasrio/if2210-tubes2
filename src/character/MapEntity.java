/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character;

import java.awt.Graphics2D;
import java.awt.image.*;
import java.awt.Rectangle;

/**
 *
 * @author kevinyu
 */
public abstract class MapEntity {
    //position attribute
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected Animation animation;      
    protected BufferedImage spriteSheet;
    
    public void setWidth(int _width) { width = _width; }
    public void setHeight(int _height) { height = _height; }
    public double getPositionX(){ return x;}
    public double getPositionY(){ return y;}
    public int getWidth(){ return width;}
    public int getHeight(){ return height;}
      
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    //check if this Character collide with another character
    public boolean isObjectCollision (MapEntity c){
        Rectangle r1 = this.getRectangle();
        Rectangle r2 = c.getRectangle();
        return r1.intersects(r2);
    }
    
    //Mendapatkan area Segi Emptat Kolision dari MapEntity
    public Rectangle getRectangle(){
        return new Rectangle((int)x
                            ,(int)y
                            ,width,height);
    }
    public abstract void draw(Graphics2D g,int offsetX,int offsetY);
    
    public abstract void loadImage(BufferedImage image);
    
}