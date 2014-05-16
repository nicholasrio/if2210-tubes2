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
public class OptionsMenuGUI extends Scene
{
    // attributes
    
    public OptionsMenuGUI()
    {
        super("OptionsMenuGUI");
    }
    
    public void LoadContent()
    {
        // load Image here
        // using ImageLoader.getImage
    }
    
    @Override
    public void Initialize()
    {
        gameFrame.getContentPane().removeAll();
        gameFrame.getContentPane().add(this);
    }
    
    @Override
    public void Update()
    {
        
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
            // paint Image here
            // using g2D.drawImage
        }
    }
}
