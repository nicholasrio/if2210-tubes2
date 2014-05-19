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

/**
 *
 * @author Tony
 */
public class MainMenuGUI extends Scene
{
    /* Textures */
    private Image bgTexture;
    private Image titleTexture;
    private Image newgameTexture;
    private Image achievementTexture;
    private Image optionsTexture;
    private Image aboutTexture;
    private Image exitTexture;
    private Image userBg;
    
    /* Rectangles */
    private Rectangle newgameRect;
    private Rectangle achievementRect;
    private Rectangle optionsRect;
    private Rectangle aboutRect;
    private Rectangle exitRect;
    private Rectangle userMenu;
    
    private final int NMenu = 6;
    private Font playernameFont;
    
    private int menuHovered;
    private int menuPressed;
    private int menuReleased;
    
    private float deltapos[];
    
    public MainMenuGUI() 
    {
        super("MainMenuGUI");
        
        menuHovered = -1;
        menuPressed = -1;
        menuReleased = -1;
        
        deltapos = new float[NMenu];
        for (int i =0;i<NMenu;i++)
        {
            deltapos[i] = 0f;
        }
        
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
    }
    
    public void LoadContent()
    {
        bgTexture = ImageLoader.getImage("mainmenu_bg");
        titleTexture = ImageLoader.getImage("title");
        newgameTexture = ImageLoader.getImage("newgame");
        achievementTexture = ImageLoader.getImage("achievement");
        optionsTexture = ImageLoader.getImage("options");
        aboutTexture = ImageLoader.getImage("about");
        exitTexture = ImageLoader.getImage("exit");
        userBg = ImageLoader.getImage("AchievementBack");
    }
    
    
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(this);
        this.LoadContent();
        
        /*Background music*/
        SoundManager.stopAllBGMSound();
        SoundManager.loopSound("mainBm");
        
        /* Rectangle */
        userMenu = new Rectangle(0,(int)(Game.ResolutionHeight*0.175f),800,50);
        newgameRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.268f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
        achievementRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.425f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
        optionsRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.595f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
        aboutRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.755f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
        exitRect = new Rectangle((int)(Game.ResolutionWidth*0.765f),(int)(Game.ResolutionHeight*0.71f),
                                 (int)(Game.ResolutionWidth*0.20f),(int)(Game.ResolutionHeight*0.22f));

        try {
            File fontfile = new File("Font/batmanforeveralternate.ttf");
            playernameFont = Font.createFont(Font.TRUETYPE_FONT, fontfile);
            playernameFont = playernameFont.deriveFont(18, 18f);
        } catch (FontFormatException | IOException ex) {
            playernameFont = new Font("Arial",18,18);
            System.err.println(ex);
        } 
        
    }
    
    @Override
    public void Update()
    {
        if (menuHovered == (-1))
        {
            for (int i=0;i<NMenu;i++)
            {
                if (deltapos[i] > 0f)
                {
                    deltapos[i] -= 10f;
                }
            }
        }
        else if (menuHovered >= 1 && menuHovered <=4)
        {
            for (int i=0;i<NMenu;i++)
            {
                if (i != menuHovered)
                {
                    if (deltapos[i] > 0f)
                    {
                        deltapos[i] -= 10f;
                    }
                }
            }
            float lowerboundPos = 0f;
            switch (menuHovered)
            {
                case 1: lowerboundPos = 70f; break;
                case 2: lowerboundPos = 80f; break;
                case 3: lowerboundPos = 90f; break;
                case 4: lowerboundPos = 105f; break;
            }
            
            if (deltapos[menuHovered] < lowerboundPos)
            {
                deltapos[menuHovered] += 10f;
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
            g2D.drawImage(userBg, 0,(int)(Game.ResolutionHeight*0.175f),800,50, this);
            g2D.drawImage(newgameTexture,(int)(getWidth()*(-0.09f)+deltapos[1]),(int)(getHeight()*0.28f),newgameTexture.getWidth(this),newgameTexture.getHeight(this),this);
            g2D.drawImage(achievementTexture,(int)(getWidth()*(-0.11f)+deltapos[2]),(int)(getHeight()*0.45f),achievementTexture.getWidth(this),achievementTexture.getHeight(this),this);
            g2D.drawImage(optionsTexture,(int)(getWidth()*(-0.13f)+deltapos[3]),(int)(getHeight()*0.63f),optionsTexture.getWidth(this),optionsTexture.getHeight(this),this);
            g2D.drawImage(aboutTexture,(int)(getWidth()*(-0.15f)+deltapos[4]),(int)(getHeight()*0.80f),aboutTexture.getWidth(this),aboutTexture.getHeight(this),this);       
        
            g2D.drawImage(exitTexture,(int)(getWidth()*(0.78f)),(int)(getHeight()*0.76f),exitTexture.getWidth(this),exitTexture.getHeight(this),this);      
       
            g2D.setFont(playernameFont);
            g2D.drawString("WELCOME: "+GameData.lastLogin.getNama(), 5, (int)(Game.ResolutionHeight*0.175f)+30);
        
        }
    }
    
    void mouseUpdateHover(MouseEvent event)
    {
        if (newgameRect.contains(event.getPoint()))
        {
            if(menuHovered != 1)
                SoundManager.playSound("button");
            menuHovered = 1;
        }
        else if (achievementRect.contains(event.getPoint()))
        {
            if(menuHovered != 2)
                SoundManager.playSound("button");
            menuHovered = 2;
        }
        else if(optionsRect.contains(event.getPoint()))
        {
            if(menuHovered != 3)
                SoundManager.playSound("button");
            menuHovered = 3;
        }
        else if (aboutRect.contains(event.getPoint()))
        {
            if(menuHovered != 4)
                SoundManager.playSound("button");
            menuHovered = 4;
        }
        else if (exitRect.contains(event.getPoint()))
        {
            if(menuHovered != 5)
            menuHovered = 5;
        }
        else
        {
            menuHovered = -1;
        }
    }
    
    void mouseUpdatePressed(MouseEvent event)
    {
        if (newgameRect.contains(event.getPoint()))
        {
            menuPressed = 1;
        }
        else if (achievementRect.contains(event.getPoint()))
        {
            menuPressed = 2;
            
        }
        else if(optionsRect.contains(event.getPoint()))
        {
            menuPressed = 3;
        }
        else if (aboutRect.contains(event.getPoint()))
        {
            menuPressed = 4;
        }
        else if (exitRect.contains(event.getPoint()))
        {
            menuPressed = 5;
        }
        else if (userMenu.contains(event.getPoint()))
        {
            menuPressed = 6;
        }
        else
        {
            menuPressed = -1;
        }
    }
    
    void mouseUpdateReleased(MouseEvent event)
    {
        if (menuPressed >= 1 && menuPressed <= 6)
        {
            try{
                switch (menuPressed)
                {
                    case 1 : //SoundManager.playSound("button2");
                             
                             SoundManager.playSound("fbutton");
                             SceneManager.SwitchScene("LevelMenuGUI"); 
                             break;
                    case 2 : SoundManager.playSound("fbutton");
                             //SoundManager.playSound("button2");
                             SceneManager.SwitchScene("AchievementMenuGUI"); 
                             break;
                    case 3 : SoundManager.playSound("fbutton");
                             SceneManager.SwitchScene("OptionsMenuGUI"); 
                             break;
                    case 4 : SoundManager.playSound("fbutton");
                             SceneManager.SwitchScene("AboutMenuGUI");
                             break;
                    case 5 : SoundManager.playSound("fbutton");
                             Game.gameRunning = false; 
                             break;
                    case 6 : SoundManager.playSound("fbutton");
                             SceneManager.SwitchScene("UserMenuGUI"); 
                             break;
                }
            }catch(SceneNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
