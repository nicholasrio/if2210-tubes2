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
    /* Textures */
    private Image bgTexture;
    private Image titleTexture;
    private Image backTexture;
    private Image AchString;
    private Image borderTexture;
    private Image borderhoverTexture;
    
    private Image userBorderTexture;
    
    private Rectangle backRect;
    private ArrayList<Rectangle> userRect;
    private Rectangle newRect;
    private Rectangle delRect;
    private Rectangle enterRect;
    private Rectangle cancelRect;
    
    private String userName;
    
    private boolean []userHover;
    private boolean cancelHover;
    private boolean enterHover;
    
    private boolean newHover;
    private boolean delHover;
    
    private float transparentPercentage;
    private int menuHovered;
    private int menuPressed;
    private float deltapos;
    
    private Font userMenuFont;
    
    private int status;
    
    public UserMenuGUI()
    {
        super("UserMenuGUI");
        
        transparentPercentage = 0f;
        menuHovered = -1;
        menuPressed = -1;
        cancelHover = false;
        enterHover = false;
        
        newHover = false;
        delHover = false;
        
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
        
        userRect = new ArrayList<>();
        userName = "";
        try {
            File fontfile = new File("Font/batmanforeveralternate.ttf");
            userMenuFont = Font.createFont(Font.TRUETYPE_FONT, fontfile);
            userMenuFont = userMenuFont.deriveFont(24, 24f);
        } catch (FontFormatException | IOException ex) {
            userMenuFont = new Font("Arial",18,18);
            System.err.println(ex);
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
                 
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
                prosesInput(e);
            }
        });
    }
    
    public void LoadContent()
    {
        bgTexture = ImageLoader.getImage("mainmenu_bg");
        titleTexture = ImageLoader.getImage("title");
        backTexture = ImageLoader.getImage("back");
        AchString = ImageLoader.getImage("AchievementBack");
        borderTexture = ImageLoader.getImage("border");
        borderhoverTexture = ImageLoader.getImage("border_hover");
        userBorderTexture = ImageLoader.getImage("user_border");
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
        userHover = new boolean[userRect.size()];
        for (int i= 0;i<userRect.size();i++)
        {
            userHover[i] = false;
        }
        newRect = new Rectangle((int)(Game.ResolutionWidth*0.0275f), (int)(Game.ResolutionHeight*0.2f)+70,210,50);
        delRect = new Rectangle((int)(Game.ResolutionWidth*0.0275f), (int)(Game.ResolutionHeight*0.2f)+170,210,50);
        enterRect = new Rectangle((int)(Game.ResolutionWidth*0.33f)+260,(int)(Game.ResolutionHeight*0.2f)+300,135,50);
        cancelRect = new Rectangle((int)(Game.ResolutionWidth*0.33f)+50,(int)(Game.ResolutionHeight*0.2f)+300,135,50);
        this.requestFocusInWindow();
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
            
            if (newHover)
            {
                g2D.drawImage(borderhoverTexture,(int)(Game.ResolutionWidth*0.028f),(int)(Game.ResolutionHeight*0.319f),210,50,this); 
            }
            else
            {
                g2D.drawImage(borderTexture,(int)(Game.ResolutionWidth*0.028f),(int)(Game.ResolutionHeight*0.319f),210,50,this); 
            }
            
            g2D.drawString("CREATE USER", Game.ResolutionWidth*0.0275f+3, Game.ResolutionHeight*0.2f+100);
            
            if (delHover)
            {
                g2D.drawImage(borderhoverTexture,(int)(Game.ResolutionWidth*0.028f),(int)(Game.ResolutionHeight*0.485f),210,50,this);
            }
            else
            {
                g2D.drawImage(borderTexture,(int)(Game.ResolutionWidth*0.028f),(int)(Game.ResolutionHeight*0.485f),210,50,this);
            }
            
            g2D.drawString("DELETE USER", Game.ResolutionWidth*0.0275f+3, Game.ResolutionHeight*0.2f+200);
            
            /* content */
            if (status == 0) 
            {
                g2D.setFont(userMenuFont);
                g2D.drawString("=====   CHANGE USER   =====", (int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+25));
                
                for(int i = 0; i < GameData.getJumlahPlayer();i++) {
                    if (userHover[i])
                        g2D.drawImage(userBorderTexture,(int)(Game.ResolutionWidth*0.329f),(int)((Game.ResolutionHeight*0.2f)+i*35)+30,450,50,this);
                    else
                        g2D.drawImage(borderTexture,(int)(Game.ResolutionWidth*0.329f),(int)((Game.ResolutionHeight*0.2f)+i*35)+30,450,50,this);
                    g2D.drawString(GameData.dataPlayer.get(i).getNama(), (int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+i*35)+60);
                }
            } 
            else if (status == 1) 
            {

            g2D.setFont(userMenuFont);
            g2D.drawString("=====CREATE NEW USER=====", (int)(Game.ResolutionWidth*0.33f),(int)(Game.ResolutionHeight*0.2f)+25);
            g2D.drawString("TYPE USERNAME", (int)(Game.ResolutionWidth*0.33f)+100,(int)(Game.ResolutionHeight*0.2f)+60);
            g2D.drawString(userName,(int)(Game.ResolutionWidth*0.33f)+100,(int)(Game.ResolutionHeight*0.2f)+160);
            
            if (cancelHover)
            {
                g2D.setPaint(Color.white);
                g2D.fill(cancelRect);
            }
            else if (enterHover)
            {
                g2D.setPaint(Color.white);
                g2D.fill(enterRect);
            }
            
            g2D.setPaint(Color.BLACK);
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
               for(int i = 0; i < GameData.getJumlahPlayer();i++) {
                   if (userHover[i])
                        g2D.drawImage(userBorderTexture,(int)(Game.ResolutionWidth*0.329f),(int)((Game.ResolutionHeight*0.2f)+i*35)+30,450,50,this);
                    else
                        g2D.drawImage(borderTexture,(int)(Game.ResolutionWidth*0.329f),(int)((Game.ResolutionHeight*0.2f)+i*35)+30,450,50,this);
                   g2D.drawString(GameData.dataPlayer.get(i).getNama(), (int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+i*35)+60);
               }
            }
        }
    }
    
    void mouseUpdateHover(MouseEvent event)
    {
        if (backRect.contains(event.getPoint()))
        {
            SoundManager.playSound("button");
            menuHovered = 1;
        }
        else
        {
            menuHovered = -1;
        }
        
        for (int i = 0 ; i<userRect.size();i++)
        {
            if (userRect.get(i).contains(event.getPoint()))
            {
                userHover[i] = true;
                break;
            }
            else
            {
                userHover[i] = false;
            }
        }
        
        newHover = (newRect.contains(event.getPoint()));
        delHover = (delRect.contains(event.getPoint()));
        
        if (status == 1)
        {
            cancelHover = (cancelRect.contains(event.getPoint()));
            enterHover = (enterRect.contains(event.getPoint()));
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
                        SoundManager.playSound("fbutton");
                    }
                }
            }
        
    }
    
    void mouseUpdateReleased(MouseEvent event)
    {
        try{
        if (menuPressed == 0)
        {
            SoundManager.playSound("button2");
            SceneManager.SwitchScene("MainMenuGUI");
        } 
        else if (menuPressed != -1) 
        {
            if (menuPressed == 555) {
               SoundManager.playSound("fbutton");
                /* menu create user */
            }
            else if (menuPressed == 777) {
                SoundManager.playSound("fbutton");
                /* menu delete user */
            } 
            else {
                if(status == 0) {
                GameData.lastLogin = GameData.dataPlayer.get(menuPressed-1);
                SoundManager.playSound("fbutton");
                SceneManager.SwitchScene("MainMenuGUI");
                }
                else if(status == 1) {
                    if (menuPressed == 444) {
                        SoundManager.playSound("fbutton");
                        status = 0;
                        GameData.addPlayer(userName);
                        userHover = new boolean[userHover.length+1];
                        for (boolean b : userHover)
                            b = false;
                        userName = "";
                        userRect.add(new Rectangle((int)(Game.ResolutionWidth*0.33f),(int)((Game.ResolutionHeight*0.2f)+(GameData.getJumlahPlayer()-1)*35+40),450,30));
                    } else if (menuPressed == 999) {
                        SoundManager.playSound("fbutton");
                        userName = "";
                        status = 0;
                    }
                }
                else if(status == 2) {
                    if(GameData.dataPlayer.get(menuPressed-1) != GameData.lastLogin) 
                    {
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
    
    void prosesInput(KeyEvent e) {
        if (status == 1) {
            SoundManager.playSound("button2");
            if (e.getKeyCode() == 8 && userName.length() != 0) {
                userName = userName.substring(0, userName.length()-1);
            } else if  ((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) ||(e.getKeyCode() >= 65 && e.getKeyCode() <= 90)){
                userName += KeyEvent.getKeyText(e.getKeyCode());
            } else if (e.getKeyCode() == 32) {
                userName += " ";
            }
        }
    }
    
}