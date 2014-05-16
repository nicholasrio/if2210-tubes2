/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tony
 */
public class AboutMenuGUI extends Scene
{
    // attributes
    private Image bgTexture;
    private Image titleTexture;
    private Image backTexture;
    private Image AchString;
    
    private Rectangle backRect;
    
    private float transparentPercentage;
    private int menuHovered;
    private int menuPressed;
    private int menuReleased;
    private float deltapos;
    
    private Font CreditsDataFont;
    private Font CreatorDataFont;
    
    private ArrayList<String> Credits;
    
    public AboutMenuGUI()
    {
        super("AboutMenuGUI");
        
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
        Credits = new ArrayList<>();
        try {
            File fontfile = new File("Font/batmanforeveralternate.ttf");
            File creditstxt = new File("Credit/credit.txt");
            CreditsDataFont = Font.createFont(Font.TRUETYPE_FONT, fontfile);
            CreatorDataFont = CreditsDataFont.deriveFont(14,14f);
            CreditsDataFont = CreditsDataFont.deriveFont(24, 24f);
            Scanner Sc = new Scanner(creditstxt);
            while (Sc.hasNextLine()) {
                Credits.add(Sc.nextLine());
            }
        } catch (FontFormatException ex) {
            CreditsDataFont = new Font("Arial",18,18);
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
                                   (int)(Game.ResolutionWidth*0.24f),(int)(Game.ResolutionHeight*0.145f));
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
                deltapos -= 5f;
            }
            
        }
        else if (menuHovered == 1)
        {
            if (deltapos < 25f)
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
            g2D.drawImage(bgTexture, 0, 0, getWidth(), getHeight(), this);
            g2D.drawImage(titleTexture,(int)(getWidth()*0.2f),(int)(getHeight()*0.025f),titleTexture.getWidth(this),titleTexture.getHeight(this),this);
            g2D.drawImage(backTexture,(int)(getWidth()*(-0.2f)+deltapos),(int)(getHeight()*0.80f),backTexture.getWidth(this),backTexture.getHeight(this),this);       

            g2D.drawImage(AchString,(int)(Game.ResolutionWidth*0.33f),(int)(Game.ResolutionHeight*0.2f),(int)(AchString.getWidth(this)*1.5f),AchString.getHeight(this),this);       
            g2D.drawImage(AchString,(int)(Game.ResolutionWidth*0.0275f),(int)(Game.ResolutionHeight*0.2f),(int)(AchString.getWidth(this)*0.7f),(int)(AchString.getHeight(this)*0.75f),this);
            
            CreatorDataFont = CreatorDataFont.deriveFont(24,24f);
            g2D.setFont(CreatorDataFont);
            g2D.drawString("Creators: ", Game.ResolutionWidth*0.0275f+20, Game.ResolutionHeight*0.2f+50);
            CreatorDataFont = CreatorDataFont.deriveFont(14,14f);
            g2D.setFont(CreatorDataFont);
            g2D.drawString("Kevin Tjong", Game.ResolutionWidth*0.0275f+5, Game.ResolutionHeight*0.2f+100);
            g2D.drawString("Michael Alexander", Game.ResolutionWidth*0.0275f+5, Game.ResolutionHeight*0.2f+140);
            g2D.drawString("Timothy Pratama", Game.ResolutionWidth*0.0275f+5, Game.ResolutionHeight*0.2f+180);
            g2D.drawString("Tony Wijaya", Game.ResolutionWidth*0.0275f+5, Game.ResolutionHeight*0.2f+220);
            g2D.drawString("Winson Waisakurnia", Game.ResolutionWidth*0.0275f+5, Game.ResolutionHeight*0.2f+260);
            
            CreditsDataFont = CreditsDataFont.deriveFont(24, 24f);
            g2D.setFont(CreditsDataFont);
            g2D.drawString("Credits: ", Game.ResolutionWidth*0.33f+5, Game.ResolutionHeight*0.2f+25);
            
            CreditsDataFont = CreditsDataFont.deriveFont(10, 10f);
            g2D.setFont(CreditsDataFont);
            int add = 40;
            for(String credline : Credits) {
                g2D.drawString(credline, Game.ResolutionWidth*0.33f+5, Game.ResolutionHeight*0.2f+add);
                add += 20;
            }
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
