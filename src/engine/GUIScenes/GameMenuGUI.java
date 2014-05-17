/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import engine.DataStructure.*;
import engine.Exception.SceneNotFoundException;
import static engine.Game.gameFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int startPlayerPosX;
    private int startPlayerPosY;
    private int playerPosX;
    private int playerPosY;
    private Map playedMap;
    
    private boolean keyUpPressed;
    private boolean keyDownPressed;
    private boolean keyRightPressed;
    private boolean keyLeftPressed;
    private boolean keyEnterPressed;
    
    private int playerFaced; // 1 for Up
                             // 2 for Down
                             // 3 for Left
                             // 4 for Right
    
    private Player currentPlayer;
    private boolean isFinish;
    private boolean isLevelUnlocked;
    
    public GameMenuGUI()
    {
        super("GameMenuGUI");
        
        
        
        //nowlevelPlay = GameData.nowLevelPlayed;
        nowlevelPlay = 0;
        nowFloor = 0;
        playedMap = new Map(GameData.dataMap.get(nowlevelPlay));
        
        keyUpPressed = false;
        keyDownPressed = false;
        keyRightPressed = false;
        keyLeftPressed = false;
        keyEnterPressed = false;
        
        switch(nowlevelPlay)
        {
            case 0: mazeSize = 6; 
                    initPosMapWidth = 165;
                    initPosMapHeight = 110;
                    playerFaced = 4;
                    startPlayerPosY = 490;
                    startPlayerPosX = 180;
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
        requestFocusInWindow();
        currentPlayer = GameData.lastLogin;
        currentPlayer.initPlayerPosition(playedMap);
        currentPlayer.resetTempScore();
        isFinish = false;
        isLevelUnlocked = false;
        playerPosX = startPlayerPosX;
        playerPosY = startPlayerPosY;
    }
    
    @Override
    public void Update()
    {
        if(isFinish)
        {
            if(keyEnterPressed)
            {
                try 
                {
                    SceneManager.SwitchScene("LevelMenuGUI");
                } 
                catch (SceneNotFoundException ex) 
                {
                    ex.printStackTrace();
                }
            }
        }
        else // belum finish
        {
            int output = 0;
            if(keyUpPressed)
            {
                output = currentPlayer.move(playedMap, 1);
                playerPosY = startPlayerPosY - ((playedMap.getMaxCol()-1 - currentPlayer.getLocation().getRow()) * pathTexture.getHeight(this));
                playerPosX = startPlayerPosX + (currentPlayer.getLocation().getCol() * wallTexture.getWidth(this));
                System.out.println(currentPlayer.getLocation());
            }
            else if(keyDownPressed)
            {
                output = currentPlayer.move(playedMap, 2);
                playerPosY = startPlayerPosY - ((playedMap.getMaxCol()-1 - currentPlayer.getLocation().getRow()) * pathTexture.getHeight(this));
                playerPosX = startPlayerPosX + (currentPlayer.getLocation().getCol() * wallTexture.getWidth(this));
                System.out.println(currentPlayer.getLocation());
            }
            else if(keyLeftPressed)
            {
                output = currentPlayer.move(playedMap, 3);
                playerPosX = startPlayerPosX + (currentPlayer.getLocation().getCol() * wallTexture.getWidth(this));
                playerPosY = startPlayerPosY - ((playedMap.getMaxCol()-1 - currentPlayer.getLocation().getRow()) * pathTexture.getHeight(this));
                System.out.println(currentPlayer.getLocation());
            }
            else if(keyRightPressed)
            {
                output = currentPlayer.move(playedMap, 4);
                playerPosX = startPlayerPosX + (currentPlayer.getLocation().getCol() * wallTexture.getWidth(this));
                playerPosY = startPlayerPosY - ((playedMap.getMaxCol()-1 - currentPlayer.getLocation().getRow()) * pathTexture.getHeight(this));
                System.out.println(currentPlayer.getLocation());
            }
            nowFloor = currentPlayer.getLocation().getLevel();
            if(output == 1)
            {
                isFinish = true;
                if(GameData.nowLevelPlayed == currentPlayer.getLevelUnlocked() && GameData.nowLevelPlayed<GameData.getJumlahMap()){
                    currentPlayer.setLevelUnlocked(currentPlayer.getLevelUnlocked()+1);
                    isLevelUnlocked = true;
                }
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
                case 1: g2D.drawImage(playerUDTexture,playerPosX,playerPosY,playerPosX+39,playerPosY+71,0,76,39,152,this);
                        break;
                case 2: g2D.drawImage(playerUDTexture,playerPosX,playerPosY,playerPosX+39,playerPosY+71,0,0,39,76,this);
                        break;
                case 3: g2D.drawImage(playerRLTexture,playerPosX,playerPosY,playerPosX+48,playerPosY+63,0,63,48,126,this);
                        break;
                case 4: g2D.drawImage(playerRLTexture,playerPosX,playerPosY,playerPosX+48,playerPosY+63,0,0,48,63,this);
                        break;
            }
        }
    }
    
    public void keyboardUpdatePressed(KeyEvent e)
    {
                int keyCode = e.getKeyCode();
                switch (keyCode)
                {
                    case KeyEvent.VK_UP: keyUpPressed = true;
                                         playerFaced = 1;
                                         break;

                    case KeyEvent.VK_DOWN: keyDownPressed = true;
                                           playerFaced = 2;
                                           break;

                    case KeyEvent.VK_LEFT: keyLeftPressed = true;
                                            playerFaced = 3;
                                            break;

                    case KeyEvent.VK_RIGHT: keyRightPressed = true;
                                           playerFaced = 4;
                                           break;
                    case KeyEvent.VK_ENTER: keyEnterPressed = true;
                                            break;
                }
    }
    
    public void keyboardUpdateReleased(KeyEvent e)
    {
                int keyCode = e.getKeyCode();
                 switch (keyCode)
                 {
                     case KeyEvent.VK_UP: 
                         if (keyUpPressed)
                         {
                             keyUpPressed = false;
                             break;
                         }

                    case KeyEvent.VK_DOWN: 
                        if (keyDownPressed)
                        {
                            keyDownPressed = false;
                            break;
                        }

                    case KeyEvent.VK_RIGHT: 
                        if (keyRightPressed)
                        {
                            keyRightPressed = false;
                            break;
                        }

                    case KeyEvent.VK_LEFT: 
                        if (keyLeftPressed)
                        {
                            keyLeftPressed = false;
                            break;
                        }
                    case KeyEvent.VK_ENTER:
                    {
                        if (keyEnterPressed)
                        {
                            keyEnterPressed = false;
                            break;
                        }
                    }
                }
    }
}
