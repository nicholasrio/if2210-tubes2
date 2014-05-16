/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
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
import sun.nio.cs.ext.GB18030;

/**
 *
 * @author Timothy
 */
public class OptionsMenuGUI extends Scene
{
    // attributes
    private Image bgtexture;
    private Image backtexture;
    private Image audiotexture1;
    private Image audiotexture2;
    private Image titletexture;
    private Image bcktexture;
    private float deltapos;
    private Rectangle backRectangle;
    private Rectangle sfxrec;
    private Rectangle bgmrec;
    private float transparentPercentage;
    private int backHovered;
    private int backPressed;
    private Font playerDataFont;
    private int lengthbgm;
    private int lengthsfx;
    private int lengthmin;
    private int lengthmax;
    private int sfxpressed;
    private int bgmpressed;
    private int sfxhover;
    private int bgmhover;
    
    public OptionsMenuGUI()
    {
        super("OptionsMenuGUI");
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
                mouseUpdateMove(e);
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
    
    void mouseUpdateReleased(MouseEvent event)
    {
        {
        if (backPressed == 1)
        {
            try{
                SceneManager.SwitchScene("MainMenuGUI");
            }catch(SceneNotFoundException e){
                e.printStackTrace();
            }
        }
    }
    }
    
     void mouseUpdateHover(MouseEvent event)
    {
        if (backRectangle.contains(event.getPoint()))
        {
            backHovered = 1;
        }
        else
        {
            backHovered = -1;
        }
    }
    
    void mouseUpdatePressed(MouseEvent event)
    {
        if(backRectangle.contains(event.getPoint()))
        {
            backPressed = 1;
        }
        else
        {
            backPressed = 0;
        }
        if(sfxrec.contains(event.getPoint()))
        {
            sfxpressed = 1;
        }
        else
        {
            sfxpressed = 0;
        }
        if(bgmrec.contains(event.getPoint()))
        {
            bgmpressed = 1;
        }
        else
        {
            bgmpressed = 0;
        }
    }
    
    public void mouseUpdateMove(MouseEvent event)
    {
        if(sfxpressed == 1)
        {
            if(event.getX()>lengthmin + 150 && event.getX()<lengthmax + 150)
            {
                lengthsfx = event.getX();
            }
        }
        if(bgmpressed == 1)
        {
            if(event.getX()>lengthmin + 150 && event.getX()<lengthmax + 150)
            {
                lengthbgm = event.getX();
            }
        }
    }
    
    public void LoadContent()
    {
        bgtexture = ImageLoader.getImage("mainmenu_bg");
        backtexture = ImageLoader.getImage("back");
        audiotexture1 = ImageLoader.getImage("AudioBar");
        audiotexture2 = ImageLoader.getImage("AudioBar");
        titletexture = ImageLoader.getImage("title");
        bcktexture = ImageLoader.getImage("AchievementBack");
    }
    
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(this);
        lengthmin = 50;
        lengthmax = 450;
        lengthsfx = 200;
        lengthbgm =200;
        sfxpressed = 0;
        bgmpressed = 0;
        sfxhover = 0;
        bgmhover = 0;
        LoadContent();
        backRectangle = new Rectangle(0,(int)(Game.ResolutionHeight*0.755f), (int)(Game.ResolutionWidth*0.30f),(int)(Game.ResolutionHeight*0.145f));
        sfxrec = new Rectangle(150 + 50,310,400,25);
        bgmrec = new Rectangle(150 + 50,210,400,25);
        backHovered = 0;
        backPressed = 0;
        File fontfile = new File("Font/batmanforeveralternate.ttf");
        try {
            playerDataFont = Font.createFont(Font.TRUETYPE_FONT, fontfile);
            playerDataFont = playerDataFont.deriveFont(23, 23);
        } catch (FontFormatException ex) {
            playerDataFont = new Font("Arial",18,18);
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        } 
    }
    
    public float getVolumeSFX()
    {
        return (((float)lengthsfx - 205) / (599 - 205) * 100);
    }
    
    public float getVolumeBGM()
    {
        return (((float)lengthsfx - 205) / (400 - 205) * 100);
    }       
    
    @Override
    public void Update()
    {
        if (transparentPercentage < 1f)
        {
            transparentPercentage += 0.01f;
        }
        
        if (backHovered == (-1))
        {
            if (deltapos > 0f)
            {
                deltapos -= 5f;
            }
        }
        else if (backHovered == 1)
        {
            if (deltapos < 45f)
            {
                deltapos += 5f;
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
            g2D.drawImage(bgtexture, 0, 0, getWidth(), getHeight(), this);
            g2D.drawImage(backtexture,(int)(getWidth()*(-0.2f)+deltapos),(int)(getHeight()*0.80f),backtexture.getWidth(this),backtexture.getHeight(this),this);       
            g2D.drawImage(titletexture,(int)(getWidth()*0.2f),(int)(getHeight()*0.025f),titletexture.getWidth(this),titletexture.getHeight(this),this);
            g2D.drawImage(bcktexture, 125,125,500,300,this);
            g2D.drawImage(audiotexture2, 150, 300,lengthsfx-150,50,this);
            g2D.drawImage(audiotexture1,150, 200, lengthbgm-150, 50, this);
            g2D.setFont(playerDataFont);
            g2D.drawString("BGM : ", 150, 180);
            g2D.drawString("SFX : ", 150, 280);
        }
    }
}
