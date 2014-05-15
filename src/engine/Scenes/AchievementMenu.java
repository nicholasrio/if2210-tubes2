/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.Scenes;
import java.awt.Graphics;
import java.awt.Graphics2D;

import engine.*;
import static engine.Game.gameFrame;

/**
 *
 * @author Tony
 */
public class AchievementMenu extends Scene
{
    private static int pos = 0;
    
    public AchievementMenu()
    {
        super("AchievementMenu");
    }
    
    @Override
    public void Initialize()
    {
        if (Game.mode == 2)
        {
            gameFrame.getContentPane().removeAll();
            gameFrame.getContentPane().add(new AchievementMenu());
        }
    }
    
    @Override
    public void Update()
    {
       if (Game.mode == 2)
       {
           pos++;
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
            g2D.drawImage(ImageLoader.getImage("tes"),100, pos, this);
        }
    }
}
