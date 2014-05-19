/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character.Skill;

import character.Animation;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.lang.Math;
import character.Character;
/**
 *
 * @author kevinyu
 */
public class FireBall extends Skill {

    private AffineTransform transformer = new AffineTransform();
    
    /**
     * constructor
     */
    public FireBall(){
        BufferedImage image=null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Resource/Skill/fireball.bmp"));
        }catch(Exception e){ System.out.println("Gagal Load Image");
        e.printStackTrace(); }
        totalFrame = 50;
        loadImage(image);
        animation = new Animation();
        animation.setDelay(100);
        animation.setFrames(sprites);
        activeTime = 400;
        active = false;
        //set transformer base on direction
    }
    
    /**
     * method for start
     * @param x
     * @param y
     * @param direction 
     */
    public void start(int x,int y,int direction){
        mana = 5;
        active = true;
        startTime = System.nanoTime();
        animation.setFrame(0);
        this.direction = direction;
        xImage = x;
        yImage = y;
        calculatePosition(x,y,direction);
    }

    /**
     * method update
     */
    public void update(){
        animation.update();
        if (direction == 1){
            y+=4;
            yImage +=4;
        }
        else if (direction ==2){
            x-=4;
            xImage -= 4;
        }
        else if (direction == 3){
            y -= 4;
            yImage -= 4;
        }
        else if (direction == 4){
            x+=4;
            xImage += 4;
        }
        if ((System.nanoTime()-startTime)/1000000 > activeTime){
            active = false;
        }
    }
    
    /**
     * method draw
     * @param g
     * @param offsetX
     * @param offsetY 
     */
    public void draw(Graphics2D g,int offsetX,int offsetY){
        int xtmp = (int)xImage - + 16;
        int ytmp = (int)yImage - heightImage/2 + 16;
        g.rotate(Math.toRadians(direction*90),(int)xImage-offsetX+(16),(int)yImage-offsetY+(16));
        g.drawImage(animation.getImage(),xtmp-offsetX,ytmp-offsetY,null);
        g.rotate(Math.toRadians(-direction*90),(int)xImage-offsetX+(16),(int)yImage-offsetY+(16));
    }
    
    /**
     * method check hitting
     * @param enemy
     * @return 
     */
    public boolean checkHitting(Character enemy){
        return isObjectCollision(enemy);
    }
    
}
