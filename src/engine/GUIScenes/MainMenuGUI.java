/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import static engine.Game.gameFrame;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

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
    
    /* Rectangles */
    private Rectangle newgameRect;
    private Rectangle achievementRect;
    private Rectangle optionsRect;
    private Rectangle aboutRect;
    private Rectangle exitRect;
    
    private final int NMenu = 6;
    private float transparentPercentage;
    private Font playernameFont;
    private int menuHovered;
    private float deltapos[];
    
    public MainMenuGUI() 
    {
        super("MainMenuGUI");
        
        transparentPercentage = 0f;
        menuHovered = -1;
        
        deltapos = new float[NMenu];
        for (int i =0;i<NMenu;i++)
        {
            deltapos[i] = 0f;
        }
        
        addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseMoved(MouseEvent event)
            {
                mouseUpdate(event);
            }
            @Override
            public void mouseDragged(MouseEvent event)
            {
                //mouseUpdate(event);
            }
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
    }
    
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(this);
        this.LoadContent();
        
        /* Rectangle */
        newgameRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.268f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
        achievementRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.425f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
        optionsRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.595f), 
                                   (int)(Game.ResolutionWidth*0.34f),(int)(Game.ResolutionHeight*0.145f));
        aboutRect = new Rectangle(0,(int)(Game.ResolutionHeight*0.755f), 
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
                case 2: lowerboundPos = 82f; break;
                case 3: lowerboundPos = 95f; break;
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
            
            g2D.drawImage(newgameTexture,(int)(getWidth()*(-0.09f)+deltapos[1]),(int)(getHeight()*0.28f),newgameTexture.getWidth(this),newgameTexture.getHeight(this),this);
            g2D.drawImage(achievementTexture,(int)(getWidth()*(-0.11f)+deltapos[2]),(int)(getHeight()*0.45f),achievementTexture.getWidth(this),achievementTexture.getHeight(this),this);
            g2D.drawImage(optionsTexture,(int)(getWidth()*(-0.13f)+deltapos[3]),(int)(getHeight()*0.63f),optionsTexture.getWidth(this),optionsTexture.getHeight(this),this);
            g2D.drawImage(aboutTexture,(int)(getWidth()*(-0.15f)+deltapos[4]),(int)(getHeight()*0.80f),aboutTexture.getWidth(this),aboutTexture.getHeight(this),this);       
        
            g2D.drawImage(exitTexture,(int)(getWidth()*(0.78f)),(int)(getHeight()*0.76f),exitTexture.getWidth(this),exitTexture.getHeight(this),this);       
        }
    }
    
    void mouseUpdate(MouseEvent event)
    {
        if (newgameRect.contains(event.getPoint()))
        {
            menuHovered = 1;
        }
        else if (achievementRect.contains(event.getPoint()))
        {
            menuHovered = 2;
        }
        else if(optionsRect.contains(event.getPoint()))
        {
            menuHovered = 3;
        }
        else if (aboutRect.contains(event.getPoint()))
        {
            menuHovered = 4;
        }
        else
        {
            menuHovered = -1;
        }
    }
}
