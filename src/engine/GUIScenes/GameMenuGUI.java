/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import engine.DataStructure.*;
import static engine.Game.gameFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    private Image playerRLTexture;
    private Image playerUDTexture;
            
    private int nowlevelPlay;
    private int mazeSize;
    private int nowFloor;
    private int initPosMapWidth;
    private int initPosMapHeight;
    private int playerPosX;
    private int playerPosY;
    private Map playedMap;
    
    private boolean keyUpPressed;
    private boolean keyDownPressed;
    private boolean keyRightPressed;
    private boolean keyLeftPressed;
    
    private int playerFaced; // 1 for Up
                             // 2 for Down
                             // 3 for Right
                             // 4 for Left
    
    public GameMenuGUI()
    {
        super("GameMenuGUI");
        
        
        
        //nowlevelPlay = GameData.nowLevelPlayed;
        nowlevelPlay = 0;
        nowFloor = 0;
        playedMap = GameData.dataMap.get(nowlevelPlay);
        
        keyUpPressed = false;
        keyDownPressed = false;
        keyRightPressed = false;
        keyLeftPressed = false;
        
        playerFaced = 3;
        
        playerPosX = 180;
        playerPosY = 490;
        switch(nowlevelPlay)
        {
            case 0: mazeSize = 6; 
                    initPosMapWidth = 165;
                    initPosMapHeight = 110;
                    break;
        }
        
        addKeyListener(new KeyListener() 
        {

            @Override
            public void keyTyped(KeyEvent e) 
            {
                
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                keyboardUpdatePressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
                keyboardUpdateReleased(e);
            }
        });
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
                    playerRLTexture = ImageLoader.getImage("ice_char_RL");
                    playerUDTexture = ImageLoader.getImage("ice_char_UD");
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
                        g2D.drawImage(pathTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("wall"))
                    {
                        int width = wallTexture.getWidth(this);
                        int height = wallTexture.getHeight(this);
                        g2D.drawImage(wallTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("coin"))
                    {
                        int width = goldTexture.getWidth(this);
                        int height = goldTexture.getHeight(this);
                        g2D.drawImage(goldTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("hole"))
                    {
                        int width = holeTexture.getWidth(this);
                        int height = holeTexture.getHeight(this);
                        g2D.drawImage(holeTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("teleporter"))
                    {
                        int width = teleporterTexture.getWidth(this);
                        int height = teleporterTexture.getHeight(this);
                        g2D.drawImage(teleporterTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("start"))
                    {
                        int width = teleporterTexture.getWidth(this);
                        int height = teleporterTexture.getHeight(this);
                        g2D.drawImage(teleporterTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
                    }
                    else if (playedMap.getElement(loc).getName().equalsIgnoreCase("finish"))
                    {
                        int width = teleporterTexture.getWidth(this);
                        int height = teleporterTexture.getHeight(this);
                        g2D.drawImage(teleporterTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
                    }
                }
            } 
            
            switch (playerFaced)
            {
                case 1: g2D.drawImage(playerUDTexture,playerPosX,playerPosY,playerPosX+39,playerPosY+71,0,0,39,76,this);
                        break;
                case 2: g2D.drawImage(playerUDTexture,playerPosX,playerPosY,playerPosX+39,playerPosY+71,0,76,39,152,this);
                        break;
                case 3: g2D.drawImage(playerRLTexture,playerPosX,playerPosY,playerPosX+48,playerPosY+63,0,0,48,63,this);
                        break;
                case 4: g2D.drawImage(playerRLTexture,playerPosX,playerPosY,playerPosX+48,playerPosY+63,0,63,48,126,this);
                        break;
            }
        }
    }
    
    public void keyboardUpdatePressed(KeyEvent e)
    {
        System.out.println("A");
                int keyCode = e.getKeyCode();
                switch (keyCode)
                {
                    case KeyEvent.VK_UP: keyUpPressed = true;
                                         playerFaced = 1;
                                         break;

                    case KeyEvent.VK_DOWN: keyDownPressed = true;
                                           playerFaced = 2;

                                           break;

                    case KeyEvent.VK_RIGHT: keyRightPressed = true;
                                            playerFaced = 3;
                                            break;

                    case KeyEvent.VK_LEFT: keyLeftPressed = true;
                                           playerFaced = 4;
                                           break;
                }
    }
    
    public void keyboardUpdateReleased(KeyEvent e)
    {
                     System.out.println("A"); 
                int keyCode = e.getKeyCode();
                 switch (keyCode)
                 {
                     case KeyEvent.VK_UP: 
                         if (keyUpPressed)
                             keyUpPressed = false;
                             break;

                    case KeyEvent.VK_DOWN: 
                        if (keyDownPressed)
                            keyDownPressed = false;
                            break;

                    case KeyEvent.VK_RIGHT: 
                        if (keyRightPressed)
                            keyRightPressed = false;
                            break;

                    case KeyEvent.VK_LEFT: 
                        if (keyLeftPressed)
                            keyLeftPressed = false;
                            break;
                }
    }
}
