/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package character.Skill;

import java.awt.image.BufferedImage;
import character.MapEntity;
import java.awt.Graphics2D;
import character.Character;

/**
 *
 * @author kevinyu
 */
public abstract class Skill extends MapEntity{
    
    BufferedImage[] sprites;
    /**
     * method integer direction
     */
    protected int direction;
    /**
     * method long start time
     */
    protected long startTime;
    /**
     * method boolean active
     */
    protected boolean active;
    /**
     * method integer damage
     */
    protected int damage;
    /**
     * method integer active time
     */
    protected int activeTime; //Waktu hingga animasi selesai;
    /**
     * method integer mana
     */
    protected int mana;
    /**
     * method integer total frame
     */
    protected int totalFrame;
    /**
     * method check hitting
     * @param enemy
     * @return 
     */
    public abstract boolean checkHitting(Character enemy);
    /**
     * integer width image
     */
    protected int widthImage;
    /**
     * integer height image
     */
    protected int heightImage;
    /**
     * integer ximage
     */
    protected int xImage;
    /**
     * integer yimage
     */
    protected int yImage;
    
    /**
     * method get damage
     * @return 
     */
    public int getDamage(){ return damage;}
    /**
     * method get active time
     * @return 
     */
    public int getActiveTime(){ return activeTime;}
    /**
     * method get mana
     * @return 
     */
    public int getMana() { return mana; }
    /**
     * method is active
     * @return 
     */
    public boolean isActive() { return active; }
    /**
     * method set damage
     * @param _damage 
     */
    public void setDamage(int _damage) { damage = _damage; }
    /**
     * method set active time
     * @param _activeTime 
     */
    public void setActiveTime(int _activeTime){ activeTime = _activeTime; }
    /**
     * method set mana
     * @param _mana 
     */
    public void setMana(int _mana){ mana = _mana; }
    
    /**
     * method update
     */
    public abstract void update();
    
    /**
     * method draw
     * @param g
     * @param offsetX
     * @param offsetY 
     */
    public abstract void draw(Graphics2D g,int offsetX,int offsetY);
    
    /**
     * method start
     * @param x
     * @param y
     * @param direction 
     */
    public abstract void start(int x,int y,int direction);
    
    /**
     * method load image
     * @param image 
     */
    public void loadImage(BufferedImage image){
        sprites = new BufferedImage[totalFrame];
        spriteSheet = image;
        for (int i=0;i<totalFrame;i++){
            widthImage = spriteSheet.getWidth()/totalFrame;
            heightImage = spriteSheet.getHeight();
            sprites[i] = spriteSheet.getSubimage(i*widthImage,0*heightImage,widthImage,heightImage);
        }
    }
    
    /**
     * method calculate position
     * @param _x
     * @param _y
     * @param direction 
     */
    public void calculatePosition(int _x,int _y, int direction){
        if (direction == 1){
            width = heightImage;
            height = widthImage;
            x = _x + 16 - width/2;
            y = _y + 16;
        }
        else if (direction == 2){
            width = widthImage;
            height = heightImage;
            x = _x + 16 - width;
            y = _y + 16 - height/2;
        }
        else if (direction == 3){
            width = heightImage;
            height = widthImage;
            x = _x + 16 - width/2;
            y = _y + 16 - height;
        }
        else if (direction == 4){
            width = widthImage;
            height = heightImage;
            x = _x + 16;
            y = _y + 16;
        }
        
    }
}
