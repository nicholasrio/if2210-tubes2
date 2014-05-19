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
    /**
     * position x
     */
    protected double x;
    /**
     * position y
     */
    protected double y;
    /**
     * integer width
     */
    protected int width;
    /**
     * integer height
     */
    protected int height;
    /**
     * animation
     */
    protected Animation animation;      
    /**
     * image for sprite
     */
    protected BufferedImage spriteSheet;
    
    /**
     * method get position x
     * @return 
     */
    public double getPositionX(){ return x;}
    /**
     * method get position y
     * @return 
     */
    public double getPositionY(){ return y;}
    /**
     * method get width
     * @return 
     */
    public double getWidth(){ return width;}
    /**
     * method get height
     * @return 
     */
    public double getHeight(){ return height;}
      
    /**
     * method set position
     * @param x
     * @param y 
     */
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    //check if this Character collide with another character
    /**
     * method is object collision
     * @param c
     * @return 
     */
    public boolean isObjectCollision (MapEntity c){
        Rectangle r1 = this.getRectangle();
        Rectangle r2 = c.getRectangle();
        return r1.intersects(r2);
    }
    
    //Mendapatkan area Segi Emptat Kolision dari MapEntity
    /**
     * method get rectangle
     * @return 
     */
    public Rectangle getRectangle(){
        return new Rectangle((int)x
                            ,(int)y
                            ,width,height);
    }
    /**
     * method for draw
     * @param g
     * @param offsetX
     * @param offsetY 
     */
    public abstract void draw(Graphics2D g,int offsetX,int offsetY);
    
    /**
     * method for load image
     * @param image 
     */
    public abstract void loadImage(BufferedImage image);
    
}