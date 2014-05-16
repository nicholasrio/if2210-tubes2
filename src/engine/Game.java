/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import engine.DataStructure.GameData;
import engine.Scenes.*;
import engine.GUIScenes.*;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Tony
 */
public class Game 
{
    static public boolean gameRunning = true;
    static public int mode; // 1 for CLI, 2 for GUI
    static public JFrame gameFrame = new JFrame();
    static public Graphics g = gameFrame.getGraphics();
    static public final int ResolutionWidth = 800;
    static public final int ResolutionHeight = 600;
    
    private Game()
    {
        // Choice Mode
        mode = 2;
        
        GameData.loadMap();
        GameData.loadPlayer("player.xml");
        if (mode == 2)
        {
            ImageLoader.loadAllImages();
            prepareFrame();
        }
        
        PrepareScenes();
        gameLoop();
    }
    
    private static void prepareFrame()
    {
        gameFrame.setTitle("CubeMazer");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setSize(new Dimension(ResolutionWidth,ResolutionHeight));
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(true);
        gameFrame.setVisible(true);
    }
    
    private static void PrepareScenes()
    {
        SceneManager.Initialize();
        if (mode == 1)
        {
            SceneManager.AddScene(new MainMenu());
            SceneManager.AddScene(new LevelMenu());
            SceneManager.AddScene(new GameMenu());
            SceneManager.SwitchScene("LevelMenu"); 
        }
        else if (mode == 2)
        {
            SceneManager.AddScene(new MainMenuGUI());
            SceneManager.AddScene(new LevelMenuGUI());
            SceneManager.AddScene(new GameMenuGUI());
            SceneManager.AddScene(new AchievementMenuGUI());
            SceneManager.AddScene(new OptionsMenuGUI());
            SceneManager.AddScene(new AboutMenuGUI());
            SceneManager.SwitchScene("MainMenuGUI");
        }
    }
    
    private static void gameLoop()
    {
        while(gameRunning) 
        { 
            long time = System.currentTimeMillis(); 
            final int fps = 60;
            
            SceneManager.Draw(); 
            SceneManager.Update(); 
                
            time = (1000 / fps) - (System.currentTimeMillis() - time); 
            if (time > 0) 
            { 
                try 
                { 
                    Thread.sleep(time); 
                } 
                catch(Exception e){} 
            } 
        }   
        GameData.savePlayer("player.xml");
        System.exit(0);
    }
    
    public static void main(String []args)
    {
        Game CubeMazer = new Game();
    }
}
