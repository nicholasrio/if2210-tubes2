/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import engine.Scenes.*;

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
    
    private Game()
    {
        // Choice Mode
        mode = 2;
        
        if (mode == 2)
        {
            ImageLoader.loadAllImages();
            prepareFrame();
        }
        PrepareScenes();
        gameLoop();
        /*LevelMenu l=new LevelMenu();        
        l.Initialize();
        l.Draw();
        l.Update();
        l.Draw();*/
    }
    
    private static void prepareFrame()
    {
        gameFrame.setTitle("CubeMazer");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setSize(new Dimension(800,600));
        gameFrame.setResizable(true);
        gameFrame.setVisible(true);
    }
    
    private static void PrepareScenes()
    {
        SceneManager.Initialize();
        SceneManager.AddScene(new MainMenu());
        SceneManager.AddScene(new LevelMenu());
        SceneManager.AddScene(new GameMenu());
        SceneManager.AddScene(new AchievementMenu());
        SceneManager.SwitchScene("MainMenu"); 
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
    }
    
    public static void main(String []args)
    {
        Game CubeMazer = new Game();
    }
}
