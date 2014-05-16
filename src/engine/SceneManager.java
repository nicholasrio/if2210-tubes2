/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.util.ArrayList;
import engine.Exception.SceneNotFoundException;

/**
 *
 * @author Tony
 */
public class SceneManager 
{
    // Attributes
    static private ArrayList<Scene> Scenes = new ArrayList<Scene>();
    static private boolean Started = false;
    static private Scene activeScene = null;
    
    // Methods
    static public void AddScene(Scene S)
    {
        for (Scene Scn : Scenes)
        {
            if (Scn.getSceneName().equalsIgnoreCase(S.getSceneName())) return;
        }
        Scenes.add(S);
    }
    
    static public void SwitchScene(String name) throws SceneNotFoundException
    {
        for (Scene Scn : Scenes)
        {
            if (Scn.getSceneName().equalsIgnoreCase(name))
            {
                activeScene = Scn;
                Scn.Initialize();
                return;
            }
        }
        throw new SceneNotFoundException();
    }
    
    static public void Initialize()
    {
        Started = true;
    }
    
    static public void Update()
    {
        if (!Started) return;
        if (activeScene != null)
            activeScene.Update();
    }
    
    static public void Draw()
    {
        if (!Started) return;
        if (activeScene != null)
            activeScene.Draw();
    }
    
    static public void ShutDown()
    {
        Game.gameRunning = false;
    }
}
