/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameState;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.Graphics2D;
import java.awt.Font;

/**
 *
 * @author kevinyu
 */
public class StatusBar {
    
    BufferedImage statusBarImage;
    
    private int HP;
    private int Mana;
    
    public int getHP() { return HP; }
    public int getMana() { return Mana; }
    
    public void setHP(int _hp) { this.HP = _hp; }
    public void setMana(int _Mana) { this.Mana = _Mana; }
    
    public void init() {
        try {
            statusBarImage = ImageIO.read(getClass().getResourceAsStream("/Resource/StatusBar/StatusBar.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void draw (Graphics2D g){
        g.drawImage(statusBarImage,10,10,null); 
        g.setFont(new Font("ComicSanMS", Font.BOLD, 12)); 
        g.drawString(Integer.toString(HP),60,23);
        g.drawString(Integer.toString(Mana), 60, 43);
    }
    
    public void update(int _HP,int _Mana){
        HP = _HP;
        Mana = _Mana;
    }
    
}
