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
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class UserMenuGUI extends Scene
{
   // attributes
    private Image bgTexture;
    private Image titleTexture;
    private Image backTexture;
    private Image AchString;
    
    private Rectangle backRect;
    private ArrayList<Rectangle> userRect;
    private Rectangle newRect;
    private Rectangle delRect;
    private Rectangle enterRect;
    private Rectangle cancelRect;
    
    private String userName;
    
    private float transparentPercentage;
    private int menuHovered;
    private int menuPressed;
    private int menuReleased;
    private float deltapos;
    
    private Font userMenuFont;
    
    private int status;
    
    public UserMenuGUI()
    {
        super("UserMenuGUI");
        
        
        transparentPercentage = 0f;
        menuHovered = -1;
        menuPressed = -1;
        menuReleased = -1;
        
        deltapos = 0f;
        
        status = 0;
        
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
        
        userRect = new ArrayList<>(GameData.getJumlahPlayer());
        userName = "";
        try {
            File fontfile = new File("Font/batmanforeveralternate.ttf");
            userMenuFont = Font.createFont(Font.TRUETYPE_FONT, fontfile);
            userMenuFont = userMenuFont.deriveFont(24, 24f);
        } catch (FontFormatException | IOException ex) {
            userMenuFont = new Font("Arial",18,18);
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
    
        /* userRect initialization */
        for (int i = 0; i < GameData.getJumlahPlayer();i++) {
            userRect.add(new Rectangle((int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+i*35+40),450,30));
        }
        newRect = new Rectangle((int)(Game.ResolutionWidth*0.0275f), (int)(Game.ResolutionHeight*0.2f)+70,210,50);
        delRect = new Rectangle((int)(Game.ResolutionWidth*0.0275f), (int)(Game.ResolutionHeight*0.2f)+170,210,50);
        enterRect = new Rectangle((int)(Game.ResolutionWidth*0.33f)+50,(int)(Game.ResolutionHeight*0.2f)+300,135,50);
        cancelRect = new Rectangle((int)(Game.ResolutionWidth*0.33f)+260,(int)(Game.ResolutionHeight*0.2f)+300,135,50);
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
            userMenuFont = userMenuFont.deriveFont(24, 24f);
            g2D.setFont(userMenuFont);
            g2D.drawString("CREATE USER", Game.ResolutionWidth*0.0275f+3, Game.ResolutionHeight*0.2f+100);
            g2D.drawString("DELETE USER", Game.ResolutionWidth*0.0275f+3, Game.ResolutionHeight*0.2f+200);
            
            /* content */
            if (status == 0) 
            {
                g2D.setFont(userMenuFont);
                g2D.drawString("=====   CHANGE USER   =====", (int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+25));
                for (int i = 0; i < GameData.getJumlahPlayer();i++) {
                    g2D.draw(userRect.get(i));
                }
                for(int i = 0; i < GameData.getJumlahPlayer();i++) {
                    g2D.drawString(GameData.dataPlayer.get(i).getNama(), (int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+i*35)+60);
                }
            } 
            else if (status == 1) 
            {
            g2D.setFont(userMenuFont);
            g2D.drawString("=====CREATE NEW USER=====", (int)(Game.ResolutionWidth*0.33f),(int)(Game.ResolutionHeight*0.2f)+25);
            g2D.drawString("TYPE USERNAME", (int)(Game.ResolutionWidth*0.33f)+100,(int)(Game.ResolutionHeight*0.2f)+60);
            g2D.drawString(userName,(int)(Game.ResolutionWidth*0.33f)+100,(int)(Game.ResolutionHeight*0.2f)+160);
            for (int i = 0; i <= userName.length()+1;i++) {
            g2D.drawString("_", (int)(Game.ResolutionWidth*0.33f)+100-1+15*i,(int)(Game.ResolutionHeight*0.2f)+170);
            }
            g2D.setColor(Color.red);
            g2D.draw3DRect((int)(Game.ResolutionWidth*0.33f)+50,(int)(Game.ResolutionHeight*0.2f)+300,135,50, true);
            g2D.drawString("CANCEL", (int)(Game.ResolutionWidth*0.33f)+65,(int)(Game.ResolutionHeight*0.2f)+332);
            g2D.setColor(Color.blue);
            g2D.draw3DRect((int)(Game.ResolutionWidth*0.33f)+260,(int)(Game.ResolutionHeight*0.2f)+300,135,50, true);
            g2D.drawString("ENTER", (int)(Game.ResolutionWidth*0.33f)+280,(int)(Game.ResolutionHeight*0.2f)+332);
            }
            else if (status == 2)
            {
                g2D.setFont(userMenuFont);
                g2D.drawString("=====   DELETE USER   =====", (int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+25));
                for (int i = 0; i < GameData.getJumlahPlayer();i++) {
                    g2D.draw(userRect.get(i));
                }
                for(int i = 0; i < GameData.getJumlahPlayer();i++) {
                    g2D.drawString(GameData.dataPlayer.get(i).getNama(), (int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+i*35)+60);
                }
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
        boolean nothing = true;
            if (backRect.contains(event.getPoint()))
            {
                menuPressed = 0;
            }
            else if (newRect.contains(event.getPoint())) 
            {
                menuPressed = 555;
                status = 1;
            }
            else if (delRect.contains(event.getPoint()))
            {
                menuPressed = 777;
                status = 2;
            }
            else if (enterRect.contains(event.getPoint()) && status == 1) 
            {
                menuPressed = 444;
            }
            else if (cancelRect.contains(event.getPoint()) && status == 1) 
            {
                menuPressed = 999;
            }
            else
            {
                for (int i = 0;i<GameData.getJumlahPlayer();i++) {
                    if(userRect.get(i).contains(event.getPoint())) {
                        menuPressed = i+1;
                        nothing = false;
                    }
                }
                if (nothing) {
                    menuPressed = -1;
                    if (status == 2) {
                        status = 0;
                    }
                }
            }
        
    }
    
    void mouseUpdateReleased(MouseEvent event)
    {
        try{
        if (menuPressed == 0)
        {
            SceneManager.SwitchScene("MainMenuGUI");
        } else if (menuPressed != -1) 
        {
            if (menuPressed == 555) {
                /* menu create user */
                System.out.println("ADD USER");
            }
            else if (menuPressed == 777) {
                /* menu delete user */
                System.out.println("DELETE USER");
            } else {
                if(status == 0) {
                GameData.lastLogin = GameData.dataPlayer.get(menuPressed-1);
                SceneManager.SwitchScene("MainMenuGUI");
                }
                else if(status == 1) {
                    status = 0;
                }
                else if(status == 2) {
                    if(GameData.dataPlayer.get(menuPressed-1) != GameData.lastLogin) {
                        GameData.deletePlayer(GameData.dataPlayer.get(menuPressed-1).getNama());
                    }
                    status = 0;
                }
            }
        }
        }catch(SceneNotFoundException e){
                e.printStackTrace();
                }
    }

}