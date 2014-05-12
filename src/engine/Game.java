/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;
import engine.Scenes.*;
import engine.DataStructure.*;

/**
 *
 * @author Tony
 */
public class Game 
{
    static public boolean gameRunning = true;
    
    public static void main(String []args)
    {
        PrepareScenes();    
        gameLoop();
    }
    
    public static void PrepareScenes()
    {
        SceneManager.Initialize();
        SceneManager.AddScene(new MainMenu());
        SceneManager.AddScene(new LevelMenu());
        SceneManager.SwitchScene("MainMenu"); 
    }
    
    public static void gameLoop()
    {
        while(gameRunning) 
        { 
            long time = System.currentTimeMillis(); 
            final int fps = 60;
            SceneManager.Update(); 
            SceneManager.Draw(); 
                
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
}
