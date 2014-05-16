/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.lang.Math;
import java.awt.Color;
/**
 *
 * @author kevinyu
 */
public class FireBall extends MapEntity {
    BufferedImage[] sprites;
    private int direction;
    private long startTime;
    private boolean remove;
    private AffineTransform transformer = new AffineTransform();
    
    public FireBall(int x,int y,int direction){
        this.x=x;
        this.y=y;
        this.direction = direction;
        loadImage();
        animation = new Animation();
        animation.setDelay(100);
        animation.setFrames(sprites);
        startTime = System.nanoTime();
        remove = false;
        
        //set transformer base on direction
    }
    
    public boolean shouldRemove(){
        return remove;
    }
    
    public void loadImage(){
        sprites = new BufferedImage[5];
        BufferedImage spriteSheet = null;
        try {
            spriteSheet = ImageIO.read(getClass().getResourceAsStream("/Hero/fireball3.gif"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        for (int i=0;i<5;i++){
            width = spriteSheet.getWidth()/5;
            height = spriteSheet.getHeight();
            sprites[i] = spriteSheet.getSubimage(i*width,0*height,width,height);
        }
    }
    
    public void update(){
        animation.update();
        if (direction == 1){
            y-=4;
        }
        else if (direction ==2){
            x+=4;
        }
        else if (direction == 3){
            y+=4;
        }
        else if (direction == 4){
            x-=4;
        }
        if ((System.nanoTime()-startTime)/1000000 > 1000){
            remove = true;
        }
    }
    
    public void draw(Graphics2D g,int offsetX,int offsetY){
        g.rotate(Math.toRadians(direction*90),(int)x-offsetX+(width/2),(int)y-offsetY+(height/2));
        g.drawImage(animation.getImage(),(int)x-offsetX,(int)y-offsetY,null);
        g.rotate(Math.toRadians(-direction*90),(int)x-offsetX+(width/2),(int)y-offsetY+(height/2));
    }
    
}
