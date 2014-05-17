/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character;

import java.awt.Graphics2D;

/**
 *
 * @author kevinyu
 */
public class MapEntity {
    //position attribute
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected Animation animation;
    
    public double getPositionX(){ return x;}
    public double getPositionY(){ return y;}
    public double getWidth(){ return width;}
    public double getHeight(){ return height;}
      
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    //check if this Character collide with another character
    public boolean isObjectCollision (MapEntity c){
        
        //implement later
        return true;
    }
    
    public void draw(Graphics2D g,int offsetX,int offsetY){
        g.drawImage(animation.getImage(),(int)x-offsetX,(int)y-offsetY,null);
    }
    
}