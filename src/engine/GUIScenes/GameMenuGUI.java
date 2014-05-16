/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.GUIScenes;

import engine.*;
import engine.DataStructure.*;
import static engine.Game.gameFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Tony
 */
public class GameMenuGUI extends Scene
{
    private int nowlevelPlay;
    private Map playedMap;
    private int mazeSize;
    
    public GameMenuGUI()
    {
        super("GameMenuGUI");
        
        //nowlevelPlay = GameData.nowLevelPlayed;
        nowlevelPlay = 0;
        playedMap = GameData.dataMap.get(nowlevelPlay);
        switch(nowlevelPlay)
        {
            case 0: mazeSize = 6; break;
        }
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
            
            for (int level=0;level<mazeSize;level++)
            {
                for (int bar=0;bar<mazeSize;bar++)
                {
                    for (int kol=0;kol<mazeSize;kol++)
                    {
                        Location loc = new Location(bar,kol,level);
                        if (playedMap.getElement(loc).getName().equalsIgnoreCase("road"))
                        {
                            //g2D.drawImage(, , );
                        }
                    }
                }
            }
        }
    }
}
