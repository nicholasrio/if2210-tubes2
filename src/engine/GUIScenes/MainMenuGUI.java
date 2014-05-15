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
    private static int pos = 0;
    private static Image bgTexture;
    
    public MainMenuGUI()
    {
        super("MainMenuGUI");
    }
    
    public void LoadContent()
    {
        bgTexture = ImageLoader.getImage("mainmenu_bg");
    }
    
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(new MainMenuGUI());
        this.LoadContent();
    }
    
    @Override
    public void Update()
    {
        pos++;/*
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
        }
    }
}
