/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import static engine.Game.gameFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

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
    private Image exitTexture;
    
    private float transparentPercentage;
    
    public MainMenuGUI()
    {
        super("MainMenuGUI");
        
        transparentPercentage = 0f;
    }
    
    public void LoadContent()
    {
        bgTexture = ImageLoader.getImage("mainmenu_bg");
        titleTexture = ImageLoader.getImage("title");
        newgameTexture = ImageLoader.getImage("newgame");
        achievementTexture = ImageLoader.getImage("achievement");
        optionsTexture = ImageLoader.getImage("options");
        exitTexture = ImageLoader.getImage("exit");
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
        if (transparentPercentage < 1f)
        {
            transparentPercentage += 0.01f;
        }
        /*
        if (pos > 100)
        {
        SceneManager.SwitchScene("AchievementMenu");
         } */
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
            
            g2D.drawImage(newgameTexture,(int)(getWidth()*(-0.09f)),(int)(getHeight()*0.28f),newgameTexture.getWidth(this),newgameTexture.getHeight(this),this);
            g2D.drawImage(achievementTexture,(int)(getWidth()*(-0.11f)),(int)(getHeight()*0.45f),achievementTexture.getWidth(this),achievementTexture.getHeight(this),this);
            g2D.drawImage(optionsTexture,(int)(getWidth()*(-0.13f)),(int)(getHeight()*0.63f),optionsTexture.getWidth(this),optionsTexture.getHeight(this),this);
            g2D.drawImage(exitTexture,(int)(getWidth()*(-0.15f)),(int)(getHeight()*0.80f),exitTexture.getWidth(this),exitTexture.getHeight(this),this);       
        }
    }
}
