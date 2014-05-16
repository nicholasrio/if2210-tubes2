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
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class AchievementMenuGUI extends Scene
{
    /* Textures */
    private Image bgTexture;
    private Image titleTexture;
    private Image backTexture;
    private Image AchString;
    
    /* Rectangles */
    private Rectangle backRect;
    
    private float transparentPercentage;
    private int menuHovered;
    private int menuPressed;
    private int menuReleased;
    private float deltapos;
    
    private Font PlayerDataFont;
    
    public AchievementMenuGUI()
    {
        super("AchievementMenuGUI");
        
        transparentPercentage = 0f;
        menuHovered = -1;
        menuPressed = -1;
        menuReleased = -1;
        
        deltapos = 0f;
        
        addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                mouseUpdateHover(e);
            }
            @Override
            public void mouseDragged(MouseEvent e)
            {
                mouseUpdateHover(e);
                mouseUpdatePressed(e);
            }
        });
        
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
                mouseUpdateReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) 
            {}

            @Override
            public void mouseExited(MouseEvent e) 
            {}
        });
        File fontfile = new File("batmanforeveralternate.ttf");
        try {
            PlayerDataFont = Font.createFont(Font.TRUETYPE_FONT, fontfile);
            PlayerDataFont = PlayerDataFont.deriveFont(18, 18f);
        } catch (FontFormatException ex) {
            PlayerDataFont = new Font("Arial",18,18);
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        } 
    }
    
    public void LoadContent()
    {
        bgTexture = ImageLoader.getImage("mainmenu_bg");
        titleTexture = ImageLoader.getImage("title");
        backTexture = ImageLoader.getImage("back");
        AchString = ImageLoader.getImage("AchievementBack");
    }
    
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(this);
        this.LoadContent();
        
        backRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.755f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
    }
    
    @Override
    public void Update()
    {
        if (transparentPercentage < 1f)
        {
            transparentPercentage += 0.01f;
        }
        
        if (menuHovered == (-1))
        {
            if (deltapos > 0f)
            {
                deltapos -= 10f;
            }
            
        }
        else if (menuHovered == 1)
        {
            if (deltapos > 0f)
            {
                deltapos -= 10f;
            }
            
            if (deltapos < 110f)
            {
                deltapos += 10f;
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
            
            g2D.drawImage(bgTexture, 0, 0, getWidth(), getHeight(), this);
            g2D.drawImage(titleTexture,(int)(getWidth()*0.2f),(int)(getHeight()*0.025f),titleTexture.getWidth(this),titleTexture.getHeight(this),this);
            g2D.drawImage(backTexture,(int)(getWidth()*(-0.15f)+deltapos),(int)(getHeight()*0.80f),backTexture.getWidth(this),backTexture.getHeight(this),this);       

            g2D.drawImage(AchString,(int)(Game.ResolutionWidth*0.33f),(int)(Game.ResolutionHeight*0.2f),(int)(AchString.getWidth(this)*1.5f),AchString.getHeight(this),this);       
        g2D.setFont(PlayerDataFont);
            g2D.drawString("Player Name : " + GameData.lastLogin.getNama(), Game.ResolutionWidth*0.33f+50, Game.ResolutionHeight*0.2f+50);
            g2D.drawString("Score : " + Integer.toString(GameData.lastLogin.getScore()), Game.ResolutionWidth*0.33f+50, Game.ResolutionHeight*0.2f+100);
            g2D.drawString("Level Unlocked : " + Integer.toString(GameData.lastLogin.getLevelUnlocked()), Game.ResolutionWidth*0.33f+50, Game.ResolutionHeight*0.2f+150);
            g2D.drawString("Achievement Unlocked : " + Integer.toString(GameData.lastLogin.getAchievmentUnlocked()), Game.ResolutionWidth*0.33f+50, Game.ResolutionHeight*0.2f+200);
        }
    }
    
        void mouseUpdateHover(MouseEvent event)
    {
        if (backRect.contains(event.getPoint()))
        {
            menuHovered = 1;
        }
        else
        {
            menuHovered = -1;
        }
    }
    
    void mouseUpdatePressed(MouseEvent event)
    {
        if (backRect.contains(event.getPoint()))
        {
            menuPressed = 1;
        }
        else
        {
            menuPressed = -1;
        }
    }
    
    void mouseUpdateReleased(MouseEvent event)
    {
        if (menuPressed == 1)
        {
            try{
                SceneManager.SwitchScene("MainMenuGUI");
            }catch(SceneNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
