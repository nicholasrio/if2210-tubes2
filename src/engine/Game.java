/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;
import engine.Scenes.*;

/**
 *
 * @author Tony
 */
public class Game 
{
    public static void main(String []args)
    {
        PrepareScenes();    
        RunGame();
    }
    
    public static void PrepareScenes()
    {
        SceneManager.Initialize();
        SceneManager.AddScene(new MainMenu());
        SceneManager.AddScene(new LevelMenu());
    }
    public static void RunGame()
    {
        SceneManager.SwitchScene("MainMenu");
        while (SceneManager.Play)
        {
            SceneManager.Draw();
            SceneManager.Update();
        }
    }
}
