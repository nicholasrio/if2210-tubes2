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
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
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
    private Image backgroundTexture;
    private Image titleTexture;
    private Image coinTexture;
            
    private int nowlevelPlay;
    private int mazeSize;
    private int nowFloor;
    private int prevFloor;
    private int initPosMapWidth;
    private int initPosMapHeight;
    private int startPlayerPosX;
    private int startPlayerPosY;
    private int playerPosX;
    private int playerPosY;
    private int charSpriteWidth;
    private int charSpriteHeight;
    private int playerdisplayState;
    private int nbCharSprite;
    private int playerSpeed;
    private int playerFaced; // 1 for Up
                             // 2 for Down
                             // 3 for Left
                             // 4 for Right
    
    public static int waitingTime;
    
    private Map playedMap;
    
    private boolean keyUpPressed;
    private boolean keyDownPressed;
    private boolean keyRightPressed;
    private boolean keyLeftPressed;
    private boolean keyEnterPressed;
    private boolean isFinish;
    private boolean isLevelUnlocked;
    
    public static boolean hitHole;
    public static boolean playerCollide;
    public static boolean hitTeleport;
    
    private Rectangle [][]tileRect;
    private Rectangle playerRect;
    
    private Font font;
    private File fontfile;
    private Player currentPlayer;
    
    public GameMenuGUI()
    {
        super("GameMenuGUI");
        
        nowlevelPlay = GameData.nowLevelPlayed;
        //nowlevelPlay = 0;
        nowFloor = 0;
        playerdisplayState = 0;
        waitingTime = 0;
        playedMap = new Map(GameData.dataMap.get(nowlevelPlay));
        
        keyUpPressed = false;
        keyDownPressed = false;
        keyRightPressed = false;
        keyLeftPressed = false;
        keyEnterPressed = false;
        
        playerCollide = false;
        hitHole = false;
        hitTeleport = false;
        
        playerSpeed = 6;
        switch(nowlevelPlay)
        {
            case 0: mazeSize = 6; 
                    nbCharSprite = 8;
                    initPosMapWidth = 165;
                    initPosMapHeight = 110;
                    playerFaced = 4;
                    charSpriteWidth = 48;
                    charSpriteHeight = 63;
                    
                    startPlayerPosX = 180;
                    startPlayerPosY = 490;
                    playerRect = new Rectangle(startPlayerPosX,startPlayerPosY,charSpriteWidth,charSpriteHeight);
                    tileRect = new Rectangle[mazeSize][mazeSize];
                    fontfile = new File("Font/batmanforeveralternate.ttf");
                    try 
                    {
                        font = font.createFont(Font.TRUETYPE_FONT, fontfile);
                        font = font.deriveFont(Font.TRUETYPE_FONT, 20);
                    } 
                    catch (FontFormatException | IOException ex) 
                    {
                        Logger.getLogger(GameMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    backgroundTexture = ImageLoader.getImage("ice");
                    titleTexture = ImageLoader.getImage("title");
                    coinTexture = ImageLoader.getImage("coin");
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
        
        for (int bar=0;bar<mazeSize;bar++)
        {
            for (int kol=0;kol<mazeSize;kol++)
            {
                int width = pathTexture.getWidth(this);
                int height = pathTexture.getHeight(this);
                tileRect[bar][kol] = new Rectangle(width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height);
            }
        }
        
        /*Jalankan Suara*/
        SoundManager.stopAllSound();
        SoundManager.loopSound("lv1bm");
    }
    
    @Override
    public void Update()
    {
        if(isFinish)
        {
            prevFloor = currentPlayer.getLocation().getLevel();
            if(keyEnterPressed)
            {
                try 
                {
                    keyUpPressed = false;
                    keyDownPressed = false;
                    keyRightPressed = false;
                    keyLeftPressed = false;
                    keyEnterPressed = false;
                    playerFaced = 4;
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
            if (!hitHole && !hitTeleport)
            {
                if(keyUpPressed)
                {
                    if (currentPlayer.getLocation().getRow() > 0)
                    {

                        if (playerRect.intersects(tileRect[currentPlayer.getLocation().getRow()-1]
                                                          [currentPlayer.getLocation().getCol()]))
                        {
                            output = currentPlayer.move(playedMap, 1);
                        }
                    }

                    if (playerRect.getMinY() <= initPosMapHeight)
                            playerCollide = true;

                    if (!playerCollide)
                    {
                        playerPosY-=playerSpeed;
                        playerRect = new Rectangle((int)playerRect.getMinX(),(int)playerRect.getMinY()-playerSpeed,
                                               (int)playerRect.getWidth(),(int)playerRect.getHeight());
                    }
                    else
                    {
                        playerCollide = false;
                    }
                    playerdisplayState ++;
                    playerdisplayState %= nbCharSprite;
                }
                else if(keyDownPressed)
                {
                    if (currentPlayer.getLocation().getRow() < (mazeSize-1))
                    {
                        if (playerRect.intersects(tileRect[currentPlayer.getLocation().getRow()+1]
                                                          [currentPlayer.getLocation().getCol()]))
                        {
                            output = currentPlayer.move(playedMap, 2);
                        }
                    }

                    if (playerRect.getMaxY() >= ((6*75)+initPosMapHeight))
                            playerCollide = true;

                    if (!playerCollide)
                    {
                        playerPosY+=playerSpeed;
                        playerRect = new Rectangle((int)playerRect.getMinX(),(int)playerRect.getMinY()+playerSpeed,
                                               (int)playerRect.getWidth(),(int)playerRect.getHeight());
                    }
                    else
                    {
                        playerCollide = false;
                    }
                    playerdisplayState++;
                    playerdisplayState %= nbCharSprite;
                }
                else if(keyLeftPressed)
                {
                    if (currentPlayer.getLocation().getCol() > 0)
                    {
                        if (playerRect.intersects(tileRect[currentPlayer.getLocation().getRow()]
                                                          [currentPlayer.getLocation().getCol()-1]))
                        {
                            output = currentPlayer.move(playedMap, 3);
                        }
                    }

                    if (playerRect.getMinX() <= initPosMapWidth)
                            playerCollide = true;

                    if (!playerCollide)
                    {
                        playerPosX-=playerSpeed;
                        playerRect = new Rectangle((int)playerRect.getMinX()-playerSpeed,(int)playerRect.getMinY(),
                                               (int)playerRect.getWidth(),(int)playerRect.getHeight());
                    }
                    else
                    {
                        playerCollide = false;
                    }
                    playerdisplayState++;
                    playerdisplayState %= nbCharSprite;
                }
                else if(keyRightPressed)
                {
                    if (currentPlayer.getLocation().getCol() < (mazeSize-1))
                    {
                        if (playerRect.intersects(tileRect[currentPlayer.getLocation().getRow()]
                                                          [currentPlayer.getLocation().getCol()+1]))
                        {
                            output = currentPlayer.move(playedMap, 4);
                        }
                    }

                    if (playerRect.getMaxX() >= ((6*75)+initPosMapWidth))
                            playerCollide = true;

                    if (!playerCollide)
                    {
                        playerPosX+=playerSpeed;
                        playerRect = new Rectangle((int)playerRect.getMinX()+playerSpeed,(int)playerRect.getMinY(),
                                               (int)playerRect.getWidth(),(int)playerRect.getHeight());
                    }
                    else
                    {
                        playerCollide = false;
                    }
                    playerdisplayState++;
                    playerdisplayState %= nbCharSprite;
                }
                
                if (!hitHole && !hitTeleport)
                {
                    nowFloor = currentPlayer.getLocation().getLevel();
                }
            }
            else
            {
                if (waitingTime > 0)
                {
                    waitingTime--;
                }
                else
                {
                    if (hitHole)
                    {
                        hitHole = false;
                    }
                    else if (hitTeleport)
                    {
                        hitTeleport = false;
                    }
                }
            }
            
            if(prevFloor != nowFloor)
            {
                prevFloor = nowFloor;
                System.out.println("TELEPORT!!");
                int offset = 10;
                playerPosX = initPosMapWidth + offset + (currentPlayer.getLocation().getCol() * pathTexture.getWidth(this));
                playerPosY = initPosMapHeight + offset + (currentPlayer.getLocation().getRow() * pathTexture.getHeight(this));
                playerRect = new Rectangle(playerPosX, playerPosY, charSpriteWidth, charSpriteHeight);
            }
            
            if(output == 1)
            {
                isFinish = true;
                if(GameData.nowLevelPlayed == currentPlayer.getLevelUnlocked() && GameData.nowLevelPlayed<GameData.getJumlahMap()){
                    currentPlayer.setLevelUnlocked(currentPlayer.getLevelUnlocked()+1);
                    isLevelUnlocked = true;
                }
            }
            
            System.out.println(nowFloor);
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
            g2D.drawImage(backgroundTexture, 0  , 0, getWidth(), getHeight(), this);
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
                        int width = pathTexture.getWidth(this);
                        int height = pathTexture.getHeight(this);
                        g2D.drawImage(pathTexture,width*kol+initPosMapWidth,height*bar+initPosMapHeight,width,height,this);
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
            
            if (hitHole)
            {
                Location loc = currentPlayer.getLocation();
                int width = holeTexture.getWidth(this);
                int height = holeTexture.getHeight(this);
                g2D.drawImage(holeTexture,width*loc.getCol()+initPosMapWidth,height*loc.getRow()+initPosMapHeight,width,height,this);    
            }
                        
            switch (playerFaced)
            {
                case 1: g2D.drawImage(playerUDTexture,playerPosX,playerPosY,playerPosX+39,playerPosY+71,(39*playerdisplayState),76,(39*(playerdisplayState+1)),152,this);
                        break;
                case 2: g2D.drawImage(playerUDTexture,playerPosX,playerPosY,playerPosX+39,playerPosY+71,(39*playerdisplayState),0,(39*(playerdisplayState+1)),76,this);
                        break;
                case 3: g2D.drawImage(playerRLTexture,playerPosX,playerPosY,playerPosX+50,playerPosY+63,(50*playerdisplayState),63,(50*(playerdisplayState+1)),126,this);
                        break;
                case 4: g2D.drawImage(playerRLTexture,playerPosX,playerPosY,playerPosX+49,playerPosY+63,(49*playerdisplayState),0,(49*(playerdisplayState+1)),63,this);
                        break;
            }
            g2D.drawImage(coinTexture, (int)(getWidth()*0.80f), (int) (getHeight()*0.2f), (int) (coinTexture.getWidth(this)*0.55f),(int) (coinTexture.getHeight(this) * 0.55f), this);
            g2D.drawImage(titleTexture, (int) (getWidth()*0.24f), (int) (getHeight()*0.03f), (int) (titleTexture.getWidth(this) * 0.80f), (int) (titleTexture.getHeight(this) * 0.80f), this);
            g2D.setFont(font);
            this.setForeground(Color.GREEN);
            g2D.drawString(String.valueOf(currentPlayer.getTempScore()),(int)(this.getWidth()*0.9f), (int)(this.getHeight()*0.275f));
        }
    }
    
    public void keyboardUpdatePressed(KeyEvent e)
    {
        if (!hitHole)
        {
            int keyCode = e.getKeyCode();
            switch (keyCode)
            {
                case KeyEvent.VK_UP: if (!(keyDownPressed || keyLeftPressed || keyRightPressed))
                                     {
                                        keyUpPressed = true;
                                        if (playerFaced != 1)
                                        {
                                            playerdisplayState = 0;
                                        }
                                        playerFaced = 1;
                                     }

                                     break;

                case KeyEvent.VK_DOWN: if (!(keyUpPressed || keyLeftPressed || keyRightPressed))
                                       {
                                            keyDownPressed = true;
                                            if (playerFaced != 2)
                                            {
                                                playerdisplayState = 0;
                                            }
                                            playerFaced = 2;
                                       }
                                       break;

                case KeyEvent.VK_LEFT: if (!(keyUpPressed || keyDownPressed || keyRightPressed))
                                       {
                                            keyLeftPressed = true;
                                            if (playerFaced != 3)
                                            {
                                                playerdisplayState = 0;
                                            }
                                            playerFaced = 3;

                                       }
                                       break;

                case KeyEvent.VK_RIGHT: if (!(keyUpPressed || keyLeftPressed || keyDownPressed))
                                        {
                                            keyRightPressed = true;
                                            if (playerFaced != 4)
                                            {
                                                playerdisplayState = 0;
                                            }
                                            playerFaced = 4;
                                        }
                                        break;

                case KeyEvent.VK_ENTER: keyEnterPressed = true;
                                        break;
            }
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
                }
            break;

            case KeyEvent.VK_DOWN: 
                if (keyDownPressed)
                {
                    keyDownPressed = false;    
                }
                break;

                case KeyEvent.VK_RIGHT: 
                    if (keyRightPressed)
                    {
                        keyRightPressed = false;
                    }
                break;

                case KeyEvent.VK_LEFT: 
                    if (keyLeftPressed)
                    {
                        keyLeftPressed = false;
                    }
                break;
                
                case KeyEvent.VK_ENTER:
                    if (keyEnterPressed)
                    {
                        keyEnterPressed = false;
                    }
                break;
        }
    }
}
