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
    protected int direction;
    protected long startTime;
    protected boolean active;
    protected int damage;
    protected int activeTime; //Waktu hingga animasi selesai;
    protected int mana;
    protected int totalFrame;
    public abstract boolean checkHitting(Character enemy);
    protected int widthImage;
    protected int heightImage;
    protected int xImage;
    protected int yImage;
    
    public int getDamage(){ return damage;}
    public int getActiveTime(){ return activeTime;}
    public int getMana() { return mana; }
    public boolean isActive() { return active; }
    
    public void setDamage(int _damage) { damage = _damage; }
    public void setActiveTime(int _activeTime){ activeTime = _activeTime; }
    public void setMana(int _mana){ mana = _mana; }
    
    public abstract void update();
    
    public abstract void draw(Graphics2D g,int offsetX,int offsetY);
    
    public abstract void start(int x,int y,int direction);
    
    public void loadImage(BufferedImage image){
        sprites = new BufferedImage[totalFrame];
        spriteSheet = image;
        for (int i=0;i<totalFrame;i++){
            widthImage = spriteSheet.getWidth()/totalFrame;
            heightImage = spriteSheet.getHeight();
            sprites[i] = spriteSheet.getSubimage(i*widthImage,0*heightImage,widthImage,heightImage);
        }
    }
    
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
