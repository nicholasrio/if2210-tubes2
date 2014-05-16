/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import static engine.Game.gameFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Tony
 */
public class LevelMenuGUI extends Scene
{
    // attributes
    private static Image bgTexture;
    private static Image groupnameTexture;
    private static Image levelTexture;
    private static Image titleLvlTexture;    
    private static Image LorULTexture;    
    
    public LevelMenuGUI()
    {
        super("LevelMenuGUI");
        /*addMouseMotionListener(new MouseMotionListener()){

            @Override
            public void mouseDragged(MouseEvent f) {
                
            };

            @Override
            public void mouseMoved(MouseEvent f) {
                
            };
        }*/
}
    
    public void LoadContent()
    {
        // load Image here
        // using ImageLoader.getImage
        bgTexture = ImageLoader.getImage("burning_cube");
        groupnameTexture = ImageLoader.getImage("cube_mazer_ice");
        levelTexture = ImageLoader.getImage("level_ice");
        titleLvlTexture = ImageLoader.getImage("ice_mage");
        LorULTexture=ImageLoader.getImage("unlocked_ice");
        
    }
    
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(this);
        this.LoadContent();
    }
    
    @Override
    public void Update()
    {
        
        
    }
    
    @Override
    public void Draw()
    {
        if (Game.mode == 2)
        {
            Game.gameFrame.revalidate();
            Game.gameFrame.repaint();
        }
    }
    
    @Override
    public void paint(Graphics g)
    {
        if (Game.mode == 2)
        {
            Graphics2D g2D = (Graphics2D) g;                                    
            g2D.drawImage(bgTexture, 0, 0,getWidth(),getHeight(), this);
            g2D.drawImage(groupnameTexture, (int) (getWidth()*0.23f), (int) (getHeight()*0.05f),
                    (int) (groupnameTexture.getWidth(this)*0.7f),(int) (groupnameTexture.getHeight(this)*0.7f), this);                                  
            g2D.drawImage(levelTexture, (int) (getWidth()*0.32f), (int) (getHeight()*0.25f),
                    (int) (levelTexture.getWidth(this)*0.7f),(int) (levelTexture.getHeight(this)*0.7f), this);
            g2D.drawImage(titleLvlTexture, (int) (getWidth()*0.29f), (int) (getHeight()*0.45f), 
                    (int) (titleLvlTexture.getWidth(this)*0.7f),(int) (titleLvlTexture.getHeight(this)*0.7f), this);
            g2D.drawImage(LorULTexture, (int) (getWidth()*0.27f), (int) (getHeight()*0.65f), 
                    (int) (LorULTexture.getWidth(this)*0.7f),(int) (LorULTexture.getHeight(this)*0.7f), this);            
            // paint Image here
            // using g2D.drawImage
        }
    }
}
