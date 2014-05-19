/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character.Skill;

import character.Animation;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import map.Map;

/**
 *
 * @author kevinyu
 */
public class Celoblast extends Skill{

    
    private AffineTransform transformer = new AffineTransform();
    
    /**
     * method celoblast
     */
    public Celoblast(){
        BufferedImage image=null;
        totalFrame = 29 ;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Resource/Skill/Celoblast.bmp"));
        }catch(Exception e){ e.printStackTrace(); }
        
        loadImage(image);
        animation = new Animation();
        animation.setDelay(60);
        animation.setFrames(sprites);
        activeTime = (1740);
        active = false;
        this.damage = 500;
        //set transformer base on direction
    }
    
    /**
     * method start
     * @param _x
     * @param _y
     * @param direction 
     */
    public void start(int _x,int _y,int direction){
        this.direction = direction;
        mana = 40;
        active = true;
        startTime = System.nanoTime();
        animation.setFrame(0);
        xImage = _x;
        yImage = _y;
        calculatePosition(_x,_y,direction);
    }

    /**
     * method update
     */
    public void update(){
        animation.update();
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
        System.out.println(direction);
        int xtmp = (int)xImage - 20 + 16;
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
    public boolean checkHitting(character.Character enemy){
        return isObjectCollision(enemy);
    }
    
}
