/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import engine.DataStructure.GameData;
import engine.Exception.SceneNotFoundException;
import static engine.Game.gameFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tjong
 */
public class LevelMenuGUI extends Scene
{
    // attributes
    private final int NLevel = 2;
    private int menuPressed;
    private boolean unlocked;
    public static int nowLevel;
    
    /* Textures */
    private static Image bgTexture;
    private static Image groupnameTexture;
    private static Image levelTexture;
    private static Image titleLvlTexture;    
    private static Image LorULTexture;    
    private static Image ArrowTexture;
    private static Image Arrow2Texture;
    private static Image BackTexture;
    
    /*Sound*/
    private static String arrowSound;
    
    /* Rectangles */
    private Rectangle startRect;
    private Rectangle rightArrowRect;
    private Rectangle leftArrowRect;
    private Rectangle backRect;
    
    public LevelMenuGUI()
    {
        super("LevelMenuGUI");
        menuPressed = -1;
              
        nowLevel=1;
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
                mouseUpdatePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) 
            {
                try {
                    mouseUpdateReleased(e);
                } catch (SceneNotFoundException ex) {
                    Logger.getLogger(LevelMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) 
            {}

            @Override
            public void mouseExited(MouseEvent e) 
            {}
        });        
    }
    
    /**
     * Me-load semua isi dari scene LevelMenu
     */
    public void LoadContent()
    {
        // load Image here
        // using ImageLoader.getImage
        switch (nowLevel)
        {
            case 1: bgTexture = ImageLoader.getImage("frozen_cube");
                    groupnameTexture = ImageLoader.getImage("cube_mazer_ice");
                    levelTexture = ImageLoader.getImage("level_ice");
                    titleLvlTexture = ImageLoader.getImage("ice_mage");
                    LorULTexture=ImageLoader.getImage("unlocked_ice");
                    ArrowTexture=ImageLoader.getImage("ice_arrow");
                    BackTexture=ImageLoader.getImage("back_ice");
                    break;
            case 2: bgTexture = ImageLoader.getImage("burning_cube");
                    groupnameTexture = ImageLoader.getImage("cube_mazer_fire");
                    levelTexture = ImageLoader.getImage("level_fire");
                    titleLvlTexture = ImageLoader.getImage("fire_maze");        
                    ArrowTexture=ImageLoader.getImage("fire_arrow");
                    Arrow2Texture=ImageLoader.getImage("fire_arrow_2");
                    BackTexture=ImageLoader.getImage("back_fire");
                    break;
        }
    }
    
    /**
     * Menginisialisasi element di scene LevelMenuGUI
     */
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(this);
        this.LoadContent();  
        menuPressed=-1;
        unlocked=true;
        
        /*Background music*/
        SoundManager.stopAllBGMSound();
        SoundManager.playSound("levelBm");
        
        /* Rectangle */
        startRect = new Rectangle(250,150,300,300);        
        rightArrowRect = new Rectangle(624, 190,200,100);
        leftArrowRect = new Rectangle(0,190, 200,100);                                   
        backRect = new Rectangle(570,480,200,120);                                
    }
    
    /**
     * Update Scene levelMenuGUI
     */
    @Override
    public void Update()
    {
        if (menuPressed==3){
            if (nowLevel<NLevel)   {
                nowLevel++;
                this.LoadContent();
            }   
            menuPressed=-1;
        }
        else if (menuPressed==4){
            if (nowLevel>1)   {
                nowLevel--;        
                this.LoadContent();
            }
            menuPressed=-1;
        }        
        if (nowLevel==1){
            arrowSound="fall";
            unlocked=true;
        }
        else if (nowLevel==2){
            
            arrowSound="fall";
            if (nowLevel<=GameData.lastLogin.getLevelUnlocked()+1){            
                LorULTexture=ImageLoader.getImage("unlocked_fire");                        
                unlocked=true;
            }
            else{
                LorULTexture=ImageLoader.getImage("locked_fire");            
                unlocked=false;
            }
        }
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
    
    /**
     * Melakukan drawing Scene LevelMenuGUI
     * @param g 
     */
    @Override
    public void paint(Graphics g)
    {
        if (Game.mode == 2)
        {
            Graphics2D g2D = (Graphics2D) g;     
            if (nowLevel==1){
                g2D.drawImage(bgTexture, 0, 0,getWidth(),getHeight(), this);
                g2D.drawImage(groupnameTexture, (int) (getWidth()*0.23f), (int) (getHeight()*0.05f),
                        (int) (groupnameTexture.getWidth(this)*0.7f),(int) (groupnameTexture.getHeight(this)*0.7f), this);                                  
                g2D.drawImage(levelTexture, (int) (getWidth()*0.32f), (int) (getHeight()*0.25f),
                        (int) (levelTexture.getWidth(this)*0.7f),(int) (levelTexture.getHeight(this)*0.7f), this);
                g2D.drawImage(titleLvlTexture, (int) (getWidth()*0.29f), (int) (getHeight()*0.45f), 
                        (int) (titleLvlTexture.getWidth(this)*0.7f),(int) (titleLvlTexture.getHeight(this)*0.7f), this);
                g2D.drawImage(LorULTexture, (int) (getWidth()*0.27f), (int) (getHeight()*0.65f), 
                        (int) (LorULTexture.getWidth(this)*0.7f),(int) (LorULTexture.getHeight(this)*0.7f), this);            
                g2D.drawImage(ArrowTexture, (int) (getWidth()*0.78f), (int) (getHeight()*0.35f), 
                        (int) (ArrowTexture.getWidth(this)*0.5f),(int) (ArrowTexture.getHeight(this)*0.5f), this);
                g2D.drawImage(BackTexture, (int) (getWidth()*0.76f), (int) (getHeight()*0.85f), 
                        (int) (BackTexture.getWidth(this)*0.7f),(int) (BackTexture.getHeight(this)*0.7f), this);                
            }
            else if (nowLevel==2){
                g2D.drawImage(bgTexture, 0, 0,getWidth(),getHeight(), this);
                g2D.drawImage(groupnameTexture, (int) (getWidth()*0.23f), (int) (getHeight()*0.05f),
                        (int) (groupnameTexture.getWidth(this)*0.7f),(int) (groupnameTexture.getHeight(this)*0.7f), this);                                  
                g2D.drawImage(levelTexture, (int) (getWidth()*0.38f), (int) (getHeight()*0.25f),
                        (int) (levelTexture.getWidth(this)*0.7f),(int) (levelTexture.getHeight(this)*0.7f), this);
                g2D.drawImage(titleLvlTexture, (int) (getWidth()*0.35f), (int) (getHeight()*0.45f), 
                        (int) (titleLvlTexture.getWidth(this)*0.7f),(int) (titleLvlTexture.getHeight(this)*0.7f), this);
                g2D.drawImage(Arrow2Texture, -20, (int) (getHeight()*0.35f), 
                        (int) (Arrow2Texture.getWidth(this)*0.5f),(int) (Arrow2Texture.getHeight(this)*0.5f), this);
                if (nowLevel<=GameData.lastLogin.getLevelUnlocked()){                            
                    g2D.drawImage(LorULTexture, (int) (getWidth()*0.35f), (int) (getHeight()*0.65f), 
                        (int) (LorULTexture.getWidth(this)*0.73f),(int) (LorULTexture.getHeight(this)*0.7f), this);                                
                }
                else{
                    g2D.drawImage(LorULTexture, (int) (getWidth()*0.38f), (int) (getHeight()*0.65f), 
                        (int) (LorULTexture.getWidth(this)*0.73f),(int) (LorULTexture.getHeight(this)*0.7f), this);                                
                }
                g2D.drawImage(BackTexture, (int) (getWidth()*0.73f), (int) (getHeight()*0.7f), 
                        (int) (BackTexture.getWidth(this)*0.7f),(int) (BackTexture.getHeight(this)*0.7f), this);
            }

            // paint Image here
            // using g2D.drawImage
        }
    }
    
    void mouseUpdatePressed(MouseEvent event)
    {        
        if (startRect.contains(event.getPoint()))
        {
            menuPressed = 1;
            System.out.println("Start");
        }
        else if (rightArrowRect.contains(event.getPoint()))
        {
            if (nowLevel < NLevel)
            {
                menuPressed = 3;
                SoundManager.playSound(arrowSound);
            }
        }
        else if (leftArrowRect.contains(event.getPoint()))
        {
            if (nowLevel>1)
            {
                menuPressed = 4;
                SoundManager.playSound(arrowSound);
            }
        }
        else if (backRect.contains(event.getPoint()))
        {
            menuPressed = 2;
            SoundManager.playSound(arrowSound);
            System.out.println("Back Button");
        }
    }
    
    void mouseUpdateReleased(MouseEvent event) throws SceneNotFoundException
    {        
        if (menuPressed ==1){
            if (unlocked){
                SceneManager.SwitchScene("GameMenuGUI");     
            }
            else{
                menuPressed=-1;
            }
        }
        else if (menuPressed==2){
            SceneManager.SwitchScene("MainMenuGUI");                    
        } 
    }
}

