/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import engine.DataStructure.*;
import static engine.Game.gameFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Tony
 */
public class GameMenuGUI extends Scene
{
    /* Textures */
    private Image pathTexture;
    private Image wallTexture;
    private Image goldTexture;
    private Image teleporterTexture;
    private Image holeTexture;
            
    private int nowlevelPlay;
    private int mazeSize;
    private int nowFloor;
    private int initMapPosHeight;
    private int initMapPosWidth;
    private Map playedMap;
    
    public GameMenuGUI()
    {
        super("GameMenuGUI");
        
        //nowlevelPlay = GameData.nowLevelPlayed;
        nowlevelPlay = 0;
        nowFloor = 0;
        playedMap = GameData.dataMap.get(nowlevelPlay);
        switch(nowlevelPlay)
        {
            case 0: mazeSize = 6; break;
        }
    }
    
    public void LoadContent()
    {
        switch (nowlevelPlay)
        {
            case 0: pathTexture = ImageLoader.getImage("ice_path");
                    wallTexture = ImageLoader.getImage("ice_wall");
                    holeTexture = ImageLoader.getImage("ice_hole");
                    teleporterTexture = ImageLoader.getImage("ice_teleporter");
                    goldTexture = ImageLoader.getImage("ice_gold");
                    //ImageLoader.getImage("ice_char_RL");
                    //ImageLoader.getImage("ice_char_UD");
                    break;
        }
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
            for (int bar=0;bar<mazeSize;bar++)
            {
                for (int kol=0;kol<mazeSize;kol++)
                {
                    Location loc = new Location(bar,kol,nowFloor);
                    if (playedMap.getElement(loc).getName().equalsIgnoreCase("road"))
                    {
                        int width = pathTexture.getWidth(this);
                        int height = pathTexture.getHeight(this);
                        g2D.drawImage(pathTexture,width*kol,height*bar,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("wall"))
                    {
                        int width = wallTexture.getWidth(this);
                        int height = wallTexture.getHeight(this);
                        g2D.drawImage(wallTexture,width*kol,height*bar,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("coin"))
                    {
                        int width = goldTexture.getWidth(this);
                        int height = goldTexture.getHeight(this);
                        g2D.drawImage(goldTexture,width*kol,height*bar,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("hole"))
                    {
                        int width = holeTexture.getWidth(this);
                        int height = holeTexture.getHeight(this);
                        g2D.drawImage(holeTexture,width*kol,height*bar,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("teleporter"))
                    {
                        int width = teleporterTexture.getWidth(this);
                        int height = teleporterTexture.getHeight(this);
                        g2D.drawImage(teleporterTexture,width*kol,height*bar,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("start"))
                    {
                        int width = teleporterTexture.getWidth(this);
                        int height = teleporterTexture.getHeight(this);
                        g2D.drawImage(teleporterTexture,width*kol,height*bar,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("finish"))
                    {
                        int width = teleporterTexture.getWidth(this);
                        int height = teleporterTexture.getHeight(this);
                        g2D.drawImage(teleporterTexture,width*kol,height*bar,width,height,this);
                    }
                }
            } 
        }
    }
}
