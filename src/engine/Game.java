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
    public static void main(String []args)
    {
        SceneManager.Initialize();
        SceneManager.AddScene(new MainMenu());
        SceneManager.AddScene(new LevelMenu());
        SceneManager.SwitchScene("MainMenu");
    }
}
